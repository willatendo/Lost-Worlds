package lostworlds.common.tileentity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import com.google.common.collect.Maps;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import lostworlds.common.blocks.FossilCleanerBlock;
import lostworlds.common.container.FossilCleanerContianer;
import lostworlds.common.recipe.FossilCleanerRecipe;
import lostworlds.core.init.RecipeSerialiserInit;
import lostworlds.core.init.TileEntityInit;
import lostworlds.core.util.FossilCleanerItemHandler;
import lostworlds.core.util.ModHooks;
import lostworlds.core.util.interfaces.IModRecipeType;
import lostworlds.core.util.reference.ModReference;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IRecipeHelperPopulator;
import net.minecraft.inventory.IRecipeHolder;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.RecipeItemHelper;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class FossilCleanerTileEntity extends TileEntity implements ISidedInventory,  IRecipeHolder, IRecipeHelperPopulator, ITickableTileEntity, INamedContainerProvider
{
	private static final int[] SLOTS_FOR_UP = new int[]{0};
	private static final int[] SLOTS_FOR_DOWN = new int[]{2, 1};
	private static final int[] SLOTS_FOR_SIDES = new int[]{1};
	private ITextComponent customName;
	private int cleanTime;
	public int currentCleaningTime;
	@SuppressWarnings("unused")
	private int cleaningDuration;
	@SuppressWarnings("unused")
	private int cleanTotalTime;
	@SuppressWarnings("unused")
	private int cleanProgress;
	protected NonNullList<ItemStack> items = NonNullList.withSize(3, ItemStack.EMPTY);
	private FossilCleanerItemHandler inventory;
	protected final IRecipeType<? extends FossilCleanerRecipe> recipeType;
	protected final IIntArray dataAccess = new IIntArray() {
		public int get(int integer) 
		{
			switch(integer) 
			{
				case 0:
					return FossilCleanerTileEntity.this.cleanTime;
				case 1:
					return FossilCleanerTileEntity.this.cleaningDuration;
				case 2:
					return FossilCleanerTileEntity.this.cleanProgress;
				case 3:
					return FossilCleanerTileEntity.this.cleanTotalTime;
				default:
					return 0;
			}
		}
	
		public void set(int integer1, int integer2) 
		{
			switch(integer1) 
			{
				case 0:
					FossilCleanerTileEntity.this.cleanTime = integer2;
					break;
				case 1:
					FossilCleanerTileEntity.this.cleaningDuration = integer2;
					break;
				case 2:
					FossilCleanerTileEntity.this.cleanProgress = integer2;
					break;
				case 3:
					FossilCleanerTileEntity.this.cleanTotalTime = integer2;
			}
		}

		public int getCount() 
		{
			return 4;
		}
	};

	public FossilCleanerTileEntity(TileEntityType<?> tileentity, IRecipeType<? extends FossilCleanerRecipe> recipe) 
	{
		super(tileentity);
		
		this.inventory = new FossilCleanerItemHandler(3);
		this.recipeType = recipe;
	}
	
	public FossilCleanerTileEntity() 
	{
		this(TileEntityInit.FOSSIL_CLEANER_TILE_ENTITY.get(), IModRecipeType.FOSSIL_CLEANING);
	}
	
	public static Map<Item, Integer> getFuel() 
	{
	      Map<Item, Integer> map = Maps.newLinkedHashMap();
	      add(map, Items.WATER_BUCKET, 20000);
	      return map;
	}

	private static void add(Map<Item, Integer> map, IItemProvider itemProvider, int integer) 
	{
		Item item = itemProvider.asItem();
		map.put(item, integer);
	}
	
	@Override
	public Container createMenu(final int windowID, final PlayerInventory playerInv, final PlayerEntity playerEntity) 
	{
		return new FossilCleanerContianer(windowID, playerInv, this);
	}

	public void setCustomName(ITextComponent name) 
	{
		this.customName = name;
	}

	public ITextComponent getName() 
	{
		return this.customName != null ? this.customName : this.getDefaultName();
	}

	private ITextComponent getDefaultName() 
	{
		return new TranslationTextComponent("container." + ModReference.ID + ".fossil_cleaner");
	}

	@Override
	public ITextComponent getDisplayName() 
	{
		return this.getName();
	}

	@Nullable
	public ITextComponent getCustomName() 
	{
		return this.customName;
	}
	
	private boolean isCleaning() 
	{
		return this.cleanTime > 0;
	}

	@Override
	public void tick() 
	{
		boolean flag = this.isCleaning();
		boolean flag1 = false;
		if(this.isCleaning()) 
		{
			--this.cleanTime;
		}
		
		if(!this.level.isClientSide) 
		{
			if(this.level.hasNeighborSignal(this.getBlockPos())) 
			{
				ItemStack itemstack = this.items.get(1);
				if(this.isCleaning() || !itemstack.isEmpty() && !this.items.get(0).isEmpty()) 
				{
					@SuppressWarnings("unchecked")
					IRecipe<?> irecipe = this.level.getRecipeManager().getRecipeFor((IModRecipeType<FossilCleanerRecipe>)this.recipeType, this, this.level).orElse(null);
					if(!this.isCleaning() && this.canUse(irecipe)) 
					{
						this.cleanTime = this.getBurnDuration(itemstack);
						this.cleaningDuration = this.cleanTime;
						if(this.isCleaning())
						{
							flag1 = true;
							if (itemstack.hasContainerItem())
								this.items.set(1, itemstack.getContainerItem());
							else if(!itemstack.isEmpty()) 
							{
								Item item = itemstack.getItem();
								itemstack.shrink(1);
								if (itemstack.isEmpty()) 
								{
									this.items.set(1, itemstack.getContainerItem());
								}
							}
						}
					}
					
					if (this.isCleaning() && this.canUse(irecipe)) 
					{
						++this.cleanProgress;
						if (this.cleanProgress == this.cleanTotalTime) 
						{
							this.cleanProgress = 0;
							this.cleanTotalTime = this.getTotalCleanTime();
							this.canUse(irecipe);
							flag1 = true;
						}
					} 
					else 
					{
						this.cleanProgress = 0;
					}
				} 
				else if(!this.isCleaning() && this.cleanProgress > 0) 
				{
					this.cleanProgress = MathHelper.clamp(this.cleanProgress - 2, 0, this.cleanTotalTime);
				}
				
				if(flag != this.isCleaning()) 
				{
					flag1 = true;
					this.level.setBlock(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(FossilCleanerBlock.CLEANING, Boolean.valueOf(this.isCleaning())), 3);
				}
			}
		}
		if (flag1) 
		{
			this.setChanged();
		}
	}
	
	protected boolean canUse(@Nullable IRecipe<?> recipe) 
	{
		if(!this.items.get(0).isEmpty() && recipe != null) 
		{
			ItemStack itemstack = recipe.getResultItem();
			if (itemstack.isEmpty()) 
			{
				return false;
			} 
			else 
			{
				ItemStack itemstack1 = this.items.get(2);
				if (itemstack1.isEmpty()) 
				{
					return true;
				} 
				else if (!itemstack1.sameItem(itemstack)) 
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
	
	@SuppressWarnings("unused")
	private void clean(@Nullable IRecipe<?> recipe) 
	{
		if(recipe != null && this.canUse(recipe)) 
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
			
			if(itemstack.getItem() == Blocks.WET_SPONGE.asItem() && !this.items.get(1).isEmpty() && this.items.get(1).getItem() == Items.BUCKET) 
			{
				this.items.set(1, new ItemStack(Items.WATER_BUCKET));
			}
			
			itemstack.shrink(1);
		}
	}
	
	protected int getBurnDuration(ItemStack stack) 
	{
		if(stack.isEmpty()) 
		{
			return 0;
		} 
		else 
		{
			return ModHooks.getFluidTime(stack);
		}
	}
		
	@SuppressWarnings("unchecked")
	protected int getTotalCleanTime() 
	{
		return this.level.getRecipeManager().getRecipeFor((IModRecipeType<FossilCleanerRecipe>)this.recipeType, this, this.level).map(FossilCleanerRecipe::getCleanTime).orElse(200);
	}
	
	private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();
	
	public void setRecipeUsed(@Nullable IRecipe<?> recipe) 
	{
		if(recipe != null) 
		{
			ResourceLocation resourcelocation = recipe.getId();
			this.recipesUsed.addTo(resourcelocation, 1);
		}
	}
	
	public static boolean isUseful(ItemStack stack) 
	{
		return ModHooks.getFluidTime(stack) > 0;
	}
	
	@Override
	public void deserializeNBT(CompoundNBT nbt) 
	{
		super.deserializeNBT(nbt);
		if(nbt.contains("CustomName", Constants.NBT.TAG_STRING))
		{
			this.customName = ITextComponent.Serializer.fromJson(nbt.getString("CustomName"));
		}
		
		NonNullList<ItemStack> inv = NonNullList.withSize(this.inventory.getSlots(), ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(nbt, inv);
		this.inventory.setNonNullList(inv);
		
		this.currentCleaningTime = nbt.getInt("CurrentCleaningTime");
	}
	
	@Override
	public CompoundNBT save(CompoundNBT nbt) 
	{
		super.save(nbt);
		if(this.customName != null)
		{
			nbt.putString("CustomName", ITextComponent.Serializer.toJson(this.customName));
		}
		
		ItemStackHelper.saveAllItems(nbt, this.inventory.toNonNullList());
		nbt.putInt("CurrentCleanTime", this.currentCleaningTime);
		
		return nbt;
	}
	
	public final IItemHandlerModifiable getInventory() 
		{
		return this.inventory;
	}

	@Nullable
	@Override
	public SUpdateTileEntityPacket getUpdatePacket() 
	{
		CompoundNBT nbt = new CompoundNBT();
		this.save(nbt);
		return new SUpdateTileEntityPacket(this.worldPosition, 0, nbt);
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) 
	{
		this.deserializeNBT(pkt.getTag());
	}

	@Override
	public CompoundNBT getUpdateTag() 
	{
		CompoundNBT nbt = new CompoundNBT();
		this.save(nbt);
		return nbt;
	}
	
	@Nullable
	private FossilCleanerRecipe getRecipe(ItemStack stack) 
	{
		if(stack == null) 
		{
			return null;
		}

		Set<IRecipe<?>> recipes = findRecipesByType(RecipeSerialiserInit.FOSSIL_CLEANER_RECIPE_TYPE, this.level);
		for(IRecipe<?> iRecipe : recipes) 
		{
			FossilCleanerRecipe recipe = (FossilCleanerRecipe) iRecipe;
			if (recipe.matches(new RecipeWrapper(this.inventory), this.level)) 
			{
				return recipe;
			}
		}

		return null;
	}
	
	public static Set<IRecipe<?>> findRecipesByType(IRecipeType<?> typeIn, World world) 
	{
		return world != null ? world.getRecipeManager().getRecipes().stream().filter(recipe -> recipe.getType() == typeIn).collect(Collectors.toSet()) : Collections.emptySet();
	}

	@SuppressWarnings("resource")
	@OnlyIn(Dist.CLIENT)
	public static Set<IRecipe<?>> findRecipesByType(IRecipeType<?> typeIn) 
	{
		ClientWorld world = Minecraft.getInstance().level;
		return world != null ? world.getRecipeManager().getRecipes().stream().filter(recipe -> recipe.getType() == typeIn).collect(Collectors.toSet()) : Collections.emptySet();
	}

	public static Set<ItemStack> getAllRecipeInputs(IRecipeType<?> typeIn, World worldIn) 
	{
		Set<ItemStack> inputs = new HashSet<ItemStack>();
		Set<IRecipe<?>> recipes = findRecipesByType(typeIn, worldIn);
		for(IRecipe<?> recipe : recipes) 
		{
			NonNullList<Ingredient> ingredients = recipe.getIngredients();
			ingredients.forEach(ingredient -> 
			{
				for(ItemStack stack : ingredient.getItems()) 
				{
					inputs.add(stack);
				}
			});
		}
		return inputs;
	}

	@Override
	public void handleUpdateTag(BlockState state, CompoundNBT tag) 
	{
		this.deserializeCaps(tag);
	}

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) 
	{
		return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.orEmpty(cap, LazyOptional.of(() -> this.inventory));
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
			if (!itemstack.isEmpty()) 
			{
				return false;
			}
		}
		
		return true;
	}

	@Override
	public ItemStack getItem(int integer) 
	{
		return this.items.get(integer);
	}

	@Override
	public ItemStack removeItem(int integer1, int integer2) 
	{
		return ItemStackHelper.removeItem(this.items, integer1, integer2);
	}

	@Override
	public ItemStack removeItemNoUpdate(int integer) 
	{
		return ItemStackHelper.takeItem(this.items, integer);
	}

	@Override
	public void setItem(int integer, ItemStack stack) 
	{
		ItemStack itemstack = this.items.get(integer);
		boolean flag = !stack.isEmpty() && stack.sameItem(itemstack) && ItemStack.tagMatches(stack, itemstack);
		this.items.set(integer, stack);
		if (stack.getCount() > this.getMaxStackSize()) 
		{
			stack.setCount(this.getMaxStackSize());
		}
		
		if (integer == 0 && !flag) 
		{
			this.cleanTotalTime = this.getTotalCleanTime();
			this.cleanProgress = 0;
			this.setChanged();
		}
	}

	@Override
	public boolean stillValid(PlayerEntity player) 
	{
		if (this.level.getBlockEntity(this.worldPosition) != this) 
		{
			return false;
		} 
		else 
		{
			return player.distanceToSqr((double)this.worldPosition.getX() + 0.5D, (double)this.worldPosition.getY() + 0.5D, (double)this.worldPosition.getZ() + 0.5D) <= 64.0D;
		}
	}
	
	public boolean canPlaceItem(int integer, ItemStack stack) 
	{
		if(integer == 2) 
		{
			return false;
		} 
		else if(integer != 1) 
		{
			return true;
		} 
		else 
		{
			ItemStack itemstack = this.items.get(1);
			return isUseful(stack) || stack.getItem() == Items.BUCKET && itemstack.getItem() != Items.BUCKET;
		}
	}

	@Override
	public void clearContent() 
	{
		this.items.clear();
	}

	@Override
	public int[] getSlotsForFace(Direction direction) 
	{	
		if (direction == Direction.DOWN) 
		{
			return SLOTS_FOR_DOWN;
		} 
		else 
		{
			return direction == Direction.UP ? SLOTS_FOR_UP : SLOTS_FOR_SIDES;
		}
	}

	@Override
	public boolean canPlaceItemThroughFace(int integer, ItemStack stack, Direction direction) 
	{
		return this.canPlaceItem(integer, stack);
	}

	@Override
	public boolean canTakeItemThroughFace(int integer, ItemStack stack, Direction direction) 
	{
		if (direction == Direction.DOWN && integer == 1) 
		{
			Item item = stack.getItem();
			if (item != Items.WATER_BUCKET && item != Items.BUCKET) 
			{
				return false;
			}
		}
		return true;
	}

	@Override
	public void fillStackedContents(RecipeItemHelper itemHelper) 
	{
		for(ItemStack itemstack : this.items) 
		{
			itemHelper.accountStack(itemstack);
		}
	}

	@Nullable
	@Override
	public IRecipe<?> getRecipeUsed() 
	{
		return null;
	}
}
