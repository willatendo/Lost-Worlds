
package lostworlds.core.init;

import lostworlds.common.blocks.ArchaeologyTable;
import lostworlds.common.blocks.BlackTerracottaFossilBlock;
import lostworlds.common.blocks.BlueTerracottaFossilBlock;
import lostworlds.common.blocks.BrownTerracottaFossilBlock;
import lostworlds.common.blocks.ConiferLog;
import lostworlds.common.blocks.CyanTerracottaFossilBlock;
import lostworlds.common.blocks.DeadSpongeColonyBlock;
import lostworlds.common.blocks.ExposedSandstoneFossilBlock;
import lostworlds.common.blocks.ExposedStoneFossilBlock;
import lostworlds.common.blocks.ExposedTerracottaFossilBlock;
import lostworlds.common.blocks.GreenTerracottaFossilBlock;
import lostworlds.common.blocks.GreyTerracottaFossilBlock;
import lostworlds.common.blocks.LargePermianDesertPlant;
import lostworlds.common.blocks.LightBlueTerracottaFossilBlock;
import lostworlds.common.blocks.LightGreyTerracottaFossilBlock;
import lostworlds.common.blocks.LimeTerracottaFossilBlock;
import lostworlds.common.blocks.MagentaTerracottaFossilBlock;
import lostworlds.common.blocks.MediumPermianDesertPlant;
import lostworlds.common.blocks.ModOreBlock;
import lostworlds.common.blocks.ModStandingSignBlock;
import lostworlds.common.blocks.ModWallSignBlock;
import lostworlds.common.blocks.OrangeTerracottaFossilBlock;
import lostworlds.common.blocks.PermianGroundFernsBlock;
import lostworlds.common.blocks.PinkTerracottaFossilBlock;
import lostworlds.common.blocks.PlasteredFossilBlock;
import lostworlds.common.blocks.PowerSupplyBlock;
import lostworlds.common.blocks.PurpleTerracottaFossilBlock;
import lostworlds.common.blocks.RedSandstoneFossilBlock;
import lostworlds.common.blocks.RedTerracottaFossilBlock;
import lostworlds.common.blocks.SandstoneFossilBlock;
import lostworlds.common.blocks.SmallPermianDesertPlant;
import lostworlds.common.blocks.SpongeColonyBlock;
import lostworlds.common.blocks.StoneFossilBlock;
import lostworlds.common.blocks.TerracottaFossilBlock;
import lostworlds.common.blocks.TimeMachineBlock;
import lostworlds.common.blocks.WhiteTerracottaFossilBlock;
import lostworlds.common.blocks.YellowTerracottaFossilBlock;
import lostworlds.common.blocks.eggs.AllosaurusEggBlock;
import lostworlds.common.blocks.eggs.CarnotaurusEggBlock;
import lostworlds.common.blocks.eggs.DimetrodonEggBlock;
import lostworlds.common.blocks.eggs.EdaphosaurusEggBlock;
import lostworlds.common.blocks.eggs.FukuivenatorEggBlock;
import lostworlds.common.blocks.eggs.GiganotosaurusEggBlock;
import lostworlds.common.blocks.eggs.GorgonopsEggBlock;
import lostworlds.common.blocks.eggs.OuranosaurusEggBlock;
import lostworlds.common.blocks.eggs.ProcompsognathusEggBlock;
import lostworlds.common.blocks.eggs.PsittacosaurusEggBlock;
import lostworlds.common.blocks.eggs.SuchomimusEggBlock;
import lostworlds.common.blocks.eggs.TetraceratopsEggBlock;
import lostworlds.common.blocks.eggs.TyrannosaurusEggBlock;
import lostworlds.core.util.ModMaterials;
import lostworlds.core.util.ModToolType;
import lostworlds.core.util.ModWoodType;
import lostworlds.core.util.registry.ModRegistry;
import lostworlds.world.feature.tree.AraucariaTree;
import lostworlds.world.feature.tree.ConiferTree;
import lostworlds.world.feature.tree.GinkgoTree;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.HayBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.OreBlock;
import net.minecraft.block.PaneBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.PressurePlateBlock.Sensitivity;
import net.minecraft.block.RedstoneOreBlock;
import net.minecraft.block.SandBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SeaGrassBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.StoneButtonBlock;
import net.minecraft.block.TallGrassBlock;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.WoodButtonBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

@SuppressWarnings("deprecation")
public class BlockInit 
{
	//Ore
	public static final RegistryObject<OreBlock> COPPER_ORE = ModRegistry.BLOCK_REGISTRY.register("copper_ore", () -> new OreBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(3.0F).sound(SoundType.STONE)));
		
	//Fossils
	public static final RegistryObject<StoneFossilBlock> STONE_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("stone_fossil", () -> new StoneFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.STONE).harvestTool(ModToolType.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<ExposedStoneFossilBlock> EXPOSED_STONE_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("exposed_stone_fossil", () -> new ExposedStoneFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(0).requiresCorrectToolForDrops().strength(1.25F).noOcclusion().sound(SoundType.STONE)));

	public static final RegistryObject<SandstoneFossilBlock> SANDSTONE_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("sandstone_fossil", () -> new SandstoneFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.SAND).requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<ExposedSandstoneFossilBlock> EXPOSED_SANDSTONE_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("exposed_sandstone_fossil", () -> new ExposedSandstoneFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.SAND).noOcclusion().requiresCorrectToolForDrops().strength(0.8F)));
	
	public static final RegistryObject<RedSandstoneFossilBlock> RED_SANDSTONE_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("red_sandstone_fossil", () -> new RedSandstoneFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<ExposedSandstoneFossilBlock> EXPOSED_RED_SANDSTONE_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("exposed_red_sandstone_fossil", () -> new ExposedSandstoneFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_ORANGE).noOcclusion().requiresCorrectToolForDrops().strength(0.8F)));
	
	public static final RegistryObject<TerracottaFossilBlock> TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("terracotta_fossil", () -> new TerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.COLOR_ORANGE).harvestTool(ModToolType.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<ExposedTerracottaFossilBlock> EXPOSED_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("exposed_terracotta_fossil", () -> new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_ORANGE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<RedTerracottaFossilBlock> RED_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("red_terracotta_fossil", () -> new RedTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_RED).harvestTool(ModToolType.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<ExposedTerracottaFossilBlock> EXPOSED_RED_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("exposed_red_terracotta_fossil", () -> new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_RED).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<OrangeTerracottaFossilBlock> ORANGE_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("orange_terracotta_fossil", () -> new OrangeTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_ORANGE).harvestTool(ModToolType.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<ExposedTerracottaFossilBlock> EXPOSED_ORANGE_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("exposed_orange_terracotta_fossil", () -> new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_ORANGE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<YellowTerracottaFossilBlock> YELLOW_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("yellow_terracotta_fossil", () -> new YellowTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_YELLOW).harvestTool(ModToolType.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<ExposedTerracottaFossilBlock> EXPOSED_YELLOW_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("exposed_yellow_terracotta_fossil", () -> new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_YELLOW).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<LimeTerracottaFossilBlock> LIME_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("lime_terracotta_fossil", () -> new LimeTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_LIGHT_GREEN).harvestTool(ModToolType.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<ExposedTerracottaFossilBlock> EXPOSED_LIME_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("exposed_lime_terracotta_fossil", () -> new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GREEN).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<GreenTerracottaFossilBlock> GREEN_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("green_terracotta_fossil", () -> new GreenTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_GREEN).harvestTool(ModToolType.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<ExposedTerracottaFossilBlock> EXPOSED_GREEN_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("exposed_green_terracotta_fossil", () -> new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_GREEN).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<CyanTerracottaFossilBlock> CYAN_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("cyan_terracotta_fossil", () -> new CyanTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_CYAN).harvestTool(ModToolType.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<ExposedTerracottaFossilBlock> EXPOSED_CYAN_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("exposed_cyan_terracotta_fossil", () -> new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_CYAN).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<LightBlueTerracottaFossilBlock> LIGHT_BLUE_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("light_blue_terracotta_fossil", () -> new LightBlueTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_LIGHT_BLUE).harvestTool(ModToolType.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<ExposedTerracottaFossilBlock> EXPOSED_LIGHT_BLUE_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("exposed_light_blue_terracotta_fossil", () -> new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_BLUE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<BlueTerracottaFossilBlock> BLUE_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("blue_terracotta_fossil", () -> new BlueTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_BLUE).harvestTool(ModToolType.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<ExposedTerracottaFossilBlock> EXPOSED_BLUE_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("exposed_blue_terracotta_fossil", () -> new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLUE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<MagentaTerracottaFossilBlock> MAGENTA_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("magenta_terracotta_fossil", () -> new MagentaTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_MAGENTA).harvestTool(ModToolType.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<ExposedTerracottaFossilBlock> EXPOSED_MAGENTA_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("exposed_magenta_terracotta_fossil", () -> new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_MAGENTA).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<PurpleTerracottaFossilBlock> PURPLE_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("purple_terracotta_fossil", () -> new PurpleTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_PURPLE).harvestTool(ModToolType.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<ExposedTerracottaFossilBlock> EXPOSED_PURPLE_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("exposed_purple_terracotta_fossil", () -> new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_PURPLE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<PinkTerracottaFossilBlock> PINK_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("pink_terracotta_fossil", () -> new PinkTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_PINK).harvestTool(ModToolType.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<ExposedTerracottaFossilBlock> EXPOSED_PINK_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("exposed_pink_terracotta_fossil", () -> new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_PINK).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<BrownTerracottaFossilBlock> BROWN_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("brown_terracotta_fossil", () -> new BrownTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_BROWN).harvestTool(ModToolType.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<ExposedTerracottaFossilBlock> EXPOSED_BROWN_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("exposed_brown_terracotta_fossil", () -> new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BROWN).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<BlackTerracottaFossilBlock> BLACK_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("black_terracotta_fossil", () -> new BlackTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_BLACK).harvestTool(ModToolType.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<ExposedTerracottaFossilBlock> EXPOSED_BLACK_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("exposed_black_terracotta_fossil", () -> new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLACK).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<GreyTerracottaFossilBlock> GREY_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("grey_terracotta_fossil", () -> new GreyTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_GRAY).harvestTool(ModToolType.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<ExposedTerracottaFossilBlock> EXPOSED_GREY_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("exposed_grey_terracotta_fossil", () -> new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_GRAY).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<LightGreyTerracottaFossilBlock> LIGHT_GREY_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("light_grey_terracotta_fossil", () -> new LightGreyTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_LIGHT_GRAY).harvestTool(ModToolType.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<ExposedTerracottaFossilBlock> EXPOSED_LIGHT_GREY_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("exposed_light_grey_terracotta_fossil", () -> new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GRAY).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	public static final RegistryObject<WhiteTerracottaFossilBlock> WHITE_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("white_terracotta_fossil", () -> new WhiteTerracottaFossilBlock(AbstractBlock.Properties.of(ModMaterials.MADE_FOR_BRUSH, MaterialColor.TERRACOTTA_WHITE).harvestTool(ModToolType.BRUSH).harvestLevel(0).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.STONE)));
	public static final RegistryObject<ExposedTerracottaFossilBlock> EXPOSED_WHITE_TERRACOTTA_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("exposed_white_terracotta_fossil", () -> new ExposedTerracottaFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_WHITE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
	
	public static final RegistryObject<PlasteredFossilBlock> PLASTERED_FOSSIL = ModRegistry.BLOCK_REGISTRY.register("plastered_fossil", () -> new PlasteredFossilBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).instabreak().sound(SoundType.WOOL).noOcclusion()));

	//Fossil Processing	
	
	
	public static final RegistryObject<PowerSupplyBlock> POWER_SUPPLY_BLOCK = ModRegistry.BLOCK_REGISTRY.register("power_supply_block", () -> new PowerSupplyBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).noOcclusion().harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(3.0F, 5.5F).sound(SoundType.STONE)));
	
	//Egg
	public static final RegistryObject<ProcompsognathusEggBlock> PROCOMPSOGNATHUS_EGG = ModRegistry.BLOCK_REGISTRY.register("procompsognathus_egg", () -> new ProcompsognathusEggBlock());
	public static final RegistryObject<DimetrodonEggBlock> DIMETRODON_EGG = ModRegistry.BLOCK_REGISTRY.register("dimetrodon_egg", () -> new DimetrodonEggBlock());
	public static final RegistryObject<EdaphosaurusEggBlock> EDAPHOSAURUS_EGG = ModRegistry.BLOCK_REGISTRY.register("edaphosaurus_egg", () -> new EdaphosaurusEggBlock());
	public static final RegistryObject<GorgonopsEggBlock> GORGONOPS_EGG = ModRegistry.BLOCK_REGISTRY.register("gorgonops_egg", () -> new GorgonopsEggBlock());
	public static final RegistryObject<CarnotaurusEggBlock> CARNOTAURUS_EGG = ModRegistry.BLOCK_REGISTRY.register("carnotaurus_egg", () -> new CarnotaurusEggBlock());
	public static final RegistryObject<TyrannosaurusEggBlock> TYRANNOSAURUS_EGG = ModRegistry.BLOCK_REGISTRY.register("tyrannosaurus_egg", () -> new TyrannosaurusEggBlock());
	public static final RegistryObject<AllosaurusEggBlock> ALLOSAURUS_EGG = ModRegistry.BLOCK_REGISTRY.register("allosaurus_egg", () -> new AllosaurusEggBlock());
	public static final RegistryObject<GiganotosaurusEggBlock> GIGANOTOSAURUS_EGG = ModRegistry.BLOCK_REGISTRY.register("giganotosaurus_egg", () -> new GiganotosaurusEggBlock());
	public static final RegistryObject<SuchomimusEggBlock> SUCHOMIMUS_EGG = ModRegistry.BLOCK_REGISTRY.register("suchomimus_egg", () -> new SuchomimusEggBlock());
	public static final RegistryObject<TetraceratopsEggBlock> TETRACERATOPS_EGG = ModRegistry.BLOCK_REGISTRY.register("tetraceratops_egg", () -> new TetraceratopsEggBlock());
	public static final RegistryObject<OuranosaurusEggBlock> OURANOSAURUS_EGG = ModRegistry.BLOCK_REGISTRY.register("ouranosaurus_egg", () -> new OuranosaurusEggBlock());
	public static final RegistryObject<FukuivenatorEggBlock> FUKUVENATOR_EGG = ModRegistry.BLOCK_REGISTRY.register("fukuivenator_egg", () -> new FukuivenatorEggBlock());
	public static final RegistryObject<PsittacosaurusEggBlock> PSITTACOSAURUS_EGG = ModRegistry.BLOCK_REGISTRY.register("psittacosaurus_egg", () -> new PsittacosaurusEggBlock());
	
	//Mud
	public static final RegistryObject<Block> MUD = ModRegistry.BLOCK_REGISTRY.register("mud", () -> new Block(AbstractBlock.Properties.of(Material.CLAY, MaterialColor.COLOR_BROWN).harvestTool(ToolType.SHOVEL).strength(0.6F).sound(SoundType.GRAVEL)));
	
	//Nesting Block
	public static final RegistryObject<Block> NESTING_BLOCK = ModRegistry.BLOCK_REGISTRY.register("nesting_block", () -> new Block(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_BROWN).harvestTool(ToolType.SHOVEL).strength(0.3F).sound(SoundType.GRASS)));

	//Time Machine
	public static final RegistryObject<TimeMachineBlock> TIME_MACHINE = ModRegistry.BLOCK_REGISTRY.register("time_machine", () -> new TimeMachineBlock(AbstractBlock.Properties.of(Material.METAL, MaterialColor.GOLD).harvestTool(ToolType.PICKAXE).harvestLevel(4).requiresCorrectToolForDrops().strength(50.0F, 1200.0F)));
	
	//Museum Stuff
	public static final RegistryObject<ArchaeologyTable> ARCHAEOLOGY_TABLE = ModRegistry.BLOCK_REGISTRY.register("archaeology_table", () -> new ArchaeologyTable(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).harvestTool(ToolType.PICKAXE).strength(2.0F, 3.0F).sound(SoundType.STONE)));

	//Volcanic Stuff
	public static final RegistryObject<Block> VOLCANIC_ROCK = ModRegistry.BLOCK_REGISTRY.register("volcanic_rock", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.GILDED_BLACKSTONE)));
	public static final RegistryObject<StairsBlock> VOLCANIC_ROCK_STAIRS = ModRegistry.BLOCK_REGISTRY.register("volcanic_rock_stairs", () -> new StairsBlock(() -> BlockInit.VOLCANIC_ROCK.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.GILDED_BLACKSTONE)));
	public static final RegistryObject<SlabBlock> VOLCANIC_ROCK_SLAB = ModRegistry.BLOCK_REGISTRY.register("volcanic_rock_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.GILDED_BLACKSTONE)));
	public static final RegistryObject<WallBlock> VOLCANIC_ROCK_WALL = ModRegistry.BLOCK_REGISTRY.register("volcanic_rock_wall", () -> new WallBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.GILDED_BLACKSTONE)));
	
	public static final RegistryObject<Block> POLISHED_VOLCANIC_ROCK = ModRegistry.BLOCK_REGISTRY.register("polished_volcanic_rock", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.GILDED_BLACKSTONE)));
	public static final RegistryObject<StairsBlock> POLISHED_VOLCANIC_ROCK_STAIRS = ModRegistry.BLOCK_REGISTRY.register("polished_volcanic_rock_stairs", () -> new StairsBlock(() -> BlockInit.POLISHED_VOLCANIC_ROCK.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.GILDED_BLACKSTONE)));
	public static final RegistryObject<SlabBlock> POLISHED_VOLCANIC_ROCK_SLAB = ModRegistry.BLOCK_REGISTRY.register("polished_volcanic_rock_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.GILDED_BLACKSTONE)));
	
	public static final RegistryObject<SandBlock> VOLCANIC_ASH = ModRegistry.BLOCK_REGISTRY.register("volcanic_ash", () -> new SandBlock(0x888988, AbstractBlock.Properties.of(Material.SAND, MaterialColor.COLOR_GRAY).harvestTool(ToolType.SHOVEL).harvestLevel(1).strength(0.5F).sound(SoundType.SAND)));	
	
	//Tunnel
	public static final RegistryObject<Block> DIICTODON_BURROW = ModRegistry.BLOCK_REGISTRY.register("diictodon_burrow", () -> new Block(AbstractBlock.Properties.of(Material.SAND, MaterialColor.SAND).harvestTool(ToolType.SHOVEL).strength(1.5F).sound(SoundType.SAND)));
	public static final RegistryObject<Block> TUNNELED_SOIL = ModRegistry.BLOCK_REGISTRY.register("tunneled_soil", () -> new Block(AbstractBlock.Properties.of(Material.DIRT, MaterialColor.DIRT).strength(0.5F).sound(SoundType.GRAVEL)));
	
	//Permian Blocks
	public static final RegistryObject<SandBlock> PERMIAN_SAND = ModRegistry.BLOCK_REGISTRY.register("permian_sand", () -> new SandBlock(0xaa915c, AbstractBlock.Properties.of(Material.SAND, MaterialColor.SAND).harvestTool(ToolType.SHOVEL).strength(1.5F).sound(SoundType.SAND)));
	
	public static final RegistryObject<Block> PERMIAN_STONE = ModRegistry.BLOCK_REGISTRY.register("permian_stone", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<StairsBlock> PERMIAN_STONE_STAIRS = ModRegistry.BLOCK_REGISTRY.register("permian_stone_stairs", () -> new StairsBlock(() -> BlockInit.PERMIAN_STONE.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<SlabBlock> PERMIAN_STONE_SLAB = ModRegistry.BLOCK_REGISTRY.register("permian_stone_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	
	public static final RegistryObject<ModOreBlock> PERMIAN_COPPER_ORE = ModRegistry.BLOCK_REGISTRY.register("permian_copper_ore", () -> new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
	public static final RegistryObject<ModOreBlock> PERMIAN_GOLD_ORE = ModRegistry.BLOCK_REGISTRY.register("permian_gold_ore", () -> new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
	public static final RegistryObject<ModOreBlock> PERMIAN_IRON_ORE = ModRegistry.BLOCK_REGISTRY.register("permian_iron_ore", () -> new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
	public static final RegistryObject<ModOreBlock> PERMIAN_COAL_ORE = ModRegistry.BLOCK_REGISTRY.register("permian_coal_ore", () -> new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
	public static final RegistryObject<ModOreBlock> PERMIAN_LAPIS_ORE = ModRegistry.BLOCK_REGISTRY.register("permian_lapis_ore", () -> new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));	
	public static final RegistryObject<ModOreBlock> PERMIAN_DIAMOND_ORE = ModRegistry.BLOCK_REGISTRY.register("permian_diamond_ore", () -> new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));	
	public static final RegistryObject<RedstoneOreBlock> PERMIAN_REDSTONE_ORE = ModRegistry.BLOCK_REGISTRY.register("permian_redstone_ore", () -> new RedstoneOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));	
	public static final RegistryObject<ModOreBlock> PERMIAN_EMERALD_ORE = ModRegistry.BLOCK_REGISTRY.register("permian_emerald_ore", () -> new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));	
	
	public static final RegistryObject<Block> PERMIAN_COBBLESTONE = ModRegistry.BLOCK_REGISTRY.register("permian_cobblestone", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<StairsBlock> PERMIAN_COBBLESTONE_STAIRS = ModRegistry.BLOCK_REGISTRY.register("permian_cobblestone_stairs", () -> new StairsBlock(() -> BlockInit.PERMIAN_STONE.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<SlabBlock> PERMIAN_COBBLESTONE_SLAB = ModRegistry.BLOCK_REGISTRY.register("permian_cobblestone_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<WallBlock> PERMIAN_COBBLESTONE_WALL = ModRegistry.BLOCK_REGISTRY.register("permian_cobblestone_wall", () -> new WallBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> PERMIAN_STONE_BRICKS = ModRegistry.BLOCK_REGISTRY.register("permian_stone_bricks", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<StairsBlock> PERMIAN_STONE_BRICK_STAIRS = ModRegistry.BLOCK_REGISTRY.register("permian_stone_brick_stairs", () -> new StairsBlock(() -> BlockInit.PERMIAN_STONE_BRICKS.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<SlabBlock> PERMIAN_STONE_BRICK_SLAB = ModRegistry.BLOCK_REGISTRY.register("permian_stone_brick_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<WallBlock> PERMIAN_STONE_BRICK_WALL = ModRegistry.BLOCK_REGISTRY.register("permian_stone_brick_wall", () -> new WallBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	
	public static final RegistryObject<SmallPermianDesertPlant> SMALL_PERMIAN_DESERT_PLANT = ModRegistry.BLOCK_REGISTRY.register("small_permian_desert_plant", () -> new SmallPermianDesertPlant(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_BROWN).noCollission().noOcclusion().strength(5.0F, 6.0F).sound(SoundType.GRASS)));
	public static final RegistryObject<MediumPermianDesertPlant> MEDIUM_PERMIAN_DESERT_PLANT = ModRegistry.BLOCK_REGISTRY.register("medium_permian_desert_plant", () -> new MediumPermianDesertPlant(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_BROWN).noCollission().noOcclusion().strength(5.0F, 6.0F).sound(SoundType.GRASS)));
	public static final RegistryObject<LargePermianDesertPlant> LARGE_PERMIAN_DESERT_PLANT = ModRegistry.BLOCK_REGISTRY.register("large_permian_desert_plant", () -> new LargePermianDesertPlant(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_BROWN).noCollission().noOcclusion().strength(5.0F, 6.0F).sound(SoundType.GRASS)));

	public static final RegistryObject<PermianGroundFernsBlock> PERMIAN_GROUND_FERNS = ModRegistry.BLOCK_REGISTRY.register("permian_ground_ferns", () -> new PermianGroundFernsBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<TallGrassBlock> DICKSONIA = ModRegistry.BLOCK_REGISTRY.register("dicksonia", () -> new TallGrassBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<DoublePlantBlock> TALL_DICKSONIA = ModRegistry.BLOCK_REGISTRY.register("tall_dicksonia", () -> new DoublePlantBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<SeaGrassBlock> PERMIAN_SEAGRASS = ModRegistry.BLOCK_REGISTRY.register("permian_seagrass", () -> new SeaGrassBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));
	
	//Jurassic Blocks
	public static final RegistryObject<Block> JURASSIC_STONE = ModRegistry.BLOCK_REGISTRY.register("jurassic_stone", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	public static final RegistryObject<StairsBlock> JURASSIC_STONE_STAIRS = ModRegistry.BLOCK_REGISTRY.register("jurassic_stone_stairs", () -> new StairsBlock(() -> BlockInit.JURASSIC_STONE.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	public static final RegistryObject<SlabBlock> JURASSIC_STONE_SLAB = ModRegistry.BLOCK_REGISTRY.register("jurassic_stone_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));

	public static final RegistryObject<ModOreBlock> JURASSIC_COPPER_ORE = ModRegistry.BLOCK_REGISTRY.register("jurassic_copper_ore", () -> new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
	public static final RegistryObject<ModOreBlock> JURASSIC_GOLD_ORE = ModRegistry.BLOCK_REGISTRY.register("jurassic_gold_ore", () -> new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
	public static final RegistryObject<ModOreBlock> JURASSIC_IRON_ORE = ModRegistry.BLOCK_REGISTRY.register("jurassic_iron_ore", () -> new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
	public static final RegistryObject<ModOreBlock> JURASSIC_COAL_ORE = ModRegistry.BLOCK_REGISTRY.register("jurassic_coal_ore", () -> new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
	public static final RegistryObject<ModOreBlock> JURASSIC_LAPIS_ORE = ModRegistry.BLOCK_REGISTRY.register("jurassic_lapis_ore", () -> new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));	
	public static final RegistryObject<ModOreBlock> JURASSIC_DIAMOND_ORE = ModRegistry.BLOCK_REGISTRY.register("jurassic_diamond_ore", () -> new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));	
	public static final RegistryObject<RedstoneOreBlock> JURASSIC_REDSTONE_ORE = ModRegistry.BLOCK_REGISTRY.register("jurassic_redstone_ore", () -> new RedstoneOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));	
	public static final RegistryObject<ModOreBlock> JURASSIC_EMERALD_ORE = ModRegistry.BLOCK_REGISTRY.register("jurassic_emerald_ore", () -> new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));		
	
	public static final RegistryObject<Block> MOSSY_JURASSIC_STONE = ModRegistry.BLOCK_REGISTRY.register("mossy_jurassic_stone", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().randomTicks().strength(3.0F)));
	public static final RegistryObject<StairsBlock> MOSSY_JURASSIC_STONE_STAIRS = ModRegistry.BLOCK_REGISTRY.register("mossy_jurassic_stone_stairs", () -> new StairsBlock(() -> BlockInit.MOSSY_JURASSIC_STONE.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	public static final RegistryObject<SlabBlock> MOSSY_JURASSIC_STONE_SLAB = ModRegistry.BLOCK_REGISTRY.register("mossy_jurassic_stone_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));

	public static final RegistryObject<Block> JURASSIC_COBBLESTONE = ModRegistry.BLOCK_REGISTRY.register("jurassic_cobblestone", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	public static final RegistryObject<StairsBlock> JURASSIC_COBBLESTONE_STAIRS = ModRegistry.BLOCK_REGISTRY.register("jurassic_cobblestone_stairs", () -> new StairsBlock(() -> BlockInit.JURASSIC_COBBLESTONE.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	public static final RegistryObject<SlabBlock> JURASSIC_COBBLESTONE_SLAB = ModRegistry.BLOCK_REGISTRY.register("jurassic_cobblestone_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	public static final RegistryObject<WallBlock> JURASSIC_COBBLESTONE_WALL = ModRegistry.BLOCK_REGISTRY.register("jurassic_cobblestone_wall", () -> new WallBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	
	public static final RegistryObject<Block> MOSSY_JURASSIC_COBBLESTONE = ModRegistry.BLOCK_REGISTRY.register("mossy_jurassic_cobblestone", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	public static final RegistryObject<StairsBlock> MOSSY_JURASSIC_COBBLESTONE_STAIRS = ModRegistry.BLOCK_REGISTRY.register("mossy_jurassic_cobblestone_stairs", () -> new StairsBlock(() -> BlockInit.MOSSY_JURASSIC_COBBLESTONE.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	public static final RegistryObject<SlabBlock> MOSSY_JURASSIC_COBBLESTONE_SLAB = ModRegistry.BLOCK_REGISTRY.register("mossy_jurassic_cobblestone_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	public static final RegistryObject<WallBlock> MOSSY_JURASSIC_COBBLESTONE_WALL = ModRegistry.BLOCK_REGISTRY.register("mossy_jurassic_cobblestone_wall", () -> new WallBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F)));
	
	public static final RegistryObject<Block> JURASSIC_STONE_BRICKS = ModRegistry.BLOCK_REGISTRY.register("jurassic_stone_bricks", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<StairsBlock> JURASSIC_STONE_BRICK_STAIRS = ModRegistry.BLOCK_REGISTRY.register("jurassic_stone_brick_stairs", () -> new StairsBlock(() -> BlockInit.JURASSIC_STONE_BRICKS.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<SlabBlock> JURASSIC_STONE_BRICK_SLAB = ModRegistry.BLOCK_REGISTRY.register("jurassic_stone_brick_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<WallBlock> JURASSIC_STONE_BRICK_WALL = ModRegistry.BLOCK_REGISTRY.register("jurassic_stone_brick_wall", () -> new WallBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> MOSSY_JURASSIC_STONE_BRICKS = ModRegistry.BLOCK_REGISTRY.register("mossy_jurassic_stone_bricks", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<StairsBlock> MOSSY_JURASSIC_STONE_BRICK_STAIRS = ModRegistry.BLOCK_REGISTRY.register("mossy_jurassic_stone_brick_stairs", () -> new StairsBlock(() -> BlockInit.MOSSY_JURASSIC_STONE_BRICKS.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<SlabBlock> MOSSY_JURASSIC_STONE_BRICK_SLAB = ModRegistry.BLOCK_REGISTRY.register("mossy_jurassic_stone_brick_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<WallBlock> MOSSY_JURASSIC_STONE_BRICK_WALL = ModRegistry.BLOCK_REGISTRY.register("mossy_jurassic_stone_brick_wall", () -> new WallBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
	
	//Sponge Colony
	public static final RegistryObject<DeadSpongeColonyBlock> DEAD_SPONGE_COLONY = ModRegistry.BLOCK_REGISTRY.register("dead_sponge_colony", () -> new DeadSpongeColonyBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.STONE).noOcclusion().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<SpongeColonyBlock> SPONGE_COLONY = ModRegistry.BLOCK_REGISTRY.register("sponge_colony", () -> new SpongeColonyBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().noOcclusion().strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK), BlockInit.DEAD_SPONGE_COLONY.get()));

	//Conifer
	public static final RegistryObject<ConiferLog> CONIFER_LOG = ModRegistry.BLOCK_REGISTRY.register("conifer_log", () -> new ConiferLog(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<ConiferLog> STRIPPED_CONIFER_LOG = ModRegistry.BLOCK_REGISTRY.register("stripped_conifer_log", () -> new ConiferLog(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<ConiferLog> CONIFER_WOOD = ModRegistry.BLOCK_REGISTRY.register("conifer_wood", () -> new ConiferLog(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<ConiferLog> STRIPPED_CONIFER_WOOD = ModRegistry.BLOCK_REGISTRY.register("stripped_conifer_wood", () -> new ConiferLog(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<LeavesBlock> CONIFER_LEAVES = ModRegistry.BLOCK_REGISTRY.register("conifer_leaves", () -> new LeavesBlock(AbstractBlock.Properties.of(Material.LEAVES, MaterialColor.COLOR_GREEN).strength(0.3F).noOcclusion().sound(SoundType.GRASS)));
	public static final RegistryObject<SaplingBlock> CONIFER_SAPLING = ModRegistry.BLOCK_REGISTRY.register("conifer_sapling", () -> new SaplingBlock(new ConiferTree(), AbstractBlock.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> CONIFER_PLANKS = ModRegistry.BLOCK_REGISTRY.register("conifer_planks", () -> new Block(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<StairsBlock> CONIFER_STAIRS = ModRegistry.BLOCK_REGISTRY.register("conifer_stairs", () -> new StairsBlock(() -> BlockInit.CONIFER_PLANKS.get().defaultBlockState(), AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<SlabBlock> CONIFER_SLAB = ModRegistry.BLOCK_REGISTRY.register("conifer_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<FenceBlock> CONIFER_FENCE = ModRegistry.BLOCK_REGISTRY.register("conifer_fence", () -> new FenceBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<FenceGateBlock> CONIFER_FENCE_GATE = ModRegistry.BLOCK_REGISTRY.register("conifer_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<PressurePlateBlock> CONIFER_PRESSURE_PLATE = ModRegistry.BLOCK_REGISTRY.register("conifer_pressure_plate", () -> new PressurePlateBlock(Sensitivity.EVERYTHING, AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noCollission().sound(SoundType.WOOD)));
	public static final RegistryObject<WoodButtonBlock> CONIFER_BUTTON = ModRegistry.BLOCK_REGISTRY.register("conifer_button", () -> new WoodButtonBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noCollission().sound(SoundType.WOOD)));
	public static final RegistryObject<TrapDoorBlock> CONIFER_TRAPDOOR = ModRegistry.BLOCK_REGISTRY.register("conifer_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noOcclusion().sound(SoundType.WOOD)));
	public static final RegistryObject<DoorBlock> CONIFER_DOOR = ModRegistry.BLOCK_REGISTRY.register("conifer_door", () -> new DoorBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noOcclusion().sound(SoundType.WOOD)));
	public static final RegistryObject<ModStandingSignBlock> CONIFER_SIGN = ModRegistry.BLOCK_REGISTRY.register("conifer_sign", () -> new ModStandingSignBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD).noCollission(), ModWoodType.CONIFER));
	public static final RegistryObject<ModWallSignBlock> CONIFER_WALL_SIGN = ModRegistry.BLOCK_REGISTRY.register("conifer_wall_sign", () -> new ModWallSignBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD).noCollission().dropsLike(BlockInit.CONIFER_SIGN.get()), ModWoodType.CONIFER));
	
	//Ginkgo
	public static final RegistryObject<ConiferLog> GINKGO_LOG = ModRegistry.BLOCK_REGISTRY.register("ginkgo_log", () -> new ConiferLog(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_GRAY).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<ConiferLog> STRIPPED_GINKGO_LOG = ModRegistry.BLOCK_REGISTRY.register("stripped_ginkgo_log", () -> new ConiferLog(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<ConiferLog> GINKGO_WOOD = ModRegistry.BLOCK_REGISTRY.register("ginkgo_wood", () -> new ConiferLog(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<ConiferLog> STRIPPED_GINKGO_WOOD = ModRegistry.BLOCK_REGISTRY.register("stripped_ginkgo_wood", () -> new ConiferLog(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<LeavesBlock> GINKGO_LEAVES = ModRegistry.BLOCK_REGISTRY.register("ginkgo_leaves", () -> new LeavesBlock(AbstractBlock.Properties.of(Material.LEAVES, MaterialColor.COLOR_GREEN).strength(0.3F).noOcclusion().sound(SoundType.GRASS)));
	public static final RegistryObject<SaplingBlock> GINKGO_SAPLING = ModRegistry.BLOCK_REGISTRY.register("ginkgo_sapling", () -> new SaplingBlock(new GinkgoTree(), AbstractBlock.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> GINKGO_PLANKS = ModRegistry.BLOCK_REGISTRY.register("ginkgo_planks", () -> new Block(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<StairsBlock> GINKGO_STAIRS = ModRegistry.BLOCK_REGISTRY.register("ginkgo_stairs", () -> new StairsBlock(() -> BlockInit.CONIFER_PLANKS.get().defaultBlockState(), AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<SlabBlock> GINKGO_SLAB = ModRegistry.BLOCK_REGISTRY.register("ginkgo_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<FenceBlock> GINKGO_FENCE = ModRegistry.BLOCK_REGISTRY.register("ginkgo_fence", () -> new FenceBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<FenceGateBlock> GINKGO_FENCE_GATE = ModRegistry.BLOCK_REGISTRY.register("ginkgo_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<PressurePlateBlock> GINKGO_PRESSURE_PLATE = ModRegistry.BLOCK_REGISTRY.register("ginkgo_pressure_plate", () -> new PressurePlateBlock(Sensitivity.EVERYTHING, AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noCollission().sound(SoundType.WOOD)));
	public static final RegistryObject<WoodButtonBlock> GINKGO_BUTTON = ModRegistry.BLOCK_REGISTRY.register("ginkgo_button", () -> new WoodButtonBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noCollission().sound(SoundType.WOOD)));
	public static final RegistryObject<TrapDoorBlock> GINKGO_TRAPDOOR = ModRegistry.BLOCK_REGISTRY.register("ginkgo_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noOcclusion().sound(SoundType.WOOD)));
	public static final RegistryObject<DoorBlock> GINKGO_DOOR = ModRegistry.BLOCK_REGISTRY.register("ginkgo_door", () -> new DoorBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noOcclusion().sound(SoundType.WOOD)));
	public static final RegistryObject<ModStandingSignBlock> GINKGO_SIGN = ModRegistry.BLOCK_REGISTRY.register("ginkgo_sign", () -> new ModStandingSignBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD).noCollission(), ModWoodType.GINKGO));
	public static final RegistryObject<ModWallSignBlock> GINKGO_WALL_SIGN = ModRegistry.BLOCK_REGISTRY.register("ginkgo_wall_sign", () -> new ModWallSignBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD).noCollission().dropsLike(BlockInit.GINKGO_SIGN.get()), ModWoodType.GINKGO));
		
	//Araucaria
	public static final RegistryObject<ConiferLog> ARAUCARIA_LOG = ModRegistry.BLOCK_REGISTRY.register("araucaria_log", () -> new ConiferLog(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_GRAY).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<ConiferLog> STRIPPED_ARAUCARIA_LOG = ModRegistry.BLOCK_REGISTRY.register("stripped_araucaria_log", () -> new ConiferLog(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<ConiferLog> ARAUCARIA_WOOD = ModRegistry.BLOCK_REGISTRY.register("araucaria_wood", () -> new ConiferLog(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<ConiferLog> STRIPPED_ARAUCARIA_WOOD = ModRegistry.BLOCK_REGISTRY.register("stripped_araucaria_wood", () -> new ConiferLog(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<LeavesBlock> ARAUCARIA_LEAVES = ModRegistry.BLOCK_REGISTRY.register("araucaria_leaves", () -> new LeavesBlock(AbstractBlock.Properties.of(Material.LEAVES, MaterialColor.COLOR_GREEN).strength(0.3F).noOcclusion().sound(SoundType.GRASS)));
	public static final RegistryObject<SaplingBlock> ARAUCARIA_SAPLING = ModRegistry.BLOCK_REGISTRY.register("araucaria_sapling", () -> new SaplingBlock(new AraucariaTree(), AbstractBlock.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> ARAUCARIA_PLANKS = ModRegistry.BLOCK_REGISTRY.register("araucaria_planks", () -> new Block(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<StairsBlock> ARAUCARIA_STAIRS = ModRegistry.BLOCK_REGISTRY.register("araucaria_stairs", () -> new StairsBlock(() -> BlockInit.ARAUCARIA_PLANKS.get().defaultBlockState(), AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<SlabBlock> ARAUCARIA_SLAB = ModRegistry.BLOCK_REGISTRY.register("araucaria_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<FenceBlock> ARAUCARIA_FENCE = ModRegistry.BLOCK_REGISTRY.register("araucaria_fence", () -> new FenceBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<FenceGateBlock> ARAUCARIA_FENCE_GATE = ModRegistry.BLOCK_REGISTRY.register("araucaria_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<PressurePlateBlock> ARAUCARIA_PRESSURE_PLATE = ModRegistry.BLOCK_REGISTRY.register("araucaria_pressure_plate", () -> new PressurePlateBlock(Sensitivity.EVERYTHING, AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noCollission().sound(SoundType.WOOD)));
	public static final RegistryObject<WoodButtonBlock> ARAUCARIA_BUTTON = ModRegistry.BLOCK_REGISTRY.register("araucaria_button", () -> new WoodButtonBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noCollission().sound(SoundType.WOOD)));
	public static final RegistryObject<TrapDoorBlock> ARAUCARIA_TRAPDOOR = ModRegistry.BLOCK_REGISTRY.register("araucaria_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noOcclusion().sound(SoundType.WOOD)));
	public static final RegistryObject<DoorBlock> ARAUCARIA_DOOR = ModRegistry.BLOCK_REGISTRY.register("araucaria_door", () -> new DoorBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).noOcclusion().sound(SoundType.WOOD)));
	public static final RegistryObject<ModStandingSignBlock> ARAUCARIA_SIGN = ModRegistry.BLOCK_REGISTRY.register("araucaria_sign", () -> new ModStandingSignBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD).noCollission(), ModWoodType.ARAUCARIA));
	public static final RegistryObject<ModWallSignBlock> ARAUCARIA_WALL_SIGN = ModRegistry.BLOCK_REGISTRY.register("araucaria_wall_sign", () -> new ModWallSignBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(2.5F).sound(SoundType.WOOD).noCollission().dropsLike(BlockInit.ARAUCARIA_SIGN.get()), ModWoodType.ARAUCARIA));
		
	//Light Concrete
	public static final RegistryObject<Block> LIGHT_CONCRETE = ModRegistry.BLOCK_REGISTRY.register("light_concrete", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(6.0F, 8.0F).sound(SoundType.STONE)));
	public static final RegistryObject<StairsBlock> LIGHT_CONCRETE_STAIRS = ModRegistry.BLOCK_REGISTRY.register("light_concrete_stairs", () -> new StairsBlock(BlockInit.LIGHT_CONCRETE.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(6.0F, 8.0F).sound(SoundType.STONE)));
	public static final RegistryObject<SlabBlock> LIGHT_CONCRETE_SLAB = ModRegistry.BLOCK_REGISTRY.register("light_concrete_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(6.0F, 8.0F).sound(SoundType.STONE)));
	public static final RegistryObject<WallBlock> LIGHT_CONCRETE_WALL = ModRegistry.BLOCK_REGISTRY.register("light_concrete_wall", () -> new WallBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(6.0F, 8.0F).noCollission().sound(SoundType.STONE)));
	public static final RegistryObject<PressurePlateBlock> LIGHT_CONCRETE_PRESSURE_PLATE = ModRegistry.BLOCK_REGISTRY.register("light_concrete_pressure_plate", () -> new PressurePlateBlock(Sensitivity.MOBS, AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(6.0F, 8.0F).noCollission().sound(SoundType.STONE)));
	public static final RegistryObject<StoneButtonBlock> LIGHT_CONCRETE_BUTTON = ModRegistry.BLOCK_REGISTRY.register("light_concrete_button", () -> new StoneButtonBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(6.0F, 8.0F).noCollission().sound(SoundType.STONE)));

	//Polished Light Concrete
	public static final RegistryObject<Block> POLISHED_LIGHT_CONCRETE = ModRegistry.BLOCK_REGISTRY.register("polished_light_concrete", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(6.5F, 8.5F).sound(SoundType.STONE)));
	public static final RegistryObject<StairsBlock> POLISHED_LIGHT_CONCRETE_STAIRS = ModRegistry.BLOCK_REGISTRY.register("polished_light_concrete_stairs", () -> new StairsBlock(BlockInit.LIGHT_CONCRETE.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(6.5F, 8.5F).sound(SoundType.STONE)));
	public static final RegistryObject<SlabBlock> POLISHED_LIGHT_CONCRETE_SLAB = ModRegistry.BLOCK_REGISTRY.register("polished_light_concrete_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(6.5F, 8.5F).sound(SoundType.STONE)));

	//Dark Concrete
	public static final RegistryObject<Block> DARK_CONCRETE = ModRegistry.BLOCK_REGISTRY.register("dark_concrete", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(8.0F, 10.0F).sound(SoundType.STONE)));
	public static final RegistryObject<StairsBlock> DARK_CONCRETE_STAIRS = ModRegistry.BLOCK_REGISTRY.register("dark_concrete_stairs", () -> new StairsBlock(() -> BlockInit.DARK_CONCRETE.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(8.0F, 10.0F).sound(SoundType.STONE)));
	public static final RegistryObject<SlabBlock> DARK_CONCRETE_SLAB = ModRegistry.BLOCK_REGISTRY.register("dark_concrete_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(8.0F, 10.0F).sound(SoundType.STONE)));
	public static final RegistryObject<WallBlock> DARK_CONCRETE_WALL = ModRegistry.BLOCK_REGISTRY.register("dark_concrete_wall", () -> new WallBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(8.0F, 10.0F).sound(SoundType.STONE)));
	public static final RegistryObject<PressurePlateBlock> DARK_CONCRETE_PRESSURE_PLATE = ModRegistry.BLOCK_REGISTRY.register("dark_concrete_pressure_plate", () -> new PressurePlateBlock(Sensitivity.MOBS, AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(8.0F, 10.0F).noCollission().sound(SoundType.STONE)));
	public static final RegistryObject<StoneButtonBlock> DARK_CONCRETE_BUTTON = ModRegistry.BLOCK_REGISTRY.register("dark_concrete_button", () -> new StoneButtonBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(8.0F, 10.0F).noCollission().sound(SoundType.STONE)));
	
	//Polished Dark Concrete
	public static final RegistryObject<Block> POLISHED_DARK_CONCRETE = ModRegistry.BLOCK_REGISTRY.register("polished_dark_concrete", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(8.5F, 10.5F).sound(SoundType.STONE)));
	public static final RegistryObject<StairsBlock> POLISHED_DARK_CONCRETE_STAIRS = ModRegistry.BLOCK_REGISTRY.register("polished_dark_concrete_stairs", () -> new StairsBlock(() -> BlockInit.DARK_CONCRETE.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(8.5F, 10.5F).sound(SoundType.STONE)));
	public static final RegistryObject<SlabBlock> POLISHED_DARK_CONCRETE_SLAB = ModRegistry.BLOCK_REGISTRY.register("polished_dark_concrete_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(8.5F, 10.5F).sound(SoundType.STONE)));

	//Wooden Planks
	public static final RegistryObject<Block> WOODEN_PLANKS = ModRegistry.BLOCK_REGISTRY.register("wooden_planks", () -> new Block(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(1.2F, 0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<StairsBlock> WOODEN_PLANKS_STAIRS = ModRegistry.BLOCK_REGISTRY.register("wooden_planks_stairs", () -> new StairsBlock(() -> BlockInit.WOODEN_PLANKS.get().defaultBlockState(), AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(1.2F, 0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<SlabBlock> WOODEN_PLANKS_SLAB = ModRegistry.BLOCK_REGISTRY.register("wooden_planks_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(1.2F, 0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<FenceBlock> WOODEN_PLANKS_FENCE = ModRegistry.BLOCK_REGISTRY.register("wooden_planks_fence", () -> new FenceBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(1.2F, 0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<FenceGateBlock> WOODEN_PLANKS_FENCE_GATE = ModRegistry.BLOCK_REGISTRY.register("wooden_planks_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(1.2F, 0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<PressurePlateBlock> WOODEN_PLANKS_PRESSURE_PLATE = ModRegistry.BLOCK_REGISTRY.register("wooden_planks_pressure_plate", () -> new PressurePlateBlock(Sensitivity.EVERYTHING, AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(1.2F, 0.5F).noCollission().sound(SoundType.WOOD)));
	public static final RegistryObject<WoodButtonBlock> WOODEN_PLANKS_BUTTON = ModRegistry.BLOCK_REGISTRY.register("wooden_planks_button", () -> new WoodButtonBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(1.2F, 0.5F).noCollission().sound(SoundType.WOOD)));

	//Refined Wooden Planks
	public static final RegistryObject<Block> REFINED_WOODEN_PLANKS = ModRegistry.BLOCK_REGISTRY.register("refined_wooden_planks", () -> new Block(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(2.7F, 1.9F).sound(SoundType.WOOD)));
	public static final RegistryObject<StairsBlock> REFINED_WOODEN_PLANKS_STAIRS = ModRegistry.BLOCK_REGISTRY.register("refined_wooden_planks_stairs", () -> new StairsBlock(() -> BlockInit.REFINED_WOODEN_PLANKS.get().defaultBlockState(), AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(2.7F, 1.9F).sound(SoundType.WOOD)));
	public static final RegistryObject<SlabBlock> REFINED_WOODEN_PLANKS_SLAB = ModRegistry.BLOCK_REGISTRY.register("refined_wooden_planks_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(2.7F, 1.9F).sound(SoundType.WOOD)));
	public static final RegistryObject<FenceBlock> REFINED_WOODEN_PLANKS_FENCE = ModRegistry.BLOCK_REGISTRY.register("refined_wooden_planks_fence", () -> new FenceBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(2.7F, 1.9F).sound(SoundType.WOOD)));
	public static final RegistryObject<FenceGateBlock> REFINED_WOODEN_PLANKS_FENCE_GATE = ModRegistry.BLOCK_REGISTRY.register("refined_wooden_planks_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(2.7F, 1.9F).sound(SoundType.WOOD)));
	public static final RegistryObject<PressurePlateBlock> REFINED_WOODEN_PLANKS_PRESSURE_PLATE = ModRegistry.BLOCK_REGISTRY.register("refined_wooden_planks_pressure_plate", () -> new PressurePlateBlock(Sensitivity.EVERYTHING, AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(2.7F, 1.9F).noCollission().sound(SoundType.WOOD)));
	public static final RegistryObject<WoodButtonBlock> REFINED_WOODEN_PLANKS_BUTTON = ModRegistry.BLOCK_REGISTRY.register("refined_wooden_planks_button", () -> new WoodButtonBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(2.7F, 1.9F).noCollission().sound(SoundType.WOOD)));

	//Pavement
	public static final RegistryObject<Block> PAVEMENT = ModRegistry.BLOCK_REGISTRY.register("pavement", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GRAY).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(3.0F).sound(SoundType.STONE)));
	public static final RegistryObject<StairsBlock> PAVEMENT_SLOPE = ModRegistry.BLOCK_REGISTRY.register("pavement_slope", () -> new StairsBlock(() -> BlockInit.PAVEMENT.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GRAY).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(3.0F).sound(SoundType.STONE)));
	public static final RegistryObject<SlabBlock> RAISED_PAVEMENT = ModRegistry.BLOCK_REGISTRY.register("raised_pavement", () -> new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GRAY).harvestTool(ToolType.PICKAXE).harvestLevel(1).strength(3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
	
	//Roads
	public static final RegistryObject<Block> GRAVEL_ROAD = ModRegistry.BLOCK_REGISTRY.register("gravel_road", () -> new Block(AbstractBlock.Properties.of(Material.SAND, MaterialColor.TERRACOTTA_LIGHT_GRAY).harvestTool(ToolType.SHOVEL).harvestLevel(0).strength(1.5F).sound(SoundType.SAND)));
	public static final RegistryObject<SlabBlock> RAISED_GRAVEL_ROAD = ModRegistry.BLOCK_REGISTRY.register("raised_gravel_road", () -> new SlabBlock(AbstractBlock.Properties.of(Material.SAND, MaterialColor.TERRACOTTA_LIGHT_GRAY).harvestTool(ToolType.SHOVEL).harvestLevel(0).strength(1.5F).sound(SoundType.SAND)));
	
	public static final RegistryObject<Block> DIRT_ROAD = ModRegistry.BLOCK_REGISTRY.register("dirt_road", () -> new Block(AbstractBlock.Properties.of(Material.DIRT, MaterialColor.DIRT).harvestTool(ToolType.SHOVEL).harvestLevel(0).strength(1.5F).sound(SoundType.GRASS)));
	public static final RegistryObject<SlabBlock> RAISED_DIRT_ROAD = ModRegistry.BLOCK_REGISTRY.register("raised_dirt_road", () -> new SlabBlock(AbstractBlock.Properties.of(Material.DIRT, MaterialColor.DIRT).harvestTool(ToolType.SHOVEL).harvestLevel(0).strength(1.5F).sound(SoundType.GRASS)));
		
	public static final RegistryObject<Block> PAVED_ROAD = ModRegistry.BLOCK_REGISTRY.register("paved_road", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.STONE)));
	public static final RegistryObject<SlabBlock> RAISED_PAVED_ROAD = ModRegistry.BLOCK_REGISTRY.register("raised_paved_road", () -> new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.STONE)));
	
	//Tile
	public static final RegistryObject<Block> TILE = ModRegistry.BLOCK_REGISTRY.register("tile", () -> new Block(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(2.7F, 1.9F).sound(SoundType.WOOD)));
	public static final RegistryObject<StairsBlock> TILE_STAIRS = ModRegistry.BLOCK_REGISTRY.register("tile_stairs", () -> new StairsBlock(() -> BlockInit.TILE.get().defaultBlockState(), AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(2.7F, 1.9F).sound(SoundType.WOOD)));
	public static final RegistryObject<SlabBlock> TILE_SLAB = ModRegistry.BLOCK_REGISTRY.register("tile_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).harvestLevel(0).strength(2.7F, 1.9F).sound(SoundType.WOOD)));

	//Fence
	public static final RegistryObject<FenceBlock> METAL_FENCE = ModRegistry.BLOCK_REGISTRY.register("metal_fence", () -> new FenceBlock(AbstractBlock.Properties.of(Material.METAL, MaterialColor.COLOR_RED).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(4.5F, 6.0F).sound(SoundType.METAL)));

	//Clear Glass
	public static final RegistryObject<GlassBlock> CLEAR_GLASS = ModRegistry.BLOCK_REGISTRY.register("clear_glass", () -> new GlassBlock(AbstractBlock.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_WHITE).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> CLEAR_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("clear_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.of(Material.GLASS, MaterialColor.TERRACOTTA_WHITE).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	//Tinted Glass
	public static final RegistryObject<GlassBlock> TINTED_GLASS = ModRegistry.BLOCK_REGISTRY.register("tinted_glass", () -> new GlassBlock(AbstractBlock.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> TINTED_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("tinted_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.of(Material.GLASS, MaterialColor.COLOR_BROWN).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	
	//Coloured Glass
	public static final RegistryObject<GlassBlock> WHITE_GLASS = ModRegistry.BLOCK_REGISTRY.register("white_glass", () -> new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> WHITE_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("white_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<GlassBlock> LIGHT_GREY_GLASS = ModRegistry.BLOCK_REGISTRY.register("light_grey_glass", () -> new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> LIGHT_GREY_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("light_grey_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<GlassBlock> GREY_GLASS = ModRegistry.BLOCK_REGISTRY.register("grey_glass", () -> new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> GREY_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("grey_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<GlassBlock> BLACK_GLASS = ModRegistry.BLOCK_REGISTRY.register("black_glass", () -> new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> BLACK_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("black_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<GlassBlock> RED_GLASS = ModRegistry.BLOCK_REGISTRY.register("red_glass", () -> new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> RED_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("red_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<GlassBlock> ORANGE_GLASS = ModRegistry.BLOCK_REGISTRY.register("orange_glass", () -> new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> ORANGE_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("orange_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<GlassBlock> YELLOW_GLASS = ModRegistry.BLOCK_REGISTRY.register("yellow_glass", () -> new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> YELLOW_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("yellow_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<GlassBlock> LIME_GLASS = ModRegistry.BLOCK_REGISTRY.register("lime_glass", () -> new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> LIME_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("lime_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<GlassBlock> GREEN_GLASS = ModRegistry.BLOCK_REGISTRY.register("green_glass", () -> new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> GREEN_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("green_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<GlassBlock> CYAN_GLASS = ModRegistry.BLOCK_REGISTRY.register("cyan_glass", () -> new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> CYAN_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("cyan_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<GlassBlock> LIGHT_BLUE_GLASS = ModRegistry.BLOCK_REGISTRY.register("light_blue_glass", () -> new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(3.0F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> LIGHT_BLUE_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("light_blue_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<GlassBlock> BLUE_GLASS = ModRegistry.BLOCK_REGISTRY.register("blue_glass", () -> new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> BLUE_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("blue_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<GlassBlock> PURPLE_GLASS = ModRegistry.BLOCK_REGISTRY.register("purple_glass", () -> new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> PURPLE_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("purple_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<GlassBlock> MAGENTA_GLASS = ModRegistry.BLOCK_REGISTRY.register("magenta_glass", () -> new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> MAGENTA_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("magenta_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<GlassBlock> PINK_GLASS = ModRegistry.BLOCK_REGISTRY.register("pink_glass", () -> new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> PINK_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("pink_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<GlassBlock> BROWN_GLASS = ModRegistry.BLOCK_REGISTRY.register("brown_glass", () -> new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> BROWN_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("brown_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));	
	
	public static final RegistryObject<GlassBlock> SHADED_GLASS = ModRegistry.BLOCK_REGISTRY.register("shaded_glass", () -> new GlassBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<PaneBlock> SHADED_GLASS_PANE = ModRegistry.BLOCK_REGISTRY.register("shaded_glass_pane", () -> new PaneBlock(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).noOcclusion().sound(SoundType.GLASS)));
	
	//Colour Blocks
	public static final RegistryObject<Block> RED_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("red_decoration_block", () -> new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));
	public static final RegistryObject<Block> ORANGE_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("orange_decoration_block", () -> new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> YELLOW_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("yellow_decoration_block", () -> new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));
	public static final RegistryObject<Block> LIME_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("lime_decoration_block", () -> new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));
	public static final RegistryObject<Block> GREEN_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("green_decoration_block", () -> new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));
	public static final RegistryObject<Block> CYAN_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("cyan_decoration_block", () -> new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> BLUE_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("blue_decoration_block", () -> new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> LIGHT_BLUE_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("light_blue_decoration_block", () -> new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> PURPLE_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("purple_decoration_block", () -> new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> MAGENTA_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("magenta_decoration_block", () -> new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> PINK_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("pink_decoration_block", () -> new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> BROWN_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("brown_decoration_block", () -> new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> GREY_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("grey_decoration_block", () -> new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> LIGHT_GREY_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("light_grey_decoration_block", () -> new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> WHITE_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("white_decoration_block", () -> new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));	
	public static final RegistryObject<Block> BLACK_DECORATION_BLOCK = ModRegistry.BLOCK_REGISTRY.register("black_decoration_block", () -> new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));

	//Thatch
	public static final RegistryObject<HayBlock> THATCH_BLOCK = ModRegistry.BLOCK_REGISTRY.register("thatch_block", () -> new HayBlock(AbstractBlock.Properties.copy(Blocks.HAY_BLOCK)));
	
	//Doors
	public static final RegistryObject<DoorBlock> OUTDOOR_TOILET_DOOR = ModRegistry.BLOCK_REGISTRY.register("outdoor_toilet_door", () -> new DoorBlock(AbstractBlock.Properties.copy(Blocks.OAK_DOOR)));
	public static final RegistryObject<DoorBlock> GLASS_SHOP_DOOR = ModRegistry.BLOCK_REGISTRY.register("glass_shop_door", () -> new DoorBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_DOOR)));	
	public static final RegistryObject<DoorBlock> VISITOR_CENTRE_DOOR = ModRegistry.BLOCK_REGISTRY.register("visitor_centre_door", () -> new DoorBlock(AbstractBlock.Properties.copy(Blocks.OAK_DOOR)));	
	public static final RegistryObject<DoorBlock> INNOVATION_CENTRE_DOOR = ModRegistry.BLOCK_REGISTRY.register("innovation_centre_door", () -> new DoorBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_DOOR)));
	public static final RegistryObject<DoorBlock> SECURITY_DOOR = ModRegistry.BLOCK_REGISTRY.register("security_door", () -> new DoorBlock(AbstractBlock.Properties.copy(Blocks.IRON_DOOR)));
	public static final RegistryObject<DoorBlock> BACK_DOOR = ModRegistry.BLOCK_REGISTRY.register("back_door", () -> new DoorBlock(AbstractBlock.Properties.copy(Blocks.IRON_DOOR)));
	
	//Registry
	public static void initBlocks() { }
}
