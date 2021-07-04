package lostworlds.content;

import lostworlds.content.server.config.LostWorldsConfig;
import lostworlds.library.dimension.permian.PermianInit;
import lostworlds.library.util.ModRegistry;
import lostworlds.library.util.ModUtil;
import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;

/*
 * Author: Willatendo
 * Date: July 2, 2021
 */

@Mod("lostworlds")
public class LostWorlds 
{
	public LostWorlds() 
	{
		ModUtil.LOGGER.debug("Starting: Lost Worlds Registration");
		
		//Setup
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);
		
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, LostWorldsConfig.serverSpec);
		
		//Objects
		final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		ModRegistry.register(bus);
		
		//v3.0.30
		GeckoLib.initialize();
		
		ModUtil.LOGGER.debug("Finished: Lost Worlds Registration");
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		event.enqueueWork(() -> 
		{
			ModUtil.LOGGER.debug("Loading: Making Dimension Pieces");

			PermianInit.init();

			ModUtil.LOGGER.debug("Finished: Making Dimension Pieces");
		});	
	}
	
	private void setupClient(FMLClientSetupEvent event) 
	{
		ModUtil.LOGGER.debug("Loading: Dimension Renders");
		
		DimensionRenderInfo permian = new DimensionRenderInfo.Overworld();
		DimensionRenderInfo.EFFECTS.put(ModUtil.rL("permian_render"), permian);
		
		ModUtil.LOGGER.debug("Finished: Dimension Renders");
	}
}