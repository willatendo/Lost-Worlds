package lostworlds.client;

import lostworlds.core.init.BlockInit;
import lostworlds.core.init.ItemInit;
import lostworlds.core.util.ModUtil;
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
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = ModUtil.ID, value = Dist.CLIENT, bus = Bus.MOD)
public class BlockColourManager 
{
	@SubscribeEvent
	public static void onBlockColoursInit(ColorHandlerEvent.Block event) 
	{
		ModUtil.LOGGER.debug("Loading: Biome Block Colours");
    	
    	BlockColors blockColours = event.getBlockColors();
		
		blockColours.register((unknown, lightReader, pos, unknown2) -> lightReader != null && pos != null ? BiomeColors.getAverageGrassColor(lightReader, pos) : GrassColors.get(0.5D, 1.0D), BlockInit.GROUND_FERNS.get());
		blockColours.register((unknown, lightReader, pos, unknown2) -> lightReader != null && pos != null ? BiomeColors.getAverageFoliageColor(lightReader, pos) : FoliageColors.get(0.5D, 1.0D), BlockInit.DICKSONIA.get(), BlockInit.TALL_DICKSONIA.get(), BlockInit.CYCAD.get(), BlockInit.ARAUCARIA_LEAVES.get(), BlockInit.CONIFER_LEAVES.get(), BlockInit.GINKGO_LEAVES.get());
		
		ModUtil.LOGGER.debug("Finished: Biome Block Colours");
	}
	
	@SubscribeEvent
	public static void onItemColorsInit(ColorHandlerEvent.Item event) 
	{
    	ModUtil.LOGGER.debug("Loading: Biome Item Colours");
    	
    	final BlockColors blockColours = event.getBlockColors();
		final ItemColors itemColours = event.getItemColors();
		
		IItemColor itemBlockColourHandler = (stack, tintIndex) ->
		{
			BlockState state = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
			return blockColours.getColor(state, null, null, tintIndex);
		};
		
		if(itemBlockColourHandler != null) 
		{
			itemColours.register(itemBlockColourHandler, ItemInit.GROUND_FERNS.get(), ItemInit.DICKSONIA.get(), ItemInit.TALL_DICKSONIA.get(), ItemInit.CYCAD.get(), ItemInit.ARAUCARIA_LEAVES.get(), ItemInit.CONIFER_LEAVES.get(), ItemInit.GINKGO_LEAVES.get());
		}
		
		ModUtil.LOGGER.debug("Loading: Biome Item Colours");
	}
}