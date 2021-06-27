package api.core.init;

import library.Init;
import library.ModRegistry;
import library.blocks.MossyDirtBlock;
import library.blocks.PowerSupplyBlock;
import library.blocks.bases.LargeEgg;
import library.blocks.bases.LogBlock;
import library.blocks.bases.MediumEggBlock;
import library.blocks.bases.ModOreBlock;
import library.blocks.bases.ModStandingSignBlock;
import library.blocks.bases.ModWallSignBlock;
import library.blocks.bases.QuintuplePlantBlock;
import library.blocks.bases.SmallEggBlock;
import library.blocks.bases.TriplePlantBlock;
import library.blocks.fossils.BlackTerracottaFossilBlock;
import library.blocks.fossils.BlueTerracottaFossilBlock;
import library.blocks.fossils.BrownTerracottaFossilBlock;
import library.blocks.fossils.CyanTerracottaFossilBlock;
import library.blocks.fossils.ExposedSandstoneFossilBlock;
import library.blocks.fossils.ExposedStoneFossilBlock;
import library.blocks.fossils.ExposedTerracottaFossilBlock;
import library.blocks.fossils.GreenTerracottaFossilBlock;
import library.blocks.fossils.GreyTerracottaFossilBlock;
import library.blocks.fossils.LightBlueTerracottaFossilBlock;
import library.blocks.fossils.LightGreyTerracottaFossilBlock;
import library.blocks.fossils.LimeTerracottaFossilBlock;
import library.blocks.fossils.MagentaTerracottaFossilBlock;
import library.blocks.fossils.OrangeTerracottaFossilBlock;
import library.blocks.fossils.PinkTerracottaFossilBlock;
import library.blocks.fossils.PlasteredFossilBlock;
import library.blocks.fossils.PurpleTerracottaFossilBlock;
import library.blocks.fossils.RedSandstoneFossilBlock;
import library.blocks.fossils.RedTerracottaFossilBlock;
import library.blocks.fossils.SandstoneFossilBlock;
import library.blocks.fossils.StoneFossilBlock;
import library.blocks.fossils.TerracottaFossilBlock;
import library.blocks.fossils.WhiteTerracottaFossilBlock;
import library.blocks.fossils.YellowTerracottaFossilBlock;
import library.blocks.machines.AnalyserBlock;
import library.blocks.machines.ArchaeologyTable;
import library.blocks.machines.DNAExtractorBlock;
import library.blocks.machines.DNAInjectorBlock;
import library.blocks.machines.FossilCleanerBlock;
import library.blocks.machines.FossilGrinderBlock;
import library.blocks.machines.TimeMachineBlock;
import library.blocks.plants.DeadSpongeColonyBlock;
import library.blocks.plants.GroundFernsBlock;
import library.blocks.plants.LargePermianDesertPlant;
import library.blocks.plants.MediumPermianDesertPlant;
import library.blocks.plants.ModBushBlock;
import library.blocks.plants.ModSaplingBlock;
import library.blocks.plants.SmallPermianDesertPlant;
import library.blocks.plants.SpongeColonyBlock;
import library.blocks.pottery.BakedKylixBlock;
import library.blocks.pottery.KylixBlock;
import library.entites.bases.AbstractPrehistoricAnimalEntity;
import library.entites.bases.BasePrehistoricEntity;
import library.feature.tree.AraucariaTree;
import library.feature.tree.ConiferTree;
import library.feature.tree.GinkgoTree;
import library.util.base.ModMaterials;
import library.util.base.ModSoundTypes;
import library.util.base.ModToolTypes;
import library.util.base.ModWoodTypes;
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
import net.minecraft.entity.EntityType;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.fml.RegistryObject;

@Init
public class BlockInit extends ModRegistry
{	
	//Ore
	public static final RegistryObject<Block> COPPER_ORE = register("copper_ore", new ModOreBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(3.0F).sound(SoundType.STONE)));
		
	//Fossils
	public static final RegistryObject<Block> STONE_FOSSIL = register("stone_fossil", new StoneFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.STONE).harvestTool(ModToolTypes.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> EXPOSED_STONE_FOSSIL = register("exposed_stone_fossil", new ExposedStoneFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(0).requiresCorrectToolForDrops().strength(1.25F).noOcclusion().sound(SoundType.STONE)));

	public static final RegistryObject<Block> SANDSTONE_FOSSIL = register("sandstone_fossil", new SandstoneFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.SAND).requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> EXPOSED_SANDSTONE_FOSSIL = register("exposed_sandstone_fossil", new ExposedSandstoneFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.SAND).noOcclusion().requiresCorrectToolForDrops().strength(0.8F)));
	
	public static final RegistryObject<Block> RED_SANDSTONE_FOSSIL = register("red_sandstone_fossil", new RedSandstoneFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> EXPOSED_RED_SANDSTONE_FOSSIL = register("exposed_red_sandstone_fossil", new ExposedSandstoneFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_ORANGE).noOcclusion().requiresCorrectToolForDrops().strength(0.8F)));
	
	public static final RegistryObject<Block> TERRACOTTA_FOSSIL = register("terracotta_fossil", new TerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.COLOR_ORANGE).harvestTool(ModToolTypes.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> EXPOSED_TERRACOTTA_FOSSIL = register("exposed_terracotta_fossil", new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_ORANGE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> RED_TERRACOTTA_FOSSIL = register("red_terracotta_fossil", new RedTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_RED).harvestTool(ModToolTypes.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> EXPOSED_RED_TERRACOTTA_FOSSIL = register("exposed_red_terracotta_fossil", new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_RED).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> ORANGE_TERRACOTTA_FOSSIL = register("orange_terracotta_fossil", new OrangeTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_ORANGE).harvestTool(ModToolTypes.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> EXPOSED_ORANGE_TERRACOTTA_FOSSIL = register("exposed_orange_terracotta_fossil", new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_ORANGE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> YELLOW_TERRACOTTA_FOSSIL = register("yellow_terracotta_fossil", new YellowTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_YELLOW).harvestTool(ModToolTypes.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> EXPOSED_YELLOW_TERRACOTTA_FOSSIL = register("exposed_yellow_terracotta_fossil", new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_YELLOW).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> LIME_TERRACOTTA_FOSSIL = register("lime_terracotta_fossil", new LimeTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_LIGHT_GREEN).harvestTool(ModToolTypes.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> EXPOSED_LIME_TERRACOTTA_FOSSIL = register("exposed_lime_terracotta_fossil", new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GREEN).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> GREEN_TERRACOTTA_FOSSIL = register("green_terracotta_fossil", new GreenTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_GREEN).harvestTool(ModToolTypes.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> EXPOSED_GREEN_TERRACOTTA_FOSSIL = register("exposed_green_terracotta_fossil", new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_GREEN).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> CYAN_TERRACOTTA_FOSSIL = register("cyan_terracotta_fossil", new CyanTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_CYAN).harvestTool(ModToolTypes.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> EXPOSED_CYAN_TERRACOTTA_FOSSIL = register("exposed_cyan_terracotta_fossil", new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_CYAN).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_FOSSIL = register("light_blue_terracotta_fossil", new LightBlueTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_LIGHT_BLUE).harvestTool(ModToolTypes.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> EXPOSED_LIGHT_BLUE_TERRACOTTA_FOSSIL = register("exposed_light_blue_terracotta_fossil", new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_BLUE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> BLUE_TERRACOTTA_FOSSIL = register("blue_terracotta_fossil", new BlueTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_BLUE).harvestTool(ModToolTypes.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> EXPOSED_BLUE_TERRACOTTA_FOSSIL = register("exposed_blue_terracotta_fossil", new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLUE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> MAGENTA_TERRACOTTA_FOSSIL = register("magenta_terracotta_fossil", new MagentaTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_MAGENTA).harvestTool(ModToolTypes.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> EXPOSED_MAGENTA_TERRACOTTA_FOSSIL = register("exposed_magenta_terracotta_fossil", new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_MAGENTA).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> PURPLE_TERRACOTTA_FOSSIL = register("purple_terracotta_fossil", new PurpleTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_PURPLE).harvestTool(ModToolTypes.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> EXPOSED_PURPLE_TERRACOTTA_FOSSIL = register("exposed_purple_terracotta_fossil", new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_PURPLE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> PINK_TERRACOTTA_FOSSIL = register("pink_terracotta_fossil", new PinkTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_PINK).harvestTool(ModToolTypes.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> EXPOSED_PINK_TERRACOTTA_FOSSIL = register("exposed_pink_terracotta_fossil", new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_PINK).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> BROWN_TERRACOTTA_FOSSIL = register("brown_terracotta_fossil", new BrownTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_BROWN).harvestTool(ModToolTypes.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> EXPOSED_BROWN_TERRACOTTA_FOSSIL = register("exposed_brown_terracotta_fossil", new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BROWN).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> BLACK_TERRACOTTA_FOSSIL = register("black_terracotta_fossil", new BlackTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_BLACK).harvestTool(ModToolTypes.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> EXPOSED_BLACK_TERRACOTTA_FOSSIL = register("exposed_black_terracotta_fossil", new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLACK).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> GREY_TERRACOTTA_FOSSIL = register("grey_terracotta_fossil", new GreyTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_GRAY).harvestTool(ModToolTypes.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> EXPOSED_GREY_TERRACOTTA_FOSSIL = register("exposed_grey_terracotta_fossil", new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_GRAY).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> LIGHT_GREY_TERRACOTTA_FOSSIL = register("light_grey_terracotta_fossil", new LightGreyTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_LIGHT_GRAY).harvestTool(ModToolTypes.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> EXPOSED_LIGHT_GREY_TERRACOTTA_FOSSIL = register("exposed_light_grey_terracotta_fossil", new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GRAY).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<Block> WHITE_TERRACOTTA_FOSSIL = register("white_terracotta_fossil", new WhiteTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_WHITE).harvestTool(ModToolTypes.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> EXPOSED_WHITE_TERRACOTTA_FOSSIL = register("exposed_white_terracotta_fossil", new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_WHITE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	
	public static final RegistryObject<Block> PLASTERED_FOSSIL = register("plastered_fossil", new PlasteredFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).instabreak().sound(SoundType.WOOL).noOcclusion()));

	//Fossil Processing	
	public static final RegistryObject<Block> FOSSIL_CLEANER = register("fossil_cleaner", new FossilCleanerBlock(AbstractBlock.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).strength(3.0f, 6.0F).requiresCorrectToolForDrops().noOcclusion().sound(SoundType.METAL)));
	public static final RegistryObject<Block> FOSSIL_GRINDER = register("fossil_grinder", new FossilGrinderBlock(AbstractBlock.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).strength(3.0f, 6.0F).requiresCorrectToolForDrops().noOcclusion().sound(SoundType.METAL)));
	public static final RegistryObject<Block> DNA_EXTRACTOR = register("dna_extractor", new DNAExtractorBlock(AbstractBlock.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).strength(3.0f, 6.0F).requiresCorrectToolForDrops().noOcclusion().sound(SoundType.METAL)));
	public static final RegistryObject<Block> ANALYSER = register("analyser", new AnalyserBlock(AbstractBlock.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).strength(3.0f, 6.0F).requiresCorrectToolForDrops().noOcclusion().sound(SoundType.METAL)));
	public static final RegistryObject<Block> DNA_INJECTOR = register("dna_injector", new DNAInjectorBlock(AbstractBlock.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).strength(3.0f, 6.0F).requiresCorrectToolForDrops().noOcclusion().sound(SoundType.METAL)));
	
	public static final RegistryObject<Block> POWER_SUPPLY_BLOCK = register("power_supply_block", new PowerSupplyBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).noOcclusion().harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(3.0F, 5.5F).sound(SoundType.STONE)));
	
	//Pottery
	public static final RegistryObject<Block> BAKED_KYLIX = register("baked_kylix", new BakedKylixBlock(AbstractBlock.Properties.of(Material.CLAY, MaterialColor.TERRACOTTA_ORANGE).instabreak().noOcclusion().sound(ModSoundTypes.POT_SOUNDS)));
	public static final RegistryObject<Block> CHIPPED_BAKED_KYLIX = register("chipped_baked_kylix", new BakedKylixBlock(AbstractBlock.Properties.of(Material.CLAY, MaterialColor.TERRACOTTA_ORANGE).instabreak().noOcclusion().sound(ModSoundTypes.POT_SOUNDS)));
	public static final RegistryObject<Block> DAMAGED_BAKED_KYLIX = register("damaged_baked_kylix", new BakedKylixBlock(AbstractBlock.Properties.of(Material.CLAY, MaterialColor.TERRACOTTA_ORANGE).instabreak().noOcclusion().sound(ModSoundTypes.POT_SOUNDS)));
	public static final RegistryObject<Block> KYLIX = register("kylix", new KylixBlock(AbstractBlock.Properties.of(Material.CLAY, MaterialColor.TERRACOTTA_ORANGE).instabreak().noOcclusion().sound(SoundType.GRAVEL)));	

	public static final RegistryObject<Block> BAKED_SEAMLESS_KYLIX = register("baked_seamless_kylix", new Block(AbstractBlock.Properties.of(Material.CLAY, MaterialColor.TERRACOTTA_ORANGE).instabreak().noOcclusion()));
	public static final RegistryObject<Block> SEAMLESS_KYLIX = register("seamless_kylix", new Block(AbstractBlock.Properties.of(Material.CLAY, MaterialColor.TERRACOTTA_ORANGE).instabreak().noOcclusion().sound(SoundType.GRAVEL)));	
	
	//Eggs (Coming soon)
	/*public static final RegistryObject<Block> PROCOMPSOGNATHUS_EGG = registerSmall("procompsognathus", () -> EntityInit.PROCOMPSOGNATHUS_ENTITY.get());
	public static final RegistryObject<Block> DIMETRODON_EGG = registerMedium("dimetrodon", () -> EntityInit.DIMETRODON_ENTITY.get());
	public static final RegistryObject<Block> EDAPHOSAURUS_EGG = registerMedium("edaphosaurus", () -> EntityInit.EDAPHOSAURUS_ENTITY.get());
	public static final RegistryObject<Block> GORGONOPS_EGG = registerSmall("gorgonops", () -> EntityInit.GORGONOPS_ENTITY.get());
	public static final RegistryObject<Block> CARNOTAURUS_EGG = registerMedium("carnotaurus", () -> EntityInit.CARNOTAURUS_ENTITY.get());
	public static final RegistryObject<Block> TYRANNOSAURUS_EGG = registerLarge("tyrannosaurus", () -> EntityInit.TYRANNOSAURUS_ENTITY.get());*/
	public static final RegistryObject<Block> ALLOSAURUS_EGG = registerMedium("allosaurus", () -> EntityInit.ALLOSAURUS_ENTITY.get());
	/*public static final RegistryObject<Block> GIGANOTOSAURUS_EGG = registerLarge("giganotosaurus", () -> EntityInit.GIGANOTOSAURUS_ENTITY.get());
	public static final RegistryObject<Block> SUCHOMIMUS_EGG = registerMedium("suchomimus", () -> EntityInit.SUCHOMIMUS_ENTITY.get());
	public static final RegistryObject<Block> TETRACERATOPS_EGG = registerSmall("tetraceratops", () -> EntityInit.TETRACERATOPS_ENTITY.get());
	public static final RegistryObject<Block> GREAT_AUK_EGG = registerSmall("great_auk", () -> EntityInit.GREAT_AUK_ENTITY.get());
	public static final RegistryObject<Block> OURANOSAURUS_EGG = registerMedium("ouranosaurus", () -> EntityInit.OURANOSAURUS_ENTITY.get());
	public static final RegistryObject<Block> FUKUIVENATOR_EGG = registerSmall("fukuivenator", () -> EntityInit.FUKUIVENATOR_ENTITY.get());
	public static final RegistryObject<Block> PSITTACOSAURUS_EGG = registerSmall("psittacosaurus", () -> EntityInit.PSITTACOSAURUS_ENTITY.get());
	public static final RegistryObject<Block> CRYOLOPHOSAURUS_EGG = registerMedium("cryolophosaurus", () -> EntityInit.CRYOLOPHOSAURUS_ENTITY.get());
	public static final RegistryObject<Block> OSTROMIA_EGG = registerSmall("ostromia", () -> EntityInit.OSTROMIA_ENTITY.get());
	public static final RegistryObject<Block> PROTOSUCHUS_EGG = registerSmall("protosuchus", () -> EntityInit.PROTOSUCHUS_ENTITY.get());
	public static final RegistryObject<Block> DIICTODON_EGG = registerSmall("diictodon", () -> EntityInit.DIICTODON_ENTITY.get());
	public static final RegistryObject<Block> KENTROSAURUS_EGG = registerMedium("kentrosaurus", () -> EntityInit.KENTROSAURUS_ENTITY.get());
	public static final RegistryObject<Block> CHILESAURUS_EGG = registerSmall("chilesaurus", () -> EntityInit.CHILESAURUS_ENTITY.get());
	public static final RegistryObject<Block> LIAONINGOSAURUS_EGG = registerSmall("liaoningosaurus", () -> EntityInit.LIAONINGOSAURUS_ENTITY.get());
	public static final RegistryObject<Block> UTAHRAPTOR_EGG = registerMedium("utahraptor", () -> EntityInit.UTAHRAPTOR_ENTITY.get());
	public static final RegistryObject<Block> ZEPHYROSAURUS_EGG = registerSmall("zephyrosaurus", () -> EntityInit.ZEPHYROSAURUS_ENTITY.get());*/
	
	//Mud
	public static final RegistryObject<Block> MUD = register("mud", new Block(AbstractBlock.Properties.of(Material.CLAY, MaterialColor.COLOR_BROWN).harvestTool(ToolType.SHOVEL).strength(0.6F).sound(SoundType.GRAVEL)));
	
	//Nesting Block
	public static final RegistryObject<Block> NESTING_BLOCK = register("nesting_block", new Block(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_BROWN).harvestTool(ToolType.SHOVEL).strength(0.3F).sound(SoundType.GRASS)));

	//Time Machine
	public static final RegistryObject<Block> TIME_MACHINE = register("time_machine", new TimeMachineBlock(AbstractBlock.Properties.of(Material.METAL, MaterialColor.GOLD).harvestTool(ToolType.PICKAXE).harvestLevel(4).requiresCorrectToolForDrops().strength(50.0F, 1200.0F)));
	
	//Museum Stuff
	public static final RegistryObject<Block> ARCHAEOLOGY_TABLE = register("archaeology_table", new ArchaeologyTable(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).harvestTool(ToolType.PICKAXE).strength(2.0F, 3.0F).noOcclusion().sound(SoundType.STONE)));

	//Volcanic Stuff
	public static final RegistryObject<Block> VOLCANIC_ROCK = register("volcanic_rock", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.GILDED_BLACKSTONE)));
	public static final RegistryObject<Block> VOLCANIC_ROCK_STAIRS = register("volcanic_rock_stairs", new StairsBlock(() -> BlockInit.VOLCANIC_ROCK.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.GILDED_BLACKSTONE)));
	public static final RegistryObject<Block> VOLCANIC_ROCK_SLAB = register("volcanic_rock_slab", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.GILDED_BLACKSTONE)));
	public static final RegistryObject<Block> VOLCANIC_ROCK_WALL = register("volcanic_rock_wall", new WallBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.GILDED_BLACKSTONE)));
	
	public static final RegistryObject<Block> POLISHED_VOLCANIC_ROCK = register("polished_volcanic_rock", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.GILDED_BLACKSTONE)));
	public static final RegistryObject<Block> POLISHED_VOLCANIC_ROCK_STAIRS = register("polished_volcanic_rock_stairs", new StairsBlock(() -> BlockInit.POLISHED_VOLCANIC_ROCK.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.GILDED_BLACKSTONE)));
	public static final RegistryObject<Block> POLISHED_VOLCANIC_ROCK_SLAB = register("polished_volcanic_rock_slab", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.GILDED_BLACKSTONE)));
	
	public static final RegistryObject<Block> VOLCANIC_ASH = register("volcanic_ash", new SandBlock(0x888988, AbstractBlock.Properties.of(Material.SAND, MaterialColor.COLOR_GRAY).harvestTool(ToolType.SHOVEL).harvestLevel(1).strength(0.5F).sound(SoundType.SAND)));	
	
	//Tunnel
	public static final RegistryObject<Block> DIICTODON_BURROW = register("diictodon_burrow", new Block(AbstractBlock.Properties.of(Material.SAND, MaterialColor.SAND).harvestTool(ToolType.SHOVEL).strength(1.5F).sound(SoundType.SAND)));
	public static final RegistryObject<Block> TUNNELED_SOIL = register("tunneled_soil", new Block(AbstractBlock.Properties.of(Material.DIRT, MaterialColor.DIRT).strength(0.5F).sound(SoundType.GRAVEL)));

	//Mossy Dirt
	public static final RegistryObject<Block> MOSSY_DIRT = register("mossy_dirt", new MossyDirtBlock(AbstractBlock.Properties.of(Material.DIRT, MaterialColor.DIRT).strength(0.5F).randomTicks().sound(SoundType.GRAVEL), Blocks.DIRT));
	
	//Permian Blocks
	public static final RegistryObject<Block> PERMIAN_SAND = register("permian_sand", new SandBlock(0xaa915c, AbstractBlock.Properties.of(Material.SAND, MaterialColor.SAND).harvestTool(ToolType.SHOVEL).strength(1.5F).sound(SoundType.SAND)));
	
	public static final RegistryObject<Block> PERMIAN_STONE = register("permian_stone", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PERMIAN_STONE_STAIRS = register("permian_stone_stairs", new StairsBlock(() -> BlockInit.PERMIAN_STONE.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PERMIAN_STONE_SLAB = register("permian_stone_slab", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> PERMIAN_COPPER_ORE = register("permian_copper_ore", new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
	public static final RegistryObject<Block> PERMIAN_GOLD_ORE = register("permian_gold_ore", new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
	public static final RegistryObject<Block> PERMIAN_IRON_ORE = register("permian_iron_ore", new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
	public static final RegistryObject<Block> PERMIAN_COAL_ORE = register("permian_coal_ore", new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
	public static final RegistryObject<Block> PERMIAN_LAPIS_ORE = register("permian_lapis_ore", new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));	
	public static final RegistryObject<Block> PERMIAN_DIAMOND_ORE = register("permian_diamond_ore", new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));	
	public static final RegistryObject<Block> PERMIAN_REDSTONE_ORE = register("permian_redstone_ore", new RedstoneOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));	
	public static final RegistryObject<Block> PERMIAN_EMERALD_ORE = register("permian_emerald_ore", new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));	
	
	public static final RegistryObject<Block> PERMIAN_COBBLESTONE = register("permian_cobblestone", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PERMIAN_COBBLESTONE_STAIRS = register("permian_cobblestone_stairs", new StairsBlock(() -> BlockInit.PERMIAN_STONE.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PERMIAN_COBBLESTONE_SLAB = register("permian_cobblestone_slab", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PERMIAN_COBBLESTONE_WALL = register("permian_cobblestone_wall", new WallBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> PERMIAN_STONE_BRICKS = register("permian_stone_bricks", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PERMIAN_STONE_BRICK_STAIRS = register("permian_stone_brick_stairs", new StairsBlock(() -> BlockInit.PERMIAN_STONE_BRICKS.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PERMIAN_STONE_BRICK_SLAB = register("permian_stone_brick_slab", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PERMIAN_STONE_BRICK_WALL = register("permian_stone_brick_wall", new WallBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> SMALL_PERMIAN_DESERT_PLANT = register("small_permian_desert_plant", new SmallPermianDesertPlant(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_BROWN).noCollission().noOcclusion().strength(5.0F, 6.0F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> MEDIUM_PERMIAN_DESERT_PLANT = register("medium_permian_desert_plant", new MediumPermianDesertPlant(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_BROWN).noCollission().noOcclusion().strength(5.0F, 6.0F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> LARGE_PERMIAN_DESERT_PLANT = register("large_permian_desert_plant", new LargePermianDesertPlant(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_BROWN).noCollission().noOcclusion().strength(5.0F, 6.0F).sound(SoundType.GRASS)));

	public static final RegistryObject<Block> GROUND_FERNS = register("ground_ferns", new GroundFernsBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> DICKSONIA = register("dicksonia", new ModBushBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> TALL_DICKSONIA = register("tall_dicksonia", new DoublePlantBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> CYCAD = register("cycad", new ModBushBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> OSMUNDA = register("osmunda", new ModBushBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> DUISBERGIA = register("duisbergia", new DoublePlantBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> CEPHALOTAXUS = register("cephalotaxus", new ModBushBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> LYCOPHYTA = register("lycophyta", new ModBushBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> DILLHOFFIA = register("dillhoffia", new FlowerBlock(Effects.BLINDNESS, 7, AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> POTTED_DILLHOFFIA = BLOCK_REGISTRY.register("potted_dillhoffia", () -> new FlowerPotBlock(DILLHOFFIA.get(), AbstractBlock.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> HORSETAIL = register("horsetail", new TriplePlantBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> TEMPSKYA = register("tempskya", new QuintuplePlantBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));

	//Jurassic Blocks
	public static final RegistryObject<Block> JURASSIC_STONE = register("jurassic_stone", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	public static final RegistryObject<Block> JURASSIC_STONE_STAIRS = register("jurassic_stone_stairs", new StairsBlock(() -> BlockInit.JURASSIC_STONE.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	public static final RegistryObject<Block> JURASSIC_STONE_SLAB = register("jurassic_stone_slab", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));

	public static final RegistryObject<Block> JURASSIC_COPPER_ORE = register("jurassic_copper_ore", new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
	public static final RegistryObject<Block> JURASSIC_GOLD_ORE = register("jurassic_gold_ore", new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
	public static final RegistryObject<Block> JURASSIC_IRON_ORE = register("jurassic_iron_ore", new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
	public static final RegistryObject<Block> JURASSIC_COAL_ORE = register("jurassic_coal_ore", new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
	public static final RegistryObject<Block> JURASSIC_LAPIS_ORE = register("jurassic_lapis_ore", new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));	
	public static final RegistryObject<Block> JURASSIC_DIAMOND_ORE = register("jurassic_diamond_ore", new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));	
	public static final RegistryObject<Block> JURASSIC_REDSTONE_ORE = register("jurassic_redstone_ore", new RedstoneOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));	
	public static final RegistryObject<Block> JURASSIC_EMERALD_ORE = register("jurassic_emerald_ore", new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));		
	
	public static final RegistryObject<Block> MOSSY_JURASSIC_STONE = register("mossy_jurassic_stone", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().randomTicks().strength(3.0F)));
	public static final RegistryObject<Block> MOSSY_JURASSIC_STONE_STAIRS = register("mossy_jurassic_stone_stairs", new StairsBlock(() -> BlockInit.MOSSY_JURASSIC_STONE.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	public static final RegistryObject<Block> MOSSY_JURASSIC_STONE_SLAB = register("mossy_jurassic_stone_slab", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));

	public static final RegistryObject<Block> JURASSIC_COBBLESTONE = register("jurassic_cobblestone", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	public static final RegistryObject<Block> JURASSIC_COBBLESTONE_STAIRS = register("jurassic_cobblestone_stairs", new StairsBlock(() -> BlockInit.JURASSIC_COBBLESTONE.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	public static final RegistryObject<Block> JURASSIC_COBBLESTONE_SLAB = register("jurassic_cobblestone_slab", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	public static final RegistryObject<Block> JURASSIC_COBBLESTONE_WALL = register("jurassic_cobblestone_wall", new WallBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	
	public static final RegistryObject<Block> MOSSY_JURASSIC_COBBLESTONE = register("mossy_jurassic_cobblestone", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	public static final RegistryObject<Block> MOSSY_JURASSIC_COBBLESTONE_STAIRS = register("mossy_jurassic_cobblestone_stairs", new StairsBlock(() -> BlockInit.MOSSY_JURASSIC_COBBLESTONE.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	public static final RegistryObject<Block> MOSSY_JURASSIC_COBBLESTONE_SLAB = register("mossy_jurassic_cobblestone_slab", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	public static final RegistryObject<Block> MOSSY_JURASSIC_COBBLESTONE_WALL = register("mossy_jurassic_cobblestone_wall", new WallBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	
	public static final RegistryObject<Block> JURASSIC_STONE_BRICKS = register("jurassic_stone_bricks", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> JURASSIC_STONE_BRICK_STAIRS = register("jurassic_stone_brick_stairs", new StairsBlock(() -> BlockInit.JURASSIC_STONE_BRICKS.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> JURASSIC_STONE_BRICK_SLAB = register("jurassic_stone_brick_slab", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> JURASSIC_STONE_BRICK_WALL = register("jurassic_stone_brick_wall", new WallBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> MOSSY_JURASSIC_STONE_BRICKS = register("mossy_jurassic_stone_bricks", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> MOSSY_JURASSIC_STONE_BRICK_STAIRS = register("mossy_jurassic_stone_brick_stairs", new StairsBlock(() -> BlockInit.MOSSY_JURASSIC_STONE_BRICKS.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> MOSSY_JURASSIC_STONE_BRICK_SLAB = register("mossy_jurassic_stone_brick_slab", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> MOSSY_JURASSIC_STONE_BRICK_WALL = register("mossy_jurassic_stone_brick_wall", new WallBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	
	//Sponge Colony
	public static final RegistryObject<Block> DEAD_SPONGE_COLONY = register("dead_sponge_colony", new DeadSpongeColonyBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.STONE).noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> SPONGE_COLONY = register("sponge_colony", new SpongeColonyBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().noOcclusion().strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK), () -> BlockInit.DEAD_SPONGE_COLONY.get()));

	//Conifer
	public static final RegistryObject<Block> CONIFER_LOG = register("conifer_log", new LogBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> STRIPPED_CONIFER_LOG = register("stripped_conifer_log", new LogBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> CONIFER_WOOD = register("conifer_wood", new LogBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> STRIPPED_CONIFER_WOOD = register("stripped_conifer_wood", new LogBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> CONIFER_LEAVES = register("conifer_leaves", new LeavesBlock(AbstractBlock.Properties.of(Material.LEAVES, MaterialColor.COLOR_GREEN).strength(0.3F).noOcclusion().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> CONIFER_SAPLING = register("conifer_sapling", new ModSaplingBlock(new ConiferTree(), AbstractBlock.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> CONIFER_PLANKS = register("conifer_planks", new Block(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> CONIFER_STAIRS = register("conifer_stairs", new StairsBlock(() -> BlockInit.CONIFER_PLANKS.get().defaultBlockState(), AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> CONIFER_SLAB = register("conifer_slab", new SlabBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> CONIFER_FENCE = register("conifer_fence", new FenceBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> CONIFER_FENCE_GATE = register("conifer_fence_gate", new FenceGateBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> CONIFER_PRESSURE_PLATE = register("conifer_pressure_plate", new PressurePlateBlock(Sensitivity.EVERYTHING, AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noCollission().sound(SoundType.WOOD)));
	public static final RegistryObject<Block> CONIFER_BUTTON = register("conifer_button", new WoodButtonBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noCollission().sound(SoundType.WOOD)));
	public static final RegistryObject<Block> CONIFER_TRAPDOOR = register("conifer_trapdoor", new TrapDoorBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noOcclusion().sound(SoundType.WOOD)));
	public static final RegistryObject<Block> CONIFER_DOOR = register("conifer_door", new DoorBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noOcclusion().sound(SoundType.WOOD)));
	public static final RegistryObject<Block> CONIFER_SIGN = register("conifer_sign", new ModStandingSignBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD).noCollission(), ModWoodTypes.CONIFER));
	public static final RegistryObject<Block> CONIFER_WALL_SIGN = BLOCK_REGISTRY.register("conifer_wall_sign", () -> new ModWallSignBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD).noCollission().dropsLike(BlockInit.CONIFER_SIGN.get()), ModWoodTypes.CONIFER));
	
	//Ginkgo
	public static final RegistryObject<Block> GINKGO_LOG = register("ginkgo_log", new LogBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_GRAY).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> STRIPPED_GINKGO_LOG = register("stripped_ginkgo_log", new LogBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> GINKGO_WOOD = register("ginkgo_wood", new LogBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> STRIPPED_GINKGO_WOOD = register("stripped_ginkgo_wood", new LogBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> GINKGO_LEAVES = register("ginkgo_leaves", new LeavesBlock(AbstractBlock.Properties.of(Material.LEAVES, MaterialColor.COLOR_GREEN).strength(0.3F).noOcclusion().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> GINKGO_SAPLING = register("ginkgo_sapling", new ModSaplingBlock(new GinkgoTree(), AbstractBlock.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> GINKGO_PLANKS = register("ginkgo_planks", new Block(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> GINKGO_STAIRS = register("ginkgo_stairs", new StairsBlock(() -> BlockInit.CONIFER_PLANKS.get().defaultBlockState(), AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> GINKGO_SLAB = register("ginkgo_slab", new SlabBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> GINKGO_FENCE = register("ginkgo_fence", new FenceBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> GINKGO_FENCE_GATE = register("ginkgo_fence_gate", new FenceGateBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> GINKGO_PRESSURE_PLATE = register("ginkgo_pressure_plate", new PressurePlateBlock(Sensitivity.EVERYTHING, AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noCollission().sound(SoundType.WOOD)));
	public static final RegistryObject<Block> GINKGO_BUTTON = register("ginkgo_button", new WoodButtonBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noCollission().sound(SoundType.WOOD)));
	public static final RegistryObject<Block> GINKGO_TRAPDOOR = register("ginkgo_trapdoor", new TrapDoorBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noOcclusion().sound(SoundType.WOOD)));
	public static final RegistryObject<Block> GINKGO_DOOR = register("ginkgo_door", new DoorBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noOcclusion().sound(SoundType.WOOD)));
	public static final RegistryObject<Block> GINKGO_SIGN = register("ginkgo_sign", new ModStandingSignBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD).noCollission(), ModWoodTypes.GINKGO));
	public static final RegistryObject<Block> GINKGO_WALL_SIGN = BLOCK_REGISTRY.register("ginkgo_wall_sign", () -> new ModWallSignBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD).noCollission().dropsLike(BlockInit.GINKGO_SIGN.get()), ModWoodTypes.GINKGO));
		
	//Araucaria
	public static final RegistryObject<Block> ARAUCARIA_LOG = register("araucaria_log", new LogBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_GRAY).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> STRIPPED_ARAUCARIA_LOG = register("stripped_araucaria_log", new LogBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ARAUCARIA_WOOD = register("araucaria_wood", new LogBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> STRIPPED_ARAUCARIA_WOOD = register("stripped_araucaria_wood", new LogBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ARAUCARIA_LEAVES = register("araucaria_leaves", new LeavesBlock(AbstractBlock.Properties.of(Material.LEAVES, MaterialColor.COLOR_GREEN).strength(0.3F).noOcclusion().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> ARAUCARIA_SAPLING = register("araucaria_sapling", new ModSaplingBlock(new AraucariaTree(), AbstractBlock.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> ARAUCARIA_PLANKS = register("araucaria_planks", new Block(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ARAUCARIA_STAIRS = register("araucaria_stairs", new StairsBlock(() -> BlockInit.ARAUCARIA_PLANKS.get().defaultBlockState(), AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ARAUCARIA_SLAB = register("araucaria_slab", new SlabBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ARAUCARIA_FENCE = register("araucaria_fence", new FenceBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ARAUCARIA_FENCE_GATE = register("araucaria_fence_gate", new FenceGateBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ARAUCARIA_PRESSURE_PLATE = register("araucaria_pressure_plate", new PressurePlateBlock(Sensitivity.EVERYTHING, AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noCollission().sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ARAUCARIA_BUTTON = register("araucaria_button", new WoodButtonBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noCollission().sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ARAUCARIA_TRAPDOOR = register("araucaria_trapdoor", new TrapDoorBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noOcclusion().sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ARAUCARIA_DOOR = register("araucaria_door", new DoorBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noOcclusion().sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ARAUCARIA_SIGN = register("araucaria_sign", new ModStandingSignBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD).noCollission(), ModWoodTypes.ARAUCARIA));
	public static final RegistryObject<Block> ARAUCARIA_WALL_SIGN = BLOCK_REGISTRY.register("araucaria_wall_sign", () -> new ModWallSignBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD).noCollission().dropsLike(BlockInit.ARAUCARIA_SIGN.get()), ModWoodTypes.ARAUCARIA));
		
	//Light Concrete
	public static final RegistryObject<Block> LIGHT_CONCRETE = register("light_concrete", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(6.0F, 8.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> LIGHT_CONCRETE_STAIRS = register("light_concrete_stairs", new StairsBlock(() -> BlockInit.LIGHT_CONCRETE.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(6.0F, 8.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> LIGHT_CONCRETE_SLAB = register("light_concrete_slab", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(6.0F, 8.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> LIGHT_CONCRETE_WALL = register("light_concrete_wall", new WallBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(6.0F, 8.0F).noCollission().sound(SoundType.STONE)));
	public static final RegistryObject<Block> LIGHT_CONCRETE_PRESSURE_PLATE = register("light_concrete_pressure_plate", new PressurePlateBlock(Sensitivity.MOBS, AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(6.0F, 8.0F).noCollission().sound(SoundType.STONE)));
	public static final RegistryObject<Block> LIGHT_CONCRETE_BUTTON = register("light_concrete_button", new StoneButtonBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(6.0F, 8.0F).noCollission().sound(SoundType.STONE)));

	//Polished Light Concrete
	public static final RegistryObject<Block> POLISHED_LIGHT_CONCRETE = register("polished_light_concrete", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(6.5F, 8.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> POLISHED_LIGHT_CONCRETE_STAIRS = register("polished_light_concrete_stairs", new StairsBlock(() -> BlockInit.LIGHT_CONCRETE.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(6.5F, 8.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> POLISHED_LIGHT_CONCRETE_SLAB = register("polished_light_concrete_slab", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(6.5F, 8.5F).sound(SoundType.STONE)));

	//Dark Concrete
	public static final RegistryObject<Block> DARK_CONCRETE = register("dark_concrete", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(8.0F, 10.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DARK_CONCRETE_STAIRS = register("dark_concrete_stairs", new StairsBlock(() -> BlockInit.DARK_CONCRETE.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(8.0F, 10.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DARK_CONCRETE_SLAB = register("dark_concrete_slab", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(8.0F, 10.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DARK_CONCRETE_WALL = register("dark_concrete_wall", new WallBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(8.0F, 10.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DARK_CONCRETE_PRESSURE_PLATE = register("dark_concrete_pressure_plate", new PressurePlateBlock(Sensitivity.MOBS, AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(8.0F, 10.0F).noCollission().sound(SoundType.STONE)));
	public static final RegistryObject<Block> DARK_CONCRETE_BUTTON = register("dark_concrete_button", new StoneButtonBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(8.0F, 10.0F).noCollission().sound(SoundType.STONE)));
	
	//Polished Dark Concrete
	public static final RegistryObject<Block> POLISHED_DARK_CONCRETE = register("polished_dark_concrete", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(8.5F, 10.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> POLISHED_DARK_CONCRETE_STAIRS = register("polished_dark_concrete_stairs", new StairsBlock(() -> BlockInit.DARK_CONCRETE.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(8.5F, 10.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> POLISHED_DARK_CONCRETE_SLAB = register("polished_dark_concrete_slab", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(8.5F, 10.5F).sound(SoundType.STONE)));

	//Wooden Planks
	public static final RegistryObject<Block> WOODEN_PLANKS = register("wooden_planks", new Block(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(1.2F, 0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> WOODEN_PLANKS_STAIRS = register("wooden_planks_stairs", new StairsBlock(() -> BlockInit.WOODEN_PLANKS.get().defaultBlockState(), AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(1.2F, 0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> WOODEN_PLANKS_SLAB = register("wooden_planks_slab", new SlabBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(1.2F, 0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> WOODEN_PLANKS_FENCE = register("wooden_planks_fence", new FenceBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(1.2F, 0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> WOODEN_PLANKS_FENCE_GATE = register("wooden_planks_fence_gate", new FenceGateBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(1.2F, 0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> WOODEN_PLANKS_PRESSURE_PLATE = register("wooden_planks_pressure_plate", new PressurePlateBlock(Sensitivity.EVERYTHING, AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(1.2F, 0.5F).noCollission().sound(SoundType.WOOD)));
	public static final RegistryObject<Block> WOODEN_PLANKS_BUTTON = register("wooden_planks_button", new WoodButtonBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(1.2F, 0.5F).noCollission().sound(SoundType.WOOD)));

	//Refined Wooden Planks
	public static final RegistryObject<Block> REFINED_WOODEN_PLANKS = register("refined_wooden_planks", new Block(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(2.7F, 1.9F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> REFINED_WOODEN_PLANKS_STAIRS = register("refined_wooden_planks_stairs", new StairsBlock(() -> BlockInit.REFINED_WOODEN_PLANKS.get().defaultBlockState(), AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(2.7F, 1.9F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> REFINED_WOODEN_PLANKS_SLAB = register("refined_wooden_planks_slab", new SlabBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(2.7F, 1.9F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> REFINED_WOODEN_PLANKS_FENCE = register("refined_wooden_planks_fence", new FenceBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(2.7F, 1.9F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> REFINED_WOODEN_PLANKS_FENCE_GATE = register("refined_wooden_planks_fence_gate", new FenceGateBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(2.7F, 1.9F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> REFINED_WOODEN_PLANKS_PRESSURE_PLATE = register("refined_wooden_planks_pressure_plate", new PressurePlateBlock(Sensitivity.EVERYTHING, AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(2.7F, 1.9F).noCollission().sound(SoundType.WOOD)));
	public static final RegistryObject<Block> REFINED_WOODEN_PLANKS_BUTTON = register("refined_wooden_planks_button", new WoodButtonBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(2.7F, 1.9F).noCollission().sound(SoundType.WOOD)));

	//Pavement
	public static final RegistryObject<Block> PAVEMENT = register("pavement", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GRAY).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(3.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PAVEMENT_SLOPE = register("pavement_slope", new StairsBlock(() -> BlockInit.PAVEMENT.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GRAY).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(3.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> RAISED_PAVEMENT = register("raised_pavement", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GRAY).harvestTool(ToolType.PICKAXE).harvestLevel(1).strength(3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
	
	//Roads
	public static final RegistryObject<Block> GRAVEL_ROAD = register("gravel_road", new Block(AbstractBlock.Properties.of(Material.SAND, MaterialColor.TERRACOTTA_LIGHT_GRAY).harvestTool(ToolType.SHOVEL).harvestLevel(0).strength(1.5F).sound(SoundType.SAND)));
	public static final RegistryObject<Block> RAISED_GRAVEL_ROAD = register("raised_gravel_road", new SlabBlock(AbstractBlock.Properties.of(Material.SAND, MaterialColor.TERRACOTTA_LIGHT_GRAY).harvestTool(ToolType.SHOVEL).harvestLevel(0).strength(1.5F).sound(SoundType.SAND)));
	
	public static final RegistryObject<Block> DIRT_ROAD = register("dirt_road", new Block(AbstractBlock.Properties.of(Material.DIRT, MaterialColor.DIRT).harvestTool(ToolType.SHOVEL).harvestLevel(0).strength(1.5F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> RAISED_DIRT_ROAD = register("raised_dirt_road", new SlabBlock(AbstractBlock.Properties.of(Material.DIRT, MaterialColor.DIRT).harvestTool(ToolType.SHOVEL).harvestLevel(0).strength(1.5F).sound(SoundType.GRASS)));
		
	public static final RegistryObject<Block> PAVED_ROAD = register("paved_road", new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> RAISED_PAVED_ROAD = register("raised_paved_road", new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.STONE)));
	
	//Tile
	public static final RegistryObject<Block> TILE = register("tile", new Block(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(2.7F, 1.9F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> TILE_STAIRS = register("tile_stairs", new StairsBlock(() -> BlockInit.TILE.get().defaultBlockState(), AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(2.7F, 1.9F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> TILE_SLAB = register("tile_slab", new SlabBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(2.7F, 1.9F).sound(SoundType.WOOD)));

	//Fence
	public static final RegistryObject<Block> METAL_FENCE = register("metal_fence", new FenceBlock(AbstractBlock.Properties.of(Material.METAL, MaterialColor.COLOR_RED).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(4.5F, 6.0F).sound(SoundType.METAL)));

	//Clear Glass
	public static final RegistryObject<Block> CLEAR_GLASS = register("clear_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_WHITE).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<Block> CLEAR_GLASS_PANE = register("clear_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_WHITE).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	//Tinted Glass
	public static final RegistryObject<Block> TINTED_GLASS = register("tinted_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<Block> TINTED_GLASS_PANE = register("tinted_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	
	//Coloured Glass
	public static final RegistryObject<Block> WHITE_GLASS = register("white_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<Block> WHITE_GLASS_PANE = register("white_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<Block> LIGHT_GREY_GLASS = register("light_grey_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<Block> LIGHT_GREY_GLASS_PANE = register("light_grey_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<Block> GREY_GLASS = register("grey_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<Block> GREY_GLASS_PANE = register("grey_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<Block> BLACK_GLASS = register("black_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<Block> BLACK_GLASS_PANE = register("black_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<Block> RED_GLASS = register("red_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<Block> RED_GLASS_PANE = register("red_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<Block> ORANGE_GLASS = register("orange_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<Block> ORANGE_GLASS_PANE = register("orange_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<Block> YELLOW_GLASS = register("yellow_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<Block> YELLOW_GLASS_PANE = register("yellow_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<Block> LIME_GLASS = register("lime_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<Block> LIME_GLASS_PANE = register("lime_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<Block> GREEN_GLASS = register("green_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<Block> GREEN_GLASS_PANE = register("green_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<Block> CYAN_GLASS = register("cyan_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<Block> CYAN_GLASS_PANE = register("cyan_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<Block> LIGHT_BLUE_GLASS = register("light_blue_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(3.0F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<Block> LIGHT_BLUE_GLASS_PANE = register("light_blue_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<Block> BLUE_GLASS = register("blue_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<Block> BLUE_GLASS_PANE = register("blue_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<Block> PURPLE_GLASS = register("purple_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<Block> PURPLE_GLASS_PANE = register("purple_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<Block> MAGENTA_GLASS = register("magenta_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<Block> MAGENTA_GLASS_PANE = register("magenta_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<Block> PINK_GLASS = register("pink_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<Block> PINK_GLASS_PANE = register("pink_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<Block> BROWN_GLASS = register("brown_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<Block> BROWN_GLASS_PANE = register("brown_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<Block> SHADED_GLASS = register("shaded_glass", new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<Block> SHADED_GLASS_PANE = register("shaded_glass_pane", new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	
	//Colour Blocks
	public static final RegistryObject<Block> RED_DECORATION_BLOCK = register("red_decoration_block", new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));
	public static final RegistryObject<Block> ORANGE_DECORATION_BLOCK = register("orange_decoration_block", new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> YELLOW_DECORATION_BLOCK = register("yellow_decoration_block", new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));
	public static final RegistryObject<Block> LIME_DECORATION_BLOCK = register("lime_decoration_block", new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));
	public static final RegistryObject<Block> GREEN_DECORATION_BLOCK = register("green_decoration_block", new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));
	public static final RegistryObject<Block> CYAN_DECORATION_BLOCK = register("cyan_decoration_block", new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> BLUE_DECORATION_BLOCK = register("blue_decoration_block", new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> LIGHT_BLUE_DECORATION_BLOCK = register("light_blue_decoration_block", new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> PURPLE_DECORATION_BLOCK = register("purple_decoration_block", new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> MAGENTA_DECORATION_BLOCK = register("magenta_decoration_block", new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> PINK_DECORATION_BLOCK = register("pink_decoration_block", new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> BROWN_DECORATION_BLOCK = register("brown_decoration_block", new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> GREY_DECORATION_BLOCK = register("grey_decoration_block", new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> LIGHT_GREY_DECORATION_BLOCK = register("light_grey_decoration_block", new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> WHITE_DECORATION_BLOCK = register("white_decoration_block", new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> BLACK_DECORATION_BLOCK = register("black_decoration_block", new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));

	//Thatch
	public static final RegistryObject<Block> THATCH_BLOCK = register("thatch_block", new HayBlock(AbstractBlock.Properties.copy(Blocks.HAY_BLOCK)));
	
	//Doors
	public static final RegistryObject<Block> OUTDOOR_TOILET_DOOR = register("outdoor_toilet_door", new DoorBlock(AbstractBlock.Properties.copy(Blocks.OAK_DOOR)));
	public static final RegistryObject<Block> GLASS_SHOP_DOOR = register("glass_shop_door", new DoorBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_DOOR)));	
	public static final RegistryObject<Block> VISITOR_CENTRE_DOOR = register("visitor_centre_door", new DoorBlock(AbstractBlock.Properties.copy(Blocks.OAK_DOOR)));	
	public static final RegistryObject<Block> INNOVATION_CENTRE_DOOR = register("innovation_centre_door", new DoorBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_DOOR)));
	public static final RegistryObject<Block> SECURITY_DOOR = register("security_door", new DoorBlock(AbstractBlock.Properties.copy(Blocks.IRON_DOOR)));
	public static final RegistryObject<Block> BACK_DOOR = register("back_door", new DoorBlock(AbstractBlock.Properties.copy(Blocks.IRON_DOOR)));
	
	//Registry
	public static RegistryObject<Block> register(String id, Block block)
	{
		return BLOCK_REGISTRY.register(id, () -> block);
	}
	
	public static RegistryObject<Block> registerSmall(String id, NonNullSupplier<? extends EntityType<? extends AbstractPrehistoricAnimalEntity>> entity)
	{
		return register(id + "_egg", new SmallEggBlock(AbstractBlock.Properties.copy(Blocks.TURTLE_EGG), () -> entity.get()));
	}
	
	public static RegistryObject<Block> registerMedium(String id, NonNullSupplier<? extends EntityType<? extends BasePrehistoricEntity>> entity)
	{
		return register(id + "_egg", new MediumEggBlock(AbstractBlock.Properties.copy(Blocks.TURTLE_EGG), () -> entity.get()));
	}
	
	public static RegistryObject<Block> registerLarge(String id, NonNullSupplier<? extends EntityType<? extends AbstractPrehistoricAnimalEntity>> entity)
	{
		return register(id + "_egg", new LargeEgg(AbstractBlock.Properties.copy(Blocks.TURTLE_EGG), () -> entity.get()));
	}
}
