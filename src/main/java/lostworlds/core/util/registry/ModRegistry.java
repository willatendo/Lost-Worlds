package lostworlds.core.util.registry;

import lostworlds.core.init.BlockInit;
import lostworlds.core.init.EntityInit;
import lostworlds.core.init.ItemInit;
import lostworlds.core.init.SoundInit;
import lostworlds.core.util.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRegistry 
{
	public static final DeferredRegister<SoundEvent> SOUND_REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Reference.ID);
	public static final DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.ID);
	public static final DeferredRegister<Block> BLOCK_REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, Reference.ID);
	public static final DeferredRegister<EntityType<?>> ENTITY_REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, Reference.ID);
	
	public static void registry() 
	{
		SOUND_REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());
		ITEM_REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());
		BLOCK_REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());
		ENTITY_REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());
		
		SoundInit.initSounds();
		ItemInit.initItems();
		BlockInit.initBlocks();
		EntityInit.initEntities();
	}
}
