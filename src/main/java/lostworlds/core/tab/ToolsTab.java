package lostworlds.core.tab;

import lostworlds.core.init.ItemInit;
import lostworlds.core.util.ModUtil;
import net.minecraft.item.ItemStack;

public class ToolsTab extends BaseTab
{
	public ToolsTab() 
	{
		super(ModUtil.ID + "." + ModUtil.ID + "_tools");
	}

	@Override
	public ItemStack makeIcon() 
	{
		return ItemInit.IRON_BRUSH.get().getDefaultInstance();
	}
}
