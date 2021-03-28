package lostworlds.world.biome;

import lostworlds.world.init.SurfaceBuilderInit;
import lostworlds.world.surfacebuilders.ModSurfaceBuilders;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

@SuppressWarnings("unchecked")
public class ModBiomeMaker 
{
	public static int getSkyColorWithTemperatureModifier(float temperature) 
	{
		float lvt_1_1_ = temperature / 3.0F;
		lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
		return MathHelper.hsvToRgb(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
	}
	
	private static <C extends ISurfaceBuilderConfig> BiomeGenerationSettings.Builder genSettings(SurfaceBuilder<C> surfaceBuilder, C config) 
		{
		return new BiomeGenerationSettings.Builder().surfaceBuilder(surfaceBuilder.configured(config));
	}
	
	public static Biome makeAVolcanoBiome() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		
		BiomeGenerationSettings.Builder biomegenerationsettings$builder = genSettings(SurfaceBuilderInit.NAKED_VOLCANO_SURFACE_BUILDER, ModSurfaceBuilders.VOLCANO_SURFACE_BUILDER);
		DefaultBiomeFeatures.addDefaultOverworldLandStructures(biomegenerationsettings$builder);
		biomegenerationsettings$builder.addStructureStart(StructureFeatures.RUINED_PORTAL_MOUNTAIN);
		DefaultBiomeFeatures.addDefaultCarvers(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultMonsterRoom(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultOres(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultGrass(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addExtraEmeralds(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDesertLakes(biomegenerationsettings$builder);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.EXTREME_HILLS).depth(1.0F).scale(0.5F).temperature(5.0F).downfall(0.3F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x1c1c1c1c).waterColor(0x333333).waterFogColor(0x0c0c0c).fogColor(0x636363).skyColor(0x262525).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(biomegenerationsettings$builder.build()).build();
	}
	
	
	public static Biome makeAPermianDesert() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
				
		BiomeGenerationSettings.Builder biomegenerationsettings$builder = genSettings(SurfaceBuilderInit.NAKED_PERMIAN_DESERT_SURFACE_BUILDER, ModSurfaceBuilders.PERMIAN_DESERT);
		DefaultBiomeFeatures.addDefaultCarvers(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultOres(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultGrass(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDesertLakes(biomegenerationsettings$builder);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.DESERT).depth(0.125F).scale(0.05F).temperature(3.75F).downfall(0.3F).specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(getSkyColorWithTemperatureModifier(0.2F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(biomegenerationsettings$builder.build()).build();
	}
	
	public static Biome makeAFloodBasaltPlains() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		
		BiomeGenerationSettings.Builder biomegenerationsettings$builder = genSettings(SurfaceBuilderInit.NAKED_FLOOD_BASALT_SURFACE_BUILDER, ModSurfaceBuilders.FLOOD_BASALT_PLAINS);
		DefaultBiomeFeatures.addDefaultCarvers(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultOres(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultGrass(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDesertLakes(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addExtraEmeralds(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDesertLakes(biomegenerationsettings$builder);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.PLAINS).depth(0.125F).scale(0.05F).temperature(4.5F).downfall(0.4F).specialEffects((new BiomeAmbience.Builder()).waterColor(0x545454).waterFogColor(0x4c4c4c).fogColor(0x3f3f3f).skyColor(0x262525).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(biomegenerationsettings$builder.build()).build();
	}
}
