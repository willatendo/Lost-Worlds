package lostworlds.world.init;

import java.util.function.Supplier;

import lostworlds.core.util.registry.ModRegistry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMaker;
import net.minecraftforge.fml.RegistryObject;

public class BiomeInit 
{
	static
	{
		registerBiome("volcano", BiomeMaker::makeVoidBiome);
	}
	
	//Registry
	private static RegistryObject<Biome> registerBiome(String id, Supplier<Biome> biome)
	{
		return ModRegistry.BIOME_REGISTRY.register(id, biome);
	}
	
	public static void initBiomes() { }
}
