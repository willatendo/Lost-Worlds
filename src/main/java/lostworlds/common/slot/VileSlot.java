package lostworlds.common.slot;

import lostworlds.common.container.DNAExtractorContainer;
import lostworlds.core.init.ItemInit;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class VileSlot extends Slot
{
	private final DNAExtractorContainer menu;

	public VileSlot(DNAExtractorContainer container, IInventory inventory, int x, int z, int y) 
	{
		super(inventory, x, z, y);
		this.menu = container;
	}
	
	@Override
	public boolean mayPlace(ItemStack stack) 
	{
		return stack == ItemInit.EMPTY_VILE.get().getDefaultInstance() ? true : super.mayPlace(stack);
	}
	
	@Override
	public int getMaxStackSize(ItemStack stack) 
	{
		return super.getMaxStackSize(stack);
	}
}
