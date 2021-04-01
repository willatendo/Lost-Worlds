package lostworlds.world.init;

import lostworlds.core.init.BlockInit;
import lostworlds.core.init.EntityInit;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityClassification;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class ModFeatures 
{	
    protected static final BlockState SMALL_PERMIAN_DESERT_PLANT = BlockInit.SMALL_PERMIAN_DESERT_PLANT.get().defaultBlockState();
    protected static final BlockState MEDIUM_PERMIAN_DESERT_PLANT = BlockInit.MEDIUM_PERMIAN_DESERT_PLANT.get().defaultBlockState();
    protected static final BlockState LARGE_PERMIAN_DESERT_PLANT = BlockInit.LARGE_PERMIAN_DESERT_PLANT.get().defaultBlockState();
	
    protected static final BlockState PERMIAN_GROUND_FERNS = BlockInit.PERMIAN_GROUND_FERNS.get().defaultBlockState();
    
	public static final BlockClusterFeatureConfig DEFAULT_PERMAIN_DESERT_CONFIG_SMALL = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModFeatures.SMALL_PERMIAN_DESERT_PLANT), SimpleBlockPlacer.INSTANCE)).tries(11).build();
	public static final BlockClusterFeatureConfig DEFAULT_PERMAIN_DESERT_CONFIG_MEDIUM = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModFeatures.MEDIUM_PERMIAN_DESERT_PLANT), SimpleBlockPlacer.INSTANCE)).tries(9).build();
	public static final BlockClusterFeatureConfig DEFAULT_PERMAIN_DESERT_CONFIG_LARGE = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModFeatures.LARGE_PERMIAN_DESERT_PLANT), SimpleBlockPlacer.INSTANCE)).tries(4).build();

	public static final BlockClusterFeatureConfig DEFAULT_PERMIAN_GROUND_FERNS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModFeatures.PERMIAN_GROUND_FERNS), SimpleBlockPlacer.INSTANCE)).tries(128).build();
	
	public static final ConfiguredFeature<?, ?> PATCH_PERMIAN_DESERT_PLANT_SMALL = register("patch_permian_desert_plant_small", Feature.RANDOM_PATCH.configured(ModFeatures.DEFAULT_PERMAIN_DESERT_CONFIG_SMALL).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE));
	public static final ConfiguredFeature<?, ?> PATCH_PERMIAN_DESERT_PLANT_MEDIUM = register("patch_permian_desert_plant_medium", Feature.RANDOM_PATCH.configured(ModFeatures.DEFAULT_PERMAIN_DESERT_CONFIG_MEDIUM).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE));
	public static final ConfiguredFeature<?, ?> PATCH_PERMIAN_DESERT_PLANT_LARGE = register("patch_permian_desert_plant_large", Feature.RANDOM_PATCH.configured(ModFeatures.DEFAULT_PERMAIN_DESERT_CONFIG_LARGE).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE));

	public static final ConfiguredFeature<?, ?> PATCH_PERMIAN_GROUND_FERNS = register("patch_permian_ground_ferns", Feature.RANDOM_PATCH.configured(ModFeatures.DEFAULT_PERMIAN_GROUND_FERNS_CONFIG).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE));
	
	private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<FC, ?> configuredFeature) 
	{
		return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, id, configuredFeature);
	}
	
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
