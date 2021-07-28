package lostworlds.content.datagen;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;

import lostworlds.content.server.init.BlockInit;
import lostworlds.content.server.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTable.Builder;
import net.minecraft.loot.LootTableManager;
import net.minecraft.loot.ValidationTracker;
import net.minecraft.loot.conditions.RandomChance;
import net.minecraft.loot.functions.ApplyBonus;
import net.minecraft.util.ResourceLocation;

public class BlockLootTableGen extends LootTableProvider
{
	private static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
	
	public BlockLootTableGen(DataGenerator generator) 
	{
		super(generator);
	}
	
	@Override
	protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootParameterSet>> getTables() 
	{
		return ImmutableList.of(Pair.of(ModBlockLootTables::new, LootParameterSets.BLOCK));
	}
	
	@Override
	protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker) 
	{
		map.forEach((rL, lT) -> LootTableManager.validate(validationtracker, rL, lT));
	}
	
	public static class ModBlockLootTables extends BlockLootTables
	{
		@Override
		protected void addTables() 
		{
			dropSelf(BlockInit.ANALYSER);
			dropSelf(BlockInit.ARAUCARIA_BUTTON);
			this.add(BlockInit.ARAUCARIA_DOOR, BlockLootTables::createDoorTable);
			dropSelf(BlockInit.ARAUCARIA_FENCE);
			dropSelf(BlockInit.ARAUCARIA_FENCE_GATE);
			add(BlockInit.ARAUCARIA_LEAVES, (block) -> 
			{
				return createLeavesDrops(block, BlockInit.ARAUCARIA_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES);
			});
			dropSelf(BlockInit.ARAUCARIA_LOG);
			dropSelf(BlockInit.ARAUCARIA_PLANKS);
			dropSelf(BlockInit.ARAUCARIA_PRESSURE_PLATE);
			dropSelf(BlockInit.ARAUCARIA_SAPLING);
			this.add(BlockInit.ARAUCARIA_SLAB, BlockLootTables::createSlabItemTable);
			dropSelf(BlockInit.ARAUCARIA_STAIRS);
			dropSelf(BlockInit.ARAUCARIA_TRAPDOOR);
			dropSelf(BlockInit.ARAUCARIA_WOOD);
			dropSelf(BlockInit.ARCHAEOLOGY_TABLE);
			this.add(BlockInit.BACK_DOOR, BlockLootTables::createDoorTable);
			this.add(BlockInit.BASALT_DIAMOND_ORE, (block) ->
			{
				return createOreDrop(block, Items.DIAMOND);
			});
			dropSelf(BlockInit.BLACK_DECORATION_BLOCK);
			dropWhenSilkTouch(BlockInit.BLACK_GLASS);
			dropWhenSilkTouch(BlockInit.BLACK_GLASS_PANE);
			dropSelf(BlockInit.BLUE_DECORATION_BLOCK);
			dropWhenSilkTouch(BlockInit.BLUE_GLASS);
			dropWhenSilkTouch(BlockInit.BLUE_GLASS_PANE);
			dropSelf(BlockInit.BROWN_DECORATION_BLOCK);
			dropWhenSilkTouch(BlockInit.BROWN_GLASS);
			dropWhenSilkTouch(BlockInit.BROWN_GLASS_PANE);
			this.add(BlockInit.CEPHALOTAXUS, (block) ->
			{
				return createAncientPlantDrop(block, ItemInit.CEPHALOTAXUS_SEEDS);
			});
			dropWhenSilkTouch(BlockInit.CLEAR_GLASS);
			dropWhenSilkTouch(BlockInit.CLEAR_GLASS_PANE);
			dropSelf(BlockInit.CONIFER_BUTTON);
			this.add(BlockInit.CONIFER_DOOR, BlockLootTables::createDoorTable);
			dropSelf(BlockInit.CONIFER_FENCE);
			dropSelf(BlockInit.CONIFER_FENCE_GATE);
			add(BlockInit.CONIFER_LEAVES, (block) -> 
			{
				return createLeavesDrops(block, BlockInit.CONIFER_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES);
			});
			dropSelf(BlockInit.CONIFER_LOG);
			dropSelf(BlockInit.CONIFER_PLANKS);
			dropSelf(BlockInit.CONIFER_PRESSURE_PLATE);
			dropSelf(BlockInit.CONIFER_SAPLING);
			this.add(BlockInit.CONIFER_SLAB, BlockLootTables::createSlabItemTable);
			dropSelf(BlockInit.CONIFER_STAIRS);
			dropSelf(BlockInit.CONIFER_TRAPDOOR);
			dropSelf(BlockInit.CONIFER_WOOD);
			dropSelf(BlockInit.COPPER_ORE);
			dropSelf(BlockInit.CRACKED_SOIL);
			dropSelf(BlockInit.CYAN_DECORATION_BLOCK);
			dropWhenSilkTouch(BlockInit.CYAN_GLASS);
			dropWhenSilkTouch(BlockInit.CYAN_GLASS_PANE);
			this.add(BlockInit.CYCAD, (block) ->
			{
				return createAncientPlantDrop(block, ItemInit.CYCAD_SEEDS);
			});
			dropSelf(BlockInit.DARK_CONCRETE);
			dropSelf(BlockInit.DARK_CONCRETE_BUTTON);
			dropSelf(BlockInit.DARK_CONCRETE_PRESSURE_PLATE);
			this.add(BlockInit.DARK_CONCRETE_SLAB, BlockLootTables::createSlabItemTable);
			dropSelf(BlockInit.DARK_CONCRETE_STAIRS);
			dropSelf(BlockInit.DARK_CONCRETE_WALL);
			this.add(BlockInit.DEAD_LARGE_PERMIAN_SHRUB, (block) ->
			{
				return createAncientPlantDrop(block, Items.STICK);
			});
			this.add(BlockInit.DEAD_PERMIAN_SHRUB, (block) ->
			{
				return createAncientPlantDrop(block, Items.STICK);
			});
			dropSelf(BlockInit.DEAD_SPONGE_COLONY);
			//Diictodon Burrow
			dropSelf(BlockInit.GINKGO_BUTTON);
			this.add(BlockInit.GINKGO_DOOR, BlockLootTables::createDoorTable);
			dropSelf(BlockInit.GINKGO_FENCE);
			dropSelf(BlockInit.GINKGO_FENCE_GATE);
			add(BlockInit.GINKGO_LEAVES, (block) -> 
			{
				return createLeavesDrops(block, BlockInit.GINKGO_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES);
			});
			dropSelf(BlockInit.GINKGO_LOG);
			dropSelf(BlockInit.GINKGO_PLANKS);
			dropSelf(BlockInit.GINKGO_PRESSURE_PLATE);
			dropSelf(BlockInit.GINKGO_SAPLING);
			this.add(BlockInit.GINKGO_SLAB, BlockLootTables::createSlabItemTable);
			dropSelf(BlockInit.GINKGO_STAIRS);
			dropSelf(BlockInit.GINKGO_TRAPDOOR);
			dropSelf(BlockInit.GINKGO_WOOD);
		}
		
		protected static LootTable.Builder createAncientPlantDrop(Block plant, Item drop) 
		{
			return createShearsDispatchTable(plant, applyExplosionDecay(plant, ItemLootEntry.lootTableItem(drop).when(RandomChance.randomChance(0.125F)).apply(ApplyBonus.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 2))));
		}
	}
}
