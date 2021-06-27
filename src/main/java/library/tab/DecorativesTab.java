package library.tab;

import api.core.init.ItemInit;
import library.util.ModUtil;
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
