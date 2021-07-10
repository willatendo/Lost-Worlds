package lostworlds.content.server.init;

import lostworlds.library.item.forge.ForgeFossilItem;
import lostworlds.library.util.ModUtil;

/*
 * Author: Willatendo
 * Date: July 2, 2021
 */

public class FossilInit 
{
	//Registry
	public static void init() 
	{
		ModUtil.LOGGER.debug("Registering Fossils");
		
		ForgeFossilItem.create("allosaurus");
	}
}
