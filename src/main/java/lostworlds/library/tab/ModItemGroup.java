package lostworlds.library.tab;

import net.minecraft.item.ItemGroup;

public class ModItemGroup 
{
	public static final ItemGroup ITEMS = new ItemsTab();
	public static final ItemGroup BLOCKS = new BlocksTab();
	public static final ItemGroup LOST_WORLDS = new LostWorldsTab().setBackgroundSuffix("item_search.png");
}
