package lostworlds.world.biome;

import lostworlds.core.init.EntityInit;
import lostworlds.core.init.ParticleInit;
import lostworlds.world.init.SurfaceBuilderInit;
import lostworlds.world.surfacebuilders.ModSurfaceBuilders;
import net.minecraft.entity.EntityClassification;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.biome.ParticleEffectAmbience;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

@SuppressWarnings("unchecked")
public class ModBiomeMaker 
{	
	private static <C extends ISurfaceBuilderConfig> BiomeGenerationSettings.Builder genSettings(SurfaceBuilder<C> surfaceBuilder, C config) 
	{
		return new BiomeGenerationSettings.Builder().surfaceBuilder(surfaceBuilder.configured(config));
	}
	
	private static int calculateSkyColor(float p_244206_0_) 
	{
		float lvt_1_1_ = p_244206_0_ / 3.0F;
		lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
		return MathHelper.hsvToRgb(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
	}
	
	private static BiomeGenerationSettings.Builder baseOceanGeneration(ConfiguredSurfaceBuilder<SurfaceBuilderConfig> p_244225_0_, boolean p_244225_1_, boolean p_244225_2_, boolean p_244225_3_) 
	{
		BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(p_244225_0_);
		DefaultBiomeFeatures.addOceanCarvers(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultLakes(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultOres(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultSprings(biomegenerationsettings$builder);

		ModBiomeFeatures.addCavesAndCanyons(biomegenerationsettings$builder);
				
		return biomegenerationsettings$builder;
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
		DefaultBiomeFeatures.addExtraEmeralds(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDesertLakes(biomegenerationsettings$builder);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.EXTREME_HILLS).depth(1.0F).scale(0.5F).temperature(5.0F).downfall(0.3F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x1c1c1c1c).waterColor(0x333333).waterFogColor(0x0c0c0c).fogColor(0x636363).skyColor(0x262525).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(biomegenerationsettings$builder.build()).build();
	}
	
	public static Biome makeAPermianDesert() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
				
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.GORGONOPS_ENTITY.get(), 1, 1, 1));
		
		BiomeGenerationSettings.Builder biomegenerationsettings$builder = genSettings(SurfaceBuilderInit.NAKED_PERMIAN_DESERT_SURFACE_BUILDER, ModSurfaceBuilders.PERMIAN_DESERT);
		DefaultBiomeFeatures.addDefaultCarvers(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultOres(biomegenerationsettings$builder);
		
		ModBiomeFeatures.addPermianDesertPlants(biomegenerationsettings$builder);
		ModBiomeFeatures.addCavesAndCanyons(biomegenerationsettings$builder);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.DESERT).depth(0.125F).scale(0.05F).temperature(3.75F).downfall(0.0F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x8e8144).waterColor(0xaf9852).waterFogColor(0x6b6145).fogColor(0xd1c5a1).skyColor(0xb73824).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).ambientParticle(new ParticleEffectAmbience(ParticleInit.PERMIAN_DESERT_AMBIANT_DUST.get(), 0.00625F)).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(biomegenerationsettings$builder.build()).build();
	}
	
	public static Biome makeAFloodBasaltPlains() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
				
		BiomeGenerationSettings.Builder biomegenerationsettings$builder = genSettings(SurfaceBuilderInit.NAKED_FLOOD_BASALT_SURFACE_BUILDER, ModSurfaceBuilders.FLOOD_BASALT_PLAINS);
		DefaultBiomeFeatures.addDefaultCarvers(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultOres(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDesertLakes(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addExtraEmeralds(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDesertLakes(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDesertLakes(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDesertLakes(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDesertLakes(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDesertLakes(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDesertLakes(biomegenerationsettings$builder);

		ModBiomeFeatures.addCavesAndCanyons(biomegenerationsettings$builder);

		return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.PLAINS).depth(0.125F).scale(0.05F).temperature(4.5F).downfall(0.4F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x1c1c1c1c).waterColor(0x545454).waterFogColor(0x4c4c4c).fogColor(0x3f3f3f).skyColor(0x262525).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(biomegenerationsettings$builder.build()).build();
	}
	
	public static Biome makeAPermianPlains() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.GORGONOPS_ENTITY.get(), 2, 1, 1));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.DIMETRODON_ENTITY.get(), 3, 1, 1));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.EDAPHOSAURUS_ENTITY.get(), 1, 7, 20));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.TETRACERATOPS_ENTITY.get(), 3, 1, 1));
		
		BiomeGenerationSettings.Builder biomegenerationsettings$builder = genSettings(SurfaceBuilderInit.NAKED_PERMIAN_PLAINS_SURFACE_BUILDER, ModSurfaceBuilders.PERMIAN_PLAINS);
		DefaultBiomeFeatures.addDefaultCarvers(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultOres(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultLakes(biomegenerationsettings$builder);
		
		ModBiomeFeatures.addPermianPlainsPlants(biomegenerationsettings$builder);
		ModBiomeFeatures.addCavesAndCanyons(biomegenerationsettings$builder);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.PLAINS).depth(0.125F).scale(0.05F).temperature(1.5F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x81b0e2).waterFogColor(0x6795c6).fogColor(0x355177).skyColor(0x50aeed).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(biomegenerationsettings$builder.build()).build();
	}
	
	public static Biome makeAPermianMountains() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.GORGONOPS_ENTITY.get(), 1, 1, 1));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.DIMETRODON_ENTITY.get(), 1, 1, 1));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.EDAPHOSAURUS_ENTITY.get(), 1, 7, 20));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.TETRACERATOPS_ENTITY.get(), 1, 1, 1));
		
		BiomeGenerationSettings.Builder biomegenerationsettings$builder = genSettings(SurfaceBuilderInit.NAKED_PERMIAN_MOUNTAIN_SURFACE_BUILDER, ModSurfaceBuilders.PERMIAN_MOUNTAIN);
		DefaultBiomeFeatures.addDefaultCarvers(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultOres(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultLakes(biomegenerationsettings$builder);
		
		ModBiomeFeatures.addPermianPlainsPlants(biomegenerationsettings$builder);
		ModBiomeFeatures.addCavesAndCanyons(biomegenerationsettings$builder);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.EXTREME_HILLS).depth(1.0F).scale(0.5F).temperature(1.5F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x81b0e2).waterFogColor(0x6795c6).fogColor(0x355177).skyColor(0x50aeed).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(biomegenerationsettings$builder.build()).build();
	}
	
	public static Biome makeAConiferForest() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.DIMETRODON_ENTITY.get(), 1, 1, 1));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.EDAPHOSAURUS_ENTITY.get(), 1, 7, 20));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.TETRACERATOPS_ENTITY.get(), 1, 1, 1));
		
		BiomeGenerationSettings.Builder biomegenerationsettings$builder = genSettings(SurfaceBuilderInit.NAKED_PERMIAN_PLAINS_SURFACE_BUILDER, ModSurfaceBuilders.PERMIAN_PLAINS);
		DefaultBiomeFeatures.addDefaultCarvers(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultOres(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultLakes(biomegenerationsettings$builder);
		
		ModBiomeFeatures.addPermianPlainsPlants(biomegenerationsettings$builder);
		ModBiomeFeatures.addConiferTree(biomegenerationsettings$builder);
		ModBiomeFeatures.addDicksonia(biomegenerationsettings$builder);
		ModBiomeFeatures.addCavesAndCanyons(biomegenerationsettings$builder);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.125F).scale(0.05F).temperature(1.5F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x81b0e2).waterFogColor(0x6795c6).fogColor(0x355177).skyColor(0x50aeed).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(biomegenerationsettings$builder.build()).build();
	}
	
	public static Biome makeAGinkgoForest() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.DIMETRODON_ENTITY.get(), 1, 1, 1));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.EDAPHOSAURUS_ENTITY.get(), 1, 7, 20));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.TETRACERATOPS_ENTITY.get(), 1, 1, 1));
		
		BiomeGenerationSettings.Builder biomegenerationsettings$builder = genSettings(SurfaceBuilderInit.NAKED_PERMIAN_PLAINS_SURFACE_BUILDER, ModSurfaceBuilders.PERMIAN_PLAINS);
		DefaultBiomeFeatures.addDefaultCarvers(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultOres(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
		DefaultBiomeFeatures.addDefaultLakes(biomegenerationsettings$builder);
		
		ModBiomeFeatures.addPermianPlainsPlants(biomegenerationsettings$builder);
		ModBiomeFeatures.addGinkgoTree(biomegenerationsettings$builder);
		ModBiomeFeatures.addDicksonia(biomegenerationsettings$builder);
		ModBiomeFeatures.addCavesAndCanyons(biomegenerationsettings$builder);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.125F).scale(0.05F).temperature(1.5F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x81b0e2).waterFogColor(0x6795c6).fogColor(0x355177).skyColor(0x50aeed).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(biomegenerationsettings$builder.build()).build();
	}
	
	public static Biome makeAPermianOcean() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = (new MobSpawnInfo.Builder());
		
		mobspawninfo$builder.addSpawn(EntityClassification.WATER_AMBIENT, new MobSpawnInfo.Spawners(EntityInit.PALAEONISCUM_ENTITY.get(), 1, 1, 1));
		mobspawninfo$builder.addSpawn(EntityClassification.WATER_CREATURE, new MobSpawnInfo.Spawners(EntityInit.RHINESUCHUS_ENTITY.get(), 1, 1, 1));
		
		BiomeGenerationSettings.Builder biomegenerationsettings$builder = baseOceanGeneration(ConfiguredSurfaceBuilders.FULL_SAND, false, false, true);
		biomegenerationsettings$builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SEAGRASS_DEEP_WARM);
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.RIVER).depth(-1.8F).scale(0.1F).temperature(0.5F).downfall(0.5F).specialEffects((new BiomeAmbience.Builder()).waterColor(4445678).waterFogColor(270131).fogColor(12638463).skyColor(calculateSkyColor(0.5F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(biomegenerationsettings$builder.build()).build();
	}
}
