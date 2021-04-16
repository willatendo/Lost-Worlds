package lostworlds.common.items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class ModWoodBurnableItem extends BlockItem
{
	public ModWoodBurnableItem(Block blockIn, Properties properties) 
	{
		super(blockIn, properties);
	}
	
	@Override
	public int getBurnTime(ItemStack itemStack) 
	{
		return 300;
	}
}
