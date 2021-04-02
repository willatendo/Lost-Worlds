package lostworlds.world.init;

import lostworlds.core.util.registry.ModRegistry;
import lostworlds.world.surfacebuilders.FloodBasaltPlainsSurfaceBuilder;
import lostworlds.world.surfacebuilders.OilSandsSurfaceBuilder;
import lostworlds.world.surfacebuilders.PermianDesertSurfaceBuilder;
import lostworlds.world.surfacebuilders.PermianMountainsSurfaceBuilder;
import lostworlds.world.surfacebuilders.PermianPlainsSurfaceBuilder;
import lostworlds.world.surfacebuilders.VolcanoSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;

@SuppressWarnings({"rawtypes", "unchecked"})
public class SurfaceBuilderInit 
{
	public static final SurfaceBuilder NAKED_VOLCANO_SURFACE_BUILDER = new VolcanoSurfaceBuilder(SurfaceBuilderConfig.CODEC);
	public static final SurfaceBuilder NAKED_OIL_SANDS_SURFACE_BUILDER = new OilSandsSurfaceBuilder(SurfaceBuilderConfig.CODEC);
	public static final SurfaceBuilder NAKED_PERMIAN_DESERT_SURFACE_BUILDER = new PermianDesertSurfaceBuilder(SurfaceBuilderConfig.CODEC);
	public static final SurfaceBuilder NAKED_FLOOD_BASALT_SURFACE_BUILDER = new FloodBasaltPlainsSurfaceBuilder(SurfaceBuilderConfig.CODEC);
	public static final SurfaceBuilder NAKED_PERMIAN_PLAINS_SURFACE_BUILDER = new PermianPlainsSurfaceBuilder(SurfaceBuilderConfig.CODEC);
	public static final SurfaceBuilder NAKED_PERMIAN_MOUNTAIN_SURFACE_BUILDER = new PermianMountainsSurfaceBuilder(SurfaceBuilderConfig.CODEC);
	
	public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> VOLCANO_SURFACE_BUILDER = ModRegistry.SURFACE_BUILDER_REGISTRY.register("volcano_surface_builder", () -> NAKED_VOLCANO_SURFACE_BUILDER);
	public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> OIL_SANDS_SURFACE_BUILDER = ModRegistry.SURFACE_BUILDER_REGISTRY.register("oil_sands_surface_builder", () -> NAKED_OIL_SANDS_SURFACE_BUILDER);
	public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> PERMIAN_DESERT_SURFACE_BUILDER = ModRegistry.SURFACE_BUILDER_REGISTRY.register("permian_desert_surface_builder", () -> NAKED_PERMIAN_DESERT_SURFACE_BUILDER);
	public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> FLOOD_BASALT_SURFACE_BUILDER = ModRegistry.SURFACE_BUILDER_REGISTRY.register("flood_basalt_surface_builder", () -> NAKED_FLOOD_BASALT_SURFACE_BUILDER);
	public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> PERMIAN_PLAINS_SURFACE_BUILDER = ModRegistry.SURFACE_BUILDER_REGISTRY.register("permian_plains_surface_builder", () -> NAKED_PERMIAN_PLAINS_SURFACE_BUILDER);
	public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> PERMIAN_MOUNTAIN_SURFACE_BUILDER = ModRegistry.SURFACE_BUILDER_REGISTRY.register("permian_mountian_surface_builder", () -> NAKED_PERMIAN_MOUNTAIN_SURFACE_BUILDER);
	
	//Registry
	public static void initSurfaceBuilders() { }
}
