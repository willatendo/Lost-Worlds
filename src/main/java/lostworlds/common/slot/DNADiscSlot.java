package lostworlds.common.slot;

import lostworlds.core.init.ItemInit;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class DNADiscSlot extends Slot
{
	public DNADiscSlot(IInventory inventory, int x, int z, int y) 
	{
		super(inventory, x, z, y);
	}
	
	@Override
	public boolean mayPlace(ItemStack stack) 
	{
		return isSoftTissue(stack);
	}
	
	public boolean isSoftTissue(ItemStack stack)
	{
		return stack.getItem() == ItemInit.STORAGE_DISC.get();
	}
}
