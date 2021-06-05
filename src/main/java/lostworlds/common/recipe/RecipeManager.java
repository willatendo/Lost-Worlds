package lostworlds.common.recipe;

import java.util.List;

import com.google.common.collect.ImmutableList;

import lostworlds.core.init.BlockInit;
import lostworlds.core.init.ItemInit;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipeManager 
{
	public static void init()
	{
		FossilCleanerRecipe fossil = new FossilCleanerRecipe(BlockInit.PLASTERED_FOSSIL.get());
		
		final List<Item> entries = ImmutableList.of(ItemInit.ALLOSAURUS_BLOOD_VILE.get());
		
		float entriesChance = 15F / (float) entries.size();
		
		for(int i = 0; i < entries.size(); i++)
		{
			fossil.addOutput(new ItemStack(entries.get(i)), entriesChance);
		}
	}
}
