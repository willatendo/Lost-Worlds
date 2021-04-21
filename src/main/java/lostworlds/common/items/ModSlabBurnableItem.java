package lostworlds.common.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.NonNullSupplier;

public class ModSlabBurnableItem extends ModWoodBurnableItem
{
	public ModSlabBurnableItem(NonNullSupplier<? extends Block> blockSupplier, Properties properties) 
	{
		super(blockSupplier, properties);
	}

	@Override
	public int getBurnTime(ItemStack itemStack) 
	{
		return 150;
	}
}
