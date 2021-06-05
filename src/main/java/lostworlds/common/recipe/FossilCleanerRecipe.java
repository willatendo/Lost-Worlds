package lostworlds.common.recipe;

import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FossilCleanerRecipe 
{
	private ItemStack stack;
	private NavigableMap<Float, ItemStack> outputMap = new TreeMap<Float, ItemStack>();
	private float totalWeight;
	
	public FossilCleanerRecipe(Item input) 
	{
		this.stack = new ItemStack(input);
	}
	
	@SuppressWarnings("deprecation")
	public FossilCleanerRecipe(Block input) 
	{
		this(Item.byBlock(input));
	}
	
	public FossilCleanerRecipe addOutput(ItemStack stack, float weight)
	{
		totalWeight += weight;
		outputMap.put(totalWeight, stack);
		return this;
	}
	
	public ItemStack getInput()
	{
		return stack;
	}
	
	public ItemStack generateOutput(Random random)
	{
		if(totalWeight < 100)
		{
			if(random.nextFloat() >= totalWeight * 0.01F)
			{
				return ItemStack.EMPTY;
			}
		}
		float entry = random.nextFloat() * totalWeight;
		return outputMap.higherEntry(entry).getValue().copy();
	}
	
	public NavigableMap<Float, ItemStack> getDisplayMap()
	{
		return outputMap;
	}
	
	public Float getTotalWeight()
	{
		return totalWeight;
	}
}
