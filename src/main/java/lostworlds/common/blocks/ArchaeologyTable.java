package lostworlds.common.blocks;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class ArchaeologyTable extends Block implements IWaterLoggable
{
	private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	protected static final Map<Block, Map<Direction, VoxelShape>> SHAPES = new HashMap<Block, Map<Direction, VoxelShape>>();
	public static final DirectionProperty HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;
	
	private static final VoxelShape VOXEL_SHAPE = Block.makeCuboidShape(0, 0, 2, 16, 14, 16);

	public ArchaeologyTable(Properties properties) 
	{
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH).with(WATERLOGGED, Boolean.valueOf(false)));
		
		runCalculation(VOXEL_SHAPE);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) 
	{
		return SHAPES.get(this).get(state.get(HORIZONTAL_FACING));
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) 
	{
		return state.rotate(mirrorIn.toRotation(state.get(HORIZONTAL_FACING)));
	}

	@Override
	public BlockState rotate(BlockState state, IWorld world, BlockPos pos, Rotation direction) 
	{
		return state.with(HORIZONTAL_FACING, direction.rotate(state.get(HORIZONTAL_FACING)));
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) 
	{
		FluidState fluidstate = context.getWorld().getFluidState(context.getPos());
		boolean flag = fluidstate.getFluid() == Fluids.WATER;
		return this.getDefaultState().with(WATERLOGGED, Boolean.valueOf(flag)).with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) 
	{
		super.fillStateContainer(builder);
		builder.add(HORIZONTAL_FACING, WATERLOGGED);
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
	
	protected static VoxelShape calculateShapes(Direction to, VoxelShape shape) 
	{
		VoxelShape[] buffer = new VoxelShape[] { shape, VoxelShapes.empty() };

		int times = (to.getHorizontalIndex() - Direction.NORTH.getHorizontalIndex() + 4) % 4;
		for (int i = 0; i < times; i++) 
		{
			buffer[0].forEachBox((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = VoxelShapes.or(buffer[1],
					VoxelShapes.create(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)));
			buffer[0] = buffer[1];
			buffer[1] = VoxelShapes.empty();
		}

		return buffer[0];
	}

	protected void runCalculation(VoxelShape shape) {
		SHAPES.put(this, new HashMap<Direction, VoxelShape>());
		Map<Direction, VoxelShape> facingMap = SHAPES.get(this);
		for (Direction direction : Direction.values()) {
			facingMap.put(direction, calculateShapes(direction, shape));
		}
	}	
}
