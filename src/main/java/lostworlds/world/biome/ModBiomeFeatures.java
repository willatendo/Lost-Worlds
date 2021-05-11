package lostworlds.world.biome;

import lostworlds.world.init.ConfiguredFeatureInit;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;

public class ModBiomeFeatures extends DefaultBiomeFeatures
{
	public static void addPermianDesertPlants(BiomeGenerationSettings.Builder builder) 
	{
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ConfiguredFeatureInit.PATCH_PERMIAN_DESERT_PLANT_SMALL);
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ConfiguredFeatureInit.PATCH_PERMIAN_DESERT_PLANT_MEDIUM);
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ConfiguredFeatureInit.PATCH_PERMIAN_DESERT_PLANT_LARGE);
	}
	
	public static void addPermianPlainsPlants(BiomeGenerationSettings.Builder builder) 
	{
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ConfiguredFeatureInit.PATCH_PERMIAN_GROUND_FERNS);
	}
	
	public static void addDicksonia(BiomeGenerationSettings.Builder builder) 
	{
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ConfiguredFeatureInit.PATCH_DICKSONIA);
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ConfiguredFeatureInit.PATCH_TALL_DICKSONIA);
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
