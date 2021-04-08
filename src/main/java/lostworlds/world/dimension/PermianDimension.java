package lostworlds.world.dimension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.function.Supplier;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;

import lostworlds.core.init.BlockInit;
import lostworlds.core.util.DimensionUtil;
import lostworlds.core.util.ModID;
import lostworlds.mixins.DimensionSettingsAccessor;
import lostworlds.mixins.DimensionTypeAccessor;
import lostworlds.mixins.NetherBiomeProviderAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.NetherBiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.NoiseChunkGenerator;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.NoiseSettings;
import net.minecraft.world.gen.settings.ScalingSettings;
import net.minecraft.world.gen.settings.SlideSettings;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class PermianDimension 
{
	public static final ResourceLocation REGISTRY_NAME = new ResourceLocation(ModID.ID, "permian_time_era");
	public static final ResourceLocation SKY_BOX = REGISTRY_NAME;
	public static final RegistryKey<World> PERMIAN_WORLD = DimensionUtil.getWorld(REGISTRY_NAME);
	public static final RegistryKey<DimensionType> PERMIAN_DIMENSION_KEY = DimensionUtil.getDimensionType(REGISTRY_NAME);
	public static final RegistryKey<Dimension> PERMIAN_DIMENSION_SETTINGS = DimensionUtil.getDimensionSettings(REGISTRY_NAME);
	public static final RegistryKey<DimensionSettings> PERMIAN_CHUNK_GENERATOR = RegistryKey.create(Registry.NOISE_GENERATOR_SETTINGS_REGISTRY, REGISTRY_NAME);
	public static final DimensionType PERMIAN_DIMENSION_TYPE = DimensionTypeAccessor.createDimensionType(OptionalLong.empty(), true, false, false, true, 1.0D, false, false, true, false, false, 256, BiomeType.COOL, BlockTags.INFINIBURN_OVERWORLD.getName(), SKY_BOX, 0.0F);
	
	private static final Map<RegistryKey<Biome>, Biome.Builder> NOISE_POINTS = new HashMap<>();
	
	public static void addBiome(RegistryKey<Biome> biome, Biome.Builder noise) 
	{
		NOISE_POINTS.put(biome, noise);
	}

	public static Map<RegistryKey<Biome>, Biome.Builder> getNoisePoints() 
	{
		return NOISE_POINTS;
	}	
	
	public static final NetherBiomeProvider.Preset BIOME_SOURCE_PRESET = new NetherBiomeProvider.Preset(REGISTRY_NAME, (preset, registry, seed) -> 
	{
		List<Pair<Biome.Builder, Supplier<Biome>>> biomes = new ArrayList<>();
		getNoisePoints().forEach((biomeKey, noisePoint) -> biomes.add(Pair.of(noisePoint, () -> registry.getOrThrow(biomeKey))));
		return NetherBiomeProviderAccessor.createMultiNoiseBiomeSource(seed, biomes, new NetherBiomeProvider.Noise(-8, ImmutableList.of(1.0D, -1.0D)), new NetherBiomeProvider.Noise(-7, ImmutableList.of(1.0D, 1.0D)), new NetherBiomeProvider.Noise(-6, ImmutableList.of(0.75D, 1.0D)), new NetherBiomeProvider.Noise(-7, ImmutableList.of(1.0D, 1.0D)), Optional.of(Pair.of(registry, preset)));
	});
	
	private static DimensionSettings createSettings() 
	{
		return DimensionSettingsAccessor.createChunkGeneratorSettings(new DimensionStructuresSettings(false), new NoiseSettings(256, new ScalingSettings(0.514507745D, 0.693358845D, 50.928453884D, 128.954865687D), new SlideSettings(0, 0, 0), new SlideSettings(0, 0, 0), 1, 2, 2.1399846D, 1.8662893D, true, true, false, false), BlockInit.PERMIAN_STONE.get().defaultBlockState(), BlockInit.PERMIAN_STONE.get().defaultBlockState(), -10, 0, -1, false);
	}
	
	public static ChunkGenerator createGenerator(Registry<Biome> biomeRegistry, Registry<DimensionSettings> chunkGeneratorSettingsRegistry, long seed) 
	{
		return new NoiseChunkGenerator(BIOME_SOURCE_PRESET.biomeSource(biomeRegistry, seed), seed, () -> 
		{
			return chunkGeneratorSettingsRegistry.getOrThrow(PERMIAN_CHUNK_GENERATOR);
		});
	}
	
	public static void init() 
	{
		WorldGenRegistries.register(WorldGenRegistries.NOISE_GENERATOR_SETTINGS, REGISTRY_NAME, createSettings());
	}
}
