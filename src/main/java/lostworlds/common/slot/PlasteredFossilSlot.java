package lostworlds.common.slot;

import lostworlds.core.init.ItemInit;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class PlasteredFossilSlot extends Slot
{
	public PlasteredFossilSlot(IInventory inventory, int x, int z, int y) 
	{
		super(inventory, x, z, y);
	}
	
	@Override
	public boolean mayPlace(ItemStack stack) 
	{
		return isDNADisc(stack);
	}
	
	public boolean isDNADisc(ItemStack stack)
	{
		return stack.getItem() == ItemInit.PLASTERED_FOSSIL.get();
	}
}