package lostworlds.content.datagen;

import java.util.function.Consumer;

import lostworlds.content.server.ModTags.ModItemTags;
import lostworlds.content.server.init.BlockInit;
import lostworlds.content.server.init.ItemInit;
import lostworlds.library.util.ModUtil;
import net.minecraft.block.Blocks;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.data.SingleItemRecipeBuilder;
import net.minecraft.data.SmithingRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.registry.Registry;

public class GenRecipes extends RecipeProvider
{
	public GenRecipes(DataGenerator generator) 
	{
		super(generator);
	}

	@Override
	protected void buildShapelessRecipes(Consumer<IFinishedRecipe> recipe) 
	{
		//Shapeless
		//Items
		ShapelessRecipeBuilder.shapeless(ItemInit.WET_PAPER, 8).requires(Items.WATER_BUCKET).requires(Items.PAPER).requires(Items.PAPER).requires(Items.PAPER).requires(Items.PAPER).requires(Items.PAPER).requires(Items.PAPER).requires(Items.PAPER).requires(Items.PAPER).unlockedBy("has_item", has(Items.PAPER)).save(recipe);
		ShapelessRecipeBuilder.shapeless(ItemInit.COPPER_NUGGET, 9).requires(ItemInit.COPPER_INGOT).unlockedBy("has_item", has(ItemInit.COPPER_INGOT)).save(recipe);
		ShapelessRecipeBuilder.shapeless(ItemInit.COMPUTER_CORE).requires(ItemInit.COMPUTER_STORAGE_PORT).requires(ItemInit.COMPUTER_FRAME).requires(ItemInit.MOTHERBOARD).requires(ItemInit.CPU).requires(ItemInit.RAM).requires(ItemInit.COMPUTER_FAN).requires(ItemInit.COMPUTER_SCREEN).requires(ItemInit.COPPER_WIRE).requires(ItemInit.COPPER_WIRE).unlockedBy("has_item", has(ItemInit.COPPER_WIRE)).save(recipe);
		
		//Blocks
		ShapelessRecipeBuilder.shapeless(BlockInit.MOSSY_JURASSIC_STONE).requires(BlockInit.JURASSIC_STONE).requires(Items.VINE).unlockedBy("has_item", has(Items.VINE)).save(recipe);
		ShapelessRecipeBuilder.shapeless(BlockInit.MOSSY_JURASSIC_STONE_BRICKS).requires(BlockInit.JURASSIC_STONE_BRICKS).requires(Items.VINE).unlockedBy("has_item", has(Items.VINE)).save(recipe);
		ShapelessRecipeBuilder.shapeless(BlockInit.MOSSY_JURASSIC_COBBLESTONE).requires(BlockInit.JURASSIC_COBBLESTONE).requires(Items.VINE).unlockedBy("has_item", has(Items.VINE)).save(recipe);

		ShapelessRecipeBuilder.shapeless(BlockInit.LIGHT_CONCRETE_BUTTON).requires(BlockInit.LIGHT_CONCRETE).unlockedBy("has_item", has(BlockInit.LIGHT_CONCRETE)).save(recipe);
		ShapelessRecipeBuilder.shapeless(BlockInit.DARK_CONCRETE_BUTTON).requires(BlockInit.LIGHT_CONCRETE).unlockedBy("has_item", has(BlockInit.LIGHT_CONCRETE)).save(recipe);

		ShapelessRecipeBuilder.shapeless(BlockInit.PAVEMENT).requires(Items.STONE).requires(Items.STONE).requires(Items.ANDESITE).requires(Items.ANDESITE).unlockedBy("has_item", has(Items.STONE)).save(recipe);

		planksFromLogs(recipe, BlockInit.ARAUCARIA_PLANKS, ModItemTags.ARAUCARIA_LOGS);
		planksFromLogs(recipe, BlockInit.CONIFER_PLANKS, ModItemTags.CONIFER_LOGS);
		planksFromLogs(recipe, BlockInit.GINKGO_PLANKS, ModItemTags.GINKGO_LOGS);
		planksFromLogs(recipe, BlockInit.SCORCHED_PLANKS, ModItemTags.SCORCHED_LOGS);
		woodenButton(recipe, BlockInit.ARAUCARIA_BUTTON, BlockInit.ARAUCARIA_PLANKS);
		woodenButton(recipe, BlockInit.CONIFER_BUTTON, BlockInit.CONIFER_PLANKS);
		woodenButton(recipe, BlockInit.GINKGO_BUTTON, BlockInit.GINKGO_PLANKS);
		woodenButton(recipe, BlockInit.SCORCHED_BUTTON, BlockInit.SCORCHED_PLANKS);
		
		//Shaped
		//Items
		ShapedRecipeBuilder.shaped(ItemInit.LEATHER_BRUSH).define('#', Items.STICK).define('$', Items.LEATHER).define('@', Items.STRING).pattern("@@@").pattern("$$$").pattern(" # ").unlockedBy("has_item", has(Items.LEATHER)).save(recipe);
		ShapedRecipeBuilder.shaped(ItemInit.IRON_BRUSH).define('#', Items.STICK).define('$', Items.IRON_INGOT).define('@', Items.STRING).pattern("@@@").pattern("$$$").pattern(" # ").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);
		ShapedRecipeBuilder.shaped(ItemInit.GOLD_BRUSH).define('#', Items.STICK).define('$', Items.GOLD_INGOT).define('@', Items.STRING).pattern("@@@").pattern("$$$").pattern(" # ").unlockedBy("has_item", has(Items.GOLD_INGOT)).save(recipe);
		ShapedRecipeBuilder.shaped(ItemInit.DIAMOND_BRUSH).define('#', Items.STICK).define('$', Items.DIAMOND).define('@', Items.STRING).pattern("@@@").pattern("$$$").pattern(" # ").unlockedBy("has_item", has(Items.DIAMOND)).save(recipe);
		ShapedRecipeBuilder.shaped(ItemInit.EMPTY_VILE).define('#', Items.GLASS_PANE).define('$', Items.WHEAT).define('@', ItemTags.STONE_TOOL_MATERIALS).pattern(" $@").pattern(" #$").pattern("#  ").unlockedBy("has_item", has(Items.GLASS_PANE)).save(recipe);
		ShapedRecipeBuilder.shaped(ItemInit.PALEO_SALAD).define('#', ModItemTags.FOOD_SEEDS).define('$', Items.BOWL).pattern("###").pattern("#$#").pattern("###").unlockedBy("has_item", has(ModItemTags.FOOD_SEEDS)).save(recipe);
		ShapedRecipeBuilder.shaped(ItemInit.COPPER_INGOT).define('#', ItemInit.COPPER_NUGGET).pattern("###").pattern("###").pattern("###").unlockedBy("has_item", has(ItemInit.COPPER_NUGGET)).save(recipe);
		ShapedRecipeBuilder.shaped(ItemInit.COPPER_WIRE).define('#', Items.BLACK_CARPET).define('$', ItemInit.COPPER_NUGGET).pattern("###").pattern("$$$").pattern("###").unlockedBy("has_item", has(ItemInit.COPPER_NUGGET)).save(recipe);
		ShapedRecipeBuilder.shaped(ItemInit.COMPUTER_FAN).define('#', Items.IRON_INGOT).define('$', Items.STONE).pattern(" # ").pattern("#$#").pattern(" # ").unlockedBy("has_item", has(Items.STONE)).save(recipe);
		ShapedRecipeBuilder.shaped(ItemInit.COMPUTER_FAN).define('#', Items.IRON_INGOT).define('$', Items.STONE).pattern("# #").pattern(" $ ").pattern("# #").unlockedBy("has_item", has(Items.STONE)).save(recipe, ModUtil.rL("computer_fan_alternate"));
		ShapedRecipeBuilder.shaped(ItemInit.COMPUTER_SCREEN).define('#', Items.GLASS_PANE).define('$', ItemInit.COPPER_WIRE).define('r', Items.RED_DYE).define('g', Items.GREEN_DYE).define('b', Items.BLUE_DYE).pattern("###").pattern("rgb").pattern("$$$").unlockedBy("has_item", has(ItemInit.COPPER_WIRE)).save(recipe);
		ShapedRecipeBuilder.shaped(ItemInit.COMPUTER_FRAME).define('#', Items.IRON_INGOT).pattern("###").pattern("# #").pattern("###").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);
		ShapedRecipeBuilder.shaped(ItemInit.COMPUTER_STORAGE_PORT).define('#', Items.IRON_INGOT).define('$', Items.STONE).define('@', ItemInit.COPPER_WIRE).pattern("$#$").pattern("#@#").pattern("$#$").unlockedBy("has_item", has(ItemInit.COPPER_WIRE)).save(recipe);
		ShapedRecipeBuilder.shaped(ItemInit.MOTHERBOARD).define('#', ItemInit.COPPER_INGOT).define('$', ItemInit.COPPER_WIRE).define('@', Items.IRON_INGOT).pattern("###").pattern("#@#").pattern("$$$").unlockedBy("has_item", has(ItemInit.COPPER_WIRE)).save(recipe);
		ShapedRecipeBuilder.shaped(ItemInit.CPU).define('#', ItemInit.COPPER_WIRE).define('$', ItemInit.COPPER_INGOT).define('@', Items.GREEN_WOOL).pattern("###").pattern("@$@").pattern("###").unlockedBy("has_item", has(ItemInit.COPPER_WIRE)).save(recipe);
		ShapedRecipeBuilder.shaped(ItemInit.RAM).define('#', Items.IRON_INGOT).define('$', ItemInit.COPPER_WIRE).pattern("###").pattern("$$$").unlockedBy("has_item", has(ItemInit.COPPER_WIRE)).save(recipe);
		ShapedRecipeBuilder.shaped(ItemInit.STORAGE_DISC).define('#', ItemInit.COPPER_WIRE).define('$', Items.DIAMOND).pattern("###").pattern("#$#").pattern("###").unlockedBy("has_item", has(Items.DIAMOND)).save(recipe);
		ShapedRecipeBuilder.shaped(ItemInit.UNCHARGED_CRYSTAL_SCARAB_GEM).define('#', ItemInit.BROKEN_CRYSTAL_SCARAB_GEM).pattern("###").pattern("###").pattern("###").unlockedBy("has_item", has(ItemInit.BROKEN_CRYSTAL_SCARAB_GEM)).save(recipe);
		
		//Blocks
		ShapedRecipeBuilder.shaped(BlockInit.FOSSIL_CLEANER).define('#', ItemInit.COMPUTER_CORE).define('$', Items.IRON_INGOT).define('@', Items.REDSTONE).define('%', Items.REDSTONE_LAMP).define('&', Items.BUCKET).define('P', Items.POLISHED_ANDESITE).pattern("$@$").pattern("P#&").pattern("$%$").unlockedBy("has_item", has(ItemInit.COMPUTER_CORE)).save(recipe);
		ShapedRecipeBuilder.shaped(BlockInit.FOSSIL_GRINDER).define('#', ItemInit.COMPUTER_CORE).define('$', Items.IRON_INGOT).define('@', Items.REDSTONE).define('%', Items.REDSTONE_LAMP).define('&', Items.DIAMOND).define('P', Items.POLISHED_ANDESITE).pattern("$@$").pattern("P#&").pattern("$%$").unlockedBy("has_item", has(ItemInit.COMPUTER_CORE)).save(recipe);
		ShapedRecipeBuilder.shaped(BlockInit.DNA_EXTRACTOR).define('#', ItemInit.COMPUTER_CORE).define('$', Items.IRON_INGOT).define('@', Items.REDSTONE).define('%', Items.REDSTONE_LAMP).define('&', Items.GOLD_INGOT).define('P', Items.POLISHED_ANDESITE).pattern(" @$").pattern("P#&").pattern("P%$").unlockedBy("has_item", has(ItemInit.COMPUTER_CORE)).save(recipe);
		ShapedRecipeBuilder.shaped(BlockInit.ANALYSER).define('#', ItemInit.COMPUTER_CORE).define('$', Items.IRON_INGOT).define('@', Items.REDSTONE).define('%', Items.REDSTONE_LAMP).define('P', Items.POLISHED_ANDESITE).pattern("$@$").pattern("P#$").pattern("$%$").unlockedBy("has_item", has(ItemInit.COMPUTER_CORE)).save(recipe);
		ShapedRecipeBuilder.shaped(BlockInit.DNA_INJECTOR).define('#', ItemInit.COMPUTER_CORE).define('$', Items.IRON_INGOT).define('@', Items.REDSTONE).define('%', Items.REDSTONE_LAMP).define('&', Items.GOLD_INGOT).define('P', Items.POLISHED_ANDESITE).pattern(" @$").pattern("$#&").pattern("P%$").unlockedBy("has_item", has(ItemInit.COMPUTER_CORE)).save(recipe);
		ShapedRecipeBuilder.shaped(BlockInit.MUD).define('#', ItemInit.MUD_BALL).pattern("##").pattern("##").unlockedBy("has_item", has(ItemInit.MUD_BALL)).save(recipe);;
		ShapedRecipeBuilder.shaped(BlockInit.VOLCANIC_ASH_LAYER).define('#', BlockInit.VOLCANIC_ASH_LAYER).pattern("###").unlockedBy("has_item", has(BlockInit.VOLCANIC_ASH)).save(recipe);;
		ShapedRecipeBuilder.shaped(BlockInit.NESTING_BLOCK).define('#', Items.DIRT).define('$', ItemInit.MUD_BALL).pattern("#$").pattern("$#").unlockedBy("has_item", has(ItemInit.MUD_BALL)).save(recipe);;
		ShapedRecipeBuilder.shaped(BlockInit.ARCHAEOLOGY_TABLE).define('#', ItemTags.PLANKS).define('$', Items.BOOKSHELF).pattern("###").pattern("#$#").unlockedBy("has_item", has(Items.BOOK)).save(recipe);
		ShapedRecipeBuilder.shaped(BlockInit.TIME_MACHINE).define('#', Items.GOLD_BLOCK).define('$', ItemInit.CHARGED_CRYSTAL_SCARAB_GEM).define('@', Items.ENCHANTING_TABLE).define('%', Items.OBSIDIAN).define('!', Items.CRYING_OBSIDIAN).pattern("#$#").pattern("$@$").pattern("%!%").unlockedBy("has_item", has(ItemInit.CHARGED_CRYSTAL_SCARAB_GEM)).save(recipe);
		
		woodFromLogs(recipe, BlockInit.ARAUCARIA_WOOD, BlockInit.ARAUCARIA_LOG);
		woodFromLogs(recipe, BlockInit.CONIFER_WOOD, BlockInit.CONIFER_LOG);
		woodFromLogs(recipe, BlockInit.GINKGO_WOOD, BlockInit.GINKGO_LOG);
		woodFromLogs(recipe, BlockInit.SCORCHED_WOOD, BlockInit.SCORCHED_LOG);
		woodFromLogs(recipe, BlockInit.STRIPPED_ARAUCARIA_WOOD, BlockInit.STRIPPED_ARAUCARIA_LOG);
		woodFromLogs(recipe, BlockInit.STRIPPED_CONIFER_WOOD, BlockInit.STRIPPED_CONIFER_LOG);
		woodFromLogs(recipe, BlockInit.STRIPPED_GINKGO_WOOD, BlockInit.STRIPPED_GINKGO_LOG);
		woodFromLogs(recipe, BlockInit.STRIPPED_SCORCHED_WOOD, BlockInit.STRIPPED_SCORCHED_LOG);
		woodenDoor(recipe, BlockInit.ARAUCARIA_DOOR, BlockInit.ARAUCARIA_PLANKS);
		woodenDoor(recipe, BlockInit.CONIFER_DOOR, BlockInit.CONIFER_PLANKS);
		woodenDoor(recipe, BlockInit.GINKGO_DOOR, BlockInit.GINKGO_PLANKS);
		woodenFence(recipe, BlockInit.ARAUCARIA_FENCE, BlockInit.ARAUCARIA_PLANKS);
		woodenFence(recipe, BlockInit.CONIFER_FENCE, BlockInit.CONIFER_PLANKS);
		woodenFence(recipe, BlockInit.GINKGO_FENCE, BlockInit.GINKGO_PLANKS);
		woodenFence(recipe, BlockInit.SCORCHED_FENCE, BlockInit.SCORCHED_PLANKS);
		woodenFenceGate(recipe, BlockInit.ARAUCARIA_FENCE_GATE, BlockInit.ARAUCARIA_PLANKS);
		woodenFenceGate(recipe, BlockInit.CONIFER_FENCE_GATE, BlockInit.CONIFER_PLANKS);
		woodenFenceGate(recipe, BlockInit.GINKGO_FENCE_GATE, BlockInit.GINKGO_PLANKS);
		woodenFenceGate(recipe, BlockInit.SCORCHED_FENCE_GATE, BlockInit.SCORCHED_PLANKS);
		woodenPressurePlate(recipe, BlockInit.ARAUCARIA_PRESSURE_PLATE, BlockInit.ARAUCARIA_PLANKS);
		woodenPressurePlate(recipe, BlockInit.CONIFER_PRESSURE_PLATE, BlockInit.CONIFER_PLANKS);
		woodenPressurePlate(recipe, BlockInit.GINKGO_PRESSURE_PLATE, BlockInit.GINKGO_PLANKS);
		woodenPressurePlate(recipe, BlockInit.SCORCHED_PRESSURE_PLATE, BlockInit.SCORCHED_PLANKS);
		woodenSlab(recipe, BlockInit.ARAUCARIA_SLAB, BlockInit.ARAUCARIA_PLANKS);
		woodenSlab(recipe, BlockInit.CONIFER_SLAB, BlockInit.CONIFER_PLANKS);
		woodenSlab(recipe, BlockInit.GINKGO_SLAB, BlockInit.GINKGO_PLANKS);
		woodenSlab(recipe, BlockInit.SCORCHED_SLAB, BlockInit.SCORCHED_PLANKS);
		woodenStairs(recipe, BlockInit.ARAUCARIA_STAIRS, BlockInit.ARAUCARIA_PLANKS);
		woodenStairs(recipe, BlockInit.CONIFER_STAIRS, BlockInit.CONIFER_PLANKS);
		woodenStairs(recipe, BlockInit.GINKGO_STAIRS, BlockInit.GINKGO_PLANKS);
		woodenStairs(recipe, BlockInit.SCORCHED_STAIRS, BlockInit.SCORCHED_PLANKS);
		woodenTrapdoor(recipe, BlockInit.ARAUCARIA_TRAPDOOR, BlockInit.ARAUCARIA_PLANKS);
		woodenTrapdoor(recipe, BlockInit.CONIFER_TRAPDOOR, BlockInit.CONIFER_PLANKS);
		woodenTrapdoor(recipe, BlockInit.GINKGO_TRAPDOOR, BlockInit.GINKGO_PLANKS);
		
		slab(recipe, BlockInit.PERMIAN_STONE_SLAB, BlockInit.PERMIAN_STONE);
		stairs(recipe, BlockInit.PERMIAN_STONE_STAIRS, BlockInit.PERMIAN_STONE);
		button(recipe, BlockInit.PERMIAN_STONE_BUTTON, BlockInit.PERMIAN_STONE);

		ShapedRecipeBuilder.shaped(BlockInit.PERMIAN_STONE_BRICKS, 4).define('#', BlockInit.PERMIAN_STONE).pattern("##").pattern("##").unlockedBy("has_item", has(BlockInit.PERMIAN_STONE)).save(recipe);

		slab(recipe, BlockInit.PERMIAN_STONE_BRICK_SLAB, BlockInit.PERMIAN_STONE_BRICKS);
		stairs(recipe, BlockInit.PERMIAN_STONE_BRICK_STAIRS, BlockInit.PERMIAN_STONE_BRICKS);
		wall(recipe, BlockInit.PERMIAN_STONE_BRICK_WALL, BlockInit.PERMIAN_STONE_BRICKS);
		
		slab(recipe, BlockInit.PERMIAN_COBBLESTONE_SLAB, BlockInit.PERMIAN_COBBLESTONE);
		stairs(recipe, BlockInit.PERMIAN_COBBLESTONE_STAIRS, BlockInit.PERMIAN_COBBLESTONE);
		wall(recipe, BlockInit.PERMIAN_COBBLESTONE_WALL, BlockInit.PERMIAN_COBBLESTONE);

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.PERMIAN_STONE), BlockInit.PERMIAN_STONE_SLAB).unlocks("has_item", has(BlockInit.PERMIAN_STONE)).save(recipe, ModUtil.rL("permian_stone_slab_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.PERMIAN_STONE), BlockInit.PERMIAN_STONE_STAIRS).unlocks("has_item", has(BlockInit.PERMIAN_STONE)).save(recipe, ModUtil.rL("permian_stone_stairs_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.PERMIAN_STONE), BlockInit.PERMIAN_STONE_BRICKS).unlocks("has_item", has(BlockInit.PERMIAN_STONE)).save(recipe, ModUtil.rL("permian_stone_bricks_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.PERMIAN_STONE), BlockInit.PERMIAN_STONE_BRICK_SLAB).unlocks("has_item", has(BlockInit.PERMIAN_STONE)).save(recipe, ModUtil.rL("permian_stone_brick_slab_from_stone_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.PERMIAN_STONE), BlockInit.PERMIAN_STONE_BRICK_STAIRS).unlocks("has_item", has(BlockInit.PERMIAN_STONE)).save(recipe, ModUtil.rL("permian_stone_brick_stairs_from_stone_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.PERMIAN_STONE), BlockInit.PERMIAN_STONE_BRICK_WALL).unlocks("has_item", has(BlockInit.PERMIAN_STONE)).save(recipe, ModUtil.rL("permian_stone_brick_wall_from_stone_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.PERMIAN_STONE_BRICKS), BlockInit.PERMIAN_STONE_BRICK_SLAB).unlocks("has_item", has(BlockInit.PERMIAN_STONE_BRICKS)).save(recipe, ModUtil.rL("permian_stone_brick_slab_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.PERMIAN_STONE_BRICKS), BlockInit.PERMIAN_STONE_BRICK_STAIRS).unlocks("has_item", has(BlockInit.PERMIAN_STONE_BRICKS)).save(recipe, ModUtil.rL("permian_stone_brick_stairs_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.PERMIAN_STONE_BRICKS), BlockInit.PERMIAN_STONE_BRICK_WALL).unlocks("has_item", has(BlockInit.PERMIAN_STONE_BRICKS)).save(recipe, ModUtil.rL("permian_stone_brick_wall_from_stonecutting"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.PERMIAN_COBBLESTONE), BlockInit.PERMIAN_COBBLESTONE_SLAB).unlocks("has_item", has(BlockInit.PERMIAN_COBBLESTONE)).save(recipe, ModUtil.rL("permian_cobblestone_slab_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.PERMIAN_COBBLESTONE), BlockInit.PERMIAN_COBBLESTONE_STAIRS).unlocks("has_item", has(BlockInit.PERMIAN_COBBLESTONE)).save(recipe, ModUtil.rL("permian_cobblestone_stairs_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.PERMIAN_COBBLESTONE), BlockInit.PERMIAN_COBBLESTONE_WALL).unlocks("has_item", has(BlockInit.PERMIAN_COBBLESTONE)).save(recipe, ModUtil.rL("permian_cobblestone_wall_from_stonecutting"));

		slab(recipe, BlockInit.JURASSIC_STONE_SLAB, BlockInit.JURASSIC_STONE);		
		stairs(recipe, BlockInit.JURASSIC_STONE_STAIRS, BlockInit.JURASSIC_STONE);
		button(recipe, BlockInit.JURASSIC_STONE_BUTTON, BlockInit.JURASSIC_STONE);
		
		ShapedRecipeBuilder.shaped(BlockInit.JURASSIC_STONE_BRICKS, 4).define('#', BlockInit.JURASSIC_STONE).pattern("##").pattern("##").unlockedBy("has_item", has(BlockInit.JURASSIC_STONE)).save(recipe);

		slab(recipe, BlockInit.JURASSIC_STONE_BRICK_SLAB, BlockInit.JURASSIC_STONE_BRICKS);
		stairs(recipe, BlockInit.JURASSIC_STONE_BRICK_STAIRS, BlockInit.JURASSIC_STONE_BRICKS);
		wall(recipe, BlockInit.JURASSIC_STONE_BRICK_WALL, BlockInit.JURASSIC_STONE_BRICKS);

		slab(recipe, BlockInit.JURASSIC_COBBLESTONE_SLAB, BlockInit.JURASSIC_STONE);
		stairs(recipe, BlockInit.JURASSIC_COBBLESTONE_STAIRS, BlockInit.JURASSIC_COBBLESTONE);
		wall(recipe, BlockInit.JURASSIC_COBBLESTONE_WALL, BlockInit.JURASSIC_COBBLESTONE);
		
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.JURASSIC_STONE), BlockInit.JURASSIC_STONE_SLAB).unlocks("has_item", has(BlockInit.JURASSIC_STONE)).save(recipe, ModUtil.rL("jurassic_stone_slab_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.JURASSIC_STONE), BlockInit.JURASSIC_STONE_STAIRS).unlocks("has_item", has(BlockInit.JURASSIC_STONE)).save(recipe, ModUtil.rL("jurassic_stone_stairs_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.JURASSIC_STONE), BlockInit.JURASSIC_STONE_BRICKS).unlocks("has_item", has(BlockInit.JURASSIC_STONE)).save(recipe, ModUtil.rL("jurassic_stone_bricks_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.JURASSIC_STONE), BlockInit.JURASSIC_STONE_BRICK_SLAB).unlocks("has_item", has(BlockInit.JURASSIC_STONE)).save(recipe, ModUtil.rL("jurassic_stone_brick_slab_from_stone_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.JURASSIC_STONE), BlockInit.JURASSIC_STONE_BRICK_STAIRS).unlocks("has_item", has(BlockInit.JURASSIC_STONE)).save(recipe, ModUtil.rL("jurassic_stone_brick_stairs_from_stone_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.JURASSIC_STONE), BlockInit.JURASSIC_STONE_BRICK_WALL).unlocks("has_item", has(BlockInit.JURASSIC_STONE)).save(recipe, ModUtil.rL("jurassic_stone_brick_wall_from_stone_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.JURASSIC_STONE_BRICKS), BlockInit.JURASSIC_STONE_BRICK_SLAB).unlocks("has_item", has(BlockInit.JURASSIC_STONE_BRICKS)).save(recipe, ModUtil.rL("jurassic_stone_brick_slab_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.JURASSIC_STONE_BRICKS), BlockInit.JURASSIC_STONE_BRICK_STAIRS).unlocks("has_item", has(BlockInit.JURASSIC_STONE_BRICKS)).save(recipe, ModUtil.rL("jurassic_stone_brick_stairs_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.JURASSIC_STONE_BRICKS), BlockInit.JURASSIC_STONE_BRICK_WALL).unlocks("has_item", has(BlockInit.JURASSIC_STONE_BRICKS)).save(recipe, ModUtil.rL("jurassic_stone_brick_wall_from_stonecutting"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.JURASSIC_COBBLESTONE), BlockInit.JURASSIC_COBBLESTONE_SLAB).unlocks("has_item", has(BlockInit.JURASSIC_COBBLESTONE)).save(recipe, ModUtil.rL("jurassic_cobblestone_slab_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.JURASSIC_COBBLESTONE), BlockInit.JURASSIC_COBBLESTONE_STAIRS).unlocks("has_item", has(BlockInit.JURASSIC_COBBLESTONE)).save(recipe, ModUtil.rL("jurassic_cobblestone_stairs_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.JURASSIC_COBBLESTONE), BlockInit.JURASSIC_COBBLESTONE_WALL).unlocks("has_item", has(BlockInit.JURASSIC_COBBLESTONE)).save(recipe, ModUtil.rL("jurassic_cobblestone_wall_from_stonecutting"));

		slab(recipe, BlockInit.MOSSY_JURASSIC_STONE_SLAB, BlockInit.MOSSY_JURASSIC_STONE);
		stairs(recipe, BlockInit.MOSSY_JURASSIC_STONE_STAIRS, BlockInit.MOSSY_JURASSIC_STONE);
	
		ShapedRecipeBuilder.shaped(BlockInit.MOSSY_JURASSIC_STONE_BRICKS, 4).define('#', BlockInit.MOSSY_JURASSIC_STONE).pattern("##").pattern("##").unlockedBy("has_item", has(BlockInit.MOSSY_JURASSIC_STONE)).save(recipe, ModUtil.rL("mossy_jurassic_stone_from_stone"));

		slab(recipe, BlockInit.MOSSY_JURASSIC_STONE_BRICK_SLAB, BlockInit.MOSSY_JURASSIC_STONE_BRICKS);
		stairs(recipe, BlockInit.MOSSY_JURASSIC_STONE_BRICK_STAIRS, BlockInit.MOSSY_JURASSIC_STONE_BRICKS);
		wall(recipe, BlockInit.MOSSY_JURASSIC_STONE_BRICK_WALL, BlockInit.MOSSY_JURASSIC_STONE_BRICKS);

		slab(recipe, BlockInit.MOSSY_JURASSIC_COBBLESTONE_SLAB, BlockInit.MOSSY_JURASSIC_COBBLESTONE);
		stairs(recipe, BlockInit.MOSSY_JURASSIC_COBBLESTONE_STAIRS, BlockInit.MOSSY_JURASSIC_COBBLESTONE);
		wall(recipe, BlockInit.MOSSY_JURASSIC_COBBLESTONE_WALL, BlockInit.MOSSY_JURASSIC_COBBLESTONE);	
		
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.MOSSY_JURASSIC_STONE), BlockInit.MOSSY_JURASSIC_STONE_SLAB).unlocks("has_item", has(BlockInit.MOSSY_JURASSIC_STONE)).save(recipe, ModUtil.rL("jurassic_mossy_stone_slab_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.MOSSY_JURASSIC_STONE), BlockInit.MOSSY_JURASSIC_STONE_STAIRS).unlocks("has_item", has(BlockInit.MOSSY_JURASSIC_STONE)).save(recipe, ModUtil.rL("jurassic_mossy_stone_stairs_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.MOSSY_JURASSIC_STONE), BlockInit.MOSSY_JURASSIC_STONE_BRICKS).unlocks("has_item", has(BlockInit.MOSSY_JURASSIC_STONE)).save(recipe, ModUtil.rL("jurassic_mossy_stone_bricks_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.MOSSY_JURASSIC_STONE), BlockInit.MOSSY_JURASSIC_STONE_BRICK_SLAB).unlocks("has_item", has(BlockInit.MOSSY_JURASSIC_STONE)).save(recipe, ModUtil.rL("jurassic_mossy_stone_brick_slab_from_stone_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.MOSSY_JURASSIC_STONE), BlockInit.MOSSY_JURASSIC_STONE_BRICK_STAIRS).unlocks("has_item", has(BlockInit.MOSSY_JURASSIC_STONE)).save(recipe, ModUtil.rL("jurassic_mossy_stone_brick_stairs_from_stone_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.MOSSY_JURASSIC_STONE), BlockInit.MOSSY_JURASSIC_STONE_BRICK_WALL).unlocks("has_item", has(BlockInit.MOSSY_JURASSIC_STONE)).save(recipe, ModUtil.rL("jurassic_mossy_stone_brick_wall_from_stone_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.MOSSY_JURASSIC_STONE_BRICKS), BlockInit.MOSSY_JURASSIC_STONE_BRICK_SLAB).unlocks("has_item", has(BlockInit.MOSSY_JURASSIC_STONE_BRICKS)).save(recipe, ModUtil.rL("jurassic_mossy_stone_brick_slab_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.MOSSY_JURASSIC_STONE_BRICKS), BlockInit.MOSSY_JURASSIC_STONE_BRICK_STAIRS).unlocks("has_item", has(BlockInit.MOSSY_JURASSIC_STONE_BRICKS)).save(recipe, ModUtil.rL("jurassic_mossy_stone_brick_stairs_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.MOSSY_JURASSIC_STONE_BRICKS), BlockInit.MOSSY_JURASSIC_STONE_BRICK_WALL).unlocks("has_item", has(BlockInit.MOSSY_JURASSIC_STONE_BRICKS)).save(recipe, ModUtil.rL("jurassic_mossy_stone_brick_wall_from_stonecutting"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.MOSSY_JURASSIC_COBBLESTONE), BlockInit.MOSSY_JURASSIC_COBBLESTONE_SLAB).unlocks("has_item", has(BlockInit.MOSSY_JURASSIC_COBBLESTONE)).save(recipe, ModUtil.rL("jurassic_mossy_cobblestone_slab_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.MOSSY_JURASSIC_COBBLESTONE), BlockInit.MOSSY_JURASSIC_COBBLESTONE_STAIRS).unlocks("has_item", has(BlockInit.MOSSY_JURASSIC_COBBLESTONE)).save(recipe, ModUtil.rL("jurassic_mossy_cobblestone_stairs_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.MOSSY_JURASSIC_COBBLESTONE), BlockInit.MOSSY_JURASSIC_COBBLESTONE_WALL).unlocks("has_item", has(BlockInit.MOSSY_JURASSIC_COBBLESTONE)).save(recipe, ModUtil.rL("jurassic_mossy_cobblestone_wall_from_stonecutting"));

		slab(recipe, BlockInit.VOLCANIC_ROCK_SLAB, BlockInit.VOLCANIC_ROCK);
		stairs(recipe, BlockInit.VOLCANIC_ROCK_STAIRS, BlockInit.VOLCANIC_ROCK);
		wall(recipe, BlockInit.VOLCANIC_ROCK_WALL, BlockInit.VOLCANIC_ROCK);
		
		ShapedRecipeBuilder.shaped(BlockInit.POLISHED_VOLCANIC_ROCK, 4).define('#', BlockInit.VOLCANIC_ROCK).pattern("##").pattern("##").unlockedBy("has_item", has(BlockInit.VOLCANIC_ROCK)).save(recipe);

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.VOLCANIC_ROCK), BlockInit.VOLCANIC_ROCK_SLAB).unlocks("has_item", has(BlockInit.VOLCANIC_ROCK)).save(recipe, ModUtil.rL("volcanic_rock_slab_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.VOLCANIC_ROCK), BlockInit.VOLCANIC_ROCK_STAIRS).unlocks("has_item", has(BlockInit.VOLCANIC_ROCK)).save(recipe, ModUtil.rL("volcanic_rock_stairs_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.VOLCANIC_ROCK), BlockInit.VOLCANIC_ROCK_WALL).unlocks("has_item", has(BlockInit.VOLCANIC_ROCK)).save(recipe, ModUtil.rL("volcanic_rock_wall_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.VOLCANIC_ROCK), BlockInit.POLISHED_VOLCANIC_ROCK).unlocks("has_item", has(BlockInit.VOLCANIC_ROCK)).save(recipe, ModUtil.rL("polished_volcanic_rock_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.VOLCANIC_ROCK), BlockInit.POLISHED_VOLCANIC_ROCK_SLAB).unlocks("has_item", has(BlockInit.VOLCANIC_ROCK)).save(recipe, ModUtil.rL("polished_volcanic_rock_slab_from_stone_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.VOLCANIC_ROCK), BlockInit.POLISHED_VOLCANIC_ROCK_STAIRS).unlocks("has_item", has(BlockInit.VOLCANIC_ROCK)).save(recipe, ModUtil.rL("polished_volcanic_rock_stairs_from_stone_stonecutting"));
		
		slab(recipe, BlockInit.POLISHED_VOLCANIC_ROCK_SLAB, BlockInit.POLISHED_VOLCANIC_ROCK);
		stairs(recipe, BlockInit.POLISHED_VOLCANIC_ROCK_STAIRS, BlockInit.POLISHED_VOLCANIC_ROCK);

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.POLISHED_VOLCANIC_ROCK), BlockInit.POLISHED_VOLCANIC_ROCK_SLAB).unlocks("has_item", has(BlockInit.POLISHED_VOLCANIC_ROCK)).save(recipe, ModUtil.rL("polished_volcanic_rock_slab_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.POLISHED_VOLCANIC_ROCK), BlockInit.POLISHED_VOLCANIC_ROCK_STAIRS).unlocks("has_item", has(BlockInit.POLISHED_VOLCANIC_ROCK)).save(recipe, ModUtil.rL("polished_volcanic_rock_stairs_from_stonecutting"));
	
		pane(recipe, BlockInit.SHADED_GLASS_PANE, BlockInit.SHADED_GLASS);
		
		ShapedRecipeBuilder.shaped(BlockInit.LIGHT_CONCRETE, 8).define('#', Items.STONE).define('$', Items.IRON_INGOT).pattern("#$#").pattern("#$#").pattern("#$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);
		slab(recipe, BlockInit.LIGHT_CONCRETE_SLAB, BlockInit.LIGHT_CONCRETE);
		stairs(recipe, BlockInit.LIGHT_CONCRETE_STAIRS, BlockInit.LIGHT_CONCRETE);
		wall(recipe, BlockInit.LIGHT_CONCRETE_WALL, BlockInit.LIGHT_CONCRETE);		
		ShapedRecipeBuilder.shaped(BlockInit.LIGHT_CONCRETE_PRESSURE_PLATE).define('#', BlockInit.LIGHT_CONCRETE).pattern("##").unlockedBy("has_item", has(BlockInit.LIGHT_CONCRETE)).save(recipe);

		ShapedRecipeBuilder.shaped(BlockInit.POLISHED_LIGHT_CONCRETE, 4).define('#', BlockInit.LIGHT_CONCRETE).pattern("##").pattern("##").unlockedBy("has_item", has(BlockInit.LIGHT_CONCRETE)).save(recipe);
		slab(recipe, BlockInit.POLISHED_LIGHT_CONCRETE_SLAB, BlockInit.POLISHED_LIGHT_CONCRETE);
		stairs(recipe, BlockInit.POLISHED_LIGHT_CONCRETE_STAIRS, BlockInit.POLISHED_LIGHT_CONCRETE);
		
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.LIGHT_CONCRETE), BlockInit.LIGHT_CONCRETE_SLAB).unlocks("has_item", has(BlockInit.LIGHT_CONCRETE)).save(recipe, ModUtil.rL("light_concrete_slab_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.LIGHT_CONCRETE), BlockInit.LIGHT_CONCRETE_STAIRS).unlocks("has_item", has(BlockInit.LIGHT_CONCRETE)).save(recipe, ModUtil.rL("light_concrete_stairs_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.LIGHT_CONCRETE), BlockInit.LIGHT_CONCRETE_WALL).unlocks("has_item", has(BlockInit.LIGHT_CONCRETE)).save(recipe, ModUtil.rL("light_concrete_wall_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.LIGHT_CONCRETE), BlockInit.POLISHED_LIGHT_CONCRETE).unlocks("has_item", has(BlockInit.LIGHT_CONCRETE)).save(recipe, ModUtil.rL("polished_light_concrete_from_stone_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.LIGHT_CONCRETE), BlockInit.POLISHED_LIGHT_CONCRETE_SLAB).unlocks("has_item", has(BlockInit.LIGHT_CONCRETE)).save(recipe, ModUtil.rL("polished_light_concrete_slab_from_stone_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.LIGHT_CONCRETE), BlockInit.POLISHED_LIGHT_CONCRETE_STAIRS).unlocks("has_item", has(BlockInit.LIGHT_CONCRETE)).save(recipe, ModUtil.rL("polished_light_concrete_stairs_from_stone_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.POLISHED_LIGHT_CONCRETE), BlockInit.POLISHED_LIGHT_CONCRETE_SLAB).unlocks("has_item", has(BlockInit.POLISHED_LIGHT_CONCRETE)).save(recipe, ModUtil.rL("polished_light_concrete_slab_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.POLISHED_LIGHT_CONCRETE), BlockInit.POLISHED_LIGHT_CONCRETE_STAIRS).unlocks("has_item", has(BlockInit.POLISHED_LIGHT_CONCRETE)).save(recipe, ModUtil.rL("polished_light_concrete_stairs_from_stonecutting"));
		
		ShapedRecipeBuilder.shaped(BlockInit.WOODEN_PLANKS, 8).define('#', ItemTags.PLANKS).define('$', Items.IRON_INGOT).pattern("#$#").pattern("#$#").pattern("#$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);
		woodenSlab(recipe, BlockInit.WOODEN_PLANKS_SLAB, BlockInit.WOODEN_PLANKS);
		woodenStairs(recipe, BlockInit.WOODEN_PLANKS_STAIRS, BlockInit.WOODEN_PLANKS);
		woodenFence(recipe, BlockInit.WOODEN_PLANKS_FENCE, BlockInit.WOODEN_PLANKS);		
		woodenFenceGate(recipe, BlockInit.WOODEN_PLANKS_FENCE_GATE, BlockInit.WOODEN_PLANKS);
		woodenPressurePlate(recipe, BlockInit.WOODEN_PLANKS_PRESSURE_PLATE, BlockInit.WOODEN_PLANKS);
		woodenButton(recipe, BlockInit.WOODEN_PLANKS_BUTTON, BlockInit.WOODEN_PLANKS);
		
		ShapedRecipeBuilder.shaped(BlockInit.METAL_FENCE, 32).define('#', Items.IRON_BLOCK).define('$', Items.IRON_INGOT).define('@', Items.RED_DYE).pattern("#$#").pattern("#@#").unlockedBy("has_item", has(Items.IRON_BLOCK)).save(recipe);
		
		ShapedRecipeBuilder.shaped(BlockInit.THATCH_BLOCK, 8).define('#', Items.WHEAT).pattern("##").pattern("##").unlockedBy("has_item", has(Items.WHEAT)).save(recipe);
		
		ShapedRecipeBuilder.shaped(BlockInit.OUTDOOR_TOILET_DOOR, 3).define('#', BlockInit.WOODEN_PLANKS).pattern("##").pattern("##").pattern("##").unlockedBy("has_item", has(BlockInit.WOODEN_PLANKS)).save(recipe);
		ShapedRecipeBuilder.shaped(BlockInit.VISITOR_CENTRE_DOOR, 3).define('#', ItemTags.PLANKS).define('$', Items.BLACK_STAINED_GLASS_PANE).pattern("#$").pattern("$#").pattern("##").unlockedBy("has_item", has(ItemTags.PLANKS)).save(recipe);
		ShapedRecipeBuilder.shaped(BlockInit.SECURITY_DOOR, 3).define('#', Items.IRON_INGOT).define('$', Items.IRON_BLOCK).pattern("##").pattern("#$").pattern("##").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		
		ShapedRecipeBuilder.shaped(BlockInit.DARK_CONCRETE, 8).define('#', Items.CYAN_TERRACOTTA).define('$', Items.IRON_INGOT).pattern("#$#").pattern("#$#").pattern("#$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);
		slab(recipe, BlockInit.DARK_CONCRETE_SLAB, BlockInit.DARK_CONCRETE);
		stairs(recipe, BlockInit.DARK_CONCRETE_STAIRS, BlockInit.DARK_CONCRETE);
		wall(recipe, BlockInit.DARK_CONCRETE_WALL, BlockInit.DARK_CONCRETE);		
		ShapedRecipeBuilder.shaped(BlockInit.DARK_CONCRETE_PRESSURE_PLATE).define('#', BlockInit.DARK_CONCRETE).pattern("##").unlockedBy("has_item", has(BlockInit.DARK_CONCRETE)).save(recipe);
		
		ShapedRecipeBuilder.shaped(BlockInit.POLISHED_DARK_CONCRETE, 4).define('#', BlockInit.DARK_CONCRETE).pattern("##").pattern("##").unlockedBy("has_item", has(BlockInit.DARK_CONCRETE)).save(recipe);
		slab(recipe, BlockInit.POLISHED_DARK_CONCRETE_SLAB, BlockInit.POLISHED_DARK_CONCRETE);
		stairs(recipe, BlockInit.POLISHED_DARK_CONCRETE_STAIRS, BlockInit.POLISHED_DARK_CONCRETE);
		
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.DARK_CONCRETE), BlockInit.DARK_CONCRETE_SLAB).unlocks("has_item", has(BlockInit.DARK_CONCRETE)).save(recipe, ModUtil.rL("dark_concrete_slab_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.DARK_CONCRETE), BlockInit.DARK_CONCRETE_STAIRS).unlocks("has_item", has(BlockInit.DARK_CONCRETE)).save(recipe, ModUtil.rL("dark_concrete_stairs_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.DARK_CONCRETE), BlockInit.DARK_CONCRETE_WALL).unlocks("has_item", has(BlockInit.DARK_CONCRETE)).save(recipe, ModUtil.rL("dark_concrete_wall_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.DARK_CONCRETE), BlockInit.POLISHED_DARK_CONCRETE).unlocks("has_item", has(BlockInit.DARK_CONCRETE)).save(recipe, ModUtil.rL("polished_dark_concrete_from_stone_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.DARK_CONCRETE), BlockInit.POLISHED_DARK_CONCRETE_SLAB).unlocks("has_item", has(BlockInit.DARK_CONCRETE)).save(recipe, ModUtil.rL("polished_dark_concrete_slab_from_stone_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.DARK_CONCRETE), BlockInit.POLISHED_DARK_CONCRETE_STAIRS).unlocks("has_item", has(BlockInit.DARK_CONCRETE)).save(recipe, ModUtil.rL("polished_dark_concrete_stairs_from_stone_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.POLISHED_DARK_CONCRETE), BlockInit.POLISHED_DARK_CONCRETE_SLAB).unlocks("has_item", has(BlockInit.POLISHED_DARK_CONCRETE)).save(recipe, ModUtil.rL("polished_dark_concrete_slab_from_stonecutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockInit.POLISHED_DARK_CONCRETE), BlockInit.POLISHED_DARK_CONCRETE_STAIRS).unlocks("has_item", has(BlockInit.POLISHED_DARK_CONCRETE)).save(recipe, ModUtil.rL("polished_dark_concrete_stairs_from_stonecutting"));

		ShapedRecipeBuilder.shaped(BlockInit.REFINED_WOODEN_PLANKS, 8).define('#', BlockInit.WOODEN_PLANKS).define('$', Items.HONEYCOMB).pattern("###").pattern("#$#").pattern("###").unlockedBy("has_item", has(Items.HONEYCOMB)).save(recipe);
		woodenSlab(recipe, BlockInit.REFINED_WOODEN_PLANKS_SLAB, BlockInit.REFINED_WOODEN_PLANKS);
		woodenStairs(recipe, BlockInit.REFINED_WOODEN_PLANKS_STAIRS, BlockInit.REFINED_WOODEN_PLANKS);
		woodenFence(recipe, BlockInit.REFINED_WOODEN_PLANKS_FENCE, BlockInit.REFINED_WOODEN_PLANKS);		
		woodenFenceGate(recipe, BlockInit.REFINED_WOODEN_PLANKS_FENCE_GATE, BlockInit.REFINED_WOODEN_PLANKS);
		woodenPressurePlate(recipe, BlockInit.REFINED_WOODEN_PLANKS_PRESSURE_PLATE, BlockInit.REFINED_WOODEN_PLANKS);
		woodenButton(recipe, BlockInit.REFINED_WOODEN_PLANKS_BUTTON, BlockInit.REFINED_WOODEN_PLANKS);	
		
		ShapedRecipeBuilder.shaped(BlockInit.TILE, 4).define('#', BlockInit.WOODEN_PLANKS).define('$', BlockInit.REFINED_WOODEN_PLANKS).pattern("#$").pattern("$#").unlockedBy("has_item", has(BlockInit.WOODEN_PLANKS)).save(recipe);		
		woodenSlab(recipe, BlockInit.TILE_SLAB, BlockInit.TILE);
		woodenStairs(recipe, BlockInit.TILE_STAIRS, BlockInit.TILE);

		ShapedRecipeBuilder.shaped(BlockInit.CLEAR_GLASS, 4).define('#', Items.GLASS).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.BLACK_GLASS, 4).define('#', Items.BLACK_STAINED_GLASS).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.BLUE_GLASS, 4).define('#', Items.BLUE_STAINED_GLASS).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.BROWN_GLASS, 4).define('#', Items.BROWN_STAINED_GLASS).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.CYAN_GLASS, 4).define('#', Items.CYAN_STAINED_GLASS).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.GREY_GLASS, 4).define('#', Items.GRAY_STAINED_GLASS).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.GREEN_GLASS, 4).define('#', Items.GREEN_STAINED_GLASS).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.LIGHT_BLUE_GLASS, 4).define('#', Items.LIGHT_BLUE_STAINED_GLASS).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.LIGHT_GREY_GLASS, 4).define('#', Items.LIGHT_GRAY_STAINED_GLASS).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.LIME_GLASS, 4).define('#', Items.LIME_STAINED_GLASS).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.MAGENTA_GLASS, 4).define('#', Items.MAGENTA_STAINED_GLASS).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.ORANGE_GLASS, 4).define('#', Items.ORANGE_STAINED_GLASS).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.PINK_GLASS, 4).define('#', Items.PINK_STAINED_GLASS).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.PURPLE_GLASS, 4).define('#', Items.PURPLE_STAINED_GLASS).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.RED_GLASS, 4).define('#', Items.RED_STAINED_GLASS).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.WHITE_GLASS, 4).define('#', Items.WHITE_STAINED_GLASS).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.YELLOW_GLASS, 4).define('#', Items.YELLOW_STAINED_GLASS).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);
		
		ShapedRecipeBuilder.shaped(BlockInit.CLEAR_GLASS_PANE, 16).define('#', BlockInit.CLEAR_GLASS).pattern("###").pattern("###").unlockedBy("has_item", has(BlockInit.CLEAR_GLASS)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.BLACK_GLASS_PANE, 16).define('#', BlockInit.BLACK_GLASS).pattern("###").pattern("###").unlockedBy("has_item", has(BlockInit.BLACK_GLASS)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.BLUE_GLASS_PANE, 16).define('#', BlockInit.BLUE_GLASS).pattern("###").pattern("###").unlockedBy("has_item", has(BlockInit.BLUE_GLASS)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.BROWN_GLASS_PANE, 16).define('#', BlockInit.BROWN_GLASS).pattern("###").pattern("###").unlockedBy("has_item", has(BlockInit.BROWN_GLASS)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.CYAN_GLASS_PANE, 16).define('#', BlockInit.CYAN_GLASS).pattern("###").pattern("###").unlockedBy("has_item", has(BlockInit.CYAN_GLASS)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.GREY_GLASS_PANE, 16).define('#', BlockInit.GREY_GLASS).pattern("###").pattern("###").unlockedBy("has_item", has(BlockInit.GREY_GLASS)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.GREEN_GLASS_PANE, 16).define('#', BlockInit.GREEN_GLASS).pattern("###").pattern("###").unlockedBy("has_item", has(BlockInit.GREEN_GLASS)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.LIGHT_BLUE_GLASS_PANE, 16).define('#', BlockInit.LIGHT_BLUE_GLASS).pattern("###").pattern("###").unlockedBy("has_item", has(BlockInit.LIGHT_BLUE_GLASS)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.LIGHT_GREY_GLASS_PANE, 16).define('#', BlockInit.LIGHT_GREY_GLASS).pattern("###").pattern("###").unlockedBy("has_item", has(BlockInit.LIGHT_GREY_GLASS)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.LIME_GLASS_PANE, 16).define('#', BlockInit.LIME_GLASS).pattern("###").pattern("###").unlockedBy("has_item", has(BlockInit.LIME_GLASS)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.MAGENTA_GLASS_PANE, 16).define('#', BlockInit.MAGENTA_GLASS).pattern("###").pattern("###").unlockedBy("has_item", has(BlockInit.MAGENTA_GLASS)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.ORANGE_GLASS_PANE, 16).define('#', BlockInit.ORANGE_GLASS).pattern("###").pattern("###").unlockedBy("has_item", has(BlockInit.ORANGE_GLASS)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.PINK_GLASS_PANE, 16).define('#', BlockInit.PINK_GLASS).pattern("###").pattern("###").unlockedBy("has_item", has(BlockInit.PINK_GLASS)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.PURPLE_GLASS_PANE, 16).define('#', BlockInit.PURPLE_GLASS).pattern("###").pattern("###").unlockedBy("has_item", has(BlockInit.PURPLE_GLASS)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.RED_GLASS_PANE, 16).define('#', BlockInit.RED_GLASS).pattern("###").pattern("###").unlockedBy("has_item", has(BlockInit.RED_GLASS)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.WHITE_GLASS_PANE, 16).define('#', BlockInit.WHITE_GLASS).pattern("###").pattern("###").unlockedBy("has_item", has(BlockInit.WHITE_GLASS)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.YELLOW_GLASS_PANE, 16).define('#', BlockInit.YELLOW_GLASS).pattern("###").pattern("###").unlockedBy("has_item", has(BlockInit.YELLOW_GLASS)).save(recipe);

		ShapedRecipeBuilder.shaped(BlockInit.BLACK_DECORATION_BLOCK, 4).define('#', Items.BLACK_CONCRETE).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.BLUE_DECORATION_BLOCK, 4).define('#', Items.BLUE_CONCRETE).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.BROWN_DECORATION_BLOCK, 4).define('#', Items.BROWN_CONCRETE).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.CYAN_DECORATION_BLOCK, 4).define('#', Items.CYAN_CONCRETE).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.GREY_DECORATION_BLOCK, 4).define('#', Items.GRAY_CONCRETE).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.GREEN_DECORATION_BLOCK, 4).define('#', Items.GREEN_CONCRETE).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.LIGHT_BLUE_DECORATION_BLOCK, 4).define('#', Items.LIGHT_BLUE_CONCRETE).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.LIGHT_GREY_DECORATION_BLOCK, 4).define('#', Items.LIGHT_GRAY_CONCRETE).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.LIME_DECORATION_BLOCK, 4).define('#', Items.LIME_CONCRETE).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.MAGENTA_DECORATION_BLOCK, 4).define('#', Items.MAGENTA_CONCRETE).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.ORANGE_DECORATION_BLOCK, 4).define('#', Items.ORANGE_CONCRETE).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.PINK_DECORATION_BLOCK, 4).define('#', Items.PINK_CONCRETE).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.PURPLE_DECORATION_BLOCK, 4).define('#', Items.PURPLE_CONCRETE).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.RED_DECORATION_BLOCK, 4).define('#', Items.RED_CONCRETE).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.WHITE_DECORATION_BLOCK, 4).define('#', Items.WHITE_CONCRETE).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);		
		ShapedRecipeBuilder.shaped(BlockInit.YELLOW_DECORATION_BLOCK, 4).define('#', Items.YELLOW_CONCRETE).define('$', Items.IRON_INGOT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);
		
		ShapedRecipeBuilder.shaped(BlockInit.GLASS_SHOP_DOOR, 3).define('#', Items.GLASS).define('$', Items.IRON_INGOT).pattern("##").pattern("$$").pattern("##").unlockedBy("has_item", has(Items.GLASS)).save(recipe);
		ShapedRecipeBuilder.shaped(BlockInit.BACK_DOOR, 3).define('#', Items.IRON_INGOT).define('$', Items.CYAN_TERRACOTTA).pattern("#$").pattern("##").pattern("##").unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe);
		ShapedRecipeBuilder.shaped(BlockInit.INNOVATION_CENTRE_DOOR, 3).define('#', Items.STONE).define('$', ModItemTags.FOSSILS).pattern("##").pattern("#$").pattern("##").unlockedBy("has_item", has(Items.STONE)).save(recipe);

		slab(recipe, BlockInit.RAISED_PAVEMENT, BlockInit.PAVEMENT);
		stairs(recipe, BlockInit.PAVEMENT_SLOPE, BlockInit.PAVEMENT);
		
		slab(recipe, BlockInit.RAISED_DIRT_ROAD, BlockInit.DIRT_ROAD);
		slab(recipe, BlockInit.RAISED_GRAVEL_ROAD, BlockInit.GRAVEL_ROAD);
		slab(recipe, BlockInit.RAISED_PAVED_ROAD, BlockInit.PAVED_ROAD);
	
		ShapedRecipeBuilder.shaped(BlockInit.DIRT_ROAD, 4).define('#', Items.DIRT).define('$', Items.COARSE_DIRT).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.DIRT)).save(recipe);
		ShapedRecipeBuilder.shaped(BlockInit.GRAVEL_ROAD, 4).define('#', Items.GRAVEL).define('$', Items.LIGHT_GRAY_CONCRETE_POWDER).pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.GRAVEL)).save(recipe);
		ShapedRecipeBuilder.shaped(BlockInit.PAVED_ROAD, 4).define('#', Items.GRAVEL).define('$', Items.LIGHT_GRAY_CONCRETE_POWDER).define('@', Items.WATER_BUCKET).pattern("@ ").pattern("#$").pattern("$#").unlockedBy("has_item", has(Items.WATER_BUCKET)).save(recipe);
		
		//Cooking		
		CookingRecipeBuilder.smelting(Ingredient.of(ItemInit.FERN_LEAVES), ItemInit.COOKED_FERN_LEAVES, 0.35F, 200).unlockedBy("has_item", has(ItemInit.FERN_LEAVES)).save(recipe, ModUtil.rL("cooked_fern_leaves_from_smelting"));
		CookingRecipeBuilder.smelting(Ingredient.of(BlockInit.COPPER_ORE), ItemInit.COPPER_INGOT, 0.7F, 200).unlockedBy("has_item", has(BlockInit.COPPER_ORE)).save(recipe, ModUtil.rL("copper_ingot_from_smelting"));
		CookingRecipeBuilder.smelting(Ingredient.of(BlockInit.BASALT_DIAMOND_ORE), Items.DIAMOND, 0.7F, 200).unlockedBy("has_item", has(BlockInit.BASALT_DIAMOND_ORE)).save(recipe, ModUtil.rL("diamond_from_basalt_diamond_ore_smelting"));

		CookingRecipeBuilder.smelting(Ingredient.of(BlockInit.PERMIAN_COAL_ORE), Items.COAL, 0.7F, 200).unlockedBy("has_item", has(BlockInit.PERMIAN_COAL_ORE)).save(recipe, ModUtil.rL("coal_from_permian_smelting"));
		CookingRecipeBuilder.smelting(Ingredient.of(BlockInit.PERMIAN_COPPER_ORE), ItemInit.COPPER_INGOT, 0.7F, 200).unlockedBy("has_item", has(BlockInit.PERMIAN_COPPER_ORE)).save(recipe, ModUtil.rL("copper_from_permian_smelting"));
		CookingRecipeBuilder.smelting(Ingredient.of(BlockInit.PERMIAN_DIAMOND_ORE), Items.DIAMOND, 0.7F, 200).unlockedBy("has_item", has(BlockInit.PERMIAN_DIAMOND_ORE)).save(recipe, ModUtil.rL("diamond_from_permian_smelting"));
		CookingRecipeBuilder.smelting(Ingredient.of(BlockInit.PERMIAN_EMERALD_ORE), Items.EMERALD, 0.7F, 200).unlockedBy("has_item", has(BlockInit.PERMIAN_EMERALD_ORE)).save(recipe, ModUtil.rL("emerald_from_permian_smelting"));
		CookingRecipeBuilder.smelting(Ingredient.of(BlockInit.PERMIAN_GOLD_ORE), Items.GOLD_INGOT, 0.7F, 200).unlockedBy("has_item", has(BlockInit.PERMIAN_GOLD_ORE)).save(recipe, ModUtil.rL("gold_from_permian_smelting"));
		CookingRecipeBuilder.smelting(Ingredient.of(BlockInit.PERMIAN_IRON_ORE), Items.IRON_INGOT, 0.7F, 200).unlockedBy("has_item", has(BlockInit.PERMIAN_IRON_ORE)).save(recipe, ModUtil.rL("iron_from_permian_smelting"));
		CookingRecipeBuilder.smelting(Ingredient.of(BlockInit.PERMIAN_LAPIS_ORE), Items.LAPIS_LAZULI, 0.7F, 200).unlockedBy("has_item", has(BlockInit.PERMIAN_LAPIS_ORE)).save(recipe, ModUtil.rL("lapis_from_permian_smelting"));
		CookingRecipeBuilder.smelting(Ingredient.of(BlockInit.PERMIAN_REDSTONE_ORE), Items.REDSTONE, 0.7F, 200).unlockedBy("has_item", has(BlockInit.PERMIAN_REDSTONE_ORE)).save(recipe, ModUtil.rL("redstone_from_permian_smelting"));

		CookingRecipeBuilder.smelting(Ingredient.of(BlockInit.JURASSIC_COAL_ORE), Items.COAL, 0.7F, 200).unlockedBy("has_item", has(BlockInit.JURASSIC_COAL_ORE)).save(recipe, ModUtil.rL("coal_from_jurassic_smelting"));
		CookingRecipeBuilder.smelting(Ingredient.of(BlockInit.JURASSIC_COPPER_ORE), ItemInit.COPPER_INGOT, 0.7F, 200).unlockedBy("has_item", has(BlockInit.JURASSIC_COPPER_ORE)).save(recipe, ModUtil.rL("copper_from_jurassic_smelting"));
		CookingRecipeBuilder.smelting(Ingredient.of(BlockInit.JURASSIC_DIAMOND_ORE), Items.DIAMOND, 0.7F, 200).unlockedBy("has_item", has(BlockInit.JURASSIC_DIAMOND_ORE)).save(recipe, ModUtil.rL("diamond_from_jurassic_smelting"));
		CookingRecipeBuilder.smelting(Ingredient.of(BlockInit.JURASSIC_EMERALD_ORE), Items.EMERALD, 0.7F, 200).unlockedBy("has_item", has(BlockInit.JURASSIC_EMERALD_ORE)).save(recipe, ModUtil.rL("emerald_from_jurassic_smelting"));
		CookingRecipeBuilder.smelting(Ingredient.of(BlockInit.JURASSIC_GOLD_ORE), Items.GOLD_INGOT, 0.7F, 200).unlockedBy("has_item", has(BlockInit.JURASSIC_GOLD_ORE)).save(recipe, ModUtil.rL("gold_from_jurassic_smelting"));
		CookingRecipeBuilder.smelting(Ingredient.of(BlockInit.JURASSIC_IRON_ORE), Items.IRON_INGOT, 0.7F, 200).unlockedBy("has_item", has(BlockInit.JURASSIC_IRON_ORE)).save(recipe, ModUtil.rL("iron_from_jurassic_smelting"));
		CookingRecipeBuilder.smelting(Ingredient.of(BlockInit.JURASSIC_LAPIS_ORE), Items.LAPIS_LAZULI, 0.7F, 200).unlockedBy("has_item", has(BlockInit.JURASSIC_LAPIS_ORE)).save(recipe, ModUtil.rL("lapis_from_jurassic_smelting"));
		CookingRecipeBuilder.smelting(Ingredient.of(BlockInit.JURASSIC_REDSTONE_ORE), Items.REDSTONE, 0.7F, 200).unlockedBy("has_item", has(BlockInit.JURASSIC_REDSTONE_ORE)).save(recipe, ModUtil.rL("redstone_from_jurassic_smelting"));

		CookingRecipeBuilder.smelting(Ingredient.of(BlockInit.VOLCANIC_ASH), BlockInit.SHADED_GLASS, 0.7F, 200).unlockedBy("has_item", has(BlockInit.VOLCANIC_ASH)).save(recipe, ModUtil.rL("shadded_glass"));

		//Blasting
		CookingRecipeBuilder.blasting(Ingredient.of(BlockInit.COPPER_ORE), ItemInit.COPPER_INGOT, 0.7F, 100).unlockedBy("has_item", has(BlockInit.COPPER_ORE)).save(recipe, ModUtil.rL("copper_ingot_from_blasting"));
		CookingRecipeBuilder.blasting(Ingredient.of(BlockInit.BASALT_DIAMOND_ORE), Items.DIAMOND, 0.7F, 100).unlockedBy("has_item", has(BlockInit.BASALT_DIAMOND_ORE)).save(recipe, ModUtil.rL("diamond_from_basalt_diamond_ore_blasting"));

		CookingRecipeBuilder.blasting(Ingredient.of(BlockInit.PERMIAN_COAL_ORE), Items.COAL, 0.7F, 100).unlockedBy("has_item", has(BlockInit.PERMIAN_COAL_ORE)).save(recipe, ModUtil.rL("coal_from_permian_blasting"));
		CookingRecipeBuilder.blasting(Ingredient.of(BlockInit.PERMIAN_COPPER_ORE), ItemInit.COPPER_INGOT, 0.7F, 100).unlockedBy("has_item", has(BlockInit.PERMIAN_COPPER_ORE)).save(recipe, ModUtil.rL("copper_from_permian_blasting"));
		CookingRecipeBuilder.blasting(Ingredient.of(BlockInit.PERMIAN_DIAMOND_ORE), Items.DIAMOND, 0.7F, 100).unlockedBy("has_item", has(BlockInit.PERMIAN_DIAMOND_ORE)).save(recipe, ModUtil.rL("diamond_from_permian_blasting"));
		CookingRecipeBuilder.blasting(Ingredient.of(BlockInit.PERMIAN_EMERALD_ORE), Items.EMERALD, 0.7F, 100).unlockedBy("has_item", has(BlockInit.PERMIAN_EMERALD_ORE)).save(recipe, ModUtil.rL("emerald_from_permian_blasting"));
		CookingRecipeBuilder.blasting(Ingredient.of(BlockInit.PERMIAN_GOLD_ORE), Items.GOLD_INGOT, 0.7F, 100).unlockedBy("has_item", has(BlockInit.PERMIAN_GOLD_ORE)).save(recipe, ModUtil.rL("gold_from_permian_blasting"));
		CookingRecipeBuilder.blasting(Ingredient.of(BlockInit.PERMIAN_IRON_ORE), Items.IRON_INGOT, 0.7F, 100).unlockedBy("has_item", has(BlockInit.PERMIAN_IRON_ORE)).save(recipe, ModUtil.rL("iron_from_permian_blasting"));
		CookingRecipeBuilder.blasting(Ingredient.of(BlockInit.PERMIAN_LAPIS_ORE), Items.LAPIS_LAZULI, 0.7F, 100).unlockedBy("has_item", has(BlockInit.PERMIAN_LAPIS_ORE)).save(recipe, ModUtil.rL("lapis_from_permian_blasting"));
		CookingRecipeBuilder.blasting(Ingredient.of(BlockInit.PERMIAN_REDSTONE_ORE), Items.REDSTONE, 0.7F, 100).unlockedBy("has_item", has(BlockInit.PERMIAN_REDSTONE_ORE)).save(recipe, ModUtil.rL("redstone_from_permian_blasting"));

		CookingRecipeBuilder.blasting(Ingredient.of(BlockInit.JURASSIC_COAL_ORE), Items.COAL, 0.7F, 100).unlockedBy("has_item", has(BlockInit.JURASSIC_COAL_ORE)).save(recipe, ModUtil.rL("coal_from_jurassic_blasting"));
		CookingRecipeBuilder.blasting(Ingredient.of(BlockInit.JURASSIC_COPPER_ORE), ItemInit.COPPER_INGOT, 0.7F, 100).unlockedBy("has_item", has(BlockInit.JURASSIC_COPPER_ORE)).save(recipe, ModUtil.rL("copper_from_jurassic_blasting"));
		CookingRecipeBuilder.blasting(Ingredient.of(BlockInit.JURASSIC_DIAMOND_ORE), Items.DIAMOND, 0.7F, 100).unlockedBy("has_item", has(BlockInit.JURASSIC_DIAMOND_ORE)).save(recipe, ModUtil.rL("diamond_from_jurassic_blasting"));
		CookingRecipeBuilder.blasting(Ingredient.of(BlockInit.JURASSIC_EMERALD_ORE), Items.EMERALD, 0.7F, 100).unlockedBy("has_item", has(BlockInit.JURASSIC_EMERALD_ORE)).save(recipe, ModUtil.rL("emerald_from_jurassic_blasting"));
		CookingRecipeBuilder.blasting(Ingredient.of(BlockInit.JURASSIC_GOLD_ORE), Items.GOLD_INGOT, 0.7F, 100).unlockedBy("has_item", has(BlockInit.JURASSIC_GOLD_ORE)).save(recipe, ModUtil.rL("gold_from_jurassic_blasting"));
		CookingRecipeBuilder.blasting(Ingredient.of(BlockInit.JURASSIC_IRON_ORE), Items.IRON_INGOT, 0.7F, 100).unlockedBy("has_item", has(BlockInit.JURASSIC_IRON_ORE)).save(recipe, ModUtil.rL("iron_from_jurassic_blasting"));
		CookingRecipeBuilder.blasting(Ingredient.of(BlockInit.JURASSIC_LAPIS_ORE), Items.LAPIS_LAZULI, 0.7F, 100).unlockedBy("has_item", has(BlockInit.JURASSIC_LAPIS_ORE)).save(recipe, ModUtil.rL("lapis_from_jurassic_blasting"));
		CookingRecipeBuilder.blasting(Ingredient.of(BlockInit.JURASSIC_REDSTONE_ORE), Items.REDSTONE, 0.7F, 100).unlockedBy("has_item", has(BlockInit.JURASSIC_REDSTONE_ORE)).save(recipe, ModUtil.rL("redstone_from_jurassic_blasting"));

		//Smoking
		CookingRecipeBuilder.cooking(Ingredient.of(ItemInit.FERN_LEAVES), ItemInit.COOKED_FERN_LEAVES, 0.35F, 100, IRecipeSerializer.SMOKING_RECIPE).unlockedBy("has_item", has(ItemInit.FERN_LEAVES)).save(recipe, ModUtil.rL("cooked_fern_leaves_from_smoking"));
		
		//Campfire Cooking
		CookingRecipeBuilder.cooking(Ingredient.of(ItemInit.FERN_LEAVES), ItemInit.COOKED_FERN_LEAVES, 0.35F, 600, IRecipeSerializer.CAMPFIRE_COOKING_RECIPE).unlockedBy("has_item", has(ItemInit.FERN_LEAVES)).save(recipe, ModUtil.rL("cooked_fern_leaves_from_campfire_cooking"));
		
		//Smithing
		smithing(recipe, ItemInit.DIAMOND_BRUSH, Items.NETHERITE_INGOT, ItemInit.NETHERITE_BRUSH);
		smithing(recipe, Items.NETHERITE_AXE, ItemInit.CHARGED_CRYSTAL_SCARAB_GEM, ItemInit.CRYSTAL_SCARAB_AXE);
		smithing(recipe, ItemInit.NETHERITE_BRUSH, ItemInit.CHARGED_CRYSTAL_SCARAB_GEM, ItemInit.CRYSTAL_SCARAB_BRUSH);
		smithing(recipe, Items.NETHERITE_HOE, ItemInit.CHARGED_CRYSTAL_SCARAB_GEM, ItemInit.CRYSTAL_SCARAB_HOE);
		smithing(recipe, Items.NETHERITE_PICKAXE, ItemInit.CHARGED_CRYSTAL_SCARAB_GEM, ItemInit.CRYSTAL_SCARAB_PICKAXE);
		smithing(recipe, Items.NETHERITE_SHOVEL, ItemInit.CHARGED_CRYSTAL_SCARAB_GEM, ItemInit.CRYSTAL_SCARAB_SHOVEL);
		smithing(recipe, Items.NETHERITE_SWORD, ItemInit.CHARGED_CRYSTAL_SCARAB_GEM, ItemInit.CRYSTAL_SCARAB_SWORD);
	}
	
	private static void smithing(Consumer<IFinishedRecipe> recipe, Item base, Item addition, Item result) 
	{
		SmithingRecipeBuilder.smithing(Ingredient.of(base), Ingredient.of(addition), result).unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT)).save(recipe, ModUtil.rL(Registry.ITEM.getKey(result.asItem()).getPath() + "_smithing"));
	}
	
	private static void planksFromLogs(Consumer<IFinishedRecipe> recipe, IItemProvider result, ITag<Item> logs) 
	{
		ShapelessRecipeBuilder.shapeless(result, 4).requires(logs).group("result").unlockedBy("has_logs", has(logs)).save(recipe);
	}
	
	private static void woodFromLogs(Consumer<IFinishedRecipe> recipe, IItemProvider result, IItemProvider logs) 
	{
		ShapedRecipeBuilder.shaped(result, 3).define('#', logs).pattern("##").pattern("##").group("bark").unlockedBy("has_log", has(logs)).save(recipe);
	}
	
	@SuppressWarnings("unused")
	private static void woodenBoat(Consumer<IFinishedRecipe> recipe, IItemProvider result, IItemProvider planks) 
	{
		ShapedRecipeBuilder.shaped(result).define('#', planks).pattern("# #").pattern("###").group("boat").unlockedBy("in_water", insideOf(Blocks.WATER)).save(recipe);
	}
	
	private static void woodenButton(Consumer<IFinishedRecipe> recipe, IItemProvider result, IItemProvider planks) 
	{
		ShapelessRecipeBuilder.shapeless(result).requires(planks).group("wooden_button").unlockedBy("has_result", has(planks)).save(recipe);
	}
	
	private static void woodenDoor(Consumer<IFinishedRecipe> recipe, IItemProvider result, IItemProvider planks) 
	{
		ShapedRecipeBuilder.shaped(result, 3).define('#', planks).pattern("##").pattern("##").pattern("##").group("wooden_door").unlockedBy("has_result", has(planks)).save(recipe);
	}
	
	private static void woodenFence(Consumer<IFinishedRecipe> recipe, IItemProvider result, IItemProvider planks) 
	{     
		ShapedRecipeBuilder.shaped(result, 3).define('#', Items.STICK).define('W', planks).pattern("W#W").pattern("W#W").group("wooden_fence").unlockedBy("has_result", has(planks)).save(recipe);
	}
	
	private static void woodenFenceGate(Consumer<IFinishedRecipe> recipe, IItemProvider result, IItemProvider planks) 
	{
		ShapedRecipeBuilder.shaped(result).define('#', Items.STICK).define('W', planks).pattern("#W#").pattern("#W#").group("wooden_fence_gate").unlockedBy("has_result", has(planks)).save(recipe);
	}
	
	private static void woodenPressurePlate(Consumer<IFinishedRecipe> recipe, IItemProvider result, IItemProvider planks) 
	{
		ShapedRecipeBuilder.shaped(result).define('#', planks).pattern("##").group("wooden_pressure_plate").unlockedBy("has_result", has(planks)).save(recipe);
	}
	
	private static void woodenSlab(Consumer<IFinishedRecipe> recipe, IItemProvider result, IItemProvider planks) 
	{
		ShapedRecipeBuilder.shaped(result, 6).define('#', planks).pattern("###").group("wooden_slab").unlockedBy("has_result", has(planks)).save(recipe);
	}
	
	private static void woodenStairs(Consumer<IFinishedRecipe> recipe, IItemProvider result, IItemProvider planks) 
	{
		ShapedRecipeBuilder.shaped(result, 4).define('#', planks).pattern("#  ").pattern("## ").pattern("###").group("wooden_stairs").unlockedBy("has_result", has(planks)).save(recipe);
	}
	
	private static void button(Consumer<IFinishedRecipe> recipe, IItemProvider result, IItemProvider stone) 
	{
		ShapelessRecipeBuilder.shapeless(result).requires(stone).unlockedBy("has_item", has(stone)).save(recipe);
	}
	
	private static void slab(Consumer<IFinishedRecipe> recipe, IItemProvider result, IItemProvider stone) 
	{
		ShapedRecipeBuilder.shaped(result, 6).define('#', stone).pattern("###").group("wooden_slab").unlockedBy("has_item", has(stone)).save(recipe);
	}
	
	private static void stairs(Consumer<IFinishedRecipe> recipe, IItemProvider result, IItemProvider stone) 
	{
		ShapedRecipeBuilder.shaped(result, 4).define('#', stone).pattern("#  ").pattern("## ").pattern("###").unlockedBy("has_item", has(stone)).save(recipe);
	}
	
	private static void wall(Consumer<IFinishedRecipe> recipe, IItemProvider result, IItemProvider stone) 
	{
		ShapedRecipeBuilder.shaped(result, 6).define('#', stone).pattern("###").pattern("###").unlockedBy("has_item", has(stone)).save(recipe);
	}
	
	private static void pane(Consumer<IFinishedRecipe> recipe, IItemProvider result, IItemProvider glass) 
	{
		ShapedRecipeBuilder.shaped(result, 16).define('#', glass).pattern("###").pattern("###").unlockedBy("has_item", has(glass)).save(recipe);
	}
	
	private static void woodenTrapdoor(Consumer<IFinishedRecipe> recipe, IItemProvider result, IItemProvider planks) 
	{
		ShapedRecipeBuilder.shaped(result, 2).define('#', planks).pattern("###").pattern("###").group("wooden_trapdoor").unlockedBy("has_result", has(planks)).save(recipe);
	}
	
	@SuppressWarnings("unused")
	private static void woodenSign(Consumer<IFinishedRecipe> recipe, IItemProvider result, IItemProvider planks) 
	{
		String s = Registry.ITEM.getKey(planks.asItem()).getPath();
		ShapedRecipeBuilder.shaped(result, 3).group("sign").define('#', planks).define('X', Items.STICK).pattern("###").pattern("###").pattern(" X ").unlockedBy("has_" + s, has(planks)).save(recipe);
	}
}
