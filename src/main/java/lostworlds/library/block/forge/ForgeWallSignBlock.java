package lostworlds.library.block.forge;

import lostworlds.library.util.ModRegistry;
import net.minecraft.block.Block;

/*
 * Author: Willatendo
 * Date: July 12, 2021
 */

public class ForgeWallSignBlock
{
	public static Block create(String id, Block block)
	{
		ModRegistry.register(id + "_wall_sign", block);
		return block;
	}
}
