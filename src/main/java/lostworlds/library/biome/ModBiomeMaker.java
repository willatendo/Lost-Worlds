package lostworlds.library.biome;

import lostworlds.content.server.init.SurfaceBuilderInit;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class ModBiomeMaker 
{	
	private static <C extends ISurfaceBuilderConfig> BiomeGenerationSettings.Builder genSettings(SurfaceBuilder<C> surfaceBuilder, C config) 
	{
		return new BiomeGenerationSettings.Builder().surfaceBuilder(surfaceBuilder.configured(config));
	}
	
	public static Biome permianDesert()
	{
		MobSpawnInfo.Builder spawnBuilder = new MobSpawnInfo.Builder();
		
		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.PERMIAN_DESERT_SURFACE_BUILDER);
			
		ModBiomeFeatures.addPermianDesertPlants(generationBuilder);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.DESERT).depth(0.125F).scale(0.05F).temperature(3.0F).downfall(0.0F).specialEffects((new BiomeAmbience.Builder()).waterColor(0xb78f59).waterFogColor(0x99774a).fogColor(0xbc745e).skyColor(0xdd5f39).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome permianDesertHills()
	{
		MobSpawnInfo.Builder spawnBuilder = new MobSpawnInfo.Builder();
		
		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.PERMIAN_DESERT_SURFACE_BUILDER);
		
		ModBiomeFeatures.addPermianDesertPlants(generationBuilder);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.DESERT).depth(0.45F).scale(0.3F).temperature(3.0F).downfall(0.0F).specialEffects((new BiomeAmbience.Builder()).waterColor(0xb78f59).waterFogColor(0x99774a).fogColor(0xbc745e).skyColor(0xdd5f39).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome permianDriedPlains()
	{
		MobSpawnInfo.Builder spawnBuilder = new MobSpawnInfo.Builder();
		
		BiomeGenerationSettings.Builder generationBuilder = genSettings(SurfaceBuilderInit.NAKED_DRIED_PLAINS, ModSurfaceBuilders.DRIED_SOIL_CONFIG);
			
		ModBiomeFeatures.addFerns(generationBuilder);
		ModBiomeFeatures.addSingleConiferTree(generationBuilder);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.PLAINS).depth(0.125F).scale(0.05F).temperature(2.0F).downfall(0.0F).specialEffects((new BiomeAmbience.Builder()).waterColor(0x94ccc3).waterFogColor(0x72aaa2).fogColor(0xbc745e).skyColor(0xdd5f39).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
}
