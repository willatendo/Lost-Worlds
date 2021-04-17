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
		//Items
		//Copper
		item.add(ItemInit.COPPER_INGOT.get().getDefaultInstance());
		item.add(ItemInit.COPPER_NUGGET.get().getDefaultInstance());
		
		//Computer Items
		item.add(ItemInit.COPPER_WIRE.get().getDefaultInstance());
		item.add(ItemInit.COMPUTER_FAN.get().getDefaultInstance());
		item.add(ItemInit.COMPUTER_SCREEN.get().getDefaultInstance());
		item.add(ItemInit.COMPUTER_FRAME.get().getDefaultInstance());
		item.add(ItemInit.COMPUTER_STORAGE_PORT.get().getDefaultInstance());
		item.add(ItemInit.MOTHERBOARD.get().getDefaultInstance());
		item.add(ItemInit.CPU.get().getDefaultInstance());
		item.add(ItemInit.RAM.get().getDefaultInstance());
		
		//Dinosaur Items
		item.add(ItemInit.BRUSH.get().getDefaultInstance());
		item.add(ItemInit.WET_PAPER.get().getDefaultInstance());
		item.add(ItemInit.FEILD_GUIDE.get().getDefaultInstance());
		item.add(ItemInit.MUD_BALL.get().getDefaultInstance());
		
		//DNA
		
		//Storage Discs
		item.add(ItemInit.STORAGE_DISC.get().getDefaultInstance());
		
		//Meat
		
		//Spawn Eggs
		item.add(ItemInit.ALLOSAURUS_SPAWN_EGG.get().getDefaultInstance());
		item.add(ItemInit.CARNOTAURUS_SPAWN_EGG.get().getDefaultInstance());
		item.add(ItemInit.DIMETRODON_SPAWN_EGG.get().getDefaultInstance());
		item.add(ItemInit.EDAPHOSAURUS_SPAWN_EGG.get().getDefaultInstance());
		item.add(ItemInit.GIGANOTOSAURUS_SPAWN_EGG.get().getDefaultInstance());
		item.add(ItemInit.GORGONOPS_SPAWN_EGG.get().getDefaultInstance());
		item.add(ItemInit.NAUTILUS_SPAWN_EGG.get().getDefaultInstance());
		item.add(ItemInit.PALAEONISCUM_SPAWN_EGG.get().getDefaultInstance());
		item.add(ItemInit.PROCOMPSOGNATHUS_SPAWN_EGG.get().getDefaultInstance());
		item.add(ItemInit.RHINESUCHUS_SPAWN_EGG.get().getDefaultInstance());
		item.add(ItemInit.SUCHOMIMUS_SPAWN_EGG.get().getDefaultInstance());
		item.add(ItemInit.TYRANNOSAURUS_SPAWN_EGG.get().getDefaultInstance());
		
		//Music Discs
		item.add(ItemInit.JP_MUSIC_DISC.get().getDefaultInstance());
	
		//Scarab
		item.add(ItemInit.BROKEN_CRYSTAL_SCARAB_GEM.get().getDefaultInstance());
		item.add(ItemInit.CRYSTAL_SCARAB_GEM.get().getDefaultInstance());
		item.add(ItemInit.CRYSTAL_SCARAB_SWORD.get().getDefaultInstance());
		item.add(ItemInit.CRYSTAL_SCARAB_SHOVEL.get().getDefaultInstance());
		item.add(ItemInit.CRYSTAL_SCARAB_PICKAXE.get().getDefaultInstance());
		item.add(ItemInit.CRYSTAL_SCARAB_AXE.get().getDefaultInstance());
		item.add(ItemInit.CRYSTAL_SCARAB_HOE.get().getDefaultInstance());
	}
}

