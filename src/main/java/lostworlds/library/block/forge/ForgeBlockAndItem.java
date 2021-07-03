package lostworlds.library.block.forge;

import lostworlds.library.item.forge.ForgeBlockItem;
import lostworlds.library.util.ModRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

/*
 * Author: Willatendo
 * Date: July 1, 2021
 */

public class ForgeBlockAndItem
{
	public static Block create(String id, Block block)
	{
		Item item = new ForgeBlockItem(() -> block);
		ModRegistry.register(id, block);
		ModRegistry.register(id, item);
		return block;
	}
}
