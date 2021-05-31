package lostworlds.core.tab;

import lostworlds.core.init.ItemInit;
import lostworlds.core.util.ModUtil;
import net.minecraft.item.ItemStack;

public class NatureTab extends BaseTab
{
	public NatureTab() 
	{
		super(ModUtil.ID + "." + ModUtil.ID + "_nature");
	}

	@Override
	public ItemStack makeIcon() 
	{
		return ItemInit.DICKSONIA.get().getDefaultInstance();
	}
}
