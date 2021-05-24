package lostworlds.core;

import lostworlds.core.tab.CreaturesTab;
import lostworlds.core.tab.DecorativesTab;
import lostworlds.core.tab.FossilsTab;
import lostworlds.core.tab.ItemsTab;
import lostworlds.core.tab.LostWorldsTab;
import lostworlds.core.tab.MachinesTab;
import lostworlds.core.tab.NatureTab;
import lostworlds.core.tab.SpawnTab;
import lostworlds.core.tab.ToolsTab;
import net.minecraft.item.ItemGroup;

public class ModItemGroups
{
	public static final ItemGroup FOSSILS_TAB = new FossilsTab();
	public static final ItemGroup CREATURES_TAB = new CreaturesTab();
	public static final ItemGroup NATURE_TAB = new NatureTab();
	public static final ItemGroup MACHINES_TAB = new MachinesTab();
	public static final ItemGroup DECORATIVES_TAB = new DecorativesTab();
	public static final ItemGroup TOOLS_TAB = new ToolsTab();
	public static final ItemGroup ITEMS_TAB = new ItemsTab();
	public static final ItemGroup SPAWN_TAB = new SpawnTab();
	public static final ItemGroup LOST_WORLDS_TAB = new LostWorldsTab();
}
