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
		
		flammableBlock(BlockInit.GINKGO_BUTTON.get(), 5, 5);
		flammableBlock(BlockInit.GINKGO_DOOR.get(), 5, 5);
		flammableBlock(BlockInit.GINKGO_FENCE.get(), 5, 5);
		flammableBlock(BlockInit.GINKGO_FENCE_GATE.get(), 5, 5);
		flammableBlock(BlockInit.GINKGO_LEAVES.get(), 5, 5);
		flammableBlock(BlockInit.GINKGO_LOG.get(), 5, 5);
		flammableBlock(BlockInit.GINKGO_PLANKS.get(), 5, 5);
		flammableBlock(BlockInit.GINKGO_PRESSURE_PLATE.get(), 5, 5);
		flammableBlock(BlockInit.GINKGO_SIGN.get(), 5, 5);
		flammableBlock(BlockInit.GINKGO_SLAB.get(), 5, 5);
		flammableBlock(BlockInit.GINKGO_STAIRS.get(), 5, 5);
		flammableBlock(BlockInit.GINKGO_TRAPDOOR.get(), 5, 5);
		flammableBlock(BlockInit.GINKGO_WALL_SIGN.get(), 5, 5);
		flammableBlock(BlockInit.GINKGO_WOOD.get(), 5, 5);
		flammableBlock(BlockInit.STRIPPED_GINKGO_LOG.get(), 5, 5);
		flammableBlock(BlockInit.STRIPPED_GINKGO_WOOD.get(), 5, 5);
	}
}
