package lostworlds.common.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ModSlabBurnableItem extends ModWoodBurnableItem
{
	public ModSlabBurnableItem(Block blockIn, Properties properties) 
	{
		super(blockIn, properties);
	}
	
	@Override
	public int getBurnTime(ItemStack itemStack) 
	{
		return 150;
	}
}
