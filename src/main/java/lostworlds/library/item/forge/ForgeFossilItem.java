package lostworlds.library.item.forge;

import lostworlds.library.tab.ModItemGroup;
import lostworlds.library.util.ModRegistry;
import net.minecraft.item.Item;

public class ForgeFossilItem extends Item
{
	protected ForgeFossilItem()
	{
		super(new Properties().tab(ModItemGroup.ITEMS));
	}
	
	public static Item create(String dino)
	{
		Item item = new ForgeFossilItem();
		ModRegistry.register(dino + "_skull", new ForgeFossilItem());
		ModRegistry.register(dino + "_arm_bone", new ForgeFossilItem());
		ModRegistry.register(dino + "_leg_bone", new ForgeFossilItem());
		ModRegistry.register(dino + "_foot_bone", new ForgeFossilItem());
		ModRegistry.register(dino + "_rib_bone", new ForgeFossilItem());
		return item;
	}
}
