package addon.officaladdons.ogpack;

import addon.officaladdons.ogpack.util.AddonRegistry;
import lostworlds.core.util.ModUtil;

public class OGPack 
{
	public static boolean hasInitilised;
	
	public static void init() 
	{		
		ModUtil.LOGGER.debug("Loading: OG Pack");
		
		AddonRegistry.registry();
		
		hasInitilised = true; 

		ModUtil.LOGGER.debug("Finished: OG Pack");
	}
}
