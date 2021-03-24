package lostworlds;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lostworlds.common.items.ModSpawnEggItem;
import lostworlds.core.util.reference.ModReference;
import lostworlds.core.util.registry.ModRegistry;
import lostworlds.world.init.BiomeInit;
import lostworlds.world.init.FeatureInit;
import net.minecraft.entity.EntityType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;

@Mod(ModReference.ID)
@Mod.EventBusSubscriber(modid = ModReference.ID, bus = Bus.MOD)
public class LostWorlds
{
    public static final Logger LOGGER = LogManager.getLogger();

    public LostWorlds() 
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        ModRegistry.registry();
        
        //Lib - 3.0.15
        GeckoLib.initialize();
        
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, FeatureInit::generateOre);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, BiomeInit::addBiomesToOverworld);
        MinecraftForge.EVENT_BUS.addListener((BiomeLoadingEvent event) -> FeatureInit.addMobSpawning(event));
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	
    }
    
    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event)
	{
		ModSpawnEggItem.initSpawnEggs();
	}
}
