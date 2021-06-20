package lostworlds.world.biome;

import lostworlds.core.init.EntityInit;
import lostworlds.core.init.ModSurfaceBuilders;
import lostworlds.core.init.ParticleInit;
import lostworlds.core.init.SurfaceBuilderInit;
import lostworlds.core.init.WorldCarverInit;
import net.minecraft.entity.EntityClassification;
import net.minecraft.particles.ParticleTypes;
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

public class ModBiomeMaker 
{	
	private static int calculateSkyColor(float temp) 
	{
		float lvt_1_1_ = temp / 3.0F;
		lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
		return MathHelper.hsvToRgb(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
	}
	
	private static <C extends ISurfaceBuilderConfig> BiomeGenerationSettings.Builder genSettings(SurfaceBuilder<C> surfaceBuilder, C config) 
	{
		return new BiomeGenerationSettings.Builder().surfaceBuilder(surfaceBuilder.configured(config));
	}

	private static BiomeGenerationSettings.Builder baseOceanGeneration(ConfiguredSurfaceBuilder<SurfaceBuilderConfig> p_244225_0_, boolean p_244225_1_, boolean p_244225_2_, boolean p_244225_3_) 
	{
		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(p_244225_0_);
				
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);
		
		return builder;
	}
	
	//Permian
	public static Biome makeAPermianDesert() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
				
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.GORGONOPS_ENTITY.get(), 1, 1, 1));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.DIICTODON_ENTITY.get(), 1, 2, 7));
		
		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.PERMIAN_DESERT_SURFACE_BUILDER);

		ModBiomeFeatures.addPermianDesertPlants(builder);
		ModBiomeFeatures.addPermianOres(builder);
		ModBiomeFeatures.addPermianLavaLakes(builder);
		ModBiomeFeatures.addPermianWaterLakes(builder);
				
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.DESERT).depth(0.125F).scale(0.05F).temperature(3.75F).downfall(0.0F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x8e8144).waterColor(0xaf9852).waterFogColor(0x6b6145).fogColor(0xd1c5a1).skyColor(0xb73824).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).ambientParticle(new ParticleEffectAmbience(ParticleInit.PERMIAN_DESERT_AMBIANT_DUST.get(), 0.00625F)).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	
	public static Biome makeAPermianDesertHills() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
				
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.GORGONOPS_ENTITY.get(), 1, 1, 1));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.DIICTODON_ENTITY.get(), 1, 2, 7));
		
		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.PERMIAN_DESERT_SURFACE_BUILDER);

		ModBiomeFeatures.addPermianDesertPlants(builder);
		ModBiomeFeatures.addPermianOres(builder);
		ModBiomeFeatures.addPermianLavaLakes(builder);
		ModBiomeFeatures.addPermianWaterLakes(builder);
				
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.DESERT).depth(0.45F).scale(0.3F).temperature(3.75F).downfall(0.0F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x8e8144).waterColor(0xaf9852).waterFogColor(0x6b6145).fogColor(0xd1c5a1).skyColor(0xb73824).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).ambientParticle(new ParticleEffectAmbience(ParticleInit.PERMIAN_DESERT_AMBIANT_DUST.get(), 0.00625F)).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	
	public static Biome makeAPermainFloodBasaltPlains() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
				
		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.PERMIAN_FLOOD_BASALT_SURFACE_BUILDER).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.ORE_MAGMA).addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Features.SMALL_BASALT_COLUMNS).addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Features.LARGE_BASALT_COLUMNS).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.BASALT_BLOBS).addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Features.DELTA);

		ModBiomeFeatures.addPermianOres(builder);
		ModBiomeFeatures.addPermianLavaLakes(builder);

		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.PLAINS).depth(0.125F).scale(0.05F).temperature(4.5F).downfall(0.4F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x1c1c1c1c).waterColor(0x545454).waterFogColor(0x4c4c4c).fogColor(0x3f3f3f).skyColor(0x262525).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).ambientParticle(new ParticleEffectAmbience(ParticleTypes.WHITE_ASH, 0.00625F)).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	
	public static Biome makeAPermianPlains() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.GORGONOPS_ENTITY.get(), 2, 1, 1));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.DIMETRODON_ENTITY.get(), 3, 1, 1));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.EDAPHOSAURUS_ENTITY.get(), 1, 7, 20));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.TETRACERATOPS_ENTITY.get(), 3, 1, 1));
		
		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.MOSSY_DIRT_TERRAIN_SURFACE_BUILDER);
		
		ModBiomeFeatures.addSingleConiferTree(builder);
		ModBiomeFeatures.addGroundFerns(builder);
		ModBiomeFeatures.addPermianOres(builder);
		ModBiomeFeatures.addPermianWaterLakes(builder);
		ModBiomeFeatures.addPermianLavaLakes(builder);

		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.PLAINS).depth(0.125F).scale(0.05F).temperature(1.5F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x81b0e2).waterFogColor(0x6795c6).fogColor(0x355177).skyColor(0x50aeed).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	
	public static Biome makeAPermianPlainsHills() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.GORGONOPS_ENTITY.get(), 2, 1, 1));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.DIMETRODON_ENTITY.get(), 3, 1, 1));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.EDAPHOSAURUS_ENTITY.get(), 1, 7, 20));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.TETRACERATOPS_ENTITY.get(), 3, 1, 1));
		
		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.MOSSY_DIRT_TERRAIN_SURFACE_BUILDER);
		
		ModBiomeFeatures.addSingleConiferTree(builder);
		ModBiomeFeatures.addGroundFerns(builder);
		ModBiomeFeatures.addPermianOres(builder);
		ModBiomeFeatures.addPermianWaterLakes(builder);
		ModBiomeFeatures.addPermianLavaLakes(builder);

		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.PLAINS).depth(0.45F).scale(0.3F).temperature(1.5F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x81b0e2).waterFogColor(0x6795c6).fogColor(0x355177).skyColor(0x50aeed).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	
	public static Biome makeAPermianMountains() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.GORGONOPS_ENTITY.get(), 1, 1, 1));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.DIMETRODON_ENTITY.get(), 1, 1, 1));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.EDAPHOSAURUS_ENTITY.get(), 1, 7, 20));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.TETRACERATOPS_ENTITY.get(), 1, 1, 1));
		
		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.PERMIAN_MOUNTAIN_SURFACE_BUILDER);
		
		ModBiomeFeatures.addGroundFerns(builder);
		ModBiomeFeatures.addPermianOres(builder);
		ModBiomeFeatures.addPermianEmerald(builder);
		ModBiomeFeatures.addPermianWaterLakes(builder);
		ModBiomeFeatures.addPermianLavaLakes(builder);

		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.EXTREME_HILLS).depth(1.0F).scale(0.5F).temperature(1.5F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x81b0e2).waterFogColor(0x6795c6).fogColor(0x355177).skyColor(0x50aeed).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	
	public static Biome makeAPermianConiferForest() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.DIMETRODON_ENTITY.get(), 1, 1, 1));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.EDAPHOSAURUS_ENTITY.get(), 1, 7, 20));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.TETRACERATOPS_ENTITY.get(), 1, 1, 1));
		
		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.MOSSY_DIRT_TERRAIN_SURFACE_BUILDER);
		
		ModBiomeFeatures.addFerns(builder);
		ModBiomeFeatures.addConiferTree(builder);
		ModBiomeFeatures.addPermianOres(builder);
		ModBiomeFeatures.addPermianWaterLakes(builder);
		ModBiomeFeatures.addPermianLavaLakes(builder);

		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.125F).scale(0.05F).temperature(1.5F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x81b0e2).waterFogColor(0x6795c6).fogColor(0x355177).skyColor(0x50aeed).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	
	public static Biome makeAPermianConiferForestHills() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.DIMETRODON_ENTITY.get(), 1, 1, 1));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.EDAPHOSAURUS_ENTITY.get(), 1, 7, 20));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.TETRACERATOPS_ENTITY.get(), 1, 1, 1));
		
		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.MOSSY_DIRT_TERRAIN_SURFACE_BUILDER);
		
		ModBiomeFeatures.addFerns(builder);
		ModBiomeFeatures.addConiferTree(builder);
		ModBiomeFeatures.addPermianOres(builder);
		ModBiomeFeatures.addPermianWaterLakes(builder);
		ModBiomeFeatures.addPermianLavaLakes(builder);

		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.45F).scale(0.3F).temperature(1.5F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x81b0e2).waterFogColor(0x6795c6).fogColor(0x355177).skyColor(0x50aeed).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	
	public static Biome makeAPermianGinkgoForest() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.DIMETRODON_ENTITY.get(), 1, 1, 1));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.EDAPHOSAURUS_ENTITY.get(), 1, 7, 20));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.TETRACERATOPS_ENTITY.get(), 1, 1, 1));
		
		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.MOSSY_DIRT_TERRAIN_SURFACE_BUILDER);
		DefaultBiomeFeatures.addDefaultOres(builder);
		DefaultBiomeFeatures.addDefaultSoftDisks(builder);
		
		ModBiomeFeatures.addFerns(builder);
		ModBiomeFeatures.addGinkgoTree(builder);
		ModBiomeFeatures.addPermianOres(builder);
		ModBiomeFeatures.addPermianWaterLakes(builder);
		ModBiomeFeatures.addPermianLavaLakes(builder);

		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.125F).scale(0.05F).temperature(1.5F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x81b0e2).waterFogColor(0x6795c6).fogColor(0x355177).skyColor(0x50aeed).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	
	public static Biome makeAPermianGinkgoForestHills() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.DIMETRODON_ENTITY.get(), 1, 1, 1));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.EDAPHOSAURUS_ENTITY.get(), 1, 7, 20));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.TETRACERATOPS_ENTITY.get(), 1, 1, 1));
		
		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.MOSSY_DIRT_TERRAIN_SURFACE_BUILDER);
		DefaultBiomeFeatures.addDefaultOres(builder);
		DefaultBiomeFeatures.addDefaultSoftDisks(builder);
		
		ModBiomeFeatures.addFerns(builder);
		ModBiomeFeatures.addGinkgoTree(builder);
		ModBiomeFeatures.addPermianOres(builder);
		ModBiomeFeatures.addPermianWaterLakes(builder);
		ModBiomeFeatures.addPermianLavaLakes(builder);

		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.45F).scale(0.3F).temperature(1.5F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x81b0e2).waterFogColor(0x6795c6).fogColor(0x355177).skyColor(0x50aeed).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}

	public static Biome makeAPermianRiver() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
				
		mobspawninfo$builder.addSpawn(EntityClassification.WATER_AMBIENT, new MobSpawnInfo.Spawners(EntityInit.PALAEONISCUM_ENTITY.get(), 1, 4, 5));
		
		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.PERMIAN_DESERT_SURFACE_BUILDER);
		
		ModBiomeFeatures.addPermianOres(builder);
		
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SEAGRASS_RIVER);
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.RIVER).depth(-0.5F).scale(0.0F).temperature(0.5F).downfall(0.5F).specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(calculateSkyColor(0.5F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	
	public static Biome makeAPermianOcean() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = (new MobSpawnInfo.Builder());
		
		mobspawninfo$builder.addSpawn(EntityClassification.WATER_AMBIENT, new MobSpawnInfo.Spawners(EntityInit.PALAEONISCUM_ENTITY.get(), 1, 4, 5));
		
		BiomeGenerationSettings.Builder builder = baseOceanGeneration(ConfiguredSurfaceBuilders.FULL_SAND, false, false, true);
		
		DefaultBiomeFeatures.addDefaultSeagrass(builder);
		DefaultBiomeFeatures.addLukeWarmKelp(builder);

		ModBiomeFeatures.addPermianOres(builder);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.OCEAN).depth(-1.8F).scale(0.1F).temperature(0.5F).downfall(0.5F).specialEffects((new BiomeAmbience.Builder()).waterColor(4445678).waterFogColor(270131).fogColor(12638463).skyColor(calculateSkyColor(0.5F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	
	//Jurassic
	public static Biome makeAJurassicConiferForest() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.ALLOSAURUS_ENTITY.get(), 2, 1, 1));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.KENTROSAURUS_ENTITY.get(), 2, 3, 7));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.OSTROMIA_ENTITY.get(), 2, 1, 3));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.CHILESAURUS_ENTITY.get(), 2, 5, 9));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.PROTOSUCHUS_ENTITY.get(), 2, 1, 1));
		
		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.MOSSY_DIRT_TERRAIN_SURFACE_BUILDER);
		
		ModBiomeFeatures.addConiferTree(builder);
		ModBiomeFeatures.addAllJurassicPlants(builder);
		ModBiomeFeatures.addJurassicOres(builder);
		ModBiomeFeatures.addJurassicWaterLakes(builder);
		ModBiomeFeatures.addJurassicLavaLakes(builder);

		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.125F).scale(0.05F).temperature(1.0F).downfall(0.9F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x1b6cb7).waterFogColor(0x1560a5).fogColor(0x355177).skyColor(0x1b4266).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	
	public static Biome makeAJurassicConiferForestHills() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.ALLOSAURUS_ENTITY.get(), 2, 1, 1));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.KENTROSAURUS_ENTITY.get(), 2, 3, 7));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.OSTROMIA_ENTITY.get(), 2, 1, 3));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.CHILESAURUS_ENTITY.get(), 2, 5, 9));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.PROTOSUCHUS_ENTITY.get(), 2, 1, 1));
		
		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.MOSSY_DIRT_TERRAIN_SURFACE_BUILDER);
		
		ModBiomeFeatures.addConiferTree(builder);
		ModBiomeFeatures.addAllJurassicPlants(builder);
		ModBiomeFeatures.addJurassicOres(builder);
		ModBiomeFeatures.addJurassicWaterLakes(builder);
		ModBiomeFeatures.addJurassicLavaLakes(builder);

		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.45F).scale(0.3F).temperature(1.0F).downfall(0.9F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x1b6cb7).waterFogColor(0x1560a5).fogColor(0x355177).skyColor(0x1b4266).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	
	public static Biome makeAJurassicGinkgoForest() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.ALLOSAURUS_ENTITY.get(), 2, 1, 1));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.KENTROSAURUS_ENTITY.get(), 2, 3, 7));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.OSTROMIA_ENTITY.get(), 2, 1, 3));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.CHILESAURUS_ENTITY.get(), 2, 5, 9));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.PROTOSUCHUS_ENTITY.get(), 2, 1, 1));
		
		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.MOSSY_DIRT_TERRAIN_SURFACE_BUILDER);
		
		ModBiomeFeatures.addGinkgoTree(builder);
		ModBiomeFeatures.addAllJurassicPlants(builder);
		ModBiomeFeatures.addJurassicOres(builder);
		ModBiomeFeatures.addJurassicWaterLakes(builder);
		ModBiomeFeatures.addJurassicLavaLakes(builder);

		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.125F).scale(0.05F).temperature(1.0F).downfall(0.9F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x1b6cb7).waterFogColor(0x1560a5).fogColor(0x355177).skyColor(0x1b4266).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	
	public static Biome makeAJurassicGinkgoForestHills() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.ALLOSAURUS_ENTITY.get(), 2, 1, 1));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.KENTROSAURUS_ENTITY.get(), 2, 3, 7));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.OSTROMIA_ENTITY.get(), 2, 1, 3));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.CHILESAURUS_ENTITY.get(), 2, 5, 9));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.PROTOSUCHUS_ENTITY.get(), 2, 1, 1));
		
		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.MOSSY_DIRT_TERRAIN_SURFACE_BUILDER);
		
		ModBiomeFeatures.addGinkgoTree(builder);
		ModBiomeFeatures.addAllJurassicPlants(builder);
		ModBiomeFeatures.addJurassicOres(builder);
		ModBiomeFeatures.addJurassicWaterLakes(builder);
		ModBiomeFeatures.addJurassicLavaLakes(builder);

		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.45F).scale(0.3F).temperature(1.0F).downfall(0.9F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x1b6cb7).waterFogColor(0x1560a5).fogColor(0x355177).skyColor(0x1b4266).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	
	public static Biome makeAJurassicAraucariaForest() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.ALLOSAURUS_ENTITY.get(), 2, 1, 1));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.KENTROSAURUS_ENTITY.get(), 2, 3, 7));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.OSTROMIA_ENTITY.get(), 2, 1, 3));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.CHILESAURUS_ENTITY.get(), 2, 5, 9));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.PROTOSUCHUS_ENTITY.get(), 2, 1, 1));
		
		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.MOSSY_DIRT_TERRAIN_SURFACE_BUILDER);
		
		ModBiomeFeatures.addAraucariaTree(builder);
		ModBiomeFeatures.addAllJurassicPlants(builder);
		ModBiomeFeatures.addJurassicOres(builder);
		ModBiomeFeatures.addJurassicWaterLakes(builder);
		ModBiomeFeatures.addJurassicLavaLakes(builder);

		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.SAVANNA).depth(0.125F).scale(0.05F).temperature(1.2F).downfall(0.0F).specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(0x1b4266).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	
	public static Biome makeAJurassicAraucariaForestHills() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.ALLOSAURUS_ENTITY.get(), 2, 1, 1));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.KENTROSAURUS_ENTITY.get(), 2, 3, 7));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.OSTROMIA_ENTITY.get(), 2, 1, 3));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.CHILESAURUS_ENTITY.get(), 2, 5, 9));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.PROTOSUCHUS_ENTITY.get(), 2, 1, 1));
		
		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.MOSSY_DIRT_TERRAIN_SURFACE_BUILDER);
		
		ModBiomeFeatures.addAraucariaTree(builder);
		ModBiomeFeatures.addAllJurassicPlants(builder);
		ModBiomeFeatures.addJurassicOres(builder);
		ModBiomeFeatures.addJurassicWaterLakes(builder);
		ModBiomeFeatures.addJurassicLavaLakes(builder);

		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.SAVANNA).depth(0.45F).scale(0.3F).temperature(1.2F).downfall(0.0F).specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(0x1b4266).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	
	public static Biome makeAJurassicPlains() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.ALLOSAURUS_ENTITY.get(), 2, 1, 1));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.KENTROSAURUS_ENTITY.get(), 2, 3, 7));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.OSTROMIA_ENTITY.get(), 2, 1, 3));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.CHILESAURUS_ENTITY.get(), 2, 5, 9));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.PROTOSUCHUS_ENTITY.get(), 2, 1, 1));
		
		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.MOSSY_DIRT_TERRAIN_SURFACE_BUILDER);
		
		ModBiomeFeatures.addJurassicWaterLakes(builder);
		ModBiomeFeatures.addAllJurassicPlants(builder);
		ModBiomeFeatures.addJurassicOres(builder);
		ModBiomeFeatures.addJurassicWaterLakes(builder);
		ModBiomeFeatures.addJurassicLavaLakes(builder);

		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.PLAINS).depth(0.125F).scale(0.05F).temperature(1.5F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x1b6cb7).waterFogColor(0x1560a5).fogColor(0x355177).skyColor(0x1b4266).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	public static Biome makeAJurassicPlainsHills() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.ALLOSAURUS_ENTITY.get(), 2, 1, 1));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.KENTROSAURUS_ENTITY.get(), 2, 3, 7));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.OSTROMIA_ENTITY.get(), 2, 1, 3));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.CHILESAURUS_ENTITY.get(), 2, 5, 9));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.PROTOSUCHUS_ENTITY.get(), 2, 1, 1));
		
		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.MOSSY_DIRT_TERRAIN_SURFACE_BUILDER);
		
		ModBiomeFeatures.addJurassicWaterLakes(builder);
		ModBiomeFeatures.addAllJurassicPlants(builder);
		ModBiomeFeatures.addJurassicOres(builder);
		ModBiomeFeatures.addJurassicWaterLakes(builder);
		ModBiomeFeatures.addJurassicLavaLakes(builder);

		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.PLAINS).depth(0.45F).scale(0.3F).temperature(1.5F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x1b6cb7).waterFogColor(0x1560a5).fogColor(0x355177).skyColor(0x1b4266).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	
	public static Biome makeAJurassicMountains() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.CRYOLOPHOSAURUS_ENTITY.get(), 2, 2, 3));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.KENTROSAURUS_ENTITY.get(), 2, 3, 7));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.OSTROMIA_ENTITY.get(), 2, 1, 3));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.CHILESAURUS_ENTITY.get(), 2, 5, 9));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.PROTOSUCHUS_ENTITY.get(), 2, 1, 1));
		
		BiomeGenerationSettings.Builder builder = genSettings(SurfaceBuilderInit.NAKED_JURASSIC_MOUNTAIN, ModSurfaceBuilders.JURASSIC_STONE_MOUNTAIN_CONFIG);
		
		ModBiomeFeatures.addJurassicWaterLakes(builder);
		ModBiomeFeatures.addJurassicOres(builder);
		ModBiomeFeatures.addJurassicWaterLakes(builder);
		ModBiomeFeatures.addJurassicLavaLakes(builder);

		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.EXTREME_HILLS).depth(1.0F).scale(0.5F).temperature(1.5F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x1b6cb7).waterFogColor(0x1560a5).fogColor(0x355177).skyColor(0x1b4266).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	
	public static Biome makeAErrodedMountains() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.CRYOLOPHOSAURUS_ENTITY.get(), 2, 2, 3));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.KENTROSAURUS_ENTITY.get(), 2, 3, 7));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.OSTROMIA_ENTITY.get(), 2, 1, 3));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.CHILESAURUS_ENTITY.get(), 2, 5, 9));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.PROTOSUCHUS_ENTITY.get(), 2, 1, 1));
		
		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.JURASSIC_ERRODED_MOUNTAIN_SURFACE_BUILDER);
		
		ModBiomeFeatures.addJurassicWaterLakes(builder);
		ModBiomeFeatures.addJurassicOres(builder);
		ModBiomeFeatures.addJurassicWaterLakes(builder);
		ModBiomeFeatures.addJurassicLavaLakes(builder);


		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.EXTREME_HILLS).depth(1.0F).scale(0.5F).temperature(1.5F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x1b6cb7).waterFogColor(0x1560a5).fogColor(0x355177).skyColor(0x1b4266).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	
	public static Biome makeAJurassicDesert() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.ALLOSAURUS_ENTITY.get(), 2, 1, 1));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.KENTROSAURUS_ENTITY.get(), 2, 3, 7));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.OSTROMIA_ENTITY.get(), 2, 1, 3));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.CHILESAURUS_ENTITY.get(), 2, 5, 9));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.PROTOSUCHUS_ENTITY.get(), 2, 1, 1));
		
		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.GRAVEL_TERRAIN_SURFACE_BUILDER);

		ModBiomeFeatures.addJurassicOres(builder);
		ModBiomeFeatures.addJurassicWaterLakes(builder);
		ModBiomeFeatures.addJurassicLavaLakes(builder);

		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.DESERT).depth(0.125F).scale(0.05F).temperature(3.75F).downfall(0.0F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x8e8144).waterColor(0x1b6cb7).waterFogColor(0x1560a5).fogColor(0x355177).skyColor(0x1b4266).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	
	public static Biome makeAJurassicDesertHills() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.ALLOSAURUS_ENTITY.get(), 2, 1, 1));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.KENTROSAURUS_ENTITY.get(), 2, 3, 7));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.OSTROMIA_ENTITY.get(), 2, 1, 3));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.CHILESAURUS_ENTITY.get(), 2, 5, 9));
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.PROTOSUCHUS_ENTITY.get(), 2, 1, 1));
		
		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.GRAVEL_TERRAIN_SURFACE_BUILDER);

		ModBiomeFeatures.addJurassicOres(builder);
		ModBiomeFeatures.addJurassicWaterLakes(builder);
		ModBiomeFeatures.addJurassicLavaLakes(builder);

		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.DESERT).depth(0.45F).scale(0.3F).temperature(3.75F).downfall(0.0F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x8e8144).waterColor(0x1b6cb7).waterFogColor(0x1560a5).fogColor(0x355177).skyColor(0x1b4266).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	
	public static Biome makeAJurassicRiver() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
						
		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.GRAVEL_TERRAIN_SURFACE_BUILDER);
		
		ModBiomeFeatures.addJurassicOres(builder);
			
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.RIVER).depth(-0.5F).scale(0.0F).temperature(0.5F).downfall(0.5F).specialEffects((new BiomeAmbience.Builder()).waterColor(0x1b6cb7).waterFogColor(0x1560a5).fogColor(0x355177).skyColor(0x1b4266).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	
	public static Biome makeAJurassicIslands() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		
		mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.PROTOSUCHUS_ENTITY.get(), 2, 1, 1));
		
		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.ISLANDS_SURFACE_BUILDER);
		
		DefaultBiomeFeatures.addDefaultSeagrass(builder);
		
		ModBiomeFeatures.addAllJurassicPlants(builder);
		ModBiomeFeatures.addJurassicOres(builder);
		ModBiomeFeatures.addJurassicWaterLakes(builder);
		ModBiomeFeatures.addJurassicLavaLakes(builder);

		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.SWAMP).depth(-0.2F).scale(0.1F).temperature(1.5F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x1b6cb7).waterFogColor(0x1560a5).fogColor(0x355177).skyColor(0x1b4266).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	
	public static Biome makeAJurassicShore() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		
		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.JURASSIC_STONE_TERRAIN_SURFACE_BUILDER);
				
		ModBiomeFeatures.addAllJurassicPlants(builder);
		ModBiomeFeatures.addJurassicOres(builder);
		ModBiomeFeatures.addJurassicWaterLakes(builder);
		ModBiomeFeatures.addJurassicLavaLakes(builder);

		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.BEACH).depth(0.1F).scale(0.8F).temperature(1.5F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x1b6cb7).waterFogColor(0x1560a5).fogColor(0x355177).skyColor(0x1b4266).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	
	public static Biome makeAJurassicOcean() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = (new MobSpawnInfo.Builder());
				
		BiomeGenerationSettings.Builder builder = baseOceanGeneration(ModSurfaceBuilders.JURASSIC_OCEAN_SURFACE_BUILDER, false, false, true);
		
		DefaultBiomeFeatures.addDefaultSeagrass(builder);
		DefaultBiomeFeatures.addLukeWarmKelp(builder);
		
		ModBiomeFeatures.addJurassicOres(builder);

		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.OCEAN).depth(-1.8F).scale(0.1F).temperature(0.5F).downfall(0.5F).specialEffects((new BiomeAmbience.Builder()).waterColor(0x1b6cb7).waterFogColor(0x1560a5).fogColor(0x355177).skyColor(0x1b4266).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}

	//Overworld
	public static Biome makeAOverworldConiferForest() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		DefaultBiomeFeatures.farmAnimals(mobspawninfo$builder);
		DefaultBiomeFeatures.commonSpawns(mobspawninfo$builder);

		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);
		DefaultBiomeFeatures.addDefaultOverworldLandStructures(builder);
		builder.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
		DefaultBiomeFeatures.addDefaultCarvers(builder);
		DefaultBiomeFeatures.addDefaultLakes(builder);
		DefaultBiomeFeatures.addDefaultMonsterRoom(builder);
		DefaultBiomeFeatures.addForestFlowers(builder);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(builder);
		DefaultBiomeFeatures.addDefaultOres(builder);
		DefaultBiomeFeatures.addDefaultSoftDisks(builder);
		DefaultBiomeFeatures.addDefaultGrass(builder);
		DefaultBiomeFeatures.addDefaultMushrooms(builder);
		DefaultBiomeFeatures.addDefaultExtraVegetation(builder);
		DefaultBiomeFeatures.addDefaultSprings(builder);
		DefaultBiomeFeatures.addSurfaceFreezing(builder);

		ModBiomeFeatures.addConiferTree(builder);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.1F).scale(0.2F).temperature(0.7F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(calculateSkyColor(0.7F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	
	public static Biome makeAOverworldConiferForestHills() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		DefaultBiomeFeatures.farmAnimals(mobspawninfo$builder);
		DefaultBiomeFeatures.commonSpawns(mobspawninfo$builder);

		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);
		DefaultBiomeFeatures.addDefaultOverworldLandStructures(builder);
		builder.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
		DefaultBiomeFeatures.addDefaultCarvers(builder);
		DefaultBiomeFeatures.addDefaultLakes(builder);
		DefaultBiomeFeatures.addDefaultMonsterRoom(builder);
		DefaultBiomeFeatures.addForestFlowers(builder);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(builder);
		DefaultBiomeFeatures.addDefaultOres(builder);
		DefaultBiomeFeatures.addDefaultSoftDisks(builder);
		DefaultBiomeFeatures.addDefaultGrass(builder);
		DefaultBiomeFeatures.addDefaultMushrooms(builder);
		DefaultBiomeFeatures.addDefaultExtraVegetation(builder);
		DefaultBiomeFeatures.addDefaultSprings(builder);
		DefaultBiomeFeatures.addSurfaceFreezing(builder);

		ModBiomeFeatures.addConiferTree(builder);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.45F).scale(0.3F).temperature(0.7F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(calculateSkyColor(0.7F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	
	public static Biome makeAOverworldGinkgoForest() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		DefaultBiomeFeatures.farmAnimals(mobspawninfo$builder);
		DefaultBiomeFeatures.commonSpawns(mobspawninfo$builder);

		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);
		DefaultBiomeFeatures.addDefaultOverworldLandStructures(builder);
		builder.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
		DefaultBiomeFeatures.addDefaultCarvers(builder);
		DefaultBiomeFeatures.addDefaultLakes(builder);
		DefaultBiomeFeatures.addDefaultMonsterRoom(builder);
		DefaultBiomeFeatures.addForestFlowers(builder);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(builder);
		DefaultBiomeFeatures.addDefaultOres(builder);
		DefaultBiomeFeatures.addDefaultSoftDisks(builder);
		DefaultBiomeFeatures.addDefaultGrass(builder);
		DefaultBiomeFeatures.addDefaultMushrooms(builder);
		DefaultBiomeFeatures.addDefaultExtraVegetation(builder);
		DefaultBiomeFeatures.addDefaultSprings(builder);
		DefaultBiomeFeatures.addSurfaceFreezing(builder);

		ModBiomeFeatures.addGinkgoTree(builder);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.1F).scale(0.2F).temperature(0.7F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(calculateSkyColor(0.7F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	
	public static Biome makeAOverworldGinkgoForestHills() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		DefaultBiomeFeatures.farmAnimals(mobspawninfo$builder);
		DefaultBiomeFeatures.commonSpawns(mobspawninfo$builder);

		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);
		DefaultBiomeFeatures.addDefaultOverworldLandStructures(builder);
		builder.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
		DefaultBiomeFeatures.addDefaultCarvers(builder);
		DefaultBiomeFeatures.addDefaultLakes(builder);
		DefaultBiomeFeatures.addDefaultMonsterRoom(builder);
		DefaultBiomeFeatures.addForestFlowers(builder);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(builder);
		DefaultBiomeFeatures.addDefaultOres(builder);
		DefaultBiomeFeatures.addDefaultSoftDisks(builder);
		DefaultBiomeFeatures.addDefaultGrass(builder);
		DefaultBiomeFeatures.addDefaultMushrooms(builder);
		DefaultBiomeFeatures.addDefaultExtraVegetation(builder);
		DefaultBiomeFeatures.addDefaultSprings(builder);
		DefaultBiomeFeatures.addSurfaceFreezing(builder);

		ModBiomeFeatures.addGinkgoTree(builder);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.45F).scale(0.3F).temperature(0.7F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(calculateSkyColor(0.7F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	
	public static Biome makeAOverworldAraucariaForest() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		DefaultBiomeFeatures.farmAnimals(mobspawninfo$builder);
		DefaultBiomeFeatures.commonSpawns(mobspawninfo$builder);

		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);
		DefaultBiomeFeatures.addDefaultOverworldLandStructures(builder);
		builder.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
		DefaultBiomeFeatures.addDefaultCarvers(builder);
		DefaultBiomeFeatures.addDefaultLakes(builder);
		DefaultBiomeFeatures.addDefaultMonsterRoom(builder);
		DefaultBiomeFeatures.addForestFlowers(builder);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(builder);
		DefaultBiomeFeatures.addDefaultOres(builder);
		DefaultBiomeFeatures.addDefaultSoftDisks(builder);
		DefaultBiomeFeatures.addDefaultGrass(builder);
		DefaultBiomeFeatures.addDefaultMushrooms(builder);
		DefaultBiomeFeatures.addDefaultExtraVegetation(builder);
		DefaultBiomeFeatures.addDefaultSprings(builder);
		DefaultBiomeFeatures.addSurfaceFreezing(builder);

		ModBiomeFeatures.addAraucariaTree(builder);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.1F).scale(0.2F).temperature(0.7F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(calculateSkyColor(0.7F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	
	public static Biome makeAOverworldAraucariaForestHills() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		DefaultBiomeFeatures.farmAnimals(mobspawninfo$builder);
		DefaultBiomeFeatures.commonSpawns(mobspawninfo$builder);

		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);
		DefaultBiomeFeatures.addDefaultOverworldLandStructures(builder);
		builder.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
		DefaultBiomeFeatures.addDefaultCarvers(builder);
		DefaultBiomeFeatures.addDefaultLakes(builder);
		DefaultBiomeFeatures.addDefaultMonsterRoom(builder);
		DefaultBiomeFeatures.addForestFlowers(builder);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(builder);
		DefaultBiomeFeatures.addDefaultOres(builder);
		DefaultBiomeFeatures.addDefaultSoftDisks(builder);
		DefaultBiomeFeatures.addDefaultGrass(builder);
		DefaultBiomeFeatures.addDefaultMushrooms(builder);
		DefaultBiomeFeatures.addDefaultExtraVegetation(builder);
		DefaultBiomeFeatures.addDefaultSprings(builder);
		DefaultBiomeFeatures.addSurfaceFreezing(builder);

		ModBiomeFeatures.addAraucariaTree(builder);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.45F).scale(0.3F).temperature(0.7F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(calculateSkyColor(0.7F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
	
	public static Biome makeAVolcanoBiome() 
	{
		MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
		DefaultBiomeFeatures.commonSpawns(mobspawninfo$builder);
		
		BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.VOLCANO_SURFACE_BUILDER);
		DefaultBiomeFeatures.addDefaultOverworldLandStructures(builder);
		builder.addStructureStart(StructureFeatures.RUINED_PORTAL_MOUNTAIN);
		DefaultBiomeFeatures.addDefaultCarvers(builder);
		DefaultBiomeFeatures.addDefaultMonsterRoom(builder);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(builder);
		DefaultBiomeFeatures.addDefaultOres(builder);
		DefaultBiomeFeatures.addDefaultSoftDisks(builder);
		DefaultBiomeFeatures.addExtraEmeralds(builder);
		DefaultBiomeFeatures.addDesertLakes(builder);
		
		builder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_VOLCANO_CAVES);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.EXTREME_HILLS).depth(1.0F).scale(0.5F).temperature(5.0F).downfall(0.3F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x777777).waterColor(0x6c777a).waterFogColor(0x555e60).fogColor(0x2f3030).skyColor(0x4b5a60).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).ambientParticle(new ParticleEffectAmbience(ParticleTypes.WHITE_ASH, 0.00625F)).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(builder.build()).build();
	}
}
