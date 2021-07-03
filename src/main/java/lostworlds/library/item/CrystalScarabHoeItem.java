package lostworlds.library.item;

import lostworlds.library.enums.ModItemTeir;
import lostworlds.library.tab.ModItemGroup;
import lostworlds.library.util.ModRegistry;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

/*
 * Author: Willatendo
 * Date: July 2, 2021
 */

public class CrystalScarabHoeItem extends HoeItem
{
	public CrystalScarabHoeItem() 
	{
		super(ModItemTeir.CRYSTAL_SCARAB, 10, -3.0F, new Properties().tab(ModItemGroup.ITEMS).rarity(Rarity.RARE));
	}
	
	public static Item create()
	{
		Item item = new CrystalScarabHoeItem();
		ModRegistry.register("crystal_scarab_hoe", item);
		return item;
	}
}
