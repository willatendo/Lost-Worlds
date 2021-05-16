package lostworlds.client.event;

import lostworlds.core.init.ItemInit;
import lostworlds.core.util.ModID;
import lostworlds.world.dimension.jurassic.JurassicDimension;
import lostworlds.world.dimension.permian.PermianDimension;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = ModID.ID, value = Dist.CLIENT, bus = Bus.FORGE)
public class TimeBookUse 
{
	@SubscribeEvent
	public static void onJurassicBookUse(final PlayerInteractEvent.RightClickItem event)
	{
		if(event.getItemStack().getItem() == ItemInit.JURASSIC_TIME_BOOK.get())
		{
			PlayerEntity player = event.getPlayer();
			
			if(player.level.dimension() == JurassicDimension.JURASSIC_WORLD)
			{
				event.getPlayer().sendMessage(new TranslationTextComponent(ModID.ID + ".transport_to_overworld"), player.getUUID());
			}
			else
			{
				event.getPlayer().sendMessage(new TranslationTextComponent(ModID.ID + ".transport_to_jurassic"), player.getUUID());
			}
		}
	}
	
	@SubscribeEvent
	public static void onPermianBookUse(final PlayerInteractEvent.RightClickItem event)
	{
		if(event.getItemStack().getItem() == ItemInit.PERMIAN_TIME_BOOK.get())
		{
			PlayerEntity player = event.getPlayer();
			
			if(player.level.dimension() == PermianDimension.PERMIAN_WORLD)
			{
				event.getPlayer().sendMessage(new TranslationTextComponent(ModID.ID + ".transport_to_overworld"), player.getUUID());
			}
			else
			{
				event.getPlayer().sendMessage(new TranslationTextComponent(ModID.ID + ".transport_to_permian"), player.getUUID());
			}
		}
	}
}
