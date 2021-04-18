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
		item.add(ItemInit.EMPTY_VILE.get().getDefaultInstance());
		item.add(ItemInit.ALLOSAURUS_DNA.get().getDefaultInstance());
		item.add(ItemInit.CARNOTAURUS_DNA.get().getDefaultInstance());
		item.add(ItemInit.DIMETRODON_DNA.get().getDefaultInstance());
		item.add(ItemInit.EDAPHOSAURUS_DNA.get().getDefaultInstance());
		item.add(ItemInit.GIGANOTOSAURUS_DNA.get().getDefaultInstance());
		item.add(ItemInit.GORGONOPS_DNA.get().getDefaultInstance());
		item.add(ItemInit.NAUTILUS_DNA.get().getDefaultInstance());
		item.add(ItemInit.PALAEONISCUM_DNA.get().getDefaultInstance());
		item.add(ItemInit.PROCOMPSOGNATHUS_DNA.get().getDefaultInstance());
		item.add(ItemInit.RHINESUCHUS_DNA.get().getDefaultInstance());
		item.add(ItemInit.SUCHOMIMUS_DNA.get().getDefaultInstance());
		item.add(ItemInit.TETRACERATOPS_DNA.get().getDefaultInstance());
		item.add(ItemInit.TYRANNOSAURUS_DNA.get().getDefaultInstance());
		
		//Storage Discs
		item.add(ItemInit.STORAGE_DISC.get().getDefaultInstance());
		item.add(ItemInit.ALLOSAURUS_DNA_DISC.get().getDefaultInstance());
		item.add(ItemInit.CARNOTAURUS_DNA_DISC.get().getDefaultInstance());
		item.add(ItemInit.DIMETRODON_DNA_DISC.get().getDefaultInstance());
		item.add(ItemInit.EDAPHOSAURUS_DNA_DISC.get().getDefaultInstance());
		item.add(ItemInit.GIGANOTOSAURUS_DNA_DISC.get().getDefaultInstance());
		item.add(ItemInit.GORGONOPS_DNA_DISC.get().getDefaultInstance());
		item.add(ItemInit.NAUTILUS_DNA_DISC.get().getDefaultInstance());
		item.add(ItemInit.PALAEONISCUM_DNA_DISC.get().getDefaultInstance());
		item.add(ItemInit.PROCOMPSOGNATHUS_DNA_DISC.get().getDefaultInstance());
		item.add(ItemInit.RHINESUCHUS_DNA_DISC.get().getDefaultInstance());
		item.add(ItemInit.SUCHOMIMUS_DNA_DISC.get().getDefaultInstance());
		item.add(ItemInit.TYRANNOSAURUS_DNA_DISC.get().getDefaultInstance());
		
		//Meat
		item.add(ItemInit.ALLOSAURUS_MEAT.get().getDefaultInstance());
		item.add(ItemInit.CARNOTAURUS_MEAT.get().getDefaultInstance());
		item.add(ItemInit.DIMETRODON_MEAT.get().getDefaultInstance());
		item.add(ItemInit.EDAPHOSAURUS_MEAT.get().getDefaultInstance());
		item.add(ItemInit.GIGANOTOSAURUS_MEAT.get().getDefaultInstance());
		item.add(ItemInit.GORGONOPS_MEAT.get().getDefaultInstance());
		item.add(ItemInit.NAUTILUS_TENTICAL.get().getDefaultInstance());
		item.add(ItemInit.PALAEONISCUM_MEAT.get().getDefaultInstance());
		item.add(ItemInit.PROCOMPSOGNATHUS_MEAT.get().getDefaultInstance());
		item.add(ItemInit.RHINESUCHUS_MEAT.get().getDefaultInstance());
		item.add(ItemInit.SUCHOMIMUS_MEAT.get().getDefaultInstance());
		item.add(ItemInit.TETRACERATOPS_MEAT.get().getDefaultInstance());
		item.add(ItemInit.TYRANNOSAURUS_MEAT.get().getDefaultInstance());

		//Cooked Meat
		item.add(ItemInit.ALLOSAURUS_COOKED_MEAT.get().getDefaultInstance());
		item.add(ItemInit.CARNOTAURUS_COOKED_MEAT.get().getDefaultInstance());
		item.add(ItemInit.DIMETRODON_COOKED_MEAT.get().getDefaultInstance());
		item.add(ItemInit.EDAPHOSAURUS_COOKED_MEAT.get().getDefaultInstance());
		item.add(ItemInit.GIGANOTOSAURUS_COOKED_MEAT.get().getDefaultInstance());
		item.add(ItemInit.GORGONOPS_COOKED_MEAT.get().getDefaultInstance());
		item.add(ItemInit.COOKED_NAUTILUS_TENTICAL.get().getDefaultInstance());
		item.add(ItemInit.PALAEONISCUM_COOKED_MEAT.get().getDefaultInstance());
		item.add(ItemInit.PROCOMPSOGNATHUS_COOKED_MEAT.get().getDefaultInstance());
		item.add(ItemInit.RHINESUCHUS_COOKED_MEAT.get().getDefaultInstance());
		item.add(ItemInit.SUCHOMIMUS_COOKED_MEAT.get().getDefaultInstance());
		item.add(ItemInit.TETRACERATOPS_COOKED_MEAT.get().getDefaultInstance());
		item.add(ItemInit.TYRANNOSAURUS_COOKED_MEAT.get().getDefaultInstance());
		
		//Bones
		
		
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
		item.add(ItemInit.TETRACERATOPS_SPAWN_EGG.get().getDefaultInstance());
		item.add(ItemInit.TYRANNOSAURUS_SPAWN_EGG.get().getDefaultInstance());
		
		//Scarab
		item.add(ItemInit.BROKEN_CRYSTAL_SCARAB_GEM.get().getDefaultInstance());
		item.add(ItemInit.CRYSTAL_SCARAB_GEM.get().getDefaultInstance());
		item.add(ItemInit.CRYSTAL_SCARAB_SWORD.get().getDefaultInstance());
		item.add(ItemInit.CRYSTAL_SCARAB_SHOVEL.get().getDefaultInstance());
		item.add(ItemInit.CRYSTAL_SCARAB_PICKAXE.get().getDefaultInstance());
		item.add(ItemInit.CRYSTAL_SCARAB_AXE.get().getDefaultInstance());
		item.add(ItemInit.CRYSTAL_SCARAB_HOE.get().getDefaultInstance());
		
		//Music Discs
		item.add(ItemInit.JP_MUSIC_DISC.get().getDefaultInstance());
		
		//Blocks
		//Ores
		item.add(ItemInit.COPPER_ORE.get().getDefaultInstance());
		
		//Fossils
		item.add(ItemInit.STONE_FOSSIL.get().getDefaultInstance());
		item.add(ItemInit.EXPOSED_STONE_FOSSIL.get().getDefaultInstance());
		item.add(ItemInit.PLASTERED_STONE_FOSSIL.get().getDefaultInstance());

		//Fossil Processing
		item.add(ItemInit.POWER_SUPPLY_BLOCK.get().getDefaultInstance());
	
		//Time Machine
		item.add(ItemInit.TIME_MACHINE.get().getDefaultInstance());
		
		//Mud
		item.add(ItemInit.MUD.get().getDefaultInstance());

		//Nesting Block
		item.add(ItemInit.NESTING_BLOCK.get().getDefaultInstance());
		
		//World Gen
		//Volcanic Stuff
		item.add(ItemInit.VOLCANIC_ROCK.get().getDefaultInstance());
		item.add(ItemInit.VOLCANIC_ROCK_SLAB.get().getDefaultInstance());
		item.add(ItemInit.VOLCANIC_ROCK_STAIRS.get().getDefaultInstance());
		item.add(ItemInit.VOLCANIC_ROCK_WALL.get().getDefaultInstance());
		
		item.add(ItemInit.POLISHED_VOLCANIC_ROCK.get().getDefaultInstance());
		item.add(ItemInit.POLISHED_VOLCANIC_ROCK_SLAB.get().getDefaultInstance());
		item.add(ItemInit.POLISHED_VOLCANIC_ROCK_STAIRS.get().getDefaultInstance());
		
		item.add(ItemInit.VOLCANIC_ASH.get().getDefaultInstance());
	
		//Permian
		//Sand
		item.add(ItemInit.PERMIAN_SAND.get().getDefaultInstance());

		//Stone
		item.add(ItemInit.PERMIAN_STONE.get().getDefaultInstance());
		item.add(ItemInit.PERMIAN_STONE_STAIRS.get().getDefaultInstance());
		item.add(ItemInit.PERMIAN_STONE_SLAB.get().getDefaultInstance());
		
		item.add(ItemInit.PERMIAN_COBBLESTONE.get().getDefaultInstance());
		item.add(ItemInit.PERMIAN_COBBLESTONE_STAIRS.get().getDefaultInstance());
		item.add(ItemInit.PERMIAN_COBBLESTONE_SLAB.get().getDefaultInstance());
		item.add(ItemInit.PERMIAN_COBBLESTONE_WALL.get().getDefaultInstance());
		
		//Flora
		item.add(ItemInit.SMALL_PERMIAN_DESERT_PLANT.get().getDefaultInstance());
		item.add(ItemInit.MEDIUM_PERMIAN_DESERT_PLANT.get().getDefaultInstance());
		item.add(ItemInit.LARGE_PERMIAN_DESERT_PLANT.get().getDefaultInstance());

		item.add(ItemInit.PERMIAN_GROUND_FERNS.get().getDefaultInstance());
		
		//Conifer
		item.add(ItemInit.CONIFER_LOG.get().getDefaultInstance());
		item.add(ItemInit.CONIFER_WOOD.get().getDefaultInstance());
		item.add(ItemInit.STRIPPED_CONIFER_LOG.get().getDefaultInstance());
		item.add(ItemInit.STRIPPED_CONIFER_WOOD.get().getDefaultInstance());
		item.add(ItemInit.CONIFER_LEAVES.get().getDefaultInstance());
		item.add(ItemInit.CONIFER_SAPLING.get().getDefaultInstance());
		item.add(ItemInit.CONIFER_PLANKS.get().getDefaultInstance());
		item.add(ItemInit.CONIFER_STAIRS.get().getDefaultInstance());
		item.add(ItemInit.CONIFER_SLAB.get().getDefaultInstance());
		item.add(ItemInit.CONIFER_FENCE.get().getDefaultInstance());
		item.add(ItemInit.CONIFER_FENCE_GATE.get().getDefaultInstance());
		item.add(ItemInit.CONIFER_PRESSURE_PLATE.get().getDefaultInstance());
		item.add(ItemInit.CONIFER_BUTTON.get().getDefaultInstance());
		item.add(ItemInit.CONIFER_TRAPDOOR.get().getDefaultInstance());
		item.add(ItemInit.CONIFER_DOOR.get().getDefaultInstance());
		item.add(ItemInit.CONIFER_SIGN.get().getDefaultInstance());
		item.add(ItemInit.CONIFER_BOAT.get().getDefaultInstance());
		
		//Ginkgo
		item.add(ItemInit.GINKGO_LOG.get().getDefaultInstance());
		item.add(ItemInit.GINKGO_WOOD.get().getDefaultInstance());
		item.add(ItemInit.STRIPPED_GINKGO_LOG.get().getDefaultInstance());
		item.add(ItemInit.STRIPPED_GINKGO_WOOD.get().getDefaultInstance());
		item.add(ItemInit.GINKGO_LEAVES.get().getDefaultInstance());
//		item.add(ItemInit.GINKGO_SAPLING.get().getDefaultInstance());
		item.add(ItemInit.GINKGO_PLANKS.get().getDefaultInstance());
		item.add(ItemInit.GINKGO_STAIRS.get().getDefaultInstance());
		item.add(ItemInit.GINKGO_SLAB.get().getDefaultInstance());
		item.add(ItemInit.GINKGO_FENCE.get().getDefaultInstance());
		item.add(ItemInit.GINKGO_FENCE_GATE.get().getDefaultInstance());
		item.add(ItemInit.GINKGO_PRESSURE_PLATE.get().getDefaultInstance());
		item.add(ItemInit.GINKGO_BUTTON.get().getDefaultInstance());
		item.add(ItemInit.GINKGO_TRAPDOOR.get().getDefaultInstance());
		item.add(ItemInit.GINKGO_DOOR.get().getDefaultInstance());
		item.add(ItemInit.GINKGO_SIGN.get().getDefaultInstance());
		item.add(ItemInit.GINKGO_BOAT.get().getDefaultInstance());
		
		//Decoration Blocks
		//Light Concrete
		item.add(ItemInit.LIGHT_CONCRETE.get().getDefaultInstance());
		item.add(ItemInit.LIGHT_CONCRETE_STAIRS.get().getDefaultInstance());
		item.add(ItemInit.LIGHT_CONCRETE_SLAB.get().getDefaultInstance());
		item.add(ItemInit.LIGHT_CONCRETE_WALL.get().getDefaultInstance());
		item.add(ItemInit.LIGHT_CONCRETE_PRESSURE_PLATE.get().getDefaultInstance());
		item.add(ItemInit.LIGHT_CONCRETE_BUTTON.get().getDefaultInstance());
		
		//Polished Light Concrete
		item.add(ItemInit.POLISHED_LIGHT_CONCRETE.get().getDefaultInstance());
		item.add(ItemInit.POLISHED_LIGHT_CONCRETE_STAIRS.get().getDefaultInstance());
		item.add(ItemInit.POLISHED_LIGHT_CONCRETE_SLAB.get().getDefaultInstance());
		
		//Dark Concrete
		item.add(ItemInit.DARK_CONCRETE.get().getDefaultInstance());
		item.add(ItemInit.DARK_CONCRETE_STAIRS.get().getDefaultInstance());
		item.add(ItemInit.DARK_CONCRETE_SLAB.get().getDefaultInstance());
		item.add(ItemInit.DARK_CONCRETE_WALL.get().getDefaultInstance());
		item.add(ItemInit.DARK_CONCRETE_PRESSURE_PLATE.get().getDefaultInstance());
		item.add(ItemInit.DARK_CONCRETE_BUTTON.get().getDefaultInstance());
		
		//Polished Dark Concrete
		item.add(ItemInit.POLISHED_DARK_CONCRETE.get().getDefaultInstance());
		item.add(ItemInit.POLISHED_DARK_CONCRETE_STAIRS.get().getDefaultInstance());
		item.add(ItemInit.POLISHED_DARK_CONCRETE_SLAB.get().getDefaultInstance());

		//Wooden Planks
		item.add(ItemInit.WOODEN_PLANKS.get().getDefaultInstance());
		item.add(ItemInit.WOODEN_PLANKS_STAIRS.get().getDefaultInstance());
		item.add(ItemInit.WOODEN_PLANKS_SLAB.get().getDefaultInstance());
		item.add(ItemInit.WOODEN_PLANKS_FENCE.get().getDefaultInstance());
		item.add(ItemInit.WOODEN_PLANKS_FENCE_GATE.get().getDefaultInstance());
		item.add(ItemInit.WOODEN_PLANKS_PRESSURE_PLATE.get().getDefaultInstance());
		item.add(ItemInit.WOODEN_PLANKS_BUTTON.get().getDefaultInstance());
			
		//Wooden Planks
		item.add(ItemInit.REFINED_WOODEN_PLANKS.get().getDefaultInstance());
		item.add(ItemInit.REFINED_WOODEN_PLANKS_STAIRS.get().getDefaultInstance());
		item.add(ItemInit.REFINED_WOODEN_PLANKS_SLAB.get().getDefaultInstance());
		item.add(ItemInit.REFINED_WOODEN_PLANKS_FENCE.get().getDefaultInstance());
		item.add(ItemInit.REFINED_WOODEN_PLANKS_FENCE_GATE.get().getDefaultInstance());
		item.add(ItemInit.REFINED_WOODEN_PLANKS_PRESSURE_PLATE.get().getDefaultInstance());
		item.add(ItemInit.REFINED_WOODEN_PLANKS_BUTTON.get().getDefaultInstance());
		
		//Pavement
		item.add(ItemInit.PAVEMENT.get().getDefaultInstance());
		item.add(ItemInit.PAVEMENT_SLOPE.get().getDefaultInstance());
		item.add(ItemInit.RAISED_PAVEMENT.get().getDefaultInstance());
		
		//Roads
		item.add(ItemInit.GRAVEL_ROAD.get().getDefaultInstance());
		item.add(ItemInit.RAISED_GRAVEL_ROAD.get().getDefaultInstance());
			
		item.add(ItemInit.DIRT_ROAD.get().getDefaultInstance());
		item.add(ItemInit.RAISED_DIRT_ROAD.get().getDefaultInstance());
				
		item.add(ItemInit.PAVED_ROAD.get().getDefaultInstance());
		item.add(ItemInit.RAISED_PAVED_ROAD.get().getDefaultInstance());
			
		//Tile
		item.add(ItemInit.TILE.get().getDefaultInstance());
		item.add(ItemInit.TILE_STAIRS.get().getDefaultInstance());
		item.add(ItemInit.TILE_SLAB.get().getDefaultInstance());

		//Metal Fence
		item.add(ItemInit.METAL_FENCE.get().getDefaultInstance());

		//Clear Glass
		item.add(ItemInit.CLEAR_GLASS.get().getDefaultInstance());
		item.add(ItemInit.CLEAR_GLASS_PANE.get().getDefaultInstance());

		//Tinted Glass
		item.add(ItemInit.TINTED_GLASS.get().getDefaultInstance());
		item.add(ItemInit.TINTED_GLASS_PANE.get().getDefaultInstance());
		
		//Coloured Glass
		item.add(ItemInit.WHITE_GLASS.get().getDefaultInstance());
		item.add(ItemInit.WHITE_GLASS_PANE.get().getDefaultInstance());
			
		item.add(ItemInit.LIGHT_GREY_GLASS.get().getDefaultInstance());
		item.add(ItemInit.LIGHT_GREY_GLASS_PANE.get().getDefaultInstance());
			
		item.add(ItemInit.GREY_GLASS.get().getDefaultInstance());
		item.add(ItemInit.GREY_GLASS_PANE.get().getDefaultInstance());
			
		item.add(ItemInit.BLACK_GLASS.get().getDefaultInstance());
		item.add(ItemInit.BLACK_GLASS_PANE.get().getDefaultInstance());
			
		item.add(ItemInit.RED_GLASS.get().getDefaultInstance());
		item.add(ItemInit.RED_GLASS_PANE.get().getDefaultInstance());
			
		item.add(ItemInit.ORANGE_GLASS.get().getDefaultInstance());
		item.add(ItemInit.ORANGE_GLASS_PANE.get().getDefaultInstance());
		
		item.add(ItemInit.YELLOW_GLASS.get().getDefaultInstance());
		item.add(ItemInit.YELLOW_GLASS_PANE.get().getDefaultInstance());
		
		item.add(ItemInit.LIME_GLASS.get().getDefaultInstance());
		item.add(ItemInit.LIME_GLASS_PANE.get().getDefaultInstance());
			
		item.add(ItemInit.GREEN_GLASS.get().getDefaultInstance());
		item.add(ItemInit.GREEN_GLASS_PANE.get().getDefaultInstance());
			
		item.add(ItemInit.CYAN_GLASS.get().getDefaultInstance());
		item.add(ItemInit.CYAN_GLASS_PANE.get().getDefaultInstance());
			
		item.add(ItemInit.LIGHT_BLUE_GLASS.get().getDefaultInstance());
		item.add(ItemInit.LIGHT_BLUE_GLASS_PANE.get().getDefaultInstance());
			
		item.add(ItemInit.BLUE_GLASS.get().getDefaultInstance());
		item.add(ItemInit.BLUE_GLASS_PANE.get().getDefaultInstance());
			
		item.add(ItemInit.PURPLE_GLASS.get().getDefaultInstance());
		item.add(ItemInit.PURPLE_GLASS_PANE.get().getDefaultInstance());	
			
		item.add(ItemInit.MAGENTA_GLASS.get().getDefaultInstance());
		item.add(ItemInit.MAGENTA_GLASS_PANE.get().getDefaultInstance());
			
		item.add(ItemInit.PINK_GLASS.get().getDefaultInstance());
		item.add(ItemInit.PINK_GLASS_PANE.get().getDefaultInstance());
			
		item.add(ItemInit.BROWN_GLASS.get().getDefaultInstance());
		item.add(ItemInit.BROWN_GLASS_PANE.get().getDefaultInstance());

		item.add(ItemInit.SHADED_GLASS.get().getDefaultInstance());
		item.add(ItemInit.SHADED_GLASS_PANE.get().getDefaultInstance());
		
		//Coloured Blocks
		item.add(ItemInit.RED_DECORATION_BLOCK.get().getDefaultInstance());
		item.add(ItemInit.ORANGE_DECORATION_BLOCK.get().getDefaultInstance());
		item.add(ItemInit.YELLOW_DECORATION_BLOCK.get().getDefaultInstance());
		item.add(ItemInit.LIME_DECORATION_BLOCK.get().getDefaultInstance());
		item.add(ItemInit.GREEN_DECORATION_BLOCK.get().getDefaultInstance());
		item.add(ItemInit.CYAN_DECORATION_BLOCK.get().getDefaultInstance());
		item.add(ItemInit.BLUE_DECORATION_BLOCK.get().getDefaultInstance());	
		item.add(ItemInit.LIGHT_BLUE_DECORATION_BLOCK.get().getDefaultInstance());
		item.add(ItemInit.PURPLE_DECORATION_BLOCK.get().getDefaultInstance());
		item.add(ItemInit.MAGENTA_DECORATION_BLOCK.get().getDefaultInstance());
		item.add(ItemInit.PINK_DECORATION_BLOCK.get().getDefaultInstance());
		item.add(ItemInit.BROWN_DECORATION_BLOCK.get().getDefaultInstance());
		item.add(ItemInit.GREY_DECORATION_BLOCK.get().getDefaultInstance());
		item.add(ItemInit.LIGHT_GREY_DECORATION_BLOCK.get().getDefaultInstance());
		item.add(ItemInit.WHITE_DECORATION_BLOCK.get().getDefaultInstance());
		item.add(ItemInit.BLACK_DECORATION_BLOCK.get().getDefaultInstance());
		
		//Thatch
		item.add(ItemInit.THATCH_BLOCK.get().getDefaultInstance());
		
		//Doors
		item.add(ItemInit.OUTDOOR_TOILET_DOOR.get().getDefaultInstance());
		item.add(ItemInit.GLASS_SHOP_DOOR.get().getDefaultInstance());
		item.add(ItemInit.VISITOR_CENTRE_DOOR.get().getDefaultInstance());
		item.add(ItemInit.INNOVATION_CENTRE_DOOR.get().getDefaultInstance());
		item.add(ItemInit.SECURITY_DOOR.get().getDefaultInstance());
		item.add(ItemInit.BACK_DOOR.get().getDefaultInstance());
	}
}

