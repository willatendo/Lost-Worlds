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

public class PlasteredStoneFossilBlock extends Block implements IWaterLoggable
{
	private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	private static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D);
	
	public PlasteredStoneFossilBlock(Properties properties) 
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
		FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
		boolean flag = fluidstate.getType() == Fluids.WATER;
		return super.getStateForPlacement(context).setValue(WATERLOGGED, Boolean.valueOf(flag));
	}
	
	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) 
	{
		super.createBlockStateDefinition(builder);
		builder.add(WATERLOGGED);
	}
	
	@Override
	public PushReaction getPistonPushReaction(BlockState state) 
	{
		return PushReaction.DESTROY;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) 
	{
		if (stateIn.getValue(WATERLOGGED)) 
		{
			worldIn.getLiquidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
		}
		
		return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}
	 
	@SuppressWarnings("deprecation")
	@Override
	public FluidState getFluidState(BlockState state) 
	{
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}
	
	@Override
	public boolean isPathfindable(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) 
	{
		return false;
	}
}