package lostworlds.core.vanilla.properties;

import lostworlds.core.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;

public class ModFlammables 
{
	public static void flammableBlock(Block block, int encouragement, int flammability) 
	{
		FireBlock fire = (FireBlock) Blocks.FIRE;
		fire.setFlammable(block, encouragement, flammability);
	}
	
	public static void flammables() 
	{
		flammableBlock(BlockInit.ACACIA_ARCHAEOLOGY_TABLE.get(), 5, 5);
		flammableBlock(BlockInit.BIRCH_ARCHAEOLOGY_TABLE.get(), 5, 5);
		flammableBlock(BlockInit.CONIFER_ARCHAEOLOGY_TABLE.get(), 5, 5);
		flammableBlock(BlockInit.DARK_OAK_ARCHAEOLOGY_TABLE.get(), 5, 5);
		flammableBlock(BlockInit.JUNGLE_ARCHAEOLOGY_TABLE.get(), 5, 5);
		flammableBlock(BlockInit.OAK_ARCHAEOLOGY_TABLE.get(), 5, 5);
		flammableBlock(BlockInit.SPRUCE_ARCHAEOLOGY_TABLE.get(), 5, 5);
		flammableBlock(BlockInit.STRIPPED_ACACIA_ARCHAEOLOGY_TABLE.get(), 5, 5);
		flammableBlock(BlockInit.STRIPPED_BIRCH_ARCHAEOLOGY_TABLE.get(), 5, 5);
		flammableBlock(BlockInit.STRIPPED_CONIFER_ARCHAEOLOGY_TABLE.get(), 5, 5);
		flammableBlock(BlockInit.STRIPPED_DARK_OAK_ARCHAEOLOGY_TABLE.get(), 5, 5);
		flammableBlock(BlockInit.STRIPPED_JUNGLE_ARCHAEOLOGY_TABLE.get(), 5, 5);
		flammableBlock(BlockInit.STRIPPED_OAK_ARCHAEOLOGY_TABLE.get(), 5, 5);
		flammableBlock(BlockInit.STRIPPED_SPRUCE_ARCHAEOLOGY_TABLE.get(), 5, 5);
		
		flammableBlock(BlockInit.CONIFER_BUTTON.get(), 5, 5);
		flammableBlock(BlockInit.CONIFER_DOOR.get(), 5, 5);
		flammableBlock(BlockInit.CONIFER_FENCE.get(), 5, 5);
		flammableBlock(BlockInit.CONIFER_FENCE_GATE.get(), 5, 5);
		flammableBlock(BlockInit.CONIFER_LEAVES.get(), 5, 5);
		flammableBlock(BlockInit.CONIFER_LOG.get(), 5, 5);
		flammableBlock(BlockInit.CONIFER_PLANKS.get(), 5, 5);
		flammableBlock(BlockInit.CONIFER_PRESSURE_PLATE.get(), 5, 5);
		flammableBlock(BlockInit.CONIFER_SIGN.get(), 5, 5);
		flammableBlock(BlockInit.CONIFER_SLAB.get(), 5, 5);
		flammableBlock(BlockInit.CONIFER_STAIRS.get(), 5, 5);
		flammableBlock(BlockInit.CONIFER_TRAPDOOR.get(), 5, 5);
		flammableBlock(BlockInit.CONIFER_WALL_SIGN.get(), 5, 5);
		flammableBlock(BlockInit.CONIFER_WOOD.get(), 5, 5);
		flammableBlock(BlockInit.STRIPPED_CONIFER_LOG.get(), 5, 5);
		flammableBlock(BlockInit.STRIPPED_CONIFER_WOOD.get(), 5, 5);
	}
}
