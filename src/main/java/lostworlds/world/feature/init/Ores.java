package lostworlds.world.feature.init;

import lostworlds.core.init.BlockInit;
import lostworlds.core.util.ModBlockStates;
import lostworlds.world.feature.ModFillerBlockType;
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

public class Ores 
{
	public static void generateOre(BiomeLoadingEvent event)
	{
		if(!(event.getCategory().equals(Biome.Category.NETHER) || event.getCategory().equals(Biome.Category.THEEND)))
		{
			//Ores
			oreGenerationConfig(event.getGeneration(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlockStates.COPPER_ORE, 9, 5, 83, 25);
			
			//Mud
			if(event.getCategory().equals(Biome.Category.SWAMP))
			{
				oreGenerationConfig(event.getGeneration(), ModFillerBlockType.GRASS, BlockInit.MUD.get().defaultBlockState(), 3, 5, 128, 25);
				oreGenerationConfig(event.getGeneration(), ModFillerBlockType.DIRT, BlockInit.MUD.get().defaultBlockState(), 3, 5, 128, 25);
			}
			
			//Fossil
			event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.NO_SURFACE_ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.STONE_FOSSIL.get().defaultBlockState(), 1)).decorated(Placement.RANGE.configured(new TopSolidRangeConfig(30, 1, 100)).squared().count(50)));				
			if(event.getCategory().equals(Biome.Category.DESERT))
			{
				event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.NO_SURFACE_ORE.configured(new OreFeatureConfig(ModFillerBlockType.SANDSTONE, BlockInit.SANDSTONE_FOSSIL.get().defaultBlockState(), 1)).decorated(Placement.RANGE.configured(new TopSolidRangeConfig(30, 1, 100)).squared().count(50)));				
			}
			if(event.getCategory().equals(Biome.Category.MESA))
			{
				event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.NO_SURFACE_ORE.configured(new OreFeatureConfig(ModFillerBlockType.TERRACOTTA, BlockInit.TERRACOTTA_FOSSIL.get().defaultBlockState(), 1)).decorated(Placement.RANGE.configured(new TopSolidRangeConfig(30, 1, 100)).squared().count(10)));				
				event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.NO_SURFACE_ORE.configured(new OreFeatureConfig(ModFillerBlockType.WHITE_TERRACOTTA, BlockInit.WHITE_TERRACOTTA_FOSSIL.get().defaultBlockState(), 1)).decorated(Placement.RANGE.configured(new TopSolidRangeConfig(30, 1, 100)).squared().count(10)));				
				event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.NO_SURFACE_ORE.configured(new OreFeatureConfig(ModFillerBlockType.LIGHT_GREY_TERRACOTTA, BlockInit.LIGHT_GREY_TERRACOTTA_FOSSIL.get().defaultBlockState(), 1)).decorated(Placement.RANGE.configured(new TopSolidRangeConfig(30, 1, 100)).squared().count(10)));				
				event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.NO_SURFACE_ORE.configured(new OreFeatureConfig(ModFillerBlockType.BLACK_TERRACOTTA, BlockInit.BLACK_TERRACOTTA_FOSSIL.get().defaultBlockState(), 1)).decorated(Placement.RANGE.configured(new TopSolidRangeConfig(30, 1, 100)).squared().count(10)));				
				event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.NO_SURFACE_ORE.configured(new OreFeatureConfig(ModFillerBlockType.RED_TERRACOTTA, BlockInit.RED_TERRACOTTA_FOSSIL.get().defaultBlockState(), 1)).decorated(Placement.RANGE.configured(new TopSolidRangeConfig(30, 1, 100)).squared().count(10)));				
				event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.NO_SURFACE_ORE.configured(new OreFeatureConfig(ModFillerBlockType.ORANGE_TERRACOTTA, BlockInit.ORANGE_TERRACOTTA_FOSSIL.get().defaultBlockState(), 1)).decorated(Placement.RANGE.configured(new TopSolidRangeConfig(30, 1, 100)).squared().count(10)));				
			}
		}
	}
		
	public static void oreGenerationConfig(BiomeGenerationSettingsBuilder settings, RuleTest blockGenerationIn, BlockState block, int veinSize, int minHeight, int maxHeight, int amountGeneratedPerChunk)
	{
		settings.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.configured(new OreFeatureConfig(blockGenerationIn, block, veinSize)).decorated(Placement.RANGE.configured(new TopSolidRangeConfig(minHeight, 0, maxHeight))).squared().count(amountGeneratedPerChunk));
	}
}
