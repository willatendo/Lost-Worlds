package lostworlds.common.blocks;

import java.util.Random;

import lostworlds.core.init.BlockInit;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IForgeShearable;

public class MediumPermianDesertPlant extends BushBlock implements IGrowable, IForgeShearable
{
	protected static final VoxelShape VOXEL_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);

	public MediumPermianDesertPlant(Properties properties) 
	{
		super(properties);
	}
	
	protected boolean mayPlaceOn(BlockState state, IBlockReader blockReader, BlockPos pos) 
	{
		Block block = state.getBlock();
		
		return block.is(BlockInit.PERMIAN_SAND.get());
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader blockReader, BlockPos pos, ISelectionContext context) 
	{
		return VOXEL_SHAPE;
	}
	
	@Override
	public boolean isValidBonemealTarget(IBlockReader blockReader, BlockPos pos, BlockState state, boolean bool) 
	{
		return true;
	}

	@Override
	public boolean isBonemealSuccess(World worldIn, Random rand, BlockPos pos, BlockState state) 
	{
		return true;
	}

	@Override
	public void performBonemeal(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) 
	{
		DoublePlantBlock doubleplantblock = (DoublePlantBlock)(this == Blocks.FERN ? Blocks.LARGE_FERN : Blocks.TALL_GRASS);
		if (doubleplantblock.defaultBlockState().canSurvive(worldIn, pos) && worldIn.isEmptyBlock(pos.above())) 
		{
			doubleplantblock.placeAt(worldIn, pos, 2);
		}
	}
	
	public AbstractBlock.OffsetType getOffsetType() 
	{
		return AbstractBlock.OffsetType.XYZ;
	}
}
