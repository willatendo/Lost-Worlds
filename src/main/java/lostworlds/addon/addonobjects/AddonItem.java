package lostworlds.addon.addonobjects;

import lostworlds.library.tab.ModItemGroup;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class AddonItem extends Item
{
	protected AddonItem() 
	{
		super(new Properties().tab(ModItemGroup.ITEMS));
	}

	public static Item create(String addonId, String id)
	{
		Item item = new AddonItem();
		item.setRegistryName(new ResourceLocation(addonId, id));
		ForgeRegistries.ITEMS.register(item);
		return item;
	}
}
