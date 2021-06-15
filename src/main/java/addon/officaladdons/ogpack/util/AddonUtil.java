package addon.officaladdons.ogpack.util;

import net.minecraft.util.ResourceLocation;

public class AddonUtil 
{
	public static final String ID = "ogpack";
	
	public static ResourceLocation rL(String id)
	{
		return new ResourceLocation(ID, id);
	}
}
