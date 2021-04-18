 package lostworlds.core.init; 

import lostworlds.common.entities.ModBoatEntity.ModBoatType;
import lostworlds.common.items.DiscItem;
import lostworlds.common.items.FieldGuideItem;
import lostworlds.common.items.ModBoatItem;
import lostworlds.common.items.ModFishBucketItem;
import lostworlds.common.items.ModSignItem;
import lostworlds.common.items.ModSlabBurnableItem;
import lostworlds.common.items.ModSpawnEggItem;
import lostworlds.common.items.ModWoodBurnableItem;
import lostworlds.common.items.WetPaperItem;
import lostworlds.common.tools.BrushItem;
import lostworlds.core.ModItemGroup;
import lostworlds.core.util.enums.ModItemTeir;
import lostworlds.core.util.registry.ModRegistry;
import net.minecraft.entity.EntityType;
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

	//Field Guide
	public static final RegistryObject<Item> FEILD_GUIDE = ModRegistry.ITEM_REGISTRY.register("field_guide", () -> new FieldGuideItem(new Item.Properties()));
	
	public static final RegistryObject<Item> EMPTY_VILE = simpleItemRegister("empty_vile", standardProperties());

	//Procompsognathus
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_DNA = registerDNA("procompsognathus");
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_DNA_DISC = registerDisc("procompsognathus");
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_EGG = ModRegistry.ITEM_REGISTRY.register("procompsognathus_egg", () -> new BlockItem(BlockInit.PROCOMPSOGNATHUS_EGG.get(), standardProperties()));
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_MEAT = registerMeat("procompsognathus", FoodInit.RAW_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_COOKED_MEAT = registerCookedMeat("procompsognathus", FoodInit.COOKED_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_SPAWN_EGG = registerSpawnEgg("procompsognathus", () -> EntityInit.PROCOMPSOGNATHUS_ENTITY.get(), 0x125611, 0x143025);
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_ARM_BONE = registerArmBone("procompsognathus");
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_LEG_BONE = registerLegBone("procompsognathus");
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_FOOT_BONE = registerFootBone("procompsognathus");
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_RIB_BONE = registerRibBone("procompsognathus");
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_VERTEBRAE_BONE = registerVertebraeBone("procompsognathus");
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_SKULL_BONE = registerSkull("procompsognathus");
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_CLAW_BONE = registerSpecialBone("procompsognathus");
	
	//Palaeoniscum
	public static final RegistryObject<Item> PALAEONISCUM_DNA = registerDNA("palaeoniscum");
	public static final RegistryObject<Item> PALAEONISCUM_DNA_DISC = registerDisc("palaeoniscum");
	public static final RegistryObject<Item> PALAEONISCUM_SPAWN = registerSpawn("palaeoniscum");
	public static final RegistryObject<Item> PALAEONISCUM_SPAWN_BUCKET = registerSpawnBucket("palaeoniscum", () -> EntityInit.PALAEONISCUM_ENTITY.get());
	public static final RegistryObject<Item> PALAEONISCUM_MEAT = registerFishMeat("palaeoniscum", FoodInit.RAW_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> PALAEONISCUM_COOKED_MEAT = registerCookedFishMeat("palaeoniscum", FoodInit.COOKED_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> PALAEONISCUM_SPAWN_EGG = registerSpawnEgg("palaeoniscum", () -> EntityInit.PALAEONISCUM_ENTITY.get(), 0x1e2f4f, 0x2b1838);
	public static final RegistryObject<Item> PALAEONISCUM_BUCKET = registerEntityBucket("palaeoniscum", () -> EntityInit.PALAEONISCUM_ENTITY.get());
	public static final RegistryObject<Item> PALAEONISCUM_RIB_BONE = registerRibBone("palaeoniscum");
	public static final RegistryObject<Item> PALAEONISCUM_VERTEBRAE_BONE = registerVertebraeBone("palaeoniscum");
	public static final RegistryObject<Item> PALAEONISCUM_SKULL_BONE = registerSkull("palaeoniscum");
	public static final RegistryObject<Item> PALAEONISCUM_FIN_BONE = registerSpecialBone("palaeoniscum");
	
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
	public static final RegistryObject<Item> RHINESUCHUS_ARM_BONE = registerArmBone("rhinesuchus");
	public static final RegistryObject<Item> RHINESUCHUS_LEG_BONE = registerLegBone("rhinesuchus");
	public static final RegistryObject<Item> RHINESUCHUS_FOOT_BONE = registerFootBone("rhinesuchus");
	public static final RegistryObject<Item> RHINESUCHUS_RIB_BONE = registerRibBone("rhinesuchus");
	public static final RegistryObject<Item> RHINESUCHUS_VERTEBRAE_BONE = registerVertebraeBone("rhinesuchus");
	public static final RegistryObject<Item> RHINESUCHUS_SKULL_BONE = registerSkull("rhinesuchus");
	
	//Dimetrodon
	public static final RegistryObject<Item> DIMETRODON_DNA = registerDNA("dimetrodon");
	public static final RegistryObject<Item> DIMETRODON_DNA_DISC = registerDisc("dimetrodon");
	public static final RegistryObject<Item> DIMETRODON_EGG = ModRegistry.ITEM_REGISTRY.register("dimetrodon_egg", () -> new BlockItem(BlockInit.DIMETRODON_EGG.get(), standardProperties()));
	public static final RegistryObject<Item> DIMETRODON_MEAT = registerMeat("dimetrodon", FoodInit.RAW_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> DIMETRODON_COOKED_MEAT = registerCookedMeat("dimetrodon", FoodInit.COOKED_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> DIMETRODON_SPAWN_EGG = registerSpawnEgg("dimetrodon", () -> EntityInit.DIMETRODON_ENTITY.get(), 0x378ca8, 0x152875);
	public static final RegistryObject<Item> DIMETRODON_ARM_BONE = registerArmBone("dimetrodon");
	public static final RegistryObject<Item> DIMETRODON_LEG_BONE = registerLegBone("dimetrodon");
	public static final RegistryObject<Item> DIMETRODON_FOOT_BONE = registerFootBone("dimetrodon");
	public static final RegistryObject<Item> DIMETRODON_RIB_BONE = registerRibBone("dimetrodon");
	public static final RegistryObject<Item> DIMETRODON_SKULL_BONE = registerSkull("dimetrodon");
	public static final RegistryObject<Item> DIMETRODON_SAIL_BONE = registerSpecialBone("dimetrodon");
	
	//Edaphosaurus
	public static final RegistryObject<Item> EDAPHOSAURUS_DNA = registerDNA("edaphosaurus");
	public static final RegistryObject<Item> EDAPHOSAURUS_DNA_DISC = registerDisc("edaphosaurus");
	public static final RegistryObject<Item> EDAPHOSAURUS_MEAT = registerMeat("edaphosaurus", FoodInit.RAW_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> EDAPHOSAURUS_COOKED_MEAT = registerCookedMeat("edaphosaurus", FoodInit.COOKED_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> EDAPHOSAURUS_EGG = ModRegistry.ITEM_REGISTRY.register("edaphosaurus_egg", () -> new BlockItem(BlockInit.EDAPHOSAURUS_EGG.get(), standardProperties()));
	public static final RegistryObject<Item> EDAPHOSAURUS_SPAWN_EGG = registerSpawnEgg("edaphosaurus", () -> EntityInit.EDAPHOSAURUS_ENTITY.get(), 0x96af42, 0x2a3016);
	public static final RegistryObject<Item> EDAPHOSAURUS_ARM_BONE = registerArmBone("edaphosaurus");
	public static final RegistryObject<Item> EDAPHOSAURUS_LEG_BONE = registerLegBone("edaphosaurus");
	public static final RegistryObject<Item> EDAPHOSAURUS_FOOT_BONE = registerFootBone("edaphosaurus");
	public static final RegistryObject<Item> EDAPHOSAURUS_RIB_BONE = registerRibBone("edaphosaurus");
	public static final RegistryObject<Item> EDAPHOSAURUS_SKULL_BONE = registerSkull("edaphosaurus");
	public static final RegistryObject<Item> EDAPHOSAURUS_SAIL_BONE = registerSpecialBone("edaphosaurus");

	//Gorgonops
	public static final RegistryObject<Item> GORGONOPS_DNA = registerDNA("gorgonops");
	public static final RegistryObject<Item> GORGONOPS_DNA_DISC = registerDisc("gorgonops");
	public static final RegistryObject<Item> GORGONOPS_EGG = ModRegistry.ITEM_REGISTRY.register("gorgonops_egg", () -> new BlockItem(BlockInit.GORGONOPS_EGG.get(), standardProperties()));
	public static final RegistryObject<Item> GORGONOPS_MEAT = registerMeat("gorgonops", FoodInit.RAW_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> GORGONOPS_COOKED_MEAT = registerCookedMeat("gorgonops", FoodInit.COOKED_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> GORGONOPS_SPAWN_EGG = registerSpawnEgg("gorgonops", () -> EntityInit.GORGONOPS_ENTITY.get(), 0x967d46, 0x4f2f1a);
	public static final RegistryObject<Item> GORGONOPS_ARM_BONE = registerArmBone("gorgonops");
	public static final RegistryObject<Item> GORGONOPS_LEG_BONE = registerLegBone("gorgonops");
	public static final RegistryObject<Item> GORGONOPS_FOOT_BONE = registerFootBone("gorgonops");
	public static final RegistryObject<Item> GORGONOPS_RIB_BONE = registerRibBone("gorgonops");
	public static final RegistryObject<Item> GORGONOPS_VERTEBRAE_BONE = registerVertebraeBone("gorgonops");
	public static final RegistryObject<Item> GORGONOPS_SKULL_BONE = registerSkull("gorgonops");
	public static final RegistryObject<Item> GORGONOPS_CLAW_BONE = registerSpecialBone("gorgonops");

	//Carnotaurus
	public static final RegistryObject<Item> CARNOTAURUS_DNA = registerDNA("carnotaurus");
	public static final RegistryObject<Item> CARNOTAURUS_DNA_DISC = registerDisc("carnotaurus");
	public static final RegistryObject<Item> CARNOTAURUS_EGG = ModRegistry.ITEM_REGISTRY.register("carnotaurus_egg", () -> new BlockItem(BlockInit.CARNOTAURUS_EGG.get(), standardProperties()));
	public static final RegistryObject<Item> CARNOTAURUS_MEAT = registerMeat("carnotaurus", FoodInit.RAW_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> CARNOTAURUS_COOKED_MEAT = registerCookedMeat("carnotaurus", FoodInit.COOKED_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> CARNOTAURUS_SPAWN_EGG = registerSpawnEgg("carnotaurus", () -> EntityInit.CARNOTAURUS_ENTITY.get(), 0x682324, 0x171c06);
	public static final RegistryObject<Item> CARNOTAURUS_ARM_BONE = registerArmBone("carnotaurus");
	public static final RegistryObject<Item> CARNOTAURUS_LEG_BONE = registerLegBone("carnotaurus");
	public static final RegistryObject<Item> CARNOTAURUS_FOOT_BONE = registerFootBone("carnotaurus");
	public static final RegistryObject<Item> CARNOTAURUS_RIB_BONE = registerRibBone("carnotaurus");
	public static final RegistryObject<Item> CARNOTAURUS_VERTEBRAE_BONE = registerVertebraeBone("carnotaurus");
	public static final RegistryObject<Item> CARNOTAURUS_SKULL_BONE = registerSkull("carnotaurus");
	public static final RegistryObject<Item> CARNOTAURUS_CLAW_BONE = registerSpecialBone("carnotaurus");
	
	//Tyrannosaurus
	public static final RegistryObject<Item> TYRANNOSAURUS_DNA = registerDNA("tyrannosaurus");
	public static final RegistryObject<Item> TYRANNOSAURUS_DNA_DISC = registerDisc("tyrannosaurus");
	public static final RegistryObject<Item> TYRANNOSAURUS_EGG = ModRegistry.ITEM_REGISTRY.register("tyrannosaurus_egg", () -> new BlockItem(BlockInit.TYRANNOSAURUS_EGG.get(), standardProperties()));
	public static final RegistryObject<Item> TYRANNOSAURUS_MEAT = registerMeat("tyrannosaurus", FoodInit.RAW_LARGE_DINOSAUR_MEAT);
	public static final RegistryObject<Item> TYRANNOSAURUS_COOKED_MEAT = registerCookedMeat("tyrannosaurus", FoodInit.COOKED_LARGE_DINOSAUR_MEAT);
	public static final RegistryObject<Item> TYRANNOSAURUS_SPAWN_EGG = registerSpawnEgg("tyrannosaurus", () -> EntityInit.TYRANNOSAURUS_ENTITY.get(), 0x92b541, 0x125134);
	public static final RegistryObject<Item> TYRANNOSAURUS_ARM_BONE = registerArmBone("tyrannosaurus");
	public static final RegistryObject<Item> TYRANNOSAURUS_LEG_BONE = registerLegBone("tyrannosaurus");
	public static final RegistryObject<Item> TYRANNOSAURUS_FOOT_BONE = registerFootBone("tyrannosaurus");
	public static final RegistryObject<Item> TYRANNOSAURUS_RIB_BONE = registerRibBone("tyrannosaurus");
	public static final RegistryObject<Item> TYRANNOSAURUS_VERTEBRAE_BONE = registerVertebraeBone("tyrannosaurus");
	public static final RegistryObject<Item> TYRANNOSAURUS_SKULL_BONE = registerSkull("tyrannosaurus");
	public static final RegistryObject<Item> TYRANNOSAURUS_CLAW_BONE = registerSpecialBone("tyrannosaurus");

	//Allosaurus
	public static final RegistryObject<Item> ALLOSAURUS_DNA = registerDNA("allosaurus");
	public static final RegistryObject<Item> ALLOSAURUS_DNA_DISC = registerDisc("allosaurus");
	public static final RegistryObject<Item> ALLOSAURUS_MEAT = registerMeat("allosaurus", FoodInit.RAW_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> ALLOSAURUS_COOKED_MEAT = registerCookedMeat("allosaurus", FoodInit.COOKED_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> ALLOSAURUS_SPAWN_EGG = registerSpawnEgg("allosaurus", () -> EntityInit.ALLOSAURUS_ENTITY.get(), 0x687c35, 0x26300c);
	public static final RegistryObject<Item> ALLOSAURUS_ARM_BONE = registerArmBone("allosaurus");
	public static final RegistryObject<Item> ALLOSAURUS_LEG_BONE = registerLegBone("allosaurus");
	public static final RegistryObject<Item> ALLOSAURUS_FOOT_BONE = registerFootBone("allosaurus");
	public static final RegistryObject<Item> ALLOSAURUS_RIB_BONE = registerRibBone("allosaurus");
	public static final RegistryObject<Item> ALLOSAURUS_VERTEBRAE_BONE = registerVertebraeBone("allosaurus");
	public static final RegistryObject<Item> ALLOSAURUS_SKULL_BONE = registerSkull("allosaurus");
	public static final RegistryObject<Item> ALLOSAURUS_CLAW_BONE = registerSpecialBone("allosaurus");
	
	//Giganotosaurus
	public static final RegistryObject<Item> GIGANOTOSAURUS_DNA = registerDNA("giganotosaurus");
	public static final RegistryObject<Item> GIGANOTOSAURUS_DNA_DISC = registerDisc("giganotosaurus");
	public static final RegistryObject<Item> GIGANOTOSAURUS_MEAT = registerMeat("giganotosaurus", FoodInit.RAW_LARGE_DINOSAUR_MEAT);
	public static final RegistryObject<Item> GIGANOTOSAURUS_COOKED_MEAT = registerCookedMeat("giganotosaurus", FoodInit.COOKED_LARGE_DINOSAUR_MEAT);
	public static final RegistryObject<Item> GIGANOTOSAURUS_SPAWN_EGG = registerSpawnEgg("giganotosaurus", () -> EntityInit.GIGANOTOSAURUS_ENTITY.get(), 0xd8a734, 0x4f391c);
	public static final RegistryObject<Item> GIGANOTOSAURUS_ARM_BONE = registerArmBone("giganotosaurus");
	public static final RegistryObject<Item> GIGANOTOSAURUS_LEG_BONE = registerLegBone("giganotosaurus");
	public static final RegistryObject<Item> GIGANOTOSAURUS_FOOT_BONE = registerFootBone("giganotosaurus");
	public static final RegistryObject<Item> GIGANOTOSAURUS_RIB_BONE = registerRibBone("giganotosaurus");
	public static final RegistryObject<Item> GIGANOTOSAURUS_VERTEBRAE_BONE = registerVertebraeBone("giganotosaurus");
	public static final RegistryObject<Item> GIGANOTOSAURUS_SKULL_BONE = registerSkull("giganotosaurus");
	public static final RegistryObject<Item> GIGANOTOSAURUS_CLAW_BONE = registerSpecialBone("giganotosaurus");
	
	//Suchomimus
	public static final RegistryObject<Item> SUCHOMIMUS_DNA = registerDNA("suchomimus");
	public static final RegistryObject<Item> SUCHOMIMUS_DNA_DISC = registerDisc("suchomimus");
	public static final RegistryObject<Item> SUCHOMIMUS_MEAT = registerMeat("suchomimus", FoodInit.RAW_LARGE_DINOSAUR_MEAT);
	public static final RegistryObject<Item> SUCHOMIMUS_COOKED_MEAT = registerCookedMeat("suchomimus", FoodInit.COOKED_LARGE_DINOSAUR_MEAT);
	public static final RegistryObject<Item> SUCHOMIMUS_SPAWN_EGG = registerSpawnEgg("suchomimus", () -> EntityInit.SUCHOMIMUS_ENTITY.get(), 0x6a94c1, 0x110f54);
	public static final RegistryObject<Item> SUCHOMIMUS_ARM_BONE = registerArmBone("suchomimus");
	public static final RegistryObject<Item> SUCHOMIMUS_LEG_BONE = registerLegBone("suchomimus");
	public static final RegistryObject<Item> SUCHOMIMUS_FOOT_BONE = registerFootBone("suchomimus");
	public static final RegistryObject<Item> SUCHOMIMUS_RIB_BONE = registerRibBone("suchomimus");
	public static final RegistryObject<Item> SUCHOMIMUS_VERTEBRAE_BONE = registerVertebraeBone("suchomimus");
	public static final RegistryObject<Item> SUCHOMIMUS_SKULL_BONE = registerSkull("suchomimus");
	public static final RegistryObject<Item> SUCHOMIMUS_CLAW_BONE = registerSpecialBone("suchomimus");
	
	//Tetraceratops
	public static final RegistryObject<Item> TETRACERATOPS_DNA = registerDNA("tetraceratops");
	public static final RegistryObject<Item> TETRACERATOPS_DNA_DISC = registerDisc("tetraceratops");
	public static final RegistryObject<Item> TETRACERATOPS_MEAT = registerMeat("tetraceratops", FoodInit.RAW_LARGE_DINOSAUR_MEAT);
	public static final RegistryObject<Item> TETRACERATOPS_COOKED_MEAT = registerCookedMeat("tetraceratops", FoodInit.COOKED_LARGE_DINOSAUR_MEAT);
	public static final RegistryObject<Item> TETRACERATOPS_SPAWN_EGG = registerSpawnEgg("tetraceratops", () -> EntityInit.TETRACERATOPS_ENTITY.get(), 0x873624, 0x543b11);
	public static final RegistryObject<Item> TETRACERATOPS_ARM_BONE = registerArmBone("tetraceratops");
	public static final RegistryObject<Item> TETRACERATOPS_LEG_BONE = registerLegBone("tetraceratops");
	public static final RegistryObject<Item> TETRACERATOPS_FOOT_BONE = registerFootBone("tetraceratops");
	public static final RegistryObject<Item> TETRACERATOPS_RIB_BONE = registerRibBone("tetraceratops");
	public static final RegistryObject<Item> TETRACERATOPS_VERTEBRAE_BONE = registerVertebraeBone("tetraceratops");
	public static final RegistryObject<Item> TETRACERATOPS_SKULL_BONE = registerSkull("tetraceratops");
	
	//Mud Ball
	public static final RegistryObject<Item> MUD_BALL = simpleItemRegister("mud_ball", standardProperties());
	
	//Copper
	public static final RegistryObject<Item> COPPER_INGOT = simpleItemRegister("copper_ingot", standardProperties());
	public static final RegistryObject<Item> COPPER_NUGGET = simpleItemRegister("copper_nugget", standardProperties());
	
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
	
	//Fossil
	public static final RegistryObject<BlockItem> STONE_FOSSIL = ModRegistry.ITEM_REGISTRY.register("stone_fossil", () -> new BlockItem(BlockInit.STONE_FOSSIL.get(), standardProperties()));
	public static final RegistryObject<BlockItem> EXPOSED_STONE_FOSSIL = ModRegistry.ITEM_REGISTRY.register("exposed_stone_fossil", () -> new BlockItem(BlockInit.EXPOSED_STONE_FOSSIL.get(), standardProperties()));
	public static final RegistryObject<BlockItem> PLASTERED_STONE_FOSSIL = ModRegistry.ITEM_REGISTRY.register("plastered_stone_fossil", () -> new BlockItem(BlockInit.PLASTERED_STONE_FOSSIL.get(), standardProperties()));

	//Fossil Processing
	
	
	public static final RegistryObject<BlockItem> POWER_SUPPLY_BLOCK = ModRegistry.ITEM_REGISTRY.register("power_supply_block", () -> new BlockItem(BlockInit.POWER_SUPPLY_BLOCK.get(), standardProperties()));

	//Mud
	public static final RegistryObject<BlockItem> MUD = ModRegistry.ITEM_REGISTRY.register("mud", () -> new BlockItem(BlockInit.MUD.get(), standardProperties()));

	//Nesting Block
	public static final RegistryObject<BlockItem> NESTING_BLOCK = ModRegistry.ITEM_REGISTRY.register("nesting_block", () -> new BlockItem(BlockInit.NESTING_BLOCK.get(), standardProperties()));

	//Time Machine
	public static final RegistryObject<BlockItem> TIME_MACHINE = ModRegistry.ITEM_REGISTRY.register("time_machine", () -> new BlockItem(BlockInit.TIME_MACHINE.get(), standardProperties()));
	
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
	//Sand
	public static final RegistryObject<BlockItem> PERMIAN_SAND = ModRegistry.ITEM_REGISTRY.register("permian_sand", () -> new BlockItem(BlockInit.PERMIAN_SAND.get(), standardProperties()));

	//Stone
	public static final RegistryObject<BlockItem> PERMIAN_STONE = ModRegistry.ITEM_REGISTRY.register("permian_stone", () -> new BlockItem(BlockInit.PERMIAN_STONE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> PERMIAN_STONE_STAIRS = ModRegistry.ITEM_REGISTRY.register("permian_stone_stairs", () -> new BlockItem(BlockInit.PERMIAN_STONE_STAIRS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> PERMIAN_STONE_SLAB = ModRegistry.ITEM_REGISTRY.register("permian_stone_slab", () -> new BlockItem(BlockInit.PERMIAN_STONE_SLAB.get(), standardProperties()));
	public static final RegistryObject<BlockItem> PERMIAN_COBBLESTONE = ModRegistry.ITEM_REGISTRY.register("permian_cobblestone", () -> new BlockItem(BlockInit.PERMIAN_COBBLESTONE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> PERMIAN_COBBLESTONE_STAIRS = ModRegistry.ITEM_REGISTRY.register("permian_cobblestone_stairs", () -> new BlockItem(BlockInit.PERMIAN_COBBLESTONE_STAIRS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> PERMIAN_COBBLESTONE_SLAB = ModRegistry.ITEM_REGISTRY.register("permian_cobblestone_slab", () -> new BlockItem(BlockInit.PERMIAN_COBBLESTONE_SLAB.get(), standardProperties()));
	public static final RegistryObject<BlockItem> PERMIAN_COBBLESTONE_WALL = ModRegistry.ITEM_REGISTRY.register("permian_cobblestone_wall", () -> new BlockItem(BlockInit.PERMIAN_COBBLESTONE_WALL.get(), standardProperties()));

	//Flora
	public static final RegistryObject<BlockItem> SMALL_PERMIAN_DESERT_PLANT = ModRegistry.ITEM_REGISTRY.register("small_permian_desert_plant", () -> new BlockItem(BlockInit.SMALL_PERMIAN_DESERT_PLANT.get(), standardProperties()));
	public static final RegistryObject<BlockItem> MEDIUM_PERMIAN_DESERT_PLANT = ModRegistry.ITEM_REGISTRY.register("medium_permian_desert_plant", () -> new BlockItem(BlockInit.MEDIUM_PERMIAN_DESERT_PLANT.get(), standardProperties()));
	public static final RegistryObject<BlockItem> LARGE_PERMIAN_DESERT_PLANT = ModRegistry.ITEM_REGISTRY.register("large_permian_desert_plant", () -> new BlockItem(BlockInit.LARGE_PERMIAN_DESERT_PLANT.get(), standardProperties()));

	public static final RegistryObject<BlockItem> PERMIAN_GROUND_FERNS = ModRegistry.ITEM_REGISTRY.register("permian_ground_ferns", () -> new BlockItem(BlockInit.PERMIAN_GROUND_FERNS.get(), standardProperties()));

	//Conifer
	public static final RegistryObject<BlockItem> CONIFER_LOG = ModRegistry.ITEM_REGISTRY.register("conifer_log", () -> new ModWoodBurnableItem(BlockInit.CONIFER_LOG.get(), standardProperties()));
	public static final RegistryObject<BlockItem> CONIFER_WOOD = ModRegistry.ITEM_REGISTRY.register("conifer_wood", () -> new ModWoodBurnableItem(BlockInit.CONIFER_WOOD.get(), standardProperties()));
	public static final RegistryObject<BlockItem> STRIPPED_CONIFER_LOG = ModRegistry.ITEM_REGISTRY.register("stripped_conifer_log", () -> new ModWoodBurnableItem(BlockInit.STRIPPED_CONIFER_LOG.get(), standardProperties()));
	public static final RegistryObject<BlockItem> STRIPPED_CONIFER_WOOD = ModRegistry.ITEM_REGISTRY.register("stripped_conifer_wood", () -> new ModWoodBurnableItem(BlockInit.STRIPPED_CONIFER_WOOD.get(), standardProperties()));
	public static final RegistryObject<BlockItem> CONIFER_LEAVES = ModRegistry.ITEM_REGISTRY.register("conifer_leaves", () -> new BlockItem(BlockInit.CONIFER_LEAVES.get(), standardProperties()));
	public static final RegistryObject<BlockItem> CONIFER_SAPLING = ModRegistry.ITEM_REGISTRY.register("conifer_sapling", () -> new ModWoodBurnableItem(BlockInit.CONIFER_SAPLING.get(), standardProperties()));
	public static final RegistryObject<BlockItem> CONIFER_PLANKS = ModRegistry.ITEM_REGISTRY.register("conifer_planks", () -> new ModWoodBurnableItem(BlockInit.CONIFER_PLANKS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> CONIFER_STAIRS = ModRegistry.ITEM_REGISTRY.register("conifer_stairs", () -> new ModWoodBurnableItem(BlockInit.CONIFER_STAIRS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> CONIFER_SLAB = ModRegistry.ITEM_REGISTRY.register("conifer_slab", () -> new ModSlabBurnableItem(BlockInit.CONIFER_SLAB.get(), standardProperties()));
	public static final RegistryObject<BlockItem> CONIFER_FENCE = ModRegistry.ITEM_REGISTRY.register("conifer_fence", () -> new ModWoodBurnableItem(BlockInit.CONIFER_FENCE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> CONIFER_FENCE_GATE = ModRegistry.ITEM_REGISTRY.register("conifer_fence_gate", () -> new ModWoodBurnableItem(BlockInit.CONIFER_FENCE_GATE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> CONIFER_PRESSURE_PLATE = ModRegistry.ITEM_REGISTRY.register("conifer_pressure_plate", () -> new ModWoodBurnableItem(BlockInit.CONIFER_PRESSURE_PLATE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> CONIFER_BUTTON = ModRegistry.ITEM_REGISTRY.register("conifer_button", () -> new ModWoodBurnableItem(BlockInit.CONIFER_BUTTON.get(), standardProperties()));
	public static final RegistryObject<BlockItem> CONIFER_TRAPDOOR = ModRegistry.ITEM_REGISTRY.register("conifer_trapdoor", () -> new ModWoodBurnableItem(BlockInit.CONIFER_TRAPDOOR.get(), standardProperties())); 
	public static final RegistryObject<BlockItem> CONIFER_DOOR = ModRegistry.ITEM_REGISTRY.register("conifer_door", () -> new ModWoodBurnableItem(BlockInit.CONIFER_DOOR.get(), standardProperties()));
	public static final RegistryObject<ModSignItem> CONIFER_SIGN = ModRegistry.ITEM_REGISTRY.register("conifer_sign", () -> new ModSignItem(BlockInit.CONIFER_SIGN.get(), BlockInit.CONIFER_WALL_SIGN.get(), standardProperties()));
	public static final RegistryObject<ModBoatItem> CONIFER_BOAT = ModRegistry.ITEM_REGISTRY.register("conifer_boat", () -> new ModBoatItem(ModBoatType.CONIFER, standardProperties()));

	//Ginkgo
	public static final RegistryObject<BlockItem> GINKGO_LOG = ModRegistry.ITEM_REGISTRY.register("ginkgo_log", () -> new BlockItem(BlockInit.GINKGO_LOG.get(), standardProperties()));
	public static final RegistryObject<BlockItem> GINKGO_WOOD = ModRegistry.ITEM_REGISTRY.register("ginkgo_wood", () -> new BlockItem(BlockInit.GINKGO_WOOD.get(), standardProperties()));
	public static final RegistryObject<BlockItem> STRIPPED_GINKGO_LOG = ModRegistry.ITEM_REGISTRY.register("stripped_ginkgo_log", () -> new BlockItem(BlockInit.STRIPPED_GINKGO_LOG.get(), standardProperties()));
	public static final RegistryObject<BlockItem> STRIPPED_GINKGO_WOOD = ModRegistry.ITEM_REGISTRY.register("stripped_ginkgo_wood", () -> new BlockItem(BlockInit.STRIPPED_GINKGO_WOOD.get(), standardProperties()));
	public static final RegistryObject<BlockItem> GINKGO_LEAVES = ModRegistry.ITEM_REGISTRY.register("ginkgo_leaves", () -> new BlockItem(BlockInit.GINKGO_LEAVES.get(), standardProperties()));
	public static final RegistryObject<BlockItem> GINKGO_PLANKS = ModRegistry.ITEM_REGISTRY.register("ginkgo_planks", () -> new BlockItem(BlockInit.GINKGO_PLANKS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> GINKGO_STAIRS = ModRegistry.ITEM_REGISTRY.register("ginkgo_stairs", () -> new BlockItem(BlockInit.GINKGO_STAIRS.get(), standardProperties()));
	public static final RegistryObject<BlockItem> GINKGO_SLAB = ModRegistry.ITEM_REGISTRY.register("ginkgo_slab", () -> new BlockItem(BlockInit.GINKGO_SLAB.get(), standardProperties()));
	public static final RegistryObject<BlockItem> GINKGO_FENCE = ModRegistry.ITEM_REGISTRY.register("ginkgo_fence", () -> new BlockItem(BlockInit.GINKGO_FENCE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> GINKGO_FENCE_GATE = ModRegistry.ITEM_REGISTRY.register("ginkgo_fence_gate", () -> new BlockItem(BlockInit.GINKGO_FENCE_GATE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> GINKGO_PRESSURE_PLATE = ModRegistry.ITEM_REGISTRY.register("ginkgo_pressure_plate", () -> new BlockItem(BlockInit.GINKGO_PRESSURE_PLATE.get(), standardProperties()));
	public static final RegistryObject<BlockItem> GINKGO_BUTTON = ModRegistry.ITEM_REGISTRY.register("ginkgo_button", () -> new BlockItem(BlockInit.GINKGO_BUTTON.get(), standardProperties()));
	public static final RegistryObject<BlockItem> GINKGO_TRAPDOOR = ModRegistry.ITEM_REGISTRY.register("ginkgo_trapdoor", () -> new BlockItem(BlockInit.GINKGO_TRAPDOOR.get(), standardProperties())); 
	public static final RegistryObject<BlockItem> GINKGO_DOOR = ModRegistry.ITEM_REGISTRY.register("ginkgo_door", () -> new BlockItem(BlockInit.GINKGO_DOOR.get(), standardProperties()));
	public static final RegistryObject<SignItem> GINKGO_SIGN = ModRegistry.ITEM_REGISTRY.register("ginkgo_sign", () -> new SignItem(standardProperties(), BlockInit.GINKGO_SIGN.get(), BlockInit.GINKGO_WALL_SIGN.get()));
	public static final RegistryObject<ModBoatItem> GINKGO_BOAT = ModRegistry.ITEM_REGISTRY.register("ginkgo_boat", () -> new ModBoatItem(ModBoatType.GINKGO, standardProperties()));
	
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
	
	//Bones
	private static RegistryObject<Item> registerArmBone(String id)
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
	}
	
	public static void initItems() { }
}
