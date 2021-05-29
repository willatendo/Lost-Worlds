package lostworlds;

import lostworlds.common.items.ModSpawnEggItem;
import lostworlds.core.init.BlockInit;
import lostworlds.core.util.ModUtil;
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

@Mod(ModUtil.ID)
@Mod.EventBusSubscriber(modid = ModUtil.ID, bus = Bus.MOD)
public class LostWorlds
{
	public LostWorlds() 
	{
		ModUtil.LOGGER.debug("Loading: The Lost Worlds");
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadComplete);

		ModRegistry.registry(); 
		
		//Lib - V. 3.0.30
		GeckoLib.initialize();
		
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OrePlaceFeature::generateOre);
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, BiomeInit::addBiomesToOverworld);

		ModUtil.LOGGER.debug("Finished: The Lost Worlds");
	}

	
	@SuppressWarnings("deprecation")
	private void setup(final FMLCommonSetupEvent event)
	{
		DeferredWorkQueue.runLater(() -> 
		{
			ModUtil.LOGGER.debug("Loading: Registering Compostables");
			
			ComposterBlock.add(0.6F, BlockInit.CONIFER_LEAVES.get());
			ComposterBlock.add(0.6F, BlockInit.ARAUCARIA_LEAVES.get());
			ComposterBlock.add(0.6F, BlockInit.GINKGO_LEAVES.get());
			ComposterBlock.add(0.4F, BlockInit.SMALL_PERMIAN_DESERT_PLANT.get());
			ComposterBlock.add(0.6F, BlockInit.MEDIUM_PERMIAN_DESERT_PLANT.get());
			ComposterBlock.add(0.8F, BlockInit.LARGE_PERMIAN_DESERT_PLANT.get());
			ComposterBlock.add(0.6F, BlockInit.GROUND_FERNS.get());
			ComposterBlock.add(0.6F, BlockInit.CONIFER_SAPLING.get());
			ComposterBlock.add(0.6F, BlockInit.ARAUCARIA_SAPLING.get());
			ComposterBlock.add(0.6F, BlockInit.GINKGO_SAPLING.get());
			
			ModUtil.LOGGER.debug("Finished: Registering Compostables");
		});
		
		event.enqueueWork(() -> 
		{
			ModUtil.LOGGER.debug("Loading: Making Dimension Pieces");

			PermianDimension.init();
			JurassicDimension.init();

			ModUtil.LOGGER.debug("Finished: Making Dimension Pieces");
		});
	}
	
	@SubscribeEvent
	public static void onRegisterWorldCarvers(Register<WorldCarver<?>> event)
	{
		ModUtil.LOGGER.debug("Loading: Making World Carvers");

		WorldCarverInit.init(event);

		ModUtil.LOGGER.debug("Finished: Making World Carvers");
	}
	
	@SubscribeEvent
	public static void onRegisterFeatures(Register<Feature<?>> event)
	{
		ModUtil.LOGGER.debug("Loading: Making Features");

		FeatureInit.init(event);
		ConfiguredFeatureInit.init();

		ModUtil.LOGGER.debug("Finished: Making Features");
	}

	public void clientSetup(FMLClientSetupEvent event) 
	{
		ModUtil.LOGGER.debug("Loading: Dimension Renders");

		DimensionRenderInfo permian = new PermianDimensionRenderInfo();
		DimensionRenderInfo.EFFECTS.put(new ResourceLocation(ModUtil.ID, "permian_render"), permian);
		
		DimensionRenderInfo jurassic = new JurassicDimensionRenderInfo();
		DimensionRenderInfo.EFFECTS.put(new ResourceLocation(ModUtil.ID, "jurassic_render"), jurassic);

		ModUtil.LOGGER.debug("Finished: Dimension Renders");
	}
	
	private void loadComplete(FMLLoadCompleteEvent event)
	{
		ModUtil.LOGGER.debug("Loading: Vanilla Maps");
		
		ModStrippables.strippingMap();
		ModFlammables.flammables();
		
		ModUtil.LOGGER.debug("Finished: Vanilla Maps");
	}
	
	@SubscribeEvent
	public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event)
	{
		ModUtil.LOGGER.debug("Loading: Spawn Eggs");
		
		ModSpawnEggItem.initSpawnEggs();
		
		ModUtil.LOGGER.debug("Finished: Spawn Eggs");
	}
}
