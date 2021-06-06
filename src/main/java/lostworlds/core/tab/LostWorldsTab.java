package lostworlds.core.tab;

import lostworlds.core.util.ModUtil;
import lostworlds.core.util.registry.ModRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

public class LostWorldsTab extends BaseTab
{
	public LostWorldsTab() 
	{
		super(ModUtil.ID + "." + ModUtil.ID);
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
	public ResourceLocation getBackgroundImage() 
	{
		return ModUtil.rL("textures/gui/creative_tab/lostworlds_tab_search.png");
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
