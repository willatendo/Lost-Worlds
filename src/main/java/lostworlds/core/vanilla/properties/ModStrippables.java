package lostworlds.core.vanilla.properties;

import com.google.common.collect.Maps;

import lostworlds.core.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.item.AxeItem;

public class ModStrippables
{
	public static void add(Block logBlock, Block strippedLogBlock)
	{
		AxeItem.STRIPABLES = Maps.newHashMap(AxeItem.STRIPABLES);
		AxeItem.STRIPABLES.put(logBlock, strippedLogBlock);
	}
	
	public static void strippingMap()
	{
		add(BlockInit.CONIFER_LOG.get(), BlockInit.STRIPPED_CONIFER_LOG.get());
		add(BlockInit.CONIFER_WOOD.get(), BlockInit.STRIPPED_CONIFER_WOOD.get());
		add(BlockInit.GINKGO_LOG.get(), BlockInit.STRIPPED_GINKGO_LOG.get());
		add(BlockInit.GINKGO_WOOD.get(), BlockInit.STRIPPED_GINKGO_WOOD.get());
		add(BlockInit.ARAUCARIA_LOG.get(), BlockInit.STRIPPED_ARAUCARIA_LOG.get());
		add(BlockInit.ARAUCARIA_WOOD.get(), BlockInit.STRIPPED_ARAUCARIA_WOOD.get());
	}
}
