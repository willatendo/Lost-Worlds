package lostworlds.world.dimension;

import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;

import lostworlds.core.init.BlockInit;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.carver.CanyonWorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class ModCanyonWorldCarver extends CanyonWorldCarver
{
	public ModCanyonWorldCarver(Codec<ProbabilityConfig> config) 
	{	
		super(config);
		replaceableBlocks = ImmutableSet.of(BlockInit.PERMIAN_SAND.get(), BlockInit.PERMIAN_STONE.get(), Blocks.DIRT);
	}
}
