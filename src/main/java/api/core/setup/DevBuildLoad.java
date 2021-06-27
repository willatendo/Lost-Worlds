package api.core.setup;

import library.util.ModUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod.EventBusSubscriber(modid = ModUtil.ID, value = Dist.CLIENT, bus = Bus.FORGE)
public class DevBuildLoad 
{
	@SubscribeEvent
	public static void onDevBuildLoad(final PlayerEvent.PlayerLoggedInEvent event)
	{
		if(!FMLEnvironment.production && !ModUtil.DISABLE_IN_DEV)
		{
			PlayerEntity player = event.getPlayer();
			event.getPlayer().sendMessage(ModUtil.tTC("loadEvent", "dev"), player.getUUID());
		}
		else
		{
			PlayerEntity player = event.getPlayer();
			event.getPlayer().sendMessage(ModUtil.cTC("loadEvent", "player", TextFormatting.GOLD), player.getUUID());
		}
	}
}