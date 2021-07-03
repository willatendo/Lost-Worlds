package lostworlds.library.item;

import lostworlds.library.enums.ModItemTeir;
import lostworlds.library.tab.ModItemGroup;
import lostworlds.library.util.ModRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;

/*
 * Author: Willatendo
 * Date: July 2, 2021
 */

public class CrystalScarabSwordItem extends SwordItem
{
	public CrystalScarabSwordItem() 
	{
		super(ModItemTeir.CRYSTAL_SCARAB, 50, -2.4F, new Properties().tab(ModItemGroup.ITEMS).rarity(Rarity.RARE));
	}
	
	public static Item create()
	{
		Item item = new CrystalScarabSwordItem();
		ModRegistry.register("crystal_scarab_sword", item);
		return item;
	}
}
