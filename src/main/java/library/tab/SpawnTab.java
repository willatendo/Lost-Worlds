package library.tab;

import api.core.init.ItemInit;
import library.util.ModUtil;
import net.minecraft.item.ItemStack;

public class SpawnTab extends BaseTab
{
	public SpawnTab() 
	{
		super(ModUtil.ID + "." + ModUtil.ID + "_spawn");
	}

	@Override
	public ItemStack makeIcon() 
	{
		return ItemInit.ALLOSAURUS_SPAWN_EGG.get().getDefaultInstance();
	}
}
