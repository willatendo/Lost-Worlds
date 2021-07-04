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
	}
}
