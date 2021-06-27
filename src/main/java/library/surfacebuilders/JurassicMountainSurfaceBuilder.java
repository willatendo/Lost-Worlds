package library.surfacebuilders;

import java.util.Random;

import com.mojang.serialization.Codec;

import api.core.init.ModSurfaceBuilders;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class JurassicMountainSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> 
{
	public JurassicMountainSurfaceBuilder(Codec<SurfaceBuilderConfig> codec) 
	{
		super(codec);
	}
	
	@Override
	public void apply(Random rand, IChunk iChunk, Biome biome, int i1, int i2, int i3, double d, BlockState state1, BlockState state2, int i4, long l, SurfaceBuilderConfig config) 
	{
		SurfaceBuilder.DEFAULT.apply(rand, iChunk, biome, i1, i2, i3, d, state1, state2, i4, l, ModSurfaceBuilders.JURASSIC_STONE_MOUNTAIN_CONFIG);
	}
}