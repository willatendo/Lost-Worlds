package library.tab;

import api.core.init.ItemInit;
import library.util.ModUtil;
import net.minecraft.item.ItemStack;

public class FossilsTab extends BaseTab
{
	public FossilsTab() 
	{
		super(ModUtil.ID + "." + ModUtil.ID + "_fossils");
	}

	@Override
	public ItemStack makeIcon() 
	{
		return ItemInit.EXPOSED_STONE_FOSSIL.get().getDefaultInstance();
	}
}
