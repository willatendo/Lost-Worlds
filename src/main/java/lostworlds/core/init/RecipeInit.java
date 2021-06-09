package lostworlds.core.init;

import lostworlds.common.recipe.DNAExtractorRecipe;
import lostworlds.common.recipe.DNAExtractorRecipeSerialiser;
import lostworlds.common.recipe.FossilGrinderRecipe;
import lostworlds.common.recipe.FossilGrinderRecipeSerialiser;
import lostworlds.core.util.ModUtil;
import lostworlds.core.util.registry.ModRegistry;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;

public class RecipeInit 
{
	public static final IRecipeSerializer<FossilGrinderRecipe> FOSSIL_GRINDER_RECIPE_SERIALIZER = new FossilGrinderRecipeSerialiser();
	public static final IRecipeSerializer<DNAExtractorRecipe> DNA_EXTRACTOR_RECIPE_SERIALIZER = new DNAExtractorRecipeSerialiser();
	public static final IRecipeType<FossilGrinderRecipe> FOSSIL_GRINDER_RECIPE = registerType(ModUtil.rL("fossil_grinder"));
	public static final IRecipeType<DNAExtractorRecipe> DNA_EXTRACTOR_RECIPE = registerType(ModUtil.rL("dna_extractor"));

	public static final RegistryObject<IRecipeSerializer<?>> FOSSIL_GRINDER_SERIALIZER = ModRegistry.RECIPE_SERIALIZERS.register("fossil_grinder", () -> FOSSIL_GRINDER_RECIPE_SERIALIZER);
	public static final RegistryObject<IRecipeSerializer<?>> DNA_EXTRACTOR_SERIALIZER = ModRegistry.RECIPE_SERIALIZERS.register("dna_extractor", () -> DNA_EXTRACTOR_RECIPE_SERIALIZER);

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
	
	public static void initRecipes() { }
}
