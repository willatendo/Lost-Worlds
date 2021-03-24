package lostworlds.world.surfacebuilders;

import lostworlds.core.init.BlockInit;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ModSurfaceBuilders 
{
	public static final SurfaceBuilderConfig VOLCANO_SURFACE_BUILDER = new SurfaceBuilderConfig(BlockInit.VOLCANIC_ASH.get().defaultBlockState(), BlockInit.VOLCANIC_ROCK.get().defaultBlockState(), BlockInit.VOLCANIC_ROCK.get().defaultBlockState());
}
