package lostworlds.core;

import lostworlds.core.tab.CreativeTab;
import lostworlds.core.util.reference.ModReference;
import net.minecraft.item.ItemGroup;

public class ModItemGroup
{
	@SuppressWarnings("deprecation")
	public static final ItemGroup TAB = new CreativeTab(ModReference.ID).setBackgroundSuffix("item_search.png");
}