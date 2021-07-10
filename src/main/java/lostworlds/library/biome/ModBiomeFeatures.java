package lostworlds.library.biome;

import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;

public class ModBiomeFeatures 
{
	/*
	
	Sorted:
	- Plants
	- Trees
	- Rocks
	
	*/
	
	public static void addPermianDesertPlants(BiomeGenerationSettings.Builder builder) 
	{
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModConfiguredFeatures.SMALL_PERMIAN_DESERT_PLANT_PATCH);
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModConfiguredFeatures.MEDIUM_PERMIAN_DESERT_PLANT_PATCH);
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModConfiguredFeatures.LARGE_PERMIAN_DESERT_PLANT_PATCH);
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModConfiguredFeatures.LUSH_PERMIAN_DESERT_PLANT_PATCH);
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModConfiguredFeatures.DEAD_PERMIAN_SHRUB_PATCH);
	}
	
	public static void addFerns(BiomeGenerationSettings.Builder builder) 
	{
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_LARGE_FERN);
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModConfiguredFeatures.FERN_PATCH);
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModConfiguredFeatures.DEAD_PERMIAN_SHRUB_PATCH);
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModConfiguredFeatures.DEAD_LARGE_PERMIAN_SHRUB_PATCH);
	}
	
	public static void addSingleConiferTree(BiomeGenerationSettings.Builder builder)
	{
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModConfiguredFeatures.SINGLE_CONIFER_TREE);
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModConfiguredFeatures.CONIFER_STICKS);
	}
	
	public static void addPermianRockOutcrop(BiomeGenerationSettings.Builder builder)
	{
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModConfiguredFeatures.PERMIAN_ROCK_OUTCROP);
	}
	
	public static void addAshyShrub(BiomeGenerationSettings.Builder builder)
	{
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModConfiguredFeatures.ASHY_SHRUB);
	}
	
	public static void addAshLayer(BiomeGenerationSettings.Builder builder)
	{
		builder.addFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, ModConfiguredFeatures.ADD_ASH_LAYER);
	}
	
	public static void addScorchedTrees(BiomeGenerationSettings.Builder builder)
	{
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModConfiguredFeatures.SINGLE_SCORCHED_TREE);
	}
	
	public static void addBasaltDiamondOre(BiomeGenerationSettings.Builder builder)
	{
		builder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ModConfiguredFeatures.ORE_BASALT_DIAMOND);
	}
}
