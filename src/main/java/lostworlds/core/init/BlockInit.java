package lostworlds.core.init;

import lostworlds.common.blocks.ExposedFossilBlock;
import lostworlds.common.blocks.PlasteredFossilBlock;
import lostworlds.core.util.ModMaterials;
import lostworlds.core.util.ModToolType;
import lostworlds.core.util.registry.ModRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.HayBlock;
import net.minecraft.block.OreBlock;
import net.minecraft.block.PaneBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.PressurePlateBlock.Sensitivity;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.StoneButtonBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.WoodButtonBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

@SuppressWarnings("deprecation")
public class BlockInit 
{
	//Copper
	public static final RegistryObject<OreBlock> COPPER_ORE = ModRegistry.BLOCK_REGISTRY.register("copper_ore", () -> new OreBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F).sound(SoundType.STONE)));
		
	//Fossils
	public static final RegistryObject<Block> STONE_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("stone_fossil", () -> new Block(AbstractBlock.Properties.create(ModMaterials.MADE_FOR_BRUSH, MaterialColor.STONE).harvestTool(ModToolType.BRUSH).harvestLevel(0).setRequiresTool().hardnessAndResistance(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<ExposedFossilBlock> EXPOSED_STONE_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("exposed_stone_fossil", () -> new ExposedFossilBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool().hardnessAndResistance(1.25F).notSolid().sound(SoundType.STONE)));
	public static final RegistryObject<PlasteredFossilBlock> PLASTERED_STONE_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("plastered_stone_fossil", () -> new PlasteredFossilBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).zeroHardnessAndResistance().sound(SoundType.CLOTH).notSolid()));
		
	//Fossil Processing
//	public static final RegistryObject<FossilCleanerBlock> FOSSIL_CLEANER = ModRegistry.BLOCK_REGISTRY.register("fossil_cleaner", () -> new FossilCleanerBlock(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GRAY)));
	
	//Permian Stuff
	public static final RegistryObject<Block> PERMAIN_SAND = ModRegistry.BLOCK_REGISTRY.register("permian_sand", () -> new Block(AbstractBlock.Properties.create(Material.SAND)));
	
	//Paths
	
	//Light Concrete
	public static final RegistryObject<Block> LIGHT_CONCRETE = ModRegistry.BLOCK_REGISTRY.register("light_concrete", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool().hardnessAndResistance(6.0F, 8.0F).sound(SoundType.STONE)));
	public static final RegistryObject<StairsBlock> LIGHT_CONCRETE_STAIRS = ModRegistry.BLOCK_REGISTRY.register("light_concrete_stairs", () -> new StairsBlock(BlockInit.LIGHT_CONCRETE.get().getDefaultState(), AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool().hardnessAndResistance(6.0F, 8.0F).sound(SoundType.STONE)));
	public static final RegistryObject<SlabBlock> LIGHT_CONCRETE_SLAB = ModRegistry.BLOCK_REGISTRY.register("light_concrete_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool().hardnessAndResistance(6.0F, 8.0F).sound(SoundType.STONE)));
	public static final RegistryObject<WallBlock> LIGHT_CONCRETE_WALL = ModRegistry.BLOCK_REGISTRY.register("light_concrete_wall", () -> new WallBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool().hardnessAndResistance(6.0F, 8.0F).doesNotBlockMovement().sound(SoundType.STONE)));
	public static final RegistryObject<PressurePlateBlock> LIGHT_CONCRETE_PRESSURE_PLATE = ModRegistry.BLOCK_REGISTRY.register("light_concrete_pressure_plate", () -> new PressurePlateBlock(Sensitivity.MOBS, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool().hardnessAndResistance(6.0F, 8.0F).doesNotBlockMovement().sound(SoundType.STONE)));
	public static final RegistryObject<StoneButtonBlock> LIGHT_CONCRETE_BUTTON = ModRegistry.BLOCK_REGISTRY.register("light_concrete_button", () -> new StoneButtonBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool().hardnessAndResistance(6.0F, 8.0F).doesNotBlockMovement().sound(SoundType.STONE)));

	//Polished Light Concrete
	public static final RegistryObject<Block> POLISHED_LIGHT_CONCRETE = ModRegistry.BLOCK_REGISTRY.register("polished_light_concrete", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool().hardnessAndResistance(6.5F, 8.5F).sound(SoundType.STONE)));
	public static final RegistryObject<StairsBlock> POLISHED_LIGHT_CONCRETE_STAIRS = ModRegistry.BLOCK_REGISTRY.register("polished_light_concrete_stairs", () -> new StairsBlock(BlockInit.LIGHT_CONCRETE.get().getDefaultState(), AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool().hardnessAndResistance(6.5F, 8.5F).sound(SoundType.STONE)));
	public static final RegistryObject<SlabBlock> POLISHED_LIGHT_CONCRETE_SLAB = ModRegistry.BLOCK_REGISTRY.register("polished_light_concrete_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool().hardnessAndResistance(6.5F, 8.5F).sound(SoundType.STONE)));

	//Dark Concrete
	public static final RegistryObject<Block> DARK_CONCRETE = ModRegistry.BLOCK_REGISTRY.register("dark_concrete", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool().hardnessAndResistance(8.0F, 10.0F).sound(SoundType.STONE)));
	public static final RegistryObject<StairsBlock> DARK_CONCRETE_STAIRS = ModRegistry.BLOCK_REGISTRY.register("dark_concrete_stairs", () -> new StairsBlock(() -> BlockInit.DARK_CONCRETE.get().getDefaultState(), AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool().hardnessAndResistance(8.0F, 10.0F).sound(SoundType.STONE)));
	public static final RegistryObject<SlabBlock> DARK_CONCRETE_SLAB = ModRegistry.BLOCK_REGISTRY.register("dark_concrete_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool().hardnessAndResistance(8.0F, 10.0F).sound(SoundType.STONE)));
	public static final RegistryObject<WallBlock> DARK_CONCRETE_WALL = ModRegistry.BLOCK_REGISTRY.register("dark_concrete_wall", () -> new WallBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool().hardnessAndResistance(8.0F, 10.0F).sound(SoundType.STONE)));
	public static final RegistryObject<PressurePlateBlock> DARK_CONCRETE_PRESSURE_PLATE = ModRegistry.BLOCK_REGISTRY.register("dark_concrete_pressure_plate", () -> new PressurePlateBlock(Sensitivity.MOBS, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool().hardnessAndResistance(8.0F, 10.0F).doesNotBlockMovement().sound(SoundType.STONE)));
	public static final RegistryObject<StoneButtonBlock> DARK_CONCRETE_BUTTON = ModRegistry.BLOCK_REGISTRY.register("dark_concrete_button", () -> new StoneButtonBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool().hardnessAndResistance(8.0F, 10.0F).doesNotBlockMovement().sound(SoundType.STONE)));
	
	//Polished Dark Concrete
	public static final RegistryObject<Block> POLISHED_DARK_CONCRETE = ModRegistry.BLOCK_REGISTRY.register("polished_dark_concrete", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool().hardnessAndResistance(8.5F, 10.5F).sound(SoundType.STONE)));
	public static final RegistryObject<StairsBlock> POLISHED_DARK_CONCRETE_STAIRS = ModRegistry.BLOCK_REGISTRY.register("polished_dark_concrete_stairs", () -> new StairsBlock(() -> BlockInit.DARK_CONCRETE.get().getDefaultState(), AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool().hardnessAndResistance(8.5F, 10.5F).sound(SoundType.STONE)));
	public static final RegistryObject<SlabBlock> POLISHED_DARK_CONCRETE_SLAB = ModRegistry.BLOCK_REGISTRY.register("polished_dark_concrete_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool().hardnessAndResistance(8.5F, 10.5F).sound(SoundType.STONE)));

	//Wooden Planks
	public static final RegistryObject<Block> WOODEN_PLANKS = ModRegistry.BLOCK_REGISTRY.register("wooden_planks", () -> new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).hardnessAndResistance(1.2F, 0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<StairsBlock> WOODEN_PLANKS_STAIRS = ModRegistry.BLOCK_REGISTRY.register("wooden_planks_stairs", () -> new StairsBlock(() -> BlockInit.WOODEN_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).hardnessAndResistance(1.2F, 0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<SlabBlock> WOODEN_PLANKS_SLAB = ModRegistry.BLOCK_REGISTRY.register("wooden_planks_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).hardnessAndResistance(1.2F, 0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<FenceBlock> WOODEN_PLANKS_FENCE = ModRegistry.BLOCK_REGISTRY.register("wooden_planks_fence", () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).hardnessAndResistance(1.2F, 0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<FenceGateBlock> WOODEN_PLANKS_FENCE_GATE = ModRegistry.BLOCK_REGISTRY.register("wooden_planks_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).hardnessAndResistance(1.2F, 0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<PressurePlateBlock> WOODEN_PLANKS_PRESSURE_PLATE = ModRegistry.BLOCK_REGISTRY.register("wooden_planks_pressure_plate", () -> new PressurePlateBlock(Sensitivity.EVERYTHING, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).hardnessAndResistance(1.2F, 0.5F).doesNotBlockMovement().sound(SoundType.WOOD)));
	public static final RegistryObject<WoodButtonBlock> WOODEN_PLANKS_BUTTON = ModRegistry.BLOCK_REGISTRY.register("wooden_planks_button", () -> new WoodButtonBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).hardnessAndResistance(1.2F, 0.5F).doesNotBlockMovement().sound(SoundType.WOOD)));

	//Wooden Planks
	public static final RegistryObject<Block> REFINED_WOODEN_PLANKS = ModRegistry.BLOCK_REGISTRY.register("refined_wooden_planks", () -> new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).hardnessAndResistance(2.7F, 1.9F).sound(SoundType.WOOD)));
	public static final RegistryObject<StairsBlock> REFINED_WOODEN_PLANKS_STAIRS = ModRegistry.BLOCK_REGISTRY.register("refined_wooden_planks_stairs", () -> new StairsBlock(() -> BlockInit.REFINED_WOODEN_PLANKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).hardnessAndResistance(2.7F, 1.9F).sound(SoundType.WOOD)));
	public static final RegistryObject<SlabBlock> REFINED_WOODEN_PLANKS_SLAB = ModRegistry.BLOCK_REGISTRY.register("refined_wooden_planks_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).hardnessAndResistance(2.7F, 1.9F).sound(SoundType.WOOD)));
	public static final RegistryObject<FenceBlock> REFINED_WOODEN_PLANKS_FENCE = ModRegistry.BLOCK_REGISTRY.register("refined_wooden_planks_fence", () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).hardnessAndResistance(2.7F, 1.9F).sound(SoundType.WOOD)));
	public static final RegistryObject<FenceGateBlock> REFINED_WOODEN_PLANKS_FENCE_GATE = ModRegistry.BLOCK_REGISTRY.register("refined_wooden_planks_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).hardnessAndResistance(2.7F, 1.9F).sound(SoundType.WOOD)));
	public static final RegistryObject<PressurePlateBlock> REFINED_WOODEN_PLANKS_PRESSURE_PLATE = ModRegistry.BLOCK_REGISTRY.register("refined_wooden_planks_pressure_plate", () -> new PressurePlateBlock(Sensitivity.EVERYTHING, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).hardnessAndResistance(2.7F, 1.9F).doesNotBlockMovement().sound(SoundType.WOOD)));
	public static final RegistryObject<WoodButtonBlock> REFINED_WOODEN_PLANKS_BUTTON = ModRegistry.BLOCK_REGISTRY.register("refined_wooden_planks_button", () -> new WoodButtonBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).hardnessAndResistance(2.7F, 1.9F).doesNotBlockMovement().sound(SoundType.WOOD)));

	//Pavement
	public static final RegistryObject<Block> PAVEMENT = ModRegistry.BLOCK_REGISTRY.register("pavement", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.LIGHT_GRAY_TERRACOTTA).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F).sound(SoundType.STONE)));
	public static final RegistryObject<StairsBlock> PAVEMENT_SLOPE = ModRegistry.BLOCK_REGISTRY.register("pavement_slope", () -> new StairsBlock(() -> BlockInit.PAVEMENT.get().getDefaultState(), AbstractBlock.Properties.create(Material.ROCK, MaterialColor.LIGHT_GRAY_TERRACOTTA).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F).sound(SoundType.STONE)));
	public static final RegistryObject<SlabBlock> RAISED_PAVEMENT = ModRegistry.BLOCK_REGISTRY.register("raised_pavement", () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.LIGHT_GRAY_TERRACOTTA).harvestTool(ToolType.PICKAXE).harvestLevel(1).hardnessAndResistance(3.0F).setRequiresTool().sound(SoundType.STONE)));
	
	//Roads
	public static final RegistryObject<Block> GRAVEL_ROAD = ModRegistry.BLOCK_REGISTRY.register("gravel_road", () -> new Block(AbstractBlock.Properties.create(Material.SAND, MaterialColor.LIGHT_GRAY_TERRACOTTA).harvestTool(ToolType.SHOVEL).harvestLevel(0).hardnessAndResistance(1.5F).sound(SoundType.SAND)));
	public static final RegistryObject<SlabBlock> RAISED_GRAVEL_ROAD = ModRegistry.BLOCK_REGISTRY.register("raised_gravel_road", () -> new SlabBlock(AbstractBlock.Properties.create(Material.SAND, MaterialColor.LIGHT_GRAY_TERRACOTTA).harvestTool(ToolType.SHOVEL).harvestLevel(0).hardnessAndResistance(1.5F).sound(SoundType.SAND)));
	
	public static final RegistryObject<Block> DIRT_ROAD = ModRegistry.BLOCK_REGISTRY.register("dirt_road", () -> new Block(AbstractBlock.Properties.create(Material.EARTH, MaterialColor.DIRT).harvestTool(ToolType.SHOVEL).harvestLevel(0).hardnessAndResistance(1.5F).sound(SoundType.GROUND)));
	public static final RegistryObject<SlabBlock> RAISED_DIRT_ROAD = ModRegistry.BLOCK_REGISTRY.register("raised_dirt_road", () -> new SlabBlock(AbstractBlock.Properties.create(Material.EARTH, MaterialColor.DIRT).harvestTool(ToolType.SHOVEL).harvestLevel(0).hardnessAndResistance(1.5F).sound(SoundType.GROUND)));
		
	public static final RegistryObject<Block> PAVED_ROAD = ModRegistry.BLOCK_REGISTRY.register("paved_road", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.5F).sound(SoundType.STONE)));
	public static final RegistryObject<SlabBlock> RAISED_PAVED_ROAD = ModRegistry.BLOCK_REGISTRY.register("raised_paved_road", () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.5F).sound(SoundType.STONE)));
	
	//Tile
	public static final RegistryObject<Block> TILE = ModRegistry.BLOCK_REGISTRY.register("tile", () -> new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).hardnessAndResistance(2.7F, 1.9F).sound(SoundType.WOOD)));
	public static final RegistryObject<StairsBlock> TILE_STAIRS = ModRegistry.BLOCK_REGISTRY.register("tile_stairs", () -> new StairsBlock(() -> BlockInit.TILE.get().getDefaultState(), AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).hardnessAndResistance(2.7F, 1.9F).sound(SoundType.WOOD)));
	public static final RegistryObject<SlabBlock> TILE_SLAB = ModRegistry.BLOCK_REGISTRY.register("tile_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).hardnessAndResistance(2.7F, 1.9F).sound(SoundType.WOOD)));

	//Fence
	public static final RegistryObject<FenceBlock> METAL_FENCE = ModRegistry.BLOCK_REGISTRY.register("metal_fence", () -> new FenceBlock(AbstractBlock.Properties.create(Material.IRON, MaterialColor.RED).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool().hardnessAndResistance(4.5F, 6.0F).sound(SoundType.METAL)));

	//Clear Glass
	public static final RegistryObject<GlassBlock> CLEAR_GLASS = ModRegistry.BLOCK_REGISTRY.register("clear_glass", () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS, MaterialColor.WHITE_TERRACOTTA).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> CLEAR_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("clear_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.create(Material.GLASS, MaterialColor.WHITE_TERRACOTTA).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));	
	
	//Tinted Glass
	public static final RegistryObject<GlassBlock> TINTED_GLASS = ModRegistry.BLOCK_REGISTRY.register("tinted_glass", () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS, MaterialColor.BROWN).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> TINTED_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("tinted_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.create(Material.GLASS, MaterialColor.BROWN).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));
	
	//Coloured Glass
	public static final RegistryObject<GlassBlock> WHITE_GLASS = ModRegistry.BLOCK_REGISTRY.register("white_glass", () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS, MaterialColor.WHITE_TERRACOTTA).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> WHITE_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("white_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.create(Material.GLASS, MaterialColor.WHITE_TERRACOTTA).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<GlassBlock> LIGHT_GREY_GLASS = ModRegistry.BLOCK_REGISTRY.register("light_grey_glass", () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> LIGHT_GREY_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("light_grey_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<GlassBlock> GREY_GLASS = ModRegistry.BLOCK_REGISTRY.register("grey_glass", () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> GREY_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("grey_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<GlassBlock> BLACK_GLASS = ModRegistry.BLOCK_REGISTRY.register("black_glass", () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> BLACK_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("black_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<GlassBlock> RED_GLASS = ModRegistry.BLOCK_REGISTRY.register("red_glass", () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> RED_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("red_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<GlassBlock> ORANGE_GLASS = ModRegistry.BLOCK_REGISTRY.register("orange_glass", () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> ORANGE_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("orange_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<GlassBlock> YELLOW_GLASS = ModRegistry.BLOCK_REGISTRY.register("yellow_glass", () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> YELLOW_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("yellow_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<GlassBlock> LIME_GLASS = ModRegistry.BLOCK_REGISTRY.register("lime_glass", () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> LIME_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("lime_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<GlassBlock> GREEN_GLASS = ModRegistry.BLOCK_REGISTRY.register("green_glass", () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> GREEN_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("green_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<GlassBlock> CYAN_GLASS = ModRegistry.BLOCK_REGISTRY.register("cyan_glass", () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> CYAN_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("cyan_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<GlassBlock> LIGHT_BLUE_GLASS = ModRegistry.BLOCK_REGISTRY.register("light_blue_glass", () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(3.0F).notSolid().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> LIGHT_BLUE_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("light_blue_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<GlassBlock> BLUE_GLASS = ModRegistry.BLOCK_REGISTRY.register("blue_glass", () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> BLUE_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("blue_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<GlassBlock> PURPLE_GLASS = ModRegistry.BLOCK_REGISTRY.register("purple_glass", () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> PURPLE_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("purple_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<GlassBlock> MAGENTA_GLASS = ModRegistry.BLOCK_REGISTRY.register("magenta_glass", () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> MAGENTA_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("magenta_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<GlassBlock> PINK_GLASS = ModRegistry.BLOCK_REGISTRY.register("pink_glass", () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> PINK_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("pink_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<GlassBlock> BROWN_GLASS = ModRegistry.BLOCK_REGISTRY.register("brown_glass", () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> BROWN_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("brown_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).notSolid().sound(SoundType.GLASS)));	
	
	//Colour Blocks
	public static final RegistryObject<Block> RED_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("red_decoration_block", () -> new Block(AbstractBlock.Properties.from(Blocks.IRON_BLOCK)));
	public static final RegistryObject<Block> ORANGE_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("orange_decoration_block", () -> new Block(AbstractBlock.Properties.from(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> YELLOW_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("yellow_decoration_block", () -> new Block(AbstractBlock.Properties.from(Blocks.IRON_BLOCK)));
	public static final RegistryObject<Block> LIME_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("lime_decoration_block", () -> new Block(AbstractBlock.Properties.from(Blocks.IRON_BLOCK)));
	public static final RegistryObject<Block> GREEN_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("green_decoration_block", () -> new Block(AbstractBlock.Properties.from(Blocks.IRON_BLOCK)));
	public static final RegistryObject<Block> CYAN_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("cyan_decoration_block", () -> new Block(AbstractBlock.Properties.from(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> BLUE_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("blue_decoration_block", () -> new Block(AbstractBlock.Properties.from(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> LIGHT_BLUE_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("light_blue_decoration_block", () -> new Block(AbstractBlock.Properties.from(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> PURPLE_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("purple_decoration_block", () -> new Block(AbstractBlock.Properties.from(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> MAGENTA_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("magenta_decoration_block", () -> new Block(AbstractBlock.Properties.from(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> PINK_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("pink_decoration_block", () -> new Block(AbstractBlock.Properties.from(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> BROWN_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("brown_decoration_block", () -> new Block(AbstractBlock.Properties.from(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> GREY_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("grey_decoration_block", () -> new Block(AbstractBlock.Properties.from(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> LIGHT_GREY_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("light_grey_decoration_block", () -> new Block(AbstractBlock.Properties.from(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> WHITE_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("white_decoration_block", () -> new Block(AbstractBlock.Properties.from(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> BLACK_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("black_decoration_block", () -> new Block(AbstractBlock.Properties.from(Blocks.IRON_BLOCK)));

	//Thatch
	public static final RegistryObject<HayBlock> THATCH_BLOCK = ModRegistry.BLOCK_REGISTRY.register("thatch_block", () -> new HayBlock(AbstractBlock.Properties.from(Blocks.HAY_BLOCK)));
	
	//Doors
	public static final RegistryObject<DoorBlock> OUTDOOR_TOILET_DOOR = ModRegistry.BLOCK_REGISTRY.register("outdoor_toilet_door", () -> new DoorBlock(AbstractBlock.Properties.from(Blocks.OAK_DOOR)));
	public static final RegistryObject<DoorBlock> GLASS_SHOP_DOOR = ModRegistry.BLOCK_REGISTRY.register("glass_shop_door", () -> new DoorBlock(AbstractBlock.Properties.from(Blocks.ACACIA_DOOR)));	
	public static final RegistryObject<DoorBlock> VISITOR_CENTRE_DOOR = ModRegistry.BLOCK_REGISTRY.register("visitor_centre_door", () -> new DoorBlock(AbstractBlock.Properties.from(Blocks.OAK_DOOR)));	
	public static final RegistryObject<DoorBlock> INNOVATION_CENTRE_DOOR = ModRegistry.BLOCK_REGISTRY.register("innovation_centre_door", () -> new DoorBlock(AbstractBlock.Properties.from(Blocks.ACACIA_DOOR)));
	public static final RegistryObject<DoorBlock> SECURITY_DOOR = ModRegistry.BLOCK_REGISTRY.register("security_door", () -> new DoorBlock(AbstractBlock.Properties.from(Blocks.IRON_DOOR)));
	public static final RegistryObject<DoorBlock> BACK_DOOR = ModRegistry.BLOCK_REGISTRY.register("back_door", () -> new DoorBlock(AbstractBlock.Properties.from(Blocks.IRON_DOOR)));
	
	//Registry
	public static void initBlocks() { }
}
