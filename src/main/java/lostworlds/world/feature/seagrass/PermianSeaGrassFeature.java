package lostworlds.world.feature.seagrass;

import java.util.Random;

import com.mojang.serialization.Codec;

import lostworlds.core.util.ModBlockStates;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class PermianSeaGrassFeature extends Feature<ProbabilityConfig> 
{
	public PermianSeaGrassFeature(Codec<ProbabilityConfig> codec) 
	{
		super(codec);
	}
	
	public boolean place(ISeedReader seed, ChunkGenerator chunkGenerator, Random rand, BlockPos pos, ProbabilityConfig config) 
	{
		boolean flag = false;
		int i = rand.nextInt(8) - rand.nextInt(8);
		int j = rand.nextInt(8) - rand.nextInt(8);
		int k = seed.getHeight(Heightmap.Type.OCEAN_FLOOR, pos.getX() + i, pos.getZ() + j);
		BlockPos blockpos = new BlockPos(pos.getX() + i, k, pos.getZ() + j);
		if(seed.getBlockState(blockpos).is(Blocks.WATER)) 
		{
			boolean flag1 = rand.nextDouble() < (double)config.probability;
			BlockState blockstate = ModBlockStates.PERMIAN_SEAGRASS;
			if(blockstate.canSurvive(seed, blockpos)) 
			{
				if(flag1) 
				{
					BlockPos blockpos1 = blockpos.above();
					if(seed.getBlockState(blockpos1).is(Blocks.WATER)) 
					{
						seed.setBlock(blockpos, blockstate, 2);
					}
				} 
				else 
				{
					seed.setBlock(blockpos, blockstate, 2);
				}
				flag = true;
			}
		}
		return flag;
	}
}
