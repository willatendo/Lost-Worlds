package lostworlds.common.recipe;

import java.util.List;

import com.google.common.collect.ImmutableList;

import lostworlds.common.recipe.interfaces.IDNAExtractorRecipe;
import lostworlds.core.init.RecipeInit;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class DNAExtractorRecipe implements IDNAExtractorRecipe
{
	private final ResourceLocation id;
	private Ingredient softTissue;
	private Ingredient vile;
	private final ItemStack output;

	private List<Ingredient> inputs = ImmutableList.of(this.softTissue, this.vile);
	
	public DNAExtractorRecipe(ResourceLocation id, Ingredient softTissue, Ingredient vile, ItemStack output) 
	{
		this.id = id;
		this.output = output;
		this.softTissue = softTissue;
		this.vile = vile;
	}

	@Override
	public boolean matches(RecipeWrapper inv, World worldIn) 
	{
		if(this.softTissue.test(inv.getItem(0))) 
		{
			return true;
		}
		if(this.vile.test(inv.getItem(1))) 
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
		return RecipeInit.DNA_EXTRACTOR_SERIALIZER.get();
	}

	@Override
	public Ingredient getInput() 
	{
		return inputs.get(2);
	}

	@Override
	public NonNullList<Ingredient> getIngredients() 
	{
		return NonNullList.of(this.vile, this.softTissue);
	}
}
