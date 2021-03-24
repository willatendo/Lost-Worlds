package lostworlds.client;

import lostworlds.client.entity.render.NautilusRender;
import lostworlds.client.entity.render.PalaeoniscumRender;
import lostworlds.client.entity.render.ProcompsognathusRender;
import lostworlds.core.init.BlockInit;
import lostworlds.core.init.EntityInit;
import lostworlds.core.util.reference.ModReference;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ModReference.ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup 
{
    @SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event)
	{
    	//Blocks
		RenderTypeLookup.setRenderLayer(BlockInit.EXPOSED_STONE_FOSSIL.get(), RenderType.translucent());
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
		//Entity
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.PROCOMPSOGNATHUS_ENTITY.get(), ProcompsognathusRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.PALAEONISCUM_ENTITY.get(), PalaeoniscumRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.NAUTILUS_ENTITY.get(), NautilusRender::new);
	}
}
