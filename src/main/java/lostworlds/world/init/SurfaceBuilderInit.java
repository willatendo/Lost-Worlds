package lostworlds.world.init;

import lostworlds.core.util.registry.ModRegistry;
import lostworlds.world.surfacebuilders.FloodBasaltPlainsSurfaceBuilder;
import lostworlds.world.surfacebuilders.PermianDesertSurfaceBuilder;
import lostworlds.world.surfacebuilders.VolcanoSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;

@SuppressWarnings({"rawtypes", "unchecked"})
public class SurfaceBuilderInit 
{
	public static final SurfaceBuilder NAKED_VOLCANO_SURFACE_BUILDER = new VolcanoSurfaceBuilder(SurfaceBuilderConfig.CODEC);
	public static final SurfaceBuilder NAKED_PERMIAN_DESERT_SURFACE_BUILDER = new PermianDesertSurfaceBuilder(SurfaceBuilderConfig.CODEC);
	public static final SurfaceBuilder NAKED_FLOOD_BASALT_SURFACE_BUILDER = new FloodBasaltPlainsSurfaceBuilder(SurfaceBuilderConfig.CODEC);
	
	public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> VOLCANO_SURFACE_BUILDER = ModRegistry.SURFACE_BUILDER_REGISTRY.register("volcano_surface_builder", () -> NAKED_VOLCANO_SURFACE_BUILDER);
	public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> PERMIAN_DESERT_SURFACE_BUILDER = ModRegistry.SURFACE_BUILDER_REGISTRY.register("permian_desert_surface_builder", () -> NAKED_PERMIAN_DESERT_SURFACE_BUILDER);
	public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> FLOOD_BASALT_SURFACE_BUILDER = ModRegistry.SURFACE_BUILDER_REGISTRY.register("flood_basalt_surface_builder", () -> NAKED_FLOOD_BASALT_SURFACE_BUILDER);
	
	//Registry
	public static void initSurfaceBuilders() { }
}
