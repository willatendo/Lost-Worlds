package lostworlds.core.util;

import lostworlds.core.init.BlockInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

public class ModBlockStates 
{
	//Vanilla
	public static final BlockState WATER = Blocks.WATER.defaultBlockState();
	public static final BlockState LAVA = Blocks.LAVA.defaultBlockState();
	
	//Mod
	//Ore
	public static final BlockState COPPER_ORE = BlockInit.COPPER_ORE.get().defaultBlockState();
	
	//Fossils
	public static final BlockState STONE_FOSSIL = BlockInit.STONE_FOSSIL.get().defaultBlockState();
	public static final BlockState EXPOSED_STONE_FOSSIL = BlockInit.EXPOSED_STONE_FOSSIL.get().defaultBlockState();
	
	public static final BlockState TERRACOTTA_FOSSIL = BlockInit.TERRACOTTA_FOSSIL.get().defaultBlockState();
	public static final BlockState EXPOSED_TERRACOTTA_FOSSIL = BlockInit.EXPOSED_TERRACOTTA_FOSSIL.get().defaultBlockState();
	public static final BlockState RED_TERRACOTTA_FOSSIL = BlockInit.RED_TERRACOTTA_FOSSIL.get().defaultBlockState();
	public static final BlockState EXPOSED_RED_TERRACOTTA_FOSSIL = BlockInit.EXPOSED_RED_TERRACOTTA_FOSSIL.get().defaultBlockState();
	public static final BlockState ORANGE_TERRACOTTA_FOSSIL = BlockInit.ORANGE_TERRACOTTA_FOSSIL.get().defaultBlockState();
	public static final BlockState EXPOSED_ORANGE_TERRACOTTA_FOSSIL = BlockInit.EXPOSED_ORANGE_TERRACOTTA_FOSSIL.get().defaultBlockState();
	public static final BlockState EXPOSED_LIME_TERRACOTTA_FOSSIL = BlockInit.EXPOSED_LIME_TERRACOTTA_FOSSIL.get().defaultBlockState();
	public static final BlockState EXPOSED_GREEN_TERRACOTTA_FOSSIL = BlockInit.EXPOSED_GREEN_TERRACOTTA_FOSSIL.get().defaultBlockState();
	public static final BlockState EXPOSED_CYAN_TERRACOTTA_FOSSIL = BlockInit.EXPOSED_CYAN_TERRACOTTA_FOSSIL.get().defaultBlockState();
	public static final BlockState EXPOSED_LIGHT_BLUE_TERRACOTTA_FOSSIL = BlockInit.EXPOSED_LIGHT_BLUE_TERRACOTTA_FOSSIL.get().defaultBlockState();
	public static final BlockState EXPOSED_BLUE_TERRACOTTA_FOSSIL = BlockInit.EXPOSED_BLUE_TERRACOTTA_FOSSIL.get().defaultBlockState();
	public static final BlockState EXPOSED_MAGENTA_TERRACOTTA_FOSSIL = BlockInit.EXPOSED_MAGENTA_TERRACOTTA_FOSSIL.get().defaultBlockState();
	public static final BlockState EXPOSED_PURPLE_TERRACOTTA_FOSSIL = BlockInit.EXPOSED_PURPLE_TERRACOTTA_FOSSIL.get().defaultBlockState();
	public static final BlockState EXPOSED_PINK_TERRACOTTA_FOSSIL = BlockInit.EXPOSED_PINK_TERRACOTTA_FOSSIL.get().defaultBlockState();
	public static final BlockState EXPOSED_BROWN_TERRACOTTA_FOSSIL = BlockInit.EXPOSED_BROWN_TERRACOTTA_FOSSIL.get().defaultBlockState();
	public static final BlockState EXPOSED_BLACK_TERRACOTTA_FOSSIL = BlockInit.EXPOSED_BLACK_TERRACOTTA_FOSSIL.get().defaultBlockState();
	public static final BlockState EXPOSED_GREY_TERRACOTTA_FOSSIL = BlockInit.EXPOSED_GREY_TERRACOTTA_FOSSIL.get().defaultBlockState();
	public static final BlockState EXPOSED_LIGHT_GREY_TERRACOTTA_FOSSIL = BlockInit.EXPOSED_LIGHT_GREY_TERRACOTTA_FOSSIL.get().defaultBlockState();
	public static final BlockState EXPOSED_WHITE_TERRACOTTA_FOSSIL = BlockInit.EXPOSED_WHITE_TERRACOTTA_FOSSIL.get().defaultBlockState();
	
	public static final BlockState PLASTERED_STONE_FOSSIL = BlockInit.PLASTERED_FOSSIL.get().defaultBlockState();
	
	//Fossil Processing
	
	public static final BlockState POWER_SUPPLY_BLOCK = BlockInit.POWER_SUPPLY_BLOCK.get().defaultBlockState();
	
	//Eggs
	public static final BlockState PROCOMPSOGNATHUS_EGG = BlockInit.PROCOMPSOGNATHUS_EGG.get().defaultBlockState();
	public static final BlockState DIMETRODON_EGG = BlockInit.DIMETRODON_EGG.get().defaultBlockState();
	public static final BlockState EDAPHOSAURUS_EGG = BlockInit.EDAPHOSAURUS_EGG.get().defaultBlockState();
	public static final BlockState GORGONOPS_EGG = BlockInit.GORGONOPS_EGG.get().defaultBlockState();
	public static final BlockState CARNOTAURUS_EGG = BlockInit.GORGONOPS_EGG.get().defaultBlockState();
	public static final BlockState TYRANNOSAURUS_EGG = BlockInit.TYRANNOSAURUS_EGG.get().defaultBlockState();
	
	//Mud
	public static final BlockState MUD = BlockInit.MUD.get().defaultBlockState();

	//Nesting Block
	public static final BlockState NESTING_BLOCK = BlockInit.NESTING_BLOCK.get().defaultBlockState();

	//Museum Stuff
	public static final BlockState ARCHAEOLOGY_TABLE = BlockInit.ARCHAEOLOGY_TABLE.get().defaultBlockState();
	
	//Volcanic Stuff
	public static final BlockState VOLCANIC_ROCK = BlockInit.VOLCANIC_ROCK.get().defaultBlockState();
	public static final BlockState VOLCANIC_ROCK_STAIRS = BlockInit.VOLCANIC_ROCK_STAIRS.get().defaultBlockState();
	public static final BlockState VOLCANIC_ROCK_SLAB = BlockInit.VOLCANIC_ROCK_SLAB.get().defaultBlockState();
	public static final BlockState VOLCANIC_ROCK_WALL = BlockInit.VOLCANIC_ROCK_WALL.get().defaultBlockState();
	
	public static final BlockState POLISHED_VOLCANIC_ROCK = BlockInit.POLISHED_VOLCANIC_ROCK.get().defaultBlockState();
	public static final BlockState POLISHED_VOLCANIC_ROCK_STAIRS = BlockInit.POLISHED_VOLCANIC_ROCK_STAIRS.get().defaultBlockState();
	public static final BlockState POLISHED_VOLCANIC_ROCK_SLAB = BlockInit.POLISHED_VOLCANIC_ROCK_SLAB.get().defaultBlockState();
	
	public static final BlockState VOLCANIC_ASH = BlockInit.VOLCANIC_ASH.get().defaultBlockState();
	
	//Permian Blocks
	public static final BlockState PERMIAN_SAND = BlockInit.PERMIAN_SAND.get().defaultBlockState();
	
	public static final BlockState PERMIAN_STONE = BlockInit.PERMIAN_STONE.get().defaultBlockState();
	public static final BlockState PERMIAN_STONE_STAIRS = BlockInit.PERMIAN_STONE_STAIRS.get().defaultBlockState();
	public static final BlockState PERMIAN_STONE_SLAB = BlockInit.PERMIAN_STONE_SLAB.get().defaultBlockState();

	public static final BlockState PERMIAN_COAL_ORE = BlockInit.PERMIAN_COAL_ORE.get().defaultBlockState();
	public static final BlockState PERMIAN_COPPER_ORE = BlockInit.PERMIAN_COPPER_ORE.get().defaultBlockState();
	public static final BlockState PERMIAN_DIAMOND_ORE = BlockInit.PERMIAN_DIAMOND_ORE.get().defaultBlockState();
	public static final BlockState PERMIAN_EMERALD_ORE = BlockInit.PERMIAN_EMERALD_ORE.get().defaultBlockState();
	public static final BlockState PERMIAN_GOLD_ORE = BlockInit.PERMIAN_GOLD_ORE.get().defaultBlockState();
	public static final BlockState PERMIAN_IRON_ORE = BlockInit.PERMIAN_IRON_ORE.get().defaultBlockState();
	public static final BlockState PERMIAN_LAPIS_ORE = BlockInit.PERMIAN_LAPIS_ORE.get().defaultBlockState();
	public static final BlockState PERMIAN_REDSTONE_ORE = BlockInit.PERMIAN_REDSTONE_ORE.get().defaultBlockState();

	public static final BlockState PERMIAN_COBBLESTONE = BlockInit.PERMIAN_COBBLESTONE.get().defaultBlockState();
	public static final BlockState PERMIAN_COBBLESTONE_STAIRS = BlockInit.PERMIAN_COBBLESTONE_STAIRS.get().defaultBlockState();
	public static final BlockState PERMIAN_COBBLESTONE_SLAB = BlockInit.PERMIAN_COBBLESTONE_SLAB.get().defaultBlockState();
	public static final BlockState PERMIAN_COBBLESTONE_WALL = BlockInit.PERMIAN_COBBLESTONE_WALL.get().defaultBlockState();
	
	public static final BlockState SMALL_PERMIAN_DESERT_PLANT = BlockInit.SMALL_PERMIAN_DESERT_PLANT.get().defaultBlockState();
	public static final BlockState MEDIUM_PERMIAN_DESERT_PLANT = BlockInit.MEDIUM_PERMIAN_DESERT_PLANT.get().defaultBlockState();
	public static final BlockState LARGE_PERMIAN_DESERT_PLANT = BlockInit.LARGE_PERMIAN_DESERT_PLANT.get().defaultBlockState();
	
	public static final BlockState GROUND_FERNS = BlockInit.GROUND_FERNS.get().defaultBlockState();
	public static final BlockState PERMIAN_SEAGRASS = BlockInit.PERMIAN_SEAGRASS.get().defaultBlockState();

	public static final BlockState DICKSONIA = BlockInit.DICKSONIA.get().defaultBlockState();
	public static final BlockState TALL_DICKSONIA = BlockInit.TALL_DICKSONIA.get().defaultBlockState();

	public static final BlockState JURASSIC_STONE = BlockInit.JURASSIC_STONE.get().defaultBlockState();
	
	public static final BlockState JURASSIC_COAL_ORE = BlockInit.JURASSIC_COAL_ORE.get().defaultBlockState();
	public static final BlockState JURASSIC_COPPER_ORE = BlockInit.JURASSIC_COPPER_ORE.get().defaultBlockState();
	public static final BlockState JURASSIC_DIAMOND_ORE = BlockInit.JURASSIC_DIAMOND_ORE.get().defaultBlockState();
	public static final BlockState JURASSIC_EMERALD_ORE = BlockInit.JURASSIC_EMERALD_ORE.get().defaultBlockState();
	public static final BlockState JURASSIC_GOLD_ORE = BlockInit.JURASSIC_GOLD_ORE.get().defaultBlockState();
	public static final BlockState JURASSIC_IRON_ORE = BlockInit.JURASSIC_IRON_ORE.get().defaultBlockState();
	public static final BlockState JURASSIC_LAPIS_ORE = BlockInit.JURASSIC_LAPIS_ORE.get().defaultBlockState();
	public static final BlockState JURASSIC_REDSTONE_ORE = BlockInit.JURASSIC_REDSTONE_ORE.get().defaultBlockState();

	//Conifer
	public static final BlockState CONIFER_LOG = BlockInit.CONIFER_LOG.get().defaultBlockState();
	public static final BlockState STRIPPED_CONIFER_LOG = BlockInit.STRIPPED_CONIFER_LOG.get().defaultBlockState();
	public static final BlockState CONIFER_WOOD = BlockInit.CONIFER_WOOD.get().defaultBlockState();
	public static final BlockState STRIPPED_CONIFER_WOOD = BlockInit.STRIPPED_CONIFER_WOOD.get().defaultBlockState();
	public static final BlockState CONIFER_LEAVES = BlockInit.CONIFER_LEAVES.get().defaultBlockState();
	public static final BlockState CONIFER_SAPLING = BlockInit.CONIFER_SAPLING.get().defaultBlockState();
	public static final BlockState CONIFER_PLANKS = BlockInit.CONIFER_PLANKS.get().defaultBlockState();
	public static final BlockState CONIFER_STAIRS = BlockInit.CONIFER_STAIRS.get().defaultBlockState();
	public static final BlockState CONIFER_SLAB = BlockInit.CONIFER_SLAB.get().defaultBlockState();
	public static final BlockState CONIFER_FENCE = BlockInit.CONIFER_FENCE.get().defaultBlockState();
	public static final BlockState CONIFER_FENCE_GATE = BlockInit.CONIFER_FENCE_GATE.get().defaultBlockState();
	public static final BlockState CONIFER_PRESSURE_PLATE = BlockInit.CONIFER_PRESSURE_PLATE.get().defaultBlockState();
	public static final BlockState CONIFER_BUTTON = BlockInit.CONIFER_BUTTON.get().defaultBlockState();
	public static final BlockState CONIFER_TRAPDOOR = BlockInit.CONIFER_TRAPDOOR.get().defaultBlockState();
	public static final BlockState CONIFER_DOOR = BlockInit.CONIFER_DOOR.get().defaultBlockState();
	public static final BlockState CONIFER_SIGN = BlockInit.CONIFER_SIGN.get().defaultBlockState();
	public static final BlockState CONIFER_WALL_SIGN = BlockInit.CONIFER_WALL_SIGN.get().defaultBlockState();
	
	//Ginkgo
	public static final BlockState GINKGO_LOG = BlockInit.GINKGO_LOG.get().defaultBlockState();
	public static final BlockState STRIPPED_GINKGO_LOG = BlockInit.STRIPPED_GINKGO_LOG.get().defaultBlockState();
	public static final BlockState GINKGO_WOOD = BlockInit.GINKGO_WOOD.get().defaultBlockState();
	public static final BlockState STRIPPED_GINKGO_WOOD = BlockInit.STRIPPED_GINKGO_WOOD.get().defaultBlockState();
	public static final BlockState GINKGO_LEAVES = BlockInit.GINKGO_LEAVES.get().defaultBlockState();
	public static final BlockState GINKGO_SAPLING = BlockInit.GINKGO_SAPLING.get().defaultBlockState();
	public static final BlockState GINKGO_PLANKS = BlockInit.GINKGO_PLANKS.get().defaultBlockState();
	public static final BlockState GINKGO_STAIRS = BlockInit.GINKGO_STAIRS.get().defaultBlockState();
	public static final BlockState GINKGO_SLAB = BlockInit.GINKGO_SLAB.get().defaultBlockState();
	public static final BlockState GINKGO_FENCE = BlockInit.GINKGO_FENCE.get().defaultBlockState();
	public static final BlockState GINKGO_FENCE_GATE = BlockInit.GINKGO_FENCE_GATE.get().defaultBlockState();
	public static final BlockState GINKGO_PRESSURE_PLATE = BlockInit.GINKGO_PRESSURE_PLATE.get().defaultBlockState();
	public static final BlockState GINKGO_BUTTON = BlockInit.GINKGO_BUTTON.get().defaultBlockState();
	public static final BlockState GINKGO_TRAPDOOR = BlockInit.GINKGO_TRAPDOOR.get().defaultBlockState();
	public static final BlockState GINKGO_DOOR = BlockInit.GINKGO_DOOR.get().defaultBlockState();
	public static final BlockState GINKGO_SIGN = BlockInit.GINKGO_SIGN.get().defaultBlockState();
	public static final BlockState GINKGO_WALL_SIGN = BlockInit.GINKGO_WALL_SIGN.get().defaultBlockState();
	
	//Araucaria
	public static final BlockState ARAUCARIA_LOG = BlockInit.ARAUCARIA_LOG.get().defaultBlockState();
	public static final BlockState STRIPPED_ARAUCARIA_LOG = BlockInit.STRIPPED_ARAUCARIA_LOG.get().defaultBlockState();
	public static final BlockState ARAUCARIA_WOOD = BlockInit.ARAUCARIA_WOOD.get().defaultBlockState();
	public static final BlockState STRIPPED_ARAUCARIA_WOOD = BlockInit.STRIPPED_ARAUCARIA_WOOD.get().defaultBlockState();
	public static final BlockState ARAUCARIA_LEAVES = BlockInit.ARAUCARIA_LEAVES.get().defaultBlockState();
	public static final BlockState ARAUCARIA_SAPLING = BlockInit.ARAUCARIA_SAPLING.get().defaultBlockState();
	public static final BlockState ARAUCARIA_PLANKS = BlockInit.ARAUCARIA_PLANKS.get().defaultBlockState();
	public static final BlockState ARAUCARIA_STAIRS = BlockInit.ARAUCARIA_STAIRS.get().defaultBlockState();
	public static final BlockState ARAUCARIA_SLAB = BlockInit.ARAUCARIA_SLAB.get().defaultBlockState();
	public static final BlockState ARAUCARIA_FENCE = BlockInit.ARAUCARIA_FENCE.get().defaultBlockState();
	public static final BlockState ARAUCARIA_FENCE_GATE = BlockInit.ARAUCARIA_FENCE_GATE.get().defaultBlockState();
	public static final BlockState ARAUCARIA_PRESSURE_PLATE = BlockInit.ARAUCARIA_PRESSURE_PLATE.get().defaultBlockState();
	public static final BlockState ARAUCARIA_BUTTON = BlockInit.ARAUCARIA_BUTTON.get().defaultBlockState();
	public static final BlockState ARAUCARIA_TRAPDOOR = BlockInit.ARAUCARIA_TRAPDOOR.get().defaultBlockState();
	public static final BlockState ARAUCARIA_DOOR = BlockInit.ARAUCARIA_DOOR.get().defaultBlockState();
	public static final BlockState ARAUCARIA_SIGN = BlockInit.ARAUCARIA_SIGN.get().defaultBlockState();
	public static final BlockState ARAUCARIA_WALL_SIGN = BlockInit.ARAUCARIA_WALL_SIGN.get().defaultBlockState();

	//Light Concrete
	public static final BlockState LIGHT_CONCRETE = BlockInit.LIGHT_CONCRETE.get().defaultBlockState();
	public static final BlockState LIGHT_CONCRETE_STAIRS = BlockInit.LIGHT_CONCRETE_STAIRS.get().defaultBlockState();
	public static final BlockState LIGHT_CONCRETE_SLAB = BlockInit.LIGHT_CONCRETE_SLAB.get().defaultBlockState();
	public static final BlockState LIGHT_CONCRETE_WALL = BlockInit.LIGHT_CONCRETE_WALL.get().defaultBlockState();
	public static final BlockState LIGHT_CONCRETE_PRESSURE_PLATE = BlockInit.LIGHT_CONCRETE_PRESSURE_PLATE.get().defaultBlockState();
	public static final BlockState LIGHT_CONCRETE_BUTTON = BlockInit.LIGHT_CONCRETE_BUTTON.get().defaultBlockState();

	//Polished Light Concrete
	public static final BlockState POLISHED_LIGHT_CONCRETE = BlockInit.POLISHED_LIGHT_CONCRETE.get().defaultBlockState();
	public static final BlockState POLISHED_LIGHT_CONCRETE_STAIRS = BlockInit.POLISHED_LIGHT_CONCRETE_STAIRS.get().defaultBlockState();
	public static final BlockState POLISHED_LIGHT_CONCRETE_SLAB = BlockInit.POLISHED_LIGHT_CONCRETE_SLAB.get().defaultBlockState();
	
	//Light Concrete
	public static final BlockState DARK_CONCRETE = BlockInit.DARK_CONCRETE.get().defaultBlockState();
	public static final BlockState DARK_CONCRETE_STAIRS = BlockInit.DARK_CONCRETE_STAIRS.get().defaultBlockState();
	public static final BlockState DARK_CONCRETE_SLAB = BlockInit.DARK_CONCRETE_SLAB.get().defaultBlockState();
	public static final BlockState DARK_CONCRETE_WALL = BlockInit.DARK_CONCRETE_WALL.get().defaultBlockState();
	public static final BlockState DARK_CONCRETE_PRESSURE_PLATE = BlockInit.DARK_CONCRETE_PRESSURE_PLATE.get().defaultBlockState();
	public static final BlockState DARK_CONCRETE_BUTTON = BlockInit.DARK_CONCRETE_BUTTON.get().defaultBlockState();

	//Polished Light Concrete
	public static final BlockState POLISHED_DARK_CONCRETE = BlockInit.POLISHED_DARK_CONCRETE.get().defaultBlockState();
	public static final BlockState POLISHED_DARK_CONCRETE_STAIRS = BlockInit.POLISHED_DARK_CONCRETE_STAIRS.get().defaultBlockState();
	public static final BlockState POLISHED_DARK_CONCRETE_SLAB = BlockInit.POLISHED_DARK_CONCRETE_SLAB.get().defaultBlockState();
	
	//Wooden Planks
	public static final BlockState WOODEN_PLANKS = BlockInit.WOODEN_PLANKS.get().defaultBlockState();
	public static final BlockState WOODEN_PLANKS_STAIRS = BlockInit.WOODEN_PLANKS_STAIRS.get().defaultBlockState();
	public static final BlockState WOODEN_PLANKS_SLAB = BlockInit.WOODEN_PLANKS_SLAB.get().defaultBlockState();
	public static final BlockState WOODEN_PLANKS_FENCE = BlockInit.WOODEN_PLANKS_FENCE.get().defaultBlockState();
	public static final BlockState WOODEN_PLANKS_FENCE_GATE = BlockInit.WOODEN_PLANKS_FENCE_GATE.get().defaultBlockState();
	public static final BlockState WOODEN_PLANKS_PRESSURE_PLATE = BlockInit.WOODEN_PLANKS_PRESSURE_PLATE.get().defaultBlockState();
	public static final BlockState WOODEN_PLANKS_BUTTON = BlockInit.WOODEN_PLANKS_BUTTON.get().defaultBlockState();
	
	//Refined Wooden Planks
	public static final BlockState REFINED_WOODEN_PLANKS = BlockInit.REFINED_WOODEN_PLANKS.get().defaultBlockState();
	public static final BlockState REFINED_WOODEN_PLANKS_STAIRS = BlockInit.REFINED_WOODEN_PLANKS_STAIRS.get().defaultBlockState();
	public static final BlockState REFINED_WOODEN_PLANKS_SLAB = BlockInit.REFINED_WOODEN_PLANKS_SLAB.get().defaultBlockState();
	public static final BlockState REFINED_WOODEN_PLANKS_FENCE = BlockInit.REFINED_WOODEN_PLANKS_FENCE.get().defaultBlockState();
	public static final BlockState REFINED_WOODEN_PLANKS_FENCE_GATE = BlockInit.REFINED_WOODEN_PLANKS_FENCE_GATE.get().defaultBlockState();
	public static final BlockState REFINED_WOODEN_PLANKS_PRESSURE_PLATE = BlockInit.REFINED_WOODEN_PLANKS_PRESSURE_PLATE.get().defaultBlockState();
	public static final BlockState REFINED_WOODEN_PLANKS_BUTTON = BlockInit.REFINED_WOODEN_PLANKS_BUTTON.get().defaultBlockState();
	
	//Pavement
	public static final BlockState PAVEMENT = BlockInit.PAVEMENT.get().defaultBlockState();
	public static final BlockState PAVEMENT_SLOPE = BlockInit.PAVEMENT_SLOPE.get().defaultBlockState();
	public static final BlockState RAISED_PAVEMENT = BlockInit.RAISED_PAVEMENT.get().defaultBlockState();

	//Roads
	public static final BlockState GRAVEL_ROAD = BlockInit.GRAVEL_ROAD.get().defaultBlockState();
	public static final BlockState RAISED_GRAVEL_ROAD = BlockInit.RAISED_GRAVEL_ROAD.get().defaultBlockState();
	
	public static final BlockState DIRT_ROAD = BlockInit.DIRT_ROAD.get().defaultBlockState();
	public static final BlockState RAISED_DIRT_ROAD = BlockInit.RAISED_DIRT_ROAD.get().defaultBlockState();
		
	public static final BlockState PAVED_ROAD = BlockInit.PAVED_ROAD.get().defaultBlockState();
	public static final BlockState RAISED_PAVED_ROAD = BlockInit.RAISED_PAVED_ROAD.get().defaultBlockState();
	
	//Tile
	public static final BlockState TILE = BlockInit.TILE.get().defaultBlockState();
	public static final BlockState TILE_STAIRS = BlockInit.TILE_STAIRS.get().defaultBlockState();
	public static final BlockState TILE_SLAB = BlockInit.TILE_SLAB.get().defaultBlockState();

	//Fence
	public static final BlockState METAL_FENCE = BlockInit.METAL_FENCE.get().defaultBlockState();

	//Clear Glass
	public static final BlockState CLEAR_GLASS = BlockInit.CLEAR_GLASS.get().defaultBlockState();
	public static final BlockState CLEAR_GLASS_PANE = BlockInit.CLEAR_GLASS_PANE.get().defaultBlockState();
	
	//Tinted Glass
	public static final BlockState TINTED_GLASS = BlockInit.TINTED_GLASS.get().defaultBlockState();
	public static final BlockState TINTED_GLASS_PANE = BlockInit.TINTED_GLASS_PANE.get().defaultBlockState();
	
	//Coloured Glass
	public static final BlockState WHITE_GLASS = BlockInit.WHITE_GLASS.get().defaultBlockState();
	public static final BlockState WHITE_GLASS_PANE = BlockInit.WHITE_GLASS_PANE.get().defaultBlockState();	
	
	public static final BlockState LIGHT_GREY_GLASS = BlockInit.LIGHT_GREY_GLASS.get().defaultBlockState();
	public static final BlockState LIGHT_GREY_GLASS_PANE = BlockInit.LIGHT_GREY_GLASS_PANE.get().defaultBlockState();	
	
	public static final BlockState GREY_GLASS = BlockInit.GREY_GLASS.get().defaultBlockState();
	public static final BlockState GREY_GLASS_PANE = BlockInit.GREY_GLASS_PANE.get().defaultBlockState();	
	
	public static final BlockState BLACK_GLASS = BlockInit.BLACK_GLASS.get().defaultBlockState();
	public static final BlockState BLACK_GLASS_PANE = BlockInit.BLACK_GLASS_PANE.get().defaultBlockState();	
	
	public static final BlockState RED_GLASS = BlockInit.RED_GLASS.get().defaultBlockState();
	public static final BlockState RED_GLASS_PANE = BlockInit.RED_GLASS_PANE.get().defaultBlockState();	
	
	public static final BlockState ORANGE_GLASS = BlockInit.ORANGE_GLASS.get().defaultBlockState();
	public static final BlockState ORANGE_GLASS_PANE = BlockInit.ORANGE_GLASS_PANE.get().defaultBlockState();	
	
	public static final BlockState YELLOW_GLASS = BlockInit.YELLOW_GLASS.get().defaultBlockState();
	public static final BlockState YELLOW_GLASS_PANE = BlockInit.YELLOW_GLASS_PANE.get().defaultBlockState();	
	
	public static final BlockState LIME_GLASS = BlockInit.YELLOW_GLASS_PANE.get().defaultBlockState();
	public static final BlockState LIME_GLASS_PANE = BlockInit.LIME_GLASS_PANE.get().defaultBlockState();	
	
	public static final BlockState GREEN_GLASS = BlockInit.GREEN_GLASS.get().defaultBlockState();
	public static final BlockState GREEN_GLASS_PANE = BlockInit.GREEN_GLASS_PANE.get().defaultBlockState();	
	
	public static final BlockState CYAN_GLASS = BlockInit.CYAN_GLASS.get().defaultBlockState();
	public static final BlockState CYAN_GLASS_PANE = BlockInit.CYAN_GLASS_PANE.get().defaultBlockState();
	
	public static final BlockState LIGHT_BLUE_GLASS = BlockInit.LIGHT_BLUE_GLASS.get().defaultBlockState();
	public static final BlockState LIGHT_BLUE_GLASS_PANE = BlockInit.LIGHT_BLUE_GLASS_PANE.get().defaultBlockState();
	
	public static final BlockState BLUE_GLASS = BlockInit.BLUE_GLASS.get().defaultBlockState();
	public static final BlockState BLUE_GLASS_PANE = BlockInit.BLUE_GLASS_PANE.get().defaultBlockState();
	
	public static final BlockState PURPLE_GLASS = BlockInit.PURPLE_GLASS.get().defaultBlockState();
	public static final BlockState PURPLE_GLASS_PANE = BlockInit.PURPLE_GLASS_PANE.get().defaultBlockState();
	
	public static final BlockState MAGENTA_GLASS = BlockInit.MAGENTA_GLASS.get().defaultBlockState();
	public static final BlockState MAGENTA_GLASS_PANE = BlockInit.MAGENTA_GLASS_PANE.get().defaultBlockState();
	
	public static final BlockState PINK_GLASS = BlockInit.PINK_GLASS.get().defaultBlockState();
	public static final BlockState PINK_GLASS_PANE = BlockInit.PINK_GLASS_PANE.get().defaultBlockState();
	
	public static final BlockState BROWN_GLASS = BlockInit.BROWN_GLASS.get().defaultBlockState();
	public static final BlockState BROWN_GLASS_PANE = BlockInit.BROWN_GLASS_PANE.get().defaultBlockState();
	
	public static final BlockState SHADED_GLASS = BlockInit.SHADED_GLASS.get().defaultBlockState();
	public static final BlockState SHADED_GLASS_PANE = BlockInit.SHADED_GLASS_PANE.get().defaultBlockState();
	
	//Colour Blocks
	public static final BlockState RED_DECORATION_BLOCK = BlockInit.RED_DECORATION_BLOCK.get().defaultBlockState();
	public static final BlockState ORANGE_DECORATION_BLOCK = BlockInit.ORANGE_DECORATION_BLOCK.get().defaultBlockState();
	public static final BlockState YELLOW_DECORATION_BLOCK = BlockInit.YELLOW_DECORATION_BLOCK.get().defaultBlockState();
	public static final BlockState LIME_DECORATION_BLOCK = BlockInit.LIME_DECORATION_BLOCK.get().defaultBlockState();
	public static final BlockState GREEN_DECORATION_BLOCK = BlockInit.GREEN_DECORATION_BLOCK.get().defaultBlockState();
	public static final BlockState CYAN_DECORATION_BLOCK = BlockInit.CYAN_DECORATION_BLOCK.get().defaultBlockState();
	public static final BlockState BLUE_DECORATION_BLOCK = BlockInit.BLUE_DECORATION_BLOCK.get().defaultBlockState();
	public static final BlockState LIGHT_BLUE_DECORATION_BLOCK = BlockInit.LIGHT_BLUE_DECORATION_BLOCK.get().defaultBlockState();
	public static final BlockState PURPLE_DECORATION_BLOCK = BlockInit.PURPLE_DECORATION_BLOCK.get().defaultBlockState();
	public static final BlockState MAGENTA_DECORATION_BLOCK = BlockInit.MAGENTA_DECORATION_BLOCK.get().defaultBlockState();
	public static final BlockState PINK_DECORATION_BLOCK = BlockInit.PINK_DECORATION_BLOCK.get().defaultBlockState();
	public static final BlockState BROWN_DECORATION_BLOCK = BlockInit.BROWN_DECORATION_BLOCK.get().defaultBlockState();
	public static final BlockState GREY_DECORATION_BLOCK = BlockInit.GREY_DECORATION_BLOCK.get().defaultBlockState();
	public static final BlockState LIGHT_GREY_DECORATION_BLOCK = BlockInit.LIGHT_GREY_DECORATION_BLOCK.get().defaultBlockState();
	public static final BlockState WHITE_DECORATION_BLOCK = BlockInit.WHITE_DECORATION_BLOCK.get().defaultBlockState();
	public static final BlockState BLACK_DECORATION_BLOCK = BlockInit.BLACK_DECORATION_BLOCK.get().defaultBlockState();

	//Thatch
	public static final BlockState THATCH_BLOCK = BlockInit.THATCH_BLOCK.get().defaultBlockState();
	
	//Doors
	public static final BlockState OUTDOOR_TOILET_DOOR = BlockInit.OUTDOOR_TOILET_DOOR.get().defaultBlockState();
	public static final BlockState GLASS_SHOP_DOOR = BlockInit.GLASS_SHOP_DOOR.get().defaultBlockState();
	public static final BlockState VISITOR_CENTRE_DOOR = BlockInit.VISITOR_CENTRE_DOOR.get().defaultBlockState();
	public static final BlockState INNOVATION_CENTRE_DOOR = BlockInit.INNOVATION_CENTRE_DOOR.get().defaultBlockState();
	public static final BlockState SECURITY_DOOR = BlockInit.SECURITY_DOOR.get().defaultBlockState();
	public static final BlockState BACK_DOOR = BlockInit.BACK_DOOR.get().defaultBlockState();
}
