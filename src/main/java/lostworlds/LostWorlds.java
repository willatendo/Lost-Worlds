package lostworlds;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lostworlds.common.items.ModSpawnEggItem;
import lostworlds.core.init.BlockInit;
import lostworlds.core.util.ModID;
import lostworlds.core.util.registry.ModRegistry;
import lostworlds.core.vanilla.properties.ModFlammables;
import lostworlds.core.vanilla.properties.ModStrippables;
import lostworlds.world.dimension.jurassic.JurassicDimension;
import lostworlds.world.dimension.jurassic.JurassicDimensionRenderInfo;
import lostworlds.world.dimension.permian.PermianDimension;
import lostworlds.world.dimension.permian.PermianDimensionRenderInfo;
import lostworlds.world.init.BiomeInit;
import lostworlds.world.init.ConfiguredFeatureInit;
import lostworlds.world.init.FeatureInit;
import lostworlds.world.init.OrePlaceFeature;
import lostworlds.world.init.WorldCarverInit;
import net.minecraft.block.ComposterBlock;
import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;

@Mod(ModID.ID)
@Mod.EventBusSubscriber(modid = ModID.ID, bus = Bus.MOD)
public class LostWorlds
{
    public static final Logger LOGGER = LogManager.getLogger(ModID.ID);
    public static boolean DISABLE_IN_DEV = false;

	public LostWorlds() 
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadComplete);

        //Main Objects
        ModRegistry.registry(); 
        
        //Lib - 3.0.30
        GeckoLib.initialize();
        
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OrePlaceFeature::generateOre);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, BiomeInit::addBiomesToOverworld);
    }

	
    @SuppressWarnings("deprecation")
	private void setup(final FMLCommonSetupEvent event)
    {
    	DeferredWorkQueue.runLater(() -> 
    	{
    		ComposterBlock.add(0.6F, BlockInit.CONIFER_LEAVES.get());
    		ComposterBlock.add(0.6F, BlockInit.GINKGO_LEAVES.get());
    		ComposterBlock.add(0.4F, BlockInit.SMALL_PERMIAN_DESERT_PLANT.get());
    		ComposterBlock.add(0.6F, BlockInit.MEDIUM_PERMIAN_DESERT_PLANT.get());
    		ComposterBlock.add(0.8F, BlockInit.LARGE_PERMIAN_DESERT_PLANT.get());
    		ComposterBlock.add(0.6F, BlockInit.GROUND_FERNS.get());
    		ComposterBlock.add(0.6F, BlockInit.CONIFER_SAPLING.get());
    		ComposterBlock.add(0.6F, BlockInit.ARAUCARIA_SAPLING.get());
    		ComposterBlock.add(0.6F, BlockInit.GINKGO_SAPLING.get());
   	});
    	
    	event.enqueueWork(() -> 
    	{
    		PermianDimension.init();
    		JurassicDimension.init();
    	});
    }
    
    @SubscribeEvent
	public static void onRegisterWorldCarvers(Register<WorldCarver<?>> event)
	{
		WorldCarverInit.init(event);
	}
    
    @SubscribeEvent
	public static void onRegisterFeatures(Register<Feature<?>> event)
	{
		FeatureInit.init(event);
		ConfiguredFeatureInit.init();
	}

	public void clientSetup(FMLClientSetupEvent event) 
    {
        DimensionRenderInfo permian = new PermianDimensionRenderInfo();
        DimensionRenderInfo.EFFECTS.put(new ResourceLocation(ModID.ID, "permian_render"), permian);
        
        DimensionRenderInfo jurassic = new JurassicDimensionRenderInfo();
        DimensionRenderInfo.EFFECTS.put(new ResourceLocation(ModID.ID, "jurassic_render"), jurassic);
    }
    
    private void loadComplete(FMLLoadCompleteEvent event)
    {
    	ModStrippables.strippingMap();
    	ModFlammables.flammables();
    }
    
    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event)
	{
		ModSpawnEggItem.initSpawnEggs();
	}
}
