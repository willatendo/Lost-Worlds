package integration.jei;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.mojang.blaze3d.matrix.MatrixStack;

import api.core.init.ItemInit;
import library.recipes.DNAInjectorRecipe;
import library.util.ModUtil;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class DNAInjectorCategory implements IRecipeCategory<DNAInjectorRecipe>
{
	public static final ResourceLocation ID = ModUtil.rL("dna_injector_category");
	public static final ResourceLocation DISPLAY = ModUtil.rL("textures/gui/jei/lostworlds_backgrounds.png");
	
	private final LoadingCache<Integer, IDrawableAnimated> DNAProgessBar;
	
	private final IDrawable background;
	private final IDrawable icon;
	
	public DNAInjectorCategory(IGuiHelper helper) 
	{
		this.background = helper.createDrawable(DISPLAY, 0, 122, 82, 54);
		this.icon = helper.createDrawableIngredient(new ItemStack(ItemInit.DNA_INJECTOR.get()));
		this.DNAProgessBar = CacheBuilder.newBuilder().maximumSize(25).build(new CacheLoader<Integer, IDrawableAnimated>() 
		{
			@Override
			public IDrawableAnimated load(Integer cookTime) 
			{
				return helper.drawableBuilder(DISPLAY, 82, 123, 16, 16).buildAnimated(cookTime, IDrawableAnimated.StartDirection.LEFT, false);
			}
		});
	}
	
	protected IDrawableAnimated getSyringeProgessBar(DNAInjectorRecipe recipe) 
	{
		int cookTime = recipe.getInjectingTime();
		if(cookTime <= 0) 
		{
			cookTime = 50;
		}
		return this.DNAProgessBar.getUnchecked(cookTime);
	}
	
	@Override
	public ResourceLocation getUid() 
	{
		return ID;
	}

	@Override
	public Class<? extends DNAInjectorRecipe> getRecipeClass() 
	{
		return DNAInjectorRecipe.class;
	}

	@Override
	public String getTitle() 
	{
		return ModUtil.tTC("jei", "dna_injector.title").getString();
	}

	@Override
	public IDrawable getBackground() 
	{
		return background;
	}

	@Override
	public IDrawable getIcon() 
	{
		return icon;
	}

	@Override
	public void setIngredients(DNAInjectorRecipe recipe, IIngredients ingredients) 
	{
		ingredients.setInputIngredients(recipe.getIngredients());
		ingredients.setOutput(VanillaTypes.ITEM, recipe.getResultItem());
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, DNAInjectorRecipe recipe, IIngredients ingredients) 
	{
		IGuiItemStackGroup itemStackGroup = recipeLayout.getItemStacks();
		
		itemStackGroup.init(0, true, 0, 0);
		itemStackGroup.init(1, true, 0, 36);
		itemStackGroup.init(2, false, 60, 18);
		
		itemStackGroup.set(ingredients);
	}
	
	@Override
	public void draw(DNAInjectorRecipe recipe, MatrixStack matrixStack, double mouseX, double mouseY) 
	{
		IDrawableAnimated arrow = getSyringeProgessBar(recipe);
		arrow.draw(matrixStack, 30, 19);
	}
}
