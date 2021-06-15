package addon.officaladdons.ogpack.util;

import addon.officaladdons.ogpack.init.BlockInit;
import addon.officaladdons.ogpack.init.EntityInit;
import addon.officaladdons.ogpack.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AddonRegistry 
{
	public static final DeferredRegister<Item> ITEM_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, AddonUtil.ID);
	public static final DeferredRegister<Block> BLOCK_REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, AddonUtil.ID);
	public static final DeferredRegister<EntityType<?>> ENTITY_REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, AddonUtil.ID);
	
	public static void registry()
	{
		final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ITEM_REGISTER.register(bus);
		BLOCK_REGISTER.register(bus);
		ENTITY_REGISTER.register(bus);
		
		BlockInit.initBlocks();
		ItemInit.initItems();
		EntityInit.initEntities();
	}
}
