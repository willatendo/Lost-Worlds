package lostworlds.library.tab;

import lostworlds.library.util.ModRegistry;
import lostworlds.library.util.ModUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.RegistryObject;

public class LostWorldsTab extends ItemGroup
{
	public LostWorldsTab() 
	{
		super(ModUtil.ID + ".lost_worlds");
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
	public void fillItemList(NonNullList<ItemStack> itemStacks) 
	{
		for(RegistryObject<Item> item : ModRegistry.ITEM_REGISTRY.getEntries()) 
		{
			itemStacks.add(item.get().getDefaultInstance());
		}	
	}
}