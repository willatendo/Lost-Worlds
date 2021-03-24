package lostworlds.world.init;

import lostworlds.core.init.BlockInit;
import lostworlds.core.init.EntityInit;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class FeatureInit 
{
	public static void addMobSpawning(BiomeLoadingEvent event)
	{
		if (event.getCategory() != Category.NETHER && event.getCategory() != Category.THEEND && event.getCategory() != Category.NONE)
		{
			if (event.getCategory() == Category.OCEAN)
			{
				event.getSpawns().addSpawn(EntityClassification.WATER_CREATURE, new MobSpawnInfo.Spawners(EntityInit.NAUTILUS_ENTITY.get(), 1, 1, 1));
			}
		}
	}
	
	public static void generateOre(BiomeLoadingEvent event)
	{
		if(!(event.getCategory().equals(Biome.Category.NETHER) || event.getCategory().equals(Biome.Category.THEEND)))
		{
			//Copper
			oreGenerationConfig(event.getGeneration(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.COPPER_ORE.get().defaultBlockState(), 9, 5, 83, 40);

			//Fossil
			event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.NO_SURFACE_ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.STONE_FOSSIL.get().defaultBlockState(), 1)).decorated(Placement.RANGE.configured(new TopSolidRangeConfig(30, 1, 100)).squared().count(50)));				
		}
	}
	
	public static void oreGenerationConfig(BiomeGenerationSettingsBuilder settings, RuleTest blockGenerationIn, BlockState block, int veinSize, int minHeight, int maxHeight, int amountGeneratedPerChunk)
	{
		settings.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.configured(new OreFeatureConfig(blockGenerationIn, block, veinSize)).decorated(Placement.RANGE.configured(new TopSolidRangeConfig(minHeight, 0, maxHeight))).squared().count(amountGeneratedPerChunk));
	}
}
