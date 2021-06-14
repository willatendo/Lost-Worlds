package addons;

import lostworlds.LostWorlds;
import lostworlds.core.util.ModUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import ogpack.OGPack;

@Mod.EventBusSubscriber(modid = ModUtil.ID, value = Dist.CLIENT, bus = Bus.FORGE)
public class LostWorldsAddon 
{
	@SubscribeEvent
	public static void makeInstallationText(final PlayerEvent.PlayerLoggedInEvent event)
	{
		PlayerEntity player = event.getPlayer();
		event.getPlayer().sendMessage(ModUtil.tTC("installed_packs"), player.getUUID());
		if(LostWorlds.hasInitilised)
		{
			event.getPlayer().sendMessage(ModUtil.tTC("installed_mod"), player.getUUID());
		}
		if(OGPack.hasInitilised)
		{
			event.getPlayer().sendMessage(ModUtil.tTC("installed_og_pack"), player.getUUID());
		}
	}
}
