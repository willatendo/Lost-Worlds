package lostworlds.core.init;

import lostworlds.core.util.registry.ModRegistry;
import lostworlds.world.surfacebuilders.JurassicMountainSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class SurfaceBuilderInit 
{
	public static final SurfaceBuilder NAKED_JURASSIC_MOUNTAIN = new JurassicMountainSurfaceBuilder(SurfaceBuilderConfig.CODEC);
	
	public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> JURASSIC_MOUNTAIN = ModRegistry.SURFACE_BUILDER_REGISTRY.register("jurassic_mountain", () -> NAKED_JURASSIC_MOUNTAIN);
	
	//Registry
	public static void initSurfaceBuilders() { }
}
