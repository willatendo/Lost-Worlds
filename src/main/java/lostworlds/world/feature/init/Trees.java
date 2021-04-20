package lostworlds.world.feature.init;

import lostworlds.core.util.ModBlockStates;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.foliageplacer.SpruceFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

public class Trees 
{
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CONIFER_TREE = Foliage.register("conifer_tree", Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlockStates.CONIFER_LOG), new SimpleBlockStateProvider(ModBlockStates.CONIFER_LEAVES), new SpruceFoliagePlacer(FeatureSpread.of(0, 2), FeatureSpread.of(0, 2), FeatureSpread.of(1, 1)), new StraightTrunkPlacer(5, 2, 1), new TwoLayerFeature(2, 0, 2))).ignoreVines().build()));
}
