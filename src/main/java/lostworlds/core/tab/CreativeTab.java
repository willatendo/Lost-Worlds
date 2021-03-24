package lostworlds.core.tab;

import lostworlds.core.init.ItemInit;
import lostworlds.core.util.reference.ModReference;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class CreativeTab extends ItemGroup
{
	public CreativeTab(String label) 
	{
		super(ModReference.ID + "." + label);
	}

	@Override
	public ItemStack makeIcon() 
	{
		return ItemInit.WET_PAPER.get().getDefaultInstance();
	}
	
	@Override
	public boolean hasSearchBar() 
	{
		return true;
	}
	
	@Override
	public int getLabelColor() 
	{
		return 0x3789ea;
	}
	
	@Override
	public ResourceLocation getBackgroundImage() 
	{
		return new ResourceLocation(ModReference.ID, "textures/gui/creative_tab/lostworlds_tab.png");
	}
}

