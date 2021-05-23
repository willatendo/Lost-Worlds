package lostworlds.common.blocks;

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
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.tileentity.FurnaceTileEntity;
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
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

@SuppressWarnings("deprecation")
public class FossilCleanerBlock extends Block implements ITileEntityProvider
{
	private static final DirectionProperty HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;
	private static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D);
	public static final BooleanProperty ON = ModBlockStateProperties.ON;
	
	public FossilCleanerBlock(Properties properties) 
	{
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(HORIZONTAL_FACING, Direction.NORTH).setValue(ON, false));
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) 
	{
		return SHAPE;
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
		return super.getStateForPlacement(context).setValue(HORIZONTAL_FACING, context.getHorizontalDirection().getOpposite());
	}
	
	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) 
	{
		super.createBlockStateDefinition(builder);
		builder.add(HORIZONTAL_FACING);
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
	
	public void openContainer(World world, BlockPos pos, PlayerEntity player) 
	{
		TileEntity tileentity = world.getBlockEntity(pos);
		if(tileentity instanceof FurnaceTileEntity) 
		{
			player.openMenu((INamedContainerProvider)tileentity);
			player.awardStat(Stats.INTERACT_WITH_FURNACE);
		}
	}
	
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
	
	public void onRemove(BlockState state, World world, BlockPos pos, BlockState newState, boolean b) 
	{
		if(!state.is(newState.getBlock())) 
		{
			TileEntity tileentity = world.getBlockEntity(pos);
			if(tileentity instanceof AbstractFurnaceTileEntity) 
			{
				InventoryHelper.dropContents(world, pos, (AbstractFurnaceTileEntity)tileentity);
				((AbstractFurnaceTileEntity)tileentity).getRecipesToAwardAndPopExperience(world, Vector3d.atCenterOf(pos));
				world.updateNeighbourForOutputSignal(pos, this);
			}
			
			super.onRemove(state, world, pos, newState, b);
		}
	}
	
	public boolean hasAnalogOutputSignal(BlockState state) 
	{
		return true;
	}
	
	public int getAnalogOutputSignal(BlockState state, World world, BlockPos pos) 
	{
		return Container.getRedstoneSignalFromBlockEntity(world.getBlockEntity(pos));
	}
	
	public BlockRenderType getRenderShape(BlockState state) 
	{
		return BlockRenderType.MODEL;
	}
	
	@Override
	public TileEntity newBlockEntity(IBlockReader blockReader) 
	{
		return new FurnaceTileEntity();
	}
}
