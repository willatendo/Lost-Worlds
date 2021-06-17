package lostworlds.compatibility.jei;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.mojang.blaze3d.matrix.MatrixStack;

import lostworlds.common.recipe.DNAExtractorRecipe;
import lostworlds.core.init.ItemInit;
import lostworlds.core.util.ModUtil;
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

public class DNAExtractorCategory implements IRecipeCategory<DNAExtractorRecipe>
{
	public static final ResourceLocation ID = ModUtil.rL("dna_extractor_category");
	public static final ResourceLocation DISPLAY = ModUtil.rL("textures/gui/jei/lostworlds_backgrounds.png");
	
	private final LoadingCache<Integer, IDrawableAnimated> DNAProgessBar;
	
	private final IDrawable background;
	private final IDrawable icon;
	
	public DNAExtractorCategory(IGuiHelper helper) 
	{
		this.background = helper.createDrawable(DISPLAY, 0, 0, 82, 38);
		this.icon = helper.createDrawableIngredient(new ItemStack(ItemInit.DNA_EXTRACTOR.get()));
		this.DNAProgessBar = CacheBuilder.newBuilder().maximumSize(25).build(new CacheLoader<Integer, IDrawableAnimated>() 
		{
			@Override
			public IDrawableAnimated load(Integer cookTime) 
			{
				return helper.drawableBuilder(DISPLAY, 82, 0, 34, 10).buildAnimated(cookTime, IDrawableAnimated.StartDirection.LEFT, false);
			}
		});
	}
	
	protected IDrawableAnimated getDNAProgessBar(DNAExtractorRecipe recipe) 
	{
		int cookTime = recipe.getExtractingTime();
		if(cookTime <= 0) 
		{
			cookTime = 60;
		}
		return this.DNAProgessBar.getUnchecked(cookTime);
	}
	
	@Override
	public ResourceLocation getUid() 
	{
		return ID;
	}

	@Override
	public Class<? extends DNAExtractorRecipe> getRecipeClass() 
	{
		return DNAExtractorRecipe.class;
	}

	@Override
	public String getTitle() 
	{
		return ModUtil.tTC("jei.dna_extractor.title").getString();
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
	public void setIngredients(DNAExtractorRecipe recipe, IIngredients ingredients) 
	{
		ingredients.setInputIngredients(recipe.getIngredients());
		ingredients.setOutput(VanillaTypes.ITEM, recipe.getResultItem());
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, DNAExtractorRecipe recipe, IIngredients ingredients) 
	{
		IGuiItemStackGroup itemStackGroup = recipeLayout.getItemStacks();
		
		itemStackGroup.init(0, true, 0, 0);
		itemStackGroup.init(1, true, 0, 20);
		itemStackGroup.init(2, false, 60, 10);
		
		itemStackGroup.set(ingredients);
	}
	
	@Override
	public void draw(DNAExtractorRecipe recipe, MatrixStack matrixStack, double mouseX, double mouseY) 
	{
		IDrawableAnimated arrow = getDNAProgessBar(recipe);
		arrow.draw(matrixStack, 20, 14);
	}
}
