package lostworlds.world.feature.init;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class ModFeatures 
{
//	public static final PermianSeaGrassFeature SEAGRASS = register("permian_seagrass", new PermianSeaGrassFeature(ProbabilityConfig.CODEC));

	@SuppressWarnings({ "deprecation", "unused" })
	private static <C extends IFeatureConfig, F extends Feature<C>> F register(String id, F feature) 
	{
		return Registry.register(Registry.FEATURE, id, feature);
	}
}
