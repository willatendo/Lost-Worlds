package lostworlds.world.surfacebuilders;

import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ModConfiguredSurfaceBuilders 
{
	public static final ConfiguredSurfaceBuilder<SurfaceBuilderConfig> VOLCANO = register("volcano", ModSurfaceBuilders.VOLCANO.func_242929_a(ModSurfaceBuilders.VOLCANO_SURFACE_BUILDER));
	
	private static <SC extends ISurfaceBuilderConfig> ConfiguredSurfaceBuilder<SC> register(String id, ConfiguredSurfaceBuilder<SC> builder) 
	{
		return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER, id, builder);
	}
}
