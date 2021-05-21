package lostworlds.core.tab;

import lostworlds.core.init.ItemInit;
import lostworlds.core.util.ModID;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class NatureTab extends ItemGroup
{
	public NatureTab() 
	{
		super(ModID.ID + "." + ModID.ID + "_nature");
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
		return ModID.lostWorlds("textures/gui/creative_tab/lostworlds_tab.png");
	}
	
	@Override
	public ResourceLocation getTabsImage() 
	{
		return ModID.lostWorlds("textures/gui/creative_tab/lostworlds_tabs.png");
	}
}
