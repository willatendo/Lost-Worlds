package lostworlds.content.server.init;

import lostworlds.library.ModMaterials;
import lostworlds.library.ModToolTypes;
import lostworlds.library.block.AnalyserBlock;
import lostworlds.library.block.ArchaeologyTable;
import lostworlds.library.block.AshLayerBlock;
import lostworlds.library.block.ColouredDecorationBlock;
import lostworlds.library.block.DNAExtractorBlock;
import lostworlds.library.block.DNAInjectorBlock;
import lostworlds.library.block.DeadSpongeColonyBlock;
import lostworlds.library.block.DriedSoilBlock;
import lostworlds.library.block.ExposedFossilBlock;
import lostworlds.library.block.FossilBlock;
import lostworlds.library.block.FossilCleanerBlock;
import lostworlds.library.block.FossilGrinderBlock;
import lostworlds.library.block.GeyserBlock;
import lostworlds.library.block.GroundFernsBlock;
import lostworlds.library.block.ModBushBlock;
import lostworlds.library.block.ModOreBlock;
import lostworlds.library.block.ModOreRotatedPillerBlock;
import lostworlds.library.block.ModSaplingBlock;
import lostworlds.library.block.ModStandingSignBlock;
import lostworlds.library.block.ModWallSignBlock;
import lostworlds.library.block.MossyDirtBlock;
import lostworlds.library.block.PlasteredFossilBlock;
import lostworlds.library.block.PowerSupplyBlock;
import lostworlds.library.block.QuintuplePlantBlock;
import lostworlds.library.block.RockOutcropBlock;
import lostworlds.library.block.SpongeColonyBlock;
import lostworlds.library.block.SticksBlock;
import lostworlds.library.block.TimeMachineBlock;
import lostworlds.library.block.TriplePlantBlock;
import lostworlds.library.block.forge.ForgeBlock;
import lostworlds.library.block.forge.ForgeBlockAndItem;
import lostworlds.library.block.forge.ForgeStandingSignBlock;
import lostworlds.library.block.forge.ForgeWallSignBlock;
import lostworlds.library.item.forge.ForgeSignItem;
import lostworlds.library.tree.ConiferTree;
import lostworlds.library.util.ModUtil;
import lostworlds.library.util.ModWoodTypes;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.HayBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.PaneBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.PressurePlateBlock.Sensitivity;
import net.minecraft.block.RedstoneOreBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SandBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.StoneButtonBlock;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.WoodButtonBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.ToolType;

/*
 * Author: Willatendo
 * Date: July 11, 2021
 */

public class BlockInit 
{
	/*
	
	BlockInit is sorted in order of:
	- Nature Blocks (Plants (A to Z) to Full Blocks(A to Z))
	- Overworld Ores (Common to Least Common)
	- Machines (Order)
	- Building Blocks (Natural Stones)
	- Trees (A to Z)
	- Dimension Blocks (Oldest Era to Youngest (Top Layer, Stones, Crafted Stones, Ores))
	- Jurassic Park Building Blocks
	- Jurassic World Building Blocks
	- Mixed Park Building Blocks
	
	 */
	
	//Nature Blocks
	public static final Block ASHY_SHRUB = ForgeBlockAndItem.create("ashy_shrub", new ModBushBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final Block ALETHOPTERIS = ForgeBlockAndItem.create("alethopteris", new DoublePlantBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final Block CEPHALOTAXUS = ForgeBlockAndItem.create("cephalotaxus", new ModBushBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final Block CYCAD = ForgeBlockAndItem.create("cycad", new ModBushBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final Block DICKSONIA = ForgeBlockAndItem.create("dicksonia", new ModBushBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final Block TALL_DICKSONIA = ForgeBlockAndItem.create("tall_dicksonia", new DoublePlantBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final Block DILLHOFFIA = ForgeBlockAndItem.create("dillhoffia", new FlowerBlock(Effects.BLINDNESS, 7, AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final Block POTTED_DILLHOFFIA = ForgeBlock.create("potted_dillhoffia", new FlowerPotBlock(DILLHOFFIA, AbstractBlock.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final Block DUISBERGIA = ForgeBlockAndItem.create("duisbergia", new DoublePlantBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final Block GROUND_FERNS = ForgeBlockAndItem.create("ground_ferns", new GroundFernsBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final Block HORSETAIL = ForgeBlockAndItem.create("horsetail", new TriplePlantBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final Block LYCOPHYTA = ForgeBlockAndItem.create("lycophyta", new ModBushBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final Block OSMUNDA = ForgeBlockAndItem.create("osmunda", new ModBushBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final Block SMALL_PERMIAN_DESERT_PLANT = ForgeBlockAndItem.create("small_permian_desert_plant", new ModBushBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_BROWN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final Block MEDIUM_PERMIAN_DESERT_PLANT = ForgeBlockAndItem.create("medium_permian_desert_plant", new ModBushBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_BROWN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final Block LARGE_PERMIAN_DESERT_PLANT = ForgeBlockAndItem.create("large_permian_desert_plant", new ModBushBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_BROWN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final Block LUSH_PERMIAN_DESERT_PLANT = ForgeBlockAndItem.create("lush_permian_desert_plant", new ModBushBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final Block DEAD_PERMIAN_SHRUB = ForgeBlockAndItem.create("dead_permian_shrub", new ModBushBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final Block DEAD_LARGE_PERMIAN_SHRUB = ForgeBlockAndItem.create("dead_large_permian_shrub", new ModBushBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final Block TEMPSKYA = ForgeBlockAndItem.create("tempskya", new QuintuplePlantBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));

	public static final Block DIICTODON_BURROW = ForgeBlockAndItem.create("diictodon_burrow", new Block(AbstractBlock.Properties.of(Material.SAND, MaterialColor.SAND).harvestTool(ToolType.SHOVEL).strength(1.5F).sound(SoundType.SAND)));

	public static final Block DRIED_SOIL = ForgeBlockAndItem.create("dried_soil", new DriedSoilBlock(AbstractBlock.Properties.of(Material.DIRT, MaterialColor.DIRT).strength(0.75F).sound(SoundType.GRAVEL).randomTicks()));
	public static final Block CRACKED_SOIL = ForgeBlockAndItem.create("cracked_soil", new Block(AbstractBlock.Properties.of(Material.DIRT, MaterialColor.DIRT).strength(0.75F).sound(SoundType.GRAVEL)));
	
	public static final Block GEYSER_BLOCK = ForgeBlockAndItem.create("geyser_block", new GeyserBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).strength(0.75F).noOcclusion()));
	
	public static final Block MOSSY_DIRT = MossyDirtBlock.create();
	
	public static final Block MUD = ForgeBlockAndItem.create("mud", new Block(AbstractBlock.Properties.of(Material.CLAY, MaterialColor.COLOR_BROWN).harvestTool(ToolType.SHOVEL).strength(0.6F).sound(SoundType.GRAVEL)));

	public static final Block NESTING_BLOCK = ForgeBlockAndItem.create("nesting_block", new Block(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_BROWN).harvestTool(ToolType.SHOVEL).strength(0.3F).sound(SoundType.GRASS)));

	public static final Block PERMIAN_ROCK_OUTCROP = ForgeBlockAndItem.create("permian_rock_outcrop", new RockOutcropBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).noOcclusion().sound(SoundType.STONE)));
	
	public static final Block DEAD_SPONGE_COLONY = ForgeBlockAndItem.create("dead_sponge_colony", new DeadSpongeColonyBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.STONE).noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final Block SPONGE_COLONY = ForgeBlockAndItem.create("sponge_colony", new SpongeColonyBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().noOcclusion().strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK), BlockInit.DEAD_SPONGE_COLONY));

	public static final Block SILT = ForgeBlockAndItem.create("silt", new Block(AbstractBlock.Properties.of(Material.CLAY, MaterialColor.COLOR_BROWN).harvestTool(ToolType.SHOVEL).strength(0.6F).sound(SoundType.GRAVEL)));

	public static final Block TUNNELED_SOIL = ForgeBlockAndItem.create("tunneled_soil", new Block(AbstractBlock.Properties.of(Material.DIRT, MaterialColor.DIRT).strength(0.5F).sound(SoundType.GRAVEL)));

	public static final Block VOLCANIC_ASH = ForgeBlockAndItem.create("volcanic_ash", new SandBlock(0x888988, AbstractBlock.Properties.of(Material.SAND, MaterialColor.COLOR_GRAY).harvestTool(ToolType.SHOVEL).harvestLevel(1).strength(0.5F).sound(SoundType.SAND)));
	public static final Block VOLCANIC_ASH_LAYER = ForgeBlockAndItem.create("volcanic_ash_layer", new AshLayerBlock());
	
	//Overworld Ores
	public static final Block COPPER_ORE = ForgeBlockAndItem.create("copper_ore", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(3.0F).sound(SoundType.STONE)));

	public static final Block BASALT_DIAMOND_ORE = ForgeBlockAndItem.create("basalt_diamond_ore", new ModOreRotatedPillerBlock(AbstractBlock.Properties.copy(Blocks.BASALT)));

	public static final Block EXPOSED_STONE_FOSSIL = ForgeBlockAndItem.create("exposed_stone_fossil", new ExposedFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_NOTHING, MaterialColor.STONE).harvestTool(ModToolTypes.BRUSH).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final Block STONE_FOSSIL = ForgeBlockAndItem.create("stone_fossil", new FossilBlock(EXPOSED_STONE_FOSSIL, AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.STONE).harvestTool(ModToolTypes.BRUSH).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	
	public static final Block EXPOSED_SANDSTONE_FOSSIL = ForgeBlockAndItem.create("exposed_sandstone_fossil", new ExposedFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_NOTHING, MaterialColor.STONE).harvestTool(ModToolTypes.BRUSH).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final Block SANDSTONE_FOSSIL = ForgeBlockAndItem.create("sandstone_fossil", new FossilBlock(EXPOSED_SANDSTONE_FOSSIL, AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.STONE).harvestTool(ModToolTypes.BRUSH).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	
	public static final Block PLASTERED_FOSSIL = PlasteredFossilBlock.create();

	//Machines
	public static final Block FOSSIL_CLEANER = FossilCleanerBlock.create();
	public static final Block FOSSIL_GRINDER = FossilGrinderBlock.create();
	public static final Block DNA_EXTRACTOR = DNAExtractorBlock.create();
	public static final Block ANALYSER = AnalyserBlock.create();
	public static final Block DNA_INJECTOR = DNAInjectorBlock.create();
	
	public static final Block ARCHAEOLOGY_TABLE = ArchaeologyTable.create();
	
	public static final Block TIME_MACHINE_BLOCK = TimeMachineBlock.create();
	
	public static final Block POWER_SUPPLY_BLOCK = PowerSupplyBlock.create();

	//Araucaria
	public static final Block ARAUCARIA_LOG = ForgeBlockAndItem.create("araucaria_log", new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_GRAY).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block STRIPPED_ARAUCARIA_LOG = ForgeBlockAndItem.create("stripped_araucaria_log", new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block ARAUCARIA_WOOD = ForgeBlockAndItem.create("araucaria_wood", new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block STRIPPED_ARAUCARIA_WOOD = ForgeBlockAndItem.create("stripped_araucaria_wood", new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block ARAUCARIA_LEAVES = ForgeBlockAndItem.create("araucaria_leaves", new LeavesBlock(AbstractBlock.Properties.of(Material.LEAVES, MaterialColor.COLOR_GREEN).strength(0.3F).noOcclusion().sound(SoundType.GRASS)));
	public static final Block ARAUCARIA_SAPLING = ForgeBlockAndItem.create("araucaria_sapling", new ModSaplingBlock(null, AbstractBlock.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final Block ARAUCARIA_PLANKS = ForgeBlockAndItem.create("araucaria_planks", new Block(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block ARAUCARIA_STAIRS = ForgeBlockAndItem.create("araucaria_stairs", new StairsBlock(() -> BlockInit.ARAUCARIA_PLANKS.defaultBlockState(), AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block ARAUCARIA_SLAB = ForgeBlockAndItem.create("araucaria_slab", new SlabBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block ARAUCARIA_FENCE = ForgeBlockAndItem.create("araucaria_fence", new FenceBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block ARAUCARIA_FENCE_GATE = ForgeBlockAndItem.create("araucaria_fence_gate", new FenceGateBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block ARAUCARIA_PRESSURE_PLATE = ForgeBlockAndItem.create("araucaria_pressure_plate", new PressurePlateBlock(Sensitivity.EVERYTHING, AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noCollission().sound(SoundType.WOOD)));
	public static final Block ARAUCARIA_BUTTON = ForgeBlockAndItem.create("araucaria_button", new WoodButtonBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noCollission().sound(SoundType.WOOD)));
	public static final Block ARAUCARIA_TRAPDOOR = ForgeBlockAndItem.create("araucaria_trapdoor", new TrapDoorBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noOcclusion().sound(SoundType.WOOD)));
	public static final Block ARAUCARIA_DOOR = ForgeBlockAndItem.create("araucaria_door", new DoorBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noOcclusion().sound(SoundType.WOOD)));
	public static final Block ARAUCARIA_SIGN = ForgeStandingSignBlock.create("araucaria", new ModStandingSignBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD).noCollission(), ModWoodTypes.ARAUCARIA));
	public static final Block ARAUCARIA_WALL_SIGN = ForgeWallSignBlock.create("araucaria", new ModWallSignBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD).noCollission().dropsLike(BlockInit.ARAUCARIA_SIGN), ModWoodTypes.ARAUCARIA));
	public static final Item ARAUCARIA_SIGN_ITEM = ForgeSignItem.create("araucaria_sign", ARAUCARIA_SIGN, ARAUCARIA_WALL_SIGN);
	
	//Conifer
	public static final Block CONIFER_LOG = ForgeBlockAndItem.create("conifer_log", new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block STRIPPED_CONIFER_LOG = ForgeBlockAndItem.create("stripped_conifer_log", new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.0F).sound(SoundType.WOOD)));
	public static final Block CONIFER_WOOD = ForgeBlockAndItem.create("conifer_wood", new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.0F).sound(SoundType.WOOD)));
	public static final Block STRIPPED_CONIFER_WOOD = ForgeBlockAndItem.create("stripped_conifer_wood", new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.0F).sound(SoundType.WOOD)));
	public static final Block CONIFER_LEAVES = ForgeBlockAndItem.create("conifer_leaves", new LeavesBlock(AbstractBlock.Properties.of(Material.LEAVES, MaterialColor.COLOR_GREEN).strength(0.3F).noOcclusion().sound(SoundType.GRASS)));
	public static final Block CONIFER_SAPLING = ForgeBlockAndItem.create("conifer_sapling", new ModSaplingBlock(new ConiferTree(), AbstractBlock.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final Block CONIFER_PLANKS = ForgeBlockAndItem.create("conifer_planks", new Block(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block CONIFER_STAIRS = ForgeBlockAndItem.create("conifer_stairs", new StairsBlock(() -> BlockInit.CONIFER_PLANKS.defaultBlockState(), AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block CONIFER_SLAB = ForgeBlockAndItem.create("conifer_slab", new SlabBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block CONIFER_FENCE = ForgeBlockAndItem.create("conifer_fence", new FenceBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block CONIFER_FENCE_GATE = ForgeBlockAndItem.create("conifer_fence_gate", new FenceGateBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block CONIFER_PRESSURE_PLATE = ForgeBlockAndItem.create("conifer_pressure_plate", new PressurePlateBlock(Sensitivity.EVERYTHING, AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noCollission().sound(SoundType.WOOD)));
	public static final Block CONIFER_BUTTON = ForgeBlockAndItem.create("conifer_button", new WoodButtonBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noCollission().sound(SoundType.WOOD)));
	public static final Block CONIFER_TRAPDOOR = ForgeBlockAndItem.create("conifer_trapdoor", new TrapDoorBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noOcclusion().sound(SoundType.WOOD)));
	public static final Block CONIFER_DOOR = ForgeBlockAndItem.create("conifer_door", new DoorBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noOcclusion().sound(SoundType.WOOD)));
	public static final Block CONIFER_SIGN = ForgeStandingSignBlock.create("conifer", new ModStandingSignBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD).noCollission(), ModWoodTypes.CONIFER));
	public static final Block CONIFER_WALL_SIGN = ForgeWallSignBlock.create("conifer", new ModWallSignBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD).noCollission().dropsLike(BlockInit.CONIFER_SIGN), ModWoodTypes.CONIFER));
	public static final Item CONIFER_SIGN_ITEM = ForgeSignItem.create("conifer_sign", CONIFER_SIGN, CONIFER_WALL_SIGN);
	
	public static final Block CONIFER_STICKS = ForgeBlockAndItem.create("conifer_sticks", new SticksBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).instabreak().noCollission().noOcclusion().sound(SoundType.WOOD)));
	
	//Ginkgo
	public static final Block GINKGO_LOG = ForgeBlockAndItem.create("ginkgo_log", new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_GRAY).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block STRIPPED_GINKGO_LOG = ForgeBlockAndItem.create("stripped_ginkgo_log", new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block GINKGO_WOOD = ForgeBlockAndItem.create("ginkgo_wood", new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block STRIPPED_GINKGO_WOOD = ForgeBlockAndItem.create("stripped_ginkgo_wood", new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block GINKGO_LEAVES = ForgeBlockAndItem.create("ginkgo_leaves", new LeavesBlock(AbstractBlock.Properties.of(Material.LEAVES, MaterialColor.COLOR_GREEN).strength(0.3F).noOcclusion().sound(SoundType.GRASS)));
	public static final Block GINKGO_SAPLING = ForgeBlockAndItem.create("ginkgo_sapling", new ModSaplingBlock(null, AbstractBlock.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final Block GINKGO_PLANKS = ForgeBlockAndItem.create("ginkgo_planks", new Block(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block GINKGO_STAIRS = ForgeBlockAndItem.create("ginkgo_stairs", new StairsBlock(() -> BlockInit.CONIFER_PLANKS.defaultBlockState(), AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block GINKGO_SLAB = ForgeBlockAndItem.create("ginkgo_slab", new SlabBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block GINKGO_FENCE = ForgeBlockAndItem.create("ginkgo_fence", new FenceBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block GINKGO_FENCE_GATE = ForgeBlockAndItem.create("ginkgo_fence_gate", new FenceGateBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block GINKGO_PRESSURE_PLATE = ForgeBlockAndItem.create("ginkgo_pressure_plate", new PressurePlateBlock(Sensitivity.EVERYTHING, AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noCollission().sound(SoundType.WOOD)));
	public static final Block GINKGO_BUTTON = ForgeBlockAndItem.create("ginkgo_button", new WoodButtonBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noCollission().sound(SoundType.WOOD)));
	public static final Block GINKGO_TRAPDOOR = ForgeBlockAndItem.create("ginkgo_trapdoor", new TrapDoorBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noOcclusion().sound(SoundType.WOOD)));
	public static final Block GINKGO_DOOR = ForgeBlockAndItem.create("ginkgo_door", new DoorBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noOcclusion().sound(SoundType.WOOD)));
	public static final Block GINKGO_SIGN = ForgeStandingSignBlock.create("ginkgo", new ModStandingSignBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD).noCollission(), ModWoodTypes.GINKGO));
	public static final Block GINKGO_WALL_SIGN = ForgeWallSignBlock.create("ginkgo", new ModWallSignBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD).noCollission().dropsLike(BlockInit.GINKGO_SIGN), ModWoodTypes.GINKGO));
	public static final Item GINKGO_SIGN_ITEM = ForgeSignItem.create("ginkgo_sign", GINKGO_SIGN, GINKGO_WALL_SIGN);
	
	//Scorched
	public static final Block SCORCHED_LOG = ForgeBlockAndItem.create("scorched_log", new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block STRIPPED_SCORCHED_LOG = ForgeBlockAndItem.create("stripped_scorched_log", new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block SCORCHED_WOOD = ForgeBlockAndItem.create("scorched_wood", new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block STRIPPED_SCORCHED_WOOD = ForgeBlockAndItem.create("stripped_scorched_wood", new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));

	
	public static final Block SCORCHED_PLANKS = ForgeBlockAndItem.create("scorched_planks", new Block(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD))); 
	public static final Block SCORCHED_STAIRS = ForgeBlockAndItem.create("scorched_stairs", new StairsBlock(() -> BlockInit.SCORCHED_PLANKS.defaultBlockState(), AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block SCORCHED_SLAB = ForgeBlockAndItem.create("scorched_slab", new SlabBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block SCORCHED_FENCE = ForgeBlockAndItem.create("scorched_fence", new FenceBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block SCORCHED_FENCE_GATE = ForgeBlockAndItem.create("scorched_fence_gate", new FenceGateBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final Block SCORCHED_PRESSURE_PLATE = ForgeBlockAndItem.create("scorched_pressure_plate", new PressurePlateBlock(Sensitivity.EVERYTHING, AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noCollission().sound(SoundType.WOOD)));
	public static final Block SCORCHED_BUTTON = ForgeBlockAndItem.create("scorched_button", new WoodButtonBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noCollission().sound(SoundType.WOOD)));
	
	
	public static final Block SCORCHED_SIGN = ForgeStandingSignBlock.create("scorched", new ModStandingSignBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD).noCollission(), ModWoodTypes.SCORCHED));
	public static final Block SCORCHED_WALL_SIGN = ForgeWallSignBlock.create("scorched", new ModWallSignBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD).noCollission().dropsLike(BlockInit.SCORCHED_SIGN), ModWoodTypes.SCORCHED));
	public static final Item SCORCHED_SIGN_ITEM = ForgeSignItem.create("scorched_sign", SCORCHED_SIGN, SCORCHED_WALL_SIGN);
	
	public static final Block SCORCHED_STICKS = ForgeBlockAndItem.create("scorched_sticks", new SticksBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).instabreak().noCollission().noOcclusion().sound(SoundType.WOOD)));

	//Permain Blocks	
	public static final Block PERMIAN_SAND = ForgeBlockAndItem.create("permian_sand", new SandBlock(0xaa915c, AbstractBlock.Properties.of(Material.SAND, MaterialColor.SAND).harvestTool(ToolType.SHOVEL).strength(1.5F).sound(SoundType.SAND)));
		
	public static final Block PERMIAN_STONE = ForgeBlockAndItem.create("permian_stone", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final Block PERMIAN_STONE_STAIRS = ForgeBlockAndItem.create("permian_stone_stairs", new StairsBlock(() -> BlockInit.PERMIAN_STONE.defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final Block PERMIAN_STONE_SLAB = ForgeBlockAndItem.create("permian_stone_slab", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));

	public static final Block PERMIAN_COBBLESTONE = ForgeBlockAndItem.create("permian_cobblestone", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final Block PERMIAN_COBBLESTONE_STAIRS = ForgeBlockAndItem.create("permian_cobblestone_stairs", new StairsBlock(() -> BlockInit.PERMIAN_STONE.defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final Block PERMIAN_COBBLESTONE_SLAB = ForgeBlockAndItem.create("permian_cobblestone_slab", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final Block PERMIAN_COBBLESTONE_WALL = ForgeBlockAndItem.create("permian_cobblestone_wall", new WallBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	
	public static final Block PERMIAN_STONE_BRICKS = ForgeBlockAndItem.create("permian_stone_bricks", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final Block PERMIAN_STONE_BRICK_STAIRS = ForgeBlockAndItem.create("permian_stone_brick_stairs", new StairsBlock(() -> BlockInit.PERMIAN_STONE_BRICKS.defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final Block PERMIAN_STONE_BRICK_SLAB = ForgeBlockAndItem.create("permian_stone_brick_slab", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final Block PERMIAN_STONE_BRICK_WALL = ForgeBlockAndItem.create("permian_stone_brick_wall", new WallBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));

	public static final Block PERMIAN_COPPER_ORE = ForgeBlockAndItem.create("permian_copper_ore", new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
	public static final Block PERMIAN_GOLD_ORE = ForgeBlockAndItem.create("permian_gold_ore", new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
	public static final Block PERMIAN_IRON_ORE = ForgeBlockAndItem.create("permian_iron_ore", new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
	public static final Block PERMIAN_COAL_ORE = ForgeBlockAndItem.create("permian_coal_ore", new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
	public static final Block PERMIAN_LAPIS_ORE = ForgeBlockAndItem.create("permian_lapis_ore", new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));	
	public static final Block PERMIAN_DIAMOND_ORE = ForgeBlockAndItem.create("permian_diamond_ore", new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));	
	public static final Block PERMIAN_REDSTONE_ORE = ForgeBlockAndItem.create("permian_redstone_ore", new RedstoneOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));	
	public static final Block PERMIAN_EMERALD_ORE = ForgeBlockAndItem.create("permian_emerald_ore", new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));	
	
	//Jurassic Blocks
	public static final Block JURASSIC_STONE = ForgeBlockAndItem.create("jurassic_stone", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	public static final Block JURASSIC_STONE_STAIRS = ForgeBlockAndItem.create("jurassic_stone_stairs", new StairsBlock(() -> BlockInit.JURASSIC_STONE.defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	public static final Block JURASSIC_STONE_SLAB = ForgeBlockAndItem.create("jurassic_stone_slab", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));

	public static final Block MOSSY_JURASSIC_STONE = ForgeBlockAndItem.create("mossy_jurassic_stone", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().randomTicks().strength(3.0F)));
	public static final Block MOSSY_JURASSIC_STONE_STAIRS = ForgeBlockAndItem.create("mossy_jurassic_stone_stairs", new StairsBlock(() -> BlockInit.MOSSY_JURASSIC_STONE.defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	public static final Block MOSSY_JURASSIC_STONE_SLAB = ForgeBlockAndItem.create("mossy_jurassic_stone_slab", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));

	public static final Block JURASSIC_COBBLESTONE = ForgeBlockAndItem.create("jurassic_cobblestone", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	public static final Block JURASSIC_COBBLESTONE_STAIRS = ForgeBlockAndItem.create("jurassic_cobblestone_stairs", new StairsBlock(() -> BlockInit.JURASSIC_COBBLESTONE.defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	public static final Block JURASSIC_COBBLESTONE_SLAB = ForgeBlockAndItem.create("jurassic_cobblestone_slab", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	public static final Block JURASSIC_COBBLESTONE_WALL = ForgeBlockAndItem.create("jurassic_cobblestone_wall", new WallBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	
	public static final Block MOSSY_JURASSIC_COBBLESTONE = ForgeBlockAndItem.create("mossy_jurassic_cobblestone", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	public static final Block MOSSY_JURASSIC_COBBLESTONE_STAIRS = ForgeBlockAndItem.create("mossy_jurassic_cobblestone_stairs", new StairsBlock(() -> BlockInit.MOSSY_JURASSIC_COBBLESTONE.defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	public static final Block MOSSY_JURASSIC_COBBLESTONE_SLAB = ForgeBlockAndItem.create("mossy_jurassic_cobblestone_slab", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	public static final Block MOSSY_JURASSIC_COBBLESTONE_WALL = ForgeBlockAndItem.create("mossy_jurassic_cobblestone_wall", new WallBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	
	public static final Block JURASSIC_STONE_BRICKS = ForgeBlockAndItem.create("jurassic_stone_bricks", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final Block JURASSIC_STONE_BRICK_STAIRS = ForgeBlockAndItem.create("jurassic_stone_brick_stairs", new StairsBlock(() -> BlockInit.JURASSIC_STONE_BRICKS.defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final Block JURASSIC_STONE_BRICK_SLAB = ForgeBlockAndItem.create("jurassic_stone_brick_slab", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final Block JURASSIC_STONE_BRICK_WALL = ForgeBlockAndItem.create("jurassic_stone_brick_wall", new WallBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	
	public static final Block MOSSY_JURASSIC_STONE_BRICKS = ForgeBlockAndItem.create("mossy_jurassic_stone_bricks", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final Block MOSSY_JURASSIC_STONE_BRICK_STAIRS = ForgeBlockAndItem.create("mossy_jurassic_stone_brick_stairs", new StairsBlock(() -> BlockInit.MOSSY_JURASSIC_STONE_BRICKS.defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final Block MOSSY_JURASSIC_STONE_BRICK_SLAB = ForgeBlockAndItem.create("mossy_jurassic_stone_brick_slab", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final Block MOSSY_JURASSIC_STONE_BRICK_WALL = ForgeBlockAndItem.create("mossy_jurassic_stone_brick_wall", new WallBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	
	public static final Block JURASSIC_COPPER_ORE = ForgeBlockAndItem.create("jurassic_copper_ore", new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
	public static final Block JURASSIC_GOLD_ORE = ForgeBlockAndItem.create("jurassic_gold_ore", new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
	public static final Block JURASSIC_IRON_ORE = ForgeBlockAndItem.create("jurassic_iron_ore", new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
	public static final Block JURASSIC_COAL_ORE = ForgeBlockAndItem.create("jurassic_coal_ore", new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
	public static final Block JURASSIC_LAPIS_ORE = ForgeBlockAndItem.create("jurassic_lapis_ore", new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));	
	public static final Block JURASSIC_DIAMOND_ORE = ForgeBlockAndItem.create("jurassic_diamond_ore", new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));	
	public static final Block JURASSIC_REDSTONE_ORE = ForgeBlockAndItem.create("jurassic_redstone_ore", new RedstoneOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));	
	public static final Block JURASSIC_EMERALD_ORE = ForgeBlockAndItem.create("jurassic_emerald_ore", new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));	
	
	//Building Blocks
	public static final Block VOLCANIC_ROCK = ForgeBlockAndItem.create("volcanic_rock", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.GILDED_BLACKSTONE)));
	public static final Block VOLCANIC_ROCK_STAIRS = ForgeBlockAndItem.create("volcanic_rock_stairs", new StairsBlock(VOLCANIC_ROCK.defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.GILDED_BLACKSTONE)));
	public static final Block VOLCANIC_ROCK_SLAB = ForgeBlockAndItem.create("volcanic_rock_slab", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.GILDED_BLACKSTONE)));
	public static final Block VOLCANIC_ROCK_WALL = ForgeBlockAndItem.create("volcanic_rock_wall", new WallBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.GILDED_BLACKSTONE)));
	
	public static final Block POLISHED_VOLCANIC_ROCK = ForgeBlockAndItem.create("polished_volcanic_rock", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.GILDED_BLACKSTONE)));
	public static final Block POLISHED_VOLCANIC_ROCK_STAIRS = ForgeBlockAndItem.create("polished_volcanic_rock_stairs", new StairsBlock(POLISHED_VOLCANIC_ROCK.defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.GILDED_BLACKSTONE)));
	public static final Block POLISHED_VOLCANIC_ROCK_SLAB = ForgeBlockAndItem.create("polished_volcanic_rock_slab", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.GILDED_BLACKSTONE)));

	public static final Block SHADED_GLASS = ForgeBlockAndItem.create("shaded_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final Block SHADED_GLASS_PANE = ForgeBlockAndItem.create("shaded_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	
	//Jurassic Park Building Blocks
	public static final Block LIGHT_CONCRETE = ForgeBlockAndItem.create("light_concrete", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(6.0F, 8.0F).sound(SoundType.STONE)));
	public static final Block LIGHT_CONCRETE_STAIRS = ForgeBlockAndItem.create("light_concrete_stairs", new StairsBlock(() -> BlockInit.LIGHT_CONCRETE.defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(6.0F, 8.0F).sound(SoundType.STONE)));
	public static final Block LIGHT_CONCRETE_SLAB = ForgeBlockAndItem.create("light_concrete_slab", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(6.0F, 8.0F).sound(SoundType.STONE)));
	public static final Block LIGHT_CONCRETE_WALL = ForgeBlockAndItem.create("light_concrete_wall", new WallBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(6.0F, 8.0F).noCollission().sound(SoundType.STONE)));
	public static final Block LIGHT_CONCRETE_PRESSURE_PLATE = ForgeBlockAndItem.create("light_concrete_pressure_plate", new PressurePlateBlock(Sensitivity.MOBS, AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(6.0F, 8.0F).noCollission().sound(SoundType.STONE)));
	public static final Block LIGHT_CONCRETE_BUTTON = ForgeBlockAndItem.create("light_concrete_button", new StoneButtonBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(6.0F, 8.0F).noCollission().sound(SoundType.STONE)));

	public static final Block POLISHED_LIGHT_CONCRETE = ForgeBlockAndItem.create("polished_light_concrete", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(6.5F, 8.5F).sound(SoundType.STONE)));
	public static final Block POLISHED_LIGHT_CONCRETE_STAIRS = ForgeBlockAndItem.create("polished_light_concrete_stairs", new StairsBlock(() -> BlockInit.LIGHT_CONCRETE.defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(6.5F, 8.5F).sound(SoundType.STONE)));
	public static final Block POLISHED_LIGHT_CONCRETE_SLAB = ForgeBlockAndItem.create("polished_light_concrete_slab", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(6.5F, 8.5F).sound(SoundType.STONE)));

	public static final Block WOODEN_PLANKS = ForgeBlockAndItem.create("wooden_planks", new Block(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(1.2F, 0.5F).sound(SoundType.WOOD)));
	public static final Block WOODEN_PLANKS_STAIRS = ForgeBlockAndItem.create("wooden_planks_stairs", new StairsBlock(() -> BlockInit.WOODEN_PLANKS.defaultBlockState(), AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(1.2F, 0.5F).sound(SoundType.WOOD)));
	public static final Block WOODEN_PLANKS_SLAB = ForgeBlockAndItem.create("wooden_planks_slab", new SlabBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(1.2F, 0.5F).sound(SoundType.WOOD)));
	public static final Block WOODEN_PLANKS_FENCE = ForgeBlockAndItem.create("wooden_planks_fence", new FenceBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(1.2F, 0.5F).sound(SoundType.WOOD)));
	public static final Block WOODEN_PLANKS_FENCE_GATE = ForgeBlockAndItem.create("wooden_planks_fence_gate", new FenceGateBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(1.2F, 0.5F).sound(SoundType.WOOD)));
	public static final Block WOODEN_PLANKS_PRESSURE_PLATE = ForgeBlockAndItem.create("wooden_planks_pressure_plate", new PressurePlateBlock(Sensitivity.EVERYTHING, AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(1.2F, 0.5F).noCollission().sound(SoundType.WOOD)));
	public static final Block WOODEN_PLANKS_BUTTON = ForgeBlockAndItem.create("wooden_planks_button", new WoodButtonBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(1.2F, 0.5F).noCollission().sound(SoundType.WOOD)));

	public static final Block METAL_FENCE = ForgeBlockAndItem.create("metal_fence", new FenceBlock(AbstractBlock.Properties.of(Material.METAL, MaterialColor.COLOR_RED).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(4.5F, 6.0F).sound(SoundType.METAL)));

	public static final Block TINTED_GLASS = ForgeBlockAndItem.create("tinted_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final Block TINTED_GLASS_PANE = ForgeBlockAndItem.create("tinted_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	
	public static final Block THATCH_BLOCK = ForgeBlockAndItem.create("thatch_block", new HayBlock(AbstractBlock.Properties.copy(Blocks.HAY_BLOCK)));

	public static final Block OUTDOOR_TOILET_DOOR = ForgeBlockAndItem.create("outdoor_toilet_door", new DoorBlock(AbstractBlock.Properties.copy(Blocks.OAK_DOOR)));
	public static final Block VISITOR_CENTRE_DOOR = ForgeBlockAndItem.create("visitor_centre_door", new DoorBlock(AbstractBlock.Properties.copy(Blocks.OAK_DOOR)));	
	public static final Block SECURITY_DOOR = ForgeBlockAndItem.create("security_door", new DoorBlock(AbstractBlock.Properties.copy(Blocks.IRON_DOOR)));
	
	//Jurassic World Building Blocks
	public static final Block DARK_CONCRETE = ForgeBlockAndItem.create("dark_concrete", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(8.0F, 10.0F).sound(SoundType.STONE)));
	public static final Block DARK_CONCRETE_STAIRS = ForgeBlockAndItem.create("dark_concrete_stairs", new StairsBlock(() -> BlockInit.DARK_CONCRETE.defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(8.0F, 10.0F).sound(SoundType.STONE)));
	public static final Block DARK_CONCRETE_SLAB = ForgeBlockAndItem.create("dark_concrete_slab", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(8.0F, 10.0F).sound(SoundType.STONE)));
	public static final Block DARK_CONCRETE_WALL = ForgeBlockAndItem.create("dark_concrete_wall", new WallBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(8.0F, 10.0F).sound(SoundType.STONE)));
	public static final Block DARK_CONCRETE_PRESSURE_PLATE = ForgeBlockAndItem.create("dark_concrete_pressure_plate", new PressurePlateBlock(Sensitivity.MOBS, AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(8.0F, 10.0F).noCollission().sound(SoundType.STONE)));
	public static final Block DARK_CONCRETE_BUTTON = ForgeBlockAndItem.create("dark_concrete_button", new StoneButtonBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(8.0F, 10.0F).noCollission().sound(SoundType.STONE)));
	
	public static final Block POLISHED_DARK_CONCRETE = ForgeBlockAndItem.create("polished_dark_concrete", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(8.5F, 10.5F).sound(SoundType.STONE)));
	public static final Block POLISHED_DARK_CONCRETE_STAIRS = ForgeBlockAndItem.create("polished_dark_concrete_stairs", new StairsBlock(() -> BlockInit.DARK_CONCRETE.defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(8.5F, 10.5F).sound(SoundType.STONE)));
	public static final Block POLISHED_DARK_CONCRETE_SLAB = ForgeBlockAndItem.create("polished_dark_concrete_slab", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(8.5F, 10.5F).sound(SoundType.STONE)));

	public static final Block REFINED_WOODEN_PLANKS = ForgeBlockAndItem.create("refined_wooden_planks", new Block(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(2.7F, 1.9F).sound(SoundType.WOOD)));
	public static final Block REFINED_WOODEN_PLANKS_STAIRS = ForgeBlockAndItem.create("refined_wooden_planks_stairs", new StairsBlock(() -> BlockInit.REFINED_WOODEN_PLANKS.defaultBlockState(), AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(2.7F, 1.9F).sound(SoundType.WOOD)));
	public static final Block REFINED_WOODEN_PLANKS_SLAB = ForgeBlockAndItem.create("refined_wooden_planks_slab", new SlabBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(2.7F, 1.9F).sound(SoundType.WOOD)));
	public static final Block REFINED_WOODEN_PLANKS_FENCE = ForgeBlockAndItem.create("refined_wooden_planks_fence", new FenceBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(2.7F, 1.9F).sound(SoundType.WOOD)));
	public static final Block REFINED_WOODEN_PLANKS_FENCE_GATE = ForgeBlockAndItem.create("refined_wooden_planks_fence_gate", new FenceGateBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(2.7F, 1.9F).sound(SoundType.WOOD)));
	public static final Block REFINED_WOODEN_PLANKS_PRESSURE_PLATE = ForgeBlockAndItem.create("refined_wooden_planks_pressure_plate", new PressurePlateBlock(Sensitivity.EVERYTHING, AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(2.7F, 1.9F).noCollission().sound(SoundType.WOOD)));
	public static final Block REFINED_WOODEN_PLANKS_BUTTON = ForgeBlockAndItem.create("refined_wooden_planks_button", new WoodButtonBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(2.7F, 1.9F).noCollission().sound(SoundType.WOOD)));

	public static final Block TILE = ForgeBlockAndItem.create("tile", new Block(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(2.7F, 1.9F).sound(SoundType.WOOD)));
	public static final Block TILE_STAIRS = ForgeBlockAndItem.create("tile_stairs", new StairsBlock(() -> BlockInit.TILE.defaultBlockState(), AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(2.7F, 1.9F).sound(SoundType.WOOD)));
	public static final Block TILE_SLAB = ForgeBlockAndItem.create("tile_slab", new SlabBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(2.7F, 1.9F).sound(SoundType.WOOD)));
	
	public static final Block CLEAR_GLASS = ForgeBlockAndItem.create("clear_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_WHITE).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final Block CLEAR_GLASS_PANE = ForgeBlockAndItem.create("clear_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_WHITE).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	

	public static final Block WHITE_GLASS = ForgeBlockAndItem.create("white_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final Block WHITE_GLASS_PANE = ForgeBlockAndItem.create("white_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final Block LIGHT_GREY_GLASS = ForgeBlockAndItem.create("light_grey_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final Block LIGHT_GREY_GLASS_PANE = ForgeBlockAndItem.create("light_grey_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final Block GREY_GLASS = ForgeBlockAndItem.create("grey_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final Block GREY_GLASS_PANE = ForgeBlockAndItem.create("grey_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final Block BLACK_GLASS = ForgeBlockAndItem.create("black_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final Block BLACK_GLASS_PANE = ForgeBlockAndItem.create("black_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final Block RED_GLASS = ForgeBlockAndItem.create("red_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final Block RED_GLASS_PANE = ForgeBlockAndItem.create("red_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final Block ORANGE_GLASS = ForgeBlockAndItem.create("orange_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final Block ORANGE_GLASS_PANE = ForgeBlockAndItem.create("orange_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final Block YELLOW_GLASS = ForgeBlockAndItem.create("yellow_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final Block YELLOW_GLASS_PANE = ForgeBlockAndItem.create("yellow_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final Block LIME_GLASS = ForgeBlockAndItem.create("lime_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final Block LIME_GLASS_PANE = ForgeBlockAndItem.create("lime_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final Block GREEN_GLASS = ForgeBlockAndItem.create("green_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final Block GREEN_GLASS_PANE = ForgeBlockAndItem.create("green_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final Block CYAN_GLASS = ForgeBlockAndItem.create("cyan_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final Block CYAN_GLASS_PANE = ForgeBlockAndItem.create("cyan_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final Block LIGHT_BLUE_GLASS = ForgeBlockAndItem.create("light_blue_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(3.0F).noOcclusion().sound(SoundType.GLASS)));
	public static final Block LIGHT_BLUE_GLASS_PANE = ForgeBlockAndItem.create("light_blue_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final Block BLUE_GLASS = ForgeBlockAndItem.create("blue_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final Block BLUE_GLASS_PANE = ForgeBlockAndItem.create("blue_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final Block PURPLE_GLASS = ForgeBlockAndItem.create("purple_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final Block PURPLE_GLASS_PANE = ForgeBlockAndItem.create("purple_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final Block MAGENTA_GLASS = ForgeBlockAndItem.create("magenta_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final Block MAGENTA_GLASS_PANE = ForgeBlockAndItem.create("magenta_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final Block PINK_GLASS = ForgeBlockAndItem.create("pink_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final Block PINK_GLASS_PANE = ForgeBlockAndItem.create("pink_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final Block BROWN_GLASS = ForgeBlockAndItem.create("brown_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final Block BROWN_GLASS_PANE = ForgeBlockAndItem.create("brown_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final Block RED_DECORATION_BLOCK = ColouredDecorationBlock.create(DyeColor.RED);
	public static final Block ORANGE_DECORATION_BLOCK = ColouredDecorationBlock.create(DyeColor.ORANGE);
	public static final Block YELLOW_DECORATION_BLOCK = ColouredDecorationBlock.create(DyeColor.YELLOW);
	public static final Block LIME_DECORATION_BLOCK = ColouredDecorationBlock.create(DyeColor.LIME);
	public static final Block GREEN_DECORATION_BLOCK = ColouredDecorationBlock.create(DyeColor.GREEN);
	public static final Block CYAN_DECORATION_BLOCK = ColouredDecorationBlock.create(DyeColor.CYAN);
	public static final Block BLUE_DECORATION_BLOCK = ColouredDecorationBlock.create(DyeColor.BLUE);
	public static final Block LIGHT_BLUE_DECORATION_BLOCK = ColouredDecorationBlock.create(DyeColor.LIGHT_BLUE);
	public static final Block PURPLE_DECORATION_BLOCK = ColouredDecorationBlock.create(DyeColor.PURPLE);
	public static final Block MAGENTA_DECORATION_BLOCK = ColouredDecorationBlock.create(DyeColor.MAGENTA);
	public static final Block PINK_DECORATION_BLOCK = ColouredDecorationBlock.create(DyeColor.PINK);
	public static final Block BROWN_DECORATION_BLOCK = ColouredDecorationBlock.create(DyeColor.BROWN);
	public static final Block GREY_DECORATION_BLOCK = ColouredDecorationBlock.create(DyeColor.GRAY);
	public static final Block LIGHT_GREY_DECORATION_BLOCK = ColouredDecorationBlock.create(DyeColor.LIGHT_GRAY);
	public static final Block WHITE_DECORATION_BLOCK = ColouredDecorationBlock.create(DyeColor.WHITE);
	public static final Block BLACK_DECORATION_BLOCK = ColouredDecorationBlock.create(DyeColor.BLACK);

	public static final Block GLASS_SHOP_DOOR = ForgeBlockAndItem.create("glass_shop_door", new DoorBlock(AbstractBlock.Properties.copy(Blocks.OAK_DOOR)));	
	public static final Block INNOVATION_CENTRE_DOOR = ForgeBlockAndItem.create("innovation_centre_door", new DoorBlock(AbstractBlock.Properties.copy(Blocks.OAK_DOOR)));
	public static final Block BACK_DOOR = ForgeBlockAndItem.create("back_door", new DoorBlock(AbstractBlock.Properties.copy(Blocks.IRON_DOOR)));

	//Mixed Park
	public static final Block PAVEMENT = ForgeBlockAndItem.create("pavement", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GRAY).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(3.0F).sound(SoundType.STONE)));
	public static final Block PAVEMENT_SLOPE = ForgeBlockAndItem.create("pavement_slope", new StairsBlock(() -> BlockInit.PAVEMENT.defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GRAY).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(3.0F).sound(SoundType.STONE)));
	public static final Block RAISED_PAVEMENT = ForgeBlockAndItem.create("raised_pavement", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GRAY).harvestTool(ToolType.PICKAXE).harvestLevel(1).strength(3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
	
	public static final Block GRAVEL_ROAD = ForgeBlockAndItem.create("gravel_road", new Block(AbstractBlock.Properties.of(Material.SAND, MaterialColor.TERRACOTTA_LIGHT_GRAY).harvestTool(ToolType.SHOVEL).harvestLevel(0).strength(1.5F).sound(SoundType.SAND)));
	public static final Block RAISED_GRAVEL_ROAD = ForgeBlockAndItem.create("raised_gravel_road", new SlabBlock(AbstractBlock.Properties.of(Material.SAND, MaterialColor.TERRACOTTA_LIGHT_GRAY).harvestTool(ToolType.SHOVEL).harvestLevel(0).strength(1.5F).sound(SoundType.SAND)));
	
	public static final Block DIRT_ROAD = ForgeBlockAndItem.create("dirt_road", new Block(AbstractBlock.Properties.of(Material.DIRT, MaterialColor.DIRT).harvestTool(ToolType.SHOVEL).harvestLevel(0).strength(1.5F).sound(SoundType.GRASS)));
	public static final Block RAISED_DIRT_ROAD = ForgeBlockAndItem.create("raised_dirt_road", new SlabBlock(AbstractBlock.Properties.of(Material.DIRT, MaterialColor.DIRT).harvestTool(ToolType.SHOVEL).harvestLevel(0).strength(1.5F).sound(SoundType.GRASS)));
	
	public static final Block PAVED_ROAD = ForgeBlockAndItem.create("paved_road", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.STONE)));
	public static final Block RAISED_PAVED_ROAD = ForgeBlockAndItem.create("raised_paved_road", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.STONE)));
	
	//Registry
	public static void init() { ModUtil.LOGGER.debug("Registering Mod Blocks"); }
}
