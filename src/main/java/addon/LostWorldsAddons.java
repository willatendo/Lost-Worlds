package addon;

import addon.officaladdons.ogpack.OGPack;
import lostworlds.LostWorlds;
import lostworlds.core.util.ModUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = ModUtil.ID, value = Dist.CLIENT, bus = Bus.FORGE)
public class LostWorldsAddons 
{
	@SubscribeEvent
	public static void onPlayerLoad(final PlayerEvent.PlayerLoggedInEvent event)
	{
		PlayerEntity player = event.getPlayer();
		event.getPlayer().sendMessage(ModUtil.tTC("installed_packs"), player.getUUID());
		if(LostWorlds.hasInitilised)
		{
			event.getPlayer().sendMessage(ModUtil.tTC("installed_mod"), player.getUUID());
		}
		if(OGPack.hasInitilised)
		{
			event.getPlayer().sendMessage(ModUtil.tTC("installed_ogpack"), player.getUUID());
		}
	}
}	
