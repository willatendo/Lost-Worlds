package api.core.init;

import library.tab.CreaturesTab;
import library.tab.DecorativesTab;
import library.tab.FoodTab;
import library.tab.FossilsTab;
import library.tab.ItemsTab;
import library.tab.LostWorldsTab;
import library.tab.MachinesTab;
import library.tab.NatureTab;
import library.tab.SpawnTab;
import library.tab.ToolsTab;
import net.minecraft.item.ItemGroup;

public class ItemGroupInit
{
	public static final ItemGroup FOSSILS_TAB = new FossilsTab();
	public static final ItemGroup CREATURES_TAB = new CreaturesTab();
	public static final ItemGroup NATURE_TAB = new NatureTab();
	public static final ItemGroup MACHINES_TAB = new MachinesTab();
	public static final ItemGroup DECORATIVES_TAB = new DecorativesTab();
	public static final ItemGroup TOOLS_TAB = new ToolsTab();
	public static final ItemGroup ITEMS_TAB = new ItemsTab();
	public static final ItemGroup SPAWN_TAB = new SpawnTab();
	public static final ItemGroup FOOD_TAB = new FoodTab();
	public static final ItemGroup LOST_WORLDS_TAB = new LostWorldsTab();
}
