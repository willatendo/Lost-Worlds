package lostworlds.core.tab;

import lostworlds.core.util.ModUtil;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;

public abstract class BaseTab extends ItemGroup
{
	public BaseTab(String id) 
	{
		super(id);
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
