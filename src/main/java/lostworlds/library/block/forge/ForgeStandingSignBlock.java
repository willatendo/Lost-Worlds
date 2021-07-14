package lostworlds.library.block.forge;

import lostworlds.library.util.ModRegistry;
import net.minecraft.block.Block;

/*
 * Author: Willatendo
 * Date: July 12, 2021
 */

public class ForgeStandingSignBlock
{
	public static Block create(String id, Block block)
	{
		ModRegistry.register(id + "_sign", block);
		return block;
	}
}
