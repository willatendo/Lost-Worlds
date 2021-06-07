package lostworlds.common.blocks.abstracts;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

import lostworlds.common.blocks.RotateableBlock;
import lostworlds.core.util.ModBlockStateProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

@SuppressWarnings("deprecation")
public abstract class AbstractMachineBlock extends RotateableBlock implements ITileEntityProvider
{
	protected static final Map<Block, Map<Direction, VoxelShape>> SHAPES = new HashMap<Block, Map<Direction, VoxelShape>>();
	public static final DirectionProperty HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final BooleanProperty ON = ModBlockStateProperties.ON;
	
	public AbstractMachineBlock(Properties properties) 
	{
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(ON, Boolean.valueOf(false)).setValue(HORIZONTAL_FACING, Direction.NORTH));
	}	
	
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) 
	{
		return state.rotate(mirrorIn.getRotation(state.getValue(HORIZONTAL_FACING)));
	}

	@Override
	public BlockState rotate(BlockState state, IWorld world, BlockPos pos, Rotation direction) 
	{
		return state.setValue(HORIZONTAL_FACING, direction.rotate(state.getValue(HORIZONTAL_FACING)));
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) 
	{
		return this.defaultBlockState().setValue(HORIZONTAL_FACING, context.getHorizontalDirection().getOpposite());
	}
	
	protected static VoxelShape calculateShapes(Direction to, VoxelShape shape) 
	{
		VoxelShape[] buffer = new VoxelShape[] { shape, VoxelShapes.empty() };

		int times = (to.get2DDataValue() - Direction.NORTH.get2DDataValue() + 4) % 4;
		for (int i = 0; i < times; i++) 
		{
			buffer[0].forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = VoxelShapes.or(buffer[1], VoxelShapes.box(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)));
			buffer[0] = buffer[1];
			buffer[1] = VoxelShapes.empty();
		}

		return buffer[0];
	}

	@Override
	protected void runCalculation(VoxelShape shape) 
	{
		SHAPES.put(this, new HashMap<Direction, VoxelShape>());
		Map<Direction, VoxelShape> facingMap = SHAPES.get(this);
		for (Direction direction : Direction.values()) 
		{
			facingMap.put(direction, calculateShapes(direction, shape));
		}
	}	
	
	@Override
	public boolean triggerEvent(BlockState state, World world, BlockPos pos, int i1, int i2) 
	{
		super.triggerEvent(state, world, pos, i1, i2);
		TileEntity tileentity = world.getBlockEntity(pos);
		return tileentity == null ? false : tileentity.triggerEvent(i1, i2);
	}
	
	@Nullable
	@Override
	public INamedContainerProvider getMenuProvider(BlockState state, World world, BlockPos pos) 
	{
		TileEntity tileentity = world.getBlockEntity(pos);
		return tileentity instanceof INamedContainerProvider ? (INamedContainerProvider)tileentity : null;
	}
	
	@Override
	public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult result) 
	{
		if(world.isClientSide) 
		{
			return ActionResultType.SUCCESS;
		}
		else 
		{
			this.openContainer(world, pos, player);
			return ActionResultType.CONSUME;
		}
	}
	
	protected abstract void openContainer(World world, BlockPos pos, PlayerEntity player);
	
	@Override
	public void setPlacedBy(World world, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) 
	{
		if(stack.hasCustomHoverName()) 
		{
			TileEntity tileentity = world.getBlockEntity(pos);
			if(tileentity instanceof AbstractFurnaceTileEntity) 
			{
				((AbstractFurnaceTileEntity)tileentity).setCustomName(stack.getHoverName());
			}
		}
	}
	
	@Override
	public void onRemove(BlockState state, World world, BlockPos pos, BlockState newState, boolean b) 
	{
		if (!state.is(newState.getBlock())) 
		{
			TileEntity tileentity = world.getBlockEntity(pos);
			if (tileentity instanceof AbstractFurnaceTileEntity) 
			{
				InventoryHelper.dropContents(world, pos, (AbstractFurnaceTileEntity)tileentity);
				((AbstractFurnaceTileEntity)tileentity).getRecipesToAwardAndPopExperience(world, Vector3d.atCenterOf(pos));
				world.updateNeighbourForOutputSignal(pos, this);
			}
			
			super.onRemove(state, world, pos, newState, b);
		}
	}
	
	@Override
	public boolean hasAnalogOutputSignal(BlockState state) 
	{
		return true;
	}
	
	@Override
	public int getAnalogOutputSignal(BlockState state, World world, BlockPos pos) 
	{
		return Container.getRedstoneSignalFromBlockEntity(world.getBlockEntity(pos));
	}
	
	@Override
	public BlockRenderType getRenderShape(BlockState state) 
	{
		return BlockRenderType.MODEL;
	}
	
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) 
	{
		builder.add(HORIZONTAL_FACING, ON);
	}
}
