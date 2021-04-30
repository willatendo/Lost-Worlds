package lostworlds.world.feature.init;

import com.google.common.collect.ImmutableList;

import lostworlds.core.util.ModBlockStates;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;

public class Foliage 
{
	public static final BlockClusterFeatureConfig DEFAULT_PERMAIN_DESERT_CONFIG_SMALL = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlockStates.SMALL_PERMIAN_DESERT_PLANT), SimpleBlockPlacer.INSTANCE)).tries(11).build();
	public static final BlockClusterFeatureConfig DEFAULT_PERMAIN_DESERT_CONFIG_MEDIUM = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlockStates.MEDIUM_PERMIAN_DESERT_PLANT), SimpleBlockPlacer.INSTANCE)).tries(9).build();
	public static final BlockClusterFeatureConfig DEFAULT_PERMAIN_DESERT_CONFIG_LARGE = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlockStates.LARGE_PERMIAN_DESERT_PLANT), SimpleBlockPlacer.INSTANCE)).tries(4).build();

	public static final BlockClusterFeatureConfig DEFAULT_PERMIAN_GROUND_FERNS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlockStates.PERMIAN_GROUND_FERNS), SimpleBlockPlacer.INSTANCE)).tries(128).build();
	
	public static final ConfiguredFeature<?, ?> PATCH_PERMIAN_DESERT_PLANT_SMALL = register("patch_permian_desert_plant_small", Feature.RANDOM_PATCH.configured(Foliage.DEFAULT_PERMAIN_DESERT_CONFIG_SMALL).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE));
	public static final ConfiguredFeature<?, ?> PATCH_PERMIAN_DESERT_PLANT_MEDIUM = register("patch_permian_desert_plant_medium", Feature.RANDOM_PATCH.configured(Foliage.DEFAULT_PERMAIN_DESERT_CONFIG_MEDIUM).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE));
	public static final ConfiguredFeature<?, ?> PATCH_PERMIAN_DESERT_PLANT_LARGE = register("patch_permian_desert_plant_large", Feature.RANDOM_PATCH.configured(Foliage.DEFAULT_PERMAIN_DESERT_CONFIG_LARGE).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE));
	
	public static final ConfiguredFeature<?, ?> PATCH_PERMIAN_GROUND_FERNS = register("patch_permian_ground_ferns", Feature.RANDOM_PATCH.configured(Foliage.DEFAULT_PERMIAN_GROUND_FERNS_CONFIG).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE));
//	public static final ConfiguredFeature<?, ?> PERMIAN_SEAGRASS = register("permian_seagrass", Feature.SEAGRASS.configured(new ProbabilityConfig(0.8F)).count(80).decorated(Features.Placements.TOP_SOLID_HEIGHTMAP_SQUARE));

	public static final ConfiguredFeature<?, ?> CONIFER_TREES = register("conifer_trees", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(Trees.CONIFER_TREE.weighted(0.5F)), Trees.CONIFER_TREE)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
	public static final ConfiguredFeature<?, ?> GINKGO_TREES = register("ginkgo_trees", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(Trees.GINKGO_TREE.weighted(0.5F)), Trees.GINKGO_TREE)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
	
	public static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<FC, ?> configuredFeature) 
	{
		return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, id, configuredFeature);
	}
}
