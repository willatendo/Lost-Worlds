package lostworlds.world.init;

import lostworlds.core.util.reference.ModReference;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Dimension;

public class DimensionInit 
{
	public static final RegistryKey<Dimension> PERMIAN_ERA = RegistryKey.getOrCreateKey(Registry.DIMENSION_KEY, new ResourceLocation(ModReference.ID, "permian_era"));
}
