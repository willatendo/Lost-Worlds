package lostworlds.core.init; 

import lostworlds.common.entities.ModBoatEntity;
import lostworlds.common.entities.ModBoatEntity.ModBoatType;
import lostworlds.common.items.DiscItem;
import lostworlds.common.items.FieldGuideItem;
import lostworlds.common.items.FoodSeedsItem;
import lostworlds.common.items.GreatAukEggItem;
import lostworlds.common.items.ModBlockItem;
import lostworlds.common.items.ModBoatItem;
import lostworlds.common.items.ModFishBucketItem;
import lostworlds.common.items.ModSignItem;
import lostworlds.common.items.ModSlabBurnableItem;
import lostworlds.common.items.ModSpawnEggItem;
import lostworlds.common.items.ModWoodBurnableItem;
import lostworlds.common.items.SyringeItem;
import lostworlds.common.items.WetPaperItem;
import lostworlds.common.items.timebooks.JurassicTimeBook;
import lostworlds.common.items.timebooks.PermianTimeBook;
import lostworlds.common.tools.BrushItem;
import lostworlds.core.util.ModUtil;
import lostworlds.core.util.enums.ModItemTeir;
import lostworlds.core.util.registry.ModRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemGroup;
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
	public static final RegistryObject<Item> LEATHER_BRUSH = register("leather_brush", ModItemTeir.LEATHER_BRUSH);
	public static final RegistryObject<Item> IRON_BRUSH = register("iron_brush", ModItemTeir.IRON_BRUSH);
	public static final RegistryObject<Item> GOLD_BRUSH = register("gold_brush", ModItemTeir.GOLD_BRUSH);
	public static final RegistryObject<Item> DIAMOND_BRUSH = register("diamond_brush", ModItemTeir.DIAMOND_BRUSH);
	
	//Plaster
	public static final RegistryObject<Item> WET_PAPER = register("wet_paper", new WetPaperItem(properties().tab(ItemGroupInit.ITEMS_TAB)));

	//Field Guide
	public static final RegistryObject<Item> FEILD_GUIDE = register("field_guide", new FieldGuideItem(properties().stacksTo(1).tab(ItemGroupInit.ITEMS_TAB)));
	
	//Syringe
	public static final RegistryObject<Item> EMPTY_SYRINGE = register("empty_syringe", new SyringeItem(properties().stacksTo(1).tab(ItemGroupInit.ITEMS_TAB)));
	
	//Viles
	public static final RegistryObject<Item> EMPTY_VILE = register("empty_vile", properties().tab(ItemGroupInit.ITEMS_TAB));

	//Time Books
	public static final RegistryObject<Item> PERMIAN_TIME_BOOK = register("permian_time_book", new PermianTimeBook(properties().stacksTo(1).rarity(Rarity.RARE).tab(ItemGroupInit.ITEMS_TAB)));
	public static final RegistryObject<Item> JURASSIC_TIME_BOOK = register("jurassic_time_book", new JurassicTimeBook(properties().stacksTo(1).rarity(Rarity.RARE).tab(ItemGroupInit.ITEMS_TAB)));
	
	//Time Lord's Staff
	//public static final RegistryObject<Item> TIME_LORDS_STAFF = register("time_lords_staff", new Item.Properties().stacksTo(1).rarity(Rarity.EPIC));
	
	//Leaf Litter
	public static final RegistryObject<Item> FERN_LITTER = register("fern_litter", properties().food(FoodInit.FERN_LITTER).stacksTo(16).tab(ItemGroupInit.FOOD_TAB));
	public static final RegistryObject<Item> COOKED_FERN_LITTER = register("cooked_fern_litter", properties().food(FoodInit.BOILED_FERN_LITTER).stacksTo(16).tab(ItemGroupInit.FOOD_TAB));
	
	public static final RegistryObject<Item> CYCAD_SEEDS = register("cycad_seeds");
	public static final RegistryObject<Item> OSMUNDA_SEEDS = register("osmunda_seeds");
	public static final RegistryObject<Item> DUISBERGIA_SEEDS = register("duisbergia_seeds");
	public static final RegistryObject<Item> CEPHALOTAXUS_SEEDS = register("cephalotaxus_seeds");
	public static final RegistryObject<Item> LYCOPHYTA_SEEDS = register("lycophyta_seeds");
	public static final RegistryObject<Item> DILLHOFFIA_SEEDS = register("dillhoffia_seeds");
	
	public static final RegistryObject<Item> PALEO_SALAD = register("paleo_salad", FoodInit.PALEO_SALAD, ItemGroupInit.FOOD_TAB);

	//Procompsognathus
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_DNA = registerDNA("procompsognathus");
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_DNA_DISC = registerDNADisc("procompsognathus");
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_SOFT_TISSUE = registerSoftTissue("procompsognathus");
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_BLOOD_SYRINGE = ModRegistry.ITEM_REGISTRY.register("syringe_of_procompsognathus_blood", () -> new Item(properties().tab(ItemGroupInit.CREATURES_TAB).craftRemainder(EMPTY_SYRINGE.get())));
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_BLOOD_VILE = registerVile("procompsognathus");
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_MEAT = registerRawMeat("procompsognathus", FoodInit.RAW_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_COOKED_MEAT = registerCookedMeat("procompsognathus", FoodInit.COOKED_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_EGG = registerEgg("procompsognathus", () -> BlockInit.PROCOMPSOGNATHUS_EGG.get());
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_SPAWN_EGG = register("procompsognathus", () -> EntityInit.PROCOMPSOGNATHUS_ENTITY.get(), 0x125611, 0x143025);
	
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_SKULL = registerSkull("procompsognathus");
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_ARM_BONE = registerArmBone("procompsognathus");
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_LEG_BONE = registerLegBone("procompsognathus");
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_FOOT_BONE = registerFootBone("procompsognathus");
	public static final RegistryObject<Item> PROCOMPSOGNATHUS_RIB_BONE = registerRibBone("procompsognathus");

	//Palaeoniscum
	public static final RegistryObject<Item> PALAEONISCUM_DNA = registerDNA("palaeoniscum");
	public static final RegistryObject<Item> PALAEONISCUM_DNA_DISC = registerDNADisc("palaeoniscum");
	public static final RegistryObject<Item> PALAEONISCUM_SOFT_TISSUE = registerSoftTissue("palaeoniscum");
	public static final RegistryObject<Item> PALAEONISCUM_BLOOD_SYRINGE = ModRegistry.ITEM_REGISTRY.register("syringe_of_palaeoniscum_blood", () -> new Item(properties().tab(ItemGroupInit.CREATURES_TAB).craftRemainder(EMPTY_SYRINGE.get())));
	public static final RegistryObject<Item> PALAEONISCUM_BLOOD_VILE = registerVile("palaeoniscum");
	public static final RegistryObject<Item> PALAEONISCUM_SPAWN = registerSpawn("palaeoniscum");
	public static final RegistryObject<Item> PALAEONISCUM_MEAT = registerRawFishMeat("palaeoniscum", FoodInit.RAW_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> PALAEONISCUM_COOKED_MEAT = registerCookedFishMeat("palaeoniscum", FoodInit.COOKED_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> PALAEONISCUM_SPAWN_EGG = register("palaeoniscum", () -> EntityInit.PALAEONISCUM_ENTITY.get(), 0x1e2f4f, 0x2b1838);
	public static final RegistryObject<Item> PALAEONISCUM_BUCKET = registerFishBucket("palaeoniscum", () -> EntityInit.PALAEONISCUM_ENTITY.get());
	
	public static final RegistryObject<Item> PALAEONISCUM_SKULL = registerSkull("palaeoniscum");
	public static final RegistryObject<Item> PALAEONISCUM_FIN_BONE = registerOtherBone("palaeoniscum_fin_bone");
	public static final RegistryObject<Item> PALAEONISCUM_RIB_BONE = registerRibBone("palaeoniscum");
	
	//Nautilus
	public static final RegistryObject<Item> NAUTILUS_DNA = registerDNA("nautilus");
	public static final RegistryObject<Item> NAUTILUS_DNA_DISC = registerDNADisc("nautilus");
	public static final RegistryObject<Item> NAUTILUS_SOFT_TISSUE = registerSoftTissue("nautilus");
	public static final RegistryObject<Item> NAUTILUS_BLOOD_SYRINGE = ModRegistry.ITEM_REGISTRY.register("syringe_of_nautilus_blood", () -> new Item(properties().tab(ItemGroupInit.CREATURES_TAB).craftRemainder(EMPTY_SYRINGE.get())));
	public static final RegistryObject<Item> NAUTILUS_BLOOD_VILE = registerVile("nautilus");
	public static final RegistryObject<Item> NAUTILUS_SPAWN = registerSpawn("nautilus");
	public static final RegistryObject<Item> NAUTILUS_TENTICAL = register("nautilus_tentical", new Item(properties().food(FoodInit.RAW_MEDIUM_DINOSAUR_MEAT)));
	public static final RegistryObject<Item> COOKED_NAUTILUS_TENTICAL = register("cooked_nautilus_tentical", new Item(properties().food(FoodInit.COOKED_MEDIUM_DINOSAUR_MEAT)));
	public static final RegistryObject<Item> NAUTILUS_SPAWN_EGG = register("nautilus", () -> EntityInit.NAUTILUS_ENTITY.get(), 0xd8cecd, 0x4f4841);
	public static final RegistryObject<Item> NAUTILUS_BUCKET = registerFishBucket("nautilus", () -> EntityInit.NAUTILUS_ENTITY.get());
	
	//Rhinesuchus
	public static final RegistryObject<Item> RHINESUCHUS_DNA = registerDNA("rhinesuchus");
	public static final RegistryObject<Item> RHINESUCHUS_DNA_DISC = registerDNADisc("rhinesuchus");
	public static final RegistryObject<Item> RHINESUCHUS_SOFT_TISSUE = registerSoftTissue("rhinesuchus");
	public static final RegistryObject<Item> RHINESUCHUS_BLOOD_SYRINGE = ModRegistry.ITEM_REGISTRY.register("syringe_of_rhinesuchus_blood", () -> new Item(properties().tab(ItemGroupInit.CREATURES_TAB).craftRemainder(EMPTY_SYRINGE.get())));
	public static final RegistryObject<Item> RHINESUCHUS_BLOOD_VILE = registerVile("rhinesuchus");
	public static final RegistryObject<Item> RHINESUCHUS_SPAWN = registerSpawn("rhinesuchus");
	public static final RegistryObject<Item> RHINESUCHUS_MEAT = registerRawMeat("rhinesuchus", FoodInit.RAW_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> RHINESUCHUS_COOKED_MEAT = registerCookedMeat("rhinesuchus", FoodInit.COOKED_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> RHINESUCHUS_SPAWN_EGG = register("rhinesuchus", () -> EntityInit.RHINESUCHUS_ENTITY.get(), 0xceaa7b, 0x1c1308);
	
	public static final RegistryObject<Item> RHINESUCHUS_SKULL = registerSkull("rhinesuchus");
	public static final RegistryObject<Item> RHINESUCHUS_ARM_BONE = registerArmBone("rhinesuchus");
	public static final RegistryObject<Item> RHINESUCHUS_LEG_BONE = registerLegBone("rhinesuchus");
	public static final RegistryObject<Item> RHINESUCHUS_FOOT_BONE = registerFootBone("rhinesuchus");
	public static final RegistryObject<Item> RHINESUCHUS_RIB_BONE = registerRibBone("rhinesuchus");
	
	//Dimetrodon
	public static final RegistryObject<Item> DIMETRODON_DNA = registerDNA("dimetrodon");
	public static final RegistryObject<Item> DIMETRODON_DNA_DISC = registerDNADisc("dimetrodon");
	public static final RegistryObject<Item> DIMETRODON_SOFT_TISSUE = registerSoftTissue("dimetrodon");
	public static final RegistryObject<Item> DIMETRODON_BLOOD_SYRINGE = ModRegistry.ITEM_REGISTRY.register("syringe_of_dimetrodon_blood", () -> new Item(properties().tab(ItemGroupInit.CREATURES_TAB).craftRemainder(EMPTY_SYRINGE.get())));
	public static final RegistryObject<Item> DIMETRODON_BLOOD_VILE = registerVile("dimetrodon");
	public static final RegistryObject<Item> DIMETRODON_MEAT = registerRawMeat("dimetrodon", FoodInit.RAW_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> DIMETRODON_COOKED_MEAT = registerCookedMeat("dimetrodon", FoodInit.COOKED_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> DIMETRODON_EGG = registerEgg("dimetrodon", () -> BlockInit.PROCOMPSOGNATHUS_EGG.get());
	public static final RegistryObject<Item> DIMETRODON_SPAWN_EGG = register("dimetrodon", () -> EntityInit.DIMETRODON_ENTITY.get(), 0x378ca8, 0x152875);
	
	public static final RegistryObject<Item> DIMETRODON_SKULL = registerSkull("dimetrodon");
	public static final RegistryObject<Item> DIMETRODON_ARM_BONE = registerArmBone("dimetrodon");
	public static final RegistryObject<Item> DIMETRODON_LEG_BONE = registerLegBone("dimetrodon");
	public static final RegistryObject<Item> DIMETRODON_FOOT_BONE = registerFootBone("dimetrodon");
	public static final RegistryObject<Item> DIMETRODON_RIB_BONE = registerRibBone("dimetrodon");
	public static final RegistryObject<Item> DIMETRODON_SAIL = registerOtherBone("dimetrodon_sail");
	
	//Edaphosaurus
	public static final RegistryObject<Item> EDAPHOSAURUS_DNA = registerDNA("edaphosaurus");
	public static final RegistryObject<Item> EDAPHOSAURUS_DNA_DISC = registerDNADisc("edaphosaurus");
	public static final RegistryObject<Item> EDAPHOSAURUS_SOFT_TISSUE = registerSoftTissue("edaphosaurus");
	public static final RegistryObject<Item> EDAPHOSAURUS_BLOOD_SYRINGE = ModRegistry.ITEM_REGISTRY.register("syringe_of_edaphosaurus_blood", () -> new Item(properties().tab(ItemGroupInit.CREATURES_TAB).craftRemainder(EMPTY_SYRINGE.get())));
	public static final RegistryObject<Item> EDAPHOSAURUS_BLOOD_VILE = registerVile("edaphosaurus");
	public static final RegistryObject<Item> EDAPHOSAURUS_MEAT = registerRawMeat("edaphosaurus", FoodInit.RAW_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> EDAPHOSAURUS_COOKED_MEAT = registerCookedMeat("edaphosaurus", FoodInit.COOKED_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> EDAPHOSAURUS_EGG = registerEgg("edaphosaurus", () -> BlockInit.PROCOMPSOGNATHUS_EGG.get());
	public static final RegistryObject<Item> EDAPHOSAURUS_SPAWN_EGG = register("edaphosaurus", () -> EntityInit.EDAPHOSAURUS_ENTITY.get(), 0x96af42, 0x2a3016);
	
	public static final RegistryObject<Item> EDAPHOSAURUS_SKULL = registerSkull("edaphosaurus");
	public static final RegistryObject<Item> EDAPHOSAURUS_ARM_BONE = registerArmBone("edaphosaurus");
	public static final RegistryObject<Item> EDAPHOSAURUS_LEG_BONE = registerLegBone("edaphosaurus");
	public static final RegistryObject<Item> EDAPHOSAURUS_FOOT_BONE = registerFootBone("edaphosaurus");
	public static final RegistryObject<Item> EDAPHOSAURUS_RIB_BONE = registerRibBone("edaphosaurus");
	public static final RegistryObject<Item> EDAPHOSAURUS_SAIL = registerOtherBone("edaphosaurus_sail");

	//Gorgonops
	public static final RegistryObject<Item> GORGONOPS_DNA = registerDNA("gorgonops");
	public static final RegistryObject<Item> GORGONOPS_DNA_DISC = registerDNADisc("gorgonops");
	public static final RegistryObject<Item> GORGONOPS_SOFT_TISSUE = registerSoftTissue("gorgonops");
	public static final RegistryObject<Item> GORGONOPS_BLOOD_SYRINGE = ModRegistry.ITEM_REGISTRY.register("syringe_of_gorgonops_blood", () -> new Item(properties().tab(ItemGroupInit.CREATURES_TAB).craftRemainder(EMPTY_SYRINGE.get())));
	public static final RegistryObject<Item> GORGONOPS_BLOOD_VILE = registerVile("gorgonops");
	public static final RegistryObject<Item> GORGONOPS_MEAT = registerRawMeat("gorgonops", FoodInit.RAW_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> GORGONOPS_COOKED_MEAT = registerCookedMeat("gorgonops", FoodInit.COOKED_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> GORGONOPS_EGG = registerEgg("gorgonops", () -> BlockInit.PROCOMPSOGNATHUS_EGG.get());
	public static final RegistryObject<Item> GORGONOPS_SPAWN_EGG = register("gorgonops", () -> EntityInit.GORGONOPS_ENTITY.get(), 0x967d46, 0x4f2f1a);
	
	public static final RegistryObject<Item> GORGONOPS_SKULL = registerSkull("gorgonops");
	public static final RegistryObject<Item> GORGONOPS_ARM_BONE = registerArmBone("gorgonops");
	public static final RegistryObject<Item> GORGONOPS_LEG_BONE = registerLegBone("gorgonops");
	public static final RegistryObject<Item> GORGONOPS_FOOT_BONE = registerFootBone("gorgonops");
	public static final RegistryObject<Item> GORGONOPS_RIB_BONE = registerRibBone("gorgonops");

	//Carnotaurus
	public static final RegistryObject<Item> CARNOTAURUS_DNA = registerDNA("carnotaurus");
	public static final RegistryObject<Item> CARNOTAURUS_DNA_DISC = registerDNADisc("carnotaurus");
	public static final RegistryObject<Item> CARNOTAURUS_SOFT_TISSUE = registerSoftTissue("carnotaurus");
	public static final RegistryObject<Item> CARNOTAURUS_BLOOD_SYRINGE = ModRegistry.ITEM_REGISTRY.register("syringe_of_carnotaurus_blood", () -> new Item(properties().tab(ItemGroupInit.CREATURES_TAB).craftRemainder(EMPTY_SYRINGE.get())));
	public static final RegistryObject<Item> CARNOTAURUS_BLOOD_VILE = registerVile("carnotaurus");
	public static final RegistryObject<Item> CARNOTAURUS_MEAT = registerRawMeat("carnotaurus", FoodInit.RAW_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> CARNOTAURUS_COOKED_MEAT = registerCookedMeat("carnotaurus", FoodInit.COOKED_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> CARNOTAURUS_EGG = registerEgg("carnotaurus", () -> BlockInit.PROCOMPSOGNATHUS_EGG.get());
	public static final RegistryObject<Item> CARNOTAURUS_SPAWN_EGG = register("carnotaurus", () -> EntityInit.CARNOTAURUS_ENTITY.get(), 0x682324, 0x171c06);
	
	public static final RegistryObject<Item> CARNOTAURUS_SKULL = registerSkull("carnotaurus");
	public static final RegistryObject<Item> CARNOTAURUS_ARM_BONE = registerArmBone("carnotaurus");
	public static final RegistryObject<Item> CARNOTAURUS_LEG_BONE = registerLegBone("carnotaurus");
	public static final RegistryObject<Item> CARNOTAURUS_FOOT_BONE = registerFootBone("carnotaurus");
	public static final RegistryObject<Item> CARNOTAURUS_RIB_BONE = registerRibBone("carnotaurus");
	//Tyrannosaurus
	public static final RegistryObject<Item> TYRANNOSAURUS_DNA = registerDNA("tyrannosaurus");
	public static final RegistryObject<Item> TYRANNOSAURUS_DNA_DISC = registerDNADisc("tyrannosaurus");
	public static final RegistryObject<Item> TYRANNOSAURUS_SOFT_TISSUE = registerSoftTissue("tyrannosaurus");
	public static final RegistryObject<Item> TYRANNOSAURUS_BLOOD_SYRINGE = ModRegistry.ITEM_REGISTRY.register("syringe_of_tyrannosaurus_blood", () -> new Item(properties().tab(ItemGroupInit.CREATURES_TAB).craftRemainder(EMPTY_SYRINGE.get())));
	public static final RegistryObject<Item> TYRANNOSAURUS_BLOOD_VILE = registerVile("tyrannosaurus");
	public static final RegistryObject<Item> TYRANNOSAURUS_MEAT = registerRawMeat("tyrannosaurus", FoodInit.RAW_LARGE_DINOSAUR_MEAT);
	public static final RegistryObject<Item> TYRANNOSAURUS_COOKED_MEAT = registerCookedMeat("tyrannosaurus", FoodInit.COOKED_LARGE_DINOSAUR_MEAT);
	public static final RegistryObject<Item> TYRANNOSAURUS_EGG = registerEgg("tyrannosaurus", () -> BlockInit.PROCOMPSOGNATHUS_EGG.get());
	public static final RegistryObject<Item> TYRANNOSAURUS_SPAWN_EGG = register("tyrannosaurus", () -> EntityInit.TYRANNOSAURUS_ENTITY.get(), 0x92b541, 0x125134);
	
	public static final RegistryObject<Item> TYRANNOSAURUS_SKULL = registerSkull("tyrannosaurus");
	public static final RegistryObject<Item> TYRANNOSAURUS_ARM_BONE = registerArmBone("tyrannosaurus");
	public static final RegistryObject<Item> TYRANNOSAURUS_LEG_BONE = registerLegBone("tyrannosaurus");
	public static final RegistryObject<Item> TYRANNOSAURUS_FOOT_BONE = registerFootBone("tyrannosaurus");
	public static final RegistryObject<Item> TYRANNOSAURUS_RIB_BONE = registerRibBone("tyrannosaurus");

	//Allosaurus
	public static final RegistryObject<Item> ALLOSAURUS_DNA = registerDNA("allosaurus");
	public static final RegistryObject<Item> ALLOSAURUS_DNA_DISC = registerDNADisc("allosaurus");
	public static final RegistryObject<Item> ALLOSAURUS_SOFT_TISSUE = registerSoftTissue("allosaurus");
	public static final RegistryObject<Item> ALLOSAURUS_BLOOD_SYRINGE = ModRegistry.ITEM_REGISTRY.register("syringe_of_allosaurus_blood", () -> new Item(properties().tab(ItemGroupInit.CREATURES_TAB).craftRemainder(EMPTY_SYRINGE.get())));
	public static final RegistryObject<Item> ALLOSAURUS_BLOOD_VILE = registerVile("allosaurus");
	public static final RegistryObject<Item> ALLOSAURUS_MEAT = registerRawMeat("allosaurus", FoodInit.RAW_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> ALLOSAURUS_COOKED_MEAT = registerCookedMeat("allosaurus", FoodInit.COOKED_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> ALLOSAURUS_EGG = registerEgg("allosaurus", () -> BlockInit.PROCOMPSOGNATHUS_EGG.get());
	public static final RegistryObject<Item> ALLOSAURUS_SPAWN_EGG = register("allosaurus", () -> EntityInit.ALLOSAURUS_ENTITY.get(), 0x687c35, 0x26300c);
	
	public static final RegistryObject<Item> ALLOSAURUS_SKULL = registerSkull("allosaurus");
	public static final RegistryObject<Item> ALLOSAURUS_ARM_BONE = registerArmBone("allosaurus");
	public static final RegistryObject<Item> ALLOSAURUS_LEG_BONE = registerLegBone("allosaurus");
	public static final RegistryObject<Item> ALLOSAURUS_FOOT_BONE = registerFootBone("allosaurus");
	public static final RegistryObject<Item> ALLOSAURUS_RIB_BONE = registerRibBone("allosaurus");
	
	//Giganotosaurus
	public static final RegistryObject<Item> GIGANOTOSAURUS_DNA = registerDNA("giganotosaurus");
	public static final RegistryObject<Item> GIGANOTOSAURUS_DNA_DISC = registerDNADisc("giganotosaurus");
	public static final RegistryObject<Item> GIGANOTOSAURUS_SOFT_TISSUE = registerSoftTissue("giganotosaurus");
	public static final RegistryObject<Item> GIGANOTOSAURUS_BLOOD_SYRINGE = ModRegistry.ITEM_REGISTRY.register("syringe_of_giganotosaurus_blood", () -> new Item(properties().tab(ItemGroupInit.CREATURES_TAB).craftRemainder(EMPTY_SYRINGE.get())));
	public static final RegistryObject<Item> GIGANOTOSAURUS_BLOOD_VILE = registerVile("giganotosaurus");
	public static final RegistryObject<Item> GIGANOTOSAURUS_MEAT = registerRawMeat("giganotosaurus", FoodInit.RAW_LARGE_DINOSAUR_MEAT);
	public static final RegistryObject<Item> GIGANOTOSAURUS_COOKED_MEAT = registerCookedMeat("giganotosaurus", FoodInit.COOKED_LARGE_DINOSAUR_MEAT);
	public static final RegistryObject<Item> GIGANOTOSAURUS_EGG = registerEgg("giganotosaurus", () -> BlockInit.PROCOMPSOGNATHUS_EGG.get());
	public static final RegistryObject<Item> GIGANOTOSAURUS_SPAWN_EGG = register("giganotosaurus", () -> EntityInit.GIGANOTOSAURUS_ENTITY.get(), 0xd8a734, 0x4f391c);
	
	public static final RegistryObject<Item> GIGANOTOSAURUS_SKULL = registerSkull("giganotosaurus");
	public static final RegistryObject<Item> GIGANOTOSAURUS_ARM_BONE = registerArmBone("giganotosaurus");
	public static final RegistryObject<Item> GIGANOTOSAURUS_LEG_BONE = registerLegBone("giganotosaurus");
	public static final RegistryObject<Item> GIGANOTOSAURUS_FOOT_BONE = registerFootBone("giganotosaurus");
	public static final RegistryObject<Item> GIGANOTOSAURUS_RIB_BONE = registerRibBone("giganotosaurus");
	
	//Suchomimus
	public static final RegistryObject<Item> SUCHOMIMUS_DNA = registerDNA("suchomimus");
	public static final RegistryObject<Item> SUCHOMIMUS_DNA_DISC = registerDNADisc("suchomimus");
	public static final RegistryObject<Item> SUCHOMIMUS_SOFT_TISSUE = registerSoftTissue("suchomimus");
	public static final RegistryObject<Item> SUCHOMIMUS_BLOOD_SYRINGE = ModRegistry.ITEM_REGISTRY.register("syringe_of_suchomimus_blood", () -> new Item(properties().tab(ItemGroupInit.CREATURES_TAB).craftRemainder(EMPTY_SYRINGE.get())));
	public static final RegistryObject<Item> SUCHOMIMUS_BLOOD_VILE = registerVile("suchomimus");
	public static final RegistryObject<Item> SUCHOMIMUS_MEAT = registerRawMeat("suchomimus", FoodInit.RAW_LARGE_DINOSAUR_MEAT);
	public static final RegistryObject<Item> SUCHOMIMUS_COOKED_MEAT = registerCookedMeat("suchomimus", FoodInit.COOKED_LARGE_DINOSAUR_MEAT);
	public static final RegistryObject<Item> SUCHOMIMUS_EGG = registerEgg("suchomimus", () -> BlockInit.PROCOMPSOGNATHUS_EGG.get());
	public static final RegistryObject<Item> SUCHOMIMUS_SPAWN_EGG = register("suchomimus", () -> EntityInit.SUCHOMIMUS_ENTITY.get(), 0x6a94c1, 0x110f54);
	
	public static final RegistryObject<Item> SUCHOMIMUS_SKULL = registerSkull("suchomimus");
	public static final RegistryObject<Item> SUCHOMIMUS_ARM_BONE = registerArmBone("suchomimus");
	public static final RegistryObject<Item> SUCHOMIMUS_LEG_BONE = registerLegBone("suchomimus");
	public static final RegistryObject<Item> SUCHOMIMUS_FOOT_BONE = registerFootBone("suchomimus");
	public static final RegistryObject<Item> SUCHOMIMUS_RIB_BONE = registerRibBone("suchomimus");
	
	//Tetraceratops
	public static final RegistryObject<Item> TETRACERATOPS_DNA = registerDNA("tetraceratops");
	public static final RegistryObject<Item> TETRACERATOPS_DNA_DISC = registerDNADisc("tetraceratops");
	public static final RegistryObject<Item> TETRACERATOPS_SOFT_TISSUE = registerSoftTissue("tetraceratops");
	public static final RegistryObject<Item> TETRACERATOPS_BLOOD_SYRINGE = ModRegistry.ITEM_REGISTRY.register("syringe_of_tetraceratops_blood", () -> new Item(properties().tab(ItemGroupInit.CREATURES_TAB).craftRemainder(EMPTY_SYRINGE.get())));
	public static final RegistryObject<Item> TETRACERATOPS_BLOOD_VILE = registerVile("tetraceratops");
	public static final RegistryObject<Item> TETRACERATOPS_MEAT = registerRawMeat("tetraceratops", FoodInit.RAW_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> TETRACERATOPS_COOKED_MEAT = registerCookedMeat("tetraceratops", FoodInit.COOKED_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> TETRACERATOPS_EGG = registerEgg("tetraceratops", () -> BlockInit.PROCOMPSOGNATHUS_EGG.get());
	public static final RegistryObject<Item> TETRACERATOPS_SPAWN_EGG = register("tetraceratops", () -> EntityInit.TETRACERATOPS_ENTITY.get(), 0x873624, 0x543b11);
	
	public static final RegistryObject<Item> TETRACERATOPS_SKULL = registerSkull("tetraceratops");
	public static final RegistryObject<Item> TETRACERATOPS_ARM_BONE = registerArmBone("tetraceratops");
	public static final RegistryObject<Item> TETRACERATOPS_LEG_BONE = registerLegBone("tetraceratops");
	public static final RegistryObject<Item> TETRACERATOPS_FOOT_BONE = registerFootBone("tetraceratops");
	public static final RegistryObject<Item> TETRACERATOPS_RIB_BONE = registerRibBone("tetraceratops");
	public static final RegistryObject<Item> TETRACERATOPS_HORN = registerOtherBone("tetraceratops_horn");

	public static final RegistryObject<Item> GREAT_AUK_DNA = registerDNA("great_auk");
	public static final RegistryObject<Item> GREAT_AUK_DNA_DISC = registerDNADisc("great_auk");
	public static final RegistryObject<Item> GREAT_AUK_SOFT_TISSUE = registerSoftTissue("great_auk");
	public static final RegistryObject<Item> GREAT_AUK_BLOOD_SYRINGE = ModRegistry.ITEM_REGISTRY.register("syringe_of_great_auk_blood", () -> new Item(properties().tab(ItemGroupInit.CREATURES_TAB).craftRemainder(EMPTY_SYRINGE.get())));
	public static final RegistryObject<Item> GREAT_AUK_BLOOD_VILE = registerVile("great_auk");
	public static final RegistryObject<Item> GREAT_AUK_MEAT = registerRawMeat("great_auk", FoodInit.RAW_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> GREAT_AUK_COOKED_MEAT = registerCookedMeat("great_auk", FoodInit.COOKED_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> GREAT_AUK_EGG = register("great_auk_egg", new GreatAukEggItem(properties().stacksTo(16)));
	public static final RegistryObject<Item> GREAT_AUK_SPAWN_EGG = register("great_auk", () -> EntityInit.GREAT_AUK_ENTITY.get(), 0x000000, 0xFFFFFF);
	
	public static final RegistryObject<Item> GREAT_AUK_SKULL = registerSkull("great_auk");
	public static final RegistryObject<Item> GREAT_AUK_ARM_BONE = registerArmBone("great_auk");
	public static final RegistryObject<Item> GREAT_AUK_LEG_BONE = registerLegBone("great_auk");
	public static final RegistryObject<Item> GREAT_AUK_FOOT_BONE = registerFootBone("great_auk");
	public static final RegistryObject<Item> GREAT_AUK_RIB_BONE = registerRibBone("great_auk");

	//Ouranosaurus
	public static final RegistryObject<Item> OURANOSAURUS_DNA = registerDNA("ouranosaurus");
	public static final RegistryObject<Item> OURANOSAURUS_DNA_DISC = registerDNADisc("ouranosaurus");
	public static final RegistryObject<Item> OURANOSAURUS_SOFT_TISSUE = registerSoftTissue("ouranosaurus");
	public static final RegistryObject<Item> OURANOSAURUS_BLOOD_SYRINGE = ModRegistry.ITEM_REGISTRY.register("syringe_of_ouranosaurus_blood", () -> new Item(properties().tab(ItemGroupInit.CREATURES_TAB).craftRemainder(EMPTY_SYRINGE.get())));
	public static final RegistryObject<Item> OURANOSAURUS_BLOOD_VILE = registerVile("ouranosaurus");
	public static final RegistryObject<Item> OURANOSAURUS_MEAT = registerRawMeat("ouranosaurus", FoodInit.RAW_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> OURANOSAURUS_COOKED_MEAT = registerCookedMeat("ouranosaurus", FoodInit.COOKED_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> OURANOSAURUS_EGG = registerEgg("ouranosaurus", () -> BlockInit.PROCOMPSOGNATHUS_EGG.get());
	public static final RegistryObject<Item> OURANOSAURUS_SPAWN_EGG = register("ouranosaurus", () -> EntityInit.OURANOSAURUS_ENTITY.get(), 0x2b3187, 0x1da6e5);
	
	public static final RegistryObject<Item> OURANOSAURUS_SKULL = registerSkull("ouranosaurus");
	public static final RegistryObject<Item> OURANOSAURUS_ARM_BONE = registerArmBone("ouranosaurus");
	public static final RegistryObject<Item> OURANOSAURUS_LEG_BONE = registerLegBone("ouranosaurus");
	public static final RegistryObject<Item> OURANOSAURUS_FOOT_BONE = registerFootBone("ouranosaurus");
	public static final RegistryObject<Item> OURANOSAURUS_RIB_BONE = registerRibBone("ouranosaurus");
	public static final RegistryObject<Item> OURANOSAURUS_SAIL = registerOtherBone("ouranosaurus_sail");

	//Fukuivenator
	public static final RegistryObject<Item> FUKUIVENATOR_DNA = registerDNA("fukuivenator");
	public static final RegistryObject<Item> FUKUIVENATOR_DNA_DISC = registerDNADisc("fukuivenator");
	public static final RegistryObject<Item> FUKUIVENATOR_SOFT_TISSUE = registerSoftTissue("fukuivenator");
	public static final RegistryObject<Item> FUKUIVENATOR_BLOOD_SYRINGE = ModRegistry.ITEM_REGISTRY.register("syringe_of_fukuivenator_blood", () -> new Item(properties().tab(ItemGroupInit.CREATURES_TAB).craftRemainder(EMPTY_SYRINGE.get())));
	public static final RegistryObject<Item> FUKUIVENATOR_BLOOD_VILE = registerVile("fukuivenator");
	public static final RegistryObject<Item> FUKUIVENATOR_MEAT = registerRawMeat("fukuivenator", FoodInit.RAW_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> FUKUIVENATOR_COOKED_MEAT = registerCookedMeat("fukuivenator", FoodInit.COOKED_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> FUKUIVENATOR_EGG = registerEgg("fukuivenator", () -> BlockInit.PROCOMPSOGNATHUS_EGG.get());
	public static final RegistryObject<Item> FUKUIVENATOR_SPAWN_EGG = register("fukuivenator", () -> EntityInit.FUKUIVENATOR_ENTITY.get(), 0xbb6ad8, 0x44284f);
	
	public static final RegistryObject<Item> FUKUIVENATOR_SKULL = registerSkull("fukuivenator");
	public static final RegistryObject<Item> FUKUIVENATOR_ARM_BONE = registerArmBone("fukuivenator");
	public static final RegistryObject<Item> FUKUIVENATOR_LEG_BONE = registerLegBone("fukuivenator");
	public static final RegistryObject<Item> FUKUIVENATOR_FOOT_BONE = registerFootBone("fukuivenator");
	public static final RegistryObject<Item> FUKUIVENATOR_RIB_BONE = registerRibBone("fukuivenator");
	public static final RegistryObject<Item> FUKUIVENATOR_CLAW = registerOtherBone("fukuivenator_claw");
	
	//Psittacosaurus
	public static final RegistryObject<Item> PSITTACOSAURUS_DNA = registerDNA("psittacosaurus");
	public static final RegistryObject<Item> PSITTACOSAURUS_DNA_DISC = registerDNADisc("psittacosaurus");
	public static final RegistryObject<Item> PSITTACOSAURUS_SOFT_TISSUE = registerSoftTissue("psittacosaurus");
	public static final RegistryObject<Item> PSITTACOSAURUS_BLOOD_SYRINGE = ModRegistry.ITEM_REGISTRY.register("syringe_of_psittacosaurus_blood", () -> new Item(properties().tab(ItemGroupInit.CREATURES_TAB).craftRemainder(EMPTY_SYRINGE.get())));
	public static final RegistryObject<Item> PSITTACOSAURUS_BLOOD_VILE = registerVile("psittacosaurus");
	public static final RegistryObject<Item> PSITTACOSAURUS_MEAT = registerRawMeat("psittacosaurus", FoodInit.RAW_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> PSITTACOSAURUS_COOKED_MEAT = registerCookedMeat("psittacosaurus", FoodInit.COOKED_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> PSITTACOSAURUS_EGG = registerEgg("psittacosaurus", () -> BlockInit.PROCOMPSOGNATHUS_EGG.get());
	public static final RegistryObject<Item> PSITTACOSAURUS_SPAWN_EGG = register("psittacosaurus", () -> EntityInit.PSITTACOSAURUS_ENTITY.get(), 0x6d4d20, 0x434c16);
	
	public static final RegistryObject<Item> PSITTACOSAURUS_SKULL = registerSkull("psittacosaurus");
	public static final RegistryObject<Item> PSITTACOSAURUS_ARM_BONE = registerArmBone("psittacosaurus");
	public static final RegistryObject<Item> PSITTACOSAURUS_LEG_BONE = registerLegBone("psittacosaurus");
	public static final RegistryObject<Item> PSITTACOSAURUS_FOOT_BONE = registerFootBone("psittacosaurus");
	public static final RegistryObject<Item> PSITTACOSAURUS_RIB_BONE = registerRibBone("psittacosaurus");
	
	//Cryolophosaurus
	public static final RegistryObject<Item> CRYOLOPHOSAURUS_DNA = registerDNA("cryolophosaurus");
	public static final RegistryObject<Item> CRYOLOPHOSAURUS_DNA_DISC = registerDNADisc("cryolophosaurus");
	public static final RegistryObject<Item> CRYOLOPHOSAURUS_SOFT_TISSUE = registerSoftTissue("cryolophosaurus");
	public static final RegistryObject<Item> CRYOLOPHOSAURUS_BLOOD_SYRINGE = ModRegistry.ITEM_REGISTRY.register("syringe_of_cryolophosaurus_blood", () -> new Item(properties().tab(ItemGroupInit.CREATURES_TAB).craftRemainder(EMPTY_SYRINGE.get())));
	public static final RegistryObject<Item> CRYOLOPHOSAURUS_BLOOD_VILE = registerVile("cryolophosaurus");
	public static final RegistryObject<Item> CRYOLOPHOSAURUS_MEAT = registerRawMeat("cryolophosaurus", FoodInit.RAW_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> CRYOLOPHOSAURUS_COOKED_MEAT = registerCookedMeat("cryolophosaurus", FoodInit.COOKED_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> CRYOLOPHOSAURUS_EGG = registerEgg("cryolophosaurus", () -> BlockInit.PROCOMPSOGNATHUS_EGG.get());
	public static final RegistryObject<Item> CRYOLOPHOSAURUS_SPAWN_EGG = register("cryolophosaurus", () -> EntityInit.CRYOLOPHOSAURUS_ENTITY.get(), 0xcec21e, 0xce791e);
	
	public static final RegistryObject<Item> CRYOLOPHOSAURUS_SKULL = registerSkull("cryolophosaurus");
	public static final RegistryObject<Item> CRYOLOPHOSAURUS_ARM_BONE = registerArmBone("cryolophosaurus");
	public static final RegistryObject<Item> CRYOLOPHOSAURUS_LEG_BONE = registerLegBone("cryolophosaurus");
	public static final RegistryObject<Item> CRYOLOPHOSAURUS_FOOT_BONE = registerFootBone("cryolophosaurus");
	public static final RegistryObject<Item> CRYOLOPHOSAURUS_RIB_BONE = registerRibBone("cryolophosaurus");

	//Ostromia
	public static final RegistryObject<Item> OSTROMIA_DNA = registerDNA("ostromia");
	public static final RegistryObject<Item> OSTROMIA_DNA_DISC = registerDNADisc("ostromia");
	public static final RegistryObject<Item> OSTROMIA_SOFT_TISSUE = registerSoftTissue("ostromia");
	public static final RegistryObject<Item> OSTROMIA_BLOOD_SYRINGE = ModRegistry.ITEM_REGISTRY.register("syringe_of_ostromia_blood", () -> new Item(properties().tab(ItemGroupInit.CREATURES_TAB).craftRemainder(EMPTY_SYRINGE.get())));
	public static final RegistryObject<Item> OSTROMIA_BLOOD_VILE = registerVile("ostromia");
	public static final RegistryObject<Item> OSTROMIA_MEAT = registerRawMeat("ostromia", FoodInit.RAW_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> OSTROMIA_COOKED_MEAT = registerCookedMeat("ostromia", FoodInit.COOKED_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> OSTROMIA_EGG = registerEgg("ostromia", () -> BlockInit.PROCOMPSOGNATHUS_EGG.get());
	public static final RegistryObject<Item> OSTROMIA_SPAWN_EGG = register("ostromia", () -> EntityInit.OSTROMIA_ENTITY.get(), 0x3c8370, 0x1f3970);
	
	public static final RegistryObject<Item> OSTROMIA_SKULL = registerSkull("ostromia");
	public static final RegistryObject<Item> OSTROMIA_ARM_BONE = registerArmBone("ostromia");
	public static final RegistryObject<Item> OSTROMIA_LEG_BONE = registerLegBone("ostromia");
	public static final RegistryObject<Item> OSTROMIA_FOOT_BONE = registerFootBone("ostromia");
	public static final RegistryObject<Item> OSTROMIA_RIB_BONE = registerRibBone("ostromia");
	public static final RegistryObject<Item> OSTROMIA_FEATHER = registerOtherBone("ostromia_feather");
	
	//Protosuchus
	public static final RegistryObject<Item> PROTOSUCHUS_DNA = registerDNA("protosuchus");
	public static final RegistryObject<Item> PROTOSUCHUS_DNA_DISC = registerDNADisc("protosuchus");
	public static final RegistryObject<Item> PROTOSUCHUS_SOFT_TISSUE = registerSoftTissue("protosuchus");
	public static final RegistryObject<Item> PROTOSUCHUS_BLOOD_SYRINGE = ModRegistry.ITEM_REGISTRY.register("syringe_of_protosuchus_blood", () -> new Item(properties().tab(ItemGroupInit.CREATURES_TAB).craftRemainder(EMPTY_SYRINGE.get())));
	public static final RegistryObject<Item> PROTOSUCHUS_BLOOD_VILE = registerVile("protosuchus");
	public static final RegistryObject<Item> PROTOSUCHUS_MEAT = registerRawMeat("protosuchus", FoodInit.RAW_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> PROTOSUCHUS_COOKED_MEAT = registerCookedMeat("protosuchus", FoodInit.COOKED_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> PROTOSUCHUS_EGG = registerEgg("protosuchus", () -> BlockInit.PROCOMPSOGNATHUS_EGG.get());
	public static final RegistryObject<Item> PROTOSUCHUS_SPAWN_EGG = register("protosuchus", () -> EntityInit.PROTOSUCHUS_ENTITY.get(), 0x773617, 0x470b0a);
	
	public static final RegistryObject<Item> PROTOSUCHUS_SKULL = registerSkull("protosuchus");
	public static final RegistryObject<Item> PROTOSUCHUS_ARM_BONE = registerArmBone("protosuchus");
	public static final RegistryObject<Item> PROTOSUCHUS_LEG_BONE = registerLegBone("protosuchus");
	public static final RegistryObject<Item> PROTOSUCHUS_FOOT_BONE = registerFootBone("protosuchus");
	public static final RegistryObject<Item> PROTOSUCHUS_RIB_BONE = registerRibBone("protosuchus");
	
	//Diictodon
	public static final RegistryObject<Item> DIICTODON_DNA = registerDNA("diictodon");
	public static final RegistryObject<Item> DIICTODON_DNA_DISC = registerDNADisc("diictodon");
	public static final RegistryObject<Item> DIICTODON_SOFT_TISSUE = registerSoftTissue("diictodon");
	public static final RegistryObject<Item> DIICTODON_BLOOD_SYRINGE = ModRegistry.ITEM_REGISTRY.register("syringe_of_diictodon_blood", () -> new Item(properties().tab(ItemGroupInit.CREATURES_TAB).craftRemainder(EMPTY_SYRINGE.get())));
	public static final RegistryObject<Item> DIICTODON_BLOOD_VILE = registerVile("diictodon");
	public static final RegistryObject<Item> DIICTODON_MEAT = registerRawMeat("diictodon", FoodInit.RAW_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> DIICTODON_COOKED_MEAT = registerCookedMeat("diictodon", FoodInit.COOKED_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> DIICTODON_EGG = registerEgg("diictodon", () -> BlockInit.PROCOMPSOGNATHUS_EGG.get());
	public static final RegistryObject<Item> DIICTODON_SPAWN_EGG = register("diictodon", () -> EntityInit.DIICTODON_ENTITY.get(), 0x8e7022, 0x7a4334);
	
	public static final RegistryObject<Item> DIICTODON_SKULL = registerSkull("diictodon");
	public static final RegistryObject<Item> DIICTODON_ARM_BONE = registerArmBone("diictodon");
	public static final RegistryObject<Item> DIICTODON_LEG_BONE = registerLegBone("diictodon");
	public static final RegistryObject<Item> DIICTODON_FOOT_BONE = registerFootBone("diictodon");
	public static final RegistryObject<Item> DIICTODON_RIB_BONE = registerRibBone("diictodon");
	
	//Kentrosaurus
	public static final RegistryObject<Item> KENTROSAURUS_DNA = registerDNA("kentrosaurus");
	public static final RegistryObject<Item> KENTROSAURUS_DNA_DISC = registerDNADisc("kentrosaurus");
	public static final RegistryObject<Item> KENTROSAURUS_SOFT_TISSUE = registerSoftTissue("kentrosaurus");
	public static final RegistryObject<Item> KENTROSAURUS_BLOOD_SYRINGE = ModRegistry.ITEM_REGISTRY.register("syringe_of_kentrosaurus_blood", () -> new Item(properties().tab(ItemGroupInit.CREATURES_TAB).craftRemainder(EMPTY_SYRINGE.get())));
	public static final RegistryObject<Item> KENTROSAURUS_BLOOD_VILE = registerVile("kentrosaurus");
	public static final RegistryObject<Item> KENTROSAURUS_MEAT = registerRawMeat("kentrosaurus", FoodInit.RAW_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> KENTROSAURUS_COOKED_MEAT = registerCookedMeat("kentrosaurus", FoodInit.COOKED_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> KENTROSAURUS_EGG = registerEgg("kentrosaurus", () -> BlockInit.PROCOMPSOGNATHUS_EGG.get());
	public static final RegistryObject<Item> KENTROSAURUS_SPAWN_EGG = register("kentrosaurus", () -> EntityInit.KENTROSAURUS_ENTITY.get(), 0xd99760, 0x612c00);
	
	public static final RegistryObject<Item> KENTROSAURUS_SKULL = registerSkull("kentrosaurus");
	public static final RegistryObject<Item> KENTROSAURUS_ARM_BONE = registerArmBone("kentrosaurus");
	public static final RegistryObject<Item> KENTROSAURUS_LEG_BONE = registerLegBone("kentrosaurus");
	public static final RegistryObject<Item> KENTROSAURUS_FOOT_BONE = registerFootBone("kentrosaurus");
	public static final RegistryObject<Item> KENTROSAURUS_RIB_BONE = registerRibBone("kentrosaurus");
	public static final RegistryObject<Item> KENTROSAURUS_PLATE = registerOtherBone("kentrosaurus_plate");
	
	//Chilesaurus
	public static final RegistryObject<Item> CHILESAURUS_DNA = registerDNA("chilesaurus");
	public static final RegistryObject<Item> CHILESAURUS_DNA_DISC = registerDNADisc("chilesaurus");
	public static final RegistryObject<Item> CHILESAURUS_SOFT_TISSUE = registerSoftTissue("chilesaurus");
	public static final RegistryObject<Item> CHILESAURUS_BLOOD_SYRINGE = ModRegistry.ITEM_REGISTRY.register("syringe_of_chilesaurus_blood", () -> new Item(properties().tab(ItemGroupInit.CREATURES_TAB).craftRemainder(EMPTY_SYRINGE.get())));
	public static final RegistryObject<Item> CHILESAURUS_BLOOD_VILE = registerVile("chilesaurus");
	public static final RegistryObject<Item> CHILESAURUS_MEAT = registerRawMeat("chilesaurus", FoodInit.RAW_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> CHILESAURUS_COOKED_MEAT = registerCookedMeat("chilesaurus", FoodInit.COOKED_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> CHILESAURUS_EGG = registerEgg("chilesaurus", () -> BlockInit.PROCOMPSOGNATHUS_EGG.get());
	public static final RegistryObject<Item> CHILESAURUS_SPAWN_EGG = register("chilesaurus", () -> EntityInit.CHILESAURUS_ENTITY.get(), 0xb08533, 0x283c3f);
	
	public static final RegistryObject<Item> CHILESAURUS_SKULL = registerSkull("chilesaurus");
	public static final RegistryObject<Item> CHILESAURUS_ARM_BONE = registerArmBone("chilesaurus");
	public static final RegistryObject<Item> CHILESAURUS_LEG_BONE = registerLegBone("chilesaurus");
	public static final RegistryObject<Item> CHILESAURUS_FOOT_BONE = registerFootBone("chilesaurus");
	public static final RegistryObject<Item> CHILESAURUS_RIB_BONE = registerRibBone("chilesaurus");
	
	//Liaoningosaurus
	public static final RegistryObject<Item> LIAONINGOSAURUS_DNA = registerDNA("liaoningosaurus");
	public static final RegistryObject<Item> LIAONINGOSAURUS_DNA_DISC = registerDNADisc("liaoningosaurus");
	public static final RegistryObject<Item> LIAONINGOSAURUS_SOFT_TISSUE = registerSoftTissue("liaoningosaurus");
	public static final RegistryObject<Item> LIAONINGOSAURUS_BLOOD_SYRINGE = ModRegistry.ITEM_REGISTRY.register("syringe_of_liaoningosaurus_blood", () -> new Item(properties().tab(ItemGroupInit.CREATURES_TAB).craftRemainder(EMPTY_SYRINGE.get())));
	public static final RegistryObject<Item> LIAONINGOSAURUS_BLOOD_VILE = registerVile("liaoningosaurus");
	public static final RegistryObject<Item> LIAONINGOSAURUS_MEAT = registerRawMeat("liaoningosaurus", FoodInit.RAW_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> LIAONINGOSAURUS_COOKED_MEAT = registerCookedMeat("liaoningosaurus", FoodInit.COOKED_SMALL_DINOSAUR_MEAT);
	public static final RegistryObject<Item> LIAONINGOSAURUS_EGG = registerEgg("liaoningosaurus", () -> BlockInit.PROCOMPSOGNATHUS_EGG.get());
	public static final RegistryObject<Item> LIAONINGOSAURUS_SPAWN_EGG = register("liaoningosaurus", () -> EntityInit.LIAONINGOSAURUS_ENTITY.get(), 0x907629, 0x50521c);
	
	public static final RegistryObject<Item> LIAONINGOSAURUS_SKULL = registerSkull("liaoningosaurus");
	public static final RegistryObject<Item> LIAONINGOSAURUS_ARM_BONE = registerArmBone("liaoningosaurus");
	public static final RegistryObject<Item> LIAONINGOSAURUS_LEG_BONE = registerLegBone("liaoningosaurus");
	public static final RegistryObject<Item> LIAONINGOSAURUS_FOOT_BONE = registerFootBone("liaoningosaurus");
	public static final RegistryObject<Item> LIAONINGOSAURUS_RIB_BONE = registerRibBone("liaoningosaurus");
	public static final RegistryObject<Item> LIAONINGOSAURUS_SCUTE = registerOtherBone("liaoningosaurus_scute");
	
	/*//Ophthalmosaurus
	public static final RegistryObject<Item> OPHTHALMOSAURUS_DNA = registerDNA("ophthalmosaurus");
	public static final RegistryObject<Item> OPHTHALMOSAURUS_DNA_DISC = registerDNADisc("ophthalmosaurus");
	public static final RegistryObject<Item> OPHTHALMOSAURUS_MEAT = registerRawMeat("ophthalmosaurus", FoodInit.RAW_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> OPHTHALMOSAURUS_COOKED_MEAT = registerCookedMeat("ophthalmosaurus", FoodInit.RAW_MEDIUM_DINOSAUR_MEAT);
	public static final RegistryObject<Item> OPHTHALMOSAURUS_SPAWN_EGG = register("ophthalmosaurus", () -> EntityInit.OPHTHALMOSAURUS_ENTITY.get(), 0x75767c, 0x2e3948);*/
	
	//Mud Ball
	public static final RegistryObject<Item> MUD_BALL = register("mud_ball", properties().tab(ItemGroupInit.ITEMS_TAB));
	
	//Copper	
	public static final RegistryObject<Item> COPPER_INGOT = register("copper_ingot", properties().tab(ItemGroupInit.ITEMS_TAB));
	public static final RegistryObject<Item> COPPER_NUGGET = register("copper_nugget", properties().tab(ItemGroupInit.ITEMS_TAB));
	
	//Electronics
	public static final RegistryObject<Item> COPPER_WIRE = register("copper_wire", properties().tab(ItemGroupInit.ITEMS_TAB));	
	public static final RegistryObject<Item> COMPUTER_FAN = register("computer_fan", properties().tab(ItemGroupInit.ITEMS_TAB));
	public static final RegistryObject<Item> COMPUTER_SCREEN = register("computer_screen", properties().tab(ItemGroupInit.ITEMS_TAB));
	public static final RegistryObject<Item> COMPUTER_FRAME = register("computer_frame", properties().tab(ItemGroupInit.ITEMS_TAB));
	public static final RegistryObject<Item> COMPUTER_STORAGE_PORT = register("computer_storage_port", properties().tab(ItemGroupInit.ITEMS_TAB));
	public static final RegistryObject<Item> MOTHERBOARD = register("motherboard", properties().tab(ItemGroupInit.ITEMS_TAB));
	public static final RegistryObject<Item> CPU = register("cpu", properties().tab(ItemGroupInit.ITEMS_TAB));
	public static final RegistryObject<Item> RAM = register("ram", properties().tab(ItemGroupInit.ITEMS_TAB));	
	
	//Storage
	public static final RegistryObject<Item> STORAGE_DISC = register("storage_disc", new Item(properties().stacksTo(1).tab(ItemGroupInit.ITEMS_TAB)));
	
	//Crystal Scarab	
	public static final RegistryObject<Item> BROKEN_CRYSTAL_SCARAB_GEM = register("broken_crystal_scarab_gem", properties().rarity(Rarity.RARE).tab(ItemGroupInit.ITEMS_TAB));
	public static final RegistryObject<Item> CRYSTAL_SCARAB_GEM = register("crystal_scarab_gem", properties().rarity(Rarity.EPIC).tab(ItemGroupInit.ITEMS_TAB));
	
	//Crystal Scarab Tools
	public static final RegistryObject<Item> CRYSTAL_SCARAB_SWORD = register("crystal_scarab_sword", new SwordItem(ModItemTeir.SCARAB, 50, -2.4F, properties().rarity(Rarity.EPIC).tab(ItemGroupInit.TOOLS_TAB)));
	public static final RegistryObject<Item> CRYSTAL_SCARAB_SHOVEL = register("crystal_scarab_shovel", new ShovelItem(ModItemTeir.SCARAB, 12.0F, -3.0F, properties().rarity(Rarity.EPIC).tab(ItemGroupInit.TOOLS_TAB)));
	public static final RegistryObject<Item> CRYSTAL_SCARAB_PICKAXE = register("crystal_scarab_pickaxe", new PickaxeItem(ModItemTeir.SCARAB, 32, -2.8F, properties().rarity(Rarity.EPIC).tab(ItemGroupInit.TOOLS_TAB)));
	public static final RegistryObject<Item> CRYSTAL_SCARAB_AXE = register("crystal_scarab_axe", new AxeItem(ModItemTeir.SCARAB, 70.0F, -3.2F, properties().rarity(Rarity.EPIC).tab(ItemGroupInit.TOOLS_TAB)));
	public static final RegistryObject<Item> CRYSTAL_SCARAB_HOE = register("crystal_scarab_hoe", new HoeItem(ModItemTeir.SCARAB, 10, -3.0F, properties().rarity(Rarity.EPIC).tab(ItemGroupInit.TOOLS_TAB)));
	
	//Blocks
	//Ore
	public static final RegistryObject<Item> COPPER_ORE = register("copper_ore", () -> BlockInit.COPPER_ORE.get(), ItemGroupInit.ITEMS_TAB);
	
	//Fossil
	public static final RegistryObject<Item> STONE_FOSSIL = registerFossilsTab("stone_fossil", () -> BlockInit.STONE_FOSSIL.get());
	public static final RegistryObject<Item> EXPOSED_STONE_FOSSIL = registerFossilsTab("exposed_stone_fossil", () -> BlockInit.EXPOSED_STONE_FOSSIL.get());

	public static final RegistryObject<Item> SANDSTONE_FOSSIL = registerFossilsTab("sandstone_fossil", () -> BlockInit.SANDSTONE_FOSSIL.get());
	public static final RegistryObject<Item> EXPOSED_SANDSTONE_FOSSIL = registerFossilsTab("exposed_sandstone_fossil", () -> BlockInit.EXPOSED_SANDSTONE_FOSSIL.get());
	
	public static final RegistryObject<Item> RED_SANDSTONE_FOSSIL = registerFossilsTab("red_sandstone_fossil", () -> BlockInit.RED_SANDSTONE_FOSSIL.get());
	public static final RegistryObject<Item> EXPOSED_RED_SANDSTONE_FOSSIL = registerFossilsTab("exposed_red_sandstone_fossil", () -> BlockInit.EXPOSED_RED_SANDSTONE_FOSSIL.get());

	public static final RegistryObject<Item> TERRACOTTA_FOSSIL = registerFossilsTab("terracotta_fossil", () -> BlockInit.TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> EXPOSED_TERRACOTTA_FOSSIL = registerFossilsTab("exposed_terracotta_fossil", () -> BlockInit.EXPOSED_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> RED_TERRACOTTA_FOSSIL = registerFossilsTab("red_terracotta_fossil", () -> BlockInit.RED_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> EXPOSED_RED_TERRACOTTA_FOSSIL = registerFossilsTab("exposed_red_terracotta_fossil", () -> BlockInit.EXPOSED_RED_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> ORANGE_TERRACOTTA_FOSSIL = registerFossilsTab("orange_terracotta_fossil", () -> BlockInit.ORANGE_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> EXPOSED_ORANGE_TERRACOTTA_FOSSIL = registerFossilsTab("exposed_orange_terracotta_fossil", () -> BlockInit.EXPOSED_ORANGE_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> YELLOW_TERRACOTTA_FOSSIL = registerFossilsTab("yellow_terracotta_fossil", () -> BlockInit.YELLOW_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> EXPOSED_YELLOW_TERRACOTTA_FOSSIL = registerFossilsTab("exposed_yellow_terracotta_fossil", () -> BlockInit.EXPOSED_YELLOW_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> LIME_TERRACOTTA_FOSSIL = registerFossilsTab("lime_terracotta_fossil", () -> BlockInit.LIME_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> EXPOSED_LIME_TERRACOTTA_FOSSIL = registerFossilsTab("exposed_lime_terracotta_fossil", () -> BlockInit.EXPOSED_LIME_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> GREEN_TERRACOTTA_FOSSIL = registerFossilsTab("green_terracotta_fossil", () -> BlockInit.GREEN_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> EXPOSED_GREEN_TERRACOTTA_FOSSIL = registerFossilsTab("exposed_green_terracotta_fossil", () -> BlockInit.EXPOSED_GREEN_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> CYAN_TERRACOTTA_FOSSIL = registerFossilsTab("cyan_terracotta_fossil", () -> BlockInit.CYAN_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> EXPOSED_CYAN_TERRACOTTA_FOSSIL = registerFossilsTab("exposed_cyan_terracotta_fossil", () -> BlockInit.EXPOSED_CYAN_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> LIGHT_BLUE_TERRACOTTA_FOSSIL = registerFossilsTab("light_blue_terracotta_fossil", () -> BlockInit.LIGHT_BLUE_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> EXPOSED_LIGHT_BLUE_TERRACOTTA_FOSSIL = registerFossilsTab("exposed_light_blue_terracotta_fossil", () -> BlockInit.EXPOSED_LIGHT_BLUE_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> BLUE_TERRACOTTA_FOSSIL = registerFossilsTab("blue_terracotta_fossil", () -> BlockInit.BLUE_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> EXPOSED_BLUE_TERRACOTTA_FOSSIL = registerFossilsTab("exposed_blue_terracotta_fossil", () -> BlockInit.EXPOSED_BLUE_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> MAGENTA_TERRACOTTA_FOSSIL = registerFossilsTab("magenta_terracotta_fossil", () -> BlockInit.MAGENTA_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> EXPOSED_MAGENTA_TERRACOTTA_FOSSIL = registerFossilsTab("exposed_magenta_terracotta_fossil", () -> BlockInit.EXPOSED_MAGENTA_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> PURPLE_TERRACOTTA_FOSSIL = registerFossilsTab("purple_terracotta_fossil", () -> BlockInit.PURPLE_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> EXPOSED_PURPLE_TERRACOTTA_FOSSIL = registerFossilsTab("exposed_purple_terracotta_fossil", () -> BlockInit.EXPOSED_PURPLE_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> PINK_TERRACOTTA_FOSSIL = registerFossilsTab("pink_terracotta_fossil", () -> BlockInit.PINK_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> EXPOSED_PINK_TERRACOTTA_FOSSIL = registerFossilsTab("exposed_pink_terracotta_fossil", () -> BlockInit.EXPOSED_PINK_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> BROWN_TERRACOTTA_FOSSIL = registerFossilsTab("brown_terracotta_fossil", () -> BlockInit.BROWN_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> EXPOSED_BROWN_TERRACOTTA_FOSSIL = registerFossilsTab("exposed_brown_terracotta_fossil", () -> BlockInit.EXPOSED_BROWN_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> BLACK_TERRACOTTA_FOSSIL = registerFossilsTab("black_terracotta_fossil", () -> BlockInit.BLACK_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> EXPOSED_BLACK_TERRACOTTA_FOSSIL = registerFossilsTab("exposed_black_terracotta_fossil", () -> BlockInit.EXPOSED_BLACK_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> GREY_TERRACOTTA_FOSSIL = registerFossilsTab("grey_terracotta_fossil", () -> BlockInit.GREY_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> EXPOSED_GREY_TERRACOTTA_FOSSIL = registerFossilsTab("exposed_grey_terracotta_fossil", () -> BlockInit.EXPOSED_GREY_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> LIGHT_GREY_TERRACOTTA_FOSSIL = registerFossilsTab("light_grey_terracotta_fossil", () -> BlockInit.LIGHT_GREY_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> EXPOSED_LIGHT_GREY_TERRACOTTA_FOSSIL = registerFossilsTab("exposed_light_grey_terracotta_fossil", () -> BlockInit.EXPOSED_LIGHT_GREY_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> WHITE_TERRACOTTA_FOSSIL = registerFossilsTab("white_terracotta_fossil", () -> BlockInit.WHITE_TERRACOTTA_FOSSIL.get());
	public static final RegistryObject<Item> EXPOSED_WHITE_TERRACOTTA_FOSSIL = registerFossilsTab("exposed_white_terracotta_fossil", () -> BlockInit.EXPOSED_WHITE_TERRACOTTA_FOSSIL.get());
	
	public static final RegistryObject<Item> PLASTERED_FOSSIL = registerFossilsTab("plastered_fossil", () -> BlockInit.PLASTERED_FOSSIL.get());

	//Fossil Processing
	public static final RegistryObject<Item> FOSSIL_CLEANER = registerMachinesTab("fossil_cleaner", () -> BlockInit.FOSSIL_CLEANER.get());
	public static final RegistryObject<Item> FOSSIL_GRINDER = registerMachinesTab("fossil_grinder", () -> BlockInit.FOSSIL_GRINDER.get());
	public static final RegistryObject<Item> DNA_EXTRACTOR = registerMachinesTab("dna_extractor", () -> BlockInit.DNA_EXTRACTOR.get());
	public static final RegistryObject<Item> ANALYSER = registerMachinesTab("analyser", () -> BlockInit.ANALYSER.get());
	public static final RegistryObject<Item> DNA_INJECTOR = registerMachinesTab("dna_injector", () -> BlockInit.DNA_INJECTOR.get());
	
	public static final RegistryObject<Item> POWER_SUPPLY_BLOCK = registerMachinesTab("power_supply_block", () -> BlockInit.POWER_SUPPLY_BLOCK.get());

	//Mud
	public static final RegistryObject<Item> MUD = registerNatureTab("mud", () -> BlockInit.MUD.get());

	//Nesting Block
	public static final RegistryObject<Item> NESTING_BLOCK = registerNatureTab("nesting_block", () -> BlockInit.NESTING_BLOCK.get());

	//Time Machine
	public static final RegistryObject<Item> TIME_MACHINE = registerMachinesTab("time_machine", () -> BlockInit.TIME_MACHINE.get());
	
	//Museum Stuff
	public static final RegistryObject<Item> ARCHAEOLOGY_TABLE = registerMachinesTab("archaeology_table", () -> BlockInit.ARCHAEOLOGY_TABLE.get());
	//Volcanic Stuff
	public static final RegistryObject<Item> VOLCANIC_ROCK = registerDecorativesTab("volcanic_rock", () -> BlockInit.VOLCANIC_ROCK.get());	
	public static final RegistryObject<Item> VOLCANIC_ROCK_STAIRS = registerDecorativesTab("volcanic_rock_stairs", () -> BlockInit.VOLCANIC_ROCK_STAIRS.get());	
	public static final RegistryObject<Item> VOLCANIC_ROCK_SLAB = registerDecorativesTab("volcanic_rock_slab", () -> BlockInit.VOLCANIC_ROCK_SLAB.get());	
	public static final RegistryObject<Item> VOLCANIC_ROCK_WALL = registerDecorativesTab("volcanic_rock_wall", () -> BlockInit.VOLCANIC_ROCK_WALL.get());	
	
	public static final RegistryObject<Item> POLISHED_VOLCANIC_ROCK = registerDecorativesTab("polished_volcanic_rock", () -> BlockInit.POLISHED_VOLCANIC_ROCK.get());	
	public static final RegistryObject<Item> POLISHED_VOLCANIC_ROCK_STAIRS = registerDecorativesTab("polished_volcanic_rock_stairs", () -> BlockInit.POLISHED_VOLCANIC_ROCK_STAIRS.get());	
	public static final RegistryObject<Item> POLISHED_VOLCANIC_ROCK_SLAB = registerDecorativesTab("polished_volcanic_rock_slab", () -> BlockInit.POLISHED_VOLCANIC_ROCK_SLAB.get());	

	public static final RegistryObject<Item> VOLCANIC_ASH = registerDecorativesTab("volcanic_ash", () -> BlockInit.VOLCANIC_ASH.get());

	//Tunnel
	public static final RegistryObject<Item> DIICTODON_BURROW = registerNatureTab("diictodon_burrow", () -> BlockInit.DIICTODON_BURROW.get());
	public static final RegistryObject<Item> TUNNELED_SOIL = registerNatureTab("tunneled_soil", () -> BlockInit.TUNNELED_SOIL.get());

	//Mossy Dirt
	public static final RegistryObject<Item> MOSSY_DIRT = registerDecorativesTab("mossy_dirt", () -> BlockInit.MOSSY_DIRT.get());
	
	//Permian
	//Sand
	public static final RegistryObject<Item> PERMIAN_SAND = registerDecorativesTab("permian_sand", () -> BlockInit.PERMIAN_SAND.get());

	//Stone
	public static final RegistryObject<Item> PERMIAN_STONE = registerDecorativesTab("permian_stone", () -> BlockInit.PERMIAN_STONE.get());
	public static final RegistryObject<Item> PERMIAN_STONE_STAIRS = registerDecorativesTab("permian_stone_stairs", () -> BlockInit.PERMIAN_STONE_STAIRS.get());
	public static final RegistryObject<Item> PERMIAN_STONE_SLAB = registerDecorativesTab("permian_stone_slab", () -> BlockInit.PERMIAN_STONE_SLAB.get());

	public static final RegistryObject<Item> PERMIAN_COPPER_ORE = registerDecorativesTab("permian_copper_ore", () -> BlockInit.PERMIAN_COPPER_ORE.get());
	public static final RegistryObject<Item> PERMIAN_GOLD_ORE = registerDecorativesTab("permian_gold_ore", () -> BlockInit.PERMIAN_GOLD_ORE.get());
	public static final RegistryObject<Item> PERMIAN_IRON_ORE = registerDecorativesTab("permian_iron_ore", () -> BlockInit.PERMIAN_IRON_ORE.get());
	public static final RegistryObject<Item> PERMIAN_COAL_ORE = registerDecorativesTab("permian_coal_ore", () -> BlockInit.PERMIAN_COAL_ORE.get());
	public static final RegistryObject<Item> PERMIAN_LAPIS_ORE = registerDecorativesTab("permian_lapis_ore", () -> BlockInit.PERMIAN_LAPIS_ORE.get());
	public static final RegistryObject<Item> PERMIAN_DIAMOND_ORE = registerDecorativesTab("permian_diamond_ore", () -> BlockInit.PERMIAN_DIAMOND_ORE.get());
	public static final RegistryObject<Item> PERMIAN_REDSTONE_ORE = registerDecorativesTab("permian_redstone_ore", () -> BlockInit.PERMIAN_REDSTONE_ORE.get());
	public static final RegistryObject<Item> PERMIAN_EMERALD_ORE = registerDecorativesTab("permian_emerald_ore", () -> BlockInit.PERMIAN_EMERALD_ORE.get());

	public static final RegistryObject<Item> PERMIAN_COBBLESTONE = registerDecorativesTab("permian_cobblestone", () -> BlockInit.PERMIAN_COBBLESTONE.get());
	public static final RegistryObject<Item> PERMIAN_COBBLESTONE_STAIRS = registerDecorativesTab("permian_cobblestone_stairs", () -> BlockInit.PERMIAN_COBBLESTONE_STAIRS.get());
	public static final RegistryObject<Item> PERMIAN_COBBLESTONE_SLAB = registerDecorativesTab("permian_cobblestone_slab", () -> BlockInit.PERMIAN_COBBLESTONE_SLAB.get());
	public static final RegistryObject<Item> PERMIAN_COBBLESTONE_WALL = registerDecorativesTab("permian_cobblestone_wall", () -> BlockInit.PERMIAN_COBBLESTONE_WALL.get());

	public static final RegistryObject<Item> PERMIAN_STONE_BRICKS = registerDecorativesTab("permian_stone_bricks", () -> BlockInit.PERMIAN_STONE_BRICKS.get());
	public static final RegistryObject<Item> PERMIAN_STONE_BRICK_STAIRS = registerDecorativesTab("permian_stone_brick_stairs", () -> BlockInit.PERMIAN_STONE_BRICK_STAIRS.get());
	public static final RegistryObject<Item> PERMIAN_STONE_BRICK_SLAB = registerDecorativesTab("permian_stone_brick_slab", () -> BlockInit.PERMIAN_STONE_BRICK_SLAB.get());
	public static final RegistryObject<Item> PERMIAN_STONE_BRICK_WALL = registerDecorativesTab("permian_stone_brick_wall", () -> BlockInit.PERMIAN_STONE_BRICK_WALL.get());

	//Flora
	public static final RegistryObject<Item> SMALL_PERMIAN_DESERT_PLANT = registerNatureTab("small_permian_desert_plant", () -> BlockInit.SMALL_PERMIAN_DESERT_PLANT.get());
	public static final RegistryObject<Item> MEDIUM_PERMIAN_DESERT_PLANT = registerNatureTab("medium_permian_desert_plant", () -> BlockInit.MEDIUM_PERMIAN_DESERT_PLANT.get());
	public static final RegistryObject<Item> LARGE_PERMIAN_DESERT_PLANT = registerNatureTab("large_permian_desert_plant", () -> BlockInit.LARGE_PERMIAN_DESERT_PLANT.get());

	public static final RegistryObject<Item> GROUND_FERNS = registerNatureTab("ground_ferns", () -> BlockInit.GROUND_FERNS.get());
	public static final RegistryObject<Item> DICKSONIA = registerNatureTab("dicksonia", () -> BlockInit.DICKSONIA.get());
	public static final RegistryObject<Item> TALL_DICKSONIA = registerNatureTab("tall_dicksonia", () -> BlockInit.TALL_DICKSONIA.get());
	public static final RegistryObject<Item> CYCAD = registerNatureTab("cycad", () -> BlockInit.CYCAD.get());
	public static final RegistryObject<Item> OSMUNDA = registerNatureTab("osmunda", () -> BlockInit.OSMUNDA.get());
	public static final RegistryObject<Item> DUISBERGIA = registerNatureTab("duisbergia", () -> BlockInit.DUISBERGIA.get());
	public static final RegistryObject<Item> CEPHALOTAXUS = registerNatureTab("cephalotaxus", () -> BlockInit.CEPHALOTAXUS.get());
	public static final RegistryObject<Item> LYCOPHYTA = registerNatureTab("lycophyta", () -> BlockInit.LYCOPHYTA.get());
	public static final RegistryObject<Item> DILLHOFFIA = registerNatureTab("dillhoffia", () -> BlockInit.DILLHOFFIA.get());

	public static final RegistryObject<Item> DEAD_SPONGE_COLONY = registerNatureTab("dead_sponge_colony", () -> BlockInit.DEAD_SPONGE_COLONY.get());
	public static final RegistryObject<Item> SPONGE_COLONY = registerNatureTab("sponge_colony", () -> BlockInit.SPONGE_COLONY.get());
	
	//Jurassic
	//Stone
	public static final RegistryObject<Item> JURASSIC_STONE = registerDecorativesTab("jurassic_stone", () -> BlockInit.JURASSIC_STONE.get());
	public static final RegistryObject<Item> JURASSIC_STONE_STAIRS = registerDecorativesTab("jurassic_stone_stairs", () -> BlockInit.JURASSIC_STONE_STAIRS.get());
	public static final RegistryObject<Item> JURASSIC_STONE_SLAB = registerDecorativesTab("jurassic_stone_slab", () -> BlockInit.JURASSIC_STONE_SLAB.get());

	public static final RegistryObject<Item> JURASSIC_COPPER_ORE = registerDecorativesTab("jurassic_copper_ore", () -> BlockInit.JURASSIC_COPPER_ORE.get());
	public static final RegistryObject<Item> JURASSIC_GOLD_ORE = registerDecorativesTab("jurassic_gold_ore", () -> BlockInit.JURASSIC_GOLD_ORE.get());
	public static final RegistryObject<Item> JURASSIC_IRON_ORE = registerDecorativesTab("jurassic_iron_ore", () -> BlockInit.JURASSIC_IRON_ORE.get());
	public static final RegistryObject<Item> JURASSIC_COAL_ORE = registerDecorativesTab("jurassic_coal_ore", () -> BlockInit.JURASSIC_COAL_ORE.get());
	public static final RegistryObject<Item> JURASSIC_LAPIS_ORE = registerDecorativesTab("jurassic_lapis_ore", () -> BlockInit.JURASSIC_LAPIS_ORE.get());
	public static final RegistryObject<Item> JURASSIC_DIAMOND_ORE = registerDecorativesTab("jurassic_diamond_ore", () -> BlockInit.JURASSIC_DIAMOND_ORE.get());
	public static final RegistryObject<Item> JURASSIC_REDSTONE_ORE = registerDecorativesTab("jurassic_redstone_ore", () -> BlockInit.JURASSIC_REDSTONE_ORE.get());
	public static final RegistryObject<Item> JURASSIC_EMERALD_ORE = registerDecorativesTab("jurassic_emerald_ore", () -> BlockInit.JURASSIC_EMERALD_ORE.get());
	
	public static final RegistryObject<Item> MOSSY_JURASSIC_STONE = registerDecorativesTab("mossy_jurassic_stone", () -> BlockInit.MOSSY_JURASSIC_STONE.get());
	public static final RegistryObject<Item> MOSSY_JURASSIC_STONE_STAIRS = registerDecorativesTab("mossy_jurassic_stone_stairs", () -> BlockInit.MOSSY_JURASSIC_STONE_STAIRS.get());
	public static final RegistryObject<Item> MOSSY_JURASSIC_STONE_SLAB = registerDecorativesTab("mossy_jurassic_stone_slab", () -> BlockInit.MOSSY_JURASSIC_STONE_SLAB.get());
	
	public static final RegistryObject<Item> JURASSIC_COBBLESTONE = registerDecorativesTab("jurassic_cobblestone", () -> BlockInit.JURASSIC_COBBLESTONE.get());
	public static final RegistryObject<Item> JURASSIC_COBBLESTONE_STAIRS = registerDecorativesTab("jurassic_cobblestone_stairs", () -> BlockInit.JURASSIC_COBBLESTONE_STAIRS.get());
	public static final RegistryObject<Item> JURASSIC_COBBLESTONE_SLAB = registerDecorativesTab("jurassic_cobblestone_slab", () -> BlockInit.JURASSIC_COBBLESTONE_SLAB.get());
	public static final RegistryObject<Item> JURASSIC_COBBLESTONE_WALL = registerDecorativesTab("jurassic_cobblestone_wall", () -> BlockInit.JURASSIC_COBBLESTONE_WALL.get());
	
	public static final RegistryObject<Item> MOSSY_JURASSIC_COBBLESTONE = registerDecorativesTab("mossy_jurassic_cobblestone", () -> BlockInit.MOSSY_JURASSIC_COBBLESTONE.get());
	public static final RegistryObject<Item> MOSSY_JURASSIC_COBBLESTONE_STAIRS = registerDecorativesTab("mossy_jurassic_cobblestone_stairs", () -> BlockInit.MOSSY_JURASSIC_COBBLESTONE_STAIRS.get());
	public static final RegistryObject<Item> MOSSY_JURASSIC_COBBLESTONE_SLAB = registerDecorativesTab("mossy_jurassic_cobblestone_slab", () -> BlockInit.MOSSY_JURASSIC_COBBLESTONE_SLAB.get());
	public static final RegistryObject<Item> MOSSY_JURASSIC_COBBLESTONE_WALL = registerDecorativesTab("mossy_jurassic_cobblestone_wall", () -> BlockInit.MOSSY_JURASSIC_COBBLESTONE_WALL.get());
	
	public static final RegistryObject<Item> JURASSIC_STONE_BRICKS = registerDecorativesTab("jurassic_stone_bricks", () -> BlockInit.JURASSIC_STONE_BRICKS.get());
	public static final RegistryObject<Item> JURASSIC_STONE_BRICK_STAIRS = registerDecorativesTab("jurassic_stone_brick_stairs", () -> BlockInit.JURASSIC_STONE_BRICK_STAIRS.get());
	public static final RegistryObject<Item> JURASSIC_STONE_BRICK_SLAB = registerDecorativesTab("jurassic_stone_brick_slab", () -> BlockInit.JURASSIC_STONE_BRICK_SLAB.get());
	public static final RegistryObject<Item> JURASSIC_STONE_BRICK_WALL = registerDecorativesTab("jurassic_stone_brick_wall", () -> BlockInit.JURASSIC_STONE_BRICK_WALL.get());
	
	public static final RegistryObject<Item> MOSSY_JURASSIC_STONE_BRICKS = registerDecorativesTab("mossy_jurassic_stone_bricks", () -> BlockInit.MOSSY_JURASSIC_STONE_BRICKS.get());
	public static final RegistryObject<Item> MOSSY_JURASSIC_STONE_BRICK_STAIRS = registerDecorativesTab("mossy_jurassic_stone_brick_stairs", () -> BlockInit.MOSSY_JURASSIC_STONE_BRICK_STAIRS.get());
	public static final RegistryObject<Item> MOSSY_JURASSIC_STONE_BRICK_SLAB = registerDecorativesTab("mossy_jurassic_stone_brick_slab", () -> BlockInit.MOSSY_JURASSIC_STONE_BRICK_SLAB.get());
	public static final RegistryObject<Item> MOSSY_JURASSIC_STONE_BRICK_WALL = registerDecorativesTab("mossy_jurassic_stone_brick_wall", () -> BlockInit.MOSSY_JURASSIC_STONE_BRICK_WALL.get());
	
	//Conifer
	public static final RegistryObject<Item> CONIFER_LOG = registerBurningBlock("conifer_log", () -> BlockInit.CONIFER_LOG.get());
	public static final RegistryObject<Item> CONIFER_WOOD = registerBurningBlock("conifer_wood", () -> BlockInit.CONIFER_WOOD.get());
	public static final RegistryObject<Item> STRIPPED_CONIFER_LOG = registerBurningBlock("stripped_conifer_log", () -> BlockInit.STRIPPED_CONIFER_LOG.get());
	public static final RegistryObject<Item> STRIPPED_CONIFER_WOOD = registerBurningBlock("stripped_conifer_wood", () -> BlockInit.STRIPPED_CONIFER_WOOD.get());
	public static final RegistryObject<Item> CONIFER_LEAVES = registerDecorativesTab("conifer_leaves", () -> BlockInit.CONIFER_LEAVES.get());
	public static final RegistryObject<Item> CONIFER_SAPLING = registerBurningBlock("conifer_sapling", () -> BlockInit.CONIFER_SAPLING.get());
	public static final RegistryObject<Item> CONIFER_PLANKS = registerBurningBlock("conifer_planks", () -> BlockInit.CONIFER_PLANKS.get());
	public static final RegistryObject<Item> CONIFER_STAIRS = registerBurningBlock("conifer_stairs", () -> BlockInit.CONIFER_STAIRS.get());
	public static final RegistryObject<Item> CONIFER_SLAB = registerBurningSlab("conifer_slab", () -> BlockInit.CONIFER_SLAB.get());
	public static final RegistryObject<Item> CONIFER_FENCE = registerBurningBlock("conifer_fence", () -> BlockInit.CONIFER_FENCE.get());
	public static final RegistryObject<Item> CONIFER_FENCE_GATE = registerBurningBlock("conifer_fence_gate", () -> BlockInit.CONIFER_FENCE_GATE.get());
	public static final RegistryObject<Item> CONIFER_PRESSURE_PLATE = registerBurningBlock("conifer_pressure_plate", () -> BlockInit.CONIFER_PRESSURE_PLATE.get());
	public static final RegistryObject<Item> CONIFER_BUTTON = registerBurningBlock("conifer_button", () -> BlockInit.CONIFER_BUTTON.get());
	public static final RegistryObject<Item> CONIFER_TRAPDOOR = registerBurningBlock("conifer_trapdoor", () -> BlockInit.CONIFER_TRAPDOOR.get()); 
	public static final RegistryObject<Item> CONIFER_DOOR = registerDecorativesTab("conifer_door", () -> BlockInit.CONIFER_DOOR.get());
	public static final RegistryObject<ModSignItem> CONIFER_SIGN = ModRegistry.ITEM_REGISTRY.register("conifer_sign", () -> new ModSignItem(BlockInit.CONIFER_SIGN.get(), BlockInit.CONIFER_WALL_SIGN.get(), properties().tab(ItemGroupInit.DECORATIVES_TAB)));
	public static final RegistryObject<Item> CONIFER_BOAT = register("conifer_boat", ModBoatType.CONIFER);

	//Ginkgo
	public static final RegistryObject<Item> GINKGO_LOG = registerBurningBlock("ginkgo_log", () -> BlockInit.GINKGO_LOG.get());
	public static final RegistryObject<Item> GINKGO_WOOD = registerBurningBlock("ginkgo_wood", () -> BlockInit.GINKGO_WOOD.get());
	public static final RegistryObject<Item> STRIPPED_GINKGO_LOG = registerBurningBlock("stripped_ginkgo_log", () -> BlockInit.STRIPPED_GINKGO_LOG.get());
	public static final RegistryObject<Item> STRIPPED_GINKGO_WOOD = registerBurningBlock("stripped_ginkgo_wood", () -> BlockInit.STRIPPED_GINKGO_WOOD.get());
	public static final RegistryObject<Item> GINKGO_LEAVES = registerDecorativesTab("ginkgo_leaves", () -> BlockInit.GINKGO_LEAVES.get());
	public static final RegistryObject<Item> GINKGO_SAPLING = registerBurningBlock("ginkgo_sapling", () -> BlockInit.GINKGO_SAPLING.get());
	public static final RegistryObject<Item> GINKGO_PLANKS = registerBurningBlock("ginkgo_planks", () -> BlockInit.GINKGO_PLANKS.get());
	public static final RegistryObject<Item> GINKGO_STAIRS = registerBurningBlock("ginkgo_stairs", () -> BlockInit.GINKGO_STAIRS.get());
	public static final RegistryObject<Item> GINKGO_SLAB = registerBurningSlab("ginkgo_slab", () -> BlockInit.GINKGO_SLAB.get());
	public static final RegistryObject<Item> GINKGO_FENCE = registerBurningBlock("ginkgo_fence", () -> BlockInit.GINKGO_FENCE.get());
	public static final RegistryObject<Item> GINKGO_FENCE_GATE = registerBurningBlock("ginkgo_fence_gate", () -> BlockInit.GINKGO_FENCE_GATE.get());
	public static final RegistryObject<Item> GINKGO_PRESSURE_PLATE = registerBurningBlock("ginkgo_pressure_plate", () -> BlockInit.GINKGO_PRESSURE_PLATE.get());
	public static final RegistryObject<Item> GINKGO_BUTTON = registerBurningBlock("ginkgo_button", () -> BlockInit.GINKGO_BUTTON.get());
	public static final RegistryObject<Item> GINKGO_TRAPDOOR = registerBurningBlock("ginkgo_trapdoor", () -> BlockInit.GINKGO_TRAPDOOR.get()); 
	public static final RegistryObject<Item> GINKGO_DOOR = registerBurningBlock("ginkgo_door", () -> BlockInit.GINKGO_DOOR.get());
	public static final RegistryObject<ModSignItem> GINKGO_SIGN = ModRegistry.ITEM_REGISTRY.register("ginkgo_sign", () -> new ModSignItem(BlockInit.GINKGO_SIGN.get(), BlockInit.GINKGO_WALL_SIGN.get(), properties().tab(ItemGroupInit.DECORATIVES_TAB)));
	public static final RegistryObject<Item> GINKGO_BOAT = register("ginkgo_boat", ModBoatType.GINKGO);

	//Araucaria
	public static final RegistryObject<Item> ARAUCARIA_LOG = registerBurningBlock("araucaria_log", () -> BlockInit.ARAUCARIA_LOG.get());
	public static final RegistryObject<Item> ARAUCARIA_WOOD = registerBurningBlock("araucaria_wood", () -> BlockInit.ARAUCARIA_WOOD.get());
	public static final RegistryObject<Item> STRIPPED_ARAUCARIA_LOG = registerBurningBlock("stripped_araucaria_log", () -> BlockInit.STRIPPED_ARAUCARIA_LOG.get());
	public static final RegistryObject<Item> STRIPPED_ARAUCARIA_WOOD = registerBurningBlock("stripped_araucaria_wood", () -> BlockInit.STRIPPED_ARAUCARIA_WOOD.get());
	public static final RegistryObject<Item> ARAUCARIA_LEAVES = registerDecorativesTab("araucaria_leaves", () -> BlockInit.ARAUCARIA_LEAVES.get());
	public static final RegistryObject<Item> ARAUCARIA_SAPLING = registerBurningBlock("araucaria_sapling", () -> BlockInit.ARAUCARIA_SAPLING.get());
	public static final RegistryObject<Item> ARAUCARIA_PLANKS = registerBurningBlock("araucaria_planks", () -> BlockInit.ARAUCARIA_PLANKS.get());
	public static final RegistryObject<Item> ARAUCARIA_STAIRS = registerBurningBlock("araucaria_stairs", () -> BlockInit.ARAUCARIA_STAIRS.get());
	public static final RegistryObject<Item> ARAUCARIA_SLAB = registerBurningBlock("araucaria_slab", () -> BlockInit.ARAUCARIA_SLAB.get());
	public static final RegistryObject<Item> ARAUCARIA_FENCE = registerBurningBlock("araucaria_fence", () -> BlockInit.ARAUCARIA_FENCE.get());
	public static final RegistryObject<Item> ARAUCARIA_FENCE_GATE = registerBurningBlock("araucaria_fence_gate", () -> BlockInit.ARAUCARIA_FENCE_GATE.get());
	public static final RegistryObject<Item> ARAUCARIA_PRESSURE_PLATE = registerBurningBlock("araucaria_pressure_plate", () -> BlockInit.ARAUCARIA_PRESSURE_PLATE.get());
	public static final RegistryObject<Item> ARAUCARIA_BUTTON = registerBurningBlock("araucaria_button", () -> BlockInit.ARAUCARIA_BUTTON.get());
	public static final RegistryObject<Item> ARAUCARIA_TRAPDOOR = registerBurningBlock("araucaria_trapdoor", () -> BlockInit.ARAUCARIA_TRAPDOOR.get());
	public static final RegistryObject<Item> ARAUCARIA_DOOR = registerBurningBlock("araucaria_door", () -> BlockInit.ARAUCARIA_DOOR.get());
	public static final RegistryObject<ModSignItem> ARAUCARIA_SIGN = ModRegistry.ITEM_REGISTRY.register("araucaria_sign", () -> new ModSignItem(BlockInit.ARAUCARIA_SIGN.get(), BlockInit.ARAUCARIA_WALL_SIGN.get(), properties().tab(ItemGroupInit.DECORATIVES_TAB)));
	public static final RegistryObject<Item> ARAUCARIA_BOAT = register("araucaria_boat", ModBoatType.ARAUCARIA);
	
	//Light Concrete
	public static final RegistryObject<Item> LIGHT_CONCRETE =  registerDecorativesTab("light_concrete", () -> BlockInit.LIGHT_CONCRETE.get());
	public static final RegistryObject<Item> LIGHT_CONCRETE_STAIRS =  registerDecorativesTab("light_concrete_stairs", () -> BlockInit.LIGHT_CONCRETE_STAIRS.get());
	public static final RegistryObject<Item> LIGHT_CONCRETE_SLAB =  registerDecorativesTab("light_concrete_slab", () -> BlockInit.LIGHT_CONCRETE_SLAB.get());
	public static final RegistryObject<Item> LIGHT_CONCRETE_WALL =  registerDecorativesTab("light_concrete_wall", () -> BlockInit.LIGHT_CONCRETE_WALL.get());
	public static final RegistryObject<Item> LIGHT_CONCRETE_PRESSURE_PLATE = registerDecorativesTab("light_concrete_pressure_plate", () -> BlockInit.LIGHT_CONCRETE_PRESSURE_PLATE.get());
	public static final RegistryObject<Item> LIGHT_CONCRETE_BUTTON =  registerDecorativesTab("light_concrete_button", () -> BlockInit.LIGHT_CONCRETE_BUTTON.get());
	
	//Polished Light Concrete
	public static final RegistryObject<Item> POLISHED_LIGHT_CONCRETE =  registerDecorativesTab("polished_light_concrete", () -> BlockInit.POLISHED_LIGHT_CONCRETE.get());
	public static final RegistryObject<Item> POLISHED_LIGHT_CONCRETE_STAIRS =  registerDecorativesTab("polished_light_concrete_stairs", () -> BlockInit.POLISHED_LIGHT_CONCRETE_STAIRS.get());
	public static final RegistryObject<Item> POLISHED_LIGHT_CONCRETE_SLAB =  registerDecorativesTab("polished_light_concrete_slab", () -> BlockInit.POLISHED_LIGHT_CONCRETE_SLAB.get());
	
	//Dark Concrete
	public static final RegistryObject<Item> DARK_CONCRETE =  registerDecorativesTab("dark_concrete", () -> BlockInit.DARK_CONCRETE.get());
	public static final RegistryObject<Item> DARK_CONCRETE_STAIRS =  registerDecorativesTab("dark_concrete_stairs", () -> BlockInit.DARK_CONCRETE_STAIRS.get());
	public static final RegistryObject<Item> DARK_CONCRETE_SLAB =  registerDecorativesTab("dark_concrete_slab", () -> BlockInit.DARK_CONCRETE_SLAB.get());
	public static final RegistryObject<Item> DARK_CONCRETE_WALL =  registerDecorativesTab("dark_concrete_wall", () -> BlockInit.DARK_CONCRETE_WALL.get());
	public static final RegistryObject<Item> DARK_CONCRETE_PRESSURE_PLATE = registerDecorativesTab("dark_concrete_pressure_plate", () -> BlockInit.DARK_CONCRETE_PRESSURE_PLATE.get());
	public static final RegistryObject<Item> DARK_CONCRETE_BUTTON =  registerDecorativesTab("dark_concrete_button", () -> BlockInit.DARK_CONCRETE_BUTTON.get());
	
	//Polished Dark Concrete
	public static final RegistryObject<Item> POLISHED_DARK_CONCRETE =  registerDecorativesTab("polished_dark_concrete", () -> BlockInit.POLISHED_DARK_CONCRETE.get());
	public static final RegistryObject<Item> POLISHED_DARK_CONCRETE_STAIRS =  registerDecorativesTab("polished_dark_concrete_stairs", () -> BlockInit.POLISHED_DARK_CONCRETE_STAIRS.get());
	public static final RegistryObject<Item> POLISHED_DARK_CONCRETE_SLAB =  registerDecorativesTab("polished_dark_concrete_slab", () -> BlockInit.POLISHED_DARK_CONCRETE_SLAB.get());

	//Wooden Planks
	public static final RegistryObject<Item> WOODEN_PLANKS =  registerDecorativesTab("wooden_planks", () -> BlockInit.WOODEN_PLANKS.get());
	public static final RegistryObject<Item> WOODEN_PLANKS_STAIRS =  registerDecorativesTab("wooden_planks_stairs", () -> BlockInit.WOODEN_PLANKS_STAIRS.get());
	public static final RegistryObject<Item> WOODEN_PLANKS_SLAB =  registerDecorativesTab("wooden_planks_slab", () -> BlockInit.WOODEN_PLANKS_SLAB.get());
	public static final RegistryObject<Item> WOODEN_PLANKS_FENCE =  registerDecorativesTab("wooden_planks_fence", () -> BlockInit.WOODEN_PLANKS_FENCE.get());
	public static final RegistryObject<Item> WOODEN_PLANKS_FENCE_GATE =  registerDecorativesTab("wooden_planks_fence_gate", () -> BlockInit.WOODEN_PLANKS_FENCE_GATE.get());
	public static final RegistryObject<Item> WOODEN_PLANKS_PRESSURE_PLATE = registerDecorativesTab("wooden_planks_pressure_plate", () -> BlockInit.WOODEN_PLANKS_PRESSURE_PLATE.get());
	public static final RegistryObject<Item> WOODEN_PLANKS_BUTTON =  registerDecorativesTab("wooden_planks_button", () -> BlockInit.WOODEN_PLANKS_BUTTON.get());
		
	//Wooden Planks
	public static final RegistryObject<Item> REFINED_WOODEN_PLANKS =  registerDecorativesTab("refined_wooden_planks", () -> BlockInit.REFINED_WOODEN_PLANKS.get());
	public static final RegistryObject<Item> REFINED_WOODEN_PLANKS_STAIRS =  registerDecorativesTab("refined_wooden_planks_stairs", () -> BlockInit.REFINED_WOODEN_PLANKS_STAIRS.get());
	public static final RegistryObject<Item> REFINED_WOODEN_PLANKS_SLAB =  registerDecorativesTab("refined_wooden_planks_slab", () -> BlockInit.REFINED_WOODEN_PLANKS_SLAB.get());
	public static final RegistryObject<Item> REFINED_WOODEN_PLANKS_FENCE =  registerDecorativesTab("refined_wooden_planks_fence", () -> BlockInit.REFINED_WOODEN_PLANKS_FENCE.get());
	public static final RegistryObject<Item> REFINED_WOODEN_PLANKS_FENCE_GATE =  registerDecorativesTab("refined_wooden_planks_fence_gate", () -> BlockInit.REFINED_WOODEN_PLANKS_FENCE_GATE.get());
	public static final RegistryObject<Item> REFINED_WOODEN_PLANKS_PRESSURE_PLATE = registerDecorativesTab("refined_wooden_planks_pressure_plate", () -> BlockInit.REFINED_WOODEN_PLANKS_PRESSURE_PLATE.get());
	public static final RegistryObject<Item> REFINED_WOODEN_PLANKS_BUTTON =  registerDecorativesTab("refined_wooden_planks_button", () -> BlockInit.REFINED_WOODEN_PLANKS_BUTTON.get());
	
	//Pavement
	public static final RegistryObject<Item> PAVEMENT =  registerDecorativesTab("pavement", () -> BlockInit.PAVEMENT.get());
	public static final RegistryObject<Item> PAVEMENT_SLOPE =  registerDecorativesTab("pavement_slope", () -> BlockInit.PAVEMENT_SLOPE.get());
	public static final RegistryObject<Item> RAISED_PAVEMENT =  registerDecorativesTab("raised_pavement", () -> BlockInit.RAISED_PAVEMENT.get());
	
	//Roads
	public static final RegistryObject<Item> GRAVEL_ROAD = registerDecorativesTab("gravel_road", () -> BlockInit.GRAVEL_ROAD.get());
	public static final RegistryObject<Item> RAISED_GRAVEL_ROAD = registerDecorativesTab("raised_gravel_road", () -> BlockInit.RAISED_GRAVEL_ROAD.get());
		
	public static final RegistryObject<Item> DIRT_ROAD = registerDecorativesTab("dirt_road", () -> BlockInit.DIRT_ROAD.get());
	public static final RegistryObject<Item> RAISED_DIRT_ROAD = registerDecorativesTab("raised_dirt_road", () -> BlockInit.RAISED_DIRT_ROAD.get());
		
	public static final RegistryObject<Item> PAVED_ROAD = registerDecorativesTab("paved_road", () -> BlockInit.PAVED_ROAD.get());
	public static final RegistryObject<Item> RAISED_PAVED_ROAD = registerDecorativesTab("raised_paved_road", () -> BlockInit.RAISED_PAVED_ROAD.get());
		
	//Tile
	public static final RegistryObject<Item> TILE =  registerDecorativesTab("tile", () -> BlockInit.TILE.get());
	public static final RegistryObject<Item> TILE_STAIRS =  registerDecorativesTab("tile_stairs", () -> BlockInit.TILE_STAIRS.get());
	public static final RegistryObject<Item> TILE_SLAB =  registerDecorativesTab("tile_slab", () -> BlockInit.TILE_SLAB.get());

	//Metal Fence
	public static final RegistryObject<Item> METAL_FENCE = registerDecorativesTab("metal_fence", () -> BlockInit.METAL_FENCE.get());

	//Clear Glass
	public static final RegistryObject<Item> CLEAR_GLASS = registerDecorativesTab("clear_glass", () -> BlockInit.CLEAR_GLASS.get());
	public static final RegistryObject<Item> CLEAR_GLASS_PANE = registerDecorativesTab("clear_glass_pane", () -> BlockInit.CLEAR_GLASS_PANE.get());

	//Tinted Glass
	public static final RegistryObject<Item> TINTED_GLASS = registerDecorativesTab("tinted_glass", () -> BlockInit.TINTED_GLASS.get());
	public static final RegistryObject<Item> TINTED_GLASS_PANE = registerDecorativesTab("tinted_glass_pane", () -> BlockInit.TINTED_GLASS_PANE.get());
	
	//Coloured Glass
	public static final RegistryObject<Item> WHITE_GLASS = registerDecorativesTab("white_glass", () -> BlockInit.WHITE_GLASS.get());
	public static final RegistryObject<Item> WHITE_GLASS_PANE = registerDecorativesTab("white_glass_pane", () -> BlockInit.WHITE_GLASS_PANE.get());	
		
	public static final RegistryObject<Item> LIGHT_GREY_GLASS = registerDecorativesTab("light_grey_glass", () -> BlockInit.LIGHT_GREY_GLASS.get());
	public static final RegistryObject<Item> LIGHT_GREY_GLASS_PANE = registerDecorativesTab("light_grey_glass_pane", () -> BlockInit.LIGHT_GREY_GLASS_PANE.get());	
		
	public static final RegistryObject<Item> GREY_GLASS = registerDecorativesTab("grey_glass", () -> BlockInit.GREY_GLASS.get());
	public static final RegistryObject<Item> GREY_GLASS_PANE = registerDecorativesTab("grey_glass_pane", () -> BlockInit.GREY_GLASS_PANE.get());	
		
	public static final RegistryObject<Item> BLACK_GLASS = registerDecorativesTab("black_glass", () -> BlockInit.BLACK_GLASS.get());
	public static final RegistryObject<Item> BLACK_GLASS_PANE = registerDecorativesTab("black_glass_pane", () -> BlockInit.BLACK_GLASS_PANE.get());	
		
	public static final RegistryObject<Item> RED_GLASS = registerDecorativesTab("red_glass", () -> BlockInit.RED_GLASS.get());
	public static final RegistryObject<Item> RED_GLASS_PANE = registerDecorativesTab("red_glass_pane", () -> BlockInit.RED_GLASS_PANE.get());	
		
	public static final RegistryObject<Item> ORANGE_GLASS = registerDecorativesTab("orange_glass", () -> BlockInit.ORANGE_GLASS.get());
	public static final RegistryObject<Item> ORANGE_GLASS_PANE = registerDecorativesTab("orange_glass_pane", () -> BlockInit.ORANGE_GLASS_PANE.get());	
	
	public static final RegistryObject<Item> YELLOW_GLASS = registerDecorativesTab("yellow_glass", () -> BlockInit.YELLOW_GLASS.get());
	public static final RegistryObject<Item> YELLOW_GLASS_PANE = registerDecorativesTab("yellow_glass_pane", () -> BlockInit.YELLOW_GLASS_PANE.get());	
	
	public static final RegistryObject<Item> LIME_GLASS = registerDecorativesTab("lime_glass", () -> BlockInit.LIME_GLASS.get());
	public static final RegistryObject<Item> LIME_GLASS_PANE = registerDecorativesTab("lime_glass_pane", () -> BlockInit.LIME_GLASS_PANE.get());	
		
	public static final RegistryObject<Item> GREEN_GLASS = registerDecorativesTab("green_glass", () -> BlockInit.GREEN_GLASS.get());
	public static final RegistryObject<Item> GREEN_GLASS_PANE = registerDecorativesTab("green_glass_pane", () -> BlockInit.GREEN_GLASS_PANE.get());	
		
	public static final RegistryObject<Item> CYAN_GLASS = registerDecorativesTab("cyan_glass", () -> BlockInit.CYAN_GLASS.get());
	public static final RegistryObject<Item> CYAN_GLASS_PANE = registerDecorativesTab("cyan_glass_pane", () -> BlockInit.CYAN_GLASS_PANE.get());	
		
	public static final RegistryObject<Item> LIGHT_BLUE_GLASS = registerDecorativesTab("light_blue_glass", () -> BlockInit.LIGHT_BLUE_GLASS.get());
	public static final RegistryObject<Item> LIGHT_BLUE_GLASS_PANE = registerDecorativesTab("light_blue_glass_pane", () -> BlockInit.LIGHT_BLUE_GLASS_PANE.get());	
		
	public static final RegistryObject<Item> BLUE_GLASS = registerDecorativesTab("blue_glass", () -> BlockInit.BLUE_GLASS.get());
	public static final RegistryObject<Item> BLUE_GLASS_PANE = registerDecorativesTab("blue_glass_pane", () -> BlockInit.BLUE_GLASS_PANE.get());	
		
	public static final RegistryObject<Item> PURPLE_GLASS = registerDecorativesTab("purple_glass", () -> BlockInit.PURPLE_GLASS.get());
	public static final RegistryObject<Item> PURPLE_GLASS_PANE = registerDecorativesTab("purple_glass_pane", () -> BlockInit.PURPLE_GLASS_PANE.get());	
		
	public static final RegistryObject<Item> MAGENTA_GLASS = registerDecorativesTab("magenta_glass", () -> BlockInit.MAGENTA_GLASS.get());
	public static final RegistryObject<Item> MAGENTA_GLASS_PANE = registerDecorativesTab("magenta_glass_pane", () -> BlockInit.MAGENTA_GLASS_PANE.get());	
		
	public static final RegistryObject<Item> PINK_GLASS = registerDecorativesTab("pink_glass", () -> BlockInit.PINK_GLASS.get());
	public static final RegistryObject<Item> PINK_GLASS_PANE = registerDecorativesTab("pink_glass_pane", () -> BlockInit.PINK_GLASS_PANE.get());	
		
	public static final RegistryObject<Item> BROWN_GLASS = registerDecorativesTab("brown_glass", () -> BlockInit.BROWN_GLASS.get());
	public static final RegistryObject<Item> BROWN_GLASS_PANE = registerDecorativesTab("brown_glass_pane", () -> BlockInit.BROWN_GLASS_PANE.get());	

	public static final RegistryObject<Item> SHADED_GLASS = registerDecorativesTab("shaded_glass", () -> BlockInit.SHADED_GLASS.get());
	public static final RegistryObject<Item> SHADED_GLASS_PANE = registerDecorativesTab("shaded_glass_pane", () -> BlockInit.SHADED_GLASS_PANE.get());	
	
	//Coloured Blocks
	public static final RegistryObject<Item> RED_DECORATION_BLOCK = registerDecorativesTab("red_decoration_block", () -> BlockInit.RED_DECORATION_BLOCK.get());
	public static final RegistryObject<Item> ORANGE_DECORATION_BLOCK = registerDecorativesTab("orange_decoration_block", () -> BlockInit.ORANGE_DECORATION_BLOCK.get());	
	public static final RegistryObject<Item> YELLOW_DECORATION_BLOCK = registerDecorativesTab("yellow_decoration_block", () -> BlockInit.YELLOW_DECORATION_BLOCK.get());
	public static final RegistryObject<Item> LIME_DECORATION_BLOCK = registerDecorativesTab("lime_decoration_block", () -> BlockInit.LIME_DECORATION_BLOCK.get());
	public static final RegistryObject<Item> GREEN_DECORATION_BLOCK = registerDecorativesTab("green_decoration_block", () -> BlockInit.GREEN_DECORATION_BLOCK.get());
	public static final RegistryObject<Item> CYAN_DECORATION_BLOCK = registerDecorativesTab("cyan_decoration_block", () -> BlockInit.CYAN_DECORATION_BLOCK.get());	
	public static final RegistryObject<Item> BLUE_DECORATION_BLOCK = registerDecorativesTab("blue_decoration_block", () -> BlockInit.BLUE_DECORATION_BLOCK.get());	
	public static final RegistryObject<Item> LIGHT_BLUE_DECORATION_BLOCK = registerDecorativesTab("light_blue_decoration_block", () -> BlockInit.LIGHT_BLUE_DECORATION_BLOCK.get());	
	public static final RegistryObject<Item> PURPLE_DECORATION_BLOCK = registerDecorativesTab("purple_decoration_block", () -> BlockInit.PURPLE_DECORATION_BLOCK.get());	
	public static final RegistryObject<Item> MAGENTA_DECORATION_BLOCK = registerDecorativesTab("magenta_decoration_block", () -> BlockInit.MAGENTA_DECORATION_BLOCK.get());	
	public static final RegistryObject<Item> PINK_DECORATION_BLOCK = registerDecorativesTab("pink_decoration_block", () -> BlockInit.PINK_DECORATION_BLOCK.get());	
	public static final RegistryObject<Item> BROWN_DECORATION_BLOCK = registerDecorativesTab("brown_decoration_block", () -> BlockInit.BROWN_DECORATION_BLOCK.get());	
	public static final RegistryObject<Item> GREY_DECORATION_BLOCK = registerDecorativesTab("grey_decoration_block", () -> BlockInit.GREY_DECORATION_BLOCK.get());	
	public static final RegistryObject<Item> LIGHT_GREY_DECORATION_BLOCK = registerDecorativesTab("light_grey_decoration_block", () -> BlockInit.LIGHT_GREY_DECORATION_BLOCK.get());	
	public static final RegistryObject<Item> WHITE_DECORATION_BLOCK = registerDecorativesTab("white_decoration_block", () -> BlockInit.WHITE_DECORATION_BLOCK.get());	
	public static final RegistryObject<Item> BLACK_DECORATION_BLOCK = registerDecorativesTab("black_decoration_block", () -> BlockInit.BLACK_DECORATION_BLOCK.get());
	
	//Thatch
	public static final RegistryObject<Item> THATCH_BLOCK =  registerDecorativesTab("thatch_block", () -> BlockInit.THATCH_BLOCK.get());
	
	//Doors
	public static final RegistryObject<Item> OUTDOOR_TOILET_DOOR = registerDecorativesTab("outdoor_toilet_door", () -> BlockInit.OUTDOOR_TOILET_DOOR.get());
	public static final RegistryObject<Item> GLASS_SHOP_DOOR = registerDecorativesTab("glass_shop_door", () -> BlockInit.GLASS_SHOP_DOOR.get());
	public static final RegistryObject<Item> VISITOR_CENTRE_DOOR = registerDecorativesTab("visitor_centre_door", () -> BlockInit.VISITOR_CENTRE_DOOR.get());
	public static final RegistryObject<Item> INNOVATION_CENTRE_DOOR = registerDecorativesTab("innovation_centre_door", () -> BlockInit.INNOVATION_CENTRE_DOOR.get());
	public static final RegistryObject<Item> SECURITY_DOOR = registerDecorativesTab("security_door", () -> BlockInit.SECURITY_DOOR.get());
	public static final RegistryObject<Item> BACK_DOOR = registerDecorativesTab("back_door", () -> BlockInit.BACK_DOOR.get());
	
	//Registry
	public static Properties properties()
	{
		return new Item.Properties();
	}
	
	private static RegistryObject<Item> register(String id, Item item)
	{
		return ModRegistry.ITEM_REGISTRY.register(id, () -> item);
	}
	
	private static RegistryObject<Item> register(String id, ModItemTeir teir)
	{
		return ModRegistry.ITEM_REGISTRY.register(id, () -> new BrushItem(teir, 1.0F, -2.4F, properties().tab(ItemGroupInit.TOOLS_TAB)));
	}
	
	private static RegistryObject<Item> register(String id, ItemGroup group)
	{
		return register(id, new Item(properties().tab(group)));
	}
	
	private static RegistryObject<Item> register(String id, ModBoatEntity.ModBoatType type)
	{
		return register(id, new ModBoatItem(type, properties().tab(ItemGroupInit.DECORATIVES_TAB)));
	}
	
	private static RegistryObject<Item> register(String id, Properties properties)
	{
		return register(id, new Item(properties));
	}
	
	private static RegistryObject<Item> register(String id, Food food, ItemGroup group)
	{
		return register(id, new Item(properties().tab(group).food(food)));
	}
	
	private static RegistryObject<Item> register(String id)
	{
		return register(id, new FoodSeedsItem(properties().tab(ItemGroupInit.FOOD_TAB).food(FoodInit.SEED).stacksTo(1)));
	}
	
	private static RegistryObject<Item> registerDNA(String id)
	{
		return register(id + "_dna", ItemGroupInit.CREATURES_TAB);
	}
	
	private static RegistryObject<Item> registerSoftTissue(String id)
	{
		return register(id + "_soft_tissue", ItemGroupInit.CREATURES_TAB);
	}
	
	private static RegistryObject<Item> registerVile(String id)
	{
		return register("vile_of_" + id + "_blood", ItemGroupInit.CREATURES_TAB);
	}
	
	private static RegistryObject<Item> registerDNADisc(String id)
	{
		return register(id + "_dna_disc", new DiscItem(id + "_dna_disc", new Item.Properties().tab(ItemGroupInit.CREATURES_TAB).stacksTo(1).durability(5).setNoRepair()));
	}
	
	private static RegistryObject<Item> registerRawMeat(String id, Food food)
	{
		return register("raw_" + id + "_meat", food, ItemGroupInit.FOOD_TAB);
	}
	
	private static RegistryObject<Item> registerCookedMeat(String id, Food food)
	{
		return register("cooked_" + id + "_meat", food, ItemGroupInit.FOOD_TAB);
	}
	
	private static RegistryObject<Item> registerRawFishMeat(String id, Food food)
	{
		return register(id, food, ItemGroupInit.FOOD_TAB);
	}
	
	private static RegistryObject<Item> registerCookedFishMeat(String id, Food food)
	{
		return register("cooked_" + id, food, ItemGroupInit.FOOD_TAB);
	}
	
	private static RegistryObject<Item> register(String id, NonNullSupplier<? extends EntityType<?>> entity, int primaryColour, int secondaryColour)
	{
		return register(id + "_spawn_egg", new ModSpawnEggItem(entity, primaryColour, secondaryColour));
	}
	
	private static RegistryObject<Item> registerSpawn(String id)
	{
		return register(id + "_spawn", ItemGroupInit.CREATURES_TAB);
	}
	
	private static RegistryObject<Item> registerFishBucket(String id, NonNullSupplier<? extends EntityType<?>> entity)
	{
		return register(id + "_bucket", new ModFishBucketItem(entity, Fluids.WATER));
	}
	
	private static RegistryObject<Item> registerSkull(String id)
	{
		return register(id + "_skull", ItemGroupInit.CREATURES_TAB);
	}
	
	private static RegistryObject<Item> registerArmBone(String id)
	{
		return register(id + "_arm_bone", ItemGroupInit.CREATURES_TAB);
	}
	
	private static RegistryObject<Item> registerLegBone(String id)
	{
		return register(id + "_leg_bone", ItemGroupInit.CREATURES_TAB);
	}
	
	private static RegistryObject<Item> registerFootBone(String id)
	{
		return register(id + "_foot_bone", ItemGroupInit.CREATURES_TAB);
	}
	
	private static RegistryObject<Item> registerRibBone(String id)
	{
		return register(id + "_rib_bone", ItemGroupInit.CREATURES_TAB);
	}
	
	private static RegistryObject<Item> registerOtherBone(String id)
	{
		return register(id, ItemGroupInit.CREATURES_TAB);
	}
	
	private static RegistryObject<Item> register(String id, NonNullSupplier<? extends Block> block, ItemGroup group)
	{
		return register(id, new ModBlockItem(block, properties().tab(group)));
	}
	
	private static RegistryObject<Item> registerFossilsTab(String id, NonNullSupplier<? extends Block> block)
	{
		return register(id, new ModBlockItem(block, properties().tab(ItemGroupInit.FOSSILS_TAB)));
	}
	
	private static RegistryObject<Item> registerMachinesTab(String id, NonNullSupplier<? extends Block> block)
	{
		return register(id, new ModBlockItem(block, properties().tab(ItemGroupInit.MACHINES_TAB)));
	}
	
	private static RegistryObject<Item> registerNatureTab(String id, NonNullSupplier<? extends Block> block)
	{
		return register(id, new ModBlockItem(block, properties().tab(ItemGroupInit.NATURE_TAB)));
	}
	
	private static RegistryObject<Item> registerDecorativesTab(String id, NonNullSupplier<? extends Block> block)
	{
		return register(id, new ModBlockItem(block, properties().tab(ItemGroupInit.DECORATIVES_TAB)));
	}
	
	private static RegistryObject<Item> registerBurningBlock(String id, NonNullSupplier<? extends Block> block)
	{
		return register(id, new ModWoodBurnableItem(block, properties().tab(ItemGroupInit.DECORATIVES_TAB)));
	}
	
	private static RegistryObject<Item> registerBurningSlab(String id, NonNullSupplier<? extends Block> block)
	{
		return register(id, new ModSlabBurnableItem(block, properties().tab(ItemGroupInit.DECORATIVES_TAB)));
	}
	
	private static RegistryObject<Item> registerEgg(String id, NonNullSupplier<? extends Block> block)
	{
		return register(id + "_egg", new ModBlockItem(block, properties().tab(ItemGroupInit.CREATURES_TAB)));
	}
	
	public static void initItems() { ModUtil.LOGGER.debug("Registering: Mod Items"); }
}
