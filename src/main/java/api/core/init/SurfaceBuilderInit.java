package api.core.init;

import library.Init;
import library.ModRegistry;
import library.surfacebuilders.JurassicMountainSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;

@Init
public class SurfaceBuilderInit extends ModRegistry
{
	public static final SurfaceBuilder NAKED_JURASSIC_MOUNTAIN = new JurassicMountainSurfaceBuilder(SurfaceBuilderConfig.CODEC);
	
	public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> JURASSIC_MOUNTAIN = SURFACE_BUILDER_REGISTRY.register("jurassic_mountain", () -> NAKED_JURASSIC_MOUNTAIN);
	
	//Registry
	public static void initSurfaceBuilders() { }
}
