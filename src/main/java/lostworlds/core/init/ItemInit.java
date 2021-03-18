package lostworlds.core.init;

import lostworlds.common.items.DiscItem;
import lostworlds.common.items.ModFishBucketItem;
import lostworlds.common.items.ModSpawnEggItem;
import lostworlds.common.items.WetPaperItem;
import lostworlds.common.tools.BrushItem;
import lostworlds.core.ModItemGroup;
import lostworlds.core.util.enums.ModItemTeir;
import lostworlds.core.util.registry.ModRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Rarity;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.fml.RegistryObject;

public class ItemInit 
{
	//Items
	//Brush
	public static final RegistryObject<Item> BRUSH = ModRegistry.ITEM_REGISTRY.register("brush", () -> new BrushItem(ModItemTeir.BRUSH, 1.5F, -3.0F, group()));
	
	//Plaster
	public static final RegistryObject<Item> WET_PAPER = registerClassItem("wet_paper", new WetPaperItem(group()));

	//Procompsognathus triassicus
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_BONE = registerBone("procompsognathus");
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_DNA = registerDNA("procompsognathus");
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_EGG = registerEgg("procompsognathus");
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_BABY = registerBabyDino("procompsognathus");
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_MEAT = registerMeat("procompsognathus", FoodInit.RAW_PROCOMPSOGNATHUS_MEAT);
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_COOKED_MEAT = registerCookedMeat("procompsognathus", FoodInit.COOKED_PROCOMPSOGNATHUS_MEAT);
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_SPAWN_EGG = registerSpawnEgg("procompsognathus", () -> EntityInit.PROCOMPSOGNATHUS_TRIASSICUS_ENTITY.get(), 0x125611, 0x143025, group());
	
	//Palaeoniscum
	public static final RegistryObject<Item> PALAEONISCUM_SPAWN_EGG = registerSpawnEgg("palaeoniscum", () -> EntityInit.PALAEONISCUM_FREISLEBENI_ENTITY.get(), 0x1e2f4f, 0x2b1838, group());
	public static final RegistryObject<Item> PALAEONISCUM_BUCKET = registerEntityBucket("palaeoniscum", () -> EntityInit.PALAEONISCUM_FREISLEBENI_ENTITY.get(), Fluids.WATER, group());
	
	//Copper
	public static final RegistryObject<Item> COPPER_INGOT = registerItem("copper_ingot", group());
	public static final RegistryObject<Item> COPPER_NUGGET = registerItem("copper_nugget", group());
	
	//Oil and Plastic Stuff
	public static final RegistryObject<Item> OIL_BUCKET = registerItem("oil_bucket", group().maxStackSize(1));
	public static final RegistryObject<Item> OIL_RESIN_BUCKET = registerItem("oil_resin_bucket", group().maxStackSize(1));
	public static final RegistryObject<Item> MOLTEN_PLASTIC_BUCKET = registerItem("molten_plastic_bucket", group().maxStackSize(1));
	
	//Electronics
	
	
	//Music
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> JP_MUSIC_DISC = registerClassItem("jp_music_disc", new MusicDiscItem(15, SoundInit.LAZY_JP_MUSIC.get(), group().maxStackSize(1).rarity(Rarity.RARE)));
	
	//Storage
	public static final RegistryObject<Item> DISC = registerClassItem("disc", new DiscItem(group().maxStackSize(1)));
		
	//Crystal Scarab	
	public static final RegistryObject<Item> BROKEN_CRYSTAL_SCARAB_GEM = registerItem("broken_crystal_scarab_gem", group().rarity(Rarity.RARE));
	public static final RegistryObject<Item> CRYSTAL_SCARAB_GEM = registerItem("crystal_scarab_gem", group().rarity(Rarity.EPIC));
	
	//Crystal Scarab Tools
	public static final RegistryObject<Item> CRYSTAL_SCARAB_SWORD = registerClassItem("crystal_scarab_sword", new SwordItem(ModItemTeir.SCARAB, 50, -2.4F, group().rarity(Rarity.EPIC)));
	public static final RegistryObject<Item> CRYSTAL_SCARAB_SHOVEL = registerClassItem("crystal_scarab_shovel", new ShovelItem(ModItemTeir.SCARAB, 12.0F, -3.0F, group().rarity(Rarity.EPIC)));
	public static final RegistryObject<Item> CRYSTAL_SCARAB_PICKAXE = registerClassItem("crystal_scarab_pickaxe", new PickaxeItem(ModItemTeir.SCARAB, 32, -2.8F, group().rarity(Rarity.EPIC)));
	public static final RegistryObject<Item> CRYSTAL_SCARAB_AXE = registerClassItem("crystal_scarab_axe", new AxeItem(ModItemTeir.SCARAB, 70.0F, -3.2F, group().rarity(Rarity.EPIC)));
	public static final RegistryObject<Item> CRYSTAL_SCARAB_HOE = registerClassItem("crystal_scarab_hoe", new HoeItem(ModItemTeir.SCARAB, 10, -3.0F, group().rarity(Rarity.EPIC)));
	
	//Blocks
	//Copper
	public static final RegistryObject<BlockItem> COPPER_ORE = ModRegistry.ITEM_REGISTRY.register("copper_ore", () -> new BlockItem(BlockInit.COPPER_ORE.get(), group()));
	
	//Fossil
	public static final RegistryObject<BlockItem> STONE_FOSSIL = ModRegistry.ITEM_REGISTRY.register("stone_fossil", () -> new BlockItem(BlockInit.STONE_FOSSIL.get(), group()));
	public static final RegistryObject<BlockItem> EXPOSED_STONE_FOSSIL = ModRegistry.ITEM_REGISTRY.register("exposed_stone_fossil", () -> new BlockItem(BlockInit.EXPOSED_STONE_FOSSIL.get(), group()));
	public static final RegistryObject<BlockItem> PLASTERED_STONE_FOSSIL = ModRegistry.ITEM_REGISTRY.register("plastered_stone_fossil", () -> new BlockItem(BlockInit.PLASTERED_STONE_FOSSIL.get(), group()));
	
	//Volcanic Stuff
	public static final RegistryObject<BlockItem> VOLCANIC_ROCK = ModRegistry.ITEM_REGISTRY.register("volcanic_rock", () -> new BlockItem(BlockInit.VOLCANIC_ROCK.get(), group()));	
	
	//Light Concrete
	public static final RegistryObject<BlockItem> LIGHT_CONCRETE =  ModRegistry.ITEM_REGISTRY.register("light_concrete", () -> new BlockItem(BlockInit.LIGHT_CONCRETE.get(), group()));
	public static final RegistryObject<BlockItem> LIGHT_CONCRETE_STAIRS =  ModRegistry.ITEM_REGISTRY.register("light_concrete_stairs", () -> new BlockItem(BlockInit.LIGHT_CONCRETE_STAIRS.get(), group()));
	public static final RegistryObject<BlockItem> LIGHT_CONCRETE_SLAB =  ModRegistry.ITEM_REGISTRY.register("light_concrete_slab", () -> new BlockItem(BlockInit.LIGHT_CONCRETE_SLAB.get(), group()));
	public static final RegistryObject<BlockItem> LIGHT_CONCRETE_WALL =  ModRegistry.ITEM_REGISTRY.register("light_concrete_wall", () -> new BlockItem(BlockInit.LIGHT_CONCRETE_WALL.get(), group()));
	public static final RegistryObject<BlockItem> LIGHT_CONCRETE_PRESSURE_PLATE = ModRegistry.ITEM_REGISTRY.register("light_concrete_pressure_plate", () -> new BlockItem(BlockInit.LIGHT_CONCRETE_PRESSURE_PLATE.get(), group()));
	public static final RegistryObject<BlockItem> LIGHT_CONCRETE_BUTTON =  ModRegistry.ITEM_REGISTRY.register("light_concrete_button", () -> new BlockItem(BlockInit.LIGHT_CONCRETE_BUTTON.get(), group()));
	
	//Polished Light Concrete
	public static final RegistryObject<BlockItem> POLISHED_LIGHT_CONCRETE =  ModRegistry.ITEM_REGISTRY.register("polished_light_concrete", () -> new BlockItem(BlockInit.POLISHED_LIGHT_CONCRETE.get(), group()));
	public static final RegistryObject<BlockItem> POLISHED_LIGHT_CONCRETE_STAIRS =  ModRegistry.ITEM_REGISTRY.register("polished_light_concrete_stairs", () -> new BlockItem(BlockInit.POLISHED_LIGHT_CONCRETE_STAIRS.get(), group()));
	public static final RegistryObject<BlockItem> POLISHED_LIGHT_CONCRETE_SLAB =  ModRegistry.ITEM_REGISTRY.register("polished_light_concrete_slab", () -> new BlockItem(BlockInit.POLISHED_LIGHT_CONCRETE_SLAB.get(), group()));
	
	//Dark Concrete
	public static final RegistryObject<BlockItem> DARK_CONCRETE =  ModRegistry.ITEM_REGISTRY.register("dark_concrete", () -> new BlockItem(BlockInit.DARK_CONCRETE.get(), group()));
	public static final RegistryObject<BlockItem> DARK_CONCRETE_STAIRS =  ModRegistry.ITEM_REGISTRY.register("dark_concrete_stairs", () -> new BlockItem(BlockInit.DARK_CONCRETE_STAIRS.get(), group()));
	public static final RegistryObject<BlockItem> DARK_CONCRETE_SLAB =  ModRegistry.ITEM_REGISTRY.register("dark_concrete_slab", () -> new BlockItem(BlockInit.DARK_CONCRETE_SLAB.get(), group()));
	public static final RegistryObject<BlockItem> DARK_CONCRETE_WALL =  ModRegistry.ITEM_REGISTRY.register("dark_concrete_wall", () -> new BlockItem(BlockInit.DARK_CONCRETE_WALL.get(), group()));
	public static final RegistryObject<BlockItem> DARK_CONCRETE_PRESSURE_PLATE = ModRegistry.ITEM_REGISTRY.register("dark_concrete_pressure_plate", () -> new BlockItem(BlockInit.DARK_CONCRETE_PRESSURE_PLATE.get(), group()));
	public static final RegistryObject<BlockItem> DARK_CONCRETE_BUTTON =  ModRegistry.ITEM_REGISTRY.register("dark_concrete_button", () -> new BlockItem(BlockInit.DARK_CONCRETE_BUTTON.get(), group()));
	
	//Polished Dark Concrete
	public static final RegistryObject<BlockItem> POLISHED_DARK_CONCRETE =  ModRegistry.ITEM_REGISTRY.register("polished_dark_concrete", () -> new BlockItem(BlockInit.POLISHED_DARK_CONCRETE.get(), group()));
	public static final RegistryObject<BlockItem> POLISHED_DARK_CONCRETE_STAIRS =  ModRegistry.ITEM_REGISTRY.register("polished_dark_concrete_stairs", () -> new BlockItem(BlockInit.POLISHED_DARK_CONCRETE_STAIRS.get(), group()));
	public static final RegistryObject<BlockItem> POLISHED_DARK_CONCRETE_SLAB =  ModRegistry.ITEM_REGISTRY.register("polished_dark_concrete_slab", () -> new BlockItem(BlockInit.POLISHED_DARK_CONCRETE_SLAB.get(), group()));

	//Wooden Planks
	public static final RegistryObject<BlockItem> WOODEN_PLANKS =  ModRegistry.ITEM_REGISTRY.register("wooden_planks", () -> new BlockItem(BlockInit.WOODEN_PLANKS.get(), group()));
	public static final RegistryObject<BlockItem> WOODEN_PLANKS_STAIRS =  ModRegistry.ITEM_REGISTRY.register("wooden_planks_stairs", () -> new BlockItem(BlockInit.WOODEN_PLANKS_STAIRS.get(), group()));
	public static final RegistryObject<BlockItem> WOODEN_PLANKS_SLAB =  ModRegistry.ITEM_REGISTRY.register("wooden_planks_slab", () -> new BlockItem(BlockInit.WOODEN_PLANKS_SLAB.get(), group()));
	public static final RegistryObject<BlockItem> WOODEN_PLANKS_FENCE =  ModRegistry.ITEM_REGISTRY.register("wooden_planks_fence", () -> new BlockItem(BlockInit.WOODEN_PLANKS_FENCE.get(), group()));
	public static final RegistryObject<BlockItem> WOODEN_PLANKS_FENCE_GATE =  ModRegistry.ITEM_REGISTRY.register("wooden_planks_fence_gate", () -> new BlockItem(BlockInit.WOODEN_PLANKS_FENCE_GATE.get(), group()));
	public static final RegistryObject<BlockItem> WOODEN_PLANKS_PRESSURE_PLATE = ModRegistry.ITEM_REGISTRY.register("wooden_planks_pressure_plate", () -> new BlockItem(BlockInit.WOODEN_PLANKS_PRESSURE_PLATE.get(), group()));
	public static final RegistryObject<BlockItem> WOODEN_PLANKS_BUTTON =  ModRegistry.ITEM_REGISTRY.register("wooden_planks_button", () -> new BlockItem(BlockInit.WOODEN_PLANKS_BUTTON.get(), group()));
		
	//Wooden Planks
	public static final RegistryObject<BlockItem> REFINED_WOODEN_PLANKS =  ModRegistry.ITEM_REGISTRY.register("refined_wooden_planks", () -> new BlockItem(BlockInit.REFINED_WOODEN_PLANKS.get(), group()));
	public static final RegistryObject<BlockItem> REFINED_WOODEN_PLANKS_STAIRS =  ModRegistry.ITEM_REGISTRY.register("refined_wooden_planks_stairs", () -> new BlockItem(BlockInit.REFINED_WOODEN_PLANKS_STAIRS.get(), group()));
	public static final RegistryObject<BlockItem> REFINED_WOODEN_PLANKS_SLAB =  ModRegistry.ITEM_REGISTRY.register("refined_wooden_planks_slab", () -> new BlockItem(BlockInit.REFINED_WOODEN_PLANKS_SLAB.get(), group()));
	public static final RegistryObject<BlockItem> REFINED_WOODEN_PLANKS_FENCE =  ModRegistry.ITEM_REGISTRY.register("refined_wooden_planks_fence", () -> new BlockItem(BlockInit.REFINED_WOODEN_PLANKS_FENCE.get(), group()));
	public static final RegistryObject<BlockItem> REFINED_WOODEN_PLANKS_FENCE_GATE =  ModRegistry.ITEM_REGISTRY.register("refined_wooden_planks_fence_gate", () -> new BlockItem(BlockInit.REFINED_WOODEN_PLANKS_FENCE_GATE.get(), group()));
	public static final RegistryObject<BlockItem> REFINED_WOODEN_PLANKS_PRESSURE_PLATE = ModRegistry.ITEM_REGISTRY.register("refined_wooden_planks_pressure_plate", () -> new BlockItem(BlockInit.REFINED_WOODEN_PLANKS_PRESSURE_PLATE.get(), group()));
	public static final RegistryObject<BlockItem> REFINED_WOODEN_PLANKS_BUTTON =  ModRegistry.ITEM_REGISTRY.register("refined_wooden_planks_button", () -> new BlockItem(BlockInit.REFINED_WOODEN_PLANKS_BUTTON.get(), group()));
	
	//Pavement
	public static final RegistryObject<BlockItem> PAVEMENT =  ModRegistry.ITEM_REGISTRY.register("pavement", () -> new BlockItem(BlockInit.PAVEMENT.get(), group()));
	public static final RegistryObject<BlockItem> PAVEMENT_SLOPE =  ModRegistry.ITEM_REGISTRY.register("pavement_slope", () -> new BlockItem(BlockInit.PAVEMENT_SLOPE.get(), group()));
	public static final RegistryObject<BlockItem> RAISED_PAVEMENT =  ModRegistry.ITEM_REGISTRY.register("raised_pavement", () -> new BlockItem(BlockInit.RAISED_PAVEMENT.get(), group()));
	
	//Roads
	public static final RegistryObject<BlockItem> GRAVEL_ROAD = ModRegistry.ITEM_REGISTRY.register("gravel_road", () -> new BlockItem(BlockInit.GRAVEL_ROAD.get(), group()));
	public static final RegistryObject<BlockItem> RAISED_GRAVEL_ROAD = ModRegistry.ITEM_REGISTRY.register("raised_gravel_road", () -> new BlockItem(BlockInit.RAISED_GRAVEL_ROAD.get(), group()));
		
	public static final RegistryObject<BlockItem> DIRT_ROAD = ModRegistry.ITEM_REGISTRY.register("dirt_road", () -> new BlockItem(BlockInit.DIRT_ROAD.get(), group()));
	public static final RegistryObject<BlockItem> RAISED_DIRT_ROAD = ModRegistry.ITEM_REGISTRY.register("raised_dirt_road", () -> new BlockItem(BlockInit.RAISED_DIRT_ROAD.get(), group()));
			
	public static final RegistryObject<BlockItem> PAVED_ROAD = ModRegistry.ITEM_REGISTRY.register("paved_road", () -> new BlockItem(BlockInit.PAVED_ROAD.get(), group()));
	public static final RegistryObject<BlockItem> RAISED_PAVED_ROAD = ModRegistry.ITEM_REGISTRY.register("raised_paved_road", () -> new BlockItem(BlockInit.RAISED_PAVED_ROAD.get(), group()));
		
	//Tile
	public static final RegistryObject<BlockItem> TILE =  ModRegistry.ITEM_REGISTRY.register("tile", () -> new BlockItem(BlockInit.TILE.get(), group()));
	public static final RegistryObject<BlockItem> TILE_STAIRS =  ModRegistry.ITEM_REGISTRY.register("tile_stairs", () -> new BlockItem(BlockInit.TILE_STAIRS.get(), group()));
	public static final RegistryObject<BlockItem> TILE_SLAB =  ModRegistry.ITEM_REGISTRY.register("tile_slab", () -> new BlockItem(BlockInit.TILE_SLAB.get(), group()));

	//Metal Fence
	public static final RegistryObject<BlockItem> METAL_FENCE = ModRegistry.ITEM_REGISTRY.register("metal_fence", () -> new BlockItem(BlockInit.METAL_FENCE.get(), group()));

	//Clear Glass
	public static final RegistryObject<BlockItem> CLEAR_GLASS = ModRegistry.ITEM_REGISTRY.register("clear_glass", () -> new BlockItem(BlockInit.CLEAR_GLASS.get(), group()));
	public static final RegistryObject<BlockItem> CLEAR_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("clear_glass_pane", () -> new BlockItem(BlockInit.CLEAR_GLASS_PANE.get(), group()));

	//Tinted Glass
	public static final RegistryObject<BlockItem> TINTED_GLASS = ModRegistry.ITEM_REGISTRY.register("tinted_glass", () -> new BlockItem(BlockInit.TINTED_GLASS.get(), group()));
	public static final RegistryObject<BlockItem> TINTED_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("tinted_glass_pane", () -> new BlockItem(BlockInit.TINTED_GLASS_PANE.get(), group()));
	
	//Coloured Glass
	public static final RegistryObject<BlockItem> WHITE_GLASS = ModRegistry.ITEM_REGISTRY.register("white_glass", () -> new BlockItem(BlockInit.WHITE_GLASS.get(), group()));
	public static final RegistryObject<BlockItem> WHITE_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("white_glass_pane", () -> new BlockItem(BlockInit.WHITE_GLASS_PANE.get(), group()));	
		
	public static final RegistryObject<BlockItem> LIGHT_GREY_GLASS = ModRegistry.ITEM_REGISTRY.register("light_grey_glass", () -> new BlockItem(BlockInit.LIGHT_GREY_GLASS.get(), group()));
	public static final RegistryObject<BlockItem> LIGHT_GREY_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("light_grey_glass_pane", () -> new BlockItem(BlockInit.LIGHT_GREY_GLASS_PANE.get(), group()));	
		
	public static final RegistryObject<BlockItem> GREY_GLASS = ModRegistry.ITEM_REGISTRY.register("grey_glass", () -> new BlockItem(BlockInit.GREY_GLASS.get(), group()));
	public static final RegistryObject<BlockItem> GREY_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("grey_glass_pane", () -> new BlockItem(BlockInit.GREY_GLASS_PANE.get(), group()));	
		
	public static final RegistryObject<BlockItem> BLACK_GLASS = ModRegistry.ITEM_REGISTRY.register("black_glass", () -> new BlockItem(BlockInit.BLACK_GLASS.get(), group()));
	public static final RegistryObject<BlockItem> BLACK_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("black_glass_pane", () -> new BlockItem(BlockInit.BLACK_GLASS_PANE.get(), group()));	
		
	public static final RegistryObject<BlockItem> RED_GLASS = ModRegistry.ITEM_REGISTRY.register("red_glass", () -> new BlockItem(BlockInit.RED_GLASS.get(), group()));
	public static final RegistryObject<BlockItem> RED_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("red_glass_pane", () -> new BlockItem(BlockInit.RED_GLASS_PANE.get(), group()));	
		
	public static final RegistryObject<BlockItem> ORANGE_GLASS = ModRegistry.ITEM_REGISTRY.register("orange_glass", () -> new BlockItem(BlockInit.ORANGE_GLASS.get(), group()));
	public static final RegistryObject<BlockItem> ORANGE_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("orange_glass_pane", () -> new BlockItem(BlockInit.ORANGE_GLASS_PANE.get(), group()));	
	
	public static final RegistryObject<BlockItem> YELLOW_GLASS = ModRegistry.ITEM_REGISTRY.register("yellow_glass", () -> new BlockItem(BlockInit.YELLOW_GLASS.get(), group()));
	public static final RegistryObject<BlockItem> YELLOW_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("yellow_glass_pane", () -> new BlockItem(BlockInit.YELLOW_GLASS_PANE.get(), group()));	
	
	public static final RegistryObject<BlockItem> LIME_GLASS = ModRegistry.ITEM_REGISTRY.register("lime_glass", () -> new BlockItem(BlockInit.LIME_GLASS.get(), group()));
	public static final RegistryObject<BlockItem> LIME_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("lime_glass_pane", () -> new BlockItem(BlockInit.LIME_GLASS_PANE.get(), group()));	
		
	public static final RegistryObject<BlockItem> GREEN_GLASS = ModRegistry.ITEM_REGISTRY.register("green_glass", () -> new BlockItem(BlockInit.GREEN_GLASS.get(), group()));
	public static final RegistryObject<BlockItem> GREEN_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("green_glass_pane", () -> new BlockItem(BlockInit.GREEN_GLASS_PANE.get(), group()));	
		
	public static final RegistryObject<BlockItem> CYAN_GLASS = ModRegistry.ITEM_REGISTRY.register("cyan_glass", () -> new BlockItem(BlockInit.CYAN_GLASS.get(), group()));
	public static final RegistryObject<BlockItem> CYAN_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("cyan_glass_pane", () -> new BlockItem(BlockInit.CYAN_GLASS_PANE.get(), group()));	
		
	public static final RegistryObject<BlockItem> LIGHT_BLUE_GLASS = ModRegistry.ITEM_REGISTRY.register("light_blue_glass", () -> new BlockItem(BlockInit.LIGHT_BLUE_GLASS.get(), group()));
	public static final RegistryObject<BlockItem> LIGHT_BLUE_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("light_blue_glass_pane", () -> new BlockItem(BlockInit.LIGHT_BLUE_GLASS_PANE.get(), group()));	
		
	public static final RegistryObject<BlockItem> BLUE_GLASS = ModRegistry.ITEM_REGISTRY.register("blue_glass", () -> new BlockItem(BlockInit.BLUE_GLASS.get(), group()));
	public static final RegistryObject<BlockItem> BLUE_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("blue_glass_pane", () -> new BlockItem(BlockInit.BLUE_GLASS_PANE.get(), group()));	
		
	public static final RegistryObject<BlockItem> PURPLE_GLASS = ModRegistry.ITEM_REGISTRY.register("purple_glass", () -> new BlockItem(BlockInit.PURPLE_GLASS.get(), group()));
	public static final RegistryObject<BlockItem> PURPLE_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("purple_glass_pane", () -> new BlockItem(BlockInit.PURPLE_GLASS_PANE.get(), group()));	
		
	public static final RegistryObject<BlockItem> MAGENTA_GLASS = ModRegistry.ITEM_REGISTRY.register("magenta_glass", () -> new BlockItem(BlockInit.MAGENTA_GLASS.get(), group()));
	public static final RegistryObject<BlockItem> MAGENTA_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("magenta_glass_pane", () -> new BlockItem(BlockInit.MAGENTA_GLASS_PANE.get(), group()));	
		
	public static final RegistryObject<BlockItem> PINK_GLASS = ModRegistry.ITEM_REGISTRY.register("pink_glass", () -> new BlockItem(BlockInit.PINK_GLASS.get(), group()));
	public static final RegistryObject<BlockItem> PINK_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("pink_glass_pane", () -> new BlockItem(BlockInit.PINK_GLASS_PANE.get(), group()));	
		
	public static final RegistryObject<BlockItem> BROWN_GLASS = ModRegistry.ITEM_REGISTRY.register("brown_glass", () -> new BlockItem(BlockInit.BROWN_GLASS.get(), group()));
	public static final RegistryObject<BlockItem> BROWN_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("brown_glass_pane", () -> new BlockItem(BlockInit.BROWN_GLASS_PANE.get(), group()));	

	//Coloured Blocks
	public static final RegistryObject<BlockItem> RED_DECORATION_BlockItem = ModRegistry.ITEM_REGISTRY.register("red_decoration_block", () -> new BlockItem(BlockInit.RED_DECORATION_BLOCK.get(), group()));
	public static final RegistryObject<BlockItem> ORANGE_DECORATION_BLOCK = ModRegistry.ITEM_REGISTRY.register("orange_decoration_block", () -> new BlockItem(BlockInit.ORANGE_DECORATION_BLOCK.get(), group()));	
	public static final RegistryObject<BlockItem> YELLOW_DECORATION_BLOCK = ModRegistry.ITEM_REGISTRY.register("yellow_decoration_block", () -> new BlockItem(BlockInit.YELLOW_DECORATION_BLOCK.get(), group()));
	public static final RegistryObject<BlockItem> LIME_DECORATION_BLOCK = ModRegistry.ITEM_REGISTRY.register("lime_decoration_block", () -> new BlockItem(BlockInit.LIME_DECORATION_BLOCK.get(), group()));
	public static final RegistryObject<BlockItem> GREEN_DECORATION_BLOCK = ModRegistry.ITEM_REGISTRY.register("green_decoration_block", () -> new BlockItem(BlockInit.GREEN_DECORATION_BLOCK.get(), group()));
	public static final RegistryObject<BlockItem> CYAN_DECORATION_BLOCK = ModRegistry.ITEM_REGISTRY.register("cyan_decoration_block", () -> new BlockItem(BlockInit.CYAN_DECORATION_BLOCK.get(), group()));	
	public static final RegistryObject<BlockItem> BLUE_DECORATION_BLOCK = ModRegistry.ITEM_REGISTRY.register("blue_decoration_block", () -> new BlockItem(BlockInit.BLUE_DECORATION_BLOCK.get(), group()));	
	public static final RegistryObject<BlockItem> LIGHT_BLUE_DECORATION_BLOCK = ModRegistry.ITEM_REGISTRY.register("light_blue_decoration_block", () -> new BlockItem(BlockInit.LIGHT_BLUE_DECORATION_BLOCK.get(), group()));	
	public static final RegistryObject<BlockItem> PURPLE_DECORATION_BLOCK = ModRegistry.ITEM_REGISTRY.register("purple_decoration_block", () -> new BlockItem(BlockInit.PURPLE_DECORATION_BLOCK.get(), group()));	
	public static final RegistryObject<BlockItem> MAGENTA_DECORATION_BLOCK = ModRegistry.ITEM_REGISTRY.register("magenta_decoration_block", () -> new BlockItem(BlockInit.MAGENTA_DECORATION_BLOCK.get(), group()));	
	public static final RegistryObject<BlockItem> PINK_DECORATION_BLOCK = ModRegistry.ITEM_REGISTRY.register("pink_decoration_block", () -> new BlockItem(BlockInit.PINK_DECORATION_BLOCK.get(), group()));	
	public static final RegistryObject<BlockItem> BROWN_DECORATION_BLOCK = ModRegistry.ITEM_REGISTRY.register("brown_decoration_block", () -> new BlockItem(BlockInit.BROWN_DECORATION_BLOCK.get(), group()));	
	public static final RegistryObject<BlockItem> GREY_DECORATION_BLOCK = ModRegistry.ITEM_REGISTRY.register("grey_decoration_block", () -> new BlockItem(BlockInit.GREY_DECORATION_BLOCK.get(), group()));	
	public static final RegistryObject<BlockItem> LIGHT_GREY_DECORATION_BLOCK = ModRegistry.ITEM_REGISTRY.register("light_grey_decoration_block", () -> new BlockItem(BlockInit.LIGHT_GREY_DECORATION_BLOCK.get(), group()));	
	public static final RegistryObject<BlockItem> WHITE_DECORATION_BLOCK = ModRegistry.ITEM_REGISTRY.register("white_decoration_block", () -> new BlockItem(BlockInit.WHITE_DECORATION_BLOCK.get(), group()));	
	public static final RegistryObject<BlockItem> BLACK_DECORATION_BLOCK = ModRegistry.ITEM_REGISTRY.register("black_decoration_block", () -> new BlockItem(BlockInit.BLACK_DECORATION_BLOCK.get(), group()));
	
	//Thatch
	public static final RegistryObject<BlockItem> THATCH_BLOCK =  ModRegistry.ITEM_REGISTRY.register("thatch_block", () -> new BlockItem(BlockInit.THATCH_BLOCK.get(), group()));
	
	//Doors
	public static final RegistryObject<BlockItem> OUTDOOR_TOILET_DOOR = ModRegistry.ITEM_REGISTRY.register("outdoor_toilet_door", () -> new BlockItem(BlockInit.OUTDOOR_TOILET_DOOR.get(), group()));
	public static final RegistryObject<BlockItem> GLASS_SHOP_DOOR = ModRegistry.ITEM_REGISTRY.register("glass_shop_door", () -> new BlockItem(BlockInit.GLASS_SHOP_DOOR.get(), group()));
	public static final RegistryObject<BlockItem> VISITOR_CENTRE_DOOR = ModRegistry.ITEM_REGISTRY.register("visitor_centre_door", () -> new BlockItem(BlockInit.VISITOR_CENTRE_DOOR.get(), group()));
	public static final RegistryObject<BlockItem> INNOVATION_CENTRE_DOOR = ModRegistry.ITEM_REGISTRY.register("innovation_centre_door", () -> new BlockItem(BlockInit.INNOVATION_CENTRE_DOOR.get(), group()));
	public static final RegistryObject<BlockItem> SECURITY_DOOR = ModRegistry.ITEM_REGISTRY.register("security_door", () -> new BlockItem(BlockInit.SECURITY_DOOR.get(), group()));
	public static final RegistryObject<BlockItem> BACK_DOOR = ModRegistry.ITEM_REGISTRY.register("back_door", () -> new BlockItem(BlockInit.BACK_DOOR.get(), group()));
	
	//Registry
	
	//Properties
	private static Properties group()
	{
		return new Item.Properties().group(ModItemGroup.TAB);
	}
	
	//Advanced Item Register
	private static RegistryObject<Item> registerClassItem(String id, Item item)
	{
		return ModRegistry.ITEM_REGISTRY.register(id, () -> item);
	}
	
	//Basic Item Register
	private static RegistryObject<Item> registerItem(String id, Item.Properties properties)
	{
		return registerClassItem(id, new Item(properties));
	}
	
	//Spawn Eggs
	private static RegistryObject<Item> registerSpawnEgg(String id, NonNullSupplier<EntityType<?>> entity, int primaryColour, int secondaryColour, Item.Properties properties)
	{
		return registerClassItem(id + "_spawn_egg", new ModSpawnEggItem(entity, primaryColour, secondaryColour, properties));
	}
	
	//Buckets For Fish
	private static RegistryObject<Item> registerEntityBucket(String id, NonNullSupplier<EntityType<?>> entity, Fluid fluid, Item.Properties properties)
	{
		return registerClassItem(id + "_bucket", new ModFishBucketItem(entity, fluid, properties));
	}
	
	//Dinosaur Items Quick Register (They're all the same anyway)
	private static RegistryObject<Item> registerBone(String type) 
	{
		return registerItem(type + "_bone", group());
	}
	
	private static RegistryObject<Item> registerDNA(String type) 
	{
		return registerItem(type + "_dna", group());
	}
	
	private static RegistryObject<Item> registerEgg(String type) 
	{
		return registerItem(type + "_egg", group().maxStackSize(1));
	}
	
	private static RegistryObject<Item> registerBabyDino(String type) 
	{
		return registerItem(type + "_baby", group().maxStackSize(1));
	}
	
	private static RegistryObject<Item> registerMeat(String type, Food food) 
	{
		return registerItem("raw_" + type + "_meat", group().food(food));
	}
	
	private static RegistryObject<Item> registerCookedMeat(String type, Food food) 
	{
		return registerItem("cooked_" + type + "_meat", group().food(food));
	}
	
	public static void initItems() { }
}
