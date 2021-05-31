package lostworlds.core.tab;

import lostworlds.core.init.ItemInit;
import lostworlds.core.util.ModUtil;
import net.minecraft.item.ItemStack;

public class MachinesTab extends BaseTab
{
	public MachinesTab() 
	{
		super(ModUtil.ID + "." + ModUtil.ID + "_machines");
	}

	@Override
	public ItemStack makeIcon() 
	{
		return ItemInit.ARCHAEOLOGY_TABLE.get().getDefaultInstance();
	}
}
