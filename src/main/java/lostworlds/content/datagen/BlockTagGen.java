package lostworlds.content.datagen;

import lostworlds.content.server.ModTags.ModBlockTags;
import lostworlds.content.server.init.BlockInit;
import lostworlds.library.util.ModUtil;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockTagGen extends BlockTagsProvider
{
	public BlockTagGen(DataGenerator generator, ExistingFileHelper existingFileHelper) 
	{
		super(generator, ModUtil.ID, existingFileHelper);
	}
	
	@Override
	protected void addTags() 
	{
		//Minecraft
		this.tag(BlockTags.CORALS).add(BlockInit.SPONGE_COLONY);
		this.tag(BlockTags.DRAGON_IMMUNE).add(BlockInit.TIME_MACHINE);
		this.tag(BlockTags.FENCE_GATES).add(BlockInit.ARAUCARIA_FENCE_GATE).add(BlockInit.CONIFER_FENCE_GATE).add(BlockInit.GINKGO_FENCE_GATE).add(BlockInit.REFINED_WOODEN_PLANKS_FENCE_GATE).add(BlockInit.SCORCHED_FENCE_GATE).add(BlockInit.WOODEN_PLANKS_FENCE_GATE);
		this.tag(BlockTags.FLOWER_POTS).add(BlockInit.POTTED_DILLHOFFIA);
		this.tag(BlockTags.GOLD_ORES).add(BlockInit.JURASSIC_GOLD_ORE).add(BlockInit.PERMIAN_GOLD_ORE);
		this.tag(BlockTags.GUARDED_BY_PIGLINS).add(BlockInit.JURASSIC_GOLD_ORE).add(BlockInit.PERMIAN_GOLD_ORE);
		this.tag(BlockTags.LEAVES).add(BlockInit.ARAUCARIA_LEAVES).add(BlockInit.CONIFER_LEAVES).add(BlockInit.GINKGO_LEAVES);
		this.tag(BlockTags.LOGS_THAT_BURN).addTag(ModBlockTags.ARAUCARIA_LOGS).addTag(ModBlockTags.CONIFER_LOGS).addTag(ModBlockTags.GINKGO_LOGS).addTag(ModBlockTags.SCORCHED_LOGS);
		this.tag(BlockTags.LOGS).addTag(ModBlockTags.ARAUCARIA_LOGS).addTag(ModBlockTags.CONIFER_LOGS).addTag(ModBlockTags.GINKGO_LOGS).addTag(ModBlockTags.SCORCHED_LOGS);
		this.tag(BlockTags.PLANKS).add(BlockInit.ARAUCARIA_PLANKS).add(BlockInit.CONIFER_PLANKS).add(BlockInit.GINKGO_PLANKS).add(BlockInit.REFINED_WOODEN_PLANKS).add(BlockInit.SCORCHED_PLANKS).add(BlockInit.WOODEN_PLANKS);
		this.tag(BlockTags.SAND).add(BlockInit.PERMIAN_SAND);
		this.tag(BlockTags.SAPLINGS).add(BlockInit.ARAUCARIA_SAPLING).add(BlockInit.CONIFER_SAPLING).add(BlockInit.GINKGO_SAPLING);
		this.tag(BlockTags.SMALL_FLOWERS).add(BlockInit.DILLHOFFIA);
		this.tag(BlockTags.STONE_BRICKS).add(BlockInit.JURASSIC_STONE_BRICKS).add(BlockInit.MOSSY_JURASSIC_STONE_BRICKS).add(BlockInit.PERMIAN_STONE_BRICKS);
		//this.tag(BlockTags.STONE_PRESSURE_PLATES).add(BlockInit.JURASSIC_STONE_PRESSURE_PLATE).add(BlockInit.PERMIAN_STONE_PRESSURE_PLATE);
		this.tag(BlockTags.WALLS).add(BlockInit.DARK_CONCRETE_WALL).add(BlockInit.JURASSIC_COBBLESTONE_WALL).add(BlockInit.JURASSIC_STONE_BRICK_WALL).add(BlockInit.LIGHT_CONCRETE_WALL).add(BlockInit.MOSSY_JURASSIC_COBBLESTONE_WALL).add(BlockInit.MOSSY_JURASSIC_STONE_BRICK_WALL).add(BlockInit.PERMIAN_COBBLESTONE_WALL).add(BlockInit.PERMIAN_STONE_BRICK_WALL).add(BlockInit.VOLCANIC_ROCK_WALL);
		this.tag(BlockTags.WITHER_IMMUNE).add(BlockInit.TIME_MACHINE);
		this.tag(BlockTags.WOODEN_BUTTONS).add(BlockInit.ARAUCARIA_BUTTON).add(BlockInit.CONIFER_BUTTON).add(BlockInit.GINKGO_BUTTON).add(BlockInit.SCORCHED_BUTTON);
		this.tag(BlockTags.WOODEN_DOORS).add(BlockInit.ARAUCARIA_DOOR).add(BlockInit.CONIFER_DOOR).add(BlockInit.GINKGO_DOOR);
		this.tag(BlockTags.WOODEN_FENCES).add(BlockInit.ARAUCARIA_FENCE).add(BlockInit.CONIFER_FENCE).add(BlockInit.GINKGO_FENCE).add(BlockInit.SCORCHED_FENCE);
		this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(BlockInit.ARAUCARIA_PRESSURE_PLATE).add(BlockInit.CONIFER_PRESSURE_PLATE).add(BlockInit.GINKGO_PRESSURE_PLATE).add(BlockInit.SCORCHED_PRESSURE_PLATE);
		this.tag(BlockTags.WOODEN_SLABS).add(BlockInit.ARAUCARIA_SLAB).add(BlockInit.CONIFER_SLAB).add(BlockInit.GINKGO_SLAB).add(BlockInit.SCORCHED_SLAB);
		this.tag(BlockTags.WOODEN_STAIRS).add(BlockInit.ARAUCARIA_STAIRS).add(BlockInit.CONIFER_STAIRS).add(BlockInit.GINKGO_STAIRS).add(BlockInit.SCORCHED_STAIRS);
		this.tag(BlockTags.WOODEN_TRAPDOORS).add(BlockInit.ARAUCARIA_TRAPDOOR).add(BlockInit.CONIFER_TRAPDOOR).add(BlockInit.GINKGO_TRAPDOOR);
		
		//Forge
		this.tag(Blocks.ORES_COAL).add(BlockInit.JURASSIC_COAL_ORE).add(BlockInit.PERMIAN_COAL_ORE);
		this.tag(Blocks.ORES_DIAMOND).add(BlockInit.JURASSIC_DIAMOND_ORE).add(BlockInit.PERMIAN_DIAMOND_ORE);
		this.tag(Blocks.ORES_EMERALD).add(BlockInit.JURASSIC_EMERALD_ORE).add(BlockInit.PERMIAN_EMERALD_ORE);
		this.tag(Blocks.ORES_GOLD).add(BlockInit.JURASSIC_GOLD_ORE).add(BlockInit.PERMIAN_GOLD_ORE);
		this.tag(Blocks.ORES_IRON).add(BlockInit.JURASSIC_IRON_ORE).add(BlockInit.PERMIAN_IRON_ORE);
		this.tag(Blocks.ORES_LAPIS).add(BlockInit.JURASSIC_LAPIS_ORE).add(BlockInit.PERMIAN_LAPIS_ORE);
		this.tag(Blocks.ORES_REDSTONE).add(BlockInit.JURASSIC_REDSTONE_ORE).add(BlockInit.PERMIAN_REDSTONE_ORE);
		this.tag(Blocks.DIRT).add(BlockInit.MOSSY_DIRT);
		
		//Mod
		this.tag(ModBlockTags.ARAUCARIA_LOGS).add(BlockInit.ARAUCARIA_LOG).add(BlockInit.STRIPPED_ARAUCARIA_LOG).add(BlockInit.ARAUCARIA_WOOD).add(BlockInit.STRIPPED_ARAUCARIA_WOOD);
		this.tag(ModBlockTags.CONIFER_LOGS).add(BlockInit.CONIFER_LOG).add(BlockInit.STRIPPED_CONIFER_LOG).add(BlockInit.CONIFER_WOOD).add(BlockInit.STRIPPED_CONIFER_WOOD);
		this.tag(ModBlockTags.DARK_CONCRETE).add(BlockInit.DARK_CONCRETE).add(BlockInit.DARK_CONCRETE_BUTTON).add(BlockInit.DARK_CONCRETE_PRESSURE_PLATE).add(BlockInit.DARK_CONCRETE_SLAB).add(BlockInit.DARK_CONCRETE_STAIRS).add(BlockInit.DARK_CONCRETE_WALL);
		this.tag(ModBlockTags.LIGHT_CONCRETE).add(BlockInit.LIGHT_CONCRETE).add(BlockInit.LIGHT_CONCRETE_BUTTON).add(BlockInit.LIGHT_CONCRETE_PRESSURE_PLATE).add(BlockInit.LIGHT_CONCRETE_SLAB).add(BlockInit.LIGHT_CONCRETE_STAIRS).add(BlockInit.LIGHT_CONCRETE_WALL);
		this.tag(ModBlockTags.DECORATIVE_BLOCKS).add(BlockInit.BLACK_DECORATION_BLOCK).add(BlockInit.BLUE_DECORATION_BLOCK).add(BlockInit.BROWN_DECORATION_BLOCK).add(BlockInit.CYAN_DECORATION_BLOCK).add(BlockInit.GREEN_DECORATION_BLOCK).add(BlockInit.GREY_DECORATION_BLOCK).add(BlockInit.LIGHT_BLUE_DECORATION_BLOCK).add(BlockInit.LIGHT_GREY_DECORATION_BLOCK).add(BlockInit.LIME_DECORATION_BLOCK).add(BlockInit.MAGENTA_DECORATION_BLOCK).add(BlockInit.ORANGE_DECORATION_BLOCK).add(BlockInit.PINK_DECORATION_BLOCK).add(BlockInit.PURPLE_DECORATION_BLOCK).add(BlockInit.RED_DECORATION_BLOCK).add(BlockInit.WHITE_DECORATION_BLOCK).add(BlockInit.YELLOW_DECORATION_BLOCK);
		this.tag(ModBlockTags.DECORATIVE_DOORS).add(BlockInit.BACK_DOOR).add(BlockInit.GLASS_SHOP_DOOR).add(BlockInit.INNOVATION_CENTRE_DOOR).add(BlockInit.OUTDOOR_TOILET_DOOR).add(BlockInit.SECURITY_DOOR).add(BlockInit.VISITOR_CENTRE_DOOR);
		this.tag(ModBlockTags.FOSSILS).add(BlockInit.STONE_FOSSIL).add(BlockInit.EXPOSED_STONE_FOSSIL).add(BlockInit.SANDSTONE_FOSSIL).add(BlockInit.EXPOSED_SANDSTONE_FOSSIL);
		this.tag(ModBlockTags.GINKGO_LOGS).add(BlockInit.GINKGO_LOG).add(BlockInit.STRIPPED_GINKGO_LOG).add(BlockInit.GINKGO_WOOD).add(BlockInit.STRIPPED_GINKGO_WOOD);
		this.tag(ModBlockTags.GLASS).add(BlockInit.BLACK_GLASS).add(BlockInit.BLACK_GLASS_PANE).add(BlockInit.BLUE_GLASS).add(BlockInit.BLUE_GLASS_PANE).add(BlockInit.BROWN_GLASS).add(BlockInit.BROWN_GLASS_PANE).add(BlockInit.CLEAR_GLASS).add(BlockInit.CLEAR_GLASS_PANE).add(BlockInit.CYAN_GLASS).add(BlockInit.CYAN_GLASS_PANE).add(BlockInit.GREEN_GLASS).add(BlockInit.GREEN_GLASS_PANE).add(BlockInit.GREY_GLASS).add(BlockInit.GREY_GLASS_PANE).add(BlockInit.LIGHT_BLUE_GLASS).add(BlockInit.LIGHT_BLUE_GLASS_PANE).add(BlockInit.LIGHT_GREY_GLASS).add(BlockInit.LIGHT_GREY_GLASS_PANE).add(BlockInit.LIME_GLASS).add(BlockInit.LIME_GLASS_PANE).add(BlockInit.MAGENTA_GLASS).add(BlockInit.MAGENTA_GLASS_PANE).add(BlockInit.ORANGE_GLASS).add(BlockInit.ORANGE_GLASS_PANE).add(BlockInit.PINK_GLASS).add(BlockInit.PINK_GLASS_PANE).add(BlockInit.PURPLE_GLASS).add(BlockInit.PURPLE_GLASS_PANE).add(BlockInit.RED_GLASS).add(BlockInit.RED_GLASS_PANE).add(BlockInit.SHADED_GLASS).add(BlockInit.SHADED_GLASS_PANE).add(BlockInit.TINTED_GLASS).add(BlockInit.TINTED_GLASS_PANE).add(BlockInit.WHITE_GLASS).add(BlockInit.WHITE_GLASS_PANE).add(BlockInit.YELLOW_GLASS).add(BlockInit.YELLOW_GLASS_PANE);
		this.tag(ModBlockTags.PAVEMENT).add(BlockInit.PAVEMENT).add(BlockInit.PAVEMENT_SLOPE).add(BlockInit.RAISED_PAVEMENT);
		this.tag(ModBlockTags.REFINED_WOODEN_PLANKS).add(BlockInit.REFINED_WOODEN_PLANKS).add(BlockInit.REFINED_WOODEN_PLANKS_BUTTON).add(BlockInit.REFINED_WOODEN_PLANKS_FENCE).add(BlockInit.REFINED_WOODEN_PLANKS_FENCE_GATE).add(BlockInit.REFINED_WOODEN_PLANKS_PRESSURE_PLATE).add(BlockInit.REFINED_WOODEN_PLANKS_SLAB).add(BlockInit.REFINED_WOODEN_PLANKS_STAIRS);
		this.tag(ModBlockTags.ROADS).add(BlockInit.DIRT_ROAD).add(BlockInit.GRAVEL_ROAD).add(BlockInit.PAVED_ROAD).add(BlockInit.RAISED_DIRT_ROAD).add(BlockInit.RAISED_GRAVEL_ROAD).add(BlockInit.RAISED_PAVED_ROAD);
		this.tag(ModBlockTags.SCORCHED_LOGS).add(BlockInit.SCORCHED_LOG).add(BlockInit.STRIPPED_SCORCHED_LOG).add(BlockInit.SCORCHED_WOOD).add(BlockInit.STRIPPED_SCORCHED_WOOD);
		this.tag(ModBlockTags.WOODEN_PLANKS).add(BlockInit.WOODEN_PLANKS).add(BlockInit.WOODEN_PLANKS_BUTTON).add(BlockInit.WOODEN_PLANKS_FENCE).add(BlockInit.WOODEN_PLANKS_FENCE_GATE).add(BlockInit.WOODEN_PLANKS_PRESSURE_PLATE).add(BlockInit.WOODEN_PLANKS_SLAB).add(BlockInit.WOODEN_PLANKS_STAIRS);		
	}
}
