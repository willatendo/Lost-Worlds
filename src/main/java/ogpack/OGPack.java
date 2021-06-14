package ogpack;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class OGPack
{
	private static final String ID = "og_pack";
	public static boolean hasInitilised;
	
	private static final DeferredRegister<Item> PACK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ID);
	private static final DeferredRegister<Block> PACK_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ID);
	private static final DeferredRegister<EntityType<?>> PACK_ENITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, ID);
	
	public static void initOGPack() 
	{		
		final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		PACK_ITEMS.register(bus);
		PACK_BLOCKS.register(bus);
		PACK_ENITIES.register(bus);
		
		hasInitilised = true;
	}
	
	private static class OGPackItems
	{
		
		
		//Registry
		public static void initOGItems() { }
	}
	
	private static class OGPackBlocks
	{
		
		
		//Registry
		public static void initOGBlocks() { }
	}
	
	private static class OGPackEntities
	{
		
		
		//Registry
		public static void initOGEntities() { }
	}
}
