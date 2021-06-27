package library.tab;

import api.core.init.ItemInit;
import library.util.ModUtil;
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
