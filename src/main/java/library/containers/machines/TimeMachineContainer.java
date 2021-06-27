package library.containers.machines;

import api.core.init.ContainerInit;
import api.core.init.ItemInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IWorldPosCallable;

public class TimeMachineContainer extends Container
{
	private final IInventory bookAndGemSlots = new Inventory(2) { };
	
	@SuppressWarnings("unused")
	private final IWorldPosCallable access;

	public TimeMachineContainer(int windowId, PlayerInventory playerInv, PacketBuffer buffer) 
	{
		this(windowId, playerInv, IWorldPosCallable.NULL);
	}
	
	public TimeMachineContainer(int windowId, PlayerInventory playerInv, IWorldPosCallable worldPos) 
	{
		super(ContainerInit.TIME_MACHINE_CONTAINER.get(), windowId);
		this.access = worldPos;
		this.addSlot(new Slot(this.bookAndGemSlots, 0, 15, 47)
		{
			@Override
			public boolean mayPlace(ItemStack stack) 
			{
				if(stack == Items.BOOK.getDefaultInstance())
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			
			@Override
			public int getMaxStackSize() 
			{
				return 1;
			}
		});
		this.addSlot(new Slot(this.bookAndGemSlots, 1, 35, 47)
		{
			@Override
			public boolean mayPlace(ItemStack stack) 
			{
				if(stack == ItemInit.CRYSTAL_SCARAB_GEM.get().getDefaultInstance())
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			
			@Override
			public int getMaxStackSize() 
			{
				return 64;
			}
		});
	}

	@Override
	public boolean stillValid(PlayerEntity p_75145_1_) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
