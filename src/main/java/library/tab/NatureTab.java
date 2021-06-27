package library.tab;

import api.core.init.ItemInit;
import library.util.ModUtil;
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
