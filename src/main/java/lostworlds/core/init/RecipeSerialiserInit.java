package lostworlds.core.init;

import lostworlds.common.recipe.FossilCleanerRecipe;
import lostworlds.common.recipe.FossilCleanerRecipeSerialiser;
import lostworlds.core.util.interfaces.IFossilCleanerRecipe;
import lostworlds.core.util.registry.ModRegistry;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;

public class RecipeSerialiserInit 
{
	public static final IRecipeSerializer<FossilCleanerRecipe> FOSSIL_CLEANER_RECIPE_SERIALISER = new FossilCleanerRecipeSerialiser();
	public static final IRecipeType<IFossilCleanerRecipe> FOSSIL_CLEANER_RECIPE_TYPE = registerType(IFossilCleanerRecipe.RECIPE_TYPE_ID);
	
	public static final RegistryObject<IRecipeSerializer<?>> FOSSIL_CLEANER_SERIALISER = ModRegistry.RECIPE_SERIALISER_REGISTRY.register("fossil_cleaner", () -> FOSSIL_CLEANER_RECIPE_SERIALISER);
			
	private static class RecipeType<T extends IRecipe<?>> implements IRecipeType<T> 
	{
		@Override
		public String toString() 
		{
			return Registry.RECIPE_TYPE.getKey(this).toString();
		}
	}
	
	//Registry
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static <T extends IRecipeType> T registerType(ResourceLocation recipeTypeId) 
	{
		return (T) Registry.register(Registry.RECIPE_TYPE, recipeTypeId, new RecipeType<>());
	}
			
	public static void initRecipeSerialisers() { }
}
