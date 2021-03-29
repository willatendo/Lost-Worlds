package lostworlds.core.util.interfaces;

import java.util.Optional;

import lostworlds.common.recipe.FossilCleanerRecipe;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public interface IModRecipeType<T extends IRecipe<?>> 
{
	IRecipeType<FossilCleanerRecipe> FOSSIL_CLEANING = register("fossil_cleaning");
	
	static <T extends IRecipe<?>> IRecipeType<T> register(final String id) 
	{
		return Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(id), new IRecipeType<T>() 
		{
			public String toString() 
			{
				return id;
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	default <C extends IInventory> Optional<T> tryMatch(IRecipe<C> recipe, World worldIn, C inv) 
	{
		return recipe.matches(inv, worldIn) ? Optional.of((T)recipe) : Optional.empty();
	}
}