package lostworlds.client.event;

import lostworlds.LostWorlds;
import lostworlds.core.util.ModID;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod.EventBusSubscriber(modid = ModID.ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DevBuildLoad 
{
	@SubscribeEvent
	public static void onDevBuildLoad(final PlayerEvent.PlayerLoggedInEvent event)
	{
		if(!FMLEnvironment.production && !LostWorlds.DISABLE_IN_DEV)
		{
			PlayerEntity player = event.getPlayer();
			event.getPlayer().sendMessage(new TranslationTextComponent(ModID.ID + ".loadEvent.dev"), player.getUUID());
		}
		else
		{
			PlayerEntity player = event.getPlayer();
			event.getPlayer().sendMessage(new StringTextComponent("lostworlds.loadEvent.player"), player.getUUID());
		}
	}
}
