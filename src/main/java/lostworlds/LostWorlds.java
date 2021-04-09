package lostworlds;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lostworlds.common.items.ModSpawnEggItem;
import lostworlds.core.init.BlockInit;
import lostworlds.core.util.ModID;
import lostworlds.core.util.registry.ModRegistry;
import lostworlds.core.vanilla.properties.ModStrippables;
import lostworlds.world.init.BiomeInit;
import lostworlds.world.init.ModFeatures;
import net.minecraft.block.ComposterBlock;
import net.minecraft.entity.EntityType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;

@Mod(ModID.ID)
@Mod.EventBusSubscriber(modid = ModID.ID, bus = Bus.MOD)
public class LostWorlds
{
    public static final Logger LOGGER = LogManager.getLogger();

    public LostWorlds() 
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadComplete);

        //Main Objects
        ModRegistry.registry();
        
        //Dimensions
 //     PermianDimension.init();
        
        //Lib - 3.0.15
        GeckoLib.initialize();
        
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, ModFeatures::generateOre);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, BiomeInit::addBiomesToOverworld);
        MinecraftForge.EVENT_BUS.addListener((BiomeLoadingEvent event) -> ModFeatures.addMobSpawning(event));
    }

    @SuppressWarnings("deprecation")
	private void setup(final FMLCommonSetupEvent event)
    {
    	DeferredWorkQueue.runLater(() -> 
    	{
    		ComposterBlock.add(0.6F, BlockInit.CONIFER_LEAVES.get());
    	});
    	DeferredWorkQueue.runLater(() -> 
    	{
    		ComposterBlock.add(0.4F, BlockInit.SMALL_PERMIAN_DESERT_PLANT.get());
    	});
    	DeferredWorkQueue.runLater(() -> 
    	{
    		ComposterBlock.add(0.6F, BlockInit.MEDIUM_PERMIAN_DESERT_PLANT.get());
    	});
    	DeferredWorkQueue.runLater(() -> 
    	{
    		ComposterBlock.add(0.8F, BlockInit.LARGE_PERMIAN_DESERT_PLANT.get());
    	});
    	DeferredWorkQueue.runLater(() -> 
    	{
    		ComposterBlock.add(0.6F, BlockInit.PERMIAN_GROUND_FERNS.get());
    	});
    }
    
    private void loadComplete(FMLLoadCompleteEvent event)
    {
    	ModStrippables.strippingMap();
    }
    
    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event)
	{
		ModSpawnEggItem.initSpawnEggs();
	}
}
