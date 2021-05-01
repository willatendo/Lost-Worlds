package lostworlds.world.init;

import lostworlds.core.util.ModBlockStates;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;

public class ModBlockClusterFeatureConfig 
{
	public static final BlockClusterFeatureConfig DEFAULT_PERMAIN_DESERT_CONFIG_SMALL = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlockStates.SMALL_PERMIAN_DESERT_PLANT), SimpleBlockPlacer.INSTANCE)).tries(11).build();
	public static final BlockClusterFeatureConfig DEFAULT_PERMAIN_DESERT_CONFIG_MEDIUM = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlockStates.MEDIUM_PERMIAN_DESERT_PLANT), SimpleBlockPlacer.INSTANCE)).tries(9).build();
	public static final BlockClusterFeatureConfig DEFAULT_PERMAIN_DESERT_CONFIG_LARGE = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlockStates.LARGE_PERMIAN_DESERT_PLANT), SimpleBlockPlacer.INSTANCE)).tries(4).build();
	
	public static final BlockClusterFeatureConfig DEFAULT_DICKSONIA = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlockStates.DICKSONIA), SimpleBlockPlacer.INSTANCE)).tries(32).build();
	public static final BlockClusterFeatureConfig DEFAULT_TALL_DICKSONIA = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlockStates.TALL_DICKSONIA), new DoublePlantBlockPlacer())).tries(64).noProjection().build();
	public static final BlockClusterFeatureConfig DEFAULT_PERMIAN_GROUND_FERNS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlockStates.PERMIAN_GROUND_FERNS), SimpleBlockPlacer.INSTANCE)).tries(32).build();
}
