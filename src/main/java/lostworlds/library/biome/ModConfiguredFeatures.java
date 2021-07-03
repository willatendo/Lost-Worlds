package lostworlds.library.biome;

import lostworlds.content.server.init.BlockInit;
import lostworlds.library.util.ModUtil;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class ModConfiguredFeatures 
{
	public static final ConfiguredFeature<?, ?> SMALL_PERMIAN_DESERT_PLANT_PATCH = register("small_permian_desert_plant_patch", Feature.RANDOM_PATCH.configured(ModBlockClusterFeatureConfig.SMALL_PERMIAN_DESERT_PLANT_CONFIG).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE));
	public static final ConfiguredFeature<?, ?> MEDIUM_PERMIAN_DESERT_PLANT_PATCH = register("medium_permian_desert_plant_patch", Feature.RANDOM_PATCH.configured(ModBlockClusterFeatureConfig.MEDIUM_PERMIAN_DESERT_PLANT_CONFIG).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE));
	public static final ConfiguredFeature<?, ?> LARGE_PERMIAN_DESERT_PLANT_PATCH = register("large_permian_desert_plant_patch", Feature.RANDOM_PATCH.configured(ModBlockClusterFeatureConfig.LARGE_PERMIAN_DESERT_PLANT_CONFIG).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE));
	public static final ConfiguredFeature<?, ?> LUSH_PERMIAN_DESERT_PLANT_PATCH = register("lush_permian_desert_plant_patch", Feature.RANDOM_PATCH.configured(ModBlockClusterFeatureConfig.LUSH_PERMIAN_DESERT_PLANT_CONFIG).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE));
	public static final ConfiguredFeature<?, ?> DEAD_PERMIAN_SHRUB_PATCH = register("dead_permian_shrub_patch", Feature.RANDOM_PATCH.configured(ModBlockClusterFeatureConfig.DEAD_PERMIAN_SHRUB_CONFIG).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE));
	public static final ConfiguredFeature<?, ?> FERN_PATCH = register("fern_patch", Feature.RANDOM_PATCH.configured(ModConfiguredFeatures.ModBlockClusterFeatureConfig.FERN_CONFIG));
	
	public static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<FC, ?> configuredFeature) 
	{
		return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, ModUtil.rL(id), configuredFeature);
	}
	
	static class ModBlockClusterFeatureConfig
	{
		public static final BlockClusterFeatureConfig SMALL_PERMIAN_DESERT_PLANT_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.SMALL_PERMIAN_DESERT_PLANT.defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(11).build();
		public static final BlockClusterFeatureConfig MEDIUM_PERMIAN_DESERT_PLANT_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.MEDIUM_PERMIAN_DESERT_PLANT.defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(9).build();
		public static final BlockClusterFeatureConfig LARGE_PERMIAN_DESERT_PLANT_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.LARGE_PERMIAN_DESERT_PLANT.defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(4).build();
		public static final BlockClusterFeatureConfig LUSH_PERMIAN_DESERT_PLANT_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.LUSH_PERMIAN_DESERT_PLANT.defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(4).build();
		public static final BlockClusterFeatureConfig DEAD_PERMIAN_SHRUB_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.DEAD_PERMIAN_SHRUB.defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(4).build();
		
		public static final BlockClusterFeatureConfig FERN_CONFIG = (new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider()).add(Blocks.FERN.defaultBlockState(), 4), SimpleBlockPlacer.INSTANCE)).tries(32).build();
	}
}
