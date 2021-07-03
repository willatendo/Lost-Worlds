package lostworlds.library.item;

import lostworlds.library.enums.ModItemTeir;
import lostworlds.library.tab.ModItemGroup;
import lostworlds.library.util.ModRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraft.item.ShovelItem;

/*
 * Author: Willatendo
 * Date: July 2, 2021
 */

public class CrystalScarabShovelItem extends ShovelItem
{
	public CrystalScarabShovelItem() 
	{
		super(ModItemTeir.CRYSTAL_SCARAB, 12.0F, -3.0F, new Properties().tab(ModItemGroup.ITEMS).rarity(Rarity.RARE));
	}
	
	public static Item create()
	{
		Item item = new CrystalScarabShovelItem();
		ModRegistry.register("crystal_scarab_shovel", item);
		return item;
	}
}
