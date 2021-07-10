package lostworlds.content.server.init;

import lostworlds.library.biome.ModBiomeMaker;
import lostworlds.library.util.ModRegistry;
import lostworlds.library.util.ModUtil;
import net.minecraft.world.biome.Biome;

/*
 * Author: Willatendo
 * Date: July 10, 2021
 */

public class BiomeInit 
{
	//Permian
	public static final Biome PERMIAN_DESERT = ModRegistry.register("permian_desert", ModBiomeMaker.permianDesert());
	public static final Biome PERMIAN_DESERT_HILLS = ModRegistry.register("permian_desert_hills", ModBiomeMaker.permianDesertHills());
	public static final Biome PERMIAN_DESERT_LAKE = ModRegistry.register("permian_desert_lake", ModBiomeMaker.permianDesertLake());

	public static final Biome PERMIAN_DRIED_PLAINS = ModRegistry.register("permian_dried_plains", ModBiomeMaker.permianDriedPlains());
	public static final Biome PERMIAN_DRIED_PLAINS_HILLS = ModRegistry.register("permian_dried_plains_hills", ModBiomeMaker.permianDriedPlainsHills());

	public static final Biome PERMIAN_ASHY_MEDOWS = ModRegistry.register("permian_ashy_medows", ModBiomeMaker.permianAshyMedows());

	public static final Biome PERMIAN_FLOOD_BASALT_PLAINS = ModRegistry.register("permian_flood_basalts", ModBiomeMaker.permianFloodBasalts());

	//Registry
	public static void init() { ModUtil.LOGGER.debug("Registering Mod Biomes"); }
}
