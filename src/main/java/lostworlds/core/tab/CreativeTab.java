package lostworlds.core.tab;

import lostworlds.core.init.ItemInit;
import lostworlds.core.util.reference.ModReference;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CreativeTab extends ItemGroup
{
	public CreativeTab(String label) 
	{
		super(ModReference.ID + "." + label);
	}

	@Override
	public ItemStack createIcon() 
	{
		return ItemInit.WET_PAPER.get().getDefaultInstance();
	}
	
	@Override
	public boolean hasSearchBar() 
	{
		return true;
	}
}

