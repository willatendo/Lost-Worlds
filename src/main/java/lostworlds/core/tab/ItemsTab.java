package lostworlds.core.tab;

import lostworlds.core.init.ItemInit;
import lostworlds.core.util.ModUtil;
import net.minecraft.item.ItemStack;

public class ItemsTab extends BaseTab
{
	public ItemsTab() 
	{
		super(ModUtil.ID + "." + ModUtil.ID + "_items");
	}

	@Override
	public ItemStack makeIcon() 
	{
		return ItemInit.WET_PAPER.get().getDefaultInstance();
	}
}
