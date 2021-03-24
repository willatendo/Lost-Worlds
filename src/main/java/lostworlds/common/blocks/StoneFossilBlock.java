package lostworlds.common.blocks;

import lostworlds.common.tools.BrushItem;
import lostworlds.core.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class StoneFossilBlock extends Block
{
	private static final DirectionProperty HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;
	
	public StoneFossilBlock(Properties properties) 
	{
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(HORIZONTAL_FACING, Direction.NORTH));
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
		return super.getStateForPlacement(context).setValue(HORIZONTAL_FACING, context.getHorizontalDirection().getOpposite());
	}
	
	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) 
	{
		super.createBlockStateDefinition(builder);
		builder.add(HORIZONTAL_FACING);
	}
	
	@Override
	public void attack(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) 
	{		
		if(player.getItemInHand(Hand.MAIN_HAND).getItem() instanceof BrushItem)
		{
			worldIn.setBlockAndUpdate(pos, BlockInit.EXPOSED_STONE_FOSSIL.get().defaultBlockState().setValue(HORIZONTAL_FACING, state.getValue(HORIZONTAL_FACING)));
			worldIn.playSound(player, pos, SoundEvents.STONE_BREAK, SoundCategory.BLOCKS, 0.7F, 1.0F);
			
//			if(!player.abilities.isCreativeMode)
//			{
				ItemStack stack = player.getMainHandItem();
				
				stack.hurtAndBreak(1, player, (p_220040_1_) -> 
				{
					p_220040_1_.broadcastBreakEvent(player.getUsedItemHand());
				});
//			}
		}
	}
}
