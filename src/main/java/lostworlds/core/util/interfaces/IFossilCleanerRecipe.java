package lostworlds.core.util.interfaces;

import javax.annotation.Nonnull;

import lostworlds.core.util.reference.ModReference;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public interface IFossilCleanerRecipe extends IRecipe<RecipeWrapper>
{
	ResourceLocation RECIPE_TYPE_ID = new ResourceLocation(ModReference.ID, "fossil_cleaner");
	
	
	
	@Nonnull
	@Override
	default IRecipeType<?> getType() 
	{
		return Registry.RECIPE_TYPE.getOptional(RECIPE_TYPE_ID).get();
	}
	
	@Override
	default boolean canCraftInDimensions(int width, int height) 
	{
		return false;
	}
	
	Ingredient getInput();
}
