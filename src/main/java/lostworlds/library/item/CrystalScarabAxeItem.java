package lostworlds.library.item;

import lostworlds.library.enums.ModItemTeir;
import lostworlds.library.tab.ModItemGroup;
import lostworlds.library.util.ModRegistry;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

/*
 * Author: Willatendo
 * Date: July 2, 2021
 */

public class CrystalScarabAxeItem extends AxeItem
{
	public CrystalScarabAxeItem() 
	{
		super(ModItemTeir.CRYSTAL_SCARAB, 70.0F, -3.2F, new Properties().tab(ModItemGroup.ITEMS).rarity(Rarity.RARE));
	}
	
	public static Item create()
	{
		Item item = new CrystalScarabAxeItem();
		ModRegistry.register("crystal_scarab_axe", item);
		return item;
	}
}
