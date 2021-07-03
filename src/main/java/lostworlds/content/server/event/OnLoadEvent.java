package lostworlds.content.server.event;

import lostworlds.library.util.ModUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.loading.FMLEnvironment;

/*
 * Author: Willatendo
 * Date: July 2, 2021
 */

@Mod.EventBusSubscriber(modid = ModUtil.ID, bus = Bus.FORGE, value = Dist.CLIENT)
public class OnLoadEvent 
{
	@SubscribeEvent
	public static void onLoadEvent(final PlayerEvent.PlayerLoggedInEvent event)
	{
		if(!FMLEnvironment.production && !ModUtil.DISABLE_IN_DEV)
		{
			PlayerEntity player = event.getPlayer();
			player.sendMessage(ModUtil.gTC("event", "dev_load"), player.getUUID());
		}
		else
		{
			PlayerEntity player = event.getPlayer();
			player.sendMessage(ModUtil.gTC("event", "player_load"), player.getUUID());
		}
	}
}
