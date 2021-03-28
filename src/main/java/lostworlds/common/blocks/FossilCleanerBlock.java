package lostworlds.common.blocks;

import java.util.HashMap;
import java.util.Map;

import lostworlds.common.tileentity.FossilCleanerTileEntity;
import lostworlds.core.init.TileEntityInit;
import lostworlds.core.util.FossilCleanerItemHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class FossilCleanerBlock extends Block
{
	public static final DirectionProperty HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;
	protected static final Map<Block, Map<Direction, VoxelShape>> SHAPES = new HashMap<Block, Map<Direction, VoxelShape>>();
	public static final BooleanProperty CLEANING = BooleanProperty.create("cleaning");
	public static final VoxelShape VOXEL_SHAPE = Block.box(1, 0, 1, 15, 8, 16);
	
	public FossilCleanerBlock(Properties properties) 
	{
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(HORIZONTAL_FACING, Direction.NORTH).setValue(CLEANING, false));
		
		runCalculation(VOXEL_SHAPE);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) 
	{
		return SHAPES.get(this).get(state.getValue(HORIZONTAL_FACING));
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) 
	{
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) 
	{
		return TileEntityInit.FOSSIL_CLEANER_TILE_ENTITY.get().create();
	}
	
	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) 
	{
		super.createBlockStateDefinition(builder);
		builder.add(HORIZONTAL_FACING, CLEANING);
	}
	
	@SuppressWarnings("deprecation")
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
	
	@Override
	public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity player, ItemStack stack) 
	{
		super.setPlacedBy(worldIn, pos, state, player, stack);
		
		if(stack.hasCustomHoverName())
		{
			TileEntity tile = worldIn.getBlockEntity(pos);
			if(tile instanceof FossilCleanerTileEntity)
			{
				((FossilCleanerTileEntity) tile).setCustomName(stack.getDisplayName());
			}
		}
	}
	
	@Override
	public boolean hasAnalogOutputSignal(BlockState state) 
	{
		return true;
	}
	
	@Override
	public int getAnalogOutputSignal(BlockState state, World worldIn, BlockPos pos) 
	{
		return Container.getRedstoneSignalFromBlockEntity(worldIn.getBlockEntity(pos));
	}
	
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerEntity, Hand hand, BlockRayTraceResult hit) 
	{
		if(worldIn != null && !worldIn.isClientSide)
		{
			TileEntity tile = worldIn.getBlockEntity(pos);
			if(tile instanceof FossilCleanerTileEntity)
			{
				NetworkHooks.openGui((ServerPlayerEntity) playerEntity, (INamedContainerProvider) tile, pos);
				return ActionResultType.SUCCESS;
			}
		}
		return ActionResultType.SUCCESS;
	}
	
	@Override
	public void onPlace(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) 
	{
		TileEntity tile = worldIn.getBlockEntity(pos);
		if(tile instanceof FossilCleanerTileEntity && state.getBlock() != newState.getBlock())
		{
			FossilCleanerTileEntity cleaner = (FossilCleanerTileEntity) tile;
			((FossilCleanerItemHandler) cleaner.getInventory()).toNonNullList().forEach(item -> 
			{
				ItemEntity itemEntity = new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), item);
				worldIn.addFreshEntity(itemEntity);
			});
		}
		
		if(state.hasTileEntity() && state.getBlock() != newState.getBlock())
		{
			worldIn.removeBlockEntity(pos);
		}
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

	protected void runCalculation(VoxelShape shape) 
	{
		SHAPES.put(this, new HashMap<Direction, VoxelShape>());
		Map<Direction, VoxelShape> facingMap = SHAPES.get(this);
		for (Direction direction : Direction.values()) 
		{
			facingMap.put(direction, calculateShapes(direction, shape));
		}
	}
}
