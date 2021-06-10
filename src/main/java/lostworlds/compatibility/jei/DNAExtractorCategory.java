package lostworlds.compatibility.jei;

import com.mojang.blaze3d.matrix.MatrixStack;

import lostworlds.common.recipe.DNAExtractorRecipe;
import lostworlds.core.init.ItemInit;
import lostworlds.core.util.ModUtil;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class DNAExtractorCategory implements IRecipeCategory<DNAExtractorRecipe>
{
	public static final ResourceLocation ID = ModUtil.rL("dna_extractor_category");
	public static final ResourceLocation DNA_PROGRESS_METER = ModUtil.rL("textures/gui/jei/dna.png");
	
	protected final IDrawableStatic staticdnaProgressMeter;	
	protected final IDrawableAnimated dnaProgressMeter;	
	
	private final IDrawable backround;
	private final IDrawable icon;
	
	public DNAExtractorCategory(IGuiHelper helper) 
	{
		this.staticdnaProgressMeter = helper.createDrawable(DNA_PROGRESS_METER, 82, 114, 34, 10);
		this.dnaProgressMeter = helper.createAnimatedDrawable(staticdnaProgressMeter, 300, IDrawableAnimated.StartDirection.LEFT, true);
		this.backround = helper.createBlankDrawable(180, 100);
		this.icon = helper.createDrawableIngredient(new ItemStack(ItemInit.DNA_EXTRACTOR.get()));
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
		return backround;
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
	public void draw(DNAExtractorRecipe recipe, MatrixStack matrixStack, double mouseX, double mouseY) 
	{
		dnaProgressMeter.draw(matrixStack, 1, 20);
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, DNAExtractorRecipe recipe, IIngredients ingredients) 
	{
		IGuiItemStackGroup itemStackGroup = recipeLayout.getItemStacks();
		
		itemStackGroup.init(0, true, 0, 0);
		itemStackGroup.init(1, true, 0, 20);
		itemStackGroup.init(2, true, 0, 40);
		itemStackGroup.init(3, false, 60, 18);
		
		itemStackGroup.set(ingredients);
	}

}
