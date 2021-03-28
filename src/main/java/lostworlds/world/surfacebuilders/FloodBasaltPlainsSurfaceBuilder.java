package lostworlds.world.surfacebuilders;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class FloodBasaltPlainsSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> 
{
	public FloodBasaltPlainsSurfaceBuilder(Codec<SurfaceBuilderConfig> codec) 
	{
		super(codec);
	}
	
	@Override
	public void apply(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) 
	{
		SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, ModSurfaceBuilders.FLOOD_BASALT_PLAINS);
	}
}
