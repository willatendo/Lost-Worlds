package library.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

public class SurfacePlaceFeature extends Feature<SurfacePlaceConfig>
{
	public SurfacePlaceFeature(Codec<SurfacePlaceConfig> codec) 
	{
		super(codec);
	}
	
	@Override
	public boolean place(ISeedReader seedReader, ChunkGenerator chunkGenerator, Random rand, BlockPos pos, SurfacePlaceConfig config) 
	{
		if(seedReader.getBlockState(pos).is(config.target.getBlock())) 
		{
			BlockState state = seedReader.getBlockState(pos.above());
			if(state.is(Blocks.AIR))
			{
				seedReader.setBlock(pos, config.state, 2);
			}
		}
		return true;
	}
}
