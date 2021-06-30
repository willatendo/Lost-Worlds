package api.core.init;

import library.Init;
import library.ModRegistry;
import library.recipes.AnalyserRecipe;
import library.recipes.AnalyserRecipeSerialiser;
import library.recipes.DNAExtractorRecipe;
import library.recipes.DNAExtractorRecipeSerialiser;
import library.recipes.DNAInjectorRecipe;
import library.recipes.DNAInjectorRecipeSerialiser;
import library.recipes.FossilGrinderRecipe;
import library.recipes.FossilGrinderRecipeSerialiser;
import library.util.ModUtil;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;

@Init
public class RecipeInit extends ModRegistry
{
	public static final IRecipeSerializer<FossilGrinderRecipe> FOSSIL_GRINDER_RECIPE_SERIALIZER = new FossilGrinderRecipeSerialiser();
	public static final IRecipeSerializer<DNAExtractorRecipe> DNA_EXTRACTOR_RECIPE_SERIALIZER = new DNAExtractorRecipeSerialiser();
	public static final IRecipeSerializer<AnalyserRecipe> ANALYSER_RECIPE_SERIALIZER = new AnalyserRecipeSerialiser();
	public static final IRecipeSerializer<DNAInjectorRecipe> DNA_INJECTOR_RECIPE_SERIALIZER = new DNAInjectorRecipeSerialiser();
	
	public static final IRecipeType<FossilGrinderRecipe> FOSSIL_GRINDER_RECIPE = registerType(ModUtil.rL("fossil_grinder"));
	public static final IRecipeType<DNAExtractorRecipe> DNA_EXTRACTOR_RECIPE = registerType(ModUtil.rL("dna_extractor"));
	public static final IRecipeType<AnalyserRecipe> ANALYSER_RECIPE = registerType(ModUtil.rL("analyser"));
	public static final IRecipeType<DNAInjectorRecipe> DNA_INJECTOR_RECIPE = registerType(ModUtil.rL("dna_injector"));

	public static final RegistryObject<IRecipeSerializer<?>> FOSSIL_GRINDER_SERIALIZER = RECIPE_SERIALIZERS.register("fossil_grinder", () -> FOSSIL_GRINDER_RECIPE_SERIALIZER);
	public static final RegistryObject<IRecipeSerializer<?>> DNA_EXTRACTOR_SERIALIZER = RECIPE_SERIALIZERS.register("dna_extractor", () -> DNA_EXTRACTOR_RECIPE_SERIALIZER);
	public static final RegistryObject<IRecipeSerializer<?>> ANALYSER_SERIALIZER = RECIPE_SERIALIZERS.register("analyser", () -> ANALYSER_RECIPE_SERIALIZER);
	public static final RegistryObject<IRecipeSerializer<?>> DNA_INJECTOR_SERIALIZER = RECIPE_SERIALIZERS.register("dna_injector", () -> DNA_INJECTOR_RECIPE_SERIALIZER);

	private static class RecipeType<T extends IRecipe<?>> implements IRecipeType<T> 
	{
		@Override
		public String toString() 
		{
			return Registry.RECIPE_TYPE.getKey(this).toString();
		}
	}
	
	private static <T extends IRecipeType> T registerType(ResourceLocation recipeTypeId) 
	{
		return (T) Registry.register(Registry.RECIPE_TYPE, recipeTypeId, new RecipeType<>());
	}
}
