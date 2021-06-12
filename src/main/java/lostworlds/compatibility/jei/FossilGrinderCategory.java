package lostworlds.compatibility.jei;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.mojang.blaze3d.matrix.MatrixStack;

import lostworlds.common.recipe.FossilGrinderRecipe;
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

public class FossilGrinderCategory implements IRecipeCategory<FossilGrinderRecipe>
{
	public static final ResourceLocation ID = ModUtil.rL("fossil_grinder_category");
	public static final ResourceLocation DISPLAY = ModUtil.rL("textures/gui/jei/lostworlds_backrounds.png");
	
	private final LoadingCache<Integer, IDrawableAnimated> grinderProgessBar;
	
	private final IDrawable backround;
	private final IDrawable icon;
	
	public FossilGrinderCategory(IGuiHelper helper) 
	{
		this.backround = helper.createDrawable(DISPLAY, 0, 38, 94, 26);
		this.icon = helper.createDrawableIngredient(new ItemStack(ItemInit.FOSSIL_GRINDER.get()));
		this.grinderProgessBar = CacheBuilder.newBuilder().maximumSize(25).build(new CacheLoader<Integer, IDrawableAnimated>() 
		{
			@Override
			public IDrawableAnimated load(Integer cookTime) 
			{
				return helper.drawableBuilder(DISPLAY, 94, 38, 35, 15).buildAnimated(cookTime, IDrawableAnimated.StartDirection.LEFT, false);
			}
		});
	}
	
	protected IDrawableAnimated getGrinderProgessBar(FossilGrinderRecipe recipe) 
	{
		int cookTime = recipe.getGrindTime();
		if(cookTime <= 0) 
		{
			cookTime = 300;
		}
		return this.grinderProgessBar.getUnchecked(cookTime);
	}
	
	@Override
	public ResourceLocation getUid() 
	{
		return ID;
	}

	@Override
	public Class<? extends FossilGrinderRecipe> getRecipeClass() 
	{
		return FossilGrinderRecipe.class;
	}

	@Override
	public String getTitle() 
	{
		return ModUtil.tTC("jei.fossil_grinder.title").getString();
	}

	@Override
	public IDrawable getBackground() 
	{
		return backround;
	}

	@Override
	public IDrawable getIcon() 
	{
		return icon;
	}

	@Override
	public void setIngredients(FossilGrinderRecipe recipe, IIngredients ingredients) 
	{
		ingredients.setInputIngredients(recipe.getIngredients());
		ingredients.setOutput(VanillaTypes.ITEM, recipe.getResultItem());
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, FossilGrinderRecipe recipe, IIngredients ingredients) 
	{
		IGuiItemStackGroup itemStackGroup = recipeLayout.getItemStacks();
		
		itemStackGroup.init(0, true, 4, 4);
		itemStackGroup.init(1, false, 71, 4);
		
		itemStackGroup.set(ingredients);
	}
	
	@Override
	public void draw(FossilGrinderRecipe recipe, MatrixStack matrixStack, double mouseX, double mouseY) 
	{
		IDrawableAnimated arrow = getGrinderProgessBar(recipe);
		arrow.draw(matrixStack, 29, 6);
	}
}
