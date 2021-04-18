package lostworlds.world.surfacebuilders;

import lostworlds.core.init.BlockInit;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ModSurfaceBuilders 
{
	public static final SurfaceBuilderConfig VOLCANO_SURFACE_BUILDER = new SurfaceBuilderConfig(BlockInit.VOLCANIC_ASH.get().defaultBlockState(), BlockInit.VOLCANIC_ROCK.get().defaultBlockState(), BlockInit.VOLCANIC_ROCK.get().defaultBlockState());
	public static final SurfaceBuilderConfig PERMIAN_DESERT = new SurfaceBuilderConfig(BlockInit.PERMIAN_SAND.get().defaultBlockState(), BlockInit.PERMIAN_SAND.get().defaultBlockState(), BlockInit.PERMIAN_SAND.get().defaultBlockState());
	public static final SurfaceBuilderConfig FLOOD_BASALT_PLAINS = new SurfaceBuilderConfig(BlockInit.VOLCANIC_ROCK.get().defaultBlockState(), BlockInit.VOLCANIC_ROCK.get().defaultBlockState(), BlockInit.VOLCANIC_ROCK.get().defaultBlockState());
	public static final SurfaceBuilderConfig PERMIAN_PLAINS = new SurfaceBuilderConfig(Blocks.DIRT.defaultBlockState(), Blocks.DIRT.defaultBlockState(), Blocks.SAND.defaultBlockState());
	public static final SurfaceBuilderConfig PERMIAN_MOUNTAIN = new SurfaceBuilderConfig(BlockInit.PERMIAN_STONE.get().defaultBlockState(), BlockInit.PERMIAN_STONE.get().defaultBlockState(), BlockInit.PERMIAN_STONE.get().defaultBlockState());
}
