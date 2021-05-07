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
		this.replaceableBlocks = ImmutableSet.of(BlockInit.PERMIAN_SAND.get(), BlockInit.VOLCANIC_ROCK.get(), BlockInit.PERMIAN_STONE.get(), BlockInit.PERMIAN_COAL_ORE.get(), BlockInit.PERMIAN_DIAMOND_ORE.get(), BlockInit.PERMIAN_EMERALD_ORE.get(), BlockInit.PERMIAN_GOLD_ORE.get(), BlockInit.PERMIAN_IRON_ORE.get(), BlockInit.PERMIAN_LAPIS_ORE.get(), BlockInit.PERMIAN_REDSTONE_ORE.get(), BlockInit.JURASSIC_STONE.get(), BlockInit.JURASSIC_COBBLESTONE.get(), BlockInit.JURASSIC_COAL_ORE.get(), BlockInit.JURASSIC_COPPER_ORE.get(), BlockInit.JURASSIC_DIAMOND_ORE.get(), BlockInit.JURASSIC_EMERALD_ORE.get(), BlockInit.JURASSIC_GOLD_ORE.get(), BlockInit.JURASSIC_IRON_ORE.get(), BlockInit.JURASSIC_LAPIS_ORE.get(), BlockInit.JURASSIC_REDSTONE_ORE.get(), Blocks.DIRT, Blocks.BASALT);
	}
}
