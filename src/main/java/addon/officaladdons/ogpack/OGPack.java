package addon.officaladdons.ogpack;

import library.util.ModUtil;

public class OGPack 
{
	public static boolean hasInitilised = false;
	
	public static void init() 
	{		
		ModUtil.LOGGER.debug("Loading: OG Pack");
				
		hasInitilised = true; 

		ModUtil.LOGGER.debug("Finished: OG Pack");
	}
}
