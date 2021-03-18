package lostworlds.world.init;

import java.util.function.Supplier;

import lostworlds.core.util.registry.ModRegistry;
import lostworlds.world.surface_builder.VolcanoSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;

public class SurfaceBuilderInit 
{
	public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> VOLCANO_SURFACE_BUILDER = registerSurfaceBuilder("honey_surface_builder", () -> new VolcanoSurfaceBuilder(SurfaceBuilderConfig.field_237203_a_));

    public static <S extends SurfaceBuilder<?>> RegistryObject<S> registerSurfaceBuilder(String name, Supplier<? extends S> surfaceBuilder) 
    {
        return ModRegistry.SURFACE_BUILDER_REGISTRY.register(name, surfaceBuilder);
    }
}
