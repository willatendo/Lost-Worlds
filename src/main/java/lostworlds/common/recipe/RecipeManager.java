package lostworlds.common.recipe;

import java.util.ArrayList;
import java.util.List;

import lostworlds.core.init.ItemInit;
import lostworlds.core.util.ModUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(bus = Bus.MOD, modid = ModUtil.ID)
public class RecipeManager 
{
    public static List<FossilCleanerRecipe> cleanerRecipes = new ArrayList<>();

    public static void initAlternateRecipes()
	{
		FossilCleanerRecipe fossil = new FossilCleanerRecipe()
				.addOutput(() -> ItemInit.ALLOSAURUS_ARM_BONE.get())
				.addOutput(() -> ItemInit.ALLOSAURUS_FOOT_BONE.get())
				.addOutput(() -> ItemInit.ALLOSAURUS_LEG_BONE.get())
				.addOutput(() -> ItemInit.ALLOSAURUS_RIB_BONE.get()) 
				.addOutput(() -> ItemInit.ALLOSAURUS_SKULL.get());
		
		registerAnalyzer(fossil);
	}
	
	public static void registerAnalyzer(FossilCleanerRecipe recipe) 
	{
		cleanerRecipes.add(recipe);
	}
	
	public static FossilCleanerRecipe getAnalyzerRecipeForItem(ItemStack stack) 
	{
		for (FossilCleanerRecipe recipe : cleanerRecipes) 
		{
			if(ItemStack.matches(recipe.getInput(), stack)) 
			{
				return recipe;
			}
		}
		return null;
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) 
	{
		initAlternateRecipes();
	}
}
