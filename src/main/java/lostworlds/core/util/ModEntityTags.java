package lostworlds.core.util;

import net.minecraft.entity.EntityType;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ITagCollectionSupplier;
import net.minecraft.tags.TagRegistry;
import net.minecraft.tags.TagRegistryManager;
import net.minecraft.util.ResourceLocation;

public class ModEntityTags 
{
	protected static final TagRegistry<EntityType<?>> HELPER = TagRegistryManager.create(new ResourceLocation(ModID.ID, "entity_type"), ITagCollectionSupplier::getEntityTypes);
	public static final ITag.INamedTag<EntityType<?>> DIICTODON_BURROW_INHABITORS = bind("diictodon_burrow_inhabitors");

	public static ITag.INamedTag<EntityType<?>> bind(String id) 
	{
		return HELPER.bind(id);
	}
}
