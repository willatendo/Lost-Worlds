package lostworlds.common.items;

import lostworlds.core.ModItemGroup;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class ModFoodItem extends Item
{
	private String textID;

	public ModFoodItem(String texID, Food food) 
	{
		super(standardItemProperties().food(food));
		this.textID = texID;
	}
	
	public static Properties standardItemProperties()
	{
		return new Item.Properties().tab(ModItemGroup.TAB);
	}
	
	@Override
	public ITextComponent getName(ItemStack stack) 
	{
		return new TranslationTextComponent(textID);
	}
}
