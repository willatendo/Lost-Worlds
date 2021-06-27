package library.containers.pottery;

import api.core.init.ContainerInit;
import library.blocks.pottery.BakedKylixBlock;
import library.tileentities.KylixTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IWorldPosCallable;

public class KylixContainer extends Container
{	
	private final IWorldPosCallable canInteractWithCallable;
	
	public KylixContainer(int windowID, PlayerInventory playerInv, KylixTileEntity tileEntity) 
	{
		super(ContainerInit.KYLIX_CONTAINER.get(), windowID);
		this.canInteractWithCallable = IWorldPosCallable.create(tileEntity.getLevel(), tileEntity.getBlockPos());
		
		this.addSlot(new Slot(tileEntity, 0, 80, 20));
		
		for(int i = 0; i < 3; ++i) 
		{
			for(int j = 0; j < 9; ++j) 
			{
				this.addSlot(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 51 + i * 18));
			}
		}
		
		for(int k = 0; k < 9; ++k) 
		{
			this.addSlot(new Slot(playerInv, k, 8 + k * 18, 109));
		}
	}
	
	public KylixContainer(int windowID, PlayerInventory playerInv, PacketBuffer data) 
	{
		this(windowID, playerInv, new KylixTileEntity());
 	}

	@Override
	public boolean stillValid(PlayerEntity playerIn) 
	{
		return this.canInteractWithCallable.evaluate((world, blockPos) -> world.getBlockState(blockPos).getBlock() instanceof BakedKylixBlock && playerIn.distanceToSqr((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D, (double) blockPos.getZ() + 0.5D) <= 64.0D, true);
	}
	
	@Override
	public ItemStack quickMoveStack(PlayerEntity player, int getslot) 
	{
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(getslot);
		if(slot != null && slot.hasItem()) 
		{
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if(getslot < 1) 
			{
				if(!this.moveItemStackTo(itemstack1, 1, this.slots.size(), true)) 
				{
					return ItemStack.EMPTY;
				}
			} 
			else if(!this.moveItemStackTo(itemstack1, 0, 1, false)) 
			{
				return ItemStack.EMPTY;
			}
			
			if(itemstack1.isEmpty()) 
			{
				slot.set(ItemStack.EMPTY);
			} 
			else 
			{
				slot.setChanged();
			}
		}
		
		return itemstack;
	}
}
