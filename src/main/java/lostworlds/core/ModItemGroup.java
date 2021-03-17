package lostworlds.core;

import lostworlds.core.tab.CreativeTab;
import lostworlds.core.util.reference.Reference;
import net.minecraft.item.ItemGroup;

public class ModItemGroup
{
	public static final ItemGroup TAB = new CreativeTab(Reference.ID).setBackgroundImageName("item_search.png");
}