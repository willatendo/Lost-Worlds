package lostworlds.content.server.init;

import lostworlds.library.biome.BiomeKeys;
import lostworlds.library.biome.ModBiomeMaker;
import lostworlds.library.util.ModRegistry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;

/*
 * Author: Willatendo
 * Date: July 3, 2021
 */

public class BiomeInit 
{
	public static final RegistryObject<Biome> PERMIAN_DESERT = ModRegistry.register(1, BiomeKeys.PERMIAN_DESERT, "permian_desert", ModBiomeMaker.permianDesert());
	public static final RegistryObject<Biome> PERMIAN_DESERT_HILLS = ModRegistry.register(2, BiomeKeys.PERMIAN_DESERT_HILLS, "permian_desert_hills", ModBiomeMaker.permianDesertHills());
	public static final RegistryObject<Biome> PERMIAN_DRIED_PLAINS = ModRegistry.register(1, BiomeKeys.PERMIAN_DRIED_PLAINS, "permian_dried_plains", ModBiomeMaker.permianDriedPlains());

	//Registry
	public static void init() { }
}
