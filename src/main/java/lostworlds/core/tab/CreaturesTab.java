package lostworlds.core.tab;

import lostworlds.core.init.ItemInit;
import lostworlds.core.util.ModUtil;
import net.minecraft.item.ItemStack;

public class CreaturesTab extends BaseTab
{
	public CreaturesTab() 
	{
		super(ModUtil.ID + "." + ModUtil.ID + "_creatures");
	}

	@Override
	public ItemStack makeIcon() 
	{
		return ItemInit.ALLOSAURUS_DNA.get().getDefaultInstance();
	}
}
