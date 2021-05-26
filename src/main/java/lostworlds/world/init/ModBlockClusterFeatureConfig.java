package lostworlds.world.init;

import lostworlds.core.init.BlockInit;
import lostworlds.core.util.ModBlockStates;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;

public class ModBlockClusterFeatureConfig 
{
	public static final BlockClusterFeatureConfig DEFAULT_PERMAIN_DESERT_CONFIG_SMALL = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlockStates.SMALL_PERMIAN_DESERT_PLANT), SimpleBlockPlacer.INSTANCE)).tries(11).build();
	public static final BlockClusterFeatureConfig DEFAULT_PERMAIN_DESERT_CONFIG_MEDIUM = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlockStates.MEDIUM_PERMIAN_DESERT_PLANT), SimpleBlockPlacer.INSTANCE)).tries(9).build();
	public static final BlockClusterFeatureConfig DEFAULT_PERMAIN_DESERT_CONFIG_LARGE = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlockStates.LARGE_PERMIAN_DESERT_PLANT), SimpleBlockPlacer.INSTANCE)).tries(4).build();
	
	public static final BlockClusterFeatureConfig DEFAULT_DICKSONIA = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlockStates.DICKSONIA), SimpleBlockPlacer.INSTANCE)).tries(16).build();
	public static final BlockClusterFeatureConfig DEFAULT_TALL_DICKSONIA = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlockStates.TALL_DICKSONIA), new DoublePlantBlockPlacer())).tries(16).noProjection().build();
	
	public static final BlockClusterFeatureConfig DEFAULT_GROUND_FERNS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlockStates.GROUND_FERNS), SimpleBlockPlacer.INSTANCE)).tries(16).build();
	public static final BlockClusterFeatureConfig DEFAULT_FERNS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.FERN.defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(16).build();

	public static final BlockClusterFeatureConfig DEFAULT_CYCAD_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.CYCAD.get().defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(16).build();

	public static final BlockClusterFeatureConfig DEFAULT_OSMUNDA_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.OSMUNDA.get().defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(16).build();

	public static final BlockClusterFeatureConfig DEFAULT_DUISBERGIA_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.DUISBERGIA.get().defaultBlockState()), new DoublePlantBlockPlacer())).tries(16).noProjection().build();

	public static final BlockClusterFeatureConfig DEFAULT_CEPHALOTAXUS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.CEPHALOTAXUS.get().defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(16).build();

	public static final BlockClusterFeatureConfig DEFAULT_LYCOPHYTA_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.LYCOPHYTA.get().defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(16).build();

	public static final BlockClusterFeatureConfig DEFAULT_DILLHOFFIA_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.DILLHOFFIA.get().defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(16).build();
}
