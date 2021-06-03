package lostworlds.world.feature.tree;

import java.util.Random;

import lostworlds.core.init.ConfiguredFeatureInit;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class GinkgoTree extends Tree 
{
	@Override
	protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getConfiguredFeature(Random rand, boolean b) 
	{
		return ConfiguredFeatureInit.GINKGO_TREE;
	}	
}
