package library.biome;

import api.core.init.EntityInit;
import api.core.init.ModSurfaceBuilders;
import api.core.init.SurfaceBuilderInit;
import api.core.init.WorldCarverInit;
import net.minecraft.entity.EntityClassification;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
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
		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(p_244225_0_);
				
		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);
		
		return generationBuilder;
	}
	
	//Permian Bits
	private static BiomeGenerationSettings.Builder permianBits(BiomeGenerationSettings.Builder generationBuilder)
	{
		ModBiomeFeatures.addPermianOres(generationBuilder);
		ModBiomeFeatures.addPermianLavaLakes(generationBuilder);
		ModBiomeFeatures.addPermianWaterLakes(generationBuilder);
		
		return generationBuilder;
	}
	
	//Basic Biome Settings
	private static Biome baseBiome(MobSpawnInfo.Builder spawngenerationBuilder, BiomeGenerationSettings.Builder generationBuilder, RainType rain, Category category, float depth, float scale, float temperature, float downfall, int grassColour, int waterColour, int waterFogColour, int fogColour, int skyColour)
	{
		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);
		
		return (new Biome.Builder()).precipitation(rain).biomeCategory(category).depth(depth).scale(scale).temperature(temperature).downfall(downfall).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(grassColour).waterColor(waterColour).waterFogColor(waterFogColour).fogColor(fogColour).skyColor(skyColour).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build(); //0.00625F
	}
	
	//Permian Biomes
	public static Biome makeAPermianDesert() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = new MobSpawnInfo.Builder();
				
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.GORGONOPS_ENTITY.get(), 1, 1, 1));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.DIICTODON_ENTITY.get(), 1, 2, 7));
		
		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.PERMIAN_DESERT_SURFACE_BUILDER);

		ModBiomeFeatures.addPermianDesertPlants(generationBuilder);
		permianBits(generationBuilder);
		
		return baseBiome(spawngenerationBuilder, generationBuilder, RainType.NONE, Category.DESERT, 0.125F, 0.02F, 3.75F, 0.0F, 0x8e8144, 0xaf9852, 0x6b6145, 0xd1c5a1, 0xb73824);
	}
	
	public static Biome makeAPermianDesertHills() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = new MobSpawnInfo.Builder();
				
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.GORGONOPS_ENTITY.get(), 1, 1, 1));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.DIICTODON_ENTITY.get(), 1, 2, 7));
		
		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.PERMIAN_DESERT_SURFACE_BUILDER);

		ModBiomeFeatures.addPermianDesertPlants(generationBuilder);
		permianBits(generationBuilder);
		
		return baseBiome(spawngenerationBuilder, generationBuilder, RainType.NONE, Category.DESERT, 0.125F, 0.05F, 3.75F, 0.0F, 0x8e8144, 0xaf9852, 0x6b6145, 0xd1c5a1, 0xb73824);
	}
	
	public static Biome makeAPermainFloodBasaltPlains() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = new MobSpawnInfo.Builder();
				
		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.PERMIAN_FLOOD_BASALT_SURFACE_BUILDER).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.ORE_MAGMA).addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Features.SMALL_BASALT_COLUMNS).addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Features.LARGE_BASALT_COLUMNS).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.BASALT_BLOBS).addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Features.DELTA);

		ModBiomeFeatures.addPermianOres(generationBuilder);
		ModBiomeFeatures.addPermianLavaLakes(generationBuilder);

		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.PLAINS).depth(0.125F).scale(0.05F).temperature(4.5F).downfall(0.4F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x1c1c1c1c).waterColor(0x545454).waterFogColor(0x4c4c4c).fogColor(0x3f3f3f).skyColor(0x262525).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).ambientParticle(new ParticleEffectAmbience(ParticleTypes.WHITE_ASH, 0.00625F)).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome makeAPermianPlains() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = new MobSpawnInfo.Builder();
		
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.GORGONOPS_ENTITY.get(), 2, 1, 1));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.DIMETRODON_ENTITY.get(), 3, 1, 1));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.EDAPHOSAURUS_ENTITY.get(), 1, 7, 20));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.TETRACERATOPS_ENTITY.get(), 3, 1, 1));
		
		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.MOSSY_DIRT_TERRAIN_SURFACE_BUILDER);
		
		ModBiomeFeatures.addSingleConiferTree(generationBuilder);
		ModBiomeFeatures.addGroundFerns(generationBuilder);
		ModBiomeFeatures.addPermianOres(generationBuilder);
		ModBiomeFeatures.addPermianWaterLakes(generationBuilder);
		ModBiomeFeatures.addPermianLavaLakes(generationBuilder);

		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.PLAINS).depth(0.125F).scale(0.05F).temperature(1.5F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x81b0e2).waterFogColor(0x6795c6).fogColor(0x355177).skyColor(0x50aeed).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome makeAPermianPlainsHills() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = new MobSpawnInfo.Builder();
		
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.GORGONOPS_ENTITY.get(), 2, 1, 1));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.DIMETRODON_ENTITY.get(), 3, 1, 1));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.EDAPHOSAURUS_ENTITY.get(), 1, 7, 20));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.TETRACERATOPS_ENTITY.get(), 3, 1, 1));
		
		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.MOSSY_DIRT_TERRAIN_SURFACE_BUILDER);
		
		ModBiomeFeatures.addSingleConiferTree(generationBuilder);
		ModBiomeFeatures.addGroundFerns(generationBuilder);
		ModBiomeFeatures.addPermianOres(generationBuilder);
		ModBiomeFeatures.addPermianWaterLakes(generationBuilder);
		ModBiomeFeatures.addPermianLavaLakes(generationBuilder);

		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.PLAINS).depth(0.45F).scale(0.3F).temperature(1.5F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x81b0e2).waterFogColor(0x6795c6).fogColor(0x355177).skyColor(0x50aeed).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome makeAPermianMountains() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = new MobSpawnInfo.Builder();
		
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.GORGONOPS_ENTITY.get(), 1, 1, 1));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.DIMETRODON_ENTITY.get(), 1, 1, 1));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.EDAPHOSAURUS_ENTITY.get(), 1, 7, 20));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.TETRACERATOPS_ENTITY.get(), 1, 1, 1));
		
		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.PERMIAN_MOUNTAIN_SURFACE_BUILDER);
		
		ModBiomeFeatures.addGroundFerns(generationBuilder);
		ModBiomeFeatures.addPermianOres(generationBuilder);
		ModBiomeFeatures.addPermianEmerald(generationBuilder);
		ModBiomeFeatures.addPermianWaterLakes(generationBuilder);
		ModBiomeFeatures.addPermianLavaLakes(generationBuilder);

		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.EXTREME_HILLS).depth(1.0F).scale(0.5F).temperature(1.5F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x81b0e2).waterFogColor(0x6795c6).fogColor(0x355177).skyColor(0x50aeed).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome makeAPermianConiferForest() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = new MobSpawnInfo.Builder();
		
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.DIMETRODON_ENTITY.get(), 1, 1, 1));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.EDAPHOSAURUS_ENTITY.get(), 1, 7, 20));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.TETRACERATOPS_ENTITY.get(), 1, 1, 1));
		
		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.MOSSY_DIRT_TERRAIN_SURFACE_BUILDER);
		
		ModBiomeFeatures.addFerns(generationBuilder);
		ModBiomeFeatures.addConiferTree(generationBuilder);
		ModBiomeFeatures.addPermianOres(generationBuilder);
		ModBiomeFeatures.addPermianWaterLakes(generationBuilder);
		ModBiomeFeatures.addPermianLavaLakes(generationBuilder);

		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.125F).scale(0.05F).temperature(1.5F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x81b0e2).waterFogColor(0x6795c6).fogColor(0x355177).skyColor(0x50aeed).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome makeAPermianConiferForestHills() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = new MobSpawnInfo.Builder();
		
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.DIMETRODON_ENTITY.get(), 1, 1, 1));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.EDAPHOSAURUS_ENTITY.get(), 1, 7, 20));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.TETRACERATOPS_ENTITY.get(), 1, 1, 1));
		
		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.MOSSY_DIRT_TERRAIN_SURFACE_BUILDER);
		
		ModBiomeFeatures.addFerns(generationBuilder);
		ModBiomeFeatures.addConiferTree(generationBuilder);
		ModBiomeFeatures.addPermianOres(generationBuilder);
		ModBiomeFeatures.addPermianWaterLakes(generationBuilder);
		ModBiomeFeatures.addPermianLavaLakes(generationBuilder);

		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.45F).scale(0.3F).temperature(1.5F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x81b0e2).waterFogColor(0x6795c6).fogColor(0x355177).skyColor(0x50aeed).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome makeAPermianGinkgoForest() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = new MobSpawnInfo.Builder();
		
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.DIMETRODON_ENTITY.get(), 1, 1, 1));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.EDAPHOSAURUS_ENTITY.get(), 1, 7, 20));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.TETRACERATOPS_ENTITY.get(), 1, 1, 1));
		
		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.MOSSY_DIRT_TERRAIN_SURFACE_BUILDER);
		DefaultBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		
		ModBiomeFeatures.addFerns(generationBuilder);
		ModBiomeFeatures.addGinkgoTree(generationBuilder);
		ModBiomeFeatures.addPermianOres(generationBuilder);
		ModBiomeFeatures.addPermianWaterLakes(generationBuilder);
		ModBiomeFeatures.addPermianLavaLakes(generationBuilder);

		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.125F).scale(0.05F).temperature(1.5F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x81b0e2).waterFogColor(0x6795c6).fogColor(0x355177).skyColor(0x50aeed).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome makeAPermianGinkgoForestHills() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = new MobSpawnInfo.Builder();
		
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.DIMETRODON_ENTITY.get(), 1, 1, 1));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.EDAPHOSAURUS_ENTITY.get(), 1, 7, 20));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.TETRACERATOPS_ENTITY.get(), 1, 1, 1));
		
		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.MOSSY_DIRT_TERRAIN_SURFACE_BUILDER);
		DefaultBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		
		ModBiomeFeatures.addFerns(generationBuilder);
		ModBiomeFeatures.addGinkgoTree(generationBuilder);
		ModBiomeFeatures.addPermianOres(generationBuilder);
		ModBiomeFeatures.addPermianWaterLakes(generationBuilder);
		ModBiomeFeatures.addPermianLavaLakes(generationBuilder);

		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.45F).scale(0.3F).temperature(1.5F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x81b0e2).waterFogColor(0x6795c6).fogColor(0x355177).skyColor(0x50aeed).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build();
	}

	public static Biome makeAPermianRiver() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = new MobSpawnInfo.Builder();
				
		spawngenerationBuilder.addSpawn(EntityClassification.WATER_AMBIENT, new MobSpawnInfo.Spawners(EntityInit.PALAEONISCUM_ENTITY.get(), 1, 4, 5));
		
		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.PERMIAN_DESERT_SURFACE_BUILDER);
		
		ModBiomeFeatures.addPermianOres(generationBuilder);
		
		generationBuilder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SEAGRASS_RIVER);
		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.RIVER).depth(-0.5F).scale(0.0F).temperature(0.5F).downfall(0.5F).specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(calculateSkyColor(0.5F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome makeAPermianOcean() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = (new MobSpawnInfo.Builder());
		
		spawngenerationBuilder.addSpawn(EntityClassification.WATER_AMBIENT, new MobSpawnInfo.Spawners(EntityInit.PALAEONISCUM_ENTITY.get(), 1, 4, 5));
		
		BiomeGenerationSettings.Builder generationBuilder = baseOceanGeneration(ConfiguredSurfaceBuilders.FULL_SAND, false, false, true);
		
		DefaultBiomeFeatures.addDefaultSeagrass(generationBuilder);
		DefaultBiomeFeatures.addLukeWarmKelp(generationBuilder);

		ModBiomeFeatures.addPermianOres(generationBuilder);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.OCEAN).depth(-1.8F).scale(0.1F).temperature(0.5F).downfall(0.5F).specialEffects((new BiomeAmbience.Builder()).waterColor(4445678).waterFogColor(270131).fogColor(12638463).skyColor(calculateSkyColor(0.5F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	//Jurassic
	public static Biome makeAJurassicConiferForest() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = new MobSpawnInfo.Builder();
		
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.ALLOSAURUS_ENTITY.get(), 2, 1, 1));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.KENTROSAURUS_ENTITY.get(), 2, 3, 7));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.OSTROMIA_ENTITY.get(), 2, 1, 3));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.CHILESAURUS_ENTITY.get(), 2, 5, 9));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.PROTOSUCHUS_ENTITY.get(), 2, 1, 1));
		
		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.MOSSY_DIRT_TERRAIN_SURFACE_BUILDER);
		
		ModBiomeFeatures.addConiferTree(generationBuilder);
		ModBiomeFeatures.addAllJurassicPlants(generationBuilder);
		ModBiomeFeatures.addJurassicOres(generationBuilder);
		ModBiomeFeatures.addJurassicWaterLakes(generationBuilder);
		ModBiomeFeatures.addJurassicLavaLakes(generationBuilder);

		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.125F).scale(0.05F).temperature(1.0F).downfall(0.9F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x1b6cb7).waterFogColor(0x1560a5).fogColor(0x355177).skyColor(0x1b4266).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome makeAJurassicConiferForestHills() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = new MobSpawnInfo.Builder();
		
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.ALLOSAURUS_ENTITY.get(), 2, 1, 1));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.KENTROSAURUS_ENTITY.get(), 2, 3, 7));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.OSTROMIA_ENTITY.get(), 2, 1, 3));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.CHILESAURUS_ENTITY.get(), 2, 5, 9));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.PROTOSUCHUS_ENTITY.get(), 2, 1, 1));
		
		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.MOSSY_DIRT_TERRAIN_SURFACE_BUILDER);
		
		ModBiomeFeatures.addConiferTree(generationBuilder);
		ModBiomeFeatures.addAllJurassicPlants(generationBuilder);
		ModBiomeFeatures.addJurassicOres(generationBuilder);
		ModBiomeFeatures.addJurassicWaterLakes(generationBuilder);
		ModBiomeFeatures.addJurassicLavaLakes(generationBuilder);

		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.45F).scale(0.3F).temperature(1.0F).downfall(0.9F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x1b6cb7).waterFogColor(0x1560a5).fogColor(0x355177).skyColor(0x1b4266).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome makeAJurassicGinkgoForest() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = new MobSpawnInfo.Builder();
		
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.ALLOSAURUS_ENTITY.get(), 2, 1, 1));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.KENTROSAURUS_ENTITY.get(), 2, 3, 7));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.OSTROMIA_ENTITY.get(), 2, 1, 3));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.CHILESAURUS_ENTITY.get(), 2, 5, 9));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.PROTOSUCHUS_ENTITY.get(), 2, 1, 1));
		
		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.MOSSY_DIRT_TERRAIN_SURFACE_BUILDER);
		
		ModBiomeFeatures.addGinkgoTree(generationBuilder);
		ModBiomeFeatures.addAllJurassicPlants(generationBuilder);
		ModBiomeFeatures.addJurassicOres(generationBuilder);
		ModBiomeFeatures.addJurassicWaterLakes(generationBuilder);
		ModBiomeFeatures.addJurassicLavaLakes(generationBuilder);

		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.125F).scale(0.05F).temperature(1.0F).downfall(0.9F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x1b6cb7).waterFogColor(0x1560a5).fogColor(0x355177).skyColor(0x1b4266).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome makeAJurassicGinkgoForestHills() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = new MobSpawnInfo.Builder();
		
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.ALLOSAURUS_ENTITY.get(), 2, 1, 1));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.KENTROSAURUS_ENTITY.get(), 2, 3, 7));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.OSTROMIA_ENTITY.get(), 2, 1, 3));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.CHILESAURUS_ENTITY.get(), 2, 5, 9));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.PROTOSUCHUS_ENTITY.get(), 2, 1, 1));
		
		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.MOSSY_DIRT_TERRAIN_SURFACE_BUILDER);
		
		ModBiomeFeatures.addGinkgoTree(generationBuilder);
		ModBiomeFeatures.addAllJurassicPlants(generationBuilder);
		ModBiomeFeatures.addJurassicOres(generationBuilder);
		ModBiomeFeatures.addJurassicWaterLakes(generationBuilder);
		ModBiomeFeatures.addJurassicLavaLakes(generationBuilder);

		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.45F).scale(0.3F).temperature(1.0F).downfall(0.9F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x1b6cb7).waterFogColor(0x1560a5).fogColor(0x355177).skyColor(0x1b4266).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome makeAJurassicAraucariaForest() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = new MobSpawnInfo.Builder();
		
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.ALLOSAURUS_ENTITY.get(), 2, 1, 1));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.KENTROSAURUS_ENTITY.get(), 2, 3, 7));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.OSTROMIA_ENTITY.get(), 2, 1, 3));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.CHILESAURUS_ENTITY.get(), 2, 5, 9));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.PROTOSUCHUS_ENTITY.get(), 2, 1, 1));
		
		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.MOSSY_DIRT_TERRAIN_SURFACE_BUILDER);
		
		ModBiomeFeatures.addAraucariaTree(generationBuilder);
		ModBiomeFeatures.addAllJurassicPlants(generationBuilder);
		ModBiomeFeatures.addJurassicOres(generationBuilder);
		ModBiomeFeatures.addJurassicWaterLakes(generationBuilder);
		ModBiomeFeatures.addJurassicLavaLakes(generationBuilder);

		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.SAVANNA).depth(0.125F).scale(0.05F).temperature(1.2F).downfall(0.0F).specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(0x1b4266).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome makeAJurassicAraucariaForestHills() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = new MobSpawnInfo.Builder();
		
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.ALLOSAURUS_ENTITY.get(), 2, 1, 1));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.KENTROSAURUS_ENTITY.get(), 2, 3, 7));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.OSTROMIA_ENTITY.get(), 2, 1, 3));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.CHILESAURUS_ENTITY.get(), 2, 5, 9));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.PROTOSUCHUS_ENTITY.get(), 2, 1, 1));
		
		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.MOSSY_DIRT_TERRAIN_SURFACE_BUILDER);
		
		ModBiomeFeatures.addAraucariaTree(generationBuilder);
		ModBiomeFeatures.addAllJurassicPlants(generationBuilder);
		ModBiomeFeatures.addJurassicOres(generationBuilder);
		ModBiomeFeatures.addJurassicWaterLakes(generationBuilder);
		ModBiomeFeatures.addJurassicLavaLakes(generationBuilder);

		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.SAVANNA).depth(0.45F).scale(0.3F).temperature(1.2F).downfall(0.0F).specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(0x1b4266).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome makeAJurassicPlains() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = new MobSpawnInfo.Builder();
		
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.ALLOSAURUS_ENTITY.get(), 2, 1, 1));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.KENTROSAURUS_ENTITY.get(), 2, 3, 7));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.OSTROMIA_ENTITY.get(), 2, 1, 3));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.CHILESAURUS_ENTITY.get(), 2, 5, 9));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.PROTOSUCHUS_ENTITY.get(), 2, 1, 1));
		
		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.MOSSY_DIRT_TERRAIN_SURFACE_BUILDER);
		
		ModBiomeFeatures.addJurassicWaterLakes(generationBuilder);
		ModBiomeFeatures.addAllJurassicPlants(generationBuilder);
		ModBiomeFeatures.addJurassicOres(generationBuilder);
		ModBiomeFeatures.addJurassicWaterLakes(generationBuilder);
		ModBiomeFeatures.addJurassicLavaLakes(generationBuilder);

		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.PLAINS).depth(0.125F).scale(0.05F).temperature(1.5F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x1b6cb7).waterFogColor(0x1560a5).fogColor(0x355177).skyColor(0x1b4266).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	public static Biome makeAJurassicPlainsHills() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = new MobSpawnInfo.Builder();
		
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.ALLOSAURUS_ENTITY.get(), 2, 1, 1));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.KENTROSAURUS_ENTITY.get(), 2, 3, 7));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.OSTROMIA_ENTITY.get(), 2, 1, 3));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.CHILESAURUS_ENTITY.get(), 2, 5, 9));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.PROTOSUCHUS_ENTITY.get(), 2, 1, 1));
		
		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.MOSSY_DIRT_TERRAIN_SURFACE_BUILDER);
		
		ModBiomeFeatures.addJurassicWaterLakes(generationBuilder);
		ModBiomeFeatures.addAllJurassicPlants(generationBuilder);
		ModBiomeFeatures.addJurassicOres(generationBuilder);
		ModBiomeFeatures.addJurassicWaterLakes(generationBuilder);
		ModBiomeFeatures.addJurassicLavaLakes(generationBuilder);

		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.PLAINS).depth(0.45F).scale(0.3F).temperature(1.5F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x1b6cb7).waterFogColor(0x1560a5).fogColor(0x355177).skyColor(0x1b4266).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome makeAJurassicMountains() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = new MobSpawnInfo.Builder();
		
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.CRYOLOPHOSAURUS_ENTITY.get(), 2, 2, 3));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.KENTROSAURUS_ENTITY.get(), 2, 3, 7));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.OSTROMIA_ENTITY.get(), 2, 1, 3));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.CHILESAURUS_ENTITY.get(), 2, 5, 9));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.PROTOSUCHUS_ENTITY.get(), 2, 1, 1));
		
		BiomeGenerationSettings.Builder generationBuilder = genSettings(SurfaceBuilderInit.NAKED_JURASSIC_MOUNTAIN, ModSurfaceBuilders.JURASSIC_STONE_MOUNTAIN_CONFIG);
		
		ModBiomeFeatures.addJurassicWaterLakes(generationBuilder);
		ModBiomeFeatures.addJurassicOres(generationBuilder);
		ModBiomeFeatures.addJurassicWaterLakes(generationBuilder);
		ModBiomeFeatures.addJurassicLavaLakes(generationBuilder);

		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.EXTREME_HILLS).depth(1.0F).scale(0.5F).temperature(1.5F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x1b6cb7).waterFogColor(0x1560a5).fogColor(0x355177).skyColor(0x1b4266).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome makeAErrodedMountains() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = new MobSpawnInfo.Builder();
		
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.CRYOLOPHOSAURUS_ENTITY.get(), 2, 2, 3));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.KENTROSAURUS_ENTITY.get(), 2, 3, 7));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.OSTROMIA_ENTITY.get(), 2, 1, 3));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.CHILESAURUS_ENTITY.get(), 2, 5, 9));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.PROTOSUCHUS_ENTITY.get(), 2, 1, 1));
		
		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.JURASSIC_ERRODED_MOUNTAIN_SURFACE_BUILDER);
		
		ModBiomeFeatures.addJurassicWaterLakes(generationBuilder);
		ModBiomeFeatures.addJurassicOres(generationBuilder);
		ModBiomeFeatures.addJurassicWaterLakes(generationBuilder);
		ModBiomeFeatures.addJurassicLavaLakes(generationBuilder);


		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.EXTREME_HILLS).depth(1.0F).scale(0.5F).temperature(1.5F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x87a545).waterColor(0x1b6cb7).waterFogColor(0x1560a5).fogColor(0x355177).skyColor(0x1b4266).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome makeAJurassicDesert() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = new MobSpawnInfo.Builder();
		
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.ALLOSAURUS_ENTITY.get(), 2, 1, 1));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.KENTROSAURUS_ENTITY.get(), 2, 3, 7));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.OSTROMIA_ENTITY.get(), 2, 1, 3));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.CHILESAURUS_ENTITY.get(), 2, 5, 9));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.PROTOSUCHUS_ENTITY.get(), 2, 1, 1));
		
		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.GRAVEL_TERRAIN_SURFACE_BUILDER);

		ModBiomeFeatures.addJurassicOres(generationBuilder);
		ModBiomeFeatures.addJurassicWaterLakes(generationBuilder);
		ModBiomeFeatures.addJurassicLavaLakes(generationBuilder);

		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.DESERT).depth(0.125F).scale(0.05F).temperature(3.75F).downfall(0.0F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x8e8144).waterColor(0x1b6cb7).waterFogColor(0x1560a5).fogColor(0x355177).skyColor(0x1b4266).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome makeAJurassicDesertHills() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = new MobSpawnInfo.Builder();
		
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.ALLOSAURUS_ENTITY.get(), 2, 1, 1));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.KENTROSAURUS_ENTITY.get(), 2, 3, 7));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.OSTROMIA_ENTITY.get(), 2, 1, 3));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.CHILESAURUS_ENTITY.get(), 2, 5, 9));
		spawngenerationBuilder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.PROTOSUCHUS_ENTITY.get(), 2, 1, 1));
		
		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.GRAVEL_TERRAIN_SURFACE_BUILDER);

		ModBiomeFeatures.addJurassicOres(generationBuilder);
		ModBiomeFeatures.addJurassicWaterLakes(generationBuilder);
		ModBiomeFeatures.addJurassicLavaLakes(generationBuilder);

		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.DESERT).depth(0.45F).scale(0.3F).temperature(3.75F).downfall(0.0F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x8e8144).waterColor(0x1b6cb7).waterFogColor(0x1560a5).fogColor(0x355177).skyColor(0x1b4266).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome makeAJurassicRiver() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = new MobSpawnInfo.Builder();
						
		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.GRAVEL_TERRAIN_SURFACE_BUILDER);
		
		ModBiomeFeatures.addJurassicOres(generationBuilder);
			
		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.RIVER).depth(-0.5F).scale(0.0F).temperature(0.5F).downfall(0.5F).specialEffects((new BiomeAmbience.Builder()).waterColor(0x1b6cb7).waterFogColor(0x1560a5).fogColor(0x355177).skyColor(0x1b4266).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome makeAJurassicOcean() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = (new MobSpawnInfo.Builder());
				
		BiomeGenerationSettings.Builder generationBuilder = baseOceanGeneration(ModSurfaceBuilders.JURASSIC_OCEAN_SURFACE_BUILDER, false, false, true);
		
		DefaultBiomeFeatures.addDefaultSeagrass(generationBuilder);
		DefaultBiomeFeatures.addLukeWarmKelp(generationBuilder);
		
		ModBiomeFeatures.addJurassicOres(generationBuilder);

		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CAVES);
		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_MOD_CANYONS);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.OCEAN).depth(-1.8F).scale(0.1F).temperature(0.5F).downfall(0.5F).specialEffects((new BiomeAmbience.Builder()).waterColor(0x1b6cb7).waterFogColor(0x1560a5).fogColor(0x355177).skyColor(0x1b4266).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build();
	}

	//Overworld
	public static Biome makeAOverworldConiferForest() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = new MobSpawnInfo.Builder();
		DefaultBiomeFeatures.farmAnimals(spawngenerationBuilder);
		DefaultBiomeFeatures.commonSpawns(spawngenerationBuilder);

		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);
		DefaultBiomeFeatures.addDefaultOverworldLandStructures(generationBuilder);
		generationBuilder.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
		DefaultBiomeFeatures.addDefaultCarvers(generationBuilder);
		DefaultBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultBiomeFeatures.addForestFlowers(generationBuilder);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(generationBuilder);
		DefaultBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultBiomeFeatures.addDefaultGrass(generationBuilder);
		DefaultBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultBiomeFeatures.addDefaultExtraVegetation(generationBuilder);
		DefaultBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultBiomeFeatures.addSurfaceFreezing(generationBuilder);

		ModBiomeFeatures.addConiferTree(generationBuilder);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.1F).scale(0.2F).temperature(0.7F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(calculateSkyColor(0.7F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome makeAOverworldConiferForestHills() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = new MobSpawnInfo.Builder();
		DefaultBiomeFeatures.farmAnimals(spawngenerationBuilder);
		DefaultBiomeFeatures.commonSpawns(spawngenerationBuilder);

		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);
		DefaultBiomeFeatures.addDefaultOverworldLandStructures(generationBuilder);
		generationBuilder.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
		DefaultBiomeFeatures.addDefaultCarvers(generationBuilder);
		DefaultBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultBiomeFeatures.addForestFlowers(generationBuilder);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(generationBuilder);
		DefaultBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultBiomeFeatures.addDefaultGrass(generationBuilder);
		DefaultBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultBiomeFeatures.addDefaultExtraVegetation(generationBuilder);
		DefaultBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultBiomeFeatures.addSurfaceFreezing(generationBuilder);

		ModBiomeFeatures.addConiferTree(generationBuilder);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.45F).scale(0.3F).temperature(0.7F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(calculateSkyColor(0.7F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome makeAOverworldGinkgoForest() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = new MobSpawnInfo.Builder();
		DefaultBiomeFeatures.farmAnimals(spawngenerationBuilder);
		DefaultBiomeFeatures.commonSpawns(spawngenerationBuilder);

		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);
		DefaultBiomeFeatures.addDefaultOverworldLandStructures(generationBuilder);
		generationBuilder.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
		DefaultBiomeFeatures.addDefaultCarvers(generationBuilder);
		DefaultBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultBiomeFeatures.addForestFlowers(generationBuilder);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(generationBuilder);
		DefaultBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultBiomeFeatures.addDefaultGrass(generationBuilder);
		DefaultBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultBiomeFeatures.addDefaultExtraVegetation(generationBuilder);
		DefaultBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultBiomeFeatures.addSurfaceFreezing(generationBuilder);

		ModBiomeFeatures.addGinkgoTree(generationBuilder);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.1F).scale(0.2F).temperature(0.7F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(calculateSkyColor(0.7F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome makeAOverworldGinkgoForestHills() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = new MobSpawnInfo.Builder();
		DefaultBiomeFeatures.farmAnimals(spawngenerationBuilder);
		DefaultBiomeFeatures.commonSpawns(spawngenerationBuilder);

		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);
		DefaultBiomeFeatures.addDefaultOverworldLandStructures(generationBuilder);
		generationBuilder.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
		DefaultBiomeFeatures.addDefaultCarvers(generationBuilder);
		DefaultBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultBiomeFeatures.addForestFlowers(generationBuilder);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(generationBuilder);
		DefaultBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultBiomeFeatures.addDefaultGrass(generationBuilder);
		DefaultBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultBiomeFeatures.addDefaultExtraVegetation(generationBuilder);
		DefaultBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultBiomeFeatures.addSurfaceFreezing(generationBuilder);

		ModBiomeFeatures.addGinkgoTree(generationBuilder);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.45F).scale(0.3F).temperature(0.7F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(calculateSkyColor(0.7F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome makeAOverworldAraucariaForest() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = new MobSpawnInfo.Builder();
		DefaultBiomeFeatures.farmAnimals(spawngenerationBuilder);
		DefaultBiomeFeatures.commonSpawns(spawngenerationBuilder);

		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);
		DefaultBiomeFeatures.addDefaultOverworldLandStructures(generationBuilder);
		generationBuilder.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
		DefaultBiomeFeatures.addDefaultCarvers(generationBuilder);
		DefaultBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultBiomeFeatures.addForestFlowers(generationBuilder);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(generationBuilder);
		DefaultBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultBiomeFeatures.addDefaultGrass(generationBuilder);
		DefaultBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultBiomeFeatures.addDefaultExtraVegetation(generationBuilder);
		DefaultBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultBiomeFeatures.addSurfaceFreezing(generationBuilder);

		ModBiomeFeatures.addAraucariaTree(generationBuilder);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.1F).scale(0.2F).temperature(0.7F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(calculateSkyColor(0.7F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome makeAOverworldAraucariaForestHills() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = new MobSpawnInfo.Builder();
		DefaultBiomeFeatures.farmAnimals(spawngenerationBuilder);
		DefaultBiomeFeatures.commonSpawns(spawngenerationBuilder);

		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);
		DefaultBiomeFeatures.addDefaultOverworldLandStructures(generationBuilder);
		generationBuilder.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
		DefaultBiomeFeatures.addDefaultCarvers(generationBuilder);
		DefaultBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultBiomeFeatures.addForestFlowers(generationBuilder);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(generationBuilder);
		DefaultBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultBiomeFeatures.addDefaultGrass(generationBuilder);
		DefaultBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultBiomeFeatures.addDefaultExtraVegetation(generationBuilder);
		DefaultBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultBiomeFeatures.addSurfaceFreezing(generationBuilder);

		ModBiomeFeatures.addAraucariaTree(generationBuilder);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.45F).scale(0.3F).temperature(0.7F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(calculateSkyColor(0.7F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
	
	public static Biome makeAVolcanoBiome() 
	{
		MobSpawnInfo.Builder spawngenerationBuilder = new MobSpawnInfo.Builder();
		DefaultBiomeFeatures.commonSpawns(spawngenerationBuilder);
		
		BiomeGenerationSettings.Builder generationBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ModSurfaceBuilders.VOLCANO_SURFACE_BUILDER);
		DefaultBiomeFeatures.addDefaultOverworldLandStructures(generationBuilder);
		generationBuilder.addStructureStart(StructureFeatures.RUINED_PORTAL_MOUNTAIN);
		DefaultBiomeFeatures.addDefaultCarvers(generationBuilder);
		DefaultBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(generationBuilder);
		DefaultBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultBiomeFeatures.addExtraEmeralds(generationBuilder);
		DefaultBiomeFeatures.addDesertLakes(generationBuilder);
		
		generationBuilder.addCarver(GenerationStage.Carving.AIR, WorldCarverInit.CONFIGURED_VOLCANO_CAVES);
		
		return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.EXTREME_HILLS).depth(1.0F).scale(0.5F).temperature(5.0F).downfall(0.3F).specialEffects((new BiomeAmbience.Builder()).grassColorOverride(0x777777).waterColor(0x6c777a).waterFogColor(0x555e60).fogColor(0x2f3030).skyColor(0x4b5a60).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).ambientParticle(new ParticleEffectAmbience(ParticleTypes.WHITE_ASH, 0.00625F)).build()).mobSpawnSettings(spawngenerationBuilder.build()).generationSettings(generationBuilder.build()).build();
	}
}
