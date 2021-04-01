package lostworlds.world.init;

import lostworlds.core.util.reference.ModReference;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class DimensionInit 
{
	public static final ResourceLocation PERMIAN_TIME_ERA = new ResourceLocation(ModReference.ID, "permian_time_era");
    public static final RegistryKey<World> PERMIAN_TIME_ERA_KEY = RegistryKey.create(Registry.DIMENSION_REGISTRY, DimensionInit.PERMIAN_TIME_ERA);

    public static void makePermianTimeEra() 
    {
    	
    }
}
