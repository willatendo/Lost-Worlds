package lostworlds.client;

import lostworlds.core.init.BlockInit;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.BlockItem;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.GrassColors;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockColourManager 
{
	 @SubscribeEvent
	 public static void onBlockColorsInit(ColorHandlerEvent.Block event) 
	 {
		 BlockColors blockColors = event.getBlockColors();
		 
		 blockColors.register((unknown, lightReader, pos, unknown2) -> lightReader != null && pos != null ? BiomeColors.getAverageGrassColor(lightReader, pos) : GrassColors.get(0.5D, 1.0D), BlockInit.PERMIAN_GROUND_FERNS.get());
		 blockColors.register((unknown, lightReader, pos, unknown2) -> lightReader != null && pos != null ? BiomeColors.getAverageFoliageColor(lightReader, pos) : FoliageColors.get(0.5D, 1.0D), BlockInit.CONIFER_LEAVES.get(), BlockInit.GINKGO_LEAVES.get());
	}
	 
	@SubscribeEvent
	public static void onItemColorsInit(ColorHandlerEvent.Item event) 
	{
		final BlockColors blockColors = event.getBlockColors();
		final ItemColors itemColors = event.getItemColors();
		
		IItemColor itemBlockColourHandler = (stack, tintIndex) ->
		{
			BlockState state = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
			return blockColors.getColor(state, null, null, tintIndex);
		};
		
		if(itemBlockColourHandler != null) 
		{
			itemColors.register(itemBlockColourHandler, BlockInit.PERMIAN_GROUND_FERNS.get(),BlockInit.CONIFER_LEAVES.get(), BlockInit.GINKGO_LEAVES.get());
		}
	}
}
