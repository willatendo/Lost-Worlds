package lostworlds.core.util;

import net.minecraft.block.Block;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ITagCollectionSupplier;
import net.minecraft.tags.TagRegistry;
import net.minecraft.tags.TagRegistryManager;
import net.minecraft.util.ResourceLocation;

public class ModBlockTags 
{
	protected static final TagRegistry<Block> HELPER = TagRegistryManager.create(new ResourceLocation("block"), ITagCollectionSupplier::getBlocks);
	public static final ITag.INamedTag<Block> DIICTODON_BURROW = bind("diictodon_burrow");

	public static ITag.INamedTag<Block> bind(String id) 
	{
		return HELPER.bind(id);
	}
}
