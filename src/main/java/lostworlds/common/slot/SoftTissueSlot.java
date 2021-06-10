package lostworlds.common.slot;

import lostworlds.core.init.ItemInit;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class SoftTissueSlot extends Slot
{
	public SoftTissueSlot(IInventory inventory, int x, int z, int y) 
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
		return stack.getItem() == ItemInit.ALLOSAURUS_SOFT_TISSUE.get() || stack.getItem() == ItemInit.CARNOTAURUS_SOFT_TISSUE.get() || stack.getItem() == ItemInit.CHILESAURUS_SOFT_TISSUE.get() || stack.getItem() == ItemInit.CRYOLOPHOSAURUS_SOFT_TISSUE.get() || stack.getItem() == ItemInit.DIICTODON_SOFT_TISSUE.get() || stack.getItem() == ItemInit.DIMETRODON_SOFT_TISSUE.get() || stack.getItem() == ItemInit.EDAPHOSAURUS_SOFT_TISSUE.get() || stack.getItem() == ItemInit.FUKUIVENATOR_SOFT_TISSUE.get() || stack.getItem() == ItemInit.GIGANOTOSAURUS_SOFT_TISSUE.get() || stack.getItem() == ItemInit.GORGONOPS_SOFT_TISSUE.get() || stack.getItem() == ItemInit.GREAT_AUK_SOFT_TISSUE.get() || stack.getItem() == ItemInit.KENTROSAURUS_SOFT_TISSUE.get() || stack.getItem() == ItemInit.LIAONINGOSAURUS_SOFT_TISSUE.get() || stack.getItem() == ItemInit.NAUTILUS_SOFT_TISSUE.get() || stack.getItem() == ItemInit.OSTROMIA_SOFT_TISSUE.get() || stack.getItem() == ItemInit.OURANOSAURUS_SOFT_TISSUE.get() || stack.getItem() == ItemInit.PALAEONISCUM_SOFT_TISSUE.get() || stack.getItem() == ItemInit.PROCOMPSOGNATHUS_SOFT_TISSUE.get() || stack.getItem() == ItemInit.PROTOSUCHUS_SOFT_TISSUE.get() || stack.getItem() == ItemInit.PSITTACOSAURUS_SOFT_TISSUE.get() || stack.getItem() == ItemInit.RHINESUCHUS_SOFT_TISSUE.get() || stack.getItem() == ItemInit.SUCHOMIMUS_SOFT_TISSUE.get() || stack.getItem() == ItemInit.TETRACERATOPS_SOFT_TISSUE.get() || stack.getItem() == ItemInit.TYRANNOSAURUS_SOFT_TISSUE.get();
	}
}
