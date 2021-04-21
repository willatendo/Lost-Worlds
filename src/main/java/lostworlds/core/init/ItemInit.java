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
import net.minecraft.item.Item.Properties;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Rarity;
import net.minecraft.item.ShovelItem;
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
	public static final RegistryObject<Item> TETRACERATOPS_MEAT = registerMeat("tetraceratops", FoodInit.RAW_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> TETRACERATOPS_COOKED_MEAT = registerCookedMeat("tetraceratops", FoodInit.COOKED_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> TETRACERATOPS_SPAWN_EGG = registerSpawnEgg("tetraceratops", () -> EntityInit.TETRACERATOPS_ENTITY.get(), 0x873624, 0x543b11);
	public static final RegistryObject<Item> TETRACERATOPS_ARM_BONE = registerArmBone("tetraceratops");
	public static final RegistryObject<Item> TETRACERATOPS_LEG_BONE = registerLegBone("tetraceratops");
	public static final RegistryObject<Item> TETRACERATOPS_FOOT_BONE = registerFootBone("tetraceratops");
	public static final RegistryObject<Item> TETRACERATOPS_RIB_BONE = registerRibBone("tetraceratops");
	public static final RegistryObject<Item> TETRACERATOPS_VERTEBRAE_BONE = registerVertebraeBone("tetraceratops");
	public static final RegistryObject<Item> TETRACERATOPS_SKULL_BONE = registerSkull("tetraceratops");
	
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
	public static final RegistryObject<Item> OURANOSAURUS_MEAT = registerMeat("ouranosaurus", FoodInit.RAW_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> OURANOSAURUS_COOKED_MEAT = registerCookedMeat("ouranosaurus", FoodInit.COOKED_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> OURANOSAURUS_SPAWN_EGG = registerSpawnEgg("ouranosaurus", () -> EntityInit.OURANOSAURUS_ENTITY.get(), 0x2b3187, 0x1da6e5);

	//Fukuvenator
	public static final RegistryObject<Item> FUKUVENATOR_DNA = registerDNA("fukuivenator");
	public static final RegistryObject<Item> FUKUVENATOR_DNA_DISC = registerDisc("fukuivenator");
	public static final RegistryObject<Item> FUKUVENATOR_MEAT = registerMeat("fukuivenator", FoodInit.RAW_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> FUKUVENATOR_COOKED_MEAT = registerCookedMeat("fukuivenator", FoodInit.COOKED_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> FUKUVENATOR_SPAWN_EGG = registerSpawnEgg("fukuivenator", () -> EntityInit.FUKUIVENATOR_ENTITY.get(), 0xbb6ad8, 0x44284f);
	
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
	public static final RegistryObject<BlockItem> COPPER_ORE =registerBlockItem("copper_ore", () -> BlockInit.COPPER_ORE.get());
	
	//Fossil
	public static final RegistryObject<BlockItem> STONE_FOSSIL = registerBlockItem("stone_fossil", () -> BlockInit.STONE_FOSSIL.get());
	public static final RegistryObject<BlockItem> EXPOSED_STONE_FOSSIL = registerBlockItem("exposed_stone_fossil", () -> BlockInit.EXPOSED_STONE_FOSSIL.get());
	public static final RegistryObject<BlockItem> PLASTERED_STONE_FOSSIL = registerBlockItem("plastered_stone_fossil", () -> BlockInit.PLASTERED_STONE_FOSSIL.get());

	//Fossil Processing
	
	
	public static final RegistryObject<BlockItem> POWER_SUPPLY_BLOCK = registerBlockItem("power_supply_block", () -> BlockInit.POWER_SUPPLY_BLOCK.get());

	//Mud
	public static final RegistryObject<BlockItem> MUD = registerBlockItem("mud", () -> BlockInit.MUD.get());

	//Nesting Block
	public static final RegistryObject<BlockItem> NESTING_BLOCK = registerBlockItem("nesting_block", () -> BlockInit.NESTING_BLOCK.get());

	//Time Machine
	public static final RegistryObject<BlockItem> TIME_MACHINE = registerBlockItem("time_machine", () -> BlockInit.TIME_MACHINE.get());
	
	//Museum Stuff
	public static final RegistryObject<BlockItem> OAK_ARCHAEOLOGY_TABLE = registerBlockItem("oak_archaeology_table", () -> BlockInit.OAK_ARCHAEOLOGY_TABLE.get());
	public static final RegistryObject<BlockItem> STRIPPED_OAK_ARCHAEOLOGY_TABLE =registerBlockItem("stripped_oak_archaeology_table", () -> BlockInit.STRIPPED_OAK_ARCHAEOLOGY_TABLE.get());
	
	public static final RegistryObject<BlockItem> BIRCH_ARCHAEOLOGY_TABLE = registerBlockItem("birch_archaeology_table", () -> BlockInit.BIRCH_ARCHAEOLOGY_TABLE.get());
	public static final RegistryObject<BlockItem> STRIPPED_BIRCH_ARCHAEOLOGY_TABLE = registerBlockItem("stripped_birch_archaeology_table", () -> BlockInit.STRIPPED_BIRCH_ARCHAEOLOGY_TABLE.get());
	
	public static final RegistryObject<BlockItem> JUNGLE_ARCHAEOLOGY_TABLE = registerBlockItem("jungle_archaeology_table", () -> BlockInit.JUNGLE_ARCHAEOLOGY_TABLE.get());
	public static final RegistryObject<BlockItem> STRIPPED_JUNGLE_ARCHAEOLOGY_TABLE = registerBlockItem("stripped_jungle_archaeology_table", () -> BlockInit.STRIPPED_JUNGLE_ARCHAEOLOGY_TABLE.get());
	
	public static final RegistryObject<BlockItem> SPRUCE_ARCHAEOLOGY_TABLE = registerBlockItem("spruce_archaeology_table", () -> BlockInit.SPRUCE_ARCHAEOLOGY_TABLE.get());
	public static final RegistryObject<BlockItem> STRIPPED_SPRUCE_ARCHAEOLOGY_TABLE = registerBlockItem("stripped_spruce_archaeology_table", () -> BlockInit.STRIPPED_SPRUCE_ARCHAEOLOGY_TABLE.get());
	
	public static final RegistryObject<BlockItem> ACACIA_ARCHAEOLOGY_TABLE = registerBlockItem("acacia_archaeology_table", () -> BlockInit.ACACIA_ARCHAEOLOGY_TABLE.get());
	public static final RegistryObject<BlockItem> STRIPPED_ACACIA_ARCHAEOLOGY_TABLE = registerBlockItem("stripped_acacia_archaeology_table", () -> BlockInit.STRIPPED_ACACIA_ARCHAEOLOGY_TABLE.get());
	
	public static final RegistryObject<BlockItem> DARK_OAK_ARCHAEOLOGY_TABLE = registerBlockItem("dark_oak_archaeology_table", () -> BlockInit.DARK_OAK_ARCHAEOLOGY_TABLE.get());
	public static final RegistryObject<BlockItem> STRIPPED_DARK_OAK_ARCHAEOLOGY_TABLE = registerBlockItem("stripped_dark_oak_archaeology_table", () -> BlockInit.STRIPPED_DARK_OAK_ARCHAEOLOGY_TABLE.get());
	
	public static final RegistryObject<BlockItem> CONIFER_ARCHAEOLOGY_TABLE = registerBlockItem("conifer_archaeology_table", () -> BlockInit.CONIFER_ARCHAEOLOGY_TABLE.get());
	public static final RegistryObject<BlockItem> STRIPPED_CONIFER_ARCHAEOLOGY_TABLE = registerBlockItem("stripped_conifer_archaeology_table", () -> BlockInit.STRIPPED_CONIFER_ARCHAEOLOGY_TABLE.get());
	
	public static final RegistryObject<BlockItem> GINKGO_ARCHAEOLOGY_TABLE = registerBlockItem("ginkgo_archaeology_table", () -> BlockInit.GINKGO_ARCHAEOLOGY_TABLE.get());
	public static final RegistryObject<BlockItem> STRIPPED_GINKGO_ARCHAEOLOGY_TABLE = registerBlockItem("stripped_ginkgo_archaeology_table", () -> BlockInit.STRIPPED_GINKGO_ARCHAEOLOGY_TABLE.get());
	
	//Volcanic Stuff
	public static final RegistryObject<BlockItem> VOLCANIC_ROCK = registerBlockItem("volcanic_rock", () -> BlockInit.VOLCANIC_ROCK.get());	
	public static final RegistryObject<BlockItem> VOLCANIC_ROCK_STAIRS = registerBlockItem("volcanic_rock_stairs", () -> BlockInit.VOLCANIC_ROCK_STAIRS.get());	
	public static final RegistryObject<BlockItem> VOLCANIC_ROCK_SLAB = registerBlockItem("volcanic_rock_slab", () -> BlockInit.VOLCANIC_ROCK_SLAB.get());	
	public static final RegistryObject<BlockItem> VOLCANIC_ROCK_WALL = registerBlockItem("volcanic_rock_wall", () -> BlockInit.VOLCANIC_ROCK_WALL.get());	
	
	public static final RegistryObject<BlockItem> POLISHED_VOLCANIC_ROCK = registerBlockItem("polished_volcanic_rock", () -> BlockInit.POLISHED_VOLCANIC_ROCK.get());	
	public static final RegistryObject<BlockItem> POLISHED_VOLCANIC_ROCK_STAIRS = registerBlockItem("polished_volcanic_rock_stairs", () -> BlockInit.POLISHED_VOLCANIC_ROCK_STAIRS.get());	
	public static final RegistryObject<BlockItem> POLISHED_VOLCANIC_ROCK_SLAB = registerBlockItem("polished_volcanic_rock_slab", () -> BlockInit.POLISHED_VOLCANIC_ROCK_SLAB.get());	

	public static final RegistryObject<BlockItem> VOLCANIC_ASH = registerBlockItem("volcanic_ash", () -> BlockInit.VOLCANIC_ASH.get());

	//Permian
	//Sand
	public static final RegistryObject<BlockItem> PERMIAN_SAND = registerBlockItem("permian_sand", () -> BlockInit.PERMIAN_SAND.get());

	//Stone
	public static final RegistryObject<BlockItem> PERMIAN_STONE = registerBlockItem("permian_stone", () -> BlockInit.PERMIAN_STONE.get());
	public static final RegistryObject<BlockItem> PERMIAN_STONE_STAIRS = registerBlockItem("permian_stone_stairs", () -> BlockInit.PERMIAN_STONE_STAIRS.get());
	public static final RegistryObject<BlockItem> PERMIAN_STONE_SLAB = registerBlockItem("permian_stone_slab", () -> BlockInit.PERMIAN_STONE_SLAB.get());
	public static final RegistryObject<BlockItem> PERMIAN_COBBLESTONE = registerBlockItem("permian_cobblestone", () -> BlockInit.PERMIAN_COBBLESTONE.get());
	public static final RegistryObject<BlockItem> PERMIAN_COBBLESTONE_STAIRS = registerBlockItem("permian_cobblestone_stairs", () -> BlockInit.PERMIAN_COBBLESTONE_STAIRS.get());
	public static final RegistryObject<BlockItem> PERMIAN_COBBLESTONE_SLAB = registerBlockItem("permian_cobblestone_slab", () -> BlockInit.PERMIAN_COBBLESTONE_SLAB.get());
	public static final RegistryObject<BlockItem> PERMIAN_COBBLESTONE_WALL = registerBlockItem("permian_cobblestone_wall", () -> BlockInit.PERMIAN_COBBLESTONE_WALL.get());

	//Flora
	public static final RegistryObject<BlockItem> SMALL_PERMIAN_DESERT_PLANT = registerBlockItem("small_permian_desert_plant", () -> BlockInit.SMALL_PERMIAN_DESERT_PLANT.get());
	public static final RegistryObject<BlockItem> MEDIUM_PERMIAN_DESERT_PLANT = registerBlockItem("medium_permian_desert_plant", () -> BlockInit.MEDIUM_PERMIAN_DESERT_PLANT.get());
	public static final RegistryObject<BlockItem> LARGE_PERMIAN_DESERT_PLANT = registerBlockItem("large_permian_desert_plant", () -> BlockInit.LARGE_PERMIAN_DESERT_PLANT.get());

	public static final RegistryObject<BlockItem> PERMIAN_GROUND_FERNS = registerBlockItem("permian_ground_ferns", () -> BlockInit.PERMIAN_GROUND_FERNS.get());

	//Conifer
	public static final RegistryObject<BlockItem> CONIFER_LOG = registerBuringBlockItem("conifer_log", () -> BlockInit.CONIFER_LOG.get());
	public static final RegistryObject<BlockItem> CONIFER_WOOD = registerBuringBlockItem("conifer_wood", () -> BlockInit.CONIFER_WOOD.get());
	public static final RegistryObject<BlockItem> STRIPPED_CONIFER_LOG = registerBuringBlockItem("stripped_conifer_log", () -> BlockInit.STRIPPED_CONIFER_LOG.get());
	public static final RegistryObject<BlockItem> STRIPPED_CONIFER_WOOD = registerBuringBlockItem("stripped_conifer_wood", () -> BlockInit.STRIPPED_CONIFER_WOOD.get());
	public static final RegistryObject<BlockItem> CONIFER_LEAVES = registerBlockItem("conifer_leaves", () -> BlockInit.CONIFER_LEAVES.get());
	public static final RegistryObject<BlockItem> CONIFER_SAPLING = registerBuringBlockItem("conifer_sapling", () -> BlockInit.CONIFER_SAPLING.get());
	public static final RegistryObject<BlockItem> CONIFER_PLANKS = registerBuringBlockItem("conifer_planks", () -> BlockInit.CONIFER_PLANKS.get());
	public static final RegistryObject<BlockItem> CONIFER_STAIRS = registerBuringBlockItem("conifer_stairs", () -> BlockInit.CONIFER_STAIRS.get());
	public static final RegistryObject<BlockItem> CONIFER_SLAB = registerBuringSlabItem("conifer_slab", () -> BlockInit.CONIFER_SLAB.get());
	public static final RegistryObject<BlockItem> CONIFER_FENCE = registerBuringBlockItem("conifer_fence", () -> BlockInit.CONIFER_FENCE.get());
	public static final RegistryObject<BlockItem> CONIFER_FENCE_GATE = registerBuringBlockItem("conifer_fence_gate", () -> BlockInit.CONIFER_FENCE_GATE.get());
	public static final RegistryObject<BlockItem> CONIFER_PRESSURE_PLATE = registerBuringBlockItem("conifer_pressure_plate", () -> BlockInit.CONIFER_PRESSURE_PLATE.get());
	public static final RegistryObject<BlockItem> CONIFER_BUTTON = registerBuringBlockItem("conifer_button", () -> BlockInit.CONIFER_BUTTON.get());
	public static final RegistryObject<BlockItem> CONIFER_TRAPDOOR = registerBuringBlockItem("conifer_trapdoor", () -> BlockInit.CONIFER_TRAPDOOR.get()); 
	public static final RegistryObject<BlockItem> CONIFER_DOOR = registerBlockItem("conifer_door", () -> BlockInit.CONIFER_DOOR.get());
	public static final RegistryObject<ModSignItem> CONIFER_SIGN = ModRegistry.ITEM_REGISTRY.register("conifer_sign", () -> new ModSignItem(BlockInit.CONIFER_SIGN.get(), BlockInit.CONIFER_WALL_SIGN.get(), standardProperties()));
	public static final RegistryObject<ModBoatItem> CONIFER_BOAT = registerBoatItem("conifer_boat", ModBoatType.CONIFER);

	//Ginkgo
	public static final RegistryObject<BlockItem> GINKGO_LOG = registerBuringBlockItem("ginkgo_log", () -> BlockInit.GINKGO_LOG.get());
	public static final RegistryObject<BlockItem> GINKGO_WOOD = registerBuringBlockItem("ginkgo_wood", () -> BlockInit.GINKGO_WOOD.get());
	public static final RegistryObject<BlockItem> STRIPPED_GINKGO_LOG = registerBuringBlockItem("stripped_ginkgo_log", () -> BlockInit.STRIPPED_GINKGO_LOG.get());
	public static final RegistryObject<BlockItem> STRIPPED_GINKGO_WOOD = registerBuringBlockItem("stripped_ginkgo_wood", () -> BlockInit.STRIPPED_GINKGO_WOOD.get());
	public static final RegistryObject<BlockItem> GINKGO_LEAVES = registerBlockItem("ginkgo_leaves", () -> BlockInit.GINKGO_LEAVES.get());
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
	
	//Light Concrete
	public static final RegistryObject<BlockItem> LIGHT_CONCRETE =  registerBlockItem("light_concrete", () -> BlockInit.LIGHT_CONCRETE.get());
	public static final RegistryObject<BlockItem> LIGHT_CONCRETE_STAIRS =  registerBlockItem("light_concrete_stairs", () -> BlockInit.LIGHT_CONCRETE_STAIRS.get());
	public static final RegistryObject<BlockItem> LIGHT_CONCRETE_SLAB =  registerBlockItem("light_concrete_slab", () -> BlockInit.LIGHT_CONCRETE_SLAB.get());
	public static final RegistryObject<BlockItem> LIGHT_CONCRETE_WALL =  registerBlockItem("light_concrete_wall", () -> BlockInit.LIGHT_CONCRETE_WALL.get());
	public static final RegistryObject<BlockItem> LIGHT_CONCRETE_PRESSURE_PLATE = registerBlockItem("light_concrete_pressure_plate", () -> BlockInit.LIGHT_CONCRETE_PRESSURE_PLATE.get());
	public static final RegistryObject<BlockItem> LIGHT_CONCRETE_BUTTON =  registerBlockItem("light_concrete_button", () -> BlockInit.LIGHT_CONCRETE_BUTTON.get());
	
	//Polished Light Concrete
	public static final RegistryObject<BlockItem> POLISHED_LIGHT_CONCRETE =  registerBlockItem("polished_light_concrete", () -> BlockInit.POLISHED_LIGHT_CONCRETE.get());
	public static final RegistryObject<BlockItem> POLISHED_LIGHT_CONCRETE_STAIRS =  registerBlockItem("polished_light_concrete_stairs", () -> BlockInit.POLISHED_LIGHT_CONCRETE_STAIRS.get());
	public static final RegistryObject<BlockItem> POLISHED_LIGHT_CONCRETE_SLAB =  registerBlockItem("polished_light_concrete_slab", () -> BlockInit.POLISHED_LIGHT_CONCRETE_SLAB.get());
	
	//Dark Concrete
	public static final RegistryObject<BlockItem> DARK_CONCRETE =  registerBlockItem("dark_concrete", () -> BlockInit.DARK_CONCRETE.get());
	public static final RegistryObject<BlockItem> DARK_CONCRETE_STAIRS =  registerBlockItem("dark_concrete_stairs", () -> BlockInit.DARK_CONCRETE_STAIRS.get());
	public static final RegistryObject<BlockItem> DARK_CONCRETE_SLAB =  registerBlockItem("dark_concrete_slab", () -> BlockInit.DARK_CONCRETE_SLAB.get());
	public static final RegistryObject<BlockItem> DARK_CONCRETE_WALL =  registerBlockItem("dark_concrete_wall", () -> BlockInit.DARK_CONCRETE_WALL.get());
	public static final RegistryObject<BlockItem> DARK_CONCRETE_PRESSURE_PLATE = registerBlockItem("dark_concrete_pressure_plate", () -> BlockInit.DARK_CONCRETE_PRESSURE_PLATE.get());
	public static final RegistryObject<BlockItem> DARK_CONCRETE_BUTTON =  registerBlockItem("dark_concrete_button", () -> BlockInit.DARK_CONCRETE_BUTTON.get());
	
	//Polished Dark Concrete
	public static final RegistryObject<BlockItem> POLISHED_DARK_CONCRETE =  registerBlockItem("polished_dark_concrete", () -> BlockInit.POLISHED_DARK_CONCRETE.get());
	public static final RegistryObject<BlockItem> POLISHED_DARK_CONCRETE_STAIRS =  registerBlockItem("polished_dark_concrete_stairs", () -> BlockInit.POLISHED_DARK_CONCRETE_STAIRS.get());
	public static final RegistryObject<BlockItem> POLISHED_DARK_CONCRETE_SLAB =  registerBlockItem("polished_dark_concrete_slab", () -> BlockInit.POLISHED_DARK_CONCRETE_SLAB.get());

	//Wooden Planks
	public static final RegistryObject<BlockItem> WOODEN_PLANKS =  registerBlockItem("wooden_planks", () -> BlockInit.WOODEN_PLANKS.get());
	public static final RegistryObject<BlockItem> WOODEN_PLANKS_STAIRS =  registerBlockItem("wooden_planks_stairs", () -> BlockInit.WOODEN_PLANKS_STAIRS.get());
	public static final RegistryObject<BlockItem> WOODEN_PLANKS_SLAB =  registerBlockItem("wooden_planks_slab", () -> BlockInit.WOODEN_PLANKS_SLAB.get());
	public static final RegistryObject<BlockItem> WOODEN_PLANKS_FENCE =  registerBlockItem("wooden_planks_fence", () -> BlockInit.WOODEN_PLANKS_FENCE.get());
	public static final RegistryObject<BlockItem> WOODEN_PLANKS_FENCE_GATE =  registerBlockItem("wooden_planks_fence_gate", () -> BlockInit.WOODEN_PLANKS_FENCE_GATE.get());
	public static final RegistryObject<BlockItem> WOODEN_PLANKS_PRESSURE_PLATE = registerBlockItem("wooden_planks_pressure_plate", () -> BlockInit.WOODEN_PLANKS_PRESSURE_PLATE.get());
	public static final RegistryObject<BlockItem> WOODEN_PLANKS_BUTTON =  registerBlockItem("wooden_planks_button", () -> BlockInit.WOODEN_PLANKS_BUTTON.get());
		
	//Wooden Planks
	public static final RegistryObject<BlockItem> REFINED_WOODEN_PLANKS =  registerBlockItem("refined_wooden_planks", () -> BlockInit.REFINED_WOODEN_PLANKS.get());
	public static final RegistryObject<BlockItem> REFINED_WOODEN_PLANKS_STAIRS =  registerBlockItem("refined_wooden_planks_stairs", () -> BlockInit.REFINED_WOODEN_PLANKS_STAIRS.get());
	public static final RegistryObject<BlockItem> REFINED_WOODEN_PLANKS_SLAB =  registerBlockItem("refined_wooden_planks_slab", () -> BlockInit.REFINED_WOODEN_PLANKS_SLAB.get());
	public static final RegistryObject<BlockItem> REFINED_WOODEN_PLANKS_FENCE =  registerBlockItem("refined_wooden_planks_fence", () -> BlockInit.REFINED_WOODEN_PLANKS_FENCE.get());
	public static final RegistryObject<BlockItem> REFINED_WOODEN_PLANKS_FENCE_GATE =  registerBlockItem("refined_wooden_planks_fence_gate", () -> BlockInit.REFINED_WOODEN_PLANKS_FENCE_GATE.get());
	public static final RegistryObject<BlockItem> REFINED_WOODEN_PLANKS_PRESSURE_PLATE = registerBlockItem("refined_wooden_planks_pressure_plate", () -> BlockInit.REFINED_WOODEN_PLANKS_PRESSURE_PLATE.get());
	public static final RegistryObject<BlockItem> REFINED_WOODEN_PLANKS_BUTTON =  registerBlockItem("refined_wooden_planks_button", () -> BlockInit.REFINED_WOODEN_PLANKS_BUTTON.get());
	
	//Pavement
	public static final RegistryObject<BlockItem> PAVEMENT =  registerBlockItem("pavement", () -> BlockInit.PAVEMENT.get());
	public static final RegistryObject<BlockItem> PAVEMENT_SLOPE =  registerBlockItem("pavement_slope", () -> BlockInit.PAVEMENT_SLOPE.get());
	public static final RegistryObject<BlockItem> RAISED_PAVEMENT =  registerBlockItem("raised_pavement", () -> BlockInit.RAISED_PAVEMENT.get());
	
	//Roads
	public static final RegistryObject<BlockItem> GRAVEL_ROAD = registerBlockItem("gravel_road", () -> BlockInit.GRAVEL_ROAD.get());
	public static final RegistryObject<BlockItem> RAISED_GRAVEL_ROAD = registerBlockItem("raised_gravel_road", () -> BlockInit.RAISED_GRAVEL_ROAD.get());
		
	public static final RegistryObject<BlockItem> DIRT_ROAD = registerBlockItem("dirt_road", () -> BlockInit.DIRT_ROAD.get());
	public static final RegistryObject<BlockItem> RAISED_DIRT_ROAD = registerBlockItem("raised_dirt_road", () -> BlockInit.RAISED_DIRT_ROAD.get());
			
	public static final RegistryObject<BlockItem> PAVED_ROAD = registerBlockItem("paved_road", () -> BlockInit.PAVED_ROAD.get());
	public static final RegistryObject<BlockItem> RAISED_PAVED_ROAD = registerBlockItem("raised_paved_road", () -> BlockInit.RAISED_PAVED_ROAD.get());
		
	//Tile
	public static final RegistryObject<BlockItem> TILE =  registerBlockItem("tile", () -> BlockInit.TILE.get());
	public static final RegistryObject<BlockItem> TILE_STAIRS =  registerBlockItem("tile_stairs", () -> BlockInit.TILE_STAIRS.get());
	public static final RegistryObject<BlockItem> TILE_SLAB =  registerBlockItem("tile_slab", () -> BlockInit.TILE_SLAB.get());

	//Metal Fence
	public static final RegistryObject<BlockItem> METAL_FENCE = registerBlockItem("metal_fence", () -> BlockInit.METAL_FENCE.get());

	//Clear Glass
	public static final RegistryObject<BlockItem> CLEAR_GLASS = registerBlockItem("clear_glass", () -> BlockInit.CLEAR_GLASS.get());
	public static final RegistryObject<BlockItem> CLEAR_GLASS_PANE = registerBlockItem("clear_glass_pane", () -> BlockInit.CLEAR_GLASS_PANE.get());

	//Tinted Glass
	public static final RegistryObject<BlockItem> TINTED_GLASS = registerBlockItem("tinted_glass", () -> BlockInit.TINTED_GLASS.get());
	public static final RegistryObject<BlockItem> TINTED_GLASS_PANE = registerBlockItem("tinted_glass_pane", () -> BlockInit.TINTED_GLASS_PANE.get());
	
	//Coloured Glass
	public static final RegistryObject<BlockItem> WHITE_GLASS = registerBlockItem("white_glass", () -> BlockInit.WHITE_GLASS.get());
	public static final RegistryObject<BlockItem> WHITE_GLASS_PANE = registerBlockItem("white_glass_pane", () -> BlockInit.WHITE_GLASS_PANE.get());	
		
	public static final RegistryObject<BlockItem> LIGHT_GREY_GLASS = registerBlockItem("light_grey_glass", () -> BlockInit.LIGHT_GREY_GLASS.get());
	public static final RegistryObject<BlockItem> LIGHT_GREY_GLASS_PANE = registerBlockItem("light_grey_glass_pane", () -> BlockInit.LIGHT_GREY_GLASS_PANE.get());	
		
	public static final RegistryObject<BlockItem> GREY_GLASS = registerBlockItem("grey_glass", () -> BlockInit.GREY_GLASS.get());
	public static final RegistryObject<BlockItem> GREY_GLASS_PANE = registerBlockItem("grey_glass_pane", () -> BlockInit.GREY_GLASS_PANE.get());	
		
	public static final RegistryObject<BlockItem> BLACK_GLASS = registerBlockItem("black_glass", () -> BlockInit.BLACK_GLASS.get());
	public static final RegistryObject<BlockItem> BLACK_GLASS_PANE = registerBlockItem("black_glass_pane", () -> BlockInit.BLACK_GLASS_PANE.get());	
		
	public static final RegistryObject<BlockItem> RED_GLASS = registerBlockItem("red_glass", () -> BlockInit.RED_GLASS.get());
	public static final RegistryObject<BlockItem> RED_GLASS_PANE = registerBlockItem("red_glass_pane", () -> BlockInit.RED_GLASS_PANE.get());	
		
	public static final RegistryObject<BlockItem> ORANGE_GLASS = registerBlockItem("orange_glass", () -> BlockInit.ORANGE_GLASS.get());
	public static final RegistryObject<BlockItem> ORANGE_GLASS_PANE = registerBlockItem("orange_glass_pane", () -> BlockInit.ORANGE_GLASS_PANE.get());	
	
	public static final RegistryObject<BlockItem> YELLOW_GLASS = registerBlockItem("yellow_glass", () -> BlockInit.YELLOW_GLASS.get());
	public static final RegistryObject<BlockItem> YELLOW_GLASS_PANE = registerBlockItem("yellow_glass_pane", () -> BlockInit.YELLOW_GLASS_PANE.get());	
	
	public static final RegistryObject<BlockItem> LIME_GLASS = registerBlockItem("lime_glass", () -> BlockInit.LIME_GLASS.get());
	public static final RegistryObject<BlockItem> LIME_GLASS_PANE = registerBlockItem("lime_glass_pane", () -> BlockInit.LIME_GLASS_PANE.get());	
		
	public static final RegistryObject<BlockItem> GREEN_GLASS = registerBlockItem("green_glass", () -> BlockInit.GREEN_GLASS.get());
	public static final RegistryObject<BlockItem> GREEN_GLASS_PANE = registerBlockItem("green_glass_pane", () -> BlockInit.GREEN_GLASS_PANE.get());	
		
	public static final RegistryObject<BlockItem> CYAN_GLASS = registerBlockItem("cyan_glass", () -> BlockInit.CYAN_GLASS.get());
	public static final RegistryObject<BlockItem> CYAN_GLASS_PANE = registerBlockItem("cyan_glass_pane", () -> BlockInit.CYAN_GLASS_PANE.get());	
		
	public static final RegistryObject<BlockItem> LIGHT_BLUE_GLASS = registerBlockItem("light_blue_glass", () -> BlockInit.LIGHT_BLUE_GLASS.get());
	public static final RegistryObject<BlockItem> LIGHT_BLUE_GLASS_PANE = registerBlockItem("light_blue_glass_pane", () -> BlockInit.LIGHT_BLUE_GLASS_PANE.get());	
		
	public static final RegistryObject<BlockItem> BLUE_GLASS = registerBlockItem("blue_glass", () -> BlockInit.BLUE_GLASS.get());
	public static final RegistryObject<BlockItem> BLUE_GLASS_PANE = registerBlockItem("blue_glass_pane", () -> BlockInit.BLUE_GLASS_PANE.get());	
		
	public static final RegistryObject<BlockItem> PURPLE_GLASS = registerBlockItem("purple_glass", () -> BlockInit.PURPLE_GLASS.get());
	public static final RegistryObject<BlockItem> PURPLE_GLASS_PANE = registerBlockItem("purple_glass_pane", () -> BlockInit.PURPLE_GLASS_PANE.get());	
		
	public static final RegistryObject<BlockItem> MAGENTA_GLASS = registerBlockItem("magenta_glass", () -> BlockInit.MAGENTA_GLASS.get());
	public static final RegistryObject<BlockItem> MAGENTA_GLASS_PANE = registerBlockItem("magenta_glass_pane", () -> BlockInit.MAGENTA_GLASS_PANE.get());	
		
	public static final RegistryObject<BlockItem> PINK_GLASS = registerBlockItem("pink_glass", () -> BlockInit.PINK_GLASS.get());
	public static final RegistryObject<BlockItem> PINK_GLASS_PANE = registerBlockItem("pink_glass_pane", () -> BlockInit.PINK_GLASS_PANE.get());	
		
	public static final RegistryObject<BlockItem> BROWN_GLASS = registerBlockItem("brown_glass", () -> BlockInit.BROWN_GLASS.get());
	public static final RegistryObject<BlockItem> BROWN_GLASS_PANE = registerBlockItem("brown_glass_pane", () -> BlockInit.BROWN_GLASS_PANE.get());	

	public static final RegistryObject<BlockItem> SHADED_GLASS = registerBlockItem("shaded_glass", () -> BlockInit.SHADED_GLASS.get());
	public static final RegistryObject<BlockItem> SHADED_GLASS_PANE = registerBlockItem("shaded_glass_pane", () -> BlockInit.SHADED_GLASS_PANE.get());	
	
	//Coloured Blocks
	public static final RegistryObject<BlockItem> RED_DECORATION_BLOCK = registerBlockItem("red_decoration_block", () -> BlockInit.RED_DECORATION_BLOCK.get());
	public static final RegistryObject<BlockItem> ORANGE_DECORATION_BLOCK = registerBlockItem("orange_decoration_block", () -> BlockInit.ORANGE_DECORATION_BLOCK.get());	
	public static final RegistryObject<BlockItem> YELLOW_DECORATION_BLOCK = registerBlockItem("yellow_decoration_block", () -> BlockInit.YELLOW_DECORATION_BLOCK.get());
	public static final RegistryObject<BlockItem> LIME_DECORATION_BLOCK = registerBlockItem("lime_decoration_block", () -> BlockInit.LIME_DECORATION_BLOCK.get());
	public static final RegistryObject<BlockItem> GREEN_DECORATION_BLOCK = registerBlockItem("green_decoration_block", () -> BlockInit.GREEN_DECORATION_BLOCK.get());
	public static final RegistryObject<BlockItem> CYAN_DECORATION_BLOCK = registerBlockItem("cyan_decoration_block", () -> BlockInit.CYAN_DECORATION_BLOCK.get());	
	public static final RegistryObject<BlockItem> BLUE_DECORATION_BLOCK = registerBlockItem("blue_decoration_block", () -> BlockInit.BLUE_DECORATION_BLOCK.get());	
	public static final RegistryObject<BlockItem> LIGHT_BLUE_DECORATION_BLOCK = registerBlockItem("light_blue_decoration_block", () -> BlockInit.LIGHT_BLUE_DECORATION_BLOCK.get());	
	public static final RegistryObject<BlockItem> PURPLE_DECORATION_BLOCK = registerBlockItem("purple_decoration_block", () -> BlockInit.PURPLE_DECORATION_BLOCK.get());	
	public static final RegistryObject<BlockItem> MAGENTA_DECORATION_BLOCK = registerBlockItem("magenta_decoration_block", () -> BlockInit.MAGENTA_DECORATION_BLOCK.get());	
	public static final RegistryObject<BlockItem> PINK_DECORATION_BLOCK = registerBlockItem("pink_decoration_block", () -> BlockInit.PINK_DECORATION_BLOCK.get());	
	public static final RegistryObject<BlockItem> BROWN_DECORATION_BLOCK = registerBlockItem("brown_decoration_block", () -> BlockInit.BROWN_DECORATION_BLOCK.get());	
	public static final RegistryObject<BlockItem> GREY_DECORATION_BLOCK = registerBlockItem("grey_decoration_block", () -> BlockInit.GREY_DECORATION_BLOCK.get());	
	public static final RegistryObject<BlockItem> LIGHT_GREY_DECORATION_BLOCK = registerBlockItem("light_grey_decoration_block", () -> BlockInit.LIGHT_GREY_DECORATION_BLOCK.get());	
	public static final RegistryObject<BlockItem> WHITE_DECORATION_BLOCK = registerBlockItem("white_decoration_block", () -> BlockInit.WHITE_DECORATION_BLOCK.get());	
	public static final RegistryObject<BlockItem> BLACK_DECORATION_BLOCK = registerBlockItem("black_decoration_block", () -> BlockInit.BLACK_DECORATION_BLOCK.get());
	
	//Thatch
	public static final RegistryObject<BlockItem> THATCH_BLOCK =  registerBlockItem("thatch_block", () -> BlockInit.THATCH_BLOCK.get());
	
	//Doors
	public static final RegistryObject<BlockItem> OUTDOOR_TOILET_DOOR = registerBlockItem("outdoor_toilet_door", () -> BlockInit.OUTDOOR_TOILET_DOOR.get());
	public static final RegistryObject<BlockItem> GLASS_SHOP_DOOR = registerBlockItem("glass_shop_door", () -> BlockInit.GLASS_SHOP_DOOR.get());
	public static final RegistryObject<BlockItem> VISITOR_CENTRE_DOOR = registerBlockItem("visitor_centre_door", () -> BlockInit.VISITOR_CENTRE_DOOR.get());
	public static final RegistryObject<BlockItem> INNOVATION_CENTRE_DOOR = registerBlockItem("innovation_centre_door", () -> BlockInit.INNOVATION_CENTRE_DOOR.get());
	public static final RegistryObject<BlockItem> SECURITY_DOOR = registerBlockItem("security_door", () -> BlockInit.SECURITY_DOOR.get());
	public static final RegistryObject<BlockItem> BACK_DOOR = registerBlockItem("back_door", () -> BlockInit.BACK_DOOR.get());
	
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
	
	//Block Item Registers
	//Block Item Register
	private static RegistryObject<BlockItem> registerBlockItem(String id, NonNullSupplier<Block> block)
	{
		return ModRegistry.ITEM_REGISTRY.register(id, () -> new ModBlockItem(block, standardProperties()));
	}
	
	private static RegistryObject<ModBoatItem> registerBoatItem(String id, ModBoatType type)
	{
		return ModRegistry.ITEM_REGISTRY.register(id, () -> new ModBoatItem(type, standardProperties()));
	}
	
	private static RegistryObject<BlockItem> registerBuringSlabItem(String id, NonNullSupplier<Block> block)
	{
		return ModRegistry.ITEM_REGISTRY.register(id, () -> new ModSlabBurnableItem(block, standardProperties()));
	}
	
	private static RegistryObject<BlockItem> registerBuringBlockItem(String id, NonNullSupplier<Block> block)
	{
		return ModRegistry.ITEM_REGISTRY.register(id, () -> new ModWoodBurnableItem(block, standardProperties()));
	}
	
	public static void initItems() { }
}
