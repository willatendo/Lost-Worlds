package lostworlds.common.container;

import java.util.Objects;

import lostworlds.common.tileentity.FossilCleanerTileEntity;
import lostworlds.core.init.BlockInit;
import lostworlds.core.init.ContainerInit;
import lostworlds.core.util.FunctionalIntReferenceHolder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.items.SlotItemHandler;

public class FossilCleanerContianer extends Container
{
	public FossilCleanerTileEntity tileEntity;
	private IWorldPosCallable canInteractWithCallable;
	public FunctionalIntReferenceHolder currentCleanTime;

	// Server Constructor
	public FossilCleanerContianer(final int windowID, final PlayerInventory playerInv, final FossilCleanerTileEntity tile) 
	{
		super(ContainerInit.FOSSIL_CLEANER_CONTAINER.get(), windowID);
		
		this.tileEntity = tile;
		this.canInteractWithCallable = IWorldPosCallable.create(tile.getLevel(), tile.getBlockPos());
		
		final int slotSizePlus2 = 18;
		final int startX = 8;
		
		// Hotbar
		int hotbarY = 142;
		for (int column = 0; column < 9; column++) 
		{
			this.addSlot(new Slot(playerInv, column, startX + (column * slotSizePlus2), hotbarY));
		}

		// Main Player Inventory
		final int startY = 84;

		for (int row = 0; row < 3; row++) 
		{
			for (int column = 0; column < 9; column++) 
			{
				this.addSlot(new Slot(playerInv, 9 + (row * 9) + column, startX + (column * slotSizePlus2), startY + (row * slotSizePlus2)));
			}
		}

		// Furnace Slots
		this.addSlot(new SlotItemHandler(tile.getInventory(), 0, 8, 35));
		this.addSlot(new SlotItemHandler(tile.getInventory(), 1, 52, 35));
		this.addSlot(new SlotItemHandler(tile.getInventory(), 2, 116, 35));

		this.addDataSlot(currentCleanTime = new FunctionalIntReferenceHolder(() -> this.tileEntity.currentCleaningTime, value -> this.tileEntity.currentCleaningTime = value));
	}
	
	public FossilCleanerContianer(final int windowID, final PlayerInventory playerInv, final PacketBuffer data) 
	{
		this(windowID, playerInv, getTileEntity(playerInv, data));
	}

	private static FossilCleanerTileEntity getTileEntity(final PlayerInventory playerInv, final PacketBuffer data) 
	{
		Objects.requireNonNull(playerInv, "playerInv cannot be null");
		Objects.requireNonNull(data, "data cannot be null");
		final TileEntity tileAtPos = playerInv.player.level.getBlockEntity(data.readBlockPos());
		if(tileAtPos instanceof FossilCleanerTileEntity) 
		{
			return (FossilCleanerTileEntity) tileAtPos;
		}
		throw new IllegalStateException("TileEntity is not correct " + tileAtPos);
	}
	
	@Override
	public boolean stillValid(PlayerEntity playerIn) 
	{
		return stillValid(canInteractWithCallable, playerIn, BlockInit.FOSSIL_CLEANER.get());
	}

	@Override
	public ItemStack quickMoveStack(final PlayerEntity player, final int index) 
	{
		ItemStack returnStack = ItemStack.EMPTY;
		final Slot slot = this.slots.get(index);
		if(slot != null && slot.hasItem()) 
		{
			final ItemStack slotStack = slot.getItem();
			returnStack = slotStack.copy();

			final int containerSlots = this.slots.size() - player.inventory.items.size();
			if(index < containerSlots) 
			{
				if(!moveItemStackTo(slotStack, containerSlots, this.slots.size(), true)) 
				{
					return ItemStack.EMPTY;
				}
			} 
			else if(!moveItemStackTo(slotStack, 0, containerSlots, false)) 
			{
				return ItemStack.EMPTY;
			}
			if (slotStack.getCount() == 0) 
			{
				slot.mayPlace(ItemStack.EMPTY);
			} 
			else 
			{
				slot.setChanged();
			}
			if(slotStack.getCount() == returnStack.getCount()) 
			{
				return ItemStack.EMPTY;
			}
			slot.onTake(player, slotStack);
		}
		return returnStack;
	}

	@OnlyIn(Dist.CLIENT)
	public int getCleanProgressionScaled() 
	{
		return this.currentCleanTime.get() != 0 && this.tileEntity.maxCleanTime != 0 ? this.currentCleanTime.get() * 24 / this.tileEntity.maxCleanTime : 0;
	}

	
}
