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
	
	public static void addPermianOres(BiomeGenerationSettings.Builder builder)
	{
		builder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ConfiguredFeatureInit.PERMIAN_COAL);
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
	
	public static void addCavesAndCanyons(BiomeGenerationSettings.Builder builder)
	{

	}
}
