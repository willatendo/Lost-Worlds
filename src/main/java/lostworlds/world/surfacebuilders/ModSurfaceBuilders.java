package lostworlds.world.surfacebuilders;

import lostworlds.core.init.BlockInit;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.MountainSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ModSurfaceBuilders 
{
	public static final SurfaceBuilderConfig VOLCANO_SURFACE_BUILDER = new SurfaceBuilderConfig(BlockInit.VOLCANIC_ASH.get().getDefaultState(), BlockInit.VOLCANIC_ROCK.get().getDefaultState(), BlockInit.VOLCANIC_ROCK.get().getDefaultState());
	public static final SurfaceBuilder<SurfaceBuilderConfig> VOLCANO = register("volcano", new MountainSurfaceBuilder(SurfaceBuilderConfig.field_237203_a_));
	
	@SuppressWarnings("deprecation")
	private static <C extends ISurfaceBuilderConfig, F extends SurfaceBuilder<C>> F register(String key, F builderIn) 
	{
	      return Registry.register(Registry.SURFACE_BUILDER, key, builderIn);
	   }
}
