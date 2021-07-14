package lostworlds.addon.addonobjects;

import lostworlds.library.item.forge.ForgeBlockItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

/*
 * Author: Willatendo
 * Date: July 10, 2021
 */

public class AddonBlockAndItem 
{
	public static Block create(String addonId, String id, Block block)
	{
		Item item = new ForgeBlockItem(() -> block);
		block.setRegistryName(new ResourceLocation(addonId, id));
		ForgeRegistries.BLOCKS.register(block);
		item.setRegistryName(new ResourceLocation(addonId, id));
		ForgeRegistries.ITEMS.register(item);
		return block;
	}
}
