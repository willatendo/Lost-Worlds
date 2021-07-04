package lostworlds.library.biome;

import com.google.common.collect.ImmutableList;

import lostworlds.content.server.init.BlockInit;
import lostworlds.library.util.ModUtil;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.foliageplacer.SpruceFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

public class ModConfiguredFeatures 
{
	/*
	 Sorted:
	 - Plant Patches (A - Z)
	 - Trees (A - Z)
	 */
	
	public static final ConfiguredFeature<?, ?> DEAD_PERMIAN_SHRUB_PATCH = register("dead_permian_shrub_patch", Feature.RANDOM_PATCH.configured(ModBlockClusterFeatureConfig.DEAD_PERMIAN_SHRUB_CONFIG).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE));
	public static final ConfiguredFeature<?, ?> DEAD_LARGE_PERMIAN_SHRUB_PATCH = register("dead_large_permian_shrub_patch", Feature.RANDOM_PATCH.configured(ModBlockClusterFeatureConfig.DEAD_LARGE_PERMIAN_SHRUB_CONFIG).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE));
	public static final ConfiguredFeature<?, ?> FERN_PATCH = register("fern_patch", Feature.RANDOM_PATCH.configured(ModConfiguredFeatures.ModBlockClusterFeatureConfig.FERN_CONFIG));
	public static final ConfiguredFeature<?, ?> SMALL_PERMIAN_DESERT_PLANT_PATCH = register("small_permian_desert_plant_patch", Feature.RANDOM_PATCH.configured(ModBlockClusterFeatureConfig.SMALL_PERMIAN_DESERT_PLANT_CONFIG).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE));
	public static final ConfiguredFeature<?, ?> MEDIUM_PERMIAN_DESERT_PLANT_PATCH = register("medium_permian_desert_plant_patch", Feature.RANDOM_PATCH.configured(ModBlockClusterFeatureConfig.MEDIUM_PERMIAN_DESERT_PLANT_CONFIG).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE));
	public static final ConfiguredFeature<?, ?> LARGE_PERMIAN_DESERT_PLANT_PATCH = register("large_permian_desert_plant_patch", Feature.RANDOM_PATCH.configured(ModBlockClusterFeatureConfig.LARGE_PERMIAN_DESERT_PLANT_CONFIG).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE));
	public static final ConfiguredFeature<?, ?> LUSH_PERMIAN_DESERT_PLANT_PATCH = register("lush_permian_desert_plant_patch", Feature.RANDOM_PATCH.configured(ModBlockClusterFeatureConfig.LUSH_PERMIAN_DESERT_PLANT_CONFIG).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE));

	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CONIFER_TREE = register("conifer_tree", Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.CONIFER_LOG.defaultBlockState()), new SimpleBlockStateProvider(BlockInit.CONIFER_LEAVES.defaultBlockState()), new SpruceFoliagePlacer(FeatureSpread.of(2, 1), FeatureSpread.of(0, 2), FeatureSpread.of(1, 1)), new StraightTrunkPlacer(5, 2, 1), new TwoLayerFeature(2, 0, 2))).ignoreVines().build()));

	public static final ConfiguredFeature<?, ?> SINGLE_CONIFER_TREE = register("single_conifer_tree", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(ModConfiguredFeatures.CONIFER_TREE.weighted(0.5F)), ModConfiguredFeatures.CONIFER_TREE)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
	public static final ConfiguredFeature<?, ?> CONIFER_TREES = register("conifer_trees", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(ModConfiguredFeatures.CONIFER_TREE.weighted(0.5F)), ModConfiguredFeatures.CONIFER_TREE)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
	public static final ConfiguredFeature<?, ?> CONIFER_VEGETATION = register("conifer_vegetation", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(CONIFER_TREE.weighted(0.33333334F)), CONIFER_TREE)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));

	
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
		public static final BlockClusterFeatureConfig DEAD_LARGE_PERMIAN_SHRUB_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.DEAD_LARGE_PERMIAN_SHRUB.defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(4).build();
		
		public static final BlockClusterFeatureConfig FERN_CONFIG = (new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider()).add(Blocks.FERN.defaultBlockState(), 4), SimpleBlockPlacer.INSTANCE)).tries(32).build();
	}
}
