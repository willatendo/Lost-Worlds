package lostworlds.world.init;

import lostworlds.core.init.BlockInit;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ModSurfaceBuilders 
{
	public static final SurfaceBuilderConfig VOLCANO_SURFACE_BUILDER_CONFIG = new SurfaceBuilderConfig(BlockInit.VOLCANIC_ASH.get().defaultBlockState(), BlockInit.VOLCANIC_ROCK.get().defaultBlockState(), BlockInit.VOLCANIC_ROCK.get().defaultBlockState());
	public static final SurfaceBuilderConfig PERMIAN_DESERT_CONFIG = new SurfaceBuilderConfig(BlockInit.PERMIAN_SAND.get().defaultBlockState(), BlockInit.PERMIAN_SAND.get().defaultBlockState(), BlockInit.PERMIAN_SAND.get().defaultBlockState());
	public static final SurfaceBuilderConfig GRAVEL_TERRAIN_CONFIG = new SurfaceBuilderConfig(Blocks.GRAVEL.defaultBlockState(), Blocks.GRAVEL.defaultBlockState(), Blocks.GRAVEL.defaultBlockState());
	public static final SurfaceBuilderConfig DIRT_TERRAIN_CONFIG = new SurfaceBuilderConfig(Blocks.DIRT.defaultBlockState(), Blocks.DIRT.defaultBlockState(), Blocks.SAND.defaultBlockState());
	public static final SurfaceBuilderConfig PERMIAN_MOUNTAIN_CONFIG = new SurfaceBuilderConfig(BlockInit.PERMIAN_STONE.get().defaultBlockState(), BlockInit.PERMIAN_STONE.get().defaultBlockState(), BlockInit.PERMIAN_STONE.get().defaultBlockState());
	public static final SurfaceBuilderConfig JURASSIC_STONE_MOUNTAIN_CONFIG = new SurfaceBuilderConfig(BlockInit.JURASSIC_STONE.get().defaultBlockState(), BlockInit.JURASSIC_STONE.get().defaultBlockState(), BlockInit.JURASSIC_STONE.get().defaultBlockState());
	public static final SurfaceBuilderConfig JURASSIC_ERRODED_MOUNTAIN_CONFIG = new SurfaceBuilderConfig(BlockInit.JURASSIC_STONE.get().defaultBlockState(), BlockInit.JURASSIC_STONE.get().defaultBlockState(), BlockInit.JURASSIC_STONE.get().defaultBlockState());
	public static final SurfaceBuilderConfig JURASSIC_MOSSY_MOUNTAIN_CONFIG = new SurfaceBuilderConfig(BlockInit.MOSSY_JURASSIC_STONE.get().defaultBlockState(), BlockInit.JURASSIC_STONE.get().defaultBlockState(), BlockInit.MOSSY_JURASSIC_STONE.get().defaultBlockState());
	public static final SurfaceBuilderConfig PERMIAN_FLOOD_BASALT_CONFIG = new SurfaceBuilderConfig(Blocks.BASALT.defaultBlockState(), Blocks.BASALT.defaultBlockState(), Blocks.BASALT.defaultBlockState());
	
	public static final ConfiguredSurfaceBuilder<SurfaceBuilderConfig> VOLCANO_SURFACE_BUILDER = SurfaceBuilder.DEFAULT.configured(VOLCANO_SURFACE_BUILDER_CONFIG);	
	public static final ConfiguredSurfaceBuilder<SurfaceBuilderConfig> PERMIAN_DESERT_SURFACE_BUILDER = SurfaceBuilder.DEFAULT.configured(PERMIAN_DESERT_CONFIG);	
	public static final ConfiguredSurfaceBuilder<SurfaceBuilderConfig> PERMIAN_MOUNTAIN_SURFACE_BUILDER = SurfaceBuilder.DEFAULT.configured(PERMIAN_MOUNTAIN_CONFIG);	
	public static final ConfiguredSurfaceBuilder<SurfaceBuilderConfig> JURASSIC_ERRODED_MOUNTAIN_SURFACE_BUILDER = SurfaceBuilder.DEFAULT.configured(JURASSIC_ERRODED_MOUNTAIN_CONFIG);	
	public static final ConfiguredSurfaceBuilder<SurfaceBuilderConfig> DIRT_TERRAIN_SURFACE_BUILDER = SurfaceBuilder.DEFAULT.configured(DIRT_TERRAIN_CONFIG);	
	public static final ConfiguredSurfaceBuilder<SurfaceBuilderConfig> PERMIAN_FLOOD_BASALT_SURFACE_BUILDER = SurfaceBuilder.DEFAULT.configured(PERMIAN_FLOOD_BASALT_CONFIG);	
	public static final ConfiguredSurfaceBuilder<SurfaceBuilderConfig> GRAVEL_TERRAIN_SURFACE_BUILDER = SurfaceBuilder.DEFAULT.configured(GRAVEL_TERRAIN_CONFIG);	
}
	