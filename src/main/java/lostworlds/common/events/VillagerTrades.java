package lostworlds.common.events;

import lostworlds.common.villager.ModVillagerTrades;
import lostworlds.core.util.ModUtil;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = ModUtil.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class VillagerTrades 
{
	@SubscribeEvent
	public static void initVillagerTradesArray(FMLCommonSetupEvent event)
	{
		event.enqueueWork(() -> {
			ModVillagerTrades.fillTradeData();
		});
	}
}
