package lostworlds.core.tab;

import lostworlds.core.init.ItemInit;
import lostworlds.core.util.ModUtil;
import net.minecraft.item.ItemStack;

public class DecorativesTab extends BaseTab
{
	public DecorativesTab() 
	{
		super(ModUtil.ID + "." + ModUtil.ID + "_decoratives");
	}

	@Override
	public ItemStack makeIcon() 
	{
		return ItemInit.LIGHT_CONCRETE.get().getDefaultInstance();
	}
}
