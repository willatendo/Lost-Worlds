package lostworlds.world.init;

import lostworlds.core.util.ModID;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ModID.ID)
public class DimensionInit 
{
	public static long seed;
	public static final RegistryKey<World> PERMIAN_TIME_ERA = RegistryKey.create(Registry.DIMENSION_REGISTRY, ModID.lostWorlds("permian_time_era"));
	
	public static void init()
	{
		Registry.register(Registry.BIOME_SOURCE, ModID.lostWorlds("smart_distribution"), null);
	}
}
