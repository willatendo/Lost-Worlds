package lostworlds.content.server.init;

import lostworlds.library.feature.AshFeature;
import lostworlds.library.util.ModRegistry;
import lostworlds.library.util.ModUtil;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class FeatureInit 
{
	public static final Feature<NoFeatureConfig> ADD_ASH = new AshFeature(NoFeatureConfig.CODEC);
	
	public static void init() 
	{
		ModUtil.LOGGER.debug("Registering Mod Features"); 
	
		ModRegistry.register("add_ash", ADD_ASH);
	}
}
