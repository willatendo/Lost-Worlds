 package lostworlds.core.init; 

import lostworlds.common.entities.ModBoatEntity.ModBoatType;
import lostworlds.common.items.DiscItem;
import lostworlds.common.items.FieldGuideItem;
import lostworlds.common.items.GreatAukEggItem;
import lostworlds.common.items.ModBlockItem;
import lostworlds.common.items.ModBoatItem;
import lostworlds.common.items.ModFishBucketItem;
import lostworlds.common.items.ModSignItem;
import lostworlds.common.items.ModSlabBurnableItem;
import lostworlds.common.items.ModSpawnEggItem;
import lostworlds.common.items.ModWoodBurnableItem;
import lostworlds.common.items.WetPaperItem;
import lostworlds.common.items.timebooks.JurassicTimeBook;
import lostworlds.common.items.timebooks.PermianTimeBook;
import lostworlds.common.tools.BrushItem;
import lostworlds.core.ModItemGroup;
import lostworlds.core.util.enums.ModItemTeir;
import lostworlds.core.util.registry.ModRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item.Properties;
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
	public static final RegistryObject<Item> LEATHER_BRUSH = ModRegistry.ITEM_REGISTRY.register("leather_brush", () -> new BrushItem(ModItemTeir.LEATHER_BRUSH, 1.5F, -3.0F, standardProperties().tab(ModItemGroup.TOOLS_TAB)));
	public static final RegistryObject<Item> IRON_BRUSH = ModRegistry.ITEM_REGISTRY.register("iron_brush", () -> new BrushItem(ModItemTeir.IRON_BRUSH, 1.5F, -3.0F, standardProperties().tab(ModItemGroup.TOOLS_TAB)));
	public static final RegistryObject<Item> GOLD_BRUSH = ModRegistry.ITEM_REGISTRY.register("gold_brush", () -> new BrushItem(ModItemTeir.GOLD_BRUSH, 1.5F, -3.0F, standardProperties().tab(ModItemGroup.TOOLS_TAB)));
	public static final RegistryObject<Item> DIAMOND_BRUSH = ModRegistry.ITEM_REGISTRY.register("diamond_brush", () -> new BrushItem(ModItemTeir.DIAMOND_BRUSH, 1.5F, -3.0F, standardProperties().tab(ModItemGroup.TOOLS_TAB)));
	
	//Plaster
	public static final RegistryObject<Item> WET_PAPER = advancedItemRegister("wet_paper", new WetPaperItem(standardProperties().tab(ModItemGroup.ITEMS_TAB)));

	//Field Guide
	public static final RegistryObject<Item> FEILD_GUIDE = ModRegistry.ITEM_REGISTRY.register("field_guide", () -> new FieldGuideItem(standardProperties().tab(ModItemGroup.ITEMS_TAB)));
	
	//Syringe
	public static final RegistryObject<Item> EMPTY_SYRINGE = simpleItemRegister("empty_syringe", standardProperties().stacksTo(1).tab(ModItemGroup.ITEMS_TAB));
	public static final RegistryObject<Item> BLOOD_SYRINGE = simpleItemRegister("blood_syringe", standardProperties().stacksTo(1).tab(ModItemGroup.ITEMS_TAB));
	
	//Viles
	public static final RegistryObject<Item> EMPTY_VILE = simpleItemRegister("empty_vile", standardProperties().tab(ModItemGroup.ITEMS_TAB));
	public static final RegistryObject<Item> BLOOD_VILE = simpleItemRegister("blood_vile", standardProperties().tab(ModItemGroup.ITEMS_TAB));

	//Time Books
	public static final RegistryObject<Item> PERMIAN_TIME_BOOK = ModRegistry.ITEM_REGISTRY.register("permian_time_book", () -> new PermianTimeBook(standardProperties().stacksTo(1).rarity(Rarity.RARE).tab(ModItemGroup.ITEMS_TAB)));
	public static final RegistryObject<Item> JURASSIC_TIME_BOOK = ModRegistry.ITEM_REGISTRY.register("jurassic_time_book", () -> new JurassicTimeBook(standardProperties().stacksTo(1).rarity(Rarity.RARE).tab(ModItemGroup.ITEMS_TAB)));
	
	//Time Lord's Staff
	public static final RegistryObject<Item> TIME_LORDS_STAFF = simpleItemRegister("time_lords_staff", new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).tab(ModItemGroup.ITEMS_TAB));
	
	//Leaf Litter
	public static final RegistryObject<Item> FERN_LITTER = advancedItemRegister("fern_litter", new Item(standardProperties().food(FoodInit.FERN_LITTER).stacksTo(16).tab(ModItemGroup.ITEMS_TAB)));
	
	//Procompsognathus
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_DNA = registerDNA("procompsognathus");
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_DNA_DISC = registerDisc("procompsognathus");
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_EGG = ModRegistry.ITEM_REGISTRY.register("procompsognathus_egg", () -> new BlockItem(BlockInit.PROCOMPSOGNATHUS_EGG.get(), standardProperties()));
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_MEAT = registerMeat("procompsognathus", FoodInit.RAW_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_COOKED_MEAT = registerCookedMeat("procompsognathus", FoodInit.COOKED_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_SPAWN_EGG = registerSpawnEgg("procompsognathus", () -> EntityInit.PROCOMPSOGNATHUS_ENTITY.get(), 0x125611, 0x143025);
	
	//Palaeoniscum
	public static final RegistryObject<Item> PALAEONISCUM_DNA = registerDNA("palaeoniscum");
	public static final RegistryObject<Item> PALAEONISCUM_DNA_DISC = registerDisc("palaeoniscum");
	public static final RegistryObject<Item> PALAEONISCUM_SPAWN = registerSpawn("palaeoniscum");
	public static final RegistryObject<Item> PALAEONISCUM_SPAWN_BUCKET = registerSpawnBucket("palaeoniscum", () -> EntityInit.PALAEONISCUM_ENTITY.get());
	public static final RegistryObject<Item> PALAEONISCUM_MEAT = registerFishMeat("palaeoniscum", FoodInit.RAW_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> PALAEONISCUM_COOKED_MEAT = registerCookedFishMeat("palaeoniscum", FoodInit.COOKED_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> PALAEONISCUM_SPAWN_EGG = registerSpawnEgg("palaeoniscum", () -> EntityInit.PALAEONISCUM_ENTITY.get(), 0x1e2f4f, 0x2b1838);
	public static final RegistryObject<Item> PALAEONISCUM_BUCKET = registerEntityBucket("palaeoniscum", () -> EntityInit.PALAEONISCUM_ENTITY.get());
	
	//Nautilus
	public static final RegistryObject<Item> NAUTILUS_DNA = registerDNA("nautilus");
	public static final RegistryObject<Item> NAUTILUS_DNA_DISC = registerDisc("nautilus");
	public static final RegistryObject<Item> NAUTILUS_SPAWN = registerSpawn("nautilus");
	public static final RegistryObject<Item> NAUTILUS_SPAWN_BUCKET = registerSpawnBucket("nautilus", () -> EntityInit.NAUTILUS_ENTITY.get());
	public static final RegistryObject<Item> NAUTILUS_TENTICAL = advancedItemRegister("nautilus_tentical", new Item(standardProperties().food(FoodInit.RAW_MEDIUM_DINOSAUR_MEAT)));
	public static final RegistryObject<Item> COOKED_NAUTILUS_TENTICAL = advancedItemRegister("cooked_nautilus_tentical", new Item(standardProperties().food(FoodInit.COOKED_MEDIUM_DINOSAUR_MEAT)));
	public static final RegistryObject<Item> NAUTILUS_SPAWN_EGG = registerSpawnEgg("nautilus", () -> EntityInit.NAUTILUS_ENTITY.get(), 0xd8cecd, 0x4f4841);
	public static final RegistryObject<Item> NAUTILUS_BUCKET = registerEntityBucket("nautilus", () -> EntityInit.NAUTILUS_ENTITY.get());
		
	//Rhinesuchus
	public static final RegistryObject<Item> RHINESUCHUS_DNA = registerDNA("rhinesuchus");
	public static final RegistryObject<Item> RHINESUCHUS_DNA_DISC = registerDisc("rhinesuchus");
	public static final RegistryObject<Item> RHINESUCHUS_SPAWN = registerSpawn("rhinesuchus");
	public static final RegistryObject<Item> RHINESUCHUS_SPAWN_BUCKET = registerSpawnBucket("rhinesuchus", () -> EntityInit.RHINESUCHUS_ENTITY.get());
	public static final RegistryObject<Item> RHINESUCHUS_MEAT = registerMeat("rhinesuchus", FoodInit.RAW_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> RHINESUCHUS_COOKED_MEAT = registerCookedMeat("rhinesuchus", FoodInit.COOKED_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> RHINESUCHUS_SPAWN_EGG = registerSpawnEgg("rhinesuchus", () -> EntityInit.RHINESUCHUS_ENTITY.get(), 0xceaa7b, 0x1c1308);
	
	//Dimetrodon
	public static final RegistryObject<Item> DIMETRODON_DNA = registerDNA("dimetrodon");
	public static final RegistryObject<Item> DIMETRODON_DNA_DISC = registerDisc("dimetrodon");
	public static final RegistryObject<Item> DIMETRODON_EGG = ModRegistry.ITEM_REGISTRY.register("dimetrodon_egg", () -> new BlockItem(BlockInit.DIMETRODON_EGG.get(), standardProperties()));
	public static final RegistryObject<Item> DIMETRODON_MEAT = registerMeat("dimetrodon", FoodInit.RAW_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> DIMETRODON_COOKED_MEAT = registerCookedMeat("dimetrodon", FoodInit.COOKED_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> DIMETRODON_SPAWN_EGG = registerSpawnEgg("dimetrodon", () -> EntityInit.DIMETRODON_ENTITY.get(), 0x378ca8, 0x152875);
	
	//Edaphosaurus
	public static final RegistryObject<Item> EDAPHOSAURUS_DNA = registerDNA("edaphosaurus");
	public static final RegistryObject<Item> EDAPHOSAURUS_DNA_DISC = registerDisc("edaphosaurus");
	public static final RegistryObject<Item> EDAPHOSAURUS_MEAT = registerMeat("edaphosaurus", FoodInit.RAW_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> EDAPHOSAURUS_COOKED_MEAT = registerCookedMeat("edaphosaurus", FoodInit.COOKED_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> EDAPHOSAURUS_EGG = ModRegistry.ITEM_REGISTRY.register("edaphosaurus_egg", () -> new BlockItem(BlockInit.EDAPHOSAURUS_EGG.get(), standardProperties()));
	public static final RegistryObject<Item> EDAPHOSAURUS_SPAWN_EGG = registerSpawnEgg("edaphosaurus", () -> EntityInit.EDAPHOSAURUS_ENTITY.get(), 0x96af42, 0x2a3016);

	//Gorgonops
	public static final RegistryObject<Item> GORGONOPS_DNA = registerDNA("gorgonops");
	public static final RegistryObject<Item> GORGONOPS_DNA_DISC = registerDisc("gorgonops");
	public static final RegistryObject<Item> GORGONOPS_EGG = ModRegistry.ITEM_REGISTRY.register("gorgonops_egg", () -> new BlockItem(BlockInit.GORGONOPS_EGG.get(), standardProperties()));
	public static final RegistryObject<Item> GORGONOPS_MEAT = registerMeat("gorgonops", FoodInit.RAW_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> GORGONOPS_COOKED_MEAT = registerCookedMeat("gorgonops", FoodInit.COOKED_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> GORGONOPS_SPAWN_EGG = registerSpawnEgg("gorgonops", () -> EntityInit.GORGONOPS_ENTITY.get(), 0x967d46, 0x4f2f1a);

	//Carnotaurus
	public static final RegistryObject<Item> CARNOTAURUS_DNA = registerDNA("carnotaurus");
	public static final RegistryObject<Item> CARNOTAURUS_DNA_DISC = registerDisc("carnotaurus");
	public static final RegistryObject<Item> CARNOTAURUS_EGG = ModRegistry.ITEM_REGISTRY.register("carnotaurus_egg", () -> new BlockItem(BlockInit.CARNOTAURUS_EGG.get(), standardProperties()));
	public static final RegistryObject<Item> CARNOTAURUS_MEAT = registerMeat("carnotaurus", FoodInit.RAW_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> CARNOTAURUS_COOKED_MEAT = registerCookedMeat("carnotaurus", FoodInit.COOKED_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> CARNOTAURUS_SPAWN_EGG = registerSpawnEgg("carnotaurus", () -> EntityInit.CARNOTAURUS_ENTITY.get(), 0x682324, 0x171c06);
	//Tyrannosaurus
	public static final RegistryObject<Item> TYRANNOSAURUS_DNA = registerDNA("tyrannosaurus");
	public static final RegistryObject<Item> TYRANNOSAURUS_DNA_DISC = registerDisc("tyrannosaurus");
	public static final RegistryObject<Item> TYRANNOSAURUS_EGG = ModRegistry.ITEM_REGISTRY.register("tyrannosaurus_egg", () -> new BlockItem(BlockInit.TYRANNOSAURUS_EGG.get(), standardProperties()));
	public static final RegistryObject<Item> TYRANNOSAURUS_MEAT = registerMeat("tyrannosaurus", FoodInit.RAW_LARGE_DINOSAUR_MEAT);
	public static final RegistryObject<Item> TYRANNOSAURUS_COOKED_MEAT = registerCookedMeat("tyrannosaurus", FoodInit.COOKED_LARGE_DINOSAUR_MEAT);
	public static final RegistryObject<Item> TYRANNOSAURUS_SPAWN_EGG = registerSpawnEgg("tyrannosaurus", () -> EntityInit.TYRANNOSAURUS_ENTITY.get(), 0x92b541, 0x125134);

	//Allosaurus
	public static final RegistryObject<Item> ALLOSAURUS_DNA = registerDNA("allosaurus");
	public static final RegistryObject<Item> ALLOSAURUS_DNA_DISC = registerDisc("allosaurus");
	public static final RegistryObject<Item> ALLOSAURUS_EGG = ModRegistry.ITEM_REGISTRY.register("allosaurus_egg", () -> new BlockItem(BlockInit.ALLOSAURUS_EGG.get(), standardProperties()));
	public static final RegistryObject<Item> ALLOSAURUS_MEAT = registerMeat("allosaurus", FoodInit.RAW_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> ALLOSAURUS_COOKED_MEAT = registerCookedMeat("allosaurus", FoodInit.COOKED_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> ALLOSAURUS_SPAWN_EGG = registerSpawnEgg("allosaurus", () -> EntityInit.ALLOSAURUS_ENTITY.get(), 0x687c35, 0x26300c);
	
	//Giganotosaurus
	public static final RegistryObject<Item> GIGANOTOSAURUS_DNA = registerDNA("giganotosaurus");
	public static final RegistryObject<Item> GIGANOTOSAURUS_DNA_DISC = registerDisc("giganotosaurus");
	public static final RegistryObject<Item> GIGANOTOSAURUS_EGG = ModRegistry.ITEM_REGISTRY.register("giganotosaurus_egg", () -> new BlockItem(BlockInit.GIGANOTOSAURUS_EGG.get(), standardProperties()));
	public static final RegistryObject<Item> GIGANOTOSAURUS_MEAT = registerMeat("giganotosaurus", FoodInit.RAW_LARGE_DINOSAUR_MEAT);
	public static final RegistryObject<Item> GIGANOTOSAURUS_COOKED_MEAT = registerCookedMeat("giganotosaurus", FoodInit.COOKED_LARGE_DINOSAUR_MEAT);
	public static final RegistryObject<Item> GIGANOTOSAURUS_SPAWN_EGG = registerSpawnEgg("giganotosaurus", () -> EntityInit.GIGANOTOSAURUS_ENTITY.get(), 0xd8a734, 0x4f391c);
	
	//Suchomimus
	public static final RegistryObject<Item> SUCHOMIMUS_DNA = registerDNA("suchomimus");
	public static final RegistryObject<Item> SUCHOMIMUS_DNA_DISC = registerDisc("suchomimus");
	public static final RegistryObject<Item> SUCHOMIMUS_EGG = ModRegistry.ITEM_REGISTRY.register("suchomimus_egg", () -> new BlockItem(BlockInit.SUCHOMIMUS_EGG.get(), standardProperties()));
	public static final RegistryObject<Item> SUCHOMIMUS_MEAT = registerMeat("suchomimus", FoodInit.RAW_LARGE_DINOSAUR_MEAT);
	public static final RegistryObject<Item> SUCHOMIMUS_COOKED_MEAT = registerCookedMeat("suchomimus", FoodInit.COOKED_LARGE_DINOSAUR_MEAT);
	public static final RegistryObject<Item> SUCHOMIMUS_SPAWN_EGG = registerSpawnEgg("suchomimus", () -> EntityInit.SUCHOMIMUS_ENTITY.get(), 0x6a94c1, 0x110f54);
	
	//Tetraceratops
	public static final RegistryObject<Item> TETRACERATOPS_DNA = registerDNA("tetraceratops");
	public static final RegistryObject<Item> TETRACERATOPS_DNA_DISC = registerDisc("tetraceratops");
	public static final RegistryObject<Item> TETRACERATOPS_EGG = ModRegistry.ITEM_REGISTRY.register("tetraceratops_egg", () -> new BlockItem(BlockInit.TETRACERATOPS_EGG.get(), standardProperties()));
	public static final RegistryObject<Item> TETRACERATOPS_MEAT = registerMeat("tetraceratops", FoodInit.RAW_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> TETRACERATOPS_COOKED_MEAT = registerCookedMeat("tetraceratops", FoodInit.COOKED_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> TETRACERATOPS_SPAWN_EGG = registerSpawnEgg("tetraceratops", () -> EntityInit.TETRACERATOPS_ENTITY.get(), 0x873624, 0x543b11);
	//Great Auk
	public static final RegistryObject<Item> GREAT_AUK_DNA = registerDNA("great_auk");
	public static final RegistryObject<Item> GREAT_AUK_DNA_DISC = registerDisc("great_auk");
	public static final RegistryObject<Item> GREAT_AUK_MEAT = registerMeat("great_auk", FoodInit.RAW_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> GREAT_AUK_COOKED_MEAT = registerCookedMeat("great_auk", FoodInit.COOKED_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> GREAT_AUK_EGG = advancedItemRegister("great_auk_egg", new GreatAukEggItem(standardProperties().stacksTo(16)));
	public static final RegistryObject<Item> GREAT_AUK_SPAWN_EGG = registerSpawnEgg("great_auk", () -> EntityInit.GREAT_AUK_ENTITY.get(), 0x000000, 0xFFFFFF);

	//Ouranosaurus
	public static final RegistryObject<Item> OURANOSAURUS_DNA = registerDNA("ouranosaurus");
	public static final RegistryObject<Item> OURANOSAURUS_DNA_DISC = registerDisc("ouranosaurus");
	public static final RegistryObject<Item> OURANOSAURUS_EGG = ModRegistry.ITEM_REGISTRY.register("ouranosaurus_egg", () -> new BlockItem(BlockInit.OURANOSAURUS_EGG.get(), standardProperties()));
	public static final RegistryObject<Item> OURANOSAURUS_MEAT = registerMeat("ouranosaurus", FoodInit.RAW_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> OURANOSAURUS_COOKED_MEAT = registerCookedMeat("ouranosaurus", FoodInit.COOKED_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> OURANOSAURUS_SPAWN_EGG = registerSpawnEgg("ouranosaurus", () -> EntityInit.OURANOSAURUS_ENTITY.get(), 0x2b3187, 0x1da6e5);

	//Fukuvenator
	public static final RegistryObject<Item> FUKUVENATOR_DNA = registerDNA("fukuivenator");
	public static final RegistryObject<Item> FUKUVENATOR_DNA_DISC = registerDisc("fukuivenator");
	public static final RegistryObject<Item> FUKUVENATOR_EGG = ModRegistry.ITEM_REGISTRY.register("fukuivenator_egg", () -> new BlockItem(BlockInit.FUKUVENATOR_EGG.get(), standardProperties()));
	public static final RegistryObject<Item> FUKUVENATOR_MEAT = registerMeat("fukuivenator", FoodInit.RAW_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> FUKUVENATOR_COOKED_MEAT = registerCookedMeat("fukuivenator", FoodInit.COOKED_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> FUKUVENATOR_SPAWN_EGG = registerSpawnEgg("fukuivenator", () -> EntityInit.FUKUIVENATOR_ENTITY.get(), 0xbb6ad8, 0x44284f);
	
	//Psittacosaurus
	public static final RegistryObject<Item> PSITTACOSAURUS_DNA = registerDNA("psittacosaurus");
	public static final RegistryObject<Item> PSITTACOSAURUS_DNA_DISC = registerDisc("psittacosaurus");
	public static final RegistryObject<Item> PSITTACOSAURUS_EGG = ModRegistry.ITEM_REGISTRY.register("psittacosaurus_egg", () -> new BlockItem(BlockInit.PSITTACOSAURUS_EGG.get(), standardProperties()));
	public static final RegistryObject<Item> PSITTACOSAURUS_MEAT = registerMeat("psittacosaurus", FoodInit.RAW_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> PSITTACOSAURUS_COOKED_MEAT = registerCookedMeat("psittacosaurus", FoodInit.COOKED_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> PSITTACOSAURUS_SPAWN_EGG = registerSpawnEgg("psittacosaurus", () -> EntityInit.PSITTACOSAURUS_ENTITY.get(), 0x6d4d20, 0x434c16);
	
	//Cryolophosaurus
	public static final RegistryObject<Item> CRYOLOPHOSAURUS_DNA = registerDNA("cryolophosaurus");
	public static final RegistryObject<Item> CRYOLOPHOSAURUS_DNA_DISC = registerDisc("cryolophosaurus");
	public static final RegistryObject<Item> CRYOLOPHOSAURUS_EGG = ModRegistry.ITEM_REGISTRY.register("cryolophosaurus", () -> new BlockItem(BlockInit.CRYOLOPHOSAURUS_EGG.get(), standardProperties()));
	public static final RegistryObject<Item> CRYOLOPHOSAURUS_MEAT = registerMeat("cryolophosaurus", FoodInit.RAW_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> CRYOLOPHOSAURUS_COOKED_MEAT = registerCookedMeat("cryolophosaurus", FoodInit.COOKED_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> CRYOLOPHOSAURUS_SPAWN_EGG = registerSpawnEgg("cryolophosaurus", () -> EntityInit.CRYOLOPHOSAURUS_ENTITY.get(), 0xcec21e, 0xce791e);

	//Protosuchus
	public static final RegistryObject<Item> PROTOSUCHUS_DNA = registerDNA("protosuchus");
	public static final RegistryObject<Item> PROTOSUCHUS_DNA_DISC = registerDisc("protosuchus");
	public static final RegistryObject<Item> PROTOSUCHUS_MEAT = registerMeat("protosuchus", FoodInit.RAW_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> PROTOSUCHUS_COOKED_MEAT = registerCookedMeat("protosuchus", FoodInit.COOKED_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> PROTOSUCHUS_SPAWN_EGG = registerSpawnEgg("protosuchus", () -> EntityInit.PROTOSUCHUS_ENTITY.get(), 0x773617, 0x470b0a);
	
	//Diictodon
	public static final RegistryObject<Item> DIICTODON_DNA = registerDNA("diictodon");
	public static final RegistryObject<Item> DIICTODON_DNA_DISC = registerDisc("diictodon");
	public static final RegistryObject<Item> DIICTODON_MEAT = registerMeat("diictodon", FoodInit.RAW_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> DIICTODON_COOKED_MEAT = registerCookedMeat("diictodon", FoodInit.COOKED_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> DIICTODON_SPAWN_EGG = registerSpawnEgg("diictodon", () -> EntityInit.DIICTODON_ENTITY.get(), 0x8e7022, 0x7a4334);
	
	//Mud Ball
	public static final RegistryObject<Item> MUD_BALL = simpleItemRegister("mud_ball", standardProperties().tab(ModItemGroup.ITEMS_TAB));
	
	//Copper	
	public static final RegistryObject<Item> COPPER_INGOT = simpleItemRegister("copper_ingot", standardProperties().tab(ModItemGroup.ITEMS_TAB));
	public static final RegistryObject<Item> COPPER_NUGGET = simpleItemRegister("copper_nugget", standardProperties().tab(ModItemGroup.ITEMS_TAB));
	
	//Electronics
	public static final RegistryObject<Item> COPPER_WIRE = simpleItemRegister("copper_wire", standardProperties().tab(ModItemGroup.ITEMS_TAB));	
	public static final RegistryObject<Item> COMPUTER_FAN = simpleItemRegister("computer_fan", standardProperties().tab(ModItemGroup.ITEMS_TAB));
	public static final RegistryObject<Item> COMPUTER_SCREEN = simpleItemRegister("computer_screen", standardProperties().tab(ModItemGroup.ITEMS_TAB));
	public static final RegistryObject<Item> COMPUTER_FRAME = simpleItemRegister("computer_frame", standardProperties().tab(ModItemGroup.ITEMS_TAB));
	public static final RegistryObject<Item> COMPUTER_STORAGE_PORT = simpleItemRegister("computer_storage_port", standardProperties().tab(ModItemGroup.ITEMS_TAB));
	public static final RegistryObject<Item> MOTHERBOARD = simpleItemRegister("motherboard", standardProperties().tab(ModItemGroup.ITEMS_TAB));
	public static final RegistryObject<Item> CPU = simpleItemRegister("cpu", standardProperties().tab(ModItemGroup.ITEMS_TAB));
	public static final RegistryObject<Item> RAM = simpleItemRegister("ram", standardProperties().tab(ModItemGroup.ITEMS_TAB));	
		
	//Storage
	public static final RegistryObject<Item> STORAGE_DISC = advancedItemRegister("storage_disc", new DiscItem("storage_disc", standardProperties().stacksTo(1).tab(ModItemGroup.ITEMS_TAB)));
		
	//Crystal Scarab	
	public static final RegistryObject<Item> BROKEN_CRYSTAL_SCARAB_GEM = simpleItemRegister("broken_crystal_scarab_gem", standardProperties().rarity(Rarity.RARE).tab(ModItemGroup.ITEMS_TAB));
	public static final RegistryObject<Item> CRYSTAL_SCARAB_GEM = simpleItemRegister("crystal_scarab_gem", standardProperties().rarity(Rarity.EPIC).tab(ModItemGroup.ITEMS_TAB));
	
	//Crystal Scarab Tools
	public static final RegistryObject<Item> CRYSTAL_SCARAB_SWORD = advancedItemRegister("crystal_scarab_sword", new SwordItem(ModItemTeir.SCARAB, 50, -2.4F, standardProperties().rarity(Rarity.EPIC).tab(ModItemGroup.ITEMS_TAB)));
	public static final RegistryObject<Item> CRYSTAL_SCARAB_SHOVEL = advancedItemRegister("crystal_scarab_shovel", new ShovelItem(ModItemTeir.SCARAB, 12.0F, -3.0F, standardProperties().rarity(Rarity.EPIC).tab(ModItemGroup.ITEMS_TAB)));
	public static final RegistryObject<Item> CRYSTAL_SCARAB_PICKAXE = advancedItemRegister("crystal_scarab_pickaxe", new PickaxeItem(ModItemTeir.SCARAB, 32, -2.8F, standardProperties().rarity(Rarity.EPIC).tab(ModItemGroup.ITEMS_TAB)));
	public static final RegistryObject<Item> CRYSTAL_SCARAB_AXE = advancedItemRegister("crystal_scarab_axe", new AxeItem(ModItemTeir.SCARAB, 70.0F, -3.2F, standardProperties().rarity(Rarity.EPIC).tab(ModItemGroup.ITEMS_TAB)));
	public static final RegistryObject<Item> CRYSTAL_SCARAB_HOE = advancedItemRegister("crystal_scarab_hoe", new HoeItem(ModItemTeir.SCARAB, 10, -3.0F, standardProperties().rarity(Rarity.EPIC).tab(ModItemGroup.ITEMS_TAB)));
		
	//Blocks
	//Ore
	public static final RegistryObject<BlockItem> COPPER_ORE = registerBlockItem("copper_ore", () -> BlockInit.COPPER_ORE.get(), ModItemGroup.ITEMS_TAB);
	
	//Fossil
	public static final RegistryObject<BlockItem> STONE_FOSSIL = registerFossilBlockItem("stone_fossil", () -> BlockInit.STONE_FOSSIL.get());
	public static final RegistryObject<BlockItem> EXPOSED_STONE_FOSSIL = registerFossilBlockItem("exposed_stone_fossil", () -> BlockInit.EXPOSED_STONE_FOSSIL.get());

	public static final RegistryObject<BlockItem> SANDSTONE_FOSSIL = registerFossilBlockItem("sandstone_fossil", () -> BlockInit.SANDSTONE_FOSSIL.get());
	public static final RegistryObject<BlockItem> EXPOSED_SANDSTONE_FOSSIL = registerFossilBlockItem("exposed_sandstone_fossil", () -> BlockInit.EXPOSED_SANDSTONE_FOSSIL.get());
	
	public static final RegistryObject<BlockItem> RED_SANDSTONE_FOSSIL = registerFossilBlockItem("red_sandstone_fossil", () -> BlockInit.RED_SANDSTONE_FOSSIL.get());
	public static final RegistryObject<BlockItem> EXPOSED_RED_SANDSTONE_FOSSIL = registerFossilBlockItem("exposed_red_sandstone_fossil", () -> BlockInit.EXPOSED_RED_SANDSTONE_FOSSIL.get());

	public static final RegistryObject<BlockItem> TERRACOTTA_FOSSIL = registerFossilBlockItem("terracotta_fossil", () -> BlockInit.TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> EXPOSED_TERRACOTTA_FOSSIL = registerFossilBlockItem("exposed_terracotta_fossil", () -> BlockInit.EXPOSED_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> RED_TERRACOTTA_FOSSIL = registerFossilBlockItem("red_terracotta_fossil", () -> BlockInit.RED_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> EXPOSED_RED_TERRACOTTA_FOSSIL = registerFossilBlockItem("exposed_red_terracotta_fossil", () -> BlockInit.EXPOSED_RED_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> ORANGE_TERRACOTTA_FOSSIL = registerFossilBlockItem("orange_terracotta_fossil", () -> BlockInit.ORANGE_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> EXPOSED_ORANGE_TERRACOTTA_FOSSIL = registerFossilBlockItem("exposed_orange_terracotta_fossil", () -> BlockInit.EXPOSED_ORANGE_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> YELLOW_TERRACOTTA_FOSSIL = registerFossilBlockItem("yellow_terracotta_fossil", () -> BlockInit.YELLOW_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> EXPOSED_YELLOW_TERRACOTTA_FOSSIL = registerFossilBlockItem("exposed_yellow_terracotta_fossil", () -> BlockInit.EXPOSED_YELLOW_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> LIME_TERRACOTTA_FOSSIL = registerFossilBlockItem("lime_terracotta_fossil", () -> BlockInit.LIME_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> EXPOSED_LIME_TERRACOTTA_FOSSIL = registerFossilBlockItem("exposed_lime_terracotta_fossil", () -> BlockInit.EXPOSED_LIME_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> GREEN_TERRACOTTA_FOSSIL = registerFossilBlockItem("green_terracotta_fossil", () -> BlockInit.GREEN_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> EXPOSED_GREEN_TERRACOTTA_FOSSIL = registerFossilBlockItem("exposed_green_terracotta_fossil", () -> BlockInit.EXPOSED_GREEN_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> CYAN_TERRACOTTA_FOSSIL = registerFossilBlockItem("cyan_terracotta_fossil", () -> BlockInit.CYAN_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> EXPOSED_CYAN_TERRACOTTA_FOSSIL = registerFossilBlockItem("exposed_cyan_terracotta_fossil", () -> BlockInit.EXPOSED_CYAN_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> LIGHT_BLUE_TERRACOTTA_FOSSIL = registerFossilBlockItem("light_blue_terracotta_fossil", () -> BlockInit.LIGHT_BLUE_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> EXPOSED_LIGHT_BLUE_TERRACOTTA_FOSSIL = registerFossilBlockItem("exposed_light_blue_terracotta_fossil", () -> BlockInit.EXPOSED_LIGHT_BLUE_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> BLUE_TERRACOTTA_FOSSIL = registerFossilBlockItem("blue_terracotta_fossil", () -> BlockInit.BLUE_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> EXPOSED_BLUE_TERRACOTTA_FOSSIL = registerFossilBlockItem("exposed_blue_terracotta_fossil", () -> BlockInit.EXPOSED_BLUE_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> MAGENTA_TERRACOTTA_FOSSIL = registerFossilBlockItem("magenta_terracotta_fossil", () -> BlockInit.MAGENTA_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> EXPOSED_MAGENTA_TERRACOTTA_FOSSIL = registerFossilBlockItem("exposed_magenta_terracotta_fossil", () -> BlockInit.EXPOSED_MAGENTA_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> PURPLE_TERRACOTTA_FOSSIL = registerFossilBlockItem("purple_terracotta_fossil", () -> BlockInit.PURPLE_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> EXPOSED_PURPLE_TERRACOTTA_FOSSIL = registerFossilBlockItem("exposed_purple_terracotta_fossil", () -> BlockInit.EXPOSED_PURPLE_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> PINK_TERRACOTTA_FOSSIL = registerFossilBlockItem("pink_terracotta_fossil", () -> BlockInit.PINK_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> EXPOSED_PINK_TERRACOTTA_FOSSIL = registerFossilBlockItem("exposed_pink_terracotta_fossil", () -> BlockInit.EXPOSED_PINK_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> BROWN_TERRACOTTA_FOSSIL = registerFossilBlockItem("brown_terracotta_fossil", () -> BlockInit.BROWN_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> EXPOSED_BROWN_TERRACOTTA_FOSSIL = registerFossilBlockItem("exposed_brown_terracotta_fossil", () -> BlockInit.EXPOSED_BROWN_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> BLACK_TERRACOTTA_FOSSIL = registerFossilBlockItem("black_terracotta_fossil", () -> BlockInit.BLACK_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> EXPOSED_BLACK_TERRACOTTA_FOSSIL = registerFossilBlockItem("exposed_black_terracotta_fossil", () -> BlockInit.EXPOSED_BLACK_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> GREY_TERRACOTTA_FOSSIL = registerFossilBlockItem("grey_terracotta_fossil", () -> BlockInit.GREY_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> EXPOSED_GREY_TERRACOTTA_FOSSIL = registerFossilBlockItem("exposed_grey_terracotta_fossil", () -> BlockInit.EXPOSED_GREY_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> LIGHT_GREY_TERRACOTTA_FOSSIL = registerFossilBlockItem("light_grey_terracotta_fossil", () -> BlockInit.LIGHT_GREY_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> EXPOSED_LIGHT_GREY_TERRACOTTA_FOSSIL = registerFossilBlockItem("exposed_light_grey_terracotta_fossil", () -> BlockInit.EXPOSED_LIGHT_GREY_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> WHITE_TERRACOTTA_FOSSIL = registerFossilBlockItem("white_terracotta_fossil", () -> BlockInit.WHITE_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<BlockItem> EXPOSED_WHITE_TERRACOTTA_FOSSIL = registerFossilBlockItem("exposed_white_terracotta_fossil", () -> BlockInit.EXPOSED_WHITE_TERRACOTTA_FOSSIL.get());
	
	public static final RegistryObject<BlockItem> PLASTERED_FOSSIL = registerFossilBlockItem("plastered_fossil", () -> BlockInit.PLASTERED_FOSSIL.get());

	//Fossil Processing
	
	
	public static final RegistryObject<BlockItem> POWER_SUPPLY_BLOCK = registerMachinesBlockItem("power_supply_block", () -> BlockInit.POWER_SUPPLY_BLOCK.get());

	//Mud
	public static final RegistryObject<BlockItem> MUD = registerNatureBlockItem("mud", () -> BlockInit.MUD.get());

	//Nesting Block
	public static final RegistryObject<BlockItem> NESTING_BLOCK = registerNatureBlockItem("nesting_block", () -> BlockInit.NESTING_BLOCK.get());

	//Time Machine
	public static final RegistryObject<BlockItem> TIME_MACHINE = registerMachinesBlockItem("time_machine", () -> BlockInit.TIME_MACHINE.get());
	
	//Museum Stuff
	public static final RegistryObject<BlockItem> ARCHAEOLOGY_TABLE = registerMachinesBlockItem("archaeology_table", () -> BlockInit.ARCHAEOLOGY_TABLE.get());
	//Volcanic Stuff
	public static final RegistryObject<BlockItem> VOLCANIC_ROCK = registerDecorativeBlockItem("volcanic_rock", () -> BlockInit.VOLCANIC_ROCK.get());	
	public static final RegistryObject<BlockItem> VOLCANIC_ROCK_STAIRS = registerDecorativeBlockItem("volcanic_rock_stairs", () -> BlockInit.VOLCANIC_ROCK_STAIRS.get());	
	public static final RegistryObject<BlockItem> VOLCANIC_ROCK_SLAB = registerDecorativeBlockItem("volcanic_rock_slab", () -> BlockInit.VOLCANIC_ROCK_SLAB.get());	
	public static final RegistryObject<BlockItem> VOLCANIC_ROCK_WALL = registerDecorativeBlockItem("volcanic_rock_wall", () -> BlockInit.VOLCANIC_ROCK_WALL.get());	
	
	public static final RegistryObject<BlockItem> POLISHED_VOLCANIC_ROCK = registerDecorativeBlockItem("polished_volcanic_rock", () -> BlockInit.POLISHED_VOLCANIC_ROCK.get());	
	public static final RegistryObject<BlockItem> POLISHED_VOLCANIC_ROCK_STAIRS = registerDecorativeBlockItem("polished_volcanic_rock_stairs", () -> BlockInit.POLISHED_VOLCANIC_ROCK_STAIRS.get());	
	public static final RegistryObject<BlockItem> POLISHED_VOLCANIC_ROCK_SLAB = registerDecorativeBlockItem("polished_volcanic_rock_slab", () -> BlockInit.POLISHED_VOLCANIC_ROCK_SLAB.get());	

	public static final RegistryObject<BlockItem> VOLCANIC_ASH = registerDecorativeBlockItem("volcanic_ash", () -> BlockInit.VOLCANIC_ASH.get());

	//Tunnel
	public static final RegistryObject<BlockItem> DIICTODON_BURROW = registerNatureBlockItem("diictodon_burrow", () -> BlockInit.DIICTODON_BURROW.get());
	public static final RegistryObject<BlockItem> TUNNELED_SOIL = registerNatureBlockItem("tunneled_soil", () -> BlockInit.TUNNELED_SOIL.get());
	
	//Permian
	//Sand
	public static final RegistryObject<BlockItem> PERMIAN_SAND = registerDecorativeBlockItem("permian_sand", () -> BlockInit.PERMIAN_SAND.get());

	//Stone
	public static final RegistryObject<BlockItem> PERMIAN_STONE = registerDecorativeBlockItem("permian_stone", () -> BlockInit.PERMIAN_STONE.get());
	public static final RegistryObject<BlockItem> PERMIAN_STONE_STAIRS = registerDecorativeBlockItem("permian_stone_stairs", () -> BlockInit.PERMIAN_STONE_STAIRS.get());
	public static final RegistryObject<BlockItem> PERMIAN_STONE_SLAB = registerDecorativeBlockItem("permian_stone_slab", () -> BlockInit.PERMIAN_STONE_SLAB.get());

	public static final RegistryObject<BlockItem> PERMIAN_COPPER_ORE = registerDecorativeBlockItem("permian_copper_ore", () -> BlockInit.PERMIAN_COPPER_ORE.get());
	public static final RegistryObject<BlockItem> PERMIAN_GOLD_ORE = registerDecorativeBlockItem("permian_gold_ore", () -> BlockInit.PERMIAN_GOLD_ORE.get());
	public static final RegistryObject<BlockItem> PERMIAN_IRON_ORE = registerDecorativeBlockItem("permian_iron_ore", () -> BlockInit.PERMIAN_IRON_ORE.get());
	public static final RegistryObject<BlockItem> PERMIAN_COAL_ORE = registerDecorativeBlockItem("permian_coal_ore", () -> BlockInit.PERMIAN_COAL_ORE.get());
	public static final RegistryObject<BlockItem> PERMIAN_LAPIS_ORE = registerDecorativeBlockItem("permian_lapis_ore", () -> BlockInit.PERMIAN_LAPIS_ORE.get());
	public static final RegistryObject<BlockItem> PERMIAN_DIAMOND_ORE = registerDecorativeBlockItem("permian_diamond_ore", () -> BlockInit.PERMIAN_DIAMOND_ORE.get());
	public static final RegistryObject<BlockItem> PERMIAN_REDSTONE_ORE = registerDecorativeBlockItem("permian_redstone_ore", () -> BlockInit.PERMIAN_REDSTONE_ORE.get());
	public static final RegistryObject<BlockItem> PERMIAN_EMERALD_ORE = registerDecorativeBlockItem("permian_emerald_ore", () -> BlockInit.PERMIAN_EMERALD_ORE.get());

	public static final RegistryObject<BlockItem> PERMIAN_COBBLESTONE = registerDecorativeBlockItem("permian_cobblestone", () -> BlockInit.PERMIAN_COBBLESTONE.get());
	public static final RegistryObject<BlockItem> PERMIAN_COBBLESTONE_STAIRS = registerDecorativeBlockItem("permian_cobblestone_stairs", () -> BlockInit.PERMIAN_COBBLESTONE_STAIRS.get());
	public static final RegistryObject<BlockItem> PERMIAN_COBBLESTONE_SLAB = registerDecorativeBlockItem("permian_cobblestone_slab", () -> BlockInit.PERMIAN_COBBLESTONE_SLAB.get());
	public static final RegistryObject<BlockItem> PERMIAN_COBBLESTONE_WALL = registerDecorativeBlockItem("permian_cobblestone_wall", () -> BlockInit.PERMIAN_COBBLESTONE_WALL.get());

	public static final RegistryObject<BlockItem> PERMIAN_STONE_BRICKS = registerDecorativeBlockItem("permian_stone_bricks", () -> BlockInit.PERMIAN_STONE_BRICKS.get());
	public static final RegistryObject<BlockItem> PERMIAN_STONE_BRICK_STAIRS = registerDecorativeBlockItem("permian_stone_brick_stairs", () -> BlockInit.PERMIAN_STONE_BRICK_STAIRS.get());
	public static final RegistryObject<BlockItem> PERMIAN_STONE_BRICK_SLAB = registerDecorativeBlockItem("permian_stone_brick_slab", () -> BlockInit.PERMIAN_STONE_BRICK_SLAB.get());
	public static final RegistryObject<BlockItem> PERMIAN_STONE_BRICK_WALL = registerDecorativeBlockItem("permian_stone_brick_wall", () -> BlockInit.PERMIAN_STONE_BRICK_WALL.get());

	//Flora
	public static final RegistryObject<BlockItem> SMALL_PERMIAN_DESERT_PLANT = registerNatureBlockItem("small_permian_desert_plant", () -> BlockInit.SMALL_PERMIAN_DESERT_PLANT.get());
	public static final RegistryObject<BlockItem> MEDIUM_PERMIAN_DESERT_PLANT = registerNatureBlockItem("medium_permian_desert_plant", () -> BlockInit.MEDIUM_PERMIAN_DESERT_PLANT.get());
	public static final RegistryObject<BlockItem> LARGE_PERMIAN_DESERT_PLANT = registerNatureBlockItem("large_permian_desert_plant", () -> BlockInit.LARGE_PERMIAN_DESERT_PLANT.get());

	public static final RegistryObject<BlockItem> GROUND_FERNS = registerNatureBlockItem("ground_ferns", () -> BlockInit.GROUND_FERNS.get());
	public static final RegistryObject<BlockItem> DICKSONIA = registerNatureBlockItem("dicksonia", () -> BlockInit.DICKSONIA.get());
	public static final RegistryObject<BlockItem> TALL_DICKSONIA = registerNatureBlockItem("tall_dicksonia", () -> BlockInit.TALL_DICKSONIA.get());

	public static final RegistryObject<BlockItem> DEAD_SPONGE_COLONY = registerNatureBlockItem("dead_sponge_colony", () -> BlockInit.DEAD_SPONGE_COLONY.get());
	public static final RegistryObject<BlockItem> SPONGE_COLONY = registerNatureBlockItem("sponge_colony", () -> BlockInit.SPONGE_COLONY.get());
	
	//Jurassic
	//Stone
	public static final RegistryObject<BlockItem> JURASSIC_STONE = registerDecorativeBlockItem("jurassic_stone", () -> BlockInit.JURASSIC_STONE.get());
	public static final RegistryObject<BlockItem> JURASSIC_STONE_STAIRS = registerDecorativeBlockItem("jurassic_stone_stairs", () -> BlockInit.JURASSIC_STONE_STAIRS.get());
	public static final RegistryObject<BlockItem> JURASSIC_STONE_SLAB = registerDecorativeBlockItem("jurassic_stone_slab", () -> BlockInit.JURASSIC_STONE_SLAB.get());

	public static final RegistryObject<BlockItem> JURASSIC_COPPER_ORE = registerDecorativeBlockItem("jurassic_copper_ore", () -> BlockInit.JURASSIC_COPPER_ORE.get());
	public static final RegistryObject<BlockItem> JURASSIC_GOLD_ORE = registerDecorativeBlockItem("jurassic_gold_ore", () -> BlockInit.JURASSIC_GOLD_ORE.get());
	public static final RegistryObject<BlockItem> JURASSIC_IRON_ORE = registerDecorativeBlockItem("jurassic_iron_ore", () -> BlockInit.JURASSIC_IRON_ORE.get());
	public static final RegistryObject<BlockItem> JURASSIC_COAL_ORE = registerDecorativeBlockItem("jurassic_coal_ore", () -> BlockInit.JURASSIC_COAL_ORE.get());
	public static final RegistryObject<BlockItem> JURASSIC_LAPIS_ORE = registerDecorativeBlockItem("jurassic_lapis_ore", () -> BlockInit.JURASSIC_LAPIS_ORE.get());
	public static final RegistryObject<BlockItem> JURASSIC_DIAMOND_ORE = registerDecorativeBlockItem("jurassic_diamond_ore", () -> BlockInit.JURASSIC_DIAMOND_ORE.get());
	public static final RegistryObject<BlockItem> JURASSIC_REDSTONE_ORE = registerDecorativeBlockItem("jurassic_redstone_ore", () -> BlockInit.JURASSIC_REDSTONE_ORE.get());
	public static final RegistryObject<BlockItem> JURASSIC_EMERALD_ORE = registerDecorativeBlockItem("jurassic_emerald_ore", () -> BlockInit.JURASSIC_EMERALD_ORE.get());
	
	public static final RegistryObject<BlockItem> MOSSY_JURASSIC_STONE = registerDecorativeBlockItem("mossy_jurassic_stone", () -> BlockInit.MOSSY_JURASSIC_STONE.get());
	public static final RegistryObject<BlockItem> MOSSY_JURASSIC_STONE_STAIRS = registerDecorativeBlockItem("mossy_jurassic_stone_stairs", () -> BlockInit.MOSSY_JURASSIC_STONE_STAIRS.get());
	public static final RegistryObject<BlockItem> MOSSY_JURASSIC_STONE_SLAB = registerDecorativeBlockItem("mossy_jurassic_stone_slab", () -> BlockInit.MOSSY_JURASSIC_STONE_SLAB.get());
	
	public static final RegistryObject<BlockItem> JURASSIC_COBBLESTONE = registerDecorativeBlockItem("jurassic_cobblestone", () -> BlockInit.JURASSIC_COBBLESTONE.get());
	public static final RegistryObject<BlockItem> JURASSIC_COBBLESTONE_STAIRS = registerDecorativeBlockItem("jurassic_cobblestone_stairs", () -> BlockInit.JURASSIC_COBBLESTONE_STAIRS.get());
	public static final RegistryObject<BlockItem> JURASSIC_COBBLESTONE_SLAB = registerDecorativeBlockItem("jurassic_cobblestone_slab", () -> BlockInit.JURASSIC_COBBLESTONE_SLAB.get());
	public static final RegistryObject<BlockItem> JURASSIC_COBBLESTONE_WALL = registerDecorativeBlockItem("jurassic_cobblestone_wall", () -> BlockInit.JURASSIC_COBBLESTONE_WALL.get());
	
	public static final RegistryObject<BlockItem> MOSSY_JURASSIC_COBBLESTONE = registerDecorativeBlockItem("mossy_jurassic_cobblestone", () -> BlockInit.MOSSY_JURASSIC_COBBLESTONE.get());
	public static final RegistryObject<BlockItem> MOSSY_JURASSIC_COBBLESTONE_STAIRS = registerDecorativeBlockItem("mossy_jurassic_cobblestone_stairs", () -> BlockInit.MOSSY_JURASSIC_COBBLESTONE_STAIRS.get());
	public static final RegistryObject<BlockItem> MOSSY_JURASSIC_COBBLESTONE_SLAB = registerDecorativeBlockItem("mossy_jurassic_cobblestone_slab", () -> BlockInit.MOSSY_JURASSIC_COBBLESTONE_SLAB.get());
	public static final RegistryObject<BlockItem> MOSSY_JURASSIC_COBBLESTONE_WALL = registerDecorativeBlockItem("mossy_jurassic_cobblestone_wall", () -> BlockInit.MOSSY_JURASSIC_COBBLESTONE_WALL.get());
	
	public static final RegistryObject<BlockItem> JURASSIC_STONE_BRICKS = registerDecorativeBlockItem("jurassic_stone_bricks", () -> BlockInit.JURASSIC_STONE_BRICKS.get());
	public static final RegistryObject<BlockItem> JURASSIC_STONE_BRICK_STAIRS = registerDecorativeBlockItem("jurassic_stone_brick_stairs", () -> BlockInit.JURASSIC_STONE_BRICK_STAIRS.get());
	public static final RegistryObject<BlockItem> JURASSIC_STONE_BRICK_SLAB = registerDecorativeBlockItem("jurassic_stone_brick_slab", () -> BlockInit.JURASSIC_STONE_BRICK_SLAB.get());
	public static final RegistryObject<BlockItem> JURASSIC_STONE_BRICK_WALL = registerDecorativeBlockItem("jurassic_stone_brick_wall", () -> BlockInit.JURASSIC_STONE_BRICK_WALL.get());
	
	public static final RegistryObject<BlockItem> MOSSY_JURASSIC_STONE_BRICKS = registerDecorativeBlockItem("mossy_jurassic_stone_bricks", () -> BlockInit.MOSSY_JURASSIC_STONE_BRICKS.get());
	public static final RegistryObject<BlockItem> MOSSY_JURASSIC_STONE_BRICK_STAIRS = registerDecorativeBlockItem("mossy_jurassic_stone_brick_stairs", () -> BlockInit.MOSSY_JURASSIC_STONE_BRICK_STAIRS.get());
	public static final RegistryObject<BlockItem> MOSSY_JURASSIC_STONE_BRICK_SLAB = registerDecorativeBlockItem("mossy_jurassic_stone_brick_slab", () -> BlockInit.MOSSY_JURASSIC_STONE_BRICK_SLAB.get());
	public static final RegistryObject<BlockItem> MOSSY_JURASSIC_STONE_BRICK_WALL = registerDecorativeBlockItem("mossy_jurassic_stone_brick_wall", () -> BlockInit.MOSSY_JURASSIC_STONE_BRICK_WALL.get());
	
	//Conifer
	public static final RegistryObject<BlockItem> CONIFER_LOG = registerBuringBlockItem("conifer_log", () -> BlockInit.CONIFER_LOG.get());
	public static final RegistryObject<BlockItem> CONIFER_WOOD = registerBuringBlockItem("conifer_wood", () -> BlockInit.CONIFER_WOOD.get());
	public static final RegistryObject<BlockItem> STRIPPED_CONIFER_LOG = registerBuringBlockItem("stripped_conifer_log", () -> BlockInit.STRIPPED_CONIFER_LOG.get());
	public static final RegistryObject<BlockItem> STRIPPED_CONIFER_WOOD = registerBuringBlockItem("stripped_conifer_wood", () -> BlockInit.STRIPPED_CONIFER_WOOD.get());
	public static final RegistryObject<BlockItem> CONIFER_LEAVES = registerDecorativeBlockItem("conifer_leaves", () -> BlockInit.CONIFER_LEAVES.get());
	public static final RegistryObject<BlockItem> CONIFER_SAPLING = registerBuringBlockItem("conifer_sapling", () -> BlockInit.CONIFER_SAPLING.get());
	public static final RegistryObject<BlockItem> CONIFER_PLANKS = registerBuringBlockItem("conifer_planks", () -> BlockInit.CONIFER_PLANKS.get());
	public static final RegistryObject<BlockItem> CONIFER_STAIRS = registerBuringBlockItem("conifer_stairs", () -> BlockInit.CONIFER_STAIRS.get());
	public static final RegistryObject<BlockItem> CONIFER_SLAB = registerBuringSlabItem("conifer_slab", () -> BlockInit.CONIFER_SLAB.get());
	public static final RegistryObject<BlockItem> CONIFER_FENCE = registerBuringBlockItem("conifer_fence", () -> BlockInit.CONIFER_FENCE.get());
	public static final RegistryObject<BlockItem> CONIFER_FENCE_GATE = registerBuringBlockItem("conifer_fence_gate", () -> BlockInit.CONIFER_FENCE_GATE.get());
	public static final RegistryObject<BlockItem> CONIFER_PRESSURE_PLATE = registerBuringBlockItem("conifer_pressure_plate", () -> BlockInit.CONIFER_PRESSURE_PLATE.get());
	public static final RegistryObject<BlockItem> CONIFER_BUTTON = registerBuringBlockItem("conifer_button", () -> BlockInit.CONIFER_BUTTON.get());
	public static final RegistryObject<BlockItem> CONIFER_TRAPDOOR = registerBuringBlockItem("conifer_trapdoor", () -> BlockInit.CONIFER_TRAPDOOR.get()); 
	public static final RegistryObject<BlockItem> CONIFER_DOOR = registerDecorativeBlockItem("conifer_door", () -> BlockInit.CONIFER_DOOR.get());
	public static final RegistryObject<ModSignItem> CONIFER_SIGN = ModRegistry.ITEM_REGISTRY.register("conifer_sign", () -> new ModSignItem(BlockInit.CONIFER_SIGN.get(), BlockInit.CONIFER_WALL_SIGN.get(), standardProperties()));
	public static final RegistryObject<ModBoatItem> CONIFER_BOAT = registerBoatItem("conifer_boat", ModBoatType.CONIFER);

	//Ginkgo
	public static final RegistryObject<BlockItem> GINKGO_LOG = registerBuringBlockItem("ginkgo_log", () -> BlockInit.GINKGO_LOG.get());
	public static final RegistryObject<BlockItem> GINKGO_WOOD = registerBuringBlockItem("ginkgo_wood", () -> BlockInit.GINKGO_WOOD.get());
	public static final RegistryObject<BlockItem> STRIPPED_GINKGO_LOG = registerBuringBlockItem("stripped_ginkgo_log", () -> BlockInit.STRIPPED_GINKGO_LOG.get());
	public static final RegistryObject<BlockItem> STRIPPED_GINKGO_WOOD = registerBuringBlockItem("stripped_ginkgo_wood", () -> BlockInit.STRIPPED_GINKGO_WOOD.get());
	public static final RegistryObject<BlockItem> GINKGO_LEAVES = registerDecorativeBlockItem("ginkgo_leaves", () -> BlockInit.GINKGO_LEAVES.get());
	public static final RegistryObject<BlockItem> GINKGO_SAPLING = registerBuringBlockItem("ginkgo_sapling", () -> BlockInit.GINKGO_SAPLING.get());
	public static final RegistryObject<BlockItem> GINKGO_PLANKS = registerBuringBlockItem("ginkgo_planks", () -> BlockInit.GINKGO_PLANKS.get());
	public static final RegistryObject<BlockItem> GINKGO_STAIRS = registerBuringBlockItem("ginkgo_stairs", () -> BlockInit.GINKGO_STAIRS.get());
	public static final RegistryObject<BlockItem> GINKGO_SLAB = registerBuringSlabItem("ginkgo_slab", () -> BlockInit.GINKGO_SLAB.get());
	public static final RegistryObject<BlockItem> GINKGO_FENCE = registerBuringBlockItem("ginkgo_fence", () -> BlockInit.GINKGO_FENCE.get());
	public static final RegistryObject<BlockItem> GINKGO_FENCE_GATE = registerBuringBlockItem("ginkgo_fence_gate", () -> BlockInit.GINKGO_FENCE_GATE.get());
	public static final RegistryObject<BlockItem> GINKGO_PRESSURE_PLATE = registerBuringBlockItem("ginkgo_pressure_plate", () -> BlockInit.GINKGO_PRESSURE_PLATE.get());
	public static final RegistryObject<BlockItem> GINKGO_BUTTON = registerBuringBlockItem("ginkgo_button", () -> BlockInit.GINKGO_BUTTON.get());
	public static final RegistryObject<BlockItem> GINKGO_TRAPDOOR = registerBuringBlockItem("ginkgo_trapdoor", () -> BlockInit.GINKGO_TRAPDOOR.get()); 
	public static final RegistryObject<BlockItem> GINKGO_DOOR = registerBuringBlockItem("ginkgo_door", () -> BlockInit.GINKGO_DOOR.get());
	public static final RegistryObject<ModSignItem> GINKGO_SIGN = ModRegistry.ITEM_REGISTRY.register("ginkgo_sign", () -> new ModSignItem(BlockInit.GINKGO_SIGN.get(), BlockInit.GINKGO_WALL_SIGN.get(), standardProperties()));
	public static final RegistryObject<ModBoatItem> GINKGO_BOAT = registerBoatItem("ginkgo_boat", ModBoatType.GINKGO);

	//Araucaria
	public static final RegistryObject<BlockItem> ARAUCARIA_LOG = registerBuringBlockItem("araucaria_log", () -> BlockInit.ARAUCARIA_LOG.get());
	public static final RegistryObject<BlockItem> ARAUCARIA_WOOD = registerBuringBlockItem("araucaria_wood", () -> BlockInit.ARAUCARIA_WOOD.get());
	public static final RegistryObject<BlockItem> STRIPPED_ARAUCARIA_LOG = registerBuringBlockItem("stripped_araucaria_log", () -> BlockInit.STRIPPED_ARAUCARIA_LOG.get());
	public static final RegistryObject<BlockItem> STRIPPED_ARAUCARIA_WOOD = registerBuringBlockItem("stripped_araucaria_wood", () -> BlockInit.STRIPPED_ARAUCARIA_WOOD.get());
	public static final RegistryObject<BlockItem> ARAUCARIA_LEAVES = registerDecorativeBlockItem("araucaria_leaves", () -> BlockInit.ARAUCARIA_LEAVES.get());
	public static final RegistryObject<BlockItem> ARAUCARIA_SAPLING = registerBuringBlockItem("araucaria_sapling", () -> BlockInit.ARAUCARIA_SAPLING.get());
	public static final RegistryObject<BlockItem> ARAUCARIA_PLANKS = registerBuringBlockItem("araucaria_planks", () -> BlockInit.ARAUCARIA_PLANKS.get());
	public static final RegistryObject<BlockItem> ARAUCARIA_STAIRS = registerBuringBlockItem("araucaria_stairs", () -> BlockInit.ARAUCARIA_STAIRS.get());
	public static final RegistryObject<BlockItem> ARAUCARIA_SLAB = registerBuringBlockItem("araucaria_slab", () -> BlockInit.ARAUCARIA_SLAB.get());
	public static final RegistryObject<BlockItem> ARAUCARIA_FENCE = registerBuringBlockItem("araucaria_fence", () -> BlockInit.ARAUCARIA_FENCE.get());
	public static final RegistryObject<BlockItem> ARAUCARIA_FENCE_GATE = registerBuringBlockItem("araucaria_fence_gate", () -> BlockInit.ARAUCARIA_FENCE_GATE.get());
	public static final RegistryObject<BlockItem> ARAUCARIA_PRESSURE_PLATE = registerBuringBlockItem("araucaria_pressure_plate", () -> BlockInit.ARAUCARIA_PRESSURE_PLATE.get());
	public static final RegistryObject<BlockItem> ARAUCARIA_BUTTON = registerBuringBlockItem("araucaria_button", () -> BlockInit.ARAUCARIA_BUTTON.get());
	public static final RegistryObject<BlockItem> ARAUCARIA_TRAPDOOR = registerBuringBlockItem("araucaria_trapdoor", () -> BlockInit.ARAUCARIA_TRAPDOOR.get());
	public static final RegistryObject<BlockItem> ARAUCARIA_DOOR = registerBuringBlockItem("araucaria_door", () -> BlockInit.ARAUCARIA_DOOR.get());
	public static final RegistryObject<ModSignItem> ARAUCARIA_SIGN = ModRegistry.ITEM_REGISTRY.register("araucaria_sign", () -> new ModSignItem(BlockInit.ARAUCARIA_SIGN.get(), BlockInit.ARAUCARIA_WALL_SIGN.get(), standardProperties()));
	public static final RegistryObject<ModBoatItem> ARAUCARIA_BOAT = registerBoatItem("araucaria_boat", ModBoatType.ARAUCARIA);
	
	//Light Concrete
	public static final RegistryObject<BlockItem> LIGHT_CONCRETE =  registerDecorativeBlockItem("light_concrete", () -> BlockInit.LIGHT_CONCRETE.get());
	public static final RegistryObject<BlockItem> LIGHT_CONCRETE_STAIRS =  registerDecorativeBlockItem("light_concrete_stairs", () -> BlockInit.LIGHT_CONCRETE_STAIRS.get());
	public static final RegistryObject<BlockItem> LIGHT_CONCRETE_SLAB =  registerDecorativeBlockItem("light_concrete_slab", () -> BlockInit.LIGHT_CONCRETE_SLAB.get());
	public static final RegistryObject<BlockItem> LIGHT_CONCRETE_WALL =  registerDecorativeBlockItem("light_concrete_wall", () -> BlockInit.LIGHT_CONCRETE_WALL.get());
	public static final RegistryObject<BlockItem> LIGHT_CONCRETE_PRESSURE_PLATE = registerDecorativeBlockItem("light_concrete_pressure_plate", () -> BlockInit.LIGHT_CONCRETE_PRESSURE_PLATE.get());
	public static final RegistryObject<BlockItem> LIGHT_CONCRETE_BUTTON =  registerDecorativeBlockItem("light_concrete_button", () -> BlockInit.LIGHT_CONCRETE_BUTTON.get());
	
	//Polished Light Concrete
	public static final RegistryObject<BlockItem> POLISHED_LIGHT_CONCRETE =  registerDecorativeBlockItem("polished_light_concrete", () -> BlockInit.POLISHED_LIGHT_CONCRETE.get());
	public static final RegistryObject<BlockItem> POLISHED_LIGHT_CONCRETE_STAIRS =  registerDecorativeBlockItem("polished_light_concrete_stairs", () -> BlockInit.POLISHED_LIGHT_CONCRETE_STAIRS.get());
	public static final RegistryObject<BlockItem> POLISHED_LIGHT_CONCRETE_SLAB =  registerDecorativeBlockItem("polished_light_concrete_slab", () -> BlockInit.POLISHED_LIGHT_CONCRETE_SLAB.get());
	
	//Dark Concrete
	public static final RegistryObject<BlockItem> DARK_CONCRETE =  registerDecorativeBlockItem("dark_concrete", () -> BlockInit.DARK_CONCRETE.get());
	public static final RegistryObject<BlockItem> DARK_CONCRETE_STAIRS =  registerDecorativeBlockItem("dark_concrete_stairs", () -> BlockInit.DARK_CONCRETE_STAIRS.get());
	public static final RegistryObject<BlockItem> DARK_CONCRETE_SLAB =  registerDecorativeBlockItem("dark_concrete_slab", () -> BlockInit.DARK_CONCRETE_SLAB.get());
	public static final RegistryObject<BlockItem> DARK_CONCRETE_WALL =  registerDecorativeBlockItem("dark_concrete_wall", () -> BlockInit.DARK_CONCRETE_WALL.get());
	public static final RegistryObject<BlockItem> DARK_CONCRETE_PRESSURE_PLATE = registerDecorativeBlockItem("dark_concrete_pressure_plate", () -> BlockInit.DARK_CONCRETE_PRESSURE_PLATE.get());
	public static final RegistryObject<BlockItem> DARK_CONCRETE_BUTTON =  registerDecorativeBlockItem("dark_concrete_button", () -> BlockInit.DARK_CONCRETE_BUTTON.get());
	
	//Polished Dark Concrete
	public static final RegistryObject<BlockItem> POLISHED_DARK_CONCRETE =  registerDecorativeBlockItem("polished_dark_concrete", () -> BlockInit.POLISHED_DARK_CONCRETE.get());
	public static final RegistryObject<BlockItem> POLISHED_DARK_CONCRETE_STAIRS =  registerDecorativeBlockItem("polished_dark_concrete_stairs", () -> BlockInit.POLISHED_DARK_CONCRETE_STAIRS.get());
	public static final RegistryObject<BlockItem> POLISHED_DARK_CONCRETE_SLAB =  registerDecorativeBlockItem("polished_dark_concrete_slab", () -> BlockInit.POLISHED_DARK_CONCRETE_SLAB.get());

	//Wooden Planks
	public static final RegistryObject<BlockItem> WOODEN_PLANKS =  registerDecorativeBlockItem("wooden_planks", () -> BlockInit.WOODEN_PLANKS.get());
	public static final RegistryObject<BlockItem> WOODEN_PLANKS_STAIRS =  registerDecorativeBlockItem("wooden_planks_stairs", () -> BlockInit.WOODEN_PLANKS_STAIRS.get());
	public static final RegistryObject<BlockItem> WOODEN_PLANKS_SLAB =  registerDecorativeBlockItem("wooden_planks_slab", () -> BlockInit.WOODEN_PLANKS_SLAB.get());
	public static final RegistryObject<BlockItem> WOODEN_PLANKS_FENCE =  registerDecorativeBlockItem("wooden_planks_fence", () -> BlockInit.WOODEN_PLANKS_FENCE.get());
	public static final RegistryObject<BlockItem> WOODEN_PLANKS_FENCE_GATE =  registerDecorativeBlockItem("wooden_planks_fence_gate", () -> BlockInit.WOODEN_PLANKS_FENCE_GATE.get());
	public static final RegistryObject<BlockItem> WOODEN_PLANKS_PRESSURE_PLATE = registerDecorativeBlockItem("wooden_planks_pressure_plate", () -> BlockInit.WOODEN_PLANKS_PRESSURE_PLATE.get());
	public static final RegistryObject<BlockItem> WOODEN_PLANKS_BUTTON =  registerDecorativeBlockItem("wooden_planks_button", () -> BlockInit.WOODEN_PLANKS_BUTTON.get());
		
	//Wooden Planks
	public static final RegistryObject<BlockItem> REFINED_WOODEN_PLANKS =  registerDecorativeBlockItem("refined_wooden_planks", () -> BlockInit.REFINED_WOODEN_PLANKS.get());
	public static final RegistryObject<BlockItem> REFINED_WOODEN_PLANKS_STAIRS =  registerDecorativeBlockItem("refined_wooden_planks_stairs", () -> BlockInit.REFINED_WOODEN_PLANKS_STAIRS.get());
	public static final RegistryObject<BlockItem> REFINED_WOODEN_PLANKS_SLAB =  registerDecorativeBlockItem("refined_wooden_planks_slab", () -> BlockInit.REFINED_WOODEN_PLANKS_SLAB.get());
	public static final RegistryObject<BlockItem> REFINED_WOODEN_PLANKS_FENCE =  registerDecorativeBlockItem("refined_wooden_planks_fence", () -> BlockInit.REFINED_WOODEN_PLANKS_FENCE.get());
	public static final RegistryObject<BlockItem> REFINED_WOODEN_PLANKS_FENCE_GATE =  registerDecorativeBlockItem("refined_wooden_planks_fence_gate", () -> BlockInit.REFINED_WOODEN_PLANKS_FENCE_GATE.get());
	public static final RegistryObject<BlockItem> REFINED_WOODEN_PLANKS_PRESSURE_PLATE = registerDecorativeBlockItem("refined_wooden_planks_pressure_plate", () -> BlockInit.REFINED_WOODEN_PLANKS_PRESSURE_PLATE.get());
	public static final RegistryObject<BlockItem> REFINED_WOODEN_PLANKS_BUTTON =  registerDecorativeBlockItem("refined_wooden_planks_button", () -> BlockInit.REFINED_WOODEN_PLANKS_BUTTON.get());
	
	//Pavement
	public static final RegistryObject<BlockItem> PAVEMENT =  registerDecorativeBlockItem("pavement", () -> BlockInit.PAVEMENT.get());
	public static final RegistryObject<BlockItem> PAVEMENT_SLOPE =  registerDecorativeBlockItem("pavement_slope", () -> BlockInit.PAVEMENT_SLOPE.get());
	public static final RegistryObject<BlockItem> RAISED_PAVEMENT =  registerDecorativeBlockItem("raised_pavement", () -> BlockInit.RAISED_PAVEMENT.get());
	
	//Roads
	public static final RegistryObject<BlockItem> GRAVEL_ROAD = registerDecorativeBlockItem("gravel_road", () -> BlockInit.GRAVEL_ROAD.get());
	public static final RegistryObject<BlockItem> RAISED_GRAVEL_ROAD = registerDecorativeBlockItem("raised_gravel_road", () -> BlockInit.RAISED_GRAVEL_ROAD.get());
		
	public static final RegistryObject<BlockItem> DIRT_ROAD = registerDecorativeBlockItem("dirt_road", () -> BlockInit.DIRT_ROAD.get());
	public static final RegistryObject<BlockItem> RAISED_DIRT_ROAD = registerDecorativeBlockItem("raised_dirt_road", () -> BlockInit.RAISED_DIRT_ROAD.get());
			
	public static final RegistryObject<BlockItem> PAVED_ROAD = registerDecorativeBlockItem("paved_road", () -> BlockInit.PAVED_ROAD.get());
	public static final RegistryObject<BlockItem> RAISED_PAVED_ROAD = registerDecorativeBlockItem("raised_paved_road", () -> BlockInit.RAISED_PAVED_ROAD.get());
		
	//Tile
	public static final RegistryObject<BlockItem> TILE =  registerDecorativeBlockItem("tile", () -> BlockInit.TILE.get());
	public static final RegistryObject<BlockItem> TILE_STAIRS =  registerDecorativeBlockItem("tile_stairs", () -> BlockInit.TILE_STAIRS.get());
	public static final RegistryObject<BlockItem> TILE_SLAB =  registerDecorativeBlockItem("tile_slab", () -> BlockInit.TILE_SLAB.get());

	//Metal Fence
	public static final RegistryObject<BlockItem> METAL_FENCE = registerDecorativeBlockItem("metal_fence", () -> BlockInit.METAL_FENCE.get());

	//Clear Glass
	public static final RegistryObject<BlockItem> CLEAR_GLASS = registerDecorativeBlockItem("clear_glass", () -> BlockInit.CLEAR_GLASS.get());
	public static final RegistryObject<BlockItem> CLEAR_GLASS_PANE = registerDecorativeBlockItem("clear_glass_pane", () -> BlockInit.CLEAR_GLASS_PANE.get());

	//Tinted Glass
	public static final RegistryObject<BlockItem> TINTED_GLASS = registerDecorativeBlockItem("tinted_glass", () -> BlockInit.TINTED_GLASS.get());
	public static final RegistryObject<BlockItem> TINTED_GLASS_PANE = registerDecorativeBlockItem("tinted_glass_pane", () -> BlockInit.TINTED_GLASS_PANE.get());
	
	//Coloured Glass
	public static final RegistryObject<BlockItem> WHITE_GLASS = registerDecorativeBlockItem("white_glass", () -> BlockInit.WHITE_GLASS.get());
	public static final RegistryObject<BlockItem> WHITE_GLASS_PANE = registerDecorativeBlockItem("white_glass_pane", () -> BlockInit.WHITE_GLASS_PANE.get());	
		
	public static final RegistryObject<BlockItem> LIGHT_GREY_GLASS = registerDecorativeBlockItem("light_grey_glass", () -> BlockInit.LIGHT_GREY_GLASS.get());
	public static final RegistryObject<BlockItem> LIGHT_GREY_GLASS_PANE = registerDecorativeBlockItem("light_grey_glass_pane", () -> BlockInit.LIGHT_GREY_GLASS_PANE.get());	
		
	public static final RegistryObject<BlockItem> GREY_GLASS = registerDecorativeBlockItem("grey_glass", () -> BlockInit.GREY_GLASS.get());
	public static final RegistryObject<BlockItem> GREY_GLASS_PANE = registerDecorativeBlockItem("grey_glass_pane", () -> BlockInit.GREY_GLASS_PANE.get());	
		
	public static final RegistryObject<BlockItem> BLACK_GLASS = registerDecorativeBlockItem("black_glass", () -> BlockInit.BLACK_GLASS.get());
	public static final RegistryObject<BlockItem> BLACK_GLASS_PANE = registerDecorativeBlockItem("black_glass_pane", () -> BlockInit.BLACK_GLASS_PANE.get());	
		
	public static final RegistryObject<BlockItem> RED_GLASS = registerDecorativeBlockItem("red_glass", () -> BlockInit.RED_GLASS.get());
	public static final RegistryObject<BlockItem> RED_GLASS_PANE = registerDecorativeBlockItem("red_glass_pane", () -> BlockInit.RED_GLASS_PANE.get());	
		
	public static final RegistryObject<BlockItem> ORANGE_GLASS = registerDecorativeBlockItem("orange_glass", () -> BlockInit.ORANGE_GLASS.get());
	public static final RegistryObject<BlockItem> ORANGE_GLASS_PANE = registerDecorativeBlockItem("orange_glass_pane", () -> BlockInit.ORANGE_GLASS_PANE.get());	
	
	public static final RegistryObject<BlockItem> YELLOW_GLASS = registerDecorativeBlockItem("yellow_glass", () -> BlockInit.YELLOW_GLASS.get());
	public static final RegistryObject<BlockItem> YELLOW_GLASS_PANE = registerDecorativeBlockItem("yellow_glass_pane", () -> BlockInit.YELLOW_GLASS_PANE.get());	
	
	public static final RegistryObject<BlockItem> LIME_GLASS = registerDecorativeBlockItem("lime_glass", () -> BlockInit.LIME_GLASS.get());
	public static final RegistryObject<BlockItem> LIME_GLASS_PANE = registerDecorativeBlockItem("lime_glass_pane", () -> BlockInit.LIME_GLASS_PANE.get());	
		
	public static final RegistryObject<BlockItem> GREEN_GLASS = registerDecorativeBlockItem("green_glass", () -> BlockInit.GREEN_GLASS.get());
	public static final RegistryObject<BlockItem> GREEN_GLASS_PANE = registerDecorativeBlockItem("green_glass_pane", () -> BlockInit.GREEN_GLASS_PANE.get());	
		
	public static final RegistryObject<BlockItem> CYAN_GLASS = registerDecorativeBlockItem("cyan_glass", () -> BlockInit.CYAN_GLASS.get());
	public static final RegistryObject<BlockItem> CYAN_GLASS_PANE = registerDecorativeBlockItem("cyan_glass_pane", () -> BlockInit.CYAN_GLASS_PANE.get());	
		
	public static final RegistryObject<BlockItem> LIGHT_BLUE_GLASS = registerDecorativeBlockItem("light_blue_glass", () -> BlockInit.LIGHT_BLUE_GLASS.get());
	public static final RegistryObject<BlockItem> LIGHT_BLUE_GLASS_PANE = registerDecorativeBlockItem("light_blue_glass_pane", () -> BlockInit.LIGHT_BLUE_GLASS_PANE.get());	
		
	public static final RegistryObject<BlockItem> BLUE_GLASS = registerDecorativeBlockItem("blue_glass", () -> BlockInit.BLUE_GLASS.get());
	public static final RegistryObject<BlockItem> BLUE_GLASS_PANE = registerDecorativeBlockItem("blue_glass_pane", () -> BlockInit.BLUE_GLASS_PANE.get());	
		
	public static final RegistryObject<BlockItem> PURPLE_GLASS = registerDecorativeBlockItem("purple_glass", () -> BlockInit.PURPLE_GLASS.get());
	public static final RegistryObject<BlockItem> PURPLE_GLASS_PANE = registerDecorativeBlockItem("purple_glass_pane", () -> BlockInit.PURPLE_GLASS_PANE.get());	
		
	public static final RegistryObject<BlockItem> MAGENTA_GLASS = registerDecorativeBlockItem("magenta_glass", () -> BlockInit.MAGENTA_GLASS.get());
	public static final RegistryObject<BlockItem> MAGENTA_GLASS_PANE = registerDecorativeBlockItem("magenta_glass_pane", () -> BlockInit.MAGENTA_GLASS_PANE.get());	
		
	public static final RegistryObject<BlockItem> PINK_GLASS = registerDecorativeBlockItem("pink_glass", () -> BlockInit.PINK_GLASS.get());
	public static final RegistryObject<BlockItem> PINK_GLASS_PANE = registerDecorativeBlockItem("pink_glass_pane", () -> BlockInit.PINK_GLASS_PANE.get());	
		
	public static final RegistryObject<BlockItem> BROWN_GLASS = registerDecorativeBlockItem("brown_glass", () -> BlockInit.BROWN_GLASS.get());
	public static final RegistryObject<BlockItem> BROWN_GLASS_PANE = registerDecorativeBlockItem("brown_glass_pane", () -> BlockInit.BROWN_GLASS_PANE.get());	

	public static final RegistryObject<BlockItem> SHADED_GLASS = registerDecorativeBlockItem("shaded_glass", () -> BlockInit.SHADED_GLASS.get());
	public static final RegistryObject<BlockItem> SHADED_GLASS_PANE = registerDecorativeBlockItem("shaded_glass_pane", () -> BlockInit.SHADED_GLASS_PANE.get());	
	
	//Coloured Blocks
	public static final RegistryObject<BlockItem> RED_DECORATION_BLOCK = registerDecorativeBlockItem("red_decoration_block", () -> BlockInit.RED_DECORATION_BLOCK.get());
	public static final RegistryObject<BlockItem> ORANGE_DECORATION_BLOCK = registerDecorativeBlockItem("orange_decoration_block", () -> BlockInit.ORANGE_DECORATION_BLOCK.get());	
	public static final RegistryObject<BlockItem> YELLOW_DECORATION_BLOCK = registerDecorativeBlockItem("yellow_decoration_block", () -> BlockInit.YELLOW_DECORATION_BLOCK.get());
	public static final RegistryObject<BlockItem> LIME_DECORATION_BLOCK = registerDecorativeBlockItem("lime_decoration_block", () -> BlockInit.LIME_DECORATION_BLOCK.get());
	public static final RegistryObject<BlockItem> GREEN_DECORATION_BLOCK = registerDecorativeBlockItem("green_decoration_block", () -> BlockInit.GREEN_DECORATION_BLOCK.get());
	public static final RegistryObject<BlockItem> CYAN_DECORATION_BLOCK = registerDecorativeBlockItem("cyan_decoration_block", () -> BlockInit.CYAN_DECORATION_BLOCK.get());	
	public static final RegistryObject<BlockItem> BLUE_DECORATION_BLOCK = registerDecorativeBlockItem("blue_decoration_block", () -> BlockInit.BLUE_DECORATION_BLOCK.get());	
	public static final RegistryObject<BlockItem> LIGHT_BLUE_DECORATION_BLOCK = registerDecorativeBlockItem("light_blue_decoration_block", () -> BlockInit.LIGHT_BLUE_DECORATION_BLOCK.get());	
	public static final RegistryObject<BlockItem> PURPLE_DECORATION_BLOCK = registerDecorativeBlockItem("purple_decoration_block", () -> BlockInit.PURPLE_DECORATION_BLOCK.get());	
	public static final RegistryObject<BlockItem> MAGENTA_DECORATION_BLOCK = registerDecorativeBlockItem("magenta_decoration_block", () -> BlockInit.MAGENTA_DECORATION_BLOCK.get());	
	public static final RegistryObject<BlockItem> PINK_DECORATION_BLOCK = registerDecorativeBlockItem("pink_decoration_block", () -> BlockInit.PINK_DECORATION_BLOCK.get());	
	public static final RegistryObject<BlockItem> BROWN_DECORATION_BLOCK = registerDecorativeBlockItem("brown_decoration_block", () -> BlockInit.BROWN_DECORATION_BLOCK.get());	
	public static final RegistryObject<BlockItem> GREY_DECORATION_BLOCK = registerDecorativeBlockItem("grey_decoration_block", () -> BlockInit.GREY_DECORATION_BLOCK.get());	
	public static final RegistryObject<BlockItem> LIGHT_GREY_DECORATION_BLOCK = registerDecorativeBlockItem("light_grey_decoration_block", () -> BlockInit.LIGHT_GREY_DECORATION_BLOCK.get());	
	public static final RegistryObject<BlockItem> WHITE_DECORATION_BLOCK = registerDecorativeBlockItem("white_decoration_block", () -> BlockInit.WHITE_DECORATION_BLOCK.get());	
	public static final RegistryObject<BlockItem> BLACK_DECORATION_BLOCK = registerDecorativeBlockItem("black_decoration_block", () -> BlockInit.BLACK_DECORATION_BLOCK.get());
	
	//Thatch
	public static final RegistryObject<BlockItem> THATCH_BLOCK =  registerDecorativeBlockItem("thatch_block", () -> BlockInit.THATCH_BLOCK.get());
	
	//Doors
	public static final RegistryObject<BlockItem> OUTDOOR_TOILET_DOOR = registerDecorativeBlockItem("outdoor_toilet_door", () -> BlockInit.OUTDOOR_TOILET_DOOR.get());
	public static final RegistryObject<BlockItem> GLASS_SHOP_DOOR = registerDecorativeBlockItem("glass_shop_door", () -> BlockInit.GLASS_SHOP_DOOR.get());
	public static final RegistryObject<BlockItem> VISITOR_CENTRE_DOOR = registerDecorativeBlockItem("visitor_centre_door", () -> BlockInit.VISITOR_CENTRE_DOOR.get());
	public static final RegistryObject<BlockItem> INNOVATION_CENTRE_DOOR = registerDecorativeBlockItem("innovation_centre_door", () -> BlockInit.INNOVATION_CENTRE_DOOR.get());
	public static final RegistryObject<BlockItem> SECURITY_DOOR = registerDecorativeBlockItem("security_door", () -> BlockInit.SECURITY_DOOR.get());
	public static final RegistryObject<BlockItem> BACK_DOOR = registerDecorativeBlockItem("back_door", () -> BlockInit.BACK_DOOR.get());
	
	//Registry
	
	//Item Registers
	//Standard Properties
	public static Properties standardProperties()
	{
		return new Item.Properties();
	}
	
	//Advanced Item Register
	public static RegistryObject<Item> advancedItemRegister(String id, Item item)
	{
		return ModRegistry.ITEM_REGISTRY.register(id, () -> item);
	}
	
	//Simple Item Register
	public static RegistryObject<Item> simpleItemRegister(String id, Item.Properties properties)
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
		return advancedItemRegister(id + "_spawn_bucket", new ModFishBucketItem(entity, Fluids.WATER));
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
		return advancedItemRegister(id + "_bucket", new ModFishBucketItem(entity, Fluids.WATER));
	}
	
	//Bones
	/*private static RegistryObject<Item> registerArmBone(String id)
	{
		return simpleItemRegister(id + "_arm_bone", standardProperties());
	}
	
	private static RegistryObject<Item> registerLegBone(String id)
	{
		return simpleItemRegister(id + "_leg_bone", standardProperties());
	}
	
	private static RegistryObject<Item> registerFootBone(String id)
	{
		return simpleItemRegister(id + "_foot_bone", standardProperties());
	}
	
	private static RegistryObject<Item> registerRibBone(String id)
	{
		return simpleItemRegister(id + "_rib_bone", standardProperties());
	}
	
	private static RegistryObject<Item> registerVertebraeBone(String id)
	{
		return simpleItemRegister(id + "_vertebrae_bone", standardProperties());
	}
	
	private static RegistryObject<Item> registerSkull(String id)
	{
		return simpleItemRegister(id + "_skull", standardProperties());
	}
	
	private static RegistryObject<Item> registerSpecialBone(String id)
	{
		return simpleItemRegister(id + "_special_bone", standardProperties());
	}*/
	
	//Block Item Registers
	//Block Item Register
	private static RegistryObject<BlockItem> registerBlockItem(String id, NonNullSupplier<Block> block, ItemGroup group)
	{
		return ModRegistry.ITEM_REGISTRY.register(id, () -> new ModBlockItem(block, new Item.Properties().tab(group)));
	}
	
	private static RegistryObject<BlockItem> registerFossilBlockItem(String id, NonNullSupplier<Block> block)
	{
		return registerBlockItem(id, block, ModItemGroup.FOSSILS_TAB);
	}
	
	private static RegistryObject<BlockItem> registerDecorativeBlockItem(String id, NonNullSupplier<Block> block)
	{
		return registerBlockItem(id, block, ModItemGroup.DECORATIVES_TAB);
	}
	
	private static RegistryObject<BlockItem> registerNatureBlockItem(String id, NonNullSupplier<Block> block)
	{
		return registerBlockItem(id, block, ModItemGroup.NATURE_TAB);
	}
	
	private static RegistryObject<BlockItem> registerMachinesBlockItem(String id, NonNullSupplier<Block> block)
	{
		return registerBlockItem(id, block, ModItemGroup.MACHINES_TAB);
	}
	
	private static RegistryObject<ModBoatItem> registerBoatItem(String id, ModBoatType type)
	{
		return ModRegistry.ITEM_REGISTRY.register(id, () -> new ModBoatItem(type, standardProperties()));
	}
	
	private static RegistryObject<BlockItem> registerBuringSlabItem(String id, NonNullSupplier<Block> block)
	{
		return ModRegistry.ITEM_REGISTRY.register(id, () -> new ModSlabBurnableItem(block, standardProperties().tab(ModItemGroup.DECORATIVES_TAB)));
	}
	
	private static RegistryObject<BlockItem> registerBuringBlockItem(String id, NonNullSupplier<Block> block)
	{
		return ModRegistry.ITEM_REGISTRY.register(id, () -> new ModWoodBurnableItem(block, standardProperties().tab(ModItemGroup.DECORATIVES_TAB)));
	}
	
	public static void initItems() { }
}
