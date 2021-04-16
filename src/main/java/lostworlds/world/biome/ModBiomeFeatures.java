package lostworlds.world.biome;

import lostworlds.world.init.Foliage;
import lostworlds.world.init.Ores;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;

public class ModBiomeFeatures extends DefaultBiomeFeatures
{
	public static void addPermianDesertPlants(BiomeGenerationSettings.Builder builder) 
	{
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Foliage.PATCH_PERMIAN_DESERT_PLANT_SMALL);
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Foliage.PATCH_PERMIAN_DESERT_PLANT_MEDIUM);
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Foliage.PATCH_PERMIAN_DESERT_PLANT_LARGE);
	}
	
	public static void addPermianPlainsPlants(BiomeGenerationSettings.Builder builder) 
	{
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Foliage.PATCH_PERMIAN_GROUND_FERNS);
	}
	
	public static void addConiferTree(BiomeGenerationSettings.Builder builder)
	{
		builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Foliage.CONIFER_TREES);
	}
	
	public static void addOilSands(BiomeGenerationSettings.Builder builder) 
	{
		builder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Ores.ORE_OIL_SANDS);
	}
}
