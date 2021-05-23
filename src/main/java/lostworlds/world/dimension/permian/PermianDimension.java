package lostworlds.world.dimension.permian;

import lostworlds.core.util.ModUtil;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

public class PermianDimension 
{
	public static final RegistryKey<World> PERMIAN_WORLD = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(ModUtil.ID, "permian_era_dimension"));
	public static final RegistryKey<DimensionType> PERMIAN_DIMENSION = RegistryKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(ModUtil.ID, "permian_era_dimension"));
	
	public static void init()
	{
		Registry.register(Registry.BIOME_SOURCE, new ResourceLocation(ModUtil.ID, "permian_era_biomes"), PermianBiomeProvider.CODEC);
		Registry.register(Registry.CHUNK_GENERATOR, new ResourceLocation(ModUtil.ID, "permian_era_chunk_generator"), PermianChunkGenerator.CODEC);
	}
}
