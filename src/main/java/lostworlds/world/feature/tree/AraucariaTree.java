package lostworlds.world.feature.tree;

import java.util.Random;

import javax.annotation.Nullable;

import lostworlds.world.init.ConfiguredFeatureInit;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class AraucariaTree extends Tree
{
	@Nullable
	@Override
	public ConfiguredFeature<BaseTreeFeatureConfig, ?> getConfiguredFeature(Random p_225546_1_, boolean p_225546_2_) 
	{
		return ConfiguredFeatureInit.ARAUCARIA_TREE;
	}
}
