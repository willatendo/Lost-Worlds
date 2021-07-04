package lostworlds.library.biome;

import lostworlds.content.server.init.BlockInit;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ModSurfaceBuilders 
{
	public static final SurfaceBuilderConfig PERMIAN_SAND_CONFIG = new SurfaceBuilderConfig(BlockInit.PERMIAN_SAND.defaultBlockState(), BlockInit.PERMIAN_SAND.defaultBlockState(), BlockInit.PERMIAN_SAND.defaultBlockState());
	public static final SurfaceBuilderConfig DRIED_SOIL_CONFIG = new SurfaceBuilderConfig(BlockInit.DRIED_SOIL.defaultBlockState(), BlockInit.DRIED_SOIL.defaultBlockState(), BlockInit.DRIED_SOIL.defaultBlockState());
	public static final SurfaceBuilderConfig CRACKED_SOIL_CONFIG = new SurfaceBuilderConfig(BlockInit.CRACKED_SOIL.defaultBlockState(), BlockInit.CRACKED_SOIL.defaultBlockState(), BlockInit.CRACKED_SOIL.defaultBlockState());
	
	public static final ConfiguredSurfaceBuilder<SurfaceBuilderConfig> PERMIAN_DESERT_SURFACE_BUILDER = SurfaceBuilder.DEFAULT.configured(PERMIAN_SAND_CONFIG);
	public static final ConfiguredSurfaceBuilder<SurfaceBuilderConfig> PERMIAN_DRIED_PLAINS_SURFACE_BUILDER = SurfaceBuilder.DEFAULT.configured(DRIED_SOIL_CONFIG);
}
