package lostworlds.world.init;

import lostworlds.core.util.registry.ModRegistry;
import lostworlds.world.surfacebuilders.VolcanoSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;

public class SurfaceBuilderInit 
{
	@SuppressWarnings("rawtypes")
	public static final SurfaceBuilder NAKED_VOLCANO_SURFACE_BUILDER = new VolcanoSurfaceBuilder(SurfaceBuilderConfig.CODEC);
	
	@SuppressWarnings("unchecked")
	public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> VOLCANO_SURFACE_BUILDER = ModRegistry.SURFACE_BUILDER_REGISTRY.register("volcano_surface_builder", () -> NAKED_VOLCANO_SURFACE_BUILDER);
	
	//Registry
	public static void initSurfaceBuilders() { }
}
