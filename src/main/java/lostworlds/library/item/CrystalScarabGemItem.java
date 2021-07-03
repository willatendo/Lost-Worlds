package lostworlds.library.item;

import lostworlds.library.tab.ModItemGroup;
import lostworlds.library.util.ModRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

/*
 * Author: Willatendo
 * Date: July 2, 2021
 */

public class CrystalScarabGemItem extends Item
{	
	protected CrystalScarabGemItem(Properties properties)
	{
		super(properties);
	}
	
	public static Item create(String broken)
	{
		Item item = new CrystalScarabGemItem(new Properties().tab(ModItemGroup.ITEMS).rarity(Rarity.RARE));
		ModRegistry.register(broken + "crystal_scarab_gem", item);
		return item;
	}
}
