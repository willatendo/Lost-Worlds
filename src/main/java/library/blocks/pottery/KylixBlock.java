package library.blocks.pottery;

import library.blocks.bases.FallingRotateableBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class KylixBlock extends FallingRotateableBlock
{
	private static final VoxelShape KYLIX_SHAPE = Block.box(1, 0, 3, 15, 5, 13);

	public KylixBlock(Properties properties)
	{
		super(properties);
	
		runCalculation(KYLIX_SHAPE);
	}

	@Override
	public void stepOn(World world, BlockPos pos, Entity entity) 
	{
		this.destroyPottery(world, pos, entity, 100);
		super.stepOn(world, pos, entity);
	}

	@Override
	public void fallOn(World world, BlockPos pos, Entity entity, float chance) 
	{
		this.destroyPottery(world, pos, entity, 3);
	}
	
	private void destroyPottery(World world, BlockPos pos, Entity entity, int amount) 
	{
		if(!world.isClientSide && world.random.nextInt(amount) == 0) 
		{
			BlockState blockstate = world.getBlockState(pos);
			if(blockstate.is(this)) 
			{
				this.breakPottery(world, pos, blockstate);
			}
		}
	}
	
	private void breakPottery(World world, BlockPos pos, BlockState state) 
	{
		world.playSound((PlayerEntity) null, pos, SoundEvents.GRAVEL_BREAK, SoundCategory.BLOCKS, 0.7F, 0.9F + world.random.nextFloat() * 0.2F);
		world.destroyBlock(pos, false);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) 
	{
		return SHAPES.get(this).get(state.getValue(HORIZONTAL_FACING));
	}
}
