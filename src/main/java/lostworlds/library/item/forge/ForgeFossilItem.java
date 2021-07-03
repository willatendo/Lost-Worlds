package lostworlds.library.item.forge;

import lostworlds.library.enums.DinoTypes;
import lostworlds.library.tab.ModItemGroup;
import lostworlds.library.util.ModRegistry;
import net.minecraft.item.Item;

public class ForgeFossilItem extends Item
{
	protected ForgeFossilItem()
	{
		super(new Properties().tab(ModItemGroup.ITEMS));
	}
	
	public static Item create(DinoTypes dino)
	{
		Item skull = new ForgeFossilItem();
		Item armBone = new ForgeFossilItem();
		Item legBone = new ForgeFossilItem();
		Item footBone = new ForgeFossilItem();
		Item ribBone = new ForgeFossilItem();
		ModRegistry.register(dino.toString().toLowerCase() + "_skull", skull);
		ModRegistry.register(dino.toString().toLowerCase() + "_arm_bone", armBone);
		ModRegistry.register(dino.toString().toLowerCase() + "_leg_bone", legBone);
		ModRegistry.register(dino.toString().toLowerCase() + "_foot_bone", footBone);
		ModRegistry.register(dino.toString().toLowerCase() + "_rib_bone", ribBone);
		return skull;
	}
}
