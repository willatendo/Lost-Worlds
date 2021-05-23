package lostworlds.common.villager;

import lostworlds.core.init.ItemInit;
import lostworlds.core.init.VillagerProfessionInit;
import lostworlds.core.util.ModUtil;
import net.minecraft.item.Items;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ModUtil.ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModVillagerTrades
{
	@SubscribeEvent
    public static void registerTrades(VillagerTradesEvent event)
	{
        if(event.getType() == VillagerProfessionInit.ARCHAEOLOGIST.get())
        {
        	event.getTrades().get(1).add((new ModVillagerTradesBuilder(1, 10, 0.05F).setEmeraldPrice(5).setForSale(ItemInit.ARCHAEOLOGY_TABLE.get(), 1, 2).build()));
        	event.getTrades().get(1).add((new ModVillagerTradesBuilder(5, 10, 0.05F).setEmeraldPrice(5).setForSale(Items.CLAY, 1, 2).build()));
        	event.getTrades().get(1).add((new ModVillagerTradesBuilder(30, 10, 0.05F).setEmeraldPrice(5).setForSale(Items.CLAY_BALL, 1, 2).build()));
        	event.getTrades().get(3).add((new ModVillagerTradesBuilder(1, 10, 0.05F).setEmeraldPrice(64).setEmeraldPrice(64).setForSale(ItemInit.PERMIAN_TIME_BOOK.get(), 1, 1).build()));
        	event.getTrades().get(3).add((new ModVillagerTradesBuilder(1, 10, 0.05F).setEmeraldPrice(64).setEmeraldPrice(64).setForSale(ItemInit.JURASSIC_TIME_BOOK.get(), 1, 1).build()));
        	event.getTrades().get(4).add((new ModVillagerTradesBuilder(1, 14, 0.05F).setEmeraldPrice(64).setForSale(Items.LODESTONE, 1, 1).build()));
        	event.getTrades().get(5).add((new ModVillagerTradesBuilder(1, 40, 0.05F).setEmeraldPrice(64).setForSale(ItemInit.BROKEN_CRYSTAL_SCARAB_GEM.get(), 1, 1).build()));
        }
	}
}
