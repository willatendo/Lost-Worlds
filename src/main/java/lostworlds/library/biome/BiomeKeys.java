package lostworlds.library.biome;

import lostworlds.library.util.ModUtil;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class BiomeKeys 
{
	public static final RegistryKey<Biome> PERMIAN_DESERT = register("permian_desert");
	public static final RegistryKey<Biome> PERMIAN_DESERT_HILLS = register("permian_desert_hills");
	public static final RegistryKey<Biome> PERMIAN_DRIED_PLAINS = register("permian_dried_plains");
	
	private static RegistryKey<Biome> register(String id)
	{
		return RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, id));
	}
}
