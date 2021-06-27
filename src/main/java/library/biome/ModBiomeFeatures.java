package library.biome;

import api.core.init.ConfiguredFeatureInit;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;

public class ModBiomeFeatures
{
	public static void addPermianDesertPlants(BiomeGenerationSettings.Builder builder) 
	{
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ConfiguredFeatureInit.PATCH_PERMIAN_DESERT_PLANT_SMALL);
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ConfiguredFeatureInit.PATCH_PERMIAN_DESERT_PLANT_MEDIUM);
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ConfiguredFeatureInit.PATCH_PERMIAN_DESERT_PLANT_LARGE);
	}
	
	public static void addAllPermianPlants(BiomeGenerationSettings.Builder builder)
	{
		
	}
	
	public static void addAllJurassicPlants(BiomeGenerationSettings.Builder builder) 
	{
		ModBiomeFeatures.addCephalotaxus(builder);
		ModBiomeFeatures.addCycad(builder);
		ModBiomeFeatures.addDicksonia(builder);
		ModBiomeFeatures.addDillhoffia(builder);
		ModBiomeFeatures.addDuisbergia(builder);
		ModBiomeFeatures.addFerns(builder);
		ModBiomeFeatures.addLycophyta(builder);
		ModBiomeFeatures.addOsmunda(builder);	
	}
	
	public static void addFerns(BiomeGenerationSettings.Builder builder) 
	{
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ConfiguredFeatureInit.PATCH_GROUND_FERNS);
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ConfiguredFeatureInit.PATCH_FERNS);
	}
	
	public static void addGroundFerns(BiomeGenerationSettings.Builder builder) 
	{
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ConfiguredFeatureInit.PATCH_GROUND_FERNS);
	}
	
	public static void addDicksonia(BiomeGenerationSettings.Builder builder) 
	{
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ConfiguredFeatureInit.PATCH_DICKSONIA);
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ConfiguredFeatureInit.PATCH_TALL_DICKSONIA);
	}
	
	public static void addCycad(BiomeGenerationSettings.Builder builder) 
	{
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ConfiguredFeatureInit.PATCH_CYCAD);
	}
	
	public static void addOsmunda(BiomeGenerationSettings.Builder builder) 
	{
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ConfiguredFeatureInit.PATCH_OSUMNDA);
	}
	
	public static void addDuisbergia(BiomeGenerationSettings.Builder builder) 
	{
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ConfiguredFeatureInit.PATCH_DUISBERGIA);
	}
	
	public static void addCephalotaxus(BiomeGenerationSettings.Builder builder) 
	{
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ConfiguredFeatureInit.PATCH_CEPHALOTAXUS);
	}
	
	public static void addLycophyta(BiomeGenerationSettings.Builder builder) 
	{
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ConfiguredFeatureInit.PATCH_LYCOPHYTA);
	}
	
	public static void addDillhoffia(BiomeGenerationSettings.Builder builder) 
	{
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ConfiguredFeatureInit.PATCH_DILLHOFFIA);
	}
	
	public static void addConiferTree(BiomeGenerationSettings.Builder builder)
	{
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ConfiguredFeatureInit.CONIFER_TREES);
	}
	
	public static void addGinkgoTree(BiomeGenerationSettings.Builder builder)
	{
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ConfiguredFeatureInit.GINKGO_TREES);
	}
	
	public static void addSingleConiferTree(BiomeGenerationSettings.Builder builder)
	{
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ConfiguredFeatureInit.SINGLE_CONIFER_TREE);
	}
	
	public static void addAraucariaTree(BiomeGenerationSettings.Builder builder)
	{
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ConfiguredFeatureInit.ARAUCARIA_VEGETATION);
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ConfiguredFeatureInit.ARAUCARIA_VEGETATION_SMALL);
	}
	
	public static void addPermianOres(BiomeGenerationSettings.Builder builder)
	{
		builder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ConfiguredFeatureInit.PERMIAN_COAL);
		builder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ConfiguredFeatureInit.PERMIAN_COPPER);
		builder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ConfiguredFeatureInit.PERMIAN_DIAMOND);
		builder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ConfiguredFeatureInit.PERMIAN_GOLD);
		builder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ConfiguredFeatureInit.PERMIAN_IRON);
		builder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ConfiguredFeatureInit.PERMIAN_LAPIS);
		builder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ConfiguredFeatureInit.PERMIAN_REDSTONE);
	}
	
	public static void addPermianEmerald(BiomeGenerationSettings.Builder builder)
	{
		builder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ConfiguredFeatureInit.PERMIAN_EMERALD);		
	}

	public static void addJurassicOres(BiomeGenerationSettings.Builder builder)
	{
		builder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ConfiguredFeatureInit.JURASSIC_COAL);
		builder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ConfiguredFeatureInit.JURASSIC_COPPER);
		builder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ConfiguredFeatureInit.JURASSIC_DIAMOND);
		builder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ConfiguredFeatureInit.JURASSIC_GOLD);
		builder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ConfiguredFeatureInit.JURASSIC_IRON);
		builder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ConfiguredFeatureInit.JURASSIC_LAPIS);
		builder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ConfiguredFeatureInit.JURASSIC_REDSTONE);
	}
	
	public static void addJurassicEmerald(BiomeGenerationSettings.Builder builder)
	{
		builder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ConfiguredFeatureInit.JURASSIC_EMERALD);		
	}
	
	public static void addPermianWaterLakes(BiomeGenerationSettings.Builder builder)
	{
		builder.addFeature(GenerationStage.Decoration.LAKES, ConfiguredFeatureInit.PERMIAN_WATER_LAKE);		
	}
	
	public static void addPermianLavaLakes(BiomeGenerationSettings.Builder builder)
	{
		builder.addFeature(GenerationStage.Decoration.LAKES, ConfiguredFeatureInit.PERMIAN_LAVA_LAKE);		
	}
	
	public static void addJurassicWaterLakes(BiomeGenerationSettings.Builder builder)
	{
		builder.addFeature(GenerationStage.Decoration.LAKES, ConfiguredFeatureInit.JURASSIC_WATER_LAKE);		
	}
	
	public static void addJurassicLavaLakes(BiomeGenerationSettings.Builder builder)
	{
		builder.addFeature(GenerationStage.Decoration.LAKES, ConfiguredFeatureInit.JURASSIC_LAVA_LAKE);		
	}
}
