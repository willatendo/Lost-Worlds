package lostworlds.world.gen;

import lostworlds.core.init.BlockInit;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class OreGen 
{
	public static void generateOres(final BiomeLoadingEvent event)
	{
		if(!(event.getCategory().equals(Biome.Category.NETHER) || event.getCategory().equals(Biome.Category.THEEND)))
		{
			oreGenerationConfig(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BlockInit.COPPER_ORE.get().getDefaultState(), 14, 5, 63, 20);
			oreGenerationConfig(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BlockInit.STONE_FOSSIL.get().getDefaultState(), 1, 30, 50, 20);
		}
	}
	
	public static void oreGenerationConfig(BiomeGenerationSettingsBuilder settings, RuleTest blockGenerationIn, BlockState block, int veinSize, int minHeight, int maxHeight, int amountGeneratedPerChunk)
	{
		settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(blockGenerationIn, block, veinSize)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight, 0, maxHeight))).square().func_242731_b(amountGeneratedPerChunk));
	}
}
