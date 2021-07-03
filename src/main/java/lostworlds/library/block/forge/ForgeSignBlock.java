package lostworlds.library.block.forge;

import lostworlds.library.tab.ModItemGroup;
import lostworlds.library.util.ModRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.SignItem;

/*
 * Author: Willatendo
 * Date: July 1, 2021
 */

public class ForgeSignBlock
{
	public static Block create(String id, Block floor, Block wall)
	{
		Item item = new SignItem(new Properties().tab(ModItemGroup.BLOCKS), floor, wall);
		ModRegistry.register(id + "_sign", floor);
		ModRegistry.register(id + "_wall_sign", wall);
		ModRegistry.register(id + "_sign", item);
		return floor;
	}
}
