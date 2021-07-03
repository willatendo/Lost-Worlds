package lostworlds.content.server.init;

import lostworlds.library.enums.DinoTypes;
import lostworlds.library.item.forge.ForgeFossilItem;

/*
 * Author: Willatendo
 * Date: July 2, 2021
 */

public class FossilInit 
{
	//Registry
	public static void init() 
	{
		ForgeFossilItem.create(DinoTypes.ALLOSAURUS);
	}
}
