package lostworlds.core.util;

import net.minecraft.util.ResourceLocation;

public class ModID
{
	public static final String ID = "lostworlds";
	public static final String VERSION = "Alpha 9";
	public static final String NAME = "Lost Worlds";
	
	public static ResourceLocation lostWorlds(String id)
	{
		return new ResourceLocation(ID, id);
	}
}
