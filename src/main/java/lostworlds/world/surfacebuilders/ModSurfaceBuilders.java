package lostworlds.world.surfacebuilders;

import lostworlds.core.init.BlockInit;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ModSurfaceBuilders 
{
	public static final SurfaceBuilderConfig VOLCANO_SURFACE_BUILDER = new SurfaceBuilderConfig(BlockInit.VOLCANIC_ASH.get().defaultBlockState(), BlockInit.VOLCANIC_ROCK.get().defaultBlockState(), BlockInit.VOLCANIC_ROCK.get().defaultBlockState());
	public static final SurfaceBuilderConfig PERMIAN_DESERT = new SurfaceBuilderConfig(BlockInit.PERMIAN_SAND.get().defaultBlockState(), BlockInit.PERMIAN_SAND.get().defaultBlockState(), BlockInit.PERMIAN_SAND.get().defaultBlockState());
	public static final SurfaceBuilderConfig FLOOD_BASALT_PLAINS = new SurfaceBuilderConfig(BlockInit.VOLCANIC_ROCK.get().defaultBlockState(), BlockInit.VOLCANIC_ROCK.get().defaultBlockState(), BlockInit.VOLCANIC_ROCK.get().defaultBlockState());
}
