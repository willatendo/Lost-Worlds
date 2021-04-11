package lostworlds.core.init; 

import lostworlds.common.entities.ModBoatEntity.ModBoatType;
import lostworlds.common.items.DiscItem;
import lostworlds.common.items.FieldGuideItem;
import lostworlds.common.items.ModBoatItem;
import lostworlds.common.items.ModFishBucketItem;
import lostworlds.common.items.ModSpawnEggItem;
import lostworlds.common.items.WetPaperItem;
import lostworlds.common.tools.BrushItem;
import lostworlds.core.ModItemGroup;
import lostworlds.core.util.enums.ModItemTeir;
import lostworlds.core.util.registry.ModRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Rarity;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SignItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.fml.RegistryObject;

@SuppressWarnings("deprecation")
public class ItemInit 
{
	//Items
	//Brush
	public static final RegistryObject<Item> BRUSH = ModRegistry.ITEM_REGISTRY.register("brush", () -> new BrushItem(ModItemTeir.BRUSH, 1.5F, -3.0F, standardProperties()));
	
	//Plaster
	public static final RegistryObject<Item> WET_PAPER = advancedItemRegister("wet_paper", new WetPaperItem(standardProperties()));

	//Fossil
	public static final RegistryObject<Item> FOSSIL = simpleItemRegister("fossil", standardProperties());
	
	//Field Guide
	public static final RegistryObject<Item> FEILD_GUIDE = ModRegistry.ITEM_REGISTRY.register("field_guide", () -> new FieldGuideItem(new Item.Properties()));
	
	//Procompsognathus
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_DNA = registerDNA("procompsognathus");
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_DNA_DISC = registerDisc("procompsognathus");
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_EGG = ModRegistry.ITEM_REGISTRY.register("procompsognathus_egg", () -> new BlockItem(BlockInit.PROCOMPSOGNATHUS_EGG.get(), standardProperties()));
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_MEAT = registerMeat("procompsognathus", FoodInit.RAW_PROCOMPSOGNATHUS_MEAT);
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_COOKED_MEAT = registerCookedMeat("procompsognathus", FoodInit.COOKED_PROCOMPSOGNATHUS_MEAT);
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_SPAWN_EGG = registerSpawnEgg("procompsognathus", () -> EntityInit.PROCOMPSOGNATHUS_ENTITY.get(), 0x125611, 0x143025);
	
	//Palaeoniscum
	public static final RegistryObject<Item> PALAEONISCUM_DNA = registerDNA("palaeoniscum");
	public static final RegistryObject<Item> PALAEONISCUM_DNA_DISC = registerDisc("palaeoniscum");
	public static final RegistryObject<Item> PALAEONISCUM_SPAWN = registerSpawn("palaeoniscum");
	public static final RegistryObject<Item> PALAEONISCUM_SPAWN_BUCKET = registerSpawnBucket("palaeoniscum", () -> EntityInit.PALAEONISCUM_ENTITY.get());
	public static final RegistryObject<Item> PALAEONISCUM_MEAT = registerFishMeat("palaeoniscum", FoodInit.PALAEONISCUM);
	public static final RegistryObject<Item> PALAEONISCUM_COOKED_MEAT = registerCookedFishMeat("palaeoniscum", FoodInit.COOKED_PROCOMPSOGNATHUS_MEAT);
	public static final RegistryObject<Item> PALAEONISCUM_SPAWN_EGG = registerSpawnEgg("palaeoniscum", () -> EntityInit.PALAEONISCUM_ENTITY.get(), 0x1e2f4f, 0x2b1838);
	public static final RegistryObject<Item> PALAEONISCUM_BUCKET = registerEntityBucket("palaeoniscum", () -> EntityInit.PALAEONISCUM_ENTITY.get());
	
	//Nautilus
	public static final RegistryObject<Item> NAUTILUS_DNA = registerDNA("nautilus");
	public static final RegistryObject<Item> NAUTILUS_DNA_DISC = registerDisc("nautilus");
	public static final RegistryObject<Item> NAUTILUS_SPAWN = registerSpawn("nautilus");
	public static final RegistryObject<Item> NAUTILUS_SPAWN_BUCKET = registerSpawnBucket("nautilus", () -> EntityInit.NAUTILUS_ENTITY.get());
	public static final RegistryObject<Item> NAUTILUS_TENTICAL = advancedItemRegister("nautilus_tentical", new Item(standardProperties().food(FoodInit.NAUTILUS_TENTICAL)));
	public static final RegistryObject<Item> COOKED_NAUTILUS_TENTICAL = advancedItemRegister("cooked_nautilus_tentical", new Item(standardProperties().food(FoodInit.COOKED_NAUTILUS_TENTICAL)));
	public static final RegistryObject<Item> NAUTILUS_SPAWN_EGG = registerSpawnEgg("nautilus", () -> EntityInit.NAUTILUS_ENTITY.get(), 0xd8cecd, 0x4f4841);
	public static final RegistryObject<Item> NAUTILUS_BUCKET = registerEntityBucket("nautilus", () -> EntityInit.NAUTILUS_ENTITY.get());
		
	//Rhinesuchus
	public static final RegistryObject<Item> RHINESUCHUS_DNA = registerDNA("rhinesuchus");
	public static final RegistryObject<Item> RHINESUCHUS_DNA_DISC = registerDisc("rhinesuchus");
	public static final RegistryObject<Item> RHINESUCHUS_SPAWN = registerSpawn("rhinesuchus");
	public static final RegistryObject<Item> RHINESUCHUS_SPAWN_BUCKET = registerSpawnBucket("rhinesuchus", () -> EntityInit.RHINESUCHUS_ENTITY.get());
	public static final RegistryObject<Item> RHINESUCHUS_MEAT = registerMeat("rhinesuchus", FoodInit.RAW_RHINESUCHUS_MEAT);
	public static final RegistryObject<Item> RHINESUCHUS_COOKED_MEAT = registerCookedMeat("rhinesuchus", FoodInit.COOKED_RHINESUCHUS_MEAT);
	public static final RegistryObject<Item> RHINESUCHUS_SPAWN_EGG = registerSpawnEgg("rhinesuchus", () -> EntityInit.RHINESUCHUS_ENTITY.get(), 0xceaa7b, 0x1c1308);
	
	//Dimetrodon
	public static final RegistryObject<Item> DIMETRODON_DNA = registerDNA("dimetrodon");
	public static final RegistryObject<Item> DIMETRODON_DNA_DISC = registerDisc("dimetrodon");
	public static final RegistryObject<Item> DIMETRODON_EGG = ModRegistry.ITEM_REGISTRY.register("dimetrodon_egg", () -> new BlockItem(BlockInit.DIMETRODON_EGG.get(), standardProperties()));
	public static final RegistryObject<Item> DIMETRODON_MEAT = registerMeat("dimetrodon", FoodInit.RAW_DIMETRODON_MEAT);
	public static final RegistryObject<Item> DIMETRODON_COOKED_MEAT = registerCookedMeat("dimetrodon", FoodInit.COOKED_DIMETRODON_MEAT);
	public static final RegistryObject<Item> DIMETRODON_SPAWN_EGG = registerSpawnEgg("dimetrodon", () -> EntityInit.DIMETRODON_ENTITY.get(), 0x378ca8, 0x152875);
	
	//Edaphosaurus
	public static final RegistryObject<Item> EDAPHOSAURUS_DNA = registerDNA("edaphosaurus");
	public static final RegistryObject<Item> EDAPHOSAURUS_DNA_DISC = registerDisc("edaphosaurus");
	public static final RegistryObject<Item> EDAPHOSAURUS_MEAT = registerMeat("edaphosaurus", FoodInit.RAW_EDAPHOSAURUS_MEAT);
	public static final RegistryObject<Item> EDAPHOSAURUS_COOKED_MEAT = registerCookedMeat("edaphosaurus", FoodInit.COOKED_EDAPHOSAURUS_MEAT);
	public static final RegistryObject<Item> EDAPHOSAURUS_SPAWN_EGG = registerSpawnEgg("edaphosaurus", () -> EntityInit.EDAPHOSAURUS_ENTITY.get(), 0x96af42, 0x2a3016);

	//Gorgonops
	public static final RegistryObject<Item> GORGONOPS_DNA = registerDNA("gorgonops");
	public static final RegistryObject<Item> GORGONOPS_DNA_DISC = registerDisc("gorgonops");
	public static final RegistryObject<Item> GORGONOPS_MEAT = registerMeat("gorgonops", FoodInit.RAW_GORGONOPS_MEAT);
	public static final RegistryObject<Item> GORGONOPS_COOKED_MEAT = registerCookedMeat("gorgonops", FoodInit.COOKED_GORGONOPS_MEAT);
	public static final RegistryObject<Item> GORGONOPS_SPAWN_EGG = registerSpawnEgg("gorgonops", () -> EntityInit.GORGONOPS_ENTITY.get(), 0x967d46, 0x4f2f1a);

	//Carnotaurus
	public static final RegistryObject<Item> CARNOTAURUS_DNA = registerDNA("carnotaurus");
	public static final RegistryObject<Item> CARNOTAURUS_DNA_DISC = registerDisc("carnotaurus");
	public static final RegistryObject<Item> CARNOTAURUS_MEAT = registerMeat("carnotaurus", FoodInit.RAW_CARNOTAURUS_MEAT);
	public static final RegistryObject<Item> CARNOTAURUS_COOKED_MEAT = registerCookedMeat("carnotaurus", FoodInit.COOKED_CARNOTAURUS_MEAT);
	public static final RegistryObject<Item> CARNOTAURUS_SPAWN_EGG = registerSpawnEgg("carnotaurus", () -> EntityInit.CARNOTAURUS_ENTITY.get(), 0x682324, 0x171c06);
	
	//Tyrannosaurus
	public static final RegistryObject<Item> TYRANNOSAURUS_DNA = registerDNA("tyrannosaurus");
	public static final RegistryObject<Item> TYRANNOSAURUS_DNA_DISC = registerDisc("tyrannosaurus");
	public static final RegistryObject<Item> TYRANNOSAURUS_MEAT = registerMeat("tyrannosaurus", FoodInit.RAW_TYRANNOSAURUS_MEAT);
	public static final RegistryObject<Item> TYRANNOSAURUS_COOKED_MEAT = registerCookedMeat("tyrannosaurus", FoodInit.COOKED_TYRANNOSAURUS_MEAT);
	public static final RegistryObject<Item> TYRANNOSAURUS_SPAWN_EGG = registerSpawnEgg("tyrannosaurus", () -> EntityInit.TYRANNOSAURUS_ENTITY.get(), 0x92b541, 0x125134);

	//Mud Ball
	public static final RegistryObject<Item> MUD_BALL = simpleItemRegister("mud_ball", standardProperties());
	
	//Copper
	public static final RegistryObject<Item> COPPER_INGOT = simpleItemRegister("copper_ingot", standardProperties());
	public static final RegistryObject<Item> COPPER_NUGGET = simpleItemRegister("copper_nugget", standardProperties());
	
	//Oil and Plastic Stuff
	public static final RegistryObject<Item> OIL_BUCKET = advancedItemRegister("oil_bucket", new BucketItem(() -> FluidInit.OIL_FLUID.get(), standardProperties().stacksTo(1)));
	public static final RegistryObject<Item> MOLTEN_PLASTIC_BUCKET = simpleItemRegister("molten_plastic_bucket", standardProperties().stacksTo(1));
	
	//Electronics
	public static final RegistryObject<Item> COPPER_WIRE = simpleItemRegister("copper_wire", standardProperties());	
	public static final RegistryObject<Item> COMPUTER_FAN = simpleItemRegister("computer_fan", standardProperties());
	public static final RegistryObject<Item> COMPUTER_SCREEN = simpleItemRegister("computer_screen", standardProperties());
	public static final RegistryObject<Item> COMPUTER_FRAME = simpleItemRegister("computer_frame", standardProperties());
	public static final RegistryObject<Item> COMPUTER_STORAGE_PORT = simpleItemRegister("computer_storage_port", standardProperties());
	public static final RegistryObject<Item> MOTHERBOARD = simpleItemRegister("motherboard", standardProperties());
	public static final RegistryObject<Item> CPU = simpleItemRegister("cpu", standardProperties());
	public static final RegistryObject<Item> RAM = simpleItemRegister("ram", standardProperties());	
	
	//Music
	public static final RegistryObject<Item> JP_MUSIC_DISC = advancedItemRegister("jp_music_disc", new MusicDiscItem(15, SoundInit.LAZY_JP_MUSIC.get(), standardProperties().stacksTo(1).rarity(Rarity.RARE)));
	
	//Storage
	public static final RegistryObject<Item> STORAGE_DISC = advancedItemRegister("storage_disc", new DiscItem("storage_disc", standardProperties().stacksTo(1)));
		
	//Crystal Scarab	
	public static final RegistryObject<Item> BROKEN_CRYSTAL_SCARAB_GEM = simpleItemRegister("broken_crystal_scarab_gem", standardProperties().rarity(Rarity.RARE));
	public static final RegistryObject<Item> CRYSTAL_SCARAB_GEM = simpleItemRegister("crystal_scarab_gem", standardProperties().rarity(Rarity.EPIC));
	
	//Crystal Scarab Tools
	public static final RegistryObject<Item> CRYSTAL_SCARAB_SWORD = advancedItemRegister("crystal_scarab_sword", new SwordItem(ModItemTeir.SCARAB, 50, -2.4F, standardProperties().rarity(Rarity.EPIC)));
	public static final RegistryObject<Item> CRYSTAL_SCARAB_SHOVEL = advancedItemRegister("crystal_scarab_shovel", new ShovelItem(ModItemTeir.SCARAB, 12.0F, -3.0F, standardProperties().rarity(Rarity.EPIC)));
	public static final RegistryObject<Item> CRYSTAL_SCARAB_PICKAXE = advancedItemRegister("crystal_scarab_pickaxe", new PickaxeItem(ModItemTeir.SCARAB, 32, -2.8F, standardProperties().rarity(Rarity.EPIC)));
	public static final RegistryObject<Item> CRYSTAL_SCARAB_AXE = advancedItemRegister("crystal_scarab_axe", new AxeItem(ModItemTeir.SCARAB, 70.0F, -3.2F, standardProperties().rarity(Rarity.EPIC)));
	public static final RegistryObject<Item> CRYSTAL_SCARAB_HOE = advancedItemRegister("crystal_scarab_hoe", new HoeItem(ModItemTeir.SCARAB, 10, -3.0F, standardProperties().rarity(Rarity.EPIC)));
		
	//Blocks
	//Ore
	public static final RegistryObject<BlockItem> COPPER_ORE = ModRegistry.ITEM_REGISTRY.register("copper_ore", () -> new BlockItem(BlockInit.COPPER_ORE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> OIL_SANDS = ModRegistry.ITEM_REGISTRY.register("oil_sands", () -> new BlockItem(BlockInit.OIL_SANDS.get(), standardProperties()));
	
	//Fossil
	public static final RegistryObject<BlockItem> STONE_FOSSIL = ModRegistry.ITEM_REGISTRY.register("stone_fossil", () -> new BlockItem(BlockInit.STONE_FOSSIL.get(), standardProperties()));
	public static final RegistryObject<BlockItem> EXPOSED_STONE_FOSSIL = ModRegistry.ITEM_REGISTRY.register("exposed_stone_fossil", () -> new BlockItem(BlockInit.EXPOSED_STONE_FOSSIL.get(), standardProperties()));
	public static final RegistryObject<BlockItem> PLASTERED_STONE_FOSSIL = ModRegistry.ITEM_REGISTRY.register("plastered_stone_fossil", () -> new BlockItem(BlockInit.PLASTERED_STONE_FOSSIL.get(), standardProperties()));
	
	public static final RegistryObject<BlockItem> POWER_SUPPLY_BLOCK = ModRegistry.ITEM_REGISTRY.register("power_supply_block", () -> new BlockItem(BlockInit.POWER_SUPPLY_BLOCK.get(), standardProperties()));

	//Mud
	public static final RegistryObject<BlockItem> MUD = ModRegistry.ITEM_REGISTRY.register("mud", () -> new BlockItem(BlockInit.MUD.get(), standardProperties()));

	//Nesting Block
	public static final RegistryObject<BlockItem> NESTING_BLOCK = ModRegistry.ITEM_REGISTRY.register("nesting_block", () -> new BlockItem(BlockInit.NESTING_BLOCK.get(), standardProperties()));

	//Museum Stuff
	public static final RegistryObject<BlockItem> OAK_ARCHAEOLOGY_TABLE = ModRegistry.ITEM_REGISTRY.register("oak_archaeology_table", () -> new BlockItem(BlockInit.OAK_ARCHAEOLOGY_TABLE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> STRIPPED_OAK_ARCHAEOLOGY_TABLE = ModRegistry.ITEM_REGISTRY.register("stripped_oak_archaeology_table", () -> new BlockItem(BlockInit.STRIPPED_OAK_ARCHAEOLOGY_TABLE.get(), standardProperties()));
	
	public static final RegistryObject<BlockItem> BIRCH_ARCHAEOLOGY_TABLE = ModRegistry.ITEM_REGISTRY.register("birch_archaeology_table", () -> new BlockItem(BlockInit.BIRCH_ARCHAEOLOGY_TABLE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> STRIPPED_BIRCH_ARCHAEOLOGY_TABLE = ModRegistry.ITEM_REGISTRY.register("stripped_birch_archaeology_table", () -> new BlockItem(BlockInit.STRIPPED_BIRCH_ARCHAEOLOGY_TABLE.get(), standardProperties()));
	
	public static final RegistryObject<BlockItem> JUNGLE_ARCHAEOLOGY_TABLE = ModRegistry.ITEM_REGISTRY.register("jungle_archaeology_table", () -> new BlockItem(BlockInit.JUNGLE_ARCHAEOLOGY_TABLE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> STRIPPED_JUNGLE_ARCHAEOLOGY_TABLE = ModRegistry.ITEM_REGISTRY.register("stripped_jungle_archaeology_table", () -> new BlockItem(BlockInit.STRIPPED_JUNGLE_ARCHAEOLOGY_TABLE.get(), standardProperties()));
	
	public static final RegistryObject<BlockItem> SPRUCE_ARCHAEOLOGY_TABLE = ModRegistry.ITEM_REGISTRY.register("spruce_archaeology_table", () -> new BlockItem(BlockInit.SPRUCE_ARCHAEOLOGY_TABLE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> STRIPPED_SPRUCE_ARCHAEOLOGY_TABLE = ModRegistry.ITEM_REGISTRY.register("stripped_spruce_archaeology_table", () -> new BlockItem(BlockInit.STRIPPED_SPRUCE_ARCHAEOLOGY_TABLE.get(), standardProperties()));
	
	public static final RegistryObject<BlockItem> ACACIA_ARCHAEOLOGY_TABLE = ModRegistry.ITEM_REGISTRY.register("acacia_archaeology_table", () -> new BlockItem(BlockInit.ACACIA_ARCHAEOLOGY_TABLE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> STRIPPED_ACACIA_ARCHAEOLOGY_TABLE = ModRegistry.ITEM_REGISTRY.register("stripped_acacia_archaeology_table", () -> new BlockItem(BlockInit.STRIPPED_ACACIA_ARCHAEOLOGY_TABLE.get(), standardProperties()));
	
	public static final RegistryObject<BlockItem> DARK_OAK_ARCHAEOLOGY_TABLE = ModRegistry.ITEM_REGISTRY.register("dark_oak_archaeology_table", () -> new BlockItem(BlockInit.DARK_OAK_ARCHAEOLOGY_TABLE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> STRIPPED_DARK_OAK_ARCHAEOLOGY_TABLE = ModRegistry.ITEM_REGISTRY.register("stripped_dark_oak_archaeology_table", () -> new BlockItem(BlockInit.STRIPPED_DARK_OAK_ARCHAEOLOGY_TABLE.get(), standardProperties()));
	
	public static final RegistryObject<BlockItem> CONIFER_ARCHAEOLOGY_TABLE = ModRegistry.ITEM_REGISTRY.register("conifer_archaeology_table", () -> new BlockItem(BlockInit.CONIFER_ARCHAEOLOGY_TABLE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> STRIPPED_CONIFER_ARCHAEOLOGY_TABLE = ModRegistry.ITEM_REGISTRY.register("stripped_conifer_archaeology_table", () -> new BlockItem(BlockInit.STRIPPED_CONIFER_ARCHAEOLOGY_TABLE.get(), standardProperties()));
	
	//Volcanic Stuff
	public static final RegistryObject<BlockItem> VOLCANIC_ROCK = ModRegistry.ITEM_REGISTRY.register("volcanic_rock", () -> new BlockItem(BlockInit.VOLCANIC_ROCK.get(), standardProperties()));	
	public static final RegistryObject<BlockItem> VOLCANIC_ROCK_STAIRS = ModRegistry.ITEM_REGISTRY.register("volcanic_rock_stairs", () -> new BlockItem(BlockInit.VOLCANIC_ROCK_STAIRS.get(), standardProperties()));	
	public static final RegistryObject<BlockItem> VOLCANIC_ROCK_SLAB = ModRegistry.ITEM_REGISTRY.register("volcanic_rock_slab", () -> new BlockItem(BlockInit.VOLCANIC_ROCK_SLAB.get(), standardProperties()));	
	public static final RegistryObject<BlockItem> VOLCANIC_ROCK_WALL = ModRegistry.ITEM_REGISTRY.register("volcanic_rock_wall", () -> new BlockItem(BlockInit.VOLCANIC_ROCK_WALL.get(), standardProperties()));	
	
	public static final RegistryObject<BlockItem> POLISHED_VOLCANIC_ROCK = ModRegistry.ITEM_REGISTRY.register("polished_volcanic_rock", () -> new BlockItem(BlockInit.POLISHED_VOLCANIC_ROCK.get(), standardProperties()));	
	public static final RegistryObject<BlockItem> POLISHED_VOLCANIC_ROCK_STAIRS = ModRegistry.ITEM_REGISTRY.register("polished_volcanic_rock_stairs", () -> new BlockItem(BlockInit.POLISHED_VOLCANIC_ROCK_STAIRS.get(), standardProperties()));	
	public static final RegistryObject<BlockItem> POLISHED_VOLCANIC_ROCK_SLAB = ModRegistry.ITEM_REGISTRY.register("polished_volcanic_rock_slab", () -> new BlockItem(BlockInit.POLISHED_VOLCANIC_ROCK_SLAB.get(), standardProperties()));	

	public static final RegistryObject<BlockItem> VOLCANIC_ASH = ModRegistry.ITEM_REGISTRY.register("volcanic_ash", () -> new BlockItem(BlockInit.VOLCANIC_ASH.get(), standardProperties()));

	//Permian
	public static final RegistryObject<BlockItem> PERMIAN_SAND = ModRegistry.ITEM_REGISTRY.register("permian_sand", () -> new BlockItem(BlockInit.PERMIAN_SAND.get(), standardProperties()));

	public static final RegistryObject<BlockItem> PERMIAN_STONE = ModRegistry.ITEM_REGISTRY.register("permian_stone", () -> new BlockItem(BlockInit.PERMIAN_STONE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> PERMIAN_STONE_STAIRS = ModRegistry.ITEM_REGISTRY.register("permian_stone_stairs", () -> new BlockItem(BlockInit.PERMIAN_STONE_STAIRS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> PERMIAN_STONE_SLAB = ModRegistry.ITEM_REGISTRY.register("permian_stone_slab", () -> new BlockItem(BlockInit.PERMIAN_STONE_SLAB.get(), standardProperties()));
	
	public static final RegistryObject<BlockItem> PERMIAN_COBBLESTONE = ModRegistry.ITEM_REGISTRY.register("permian_cobblestone", () -> new BlockItem(BlockInit.PERMIAN_COBBLESTONE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> PERMIAN_COBBLESTONE_STAIRS = ModRegistry.ITEM_REGISTRY.register("permian_cobblestone_stairs", () -> new BlockItem(BlockInit.PERMIAN_COBBLESTONE_STAIRS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> PERMIAN_COBBLESTONE_SLAB = ModRegistry.ITEM_REGISTRY.register("permian_cobblestone_slab", () -> new BlockItem(BlockInit.PERMIAN_COBBLESTONE_SLAB.get(), standardProperties()));
	public static final RegistryObject<BlockItem> PERMIAN_COBBLESTONE_WALL = ModRegistry.ITEM_REGISTRY.register("permian_cobblestone_wall", () -> new BlockItem(BlockInit.PERMIAN_COBBLESTONE_WALL.get(), standardProperties()));

	public static final RegistryObject<BlockItem> SMALL_PERMIAN_DESERT_PLANT = ModRegistry.ITEM_REGISTRY.register("small_permian_desert_plant", () -> new BlockItem(BlockInit.SMALL_PERMIAN_DESERT_PLANT.get(), standardProperties()));
	public static final RegistryObject<BlockItem> MEDIUM_PERMIAN_DESERT_PLANT = ModRegistry.ITEM_REGISTRY.register("medium_permian_desert_plant", () -> new BlockItem(BlockInit.MEDIUM_PERMIAN_DESERT_PLANT.get(), standardProperties()));
	public static final RegistryObject<BlockItem> LARGE_PERMIAN_DESERT_PLANT = ModRegistry.ITEM_REGISTRY.register("large_permian_desert_plant", () -> new BlockItem(BlockInit.LARGE_PERMIAN_DESERT_PLANT.get(), standardProperties()));

	public static final RegistryObject<BlockItem> PERMIAN_GROUND_FERNS = ModRegistry.ITEM_REGISTRY.register("permian_ground_ferns", () -> new BlockItem(BlockInit.PERMIAN_GROUND_FERNS.get(), standardProperties()));

	public static final RegistryObject<BlockItem> CONIFER_LOG = ModRegistry.ITEM_REGISTRY.register("conifer_log", () -> new BlockItem(BlockInit.CONIFER_LOG.get(), standardProperties()));
	public static final RegistryObject<BlockItem> CONIFER_WOOD = ModRegistry.ITEM_REGISTRY.register("conifer_wood", () -> new BlockItem(BlockInit.CONIFER_WOOD.get(), standardProperties()));
	public static final RegistryObject<BlockItem> STRIPPED_CONIFER_LOG = ModRegistry.ITEM_REGISTRY.register("stripped_conifer_log", () -> new BlockItem(BlockInit.STRIPPED_CONIFER_LOG.get(), standardProperties()));
	public static final RegistryObject<BlockItem> STRIPPED_CONIFER_WOOD = ModRegistry.ITEM_REGISTRY.register("stripped_conifer_wood", () -> new BlockItem(BlockInit.STRIPPED_CONIFER_WOOD.get(), standardProperties()));
	public static final RegistryObject<BlockItem> CONIFER_LEAVES = ModRegistry.ITEM_REGISTRY.register("conifer_leaves", () -> new BlockItem(BlockInit.CONIFER_LEAVES.get(), standardProperties()));
	public static final RegistryObject<BlockItem> CONIFER_SAPLING = ModRegistry.ITEM_REGISTRY.register("conifer_sapling", () -> new BlockItem(BlockInit.CONIFER_SAPLING.get(), standardProperties()));
	public static final RegistryObject<BlockItem> CONIFER_PLANKS = ModRegistry.ITEM_REGISTRY.register("conifer_planks", () -> new BlockItem(BlockInit.CONIFER_PLANKS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> CONIFER_STAIRS = ModRegistry.ITEM_REGISTRY.register("conifer_stairs", () -> new BlockItem(BlockInit.CONIFER_STAIRS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> CONIFER_SLAB = ModRegistry.ITEM_REGISTRY.register("conifer_slab", () -> new BlockItem(BlockInit.CONIFER_SLAB.get(), standardProperties()));
	public static final RegistryObject<BlockItem> CONIFER_FENCE = ModRegistry.ITEM_REGISTRY.register("conifer_fence", () -> new BlockItem(BlockInit.CONIFER_FENCE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> CONIFER_FENCE_GATE = ModRegistry.ITEM_REGISTRY.register("conifer_fence_gate", () -> new BlockItem(BlockInit.CONIFER_FENCE_GATE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> CONIFER_PRESSURE_PLATE = ModRegistry.ITEM_REGISTRY.register("conifer_pressure_plate", () -> new BlockItem(BlockInit.CONIFER_PRESSURE_PLATE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> CONIFER_BUTTON = ModRegistry.ITEM_REGISTRY.register("conifer_button", () -> new BlockItem(BlockInit.CONIFER_BUTTON.get(), standardProperties()));
	public static final RegistryObject<BlockItem> CONIFER_TRAPDOOR = ModRegistry.ITEM_REGISTRY.register("conifer_trapdoor", () -> new BlockItem(BlockInit.CONIFER_TRAPDOOR.get(), standardProperties())); 
	public static final RegistryObject<BlockItem> CONIFER_DOOR = ModRegistry.ITEM_REGISTRY.register("conifer_door", () -> new BlockItem(BlockInit.CONIFER_DOOR.get(), standardProperties()));
	public static final RegistryObject<SignItem> CONIFER_SIGN = ModRegistry.ITEM_REGISTRY.register("conifer_sign", () -> new SignItem(standardProperties(), BlockInit.CONIFER_SIGN.get(), BlockInit.CONIFER_WALL_SIGN.get()));
	public static final RegistryObject<ModBoatItem> CONIFER_BOAT = ModRegistry.ITEM_REGISTRY.register("conifer_boat", () -> new ModBoatItem(ModBoatType.CONIFER, standardProperties()));

	//Light Concrete
	public static final RegistryObject<BlockItem> LIGHT_CONCRETE =  ModRegistry.ITEM_REGISTRY.register("light_concrete", () -> new BlockItem(BlockInit.LIGHT_CONCRETE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> LIGHT_CONCRETE_STAIRS =  ModRegistry.ITEM_REGISTRY.register("light_concrete_stairs", () -> new BlockItem(BlockInit.LIGHT_CONCRETE_STAIRS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> LIGHT_CONCRETE_SLAB =  ModRegistry.ITEM_REGISTRY.register("light_concrete_slab", () -> new BlockItem(BlockInit.LIGHT_CONCRETE_SLAB.get(), standardProperties()));
	public static final RegistryObject<BlockItem> LIGHT_CONCRETE_WALL =  ModRegistry.ITEM_REGISTRY.register("light_concrete_wall", () -> new BlockItem(BlockInit.LIGHT_CONCRETE_WALL.get(), standardProperties()));
	public static final RegistryObject<BlockItem> LIGHT_CONCRETE_PRESSURE_PLATE = ModRegistry.ITEM_REGISTRY.register("light_concrete_pressure_plate", () -> new BlockItem(BlockInit.LIGHT_CONCRETE_PRESSURE_PLATE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> LIGHT_CONCRETE_BUTTON =  ModRegistry.ITEM_REGISTRY.register("light_concrete_button", () -> new BlockItem(BlockInit.LIGHT_CONCRETE_BUTTON.get(), standardProperties()));
	
	//Polished Light Concrete
	public static final RegistryObject<BlockItem> POLISHED_LIGHT_CONCRETE =  ModRegistry.ITEM_REGISTRY.register("polished_light_concrete", () -> new BlockItem(BlockInit.POLISHED_LIGHT_CONCRETE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> POLISHED_LIGHT_CONCRETE_STAIRS =  ModRegistry.ITEM_REGISTRY.register("polished_light_concrete_stairs", () -> new BlockItem(BlockInit.POLISHED_LIGHT_CONCRETE_STAIRS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> POLISHED_LIGHT_CONCRETE_SLAB =  ModRegistry.ITEM_REGISTRY.register("polished_light_concrete_slab", () -> new BlockItem(BlockInit.POLISHED_LIGHT_CONCRETE_SLAB.get(), standardProperties()));
	
	//Dark Concrete
	public static final RegistryObject<BlockItem> DARK_CONCRETE =  ModRegistry.ITEM_REGISTRY.register("dark_concrete", () -> new BlockItem(BlockInit.DARK_CONCRETE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> DARK_CONCRETE_STAIRS =  ModRegistry.ITEM_REGISTRY.register("dark_concrete_stairs", () -> new BlockItem(BlockInit.DARK_CONCRETE_STAIRS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> DARK_CONCRETE_SLAB =  ModRegistry.ITEM_REGISTRY.register("dark_concrete_slab", () -> new BlockItem(BlockInit.DARK_CONCRETE_SLAB.get(), standardProperties()));
	public static final RegistryObject<BlockItem> DARK_CONCRETE_WALL =  ModRegistry.ITEM_REGISTRY.register("dark_concrete_wall", () -> new BlockItem(BlockInit.DARK_CONCRETE_WALL.get(), standardProperties()));
	public static final RegistryObject<BlockItem> DARK_CONCRETE_PRESSURE_PLATE = ModRegistry.ITEM_REGISTRY.register("dark_concrete_pressure_plate", () -> new BlockItem(BlockInit.DARK_CONCRETE_PRESSURE_PLATE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> DARK_CONCRETE_BUTTON =  ModRegistry.ITEM_REGISTRY.register("dark_concrete_button", () -> new BlockItem(BlockInit.DARK_CONCRETE_BUTTON.get(), standardProperties()));
	
	//Polished Dark Concrete
	public static final RegistryObject<BlockItem> POLISHED_DARK_CONCRETE =  ModRegistry.ITEM_REGISTRY.register("polished_dark_concrete", () -> new BlockItem(BlockInit.POLISHED_DARK_CONCRETE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> POLISHED_DARK_CONCRETE_STAIRS =  ModRegistry.ITEM_REGISTRY.register("polished_dark_concrete_stairs", () -> new BlockItem(BlockInit.POLISHED_DARK_CONCRETE_STAIRS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> POLISHED_DARK_CONCRETE_SLAB =  ModRegistry.ITEM_REGISTRY.register("polished_dark_concrete_slab", () -> new BlockItem(BlockInit.POLISHED_DARK_CONCRETE_SLAB.get(), standardProperties()));

	//Wooden Planks
	public static final RegistryObject<BlockItem> WOODEN_PLANKS =  ModRegistry.ITEM_REGISTRY.register("wooden_planks", () -> new BlockItem(BlockInit.WOODEN_PLANKS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> WOODEN_PLANKS_STAIRS =  ModRegistry.ITEM_REGISTRY.register("wooden_planks_stairs", () -> new BlockItem(BlockInit.WOODEN_PLANKS_STAIRS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> WOODEN_PLANKS_SLAB =  ModRegistry.ITEM_REGISTRY.register("wooden_planks_slab", () -> new BlockItem(BlockInit.WOODEN_PLANKS_SLAB.get(), standardProperties()));
	public static final RegistryObject<BlockItem> WOODEN_PLANKS_FENCE =  ModRegistry.ITEM_REGISTRY.register("wooden_planks_fence", () -> new BlockItem(BlockInit.WOODEN_PLANKS_FENCE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> WOODEN_PLANKS_FENCE_GATE =  ModRegistry.ITEM_REGISTRY.register("wooden_planks_fence_gate", () -> new BlockItem(BlockInit.WOODEN_PLANKS_FENCE_GATE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> WOODEN_PLANKS_PRESSURE_PLATE = ModRegistry.ITEM_REGISTRY.register("wooden_planks_pressure_plate", () -> new BlockItem(BlockInit.WOODEN_PLANKS_PRESSURE_PLATE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> WOODEN_PLANKS_BUTTON =  ModRegistry.ITEM_REGISTRY.register("wooden_planks_button", () -> new BlockItem(BlockInit.WOODEN_PLANKS_BUTTON.get(), standardProperties()));
		
	//Wooden Planks
	public static final RegistryObject<BlockItem> REFINED_WOODEN_PLANKS =  ModRegistry.ITEM_REGISTRY.register("refined_wooden_planks", () -> new BlockItem(BlockInit.REFINED_WOODEN_PLANKS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> REFINED_WOODEN_PLANKS_STAIRS =  ModRegistry.ITEM_REGISTRY.register("refined_wooden_planks_stairs", () -> new BlockItem(BlockInit.REFINED_WOODEN_PLANKS_STAIRS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> REFINED_WOODEN_PLANKS_SLAB =  ModRegistry.ITEM_REGISTRY.register("refined_wooden_planks_slab", () -> new BlockItem(BlockInit.REFINED_WOODEN_PLANKS_SLAB.get(), standardProperties()));
	public static final RegistryObject<BlockItem> REFINED_WOODEN_PLANKS_FENCE =  ModRegistry.ITEM_REGISTRY.register("refined_wooden_planks_fence", () -> new BlockItem(BlockInit.REFINED_WOODEN_PLANKS_FENCE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> REFINED_WOODEN_PLANKS_FENCE_GATE =  ModRegistry.ITEM_REGISTRY.register("refined_wooden_planks_fence_gate", () -> new BlockItem(BlockInit.REFINED_WOODEN_PLANKS_FENCE_GATE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> REFINED_WOODEN_PLANKS_PRESSURE_PLATE = ModRegistry.ITEM_REGISTRY.register("refined_wooden_planks_pressure_plate", () -> new BlockItem(BlockInit.REFINED_WOODEN_PLANKS_PRESSURE_PLATE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> REFINED_WOODEN_PLANKS_BUTTON =  ModRegistry.ITEM_REGISTRY.register("refined_wooden_planks_button", () -> new BlockItem(BlockInit.REFINED_WOODEN_PLANKS_BUTTON.get(), standardProperties()));
	
	//Pavement
	public static final RegistryObject<BlockItem> PAVEMENT =  ModRegistry.ITEM_REGISTRY.register("pavement", () -> new BlockItem(BlockInit.PAVEMENT.get(), standardProperties()));
	public static final RegistryObject<BlockItem> PAVEMENT_SLOPE =  ModRegistry.ITEM_REGISTRY.register("pavement_slope", () -> new BlockItem(BlockInit.PAVEMENT_SLOPE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> RAISED_PAVEMENT =  ModRegistry.ITEM_REGISTRY.register("raised_pavement", () -> new BlockItem(BlockInit.RAISED_PAVEMENT.get(), standardProperties()));
	
	//Roads
	public static final RegistryObject<BlockItem> GRAVEL_ROAD = ModRegistry.ITEM_REGISTRY.register("gravel_road", () -> new BlockItem(BlockInit.GRAVEL_ROAD.get(), standardProperties()));
	public static final RegistryObject<BlockItem> RAISED_GRAVEL_ROAD = ModRegistry.ITEM_REGISTRY.register("raised_gravel_road", () -> new BlockItem(BlockInit.RAISED_GRAVEL_ROAD.get(), standardProperties()));
		
	public static final RegistryObject<BlockItem> DIRT_ROAD = ModRegistry.ITEM_REGISTRY.register("dirt_road", () -> new BlockItem(BlockInit.DIRT_ROAD.get(), standardProperties()));
	public static final RegistryObject<BlockItem> RAISED_DIRT_ROAD = ModRegistry.ITEM_REGISTRY.register("raised_dirt_road", () -> new BlockItem(BlockInit.RAISED_DIRT_ROAD.get(), standardProperties()));
			
	public static final RegistryObject<BlockItem> PAVED_ROAD = ModRegistry.ITEM_REGISTRY.register("paved_road", () -> new BlockItem(BlockInit.PAVED_ROAD.get(), standardProperties()));
	public static final RegistryObject<BlockItem> RAISED_PAVED_ROAD = ModRegistry.ITEM_REGISTRY.register("raised_paved_road", () -> new BlockItem(BlockInit.RAISED_PAVED_ROAD.get(), standardProperties()));
		
	//Tile
	public static final RegistryObject<BlockItem> TILE =  ModRegistry.ITEM_REGISTRY.register("tile", () -> new BlockItem(BlockInit.TILE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> TILE_STAIRS =  ModRegistry.ITEM_REGISTRY.register("tile_stairs", () -> new BlockItem(BlockInit.TILE_STAIRS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> TILE_SLAB =  ModRegistry.ITEM_REGISTRY.register("tile_slab", () -> new BlockItem(BlockInit.TILE_SLAB.get(), standardProperties()));

	//Metal Fence
	public static final RegistryObject<BlockItem> METAL_FENCE = ModRegistry.ITEM_REGISTRY.register("metal_fence", () -> new BlockItem(BlockInit.METAL_FENCE.get(), standardProperties()));

	//Clear Glass
	public static final RegistryObject<BlockItem> CLEAR_GLASS = ModRegistry.ITEM_REGISTRY.register("clear_glass", () -> new BlockItem(BlockInit.CLEAR_GLASS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> CLEAR_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("clear_glass_pane", () -> new BlockItem(BlockInit.CLEAR_GLASS_PANE.get(), standardProperties()));

	//Tinted Glass
	public static final RegistryObject<BlockItem> TINTED_GLASS = ModRegistry.ITEM_REGISTRY.register("tinted_glass", () -> new BlockItem(BlockInit.TINTED_GLASS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> TINTED_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("tinted_glass_pane", () -> new BlockItem(BlockInit.TINTED_GLASS_PANE.get(), standardProperties()));
	
	//Coloured Glass
	public static final RegistryObject<BlockItem> WHITE_GLASS = ModRegistry.ITEM_REGISTRY.register("white_glass", () -> new BlockItem(BlockInit.WHITE_GLASS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> WHITE_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("white_glass_pane", () -> new BlockItem(BlockInit.WHITE_GLASS_PANE.get(), standardProperties()));	
		
	public static final RegistryObject<BlockItem> LIGHT_GREY_GLASS = ModRegistry.ITEM_REGISTRY.register("light_grey_glass", () -> new BlockItem(BlockInit.LIGHT_GREY_GLASS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> LIGHT_GREY_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("light_grey_glass_pane", () -> new BlockItem(BlockInit.LIGHT_GREY_GLASS_PANE.get(), standardProperties()));	
		
	public static final RegistryObject<BlockItem> GREY_GLASS = ModRegistry.ITEM_REGISTRY.register("grey_glass", () -> new BlockItem(BlockInit.GREY_GLASS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> GREY_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("grey_glass_pane", () -> new BlockItem(BlockInit.GREY_GLASS_PANE.get(), standardProperties()));	
		
	public static final RegistryObject<BlockItem> BLACK_GLASS = ModRegistry.ITEM_REGISTRY.register("black_glass", () -> new BlockItem(BlockInit.BLACK_GLASS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> BLACK_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("black_glass_pane", () -> new BlockItem(BlockInit.BLACK_GLASS_PANE.get(), standardProperties()));	
		
	public static final RegistryObject<BlockItem> RED_GLASS = ModRegistry.ITEM_REGISTRY.register("red_glass", () -> new BlockItem(BlockInit.RED_GLASS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> RED_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("red_glass_pane", () -> new BlockItem(BlockInit.RED_GLASS_PANE.get(), standardProperties()));	
		
	public static final RegistryObject<BlockItem> ORANGE_GLASS = ModRegistry.ITEM_REGISTRY.register("orange_glass", () -> new BlockItem(BlockInit.ORANGE_GLASS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> ORANGE_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("orange_glass_pane", () -> new BlockItem(BlockInit.ORANGE_GLASS_PANE.get(), standardProperties()));	
	
	public static final RegistryObject<BlockItem> YELLOW_GLASS = ModRegistry.ITEM_REGISTRY.register("yellow_glass", () -> new BlockItem(BlockInit.YELLOW_GLASS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> YELLOW_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("yellow_glass_pane", () -> new BlockItem(BlockInit.YELLOW_GLASS_PANE.get(), standardProperties()));	
	
	public static final RegistryObject<BlockItem> LIME_GLASS = ModRegistry.ITEM_REGISTRY.register("lime_glass", () -> new BlockItem(BlockInit.LIME_GLASS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> LIME_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("lime_glass_pane", () -> new BlockItem(BlockInit.LIME_GLASS_PANE.get(), standardProperties()));	
		
	public static final RegistryObject<BlockItem> GREEN_GLASS = ModRegistry.ITEM_REGISTRY.register("green_glass", () -> new BlockItem(BlockInit.GREEN_GLASS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> GREEN_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("green_glass_pane", () -> new BlockItem(BlockInit.GREEN_GLASS_PANE.get(), standardProperties()));	
		
	public static final RegistryObject<BlockItem> CYAN_GLASS = ModRegistry.ITEM_REGISTRY.register("cyan_glass", () -> new BlockItem(BlockInit.CYAN_GLASS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> CYAN_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("cyan_glass_pane", () -> new BlockItem(BlockInit.CYAN_GLASS_PANE.get(), standardProperties()));	
		
	public static final RegistryObject<BlockItem> LIGHT_BLUE_GLASS = ModRegistry.ITEM_REGISTRY.register("light_blue_glass", () -> new BlockItem(BlockInit.LIGHT_BLUE_GLASS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> LIGHT_BLUE_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("light_blue_glass_pane", () -> new BlockItem(BlockInit.LIGHT_BLUE_GLASS_PANE.get(), standardProperties()));	
		
	public static final RegistryObject<BlockItem> BLUE_GLASS = ModRegistry.ITEM_REGISTRY.register("blue_glass", () -> new BlockItem(BlockInit.BLUE_GLASS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> BLUE_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("blue_glass_pane", () -> new BlockItem(BlockInit.BLUE_GLASS_PANE.get(), standardProperties()));	
		
	public static final RegistryObject<BlockItem> PURPLE_GLASS = ModRegistry.ITEM_REGISTRY.register("purple_glass", () -> new BlockItem(BlockInit.PURPLE_GLASS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> PURPLE_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("purple_glass_pane", () -> new BlockItem(BlockInit.PURPLE_GLASS_PANE.get(), standardProperties()));	
		
	public static final RegistryObject<BlockItem> MAGENTA_GLASS = ModRegistry.ITEM_REGISTRY.register("magenta_glass", () -> new BlockItem(BlockInit.MAGENTA_GLASS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> MAGENTA_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("magenta_glass_pane", () -> new BlockItem(BlockInit.MAGENTA_GLASS_PANE.get(), standardProperties()));	
		
	public static final RegistryObject<BlockItem> PINK_GLASS = ModRegistry.ITEM_REGISTRY.register("pink_glass", () -> new BlockItem(BlockInit.PINK_GLASS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> PINK_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("pink_glass_pane", () -> new BlockItem(BlockInit.PINK_GLASS_PANE.get(), standardProperties()));	
		
	public static final RegistryObject<BlockItem> BROWN_GLASS = ModRegistry.ITEM_REGISTRY.register("brown_glass", () -> new BlockItem(BlockInit.BROWN_GLASS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> BROWN_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("brown_glass_pane", () -> new BlockItem(BlockInit.BROWN_GLASS_PANE.get(), standardProperties()));	

	public static final RegistryObject<BlockItem> SHADED_GLASS = ModRegistry.ITEM_REGISTRY.register("shaded_glass", () -> new BlockItem(BlockInit.SHADED_GLASS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> SHADED_GLASS_PANE = ModRegistry.ITEM_REGISTRY.register("shaded_glass_pane", () -> new BlockItem(BlockInit.SHADED_GLASS_PANE.get(), standardProperties()));	
	
	//Coloured Blocks
	public static final RegistryObject<BlockItem> RED_DECORATION_BLOCK = ModRegistry.ITEM_REGISTRY.register("red_decoration_block", () -> new BlockItem(BlockInit.RED_DECORATION_BLOCK.get(), standardProperties()));
	public static final RegistryObject<BlockItem> ORANGE_DECORATION_BLOCK = ModRegistry.ITEM_REGISTRY.register("orange_decoration_block", () -> new BlockItem(BlockInit.ORANGE_DECORATION_BLOCK.get(), standardProperties()));	
	public static final RegistryObject<BlockItem> YELLOW_DECORATION_BLOCK = ModRegistry.ITEM_REGISTRY.register("yellow_decoration_block", () -> new BlockItem(BlockInit.YELLOW_DECORATION_BLOCK.get(), standardProperties()));
	public static final RegistryObject<BlockItem> LIME_DECORATION_BLOCK = ModRegistry.ITEM_REGISTRY.register("lime_decoration_block", () -> new BlockItem(BlockInit.LIME_DECORATION_BLOCK.get(), standardProperties()));
	public static final RegistryObject<BlockItem> GREEN_DECORATION_BLOCK = ModRegistry.ITEM_REGISTRY.register("green_decoration_block", () -> new BlockItem(BlockInit.GREEN_DECORATION_BLOCK.get(), standardProperties()));
	public static final RegistryObject<BlockItem> CYAN_DECORATION_BLOCK = ModRegistry.ITEM_REGISTRY.register("cyan_decoration_block", () -> new BlockItem(BlockInit.CYAN_DECORATION_BLOCK.get(), standardProperties()));	
	public static final RegistryObject<BlockItem> BLUE_DECORATION_BLOCK = ModRegistry.ITEM_REGISTRY.register("blue_decoration_block", () -> new BlockItem(BlockInit.BLUE_DECORATION_BLOCK.get(), standardProperties()));	
	public static final RegistryObject<BlockItem> LIGHT_BLUE_DECORATION_BLOCK = ModRegistry.ITEM_REGISTRY.register("light_blue_decoration_block", () -> new BlockItem(BlockInit.LIGHT_BLUE_DECORATION_BLOCK.get(), standardProperties()));	
	public static final RegistryObject<BlockItem> PURPLE_DECORATION_BLOCK = ModRegistry.ITEM_REGISTRY.register("purple_decoration_block", () -> new BlockItem(BlockInit.PURPLE_DECORATION_BLOCK.get(), standardProperties()));	
	public static final RegistryObject<BlockItem> MAGENTA_DECORATION_BLOCK = ModRegistry.ITEM_REGISTRY.register("magenta_decoration_block", () -> new BlockItem(BlockInit.MAGENTA_DECORATION_BLOCK.get(), standardProperties()));	
	public static final RegistryObject<BlockItem> PINK_DECORATION_BLOCK = ModRegistry.ITEM_REGISTRY.register("pink_decoration_block", () -> new BlockItem(BlockInit.PINK_DECORATION_BLOCK.get(), standardProperties()));	
	public static final RegistryObject<BlockItem> BROWN_DECORATION_BLOCK = ModRegistry.ITEM_REGISTRY.register("brown_decoration_block", () -> new BlockItem(BlockInit.BROWN_DECORATION_BLOCK.get(), standardProperties()));	
	public static final RegistryObject<BlockItem> GREY_DECORATION_BLOCK = ModRegistry.ITEM_REGISTRY.register("grey_decoration_block", () -> new BlockItem(BlockInit.GREY_DECORATION_BLOCK.get(), standardProperties()));	
	public static final RegistryObject<BlockItem> LIGHT_GREY_DECORATION_BLOCK = ModRegistry.ITEM_REGISTRY.register("light_grey_decoration_block", () -> new BlockItem(BlockInit.LIGHT_GREY_DECORATION_BLOCK.get(), standardProperties()));	
	public static final RegistryObject<BlockItem> WHITE_DECORATION_BLOCK = ModRegistry.ITEM_REGISTRY.register("white_decoration_block", () -> new BlockItem(BlockInit.WHITE_DECORATION_BLOCK.get(), standardProperties()));	
	public static final RegistryObject<BlockItem> BLACK_DECORATION_BLOCK = ModRegistry.ITEM_REGISTRY.register("black_decoration_block", () -> new BlockItem(BlockInit.BLACK_DECORATION_BLOCK.get(), standardProperties()));
	
	//Thatch
	public static final RegistryObject<BlockItem> THATCH_BLOCK =  ModRegistry.ITEM_REGISTRY.register("thatch_block", () -> new BlockItem(BlockInit.THATCH_BLOCK.get(), standardProperties()));
	
	//Doors
	public static final RegistryObject<BlockItem> OUTDOOR_TOILET_DOOR = ModRegistry.ITEM_REGISTRY.register("outdoor_toilet_door", () -> new BlockItem(BlockInit.OUTDOOR_TOILET_DOOR.get(), standardProperties()));
	public static final RegistryObject<BlockItem> GLASS_SHOP_DOOR = ModRegistry.ITEM_REGISTRY.register("glass_shop_door", () -> new BlockItem(BlockInit.GLASS_SHOP_DOOR.get(), standardProperties()));
	public static final RegistryObject<BlockItem> VISITOR_CENTRE_DOOR = ModRegistry.ITEM_REGISTRY.register("visitor_centre_door", () -> new BlockItem(BlockInit.VISITOR_CENTRE_DOOR.get(), standardProperties()));
	public static final RegistryObject<BlockItem> INNOVATION_CENTRE_DOOR = ModRegistry.ITEM_REGISTRY.register("innovation_centre_door", () -> new BlockItem(BlockInit.INNOVATION_CENTRE_DOOR.get(), standardProperties()));
	public static final RegistryObject<BlockItem> SECURITY_DOOR = ModRegistry.ITEM_REGISTRY.register("security_door", () -> new BlockItem(BlockInit.SECURITY_DOOR.get(), standardProperties()));
	public static final RegistryObject<BlockItem> BACK_DOOR = ModRegistry.ITEM_REGISTRY.register("back_door", () -> new BlockItem(BlockInit.BACK_DOOR.get(), standardProperties()));
	
	//Registry
	
	//Item Registers
	//Standard Properties
	public static Properties standardProperties()
	{
		return new Item.Properties().tab(ModItemGroup.TAB);
	}
	
	//Advanced Item Register
	private static RegistryObject<Item> advancedItemRegister(String id, Item item)
	{
		return ModRegistry.ITEM_REGISTRY.register(id, () -> item);
	}
	
	//Simple Item Register
	private static RegistryObject<Item> simpleItemRegister(String id, Item.Properties properties)
	{
		return advancedItemRegister(id, new Item(properties));
	}
	
	//Quick Register
	
	private static RegistryObject<Item> registerDNA(String type) 
	{
		return simpleItemRegister(type + "_dna", standardProperties());
	}
	
	private static RegistryObject<Item> registerDisc(String type)
	{
		return advancedItemRegister(type + "_dna_disc", new DiscItem(type + "_dna_disc", standardProperties().stacksTo(1)));
	}
	
	private static RegistryObject<Item> registerSpawn(String id)
	{
		return simpleItemRegister(id + "_spawn", standardProperties());
	}
	
	private static RegistryObject<Item> registerSpawnBucket(String id, NonNullSupplier<EntityType<?>> entity)
	{
		return advancedItemRegister(id + "_spawn_bucket", new ModFishBucketItem(id, entity, Fluids.WATER));
	}
	
	private static RegistryObject<Item> registerMeat(String type, Food food) 
	{
		return simpleItemRegister("raw_" + type + "_meat", standardProperties().food(food));
	}
	
	private static RegistryObject<Item> registerFishMeat(String type, Food food) 
	{
		return simpleItemRegister(type, standardProperties().food(food));
	}
	
	private static RegistryObject<Item> registerCookedMeat(String type, Food food) 
	{
		return simpleItemRegister("cooked_" + type + "_meat", standardProperties().food(food));
	}
	
	private static RegistryObject<Item> registerCookedFishMeat(String type, Food food) 
	{
		return simpleItemRegister("cooked_" + type, standardProperties().food(food));
	}
	
	private static RegistryObject<Item> registerSpawnEgg(String id, NonNullSupplier<EntityType<?>> entity, int primaryColour, int secondaryColour)
	{
		return advancedItemRegister(id + "_spawn_egg", new ModSpawnEggItem(entity, primaryColour, secondaryColour));
	}
	
	private static RegistryObject<Item> registerEntityBucket(String id, NonNullSupplier<EntityType<?>> entity)
	{
		return advancedItemRegister(id + "_bucket", new ModFishBucketItem(id, entity, Fluids.WATER));
	}
	
	public static void initItems() { }
}
