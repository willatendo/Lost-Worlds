package lostworlds.common.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.NonNullSupplier;

public class ModWoodBurnableItem extends ModBlockItem
{
	public ModWoodBurnableItem(NonNullSupplier<? extends Block> blockSupplier, Properties properties) 
	{
		super(blockSupplier, properties);
	}

	@Override
	public int getBurnTime(ItemStack itemStack) 
	{
		return 300;
	}
}
