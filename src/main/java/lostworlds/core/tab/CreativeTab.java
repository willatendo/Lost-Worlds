package lostworlds.core.tab;

import lostworlds.core.util.reference.ModReference;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.NonNullList;
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
		return Items.NAUTILUS_SHELL.getDefaultInstance();
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
	
	@Override
	public void fillItemList(NonNullList<ItemStack> p_78018_1_) 
	{
		super.fillItemList(p_78018_1_);
	}
}

