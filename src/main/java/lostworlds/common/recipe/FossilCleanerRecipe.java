package lostworlds.common.recipe;

import lostworlds.core.init.RecipeSerialiserInit;
import lostworlds.core.util.interfaces.IFossilCleanerRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class FossilCleanerRecipe implements IFossilCleanerRecipe
{
	private final ResourceLocation id;
	private Ingredient input;
	private final ItemStack output;
	protected final int cleanTime;
	
	public FossilCleanerRecipe(ResourceLocation id, Ingredient input, ItemStack output, int cleanTime)
	{
		this.id = id;
		this.output = output;
		this.input = input;
		this.cleanTime = cleanTime;
	}
	
	@Override
	public boolean matches(RecipeWrapper inv, World worldIn) 
	{
		if(this.input.test(inv.getItem(0)))
		{
			return true;
		}
		return false;
	}

	@Override
	public ItemStack assemble(RecipeWrapper inv) 
	{
		return this.output;
	}

	@Override
	public ItemStack getResultItem() 
	{
		return this.output;
	}

	@Override
	public ResourceLocation getId() 
	{
		return this.id;
	}

	@Override
	public IRecipeSerializer<?> getSerializer() 
	{
		return RecipeSerialiserInit.FOSSIL_CLEANER_SERIALISER.get();
	}
	
	public Ingredient getInput() 
	{
		return this.input;
	}
	
	public int getCleanTime() 
	{
		return this.cleanTime;
	}

	@Override
	public NonNullList<Ingredient> getIngredients() 
	{
		return NonNullList.of(null, this.input);
	}
}
