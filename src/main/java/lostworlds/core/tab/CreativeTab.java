package lostworlds.core.tab;

import lostworlds.core.init.ItemInit;
import lostworlds.core.util.ModID;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

public class CreativeTab extends ItemGroup
{
	public CreativeTab(String label) 
	{
		super(ModID.ID + "." + label);
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
		return new ResourceLocation(ModID.ID, "textures/gui/creative_tab/lostworlds_tab.png");
	}
	
	@Override
	public void fillItemList(NonNullList<ItemStack> item) 
	{
		item.add(ItemInit.BRUSH.get().getDefaultInstance());
	}
}

