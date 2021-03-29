package lostworlds.core.util.interfaces;

import net.minecraft.item.crafting.ICraftingRecipe;
import net.minecraft.item.crafting.IRecipeType;

public interface IModRecipeType 
{
	IRecipeType<ICraftingRecipe> CLEANING = IRecipeType.register("cleaning");
}
