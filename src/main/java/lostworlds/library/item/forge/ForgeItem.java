package lostworlds.library.item.forge;

import lostworlds.library.tab.ModItemGroup;
import lostworlds.library.util.ModRegistry;
import net.minecraft.item.Item;

/*
 * Author: Willatendo
 * Date: July 2, 2021
 */

public class ForgeItem extends Item
{
	protected ForgeItem() 
	{
		super(new Properties().tab(ModItemGroup.ITEMS));
	}

	public static Item create(String id)
	{
		Item item = new ForgeItem();
		ModRegistry.register(id, item);
		return item;
	}
}
