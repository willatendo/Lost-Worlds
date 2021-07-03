package lostworlds.content.server.init;

import lostworlds.library.enums.DinoTypes;
import lostworlds.library.item.forge.ForgeFossilItem;

public class FossilInit 
{
	//Registry
	public static void init() 
	{
		ForgeFossilItem.create(DinoTypes.ALLOSAURUS);
	}
}
