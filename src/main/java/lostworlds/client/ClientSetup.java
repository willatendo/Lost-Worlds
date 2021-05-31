package lostworlds.client;

import lostworlds.client.entity.render.AllosaurusRender;
import lostworlds.client.entity.render.CarnotaurusRender;
import lostworlds.client.entity.render.ChilesaurusRender;
import lostworlds.client.entity.render.CryolophosaurusRender;
import lostworlds.client.entity.render.DiictodonRender;
import lostworlds.client.entity.render.DimetrodonRender;
import lostworlds.client.entity.render.EdaphosaurusRender;
import lostworlds.client.entity.render.FukuivenatorRender;
import lostworlds.client.entity.render.GiganotosaurusRender;
import lostworlds.client.entity.render.GorgonopsRender;
import lostworlds.client.entity.render.GreatAukRender;
import lostworlds.client.entity.render.KentrosaurusRender;
import lostworlds.client.entity.render.NautilusRender;
import lostworlds.client.entity.render.OstromiaRender;
import lostworlds.client.entity.render.OuranosaurusRender;
import lostworlds.client.entity.render.PalaeoniscumRender;
import lostworlds.client.entity.render.ProcompsognathusRender;
import lostworlds.client.entity.render.ProtosuchusRender;
import lostworlds.client.entity.render.PsittacosaurusRender;
import lostworlds.client.entity.render.RhinesuchusRender;
import lostworlds.client.entity.render.SuchomimusRender;
import lostworlds.client.entity.render.TetraceratopsRender;
import lostworlds.client.entity.render.TyrannosaurusRender;
import lostworlds.common.entities.ModBoatRender;
import lostworlds.core.init.BlockInit;
import lostworlds.core.init.EntityInit;
import lostworlds.core.init.TileEntityInit;
import lostworlds.core.util.ModUtil;
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

@Mod.EventBusSubscriber(modid = ModUtil.ID, value = Dist.CLIENT, bus = Bus.MOD)
public class ClientSetup 
{
    @SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event)
	{
    	ModUtil.LOGGER.debug("Loading: Setting Up Client Render");
    	
    	//Blocks
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
		RenderTypeLookup.setRenderLayer(BlockInit.SMALL_PERMIAN_DESERT_PLANT.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.MEDIUM_PERMIAN_DESERT_PLANT.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.LARGE_PERMIAN_DESERT_PLANT.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DICKSONIA.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.TALL_DICKSONIA.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.OSMUNDA.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.CYCAD.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.LYCOPHYTA.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.CEPHALOTAXUS.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DILLHOFFIA.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.POTTED_DILLHOFFIA.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DUISBERGIA.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.CONIFER_SAPLING.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.GINKGO_SAPLING.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.ARAUCARIA_SAPLING.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.GROUND_FERNS.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.CLEAR_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.CLEAR_GLASS_PANE.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.TINTED_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.TINTED_GLASS_PANE.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.OUTDOOR_TOILET_DOOR.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.GLASS_SHOP_DOOR.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.VISITOR_CENTRE_DOOR.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.INNOVATION_CENTRE_DOOR.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.SECURITY_DOOR.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.BACK_DOOR.get(), RenderType.translucent());
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
		RenderTypeLookup.setRenderLayer(BlockInit.CONIFER_LEAVES.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.CONIFER_DOOR.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.CONIFER_TRAPDOOR.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.GINKGO_LEAVES.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.GINKGO_DOOR.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.GINKGO_TRAPDOOR.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.ARAUCARIA_LEAVES.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.ARAUCARIA_DOOR.get(), RenderType.translucent());	
		RenderTypeLookup.setRenderLayer(BlockInit.ARAUCARIA_TRAPDOOR.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.ARCHAEOLOGY_TABLE.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.FOSSIL_CLEANER.get(), RenderType.translucent());
		
		//Sign
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.SIGN_TILE_ENTITY.get(), SignTileEntityRenderer::new);

		//ScreenManager.register(ContainerInit.TIME_MACHINE_CONTAINER.get(), TimeMachineScreen::new);

		//EntitiesS
		//Mobs
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.PROCOMPSOGNATHUS_ENTITY.get(), ProcompsognathusRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.PALAEONISCUM_ENTITY.get(), PalaeoniscumRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.NAUTILUS_ENTITY.get(), NautilusRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.RHINESUCHUS_ENTITY.get(), RhinesuchusRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.DIMETRODON_ENTITY.get(), DimetrodonRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.EDAPHOSAURUS_ENTITY.get(), EdaphosaurusRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.GORGONOPS_ENTITY.get(), GorgonopsRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.CARNOTAURUS_ENTITY.get(), CarnotaurusRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.TYRANNOSAURUS_ENTITY.get(), TyrannosaurusRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.ALLOSAURUS_ENTITY.get(), AllosaurusRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.GIGANOTOSAURUS_ENTITY.get(), GiganotosaurusRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.SUCHOMIMUS_ENTITY.get(), SuchomimusRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.TETRACERATOPS_ENTITY.get(), TetraceratopsRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.GREAT_AUK_ENTITY.get(), GreatAukRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.OURANOSAURUS_ENTITY.get(), OuranosaurusRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.FUKUIVENATOR_ENTITY.get(), FukuivenatorRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.PSITTACOSAURUS_ENTITY.get(), PsittacosaurusRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.CRYOLOPHOSAURUS_ENTITY.get(), CryolophosaurusRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.OSTROMIA_ENTITY.get(), OstromiaRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.PROTOSUCHUS_ENTITY.get(), ProtosuchusRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.DIICTODON_ENTITY.get(), DiictodonRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.KENTROSAURUS_ENTITY.get(), KentrosaurusRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.CHILESAURUS_ENTITY.get(), ChilesaurusRender::new);
		
		//Boat
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.BOAT.get(), ModBoatRender::new);
		
    	ModUtil.LOGGER.debug("Finished: Setting Up Client Render");
	}
}
