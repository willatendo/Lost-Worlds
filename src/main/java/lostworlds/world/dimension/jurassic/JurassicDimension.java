package lostworlds.world.dimension.jurassic;

import lostworlds.core.util.ModID;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

public class JurassicDimension
{
	public static final RegistryKey<World> JURASSIC_WORLD = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(ModID.ID, "jurassic_era_dimension"));
	public static final RegistryKey<DimensionType> JURASSIC_DIMENSION = RegistryKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(ModID.ID, "jurassic_era_dimension"));
	
	public static void init()
	{
		Registry.register(Registry.BIOME_SOURCE, new ResourceLocation(ModID.ID, "jurassic_era_biomes"), JurassicBiomeProvider.CODEC);
		Registry.register(Registry.CHUNK_GENERATOR, new ResourceLocation(ModID.ID, "jurassic_era_chunk_generator"), JurassicChunkGenerator.CODEC);
	}
}
