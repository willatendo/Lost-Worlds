package api.client;

import api.client.entity.render.AllosaurusRender;
import api.client.entity.render.CarnotaurusRender;
import api.client.entity.render.ChilesaurusRender;
import api.client.entity.render.CryolophosaurusRender;
import api.client.entity.render.DiictodonRender;
import api.client.entity.render.DimetrodonRender;
import api.client.entity.render.EdaphosaurusRender;
import api.client.entity.render.FukuivenatorRender;
import api.client.entity.render.GiganotosaurusRender;
import api.client.entity.render.GorgonopsRender;
import api.client.entity.render.GreatAukRender;
import api.client.entity.render.KentrosaurusRender;
import api.client.entity.render.LiaoningosaurusRender;
import api.client.entity.render.NautilusRender;
import api.client.entity.render.OstromiaRender;
import api.client.entity.render.OuranosaurusRender;
import api.client.entity.render.PalaeoniscumRender;
import api.client.entity.render.ProcompsognathusRender;
import api.client.entity.render.ProtosuchusRender;
import api.client.entity.render.PsittacosaurusRender;
import api.client.entity.render.RhinesuchusRender;
import api.client.entity.render.SuchomimusRender;
import api.client.entity.render.TetraceratopsRender;
import api.client.entity.render.TyrannosaurusRender;
import api.client.entity.render.UtahraptorRender;
import api.client.entity.render.ZephyrosaurusRender;
import api.client.screen.machines.AnalyserScreen;
import api.client.screen.machines.DNAExtractorScreen;
import api.client.screen.machines.DNAInjectorScreen;
import api.client.screen.machines.FossilCleanerScreen;
import api.client.screen.machines.FossilGrinderScreen;
import api.client.screen.pottery.KylixScreen;
import api.client.tileentityrender.KylixTileEntityRender;
import api.core.init.BlockInit;
import api.core.init.ContainerInit;
import api.core.init.EntityInit;
import api.core.init.TileEntityInit;
import library.entites.ModBoatRender;
import library.util.ModUtil;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.tileentity.SignTileEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ModUtil.ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientSetup 
{
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event)
	{
    	ModUtil.LOGGER.debug("Loading: Setting Up Client Render");
    	    	
    	//Blocks
		//Fossils
    	RenderTypeLookup.setRenderLayer(BlockInit.EXPOSED_STONE_FOSSIL.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.EXPOSED_SANDSTONE_FOSSIL.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.EXPOSED_RED_SANDSTONE_FOSSIL.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.EXPOSED_TERRACOTTA_FOSSIL.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.EXPOSED_BLACK_TERRACOTTA_FOSSIL.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.EXPOSED_BLUE_TERRACOTTA_FOSSIL.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.EXPOSED_BROWN_TERRACOTTA_FOSSIL.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.EXPOSED_CYAN_TERRACOTTA_FOSSIL.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.EXPOSED_GREEN_TERRACOTTA_FOSSIL.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.EXPOSED_GREY_TERRACOTTA_FOSSIL.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.EXPOSED_LIGHT_BLUE_TERRACOTTA_FOSSIL.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.EXPOSED_LIGHT_GREY_TERRACOTTA_FOSSIL.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.EXPOSED_LIME_TERRACOTTA_FOSSIL.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.EXPOSED_MAGENTA_TERRACOTTA_FOSSIL.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.EXPOSED_ORANGE_TERRACOTTA_FOSSIL.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.EXPOSED_PINK_TERRACOTTA_FOSSIL.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.EXPOSED_PURPLE_TERRACOTTA_FOSSIL.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.EXPOSED_PURPLE_TERRACOTTA_FOSSIL.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.EXPOSED_RED_TERRACOTTA_FOSSIL.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.EXPOSED_WHITE_TERRACOTTA_FOSSIL.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.EXPOSED_YELLOW_TERRACOTTA_FOSSIL.get(), RenderType.translucent());
		
		//Plants
		RenderTypeLookup.setRenderLayer(BlockInit.SMALL_PERMIAN_DESERT_PLANT.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.MEDIUM_PERMIAN_DESERT_PLANT.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.LARGE_PERMIAN_DESERT_PLANT.get(), RenderType.cutout());
		
		RenderTypeLookup.setRenderLayer(BlockInit.GROUND_FERNS.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DICKSONIA.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.TALL_DICKSONIA.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.OSMUNDA.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.CYCAD.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.LYCOPHYTA.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.CEPHALOTAXUS.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DILLHOFFIA.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.POTTED_DILLHOFFIA.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DUISBERGIA.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.HORSETAIL.get(), RenderType.cutout());
		
		//Saplings
		RenderTypeLookup.setRenderLayer(BlockInit.CONIFER_SAPLING.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.GINKGO_SAPLING.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.ARAUCARIA_SAPLING.get(), RenderType.cutout());
		
		//Glass
		RenderTypeLookup.setRenderLayer(BlockInit.CLEAR_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.CLEAR_GLASS_PANE.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.TINTED_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.TINTED_GLASS_PANE.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.WHITE_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.WHITE_GLASS_PANE.get(), RenderType.translucent());		
		RenderTypeLookup.setRenderLayer(BlockInit.LIGHT_GREY_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.LIGHT_GREY_GLASS_PANE.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.GREY_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.GREY_GLASS_PANE.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.BLACK_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.BLACK_GLASS_PANE.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.RED_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.RED_GLASS_PANE.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.ORANGE_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.ORANGE_GLASS_PANE.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.YELLOW_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.YELLOW_GLASS_PANE.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.LIME_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.LIME_GLASS_PANE.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.GREEN_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.GREEN_GLASS_PANE.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.CYAN_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.CYAN_GLASS_PANE.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.LIGHT_BLUE_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.LIGHT_BLUE_GLASS_PANE.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.BLUE_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.BLUE_GLASS_PANE.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.PURPLE_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.PURPLE_GLASS_PANE.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.MAGENTA_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.MAGENTA_GLASS_PANE.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.PINK_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.PINK_GLASS_PANE.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.BROWN_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.BROWN_GLASS_PANE.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.SHADED_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.SHADED_GLASS_PANE.get(), RenderType.translucent());
		
		//Tree Stuff
		RenderTypeLookup.setRenderLayer(BlockInit.CONIFER_LEAVES.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.CONIFER_DOOR.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.CONIFER_TRAPDOOR.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.GINKGO_LEAVES.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.GINKGO_DOOR.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.GINKGO_TRAPDOOR.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.ARAUCARIA_LEAVES.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.ARAUCARIA_DOOR.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.ARAUCARIA_TRAPDOOR.get(), RenderType.translucent());
		
		//Doors
		RenderTypeLookup.setRenderLayer(BlockInit.OUTDOOR_TOILET_DOOR.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.GLASS_SHOP_DOOR.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.VISITOR_CENTRE_DOOR.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.INNOVATION_CENTRE_DOOR.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.SECURITY_DOOR.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.BACK_DOOR.get(), RenderType.translucent());
		
		//Machines
		RenderTypeLookup.setRenderLayer(BlockInit.FOSSIL_CLEANER.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.FOSSIL_GRINDER.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.DNA_EXTRACTOR.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.ANALYSER.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.DNA_INJECTOR.get(), RenderType.translucent());		
		
		//Tile Entity Render Binder
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.SIGN_TILE_ENTITY.get(), SignTileEntityRenderer::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.KYLIX_TILE_ENTITY.get(), KylixTileEntityRender::new);
		
		//Screens
		//ScreenManager.register(ContainerInit.TIME_MACHINE_CONTAINER.get(), TimeMachineScreen::new);
		ScreenManager.register(ContainerInit.FOSSIL_CLEANER_CONTAINER.get(), FossilCleanerScreen::new);
		ScreenManager.register(ContainerInit.FOSSIL_GRINDER_CONTAINER.get(), FossilGrinderScreen::new);
		ScreenManager.register(ContainerInit.DNA_EXTRACTOR_CONTAINER.get(), DNAExtractorScreen::new);
		ScreenManager.register(ContainerInit.ANALYSER_CONTAINER.get(), AnalyserScreen::new);
		ScreenManager.register(ContainerInit.DNA_INJECTOR_CONTAINER.get(), DNAInjectorScreen::new);

		ScreenManager.register(ContainerInit.KYLIX_CONTAINER.get(), KylixScreen::new);

		//Entities
		//Mobs
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.PROCOMPSOGNATHUS_ENTITY.get(), manager -> new ProcompsognathusRender(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.PALAEONISCUM_ENTITY.get(), manager -> new PalaeoniscumRender(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.NAUTILUS_ENTITY.get(), manager -> new NautilusRender(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.RHINESUCHUS_ENTITY.get(), manager -> new RhinesuchusRender(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.DIMETRODON_ENTITY.get(), manager -> new DimetrodonRender(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.EDAPHOSAURUS_ENTITY.get(), manager -> new EdaphosaurusRender(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.GORGONOPS_ENTITY.get(), manager -> new GorgonopsRender(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.CARNOTAURUS_ENTITY.get(), manager -> new CarnotaurusRender(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.TYRANNOSAURUS_ENTITY.get(), manager -> new TyrannosaurusRender(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.ALLOSAURUS_ENTITY.get(), manager -> new AllosaurusRender(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.GIGANOTOSAURUS_ENTITY.get(), manager -> new GiganotosaurusRender(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.SUCHOMIMUS_ENTITY.get(), manager -> new SuchomimusRender(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.TETRACERATOPS_ENTITY.get(), manager -> new TetraceratopsRender(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.GREAT_AUK_ENTITY.get(), manager -> new GreatAukRender(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.OURANOSAURUS_ENTITY.get(), manager -> new OuranosaurusRender(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.FUKUIVENATOR_ENTITY.get(), manager -> new FukuivenatorRender(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.PSITTACOSAURUS_ENTITY.get(), manager -> new PsittacosaurusRender(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.CRYOLOPHOSAURUS_ENTITY.get(), manager -> new CryolophosaurusRender(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.OSTROMIA_ENTITY.get(), manager -> new OstromiaRender(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.PROTOSUCHUS_ENTITY.get(), manager -> new ProtosuchusRender(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.DIICTODON_ENTITY.get(), manager -> new DiictodonRender(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.KENTROSAURUS_ENTITY.get(), manager -> new KentrosaurusRender(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.CHILESAURUS_ENTITY.get(), manager -> new ChilesaurusRender(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.LIAONINGOSAURUS_ENTITY.get(), manager -> new LiaoningosaurusRender(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.UTAHRAPTOR_ENTITY.get(), manager -> new UtahraptorRender(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.ZEPHYROSAURUS_ENTITY.get(), manager -> new ZephyrosaurusRender(manager));

		//Boat
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.BOAT.get(), manager -> new ModBoatRender(manager));
		
    	ModUtil.LOGGER.debug("Finished: Setting Up Client Render");
	}
}
