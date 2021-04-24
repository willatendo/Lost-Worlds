package lostworlds.world.feature.init;

import com.google.common.collect.ImmutableList;

import lostworlds.core.util.ModBlockStates;
import lostworlds.world.feature.foliageplacer.GinkgoFoliagePlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.foliageplacer.SpruceFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

public class Trees 
{
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CONIFER_TREE = Foliage.register("conifer_tree", Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlockStates.CONIFER_LOG), new SimpleBlockStateProvider(ModBlockStates.CONIFER_LEAVES), new SpruceFoliagePlacer(FeatureSpread.of(2, 1), FeatureSpread.of(0, 2), FeatureSpread.of(1, 1)), new StraightTrunkPlacer(5, 2, 1), new TwoLayerFeature(2, 0, 2))).ignoreVines().build()));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> GINKGO_TREE = Foliage.register("ginkgo_tree", Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlockStates.GINKGO_LOG), new SimpleBlockStateProvider(ModBlockStates.GINKGO_LEAVES), new GinkgoFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 6), new StraightTrunkPlacer(7, 2, 1), new TwoLayerFeature(2, 0, 2))).ignoreVines().build()));

	public static final ConfiguredFeature<?, ?> CONIFER_VEGETATION = Foliage.register("conifer_vegetation", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(CONIFER_TREE.weighted(0.33333334F)), CONIFER_TREE)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
	public static final ConfiguredFeature<?, ?> GINKGO_VEGETATION = Foliage.register("gingko_vegetation", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(GINKGO_TREE.weighted(0.33333334F)), GINKGO_TREE)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
}
