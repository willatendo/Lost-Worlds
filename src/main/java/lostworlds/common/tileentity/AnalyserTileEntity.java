package lostworlds.common.tileentity;

import javax.annotation.Nullable;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import lostworlds.common.blocks.FossilCleanerBlock;
import lostworlds.common.container.FossilCleanerContainer;
import lostworlds.core.init.TileEntityInit;
import lostworlds.core.util.ModUtil;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.FurnaceRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeItemHelper;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.INameable;
import net.minecraft.util.IntArray;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;

public class AnalyserTileEntity extends TileEntity implements IInventory, INamedContainerProvider, INameable, ITickableTileEntity	
{
	protected NonNullList<ItemStack> items = NonNullList.withSize(3, ItemStack.EMPTY);
	
	private int onTime;
	@SuppressWarnings("unused")
	private int onDuration;
	private int cleaningProgress;
	private int cleaningTotalTime;

	private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();
	protected final IRecipeType<?> recipeType = IRecipeType.SMELTING;
	
	public AnalyserTileEntity() 
	{
		super(TileEntityInit.FOSSIL_CLEANER_TILE_ENTITY.get());
	}
	
	private boolean isOn() 
	{
		return this.onTime > 0;
	}
	
	@Override
	public void load(BlockState state, CompoundNBT nbt) 
	{
		super.load(state, nbt);
		this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(nbt, this.items);
		this.onTime = nbt.getInt("OnTime");
		this.cleaningProgress = nbt.getInt("CleanTime");
		this.cleaningTotalTime = nbt.getInt("CleanTimeTotal");
		this.onDuration = this.getCleanDuration(this.items.get(1));
	}
	
	@Override
	public CompoundNBT save(CompoundNBT nbt) 
	{
		super.save(nbt);
		nbt.putInt("OnTime", this.onTime);
		nbt.putInt("CleanTime", this.cleaningProgress);
		nbt.putInt("CleanTimeTotal", this.cleaningTotalTime);
		ItemStackHelper.saveAllItems(nbt, this.items);
		return nbt;
	}
	
	@Override
	public void tick() 
	{
		boolean flag = this.isOn();
		boolean flag1 = false;
		if(this.isOn()) 
		{
			--this.onTime;
		}
		
		if(!this.level.isClientSide) 
		{
			ItemStack itemstack = this.items.get(1);
			if(this.isOn() || !itemstack.isEmpty() && !this.items.get(0).isEmpty()) 
			{
				@SuppressWarnings("unchecked")
				IRecipe<?> irecipe = this.level.getRecipeManager().getRecipeFor((IRecipeType<FurnaceRecipe>)this.recipeType, this, this.level).orElse(null);
				if(!this.isOn() && this.canCleanWith(irecipe)) 
				{
					this.onTime = this.getCleanDuration(itemstack);
					this.onDuration = this.onTime;
					if(this.isOn()) 
					{
						flag1 = true;
						if(itemstack.hasContainerItem())
							this.items.set(1, itemstack.getContainerItem());
						else
							if(!itemstack.isEmpty()) 
							{
								itemstack.shrink(1);
								if(itemstack.isEmpty()) 
								{
									this.items.set(1, itemstack.getContainerItem());
								}
							}
					}
				}
				
				if(this.isOn() && this.canCleanWith(irecipe)) 
				{
					++this.cleaningProgress;
					if(this.cleaningProgress == this.cleaningTotalTime) 
					{
						this.cleaningProgress = 0;
						this.cleaningTotalTime = this.getTotalCleanTime();
						this.cleanWith(irecipe);
						flag1 = true;
					}
				} 
				else 
				{
					this.cleaningProgress = 0;
				}
			} 
			else if(!this.isOn() && this.cleaningProgress > 0) 
			{
				this.cleaningProgress = MathHelper.clamp(this.cleaningProgress - 2, 0, this.cleaningTotalTime);
			}
			
			if(flag != this.isOn()) 
			{
				flag1 = true;
				this.level.setBlock(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(FossilCleanerBlock.ON, Boolean.valueOf(this.isOn())), 3);
			}
		}
		
		if(flag1) 
		{
			this.setChanged();
		}
	}
	
	protected boolean canCleanWith(@Nullable IRecipe<?> recipe) 
	{
		if(!this.items.get(0).isEmpty() && recipe != null) 
		{
			ItemStack itemstack = recipe.getResultItem();
			if(itemstack.isEmpty()) 
			{
				return false;
			} 
			else 
			{
				ItemStack itemstack1 = this.items.get(2);
				if(itemstack1.isEmpty()) 
				{
					return true;
				} 
				else if(!itemstack1.sameItem(itemstack)) 
				{	               
					return false;
				}
				else if (itemstack1.getCount() + itemstack.getCount() <= this.getMaxStackSize() && itemstack1.getCount() + itemstack.getCount() <= itemstack1.getMaxStackSize()) 
				{
					return true;
				} 
				else 
				{
					return itemstack1.getCount() + itemstack.getCount() <= itemstack.getMaxStackSize();
				}
			}
		} 
		else 
		{
			return false;
		}
	}
	
	private void cleanWith(@Nullable IRecipe<?> recipe) 
	{
		if(recipe != null && this.canCleanWith(recipe)) 
		{
			ItemStack itemstack = this.items.get(0);
			ItemStack itemstack1 = recipe.getResultItem();
			ItemStack itemstack2 = this.items.get(2);
			if(itemstack2.isEmpty()) 
			{
				this.items.set(2, itemstack1.copy());
			} 
			else if(itemstack2.getItem() == itemstack1.getItem()) 
			{
				itemstack2.grow(itemstack1.getCount());
			}
			
			if(!this.level.isClientSide) 
			{
				this.setRecipeUsed(recipe);
			}
			itemstack.shrink(1);
		}
	}
	
	protected int getCleanDuration(ItemStack stack) 
	{
		if(stack.isEmpty()) 
		{
			return 0;
		} 
		else 
		{
			return 2200;
		}
	}
	
	@SuppressWarnings("unchecked")
	protected int getTotalCleanTime() 
	{
		return this.level.getRecipeManager().getRecipeFor((IRecipeType<FurnaceRecipe>)this.recipeType, this, this.level).map(FurnaceRecipe::getCookingTime).orElse(2200);
	}
	
	public static boolean isFuel(ItemStack stack) 
	{
		if(stack == Items.WATER_BUCKET.getDefaultInstance())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public int getContainerSize() 
	{
		return this.items.size();
	}
	
	@Override
	public boolean isEmpty() 
	{
		for(ItemStack itemstack : this.items) 
		{
			if(!itemstack.isEmpty()) 
			{
				return false;
			}
		}
		
		return true;
	}
	
	@Override
	public ItemStack getItem(int i) 
	{
		return this.items.get(i);
	}
	
	@Override
	public ItemStack removeItem(int i1, int i2) 
	{
		return ItemStackHelper.removeItem(this.items, i1, i2);
	}
	
	@Override
	public ItemStack removeItemNoUpdate(int i) 
	{
		return ItemStackHelper.takeItem(this.items, i);
	}
	
	@Override
	public void setItem(int i, ItemStack stack) 
	{
		ItemStack itemstack = this.items.get(i);
		boolean flag = !stack.isEmpty() && stack.sameItem(itemstack) && ItemStack.tagMatches(stack, itemstack);
		this.items.set(i, stack);
		if(stack.getCount() > this.getMaxStackSize()) 
		{
			stack.setCount(this.getMaxStackSize());
		}
		
		if (i == 0 && !flag) 
		{
			this.cleaningTotalTime = this.getTotalCleanTime();
			this.cleaningProgress = 0;
			this.setChanged();
		}
	}
	
	@Override
	public boolean stillValid(PlayerEntity player) 
	{
		if(this.level.getBlockEntity(this.worldPosition) != this) 
		{
			return false;
		} 
		else 
		{
			return player.distanceToSqr((double)this.worldPosition.getX() + 0.5D, (double)this.worldPosition.getY() + 0.5D, (double)this.worldPosition.getZ() + 0.5D) <= 64.0D;
		}
	}
	
	@Override
	public boolean canPlaceItem(int i, ItemStack stack) 
	{
		if(i == 2) 
		{
			return false;
		} 
		else if(i != 1) 
		{
			return true;
		} 
		else 
		{
			return isFuel(stack);
		}
	}
	
	@Override
	public void clearContent() 
	{
		this.items.clear();
	}
	
	public void setRecipeUsed(@Nullable IRecipe<?> recipe) 
	{
		if(recipe != null) 
		{
			ResourceLocation resourcelocation = recipe.getId();
			this.recipesUsed.addTo(resourcelocation, 1);
		}
	}
	
	@Nullable
	public IRecipe<?> getRecipeUsed() {
	      return null;
	   }

	public void fillStackedContents(RecipeItemHelper helper) 
	{
		for(ItemStack itemstack : this.items) 
		{
			helper.accountStack(itemstack);
		}
	}

	@Override
	public Container createMenu(int windowId, PlayerInventory playerInv, PlayerEntity player) 
	{
		return new FossilCleanerContainer(windowId, playerInv, this, new IntArray(4));
	}

	@Override
	public ITextComponent getName() 
	{
		return ModUtil.tTC("container.fossil_cleaner");
	}

	@Override
	public ITextComponent getDisplayName() 
	{
		return this.getName();
	}
}
