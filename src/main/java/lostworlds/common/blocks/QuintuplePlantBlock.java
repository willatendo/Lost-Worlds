package lostworlds.common.blocks;

import javax.annotation.Nullable;

import lostworlds.core.util.ModBlockStateProperties;
import lostworlds.core.util.enums.QuintupleBlockHalfs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class QuintuplePlantBlock extends ModBushBlock
{
	public static final EnumProperty<QuintupleBlockHalfs> HALFS = ModBlockStateProperties.HALFS;
	
	public QuintuplePlantBlock(Properties properties) 
	{
		super(properties);
	}
	
	public BlockState updateShape(BlockState state, Direction direction, BlockState newState, IWorld world, BlockPos pos, BlockPos newPos) 
	{
		QuintupleBlockHalfs quintupleblockhalfs = state.getValue(HALFS);
		if(direction.getAxis() != Direction.Axis.Y || quintupleblockhalfs == QuintupleBlockHalfs.BOTTOM != (direction == Direction.UP) || newState.is(this) && newState.getValue(HALFS) != quintupleblockhalfs) 
		{
			return quintupleblockhalfs == QuintupleBlockHalfs.BOTTOM && direction == Direction.DOWN && !state.canSurvive(world, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, newState, world, pos, newPos);
		}
		else 
		{
			return Blocks.AIR.defaultBlockState();
		}
	}
	
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) 
	{
		BlockPos blockpos = context.getClickedPos();
		return blockpos.getY() < 255 && context.getLevel().getBlockState(blockpos.above()).canBeReplaced(context) ? super.getStateForPlacement(context) : null;
	}
	
	public void setPlacedBy(World world, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) 
	{
		world.setBlock(pos.above().above().above().above(), this.defaultBlockState().setValue(HALFS, QuintupleBlockHalfs.TOP), 3);
	}
	
	public boolean canSurvive(BlockState state, IWorldReader worldReader, BlockPos pos) 
	{
		if(state.getValue(HALFS) != QuintupleBlockHalfs.TOP) 
		{
			return super.canSurvive(state, worldReader, pos);
		}
		else 
		{
			BlockState blockstate = worldReader.getBlockState(pos.below());
			if(state.getBlock() != this)
			{
				return super.canSurvive(blockstate, worldReader, pos);
			}
			return blockstate.is(this) && blockstate.getValue(HALFS) == QuintupleBlockHalfs.BOTTOM;
		}
	}
	
	public void placeAt(IWorld world, BlockPos pos, int i) 
	{
		world.setBlock(pos, this.defaultBlockState().setValue(HALFS, QuintupleBlockHalfs.BOTTOM), i);
		world.setBlock(pos.above(), this.defaultBlockState().setValue(HALFS, QuintupleBlockHalfs.MIDDLE_BOTTOM), i);
		world.setBlock(pos.above().above(), this.defaultBlockState().setValue(HALFS, QuintupleBlockHalfs.MIDDLE_MIDDLE), i);
		world.setBlock(pos.above().above().above(), this.defaultBlockState().setValue(HALFS, QuintupleBlockHalfs.MIDDLE_TOP), i);
		world.setBlock(pos.above().above().above().above(), this.defaultBlockState().setValue(HALFS, QuintupleBlockHalfs.TOP), i);
	}
	
	public void playerWillDestroy(World world, BlockPos pos, BlockState state, PlayerEntity entity) 
	{
		if(!world.isClientSide) 
		{
			if(entity.isCreative()) 
			{
				preventCreativeDropFromBottomPart(world, pos, state, entity);
			} 
			else 
			{
				dropResources(state, world, pos, (TileEntity)null, entity, entity.getMainHandItem());
			}
		}
		
		super.playerWillDestroy(world, pos, state, entity);
	}
	
	public void playerDestroy(World world, PlayerEntity entity, BlockPos pos, BlockState state, @Nullable TileEntity tileEntity, ItemStack stack) 
	{
		super.playerDestroy(world, entity, pos, Blocks.AIR.defaultBlockState(), tileEntity, stack);
	}
	
	protected static void preventCreativeDropFromBottomPart(World world, BlockPos pos, BlockState state, PlayerEntity entity) 
	{
		QuintupleBlockHalfs quintupleblockhalfs = state.getValue(HALFS);
		if(quintupleblockhalfs == QuintupleBlockHalfs.TOP) 
		{
			BlockPos blockpos = pos.below();
			BlockState blockstate = world.getBlockState(blockpos);
			if(blockstate.getBlock() == state.getBlock() && blockstate.getValue(HALFS) == QuintupleBlockHalfs.MIDDLE_TOP) 
			{
				world.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 35);
				world.levelEvent(entity, 2001, blockpos.below(), Block.getId(blockstate));
			}
			if(blockstate.getBlock() == state.getBlock() && blockstate.getValue(HALFS) == QuintupleBlockHalfs.MIDDLE_MIDDLE) 
			{
				world.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 35);
				world.levelEvent(entity, 2001, blockpos.below().below(), Block.getId(blockstate));
			}
			if(blockstate.getBlock() == state.getBlock() && blockstate.getValue(HALFS) == QuintupleBlockHalfs.MIDDLE_BOTTOM) 
			{
				world.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 35);
				world.levelEvent(entity, 2001, blockpos.below().below().below(), Block.getId(blockstate));
			}
			if(blockstate.getBlock() == state.getBlock() && blockstate.getValue(HALFS) == QuintupleBlockHalfs.BOTTOM) 
			{
				world.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 35);
				world.levelEvent(entity, 2001, blockpos.below().below().below().below(), Block.getId(blockstate));
			}
		}
	}
	
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) 
	{
		builder.add(HALFS);
	}
	
	@OnlyIn(Dist.CLIENT)
	public long getSeed(BlockState state, BlockPos pos) 
	{
		return MathHelper.getSeed(pos.getX(), pos.below(state.getValue(HALFS) == QuintupleBlockHalfs.BOTTOM ? 0 : 1).getY(), pos.getZ());
	}
}
