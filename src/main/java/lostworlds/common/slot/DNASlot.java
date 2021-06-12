package lostworlds.common.slot;

import lostworlds.core.init.ItemInit;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class DNASlot extends Slot
{
	public DNASlot(IInventory inventory, int x, int z, int y) 
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
		return stack.getItem() == ItemInit.ALLOSAURUS_DNA.get() || stack.getItem() == ItemInit.CARNOTAURUS_DNA.get() || stack.getItem() == ItemInit.CHILESAURUS_DNA.get() || stack.getItem() == ItemInit.CRYOLOPHOSAURUS_DNA.get() || stack.getItem() == ItemInit.DIICTODON_DNA.get() || stack.getItem() == ItemInit.DIMETRODON_DNA.get() || stack.getItem() == ItemInit.EDAPHOSAURUS_DNA.get() || stack.getItem() == ItemInit.FUKUIVENATOR_DNA.get() || stack.getItem() == ItemInit.GIGANOTOSAURUS_DNA.get() || stack.getItem() == ItemInit.GORGONOPS_DNA.get() || stack.getItem() == ItemInit.GREAT_AUK_DNA.get() || stack.getItem() == ItemInit.KENTROSAURUS_DNA.get() || stack.getItem() == ItemInit.LIAONINGOSAURUS_DNA.get() || stack.getItem() == ItemInit.NAUTILUS_DNA.get() || stack.getItem() == ItemInit.OSTROMIA_DNA.get() || stack.getItem() == ItemInit.OURANOSAURUS_DNA.get() || stack.getItem() == ItemInit.PALAEONISCUM_DNA.get() || stack.getItem() == ItemInit.PROCOMPSOGNATHUS_DNA.get() || stack.getItem() == ItemInit.PROTOSUCHUS_DNA.get() || stack.getItem() == ItemInit.PSITTACOSAURUS_DNA.get() || stack.getItem() == ItemInit.RHINESUCHUS_DNA.get() || stack.getItem() == ItemInit.SUCHOMIMUS_DNA.get() || stack.getItem() == ItemInit.TETRACERATOPS_DNA.get() || stack.getItem() == ItemInit.TYRANNOSAURUS_DNA.get();
	}
}
