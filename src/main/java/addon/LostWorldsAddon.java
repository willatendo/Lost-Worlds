package addon;

import addon.officaladdons.ogpack.OGPack;
import lostworlds.core.util.ModUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = ModUtil.ID, value = Dist.CLIENT, bus = Bus.FORGE)
public class LostWorldsAddon 
{
	@SubscribeEvent
	public static void onPlayerLoad(final PlayerEvent.PlayerLoggedInEvent event)
	{
		if(OGPack.hasInit)
		{
			PlayerEntity player = event.getPlayer();
			event.getPlayer().sendMessage(new TranslationTextComponent("installed_ogpack"), player.getUUID());
		}
	}
}
