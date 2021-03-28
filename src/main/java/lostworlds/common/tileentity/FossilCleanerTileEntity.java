package lostworlds.common.tileentity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import lostworlds.common.container.FossilCleanerContianer;
import lostworlds.common.recipe.FossilCleanerRecipe;
import lostworlds.core.init.RecipeSerialiserInit;
import lostworlds.core.init.TileEntityInit;
import lostworlds.core.util.FossilCleanerItemHandler;
import lostworlds.core.util.reference.ModReference;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
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

public class FossilCleanerTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider
{
	private ITextComponent customName;
	public int currentCleaningTime;
	public final int maxCleanTime = 500;
	private FossilCleanerItemHandler inventory;

	public FossilCleanerTileEntity(TileEntityType<?> tileentity) 
	{
		super(tileentity);
		
		this.inventory = new FossilCleanerItemHandler(3);
	}
	
	public FossilCleanerTileEntity() 
	{
		this(TileEntityInit.FOSSIL_CLEANER_TILE_ENTITY.get());
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

	@Override
	public void tick() 
	{
		
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
}
