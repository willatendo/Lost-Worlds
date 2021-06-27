package library.feature.blockplacer;

import java.util.Random;

import com.mojang.serialization.Codec;

import library.blocks.bases.TriplePlantBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.blockplacer.BlockPlacer;
import net.minecraft.world.gen.blockplacer.BlockPlacerType;

public class TriplePlantBlockPlacer extends BlockPlacer 
{
	public static final Codec<TriplePlantBlockPlacer> CODEC;
	public static final TriplePlantBlockPlacer INSTANCE = new TriplePlantBlockPlacer();
	
	protected BlockPlacerType<?> type() 
	{
		return BlockPlacerType.DOUBLE_PLANT_PLACER;
	}
	
	public void place(IWorld world, BlockPos pos, BlockState state, Random rand) 
	{
		((TriplePlantBlock)state.getBlock()).placeAt(world, pos, 2);
	}
	
	static 
	{
		CODEC = Codec.unit(() -> 
		{
			return INSTANCE;
		});
	}
}