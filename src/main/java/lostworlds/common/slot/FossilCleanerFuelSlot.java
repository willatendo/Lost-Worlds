package lostworlds.common.slot;

import lostworlds.common.container.FossilCleanerContainer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class FossilCleanerFuelSlot extends Slot
{
	private final FossilCleanerContainer menu;

	public FossilCleanerFuelSlot(FossilCleanerContainer container, IInventory inventory, int x, int z, int y) 
	{
		super(inventory, x, z, y);
		this.menu = container;
	}
	
	@Override
	public boolean mayPlace(ItemStack stack) 
	{
		return this.menu.isFuel(stack);
	}
	
	public int getMaxStackSize(ItemStack stack) 
	{
		return super.getMaxStackSize(stack);
	}
}
