package lostworlds.world.dimension;

import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;

import lostworlds.core.init.BlockInit;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.carver.CaveWorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class VolcanoCaveWorldCarver extends CaveWorldCarver
{
	public VolcanoCaveWorldCarver(Codec<ProbabilityConfig> config, int height) 
	{
		super(config, height);
		this.replaceableBlocks = ImmutableSet.of(BlockInit.VOLCANIC_ASH.get(), BlockInit.VOLCANIC_ROCK.get(), Blocks.STONE, Blocks.DIRT, Blocks.GRAVEL, Blocks.ANDESITE, Blocks.GRANITE, Blocks.DIORITE, Blocks.COAL_ORE, Blocks.DIAMOND_ORE, Blocks.EMERALD_ORE, Blocks.GOLD_ORE, Blocks.IRON_ORE, Blocks.LAPIS_ORE, Blocks.REDSTONE_ORE);
	}
}
