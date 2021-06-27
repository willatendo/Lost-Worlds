package library.tab;

import api.core.init.ItemInit;
import library.util.ModUtil;
import net.minecraft.item.ItemStack;

public class FoodTab extends BaseTab
{
	public FoodTab() 
	{
		super(ModUtil.ID + "." + ModUtil.ID + "_food");
	}

	@Override
	public ItemStack makeIcon() 
	{
		return ItemInit.CHILESAURUS_COOKED_MEAT.get().getDefaultInstance();
	}
}
