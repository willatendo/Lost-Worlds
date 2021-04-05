package lostworlds.common.items;

import lostworlds.core.ModItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class ModItem extends Item
{
	private String textID;

	public ModItem(String texID) 
	{
		super(standardItemProperties());
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
