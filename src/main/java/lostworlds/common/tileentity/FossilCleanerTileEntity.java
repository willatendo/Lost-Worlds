package lostworlds.common.tileentity;

import java.util.Map;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.Maps;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import lostworlds.common.blocks.DNAInjectorBlock;
import lostworlds.common.container.FossilCleanerContainer;
import lostworlds.common.recipe.RecipeManager;
import lostworlds.core.init.ItemInit;
import lostworlds.core.init.TileEntityInit;
import lostworlds.core.util.ModUtil;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.RecipeItemHelper;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.INameable;
import net.minecraft.util.IntArray;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class FossilCleanerTileEntity extends TileEntity implements IInventory, INamedContainerProvider, INameable, ITickableTileEntity	
{
    protected NonNullList<ItemStack> items = NonNullList.withSize(3, ItemStack.EMPTY);
	
	private int onTime;
	private int onDuration;
	public int cleaningProgress;
	private int cleaningTotalTime;
	private int rawIndex = -1;

	private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();
	
	public static Map<Item, Integer> getFuel() 
	{
		Map<Item, Integer> map = Maps.newLinkedHashMap();
		add(map, Items.WATER_BUCKET, 3500);
		return map;
	}
	
	private static void add(Map<Item, Integer> map, IItemProvider itemProvider, int length) 
	{
		Item item = itemProvider.asItem();
		
		map.put(item, length);
	}

	private ITextComponent name;

	public FossilCleanerTileEntity() 
	{
		super(TileEntityInit.FOSSIL_CLEANER_TILE_ENTITY.get());
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
		this.onDuration = this.getCleanDuration();
		if(nbt.contains("CustomName", 8)) 
		{
			this.name = ITextComponent.Serializer.fromJson(nbt.getString("CustomName"));
		}
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
	
	public boolean isOn() 
	{
		return this.onTime > 0;
	}
	
	@Override
	public void tick() 
	{	
		if(this.isOn()) 
		{
			--this.onTime;
		}
		
		if(!this.level.isClientSide) 
		{
			if(this.level.hasNeighborSignal(this.getBlockPos()))
			{
				if(this.isOn() && this.canClean())
				{
					++this.cleaningProgress;
					if(this.cleaningProgress == 500) 
					{
						this.cleaningProgress = 0;
						this.cleanItem();
					}
				} 
				else 
				{
					this.cleaningProgress = 0;
				}
			}
			
			this.level.setBlock(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(DNAInjectorBlock.ON, Boolean.valueOf(this.isOn())), 3);
		}
	}
	
	private static boolean isCleanable(ItemStack stack) 
	{
		return stack.getItem() == ItemInit.PLASTERED_FOSSIL.get();
	}
	
	private boolean canClean() 
	{
		if(!this.items.get(0).isEmpty() && !this.items.get(1).isEmpty()) 
		{
			if(isCleanable(this.items.get(0)) && isFuel(this.items.get(1))) 
			{
				return true;
			}
		}
		return false;
	}
	
	public void cleanItem() 
	{
		if(this.canClean()) 
		{
			ItemStack input = this.items.get(rawIndex);
			ItemStack output = RecipeManager.getAnalyzerRecipeForItem(input).generateOutput(new Random());
			if(!output.isEmpty()) 
			{
				ItemStack stack = this.items.get(2);
				if(stack.isEmpty()) 
				{
					this.items.set(2, output);
				} 
				else 
				{
					if(stack.sameItem(this.items.get(2)) && stack.getCount() + output.getCount() < 64) 
					{
						stack.setCount(stack.getCount() + output.getCount());
					}
				}
			}
			input.shrink(1);
		}
	}
	
	protected int getCleanDuration() 
	{
		return 1000;
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
			this.cleaningTotalTime = this.getCleanDuration();
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
	public IRecipe<?> getRecipeUsed() 
	{
		return null;
	}
	
	public static boolean isFuel(ItemStack stack) 
	{
		return getFuel().containsKey(stack.getItem());
	}

	public void fillStackedContents(RecipeItemHelper helper) 
	{
		for(ItemStack itemstack : this.items) 
		{
			helper.accountStack(itemstack);
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
	public Container createMenu(int windowId, PlayerInventory playerInv, PlayerEntity player) 
	{
		return new FossilCleanerContainer(windowId, playerInv, this, this, new IntArray(4));
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
	
	@Override
	@Nullable
	public ITextComponent getCustomName() 
	{
		return this.name;
	}

	public void setCustomName(ITextComponent text) 
	{
		this.name = text;
	}
}
