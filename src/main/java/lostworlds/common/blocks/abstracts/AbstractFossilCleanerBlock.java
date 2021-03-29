package lostworlds.common.blocks.abstracts;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.Container;
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
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public abstract class AbstractFossilCleanerBlock extends ContainerBlock
{
	public static final DirectionProperty HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final BooleanProperty ON = BooleanProperty.create("on");

	public AbstractFossilCleanerBlock(Properties properties) 
	{
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(HORIZONTAL_FACING, Direction.NORTH).setValue(ON, Boolean.valueOf(false)));
	}
	
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerEntity, Hand handIn, BlockRayTraceResult hit) 
	{
		if (worldIn.isClientSide) 
		{
			return ActionResultType.SUCCESS;
		} 
		else 
		{
			this.openContainer(worldIn, pos, playerEntity);
			return ActionResultType.CONSUME;
		}
	}
	
	protected abstract void openContainer(World worldIn, BlockPos pos, PlayerEntity playerEntity);
	
	public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity enitity, ItemStack stack) 
	{
		if(stack.hasCustomHoverName()) 
		{
			TileEntity tileentity = worldIn.getBlockEntity(pos);
			if (tileentity instanceof AbstractFurnaceTileEntity) 
			{
				((AbstractFurnaceTileEntity)tileentity).setCustomName(stack.getHoverName());
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public void onRemove(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean bool) 
	{
		if (!state.is(newState.getBlock())) 
		{
			TileEntity tileentity = worldIn.getBlockEntity(pos);
			if (tileentity instanceof AbstractFurnaceTileEntity) 
			{
				InventoryHelper.dropContents(worldIn, pos, (AbstractFurnaceTileEntity)tileentity);
				((AbstractFurnaceTileEntity)tileentity).getRecipesToAwardAndPopExperience(worldIn, Vector3d.atCenterOf(pos));
				worldIn.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, worldIn, pos, newState, bool);
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
	
	public BlockState rotate(BlockState state, Rotation rot) 
	{
		return state.setValue(HORIZONTAL_FACING, rot.rotate(state.getValue(HORIZONTAL_FACING)));
	}
	
	@SuppressWarnings("deprecation")
	public BlockState mirror(BlockState state, Mirror mirror) 
	{
		return state.rotate(mirror.getRotation(state.getValue(HORIZONTAL_FACING)));
	}
	
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> state) 
	{
		state.add(HORIZONTAL_FACING, ON);
	}
}
