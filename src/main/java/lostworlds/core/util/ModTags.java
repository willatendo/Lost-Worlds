package lostworlds.core.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag.INamedTag;
import net.minecraft.tags.ITagCollectionSupplier;
import net.minecraft.tags.TagRegistry;
import net.minecraft.tags.TagRegistryManager;

public class ModTags 
{	
	protected static final TagRegistry<Item> ITEM_HELPER = TagRegistryManager.create(ModUtil.rL("item"), ITagCollectionSupplier::getItems);
	protected static final TagRegistry<Block> BLOCK_HELPER = TagRegistryManager.create(ModUtil.rL("block"), ITagCollectionSupplier::getBlocks);
	
	//Items
	public static class Items
	{
		public static final INamedTag<Item> ALLOSAURUS_FOSSILS = itemTag("allosaurus_fossils");
		public static final INamedTag<Item> ARAUCARIA_LOGS = itemTag("araucaria_logs");
		public static final INamedTag<Item> BLOOD_SYRINGES = itemTag("blood_syringes");
		public static final INamedTag<Item> BLOOD_VILES = itemTag("blood_viles");
		public static final INamedTag<Item> CARNOTAURUS_FOSSILS = itemTag("carnotaurus_fossils");
		public static final INamedTag<Item> CHILESAURUS_FOSSILS = itemTag("chilesaurus_fossils");
		public static final INamedTag<Item> CONIFER_LOGS = itemTag("conifer_logs");
		public static final INamedTag<Item> CRYOLOPHOSAURUS_FOSSILS = itemTag("cryolophosaurus_fossils");
		public static final INamedTag<Item> DIICTODON_FOSSILS = itemTag("diictodon_fossils");
		public static final INamedTag<Item> DIMETRODON_FOSSILS = itemTag("dimetrodon_fossils");
		public static final INamedTag<Item> DNA_DISCS = itemTag("dna_discs");
		public static final INamedTag<Item> DNA = itemTag("dna");
		public static final INamedTag<Item> EDAPHOSAURUS_FOSSILS = itemTag("edaphosaurus_fossils");
		public static final INamedTag<Item> FOOD_SEEDS = itemTag("food_seeds");
		public static final INamedTag<Item> FUKUIVENATOR_FOSSILS = itemTag("fukuivenator_fossils");
		public static final INamedTag<Item> GIGANOTOSAURUS_FOSSILS = itemTag("giganotosaurus_fossils");
		public static final INamedTag<Item> GINKGO_LOGS = itemTag("ginkgo_logs");
		public static final INamedTag<Item> GORGONOPS_FOSSILS = itemTag("gorgonops_fossils");
		public static final INamedTag<Item> GREAT_AUK_FOSSILS = itemTag("great_auk_fossils");
		public static final INamedTag<Item> KENTROSAURUS_FOSSILS = itemTag("kentrosaurus_fossils");
		public static final INamedTag<Item> LIAONINGOSAURUS_FOSSILS = itemTag("liaoningosaurus_fossils");
		public static final INamedTag<Item> OSTROMIA_FOSSILS = itemTag("ostromia_fossils");
		public static final INamedTag<Item> OURANOSAURUS_FOSSILS = itemTag("ouranosaurus_fossils");
		public static final INamedTag<Item> PALAEONISCUM_FOSSILS = itemTag("palaeoniscum_fossils");
		public static final INamedTag<Item> PROCOMPSOGNATHUS_FOSSILS = itemTag("procompsognathus_fossils");
		public static final INamedTag<Item> PROTOSUCHUS_FOSSILS = itemTag("protosuchus_fossils");
		public static final INamedTag<Item> PSITTACOSAURUS_FOSSILS = itemTag("psittacosaurus_fossils");
		public static final INamedTag<Item> RHINESUCHUS_FOSSILS = itemTag("rhinesuchus_fossils");
		public static final INamedTag<Item> SOFT_TISSUE = itemTag("soft_tissue");
		public static final INamedTag<Item> SUCHOMIMUS_FOSSILS = itemTag("suchomimus_fossils");
		public static final INamedTag<Item> TETRACERATOPS_FOSSILS = itemTag("tetraceratops_fossils");
		public static final INamedTag<Item> TIME_BOOKS = itemTag("time_books");
		public static final INamedTag<Item> TYRANNOSAURUS_FOSSILS = itemTag("tyrannosaurus_fossils");
		public static final INamedTag<Item> UTAHRAPTOR_FOSSILS = itemTag("utahraptor_fossils");
		public static final INamedTag<Item> ZEPHYROSAURUS_FOSSILS = itemTag("zephyrosaurus_fossils");
	}
	
	//Blocks
	public static class Blocks
	{
		public static final INamedTag<Block> ARAUCARIA_LOGS = blockTag("araucaria_logs");
		public static final INamedTag<Block> CONIFER_LOGS = blockTag("conifer_logs");
		public static final INamedTag<Block> DARK_CONCRETE = blockTag("dark_concrete");
		public static final INamedTag<Block> DECORATION_BLOCKS = blockTag("decoration_blocks");
		public static final INamedTag<Block> DECORATIVE_DOORS = blockTag("decorative_doors");
		public static final INamedTag<Block> DINO_BREAKABLES = blockTag("dino_breakables");
		public static final INamedTag<Block> FOSSILS = blockTag("fossils");
		public static final INamedTag<Block> GINKGO_LOGS = blockTag("ginkgo_logs");
		public static final INamedTag<Block> GLASS = blockTag("glass");
		public static final INamedTag<Block> LIGHT_CONCRETE = blockTag("light_concrete");
		public static final INamedTag<Block> PAVEMENTS = blockTag("pavements");
		public static final INamedTag<Block> REFINED_WOODEN_PLANKS = blockTag("refined_wooden_planks");
		public static final INamedTag<Block> ROADS = blockTag("roads");
		public static final INamedTag<Block> WOODEN_PLANKS = blockTag("wooden_planks");
	}
	
	private static INamedTag<Item> itemTag(String id)
	{
		return ITEM_HELPER.bind(id);
	}
	
	private static INamedTag<Block> blockTag(String id)
	{
		return BLOCK_HELPER.bind(id);
	}
}
