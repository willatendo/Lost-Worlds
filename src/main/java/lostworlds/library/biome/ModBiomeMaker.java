package lostworlds.library.biome;

import lostworlds.content.server.init.SurfaceBuilderInit;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.biome.ParticleEffectAmbience;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

/*
 * Author: Willatendo
 * Date: July 8, 2021
 */

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
		ModBiomeFeatures.addPermianRockOutcrop(generationBuilder);
	
		return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.DESERT).depth(0.125F).scale(0.05F).temperature(3.0F).downfall(0.0F).specialEffects((new BiomeAmbience.Builder()).waterColor(0xb78f59).waterFogColor(0x99774a).fogColor(0xbc745e).skyColor(0xdd5f39).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome permianDesertHills()
	{
		MobSpawnInfo.Builder spawnBuilder = new MobSpawnInfo.Builder();
		
		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.PERMIAN_DESERT_SURFACE_BUILDER);
		
		ModBiomeFeatures.addPermianDesertPlants(generationBuilder);
		ModBiomeFeatures.addPermianRockOutcrop(generationBuilder);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.DESERT).depth(0.45F).scale(0.3F).temperature(3.0F).downfall(0.0F).specialEffects((new BiomeAmbience.Builder()).waterColor(0xb78f59).waterFogColor(0x99774a).fogColor(0xbc745e).skyColor(0xdd5f39).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome permianDesertLake()
	{
		MobSpawnInfo.Builder spawnBuilder = new MobSpawnInfo.Builder();
		
		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.PERMIAN_DESERT_SURFACE_BUILDER);
			
		ModBiomeFeatures.addPermianDesertPlants(generationBuilder);
		ModBiomeFeatures.addPermianRockOutcrop(generationBuilder);
	
		return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.DESERT).depth(0.225F).scale(0.25F).temperature(3.0F).downfall(0.0F).specialEffects((new BiomeAmbience.Builder()).waterColor(0xb78f59).waterFogColor(0x99774a).fogColor(0xbc745e).skyColor(0xdd5f39).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome permianDriedPlains()
	{
		MobSpawnInfo.Builder spawnBuilder = new MobSpawnInfo.Builder();
		
		BiomeGenerationSettings.Builder generationBuilder = genSettings(SurfaceBuilderInit.NAKED_DRIED_PLAINS, ModSurfaceBuilders.DRIED_SOIL_MUD_CONFIG);
			
		ModBiomeFeatures.addFerns(generationBuilder);
		ModBiomeFeatures.addSingleConiferTree(generationBuilder);
		ModBiomeFeatures.addPermianRockOutcrop(generationBuilder);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.PLAINS).depth(0.125F).scale(0.05F).temperature(2.0F).downfall(0.0F).specialEffects((new BiomeAmbience.Builder()).waterColor(0x94ccc3).waterFogColor(0x72aaa2).fogColor(0xbc745e).skyColor(0xdd5f39).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome permianDriedPlainsHills()
	{
		MobSpawnInfo.Builder spawnBuilder = new MobSpawnInfo.Builder();
		
		BiomeGenerationSettings.Builder generationBuilder = genSettings(SurfaceBuilderInit.NAKED_DRIED_PLAINS, ModSurfaceBuilders.DRIED_SOIL_CONFIG);
			
		ModBiomeFeatures.addFerns(generationBuilder);
		ModBiomeFeatures.addSingleConiferTree(generationBuilder);
		ModBiomeFeatures.addPermianRockOutcrop(generationBuilder);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.PLAINS).depth(0.45F).scale(0.3F).temperature(2.0F).downfall(0.0F).specialEffects((new BiomeAmbience.Builder()).waterColor(0x94ccc3).waterFogColor(0x72aaa2).fogColor(0xbc745e).skyColor(0xdd5f39).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome permianAshyMedows()
	{
		MobSpawnInfo.Builder spawnBuilder = new MobSpawnInfo.Builder();
		
		BiomeGenerationSettings.Builder generationBuilder = genSettings(SurfaceBuilderInit.NAKED_ASHY_MEDOWS, ModSurfaceBuilders.VOLCANIC_ASH_CONFIG);
		
		ModBiomeFeatures.addScorchedTrees(generationBuilder);
		ModBiomeFeatures.addAshyShrub(generationBuilder);
		ModBiomeFeatures.addAshLayer(generationBuilder);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.PLAINS).depth(0.125F).scale(0.05F).temperature(2.0F).downfall(0.0F).specialEffects((new BiomeAmbience.Builder()).waterColor(0x999999).waterFogColor(0x757575).fogColor(0x494949).skyColor(0x3a3a3a).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).ambientParticle(new ParticleEffectAmbience(ParticleTypes.WHITE_ASH, 0.00625F)).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome permianFloodBasalts()
	{
		MobSpawnInfo.Builder spawnBuilder = new MobSpawnInfo.Builder();
		
		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ConfiguredSurfaceBuilders.BASALT_DELTAS).addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SPRING_LAVA).addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Features.BASALT_PILLAR).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.ORE_MAGMA).addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Features.DELTA).addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SPRING_LAVA_DOUBLE).addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Features.SMALL_BASALT_COLUMNS).addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Features.LARGE_BASALT_COLUMNS);
		
		ModBiomeFeatures.addBasaltDiamondOre(generationBuilder);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.PLAINS).depth(0.125F).scale(0.05F).temperature(5.0F).downfall(0.0F).specialEffects((new BiomeAmbience.Builder()).waterColor(0x999999).waterFogColor(0x757575).fogColor(0x494949).skyColor(0x3a3a3a).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).ambientParticle(new ParticleEffectAmbience(ParticleTypes.WHITE_ASH, 0.0625F)).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
}
