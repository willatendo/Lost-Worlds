package lostworlds.core.util;

import net.minecraft.util.ResourceLocation;

public class ModID
{
	public static final String ID = "lostworlds";
	
	public static ResourceLocation lostWorlds(String id)
	{
		return new ResourceLocation(ID, id);
	}
}
