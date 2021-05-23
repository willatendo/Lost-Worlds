package lostworlds.core.tab;

import lostworlds.core.init.ItemInit;
import lostworlds.core.util.ModUtil;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class NatureTab extends ItemGroup
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
	
	@Override
	public int getLabelColor() 
	{
		return 0x3789ea;
	}
	
	@Override
	public ResourceLocation getBackgroundImage() 
	{
		return ModUtil.rL("textures/gui/creative_tab/lostworlds_tab.png");
	}
	
	@Override
	public ResourceLocation getTabsImage() 
	{
		return ModUtil.rL("textures/gui/creative_tab/lostworlds_tabs.png");
	}
}
