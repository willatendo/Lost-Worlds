package lostworlds.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.material.PushReaction;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class PlasteredFossilBlock extends Block implements IWaterLoggable
{
	private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	private static final VoxelShape SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D);
	
	public PlasteredFossilBlock(Properties properties) 
	{
		super(properties);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) 
	{
		return SHAPE;
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) 
	{
		FluidState fluidstate = context.getWorld().getFluidState(context.getPos());
		boolean flag = fluidstate.getFluid() == Fluids.WATER;
		return super.getStateForPlacement(context).with(WATERLOGGED, Boolean.valueOf(flag));
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) 
	{
		super.fillStateContainer(builder);
		builder.add(WATERLOGGED);
	}
	
	@Override
	public PushReaction getPushReaction(BlockState state) 
	{
		return PushReaction.DESTROY;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) 
	{
		if (stateIn.get(WATERLOGGED)) 
		{
			worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
		}
		
		return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}
	 
	@SuppressWarnings("deprecation")
	@Override
	public FluidState getFluidState(BlockState state) 
	{
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}
	
	@Override
	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) 
	{
		return false;
	}
}