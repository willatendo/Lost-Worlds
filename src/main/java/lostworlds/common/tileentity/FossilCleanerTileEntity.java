package lostworlds.common.tileentity;

import javax.annotation.Nullable;

import lostworlds.common.container.FossilCleanerContianer;
import lostworlds.core.init.TileEntityInit;
import lostworlds.core.util.FossilCleanerItemHandler;
import lostworlds.core.util.reference.ModReference;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
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
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

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
