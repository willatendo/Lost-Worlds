package lostworlds.common.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import lostworlds.common.entities.DimetrodonEntity;
import lostworlds.core.init.BlockInit;
import lostworlds.core.init.EntityInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.ForgeEventFactory;

public class DimetrodonEggBlock extends Block
{
	private static final VoxelShape VOXEL_SHAPE = Block.box(6, 0, 6, 10, 7, 10);
	public static final IntegerProperty HATCH = BlockStateProperties.HATCH;

	public DimetrodonEggBlock(Properties properties) 
	{
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(HATCH, Integer.valueOf(0)));
	}
	
	public void stepOn(World worldIn, BlockPos pos, Entity entityIn) 
	{
		this.destroyEgg(worldIn, pos, entityIn, 100);
		super.stepOn(worldIn, pos, entityIn);
	}
	
	public void fallOn(World worldIn, BlockPos pos, Entity entityIn, float floatIn) 
	{
		if(!(entityIn instanceof ZombieEntity)) 
		{
			this.destroyEgg(worldIn, pos, entityIn, 3);
		}
		
		super.fallOn(worldIn, pos, entityIn, floatIn);
	}
	
	private void destroyEgg(World worldIn, BlockPos pos, Entity entityIn, int integer) 
	{
		if(this.canDestroyEgg(worldIn, entityIn)) 
		{
			if(!worldIn.isClientSide && worldIn.random.nextInt(integer) == 0) 
			{
				BlockState blockstate = worldIn.getBlockState(pos);
				if(blockstate.is(BlockInit.DIMETRODON_EGG.get())) 
				{
					this.destroyEgg(worldIn, pos, entityIn, 3);
	            }
			}
		}
	}
	
	private void destroyEggOther(World worldIn, BlockPos pos, BlockState state) 
	{
		worldIn.playSound((PlayerEntity)null, pos, SoundEvents.TURTLE_EGG_BREAK, SoundCategory.BLOCKS, 0.7F, 0.9F + worldIn.random.nextFloat() * 0.2F);
		worldIn.destroyBlock(pos, false);
	}
	
	public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random rand) 
	{
		if(this.shouldUpdateHatchLevel(world) && onNest(world, pos)) 
		{
			int i = state.getValue(HATCH);
			if(i < 2) 
			{
				world.playSound((PlayerEntity)null, pos, SoundEvents.TURTLE_EGG_CRACK, SoundCategory.BLOCKS, 0.7F, 0.9F + rand.nextFloat() * 0.2F);
				world.setBlock(pos, state.setValue(HATCH, Integer.valueOf(i + 1)), 2);
			} 
			else 
			{
				world.playSound((PlayerEntity)null, pos, SoundEvents.TURTLE_EGG_HATCH, SoundCategory.BLOCKS, 0.7F, 0.9F + rand.nextFloat() * 0.2F);
				world.removeBlock(pos, false);
				
				world.levelEvent(2001, pos, Block.getId(state));
				DimetrodonEntity dimetrodon = EntityInit.DIMETRODON_ENTITY.get().create(world);
				dimetrodon.moveTo((double)pos.getX() + 0.3D * 0.2D, (double)pos.getY(), (double)pos.getZ() + 0.3D, 0.0F, 0.0F);
				world.addFreshEntity(dimetrodon);
			}
		}
	}
	
	public static boolean onNest(IBlockReader blockReader, BlockPos pos) 
	{
		return isNest(blockReader, pos.below());
	}
	
	public static boolean isNest(IBlockReader blockReader, BlockPos pos) 
	{
		return blockReader.getBlockState(pos).is(BlockInit.NESTING_BLOCK.get());
	}
	
	public void onPlace(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean bool) 
	{
		if(onNest(worldIn, pos) && !worldIn.isClientSide) 
		{
			worldIn.levelEvent(2005, pos, 0);
		}
	}
	
	private boolean shouldUpdateHatchLevel(World worldIn) 
	{
		float f = worldIn.getTimeOfDay(1.0F);
		if((double)f < 0.69D && (double)f > 0.65D) 
		{
			return true;
		} 
		else 
		{
			return worldIn.random.nextInt(500) == 0;
		}
	}
	
	public void playerDestroy(World worldIn, PlayerEntity playerEntity, BlockPos pos, BlockState state, @Nullable TileEntity tile, ItemStack stack) 
	{
		super.playerDestroy(worldIn, playerEntity, pos, state, tile, stack);
		this.destroyEggOther(worldIn, pos, state);
	}
	
	public VoxelShape getShape(BlockState state, IBlockReader blockReader, BlockPos pos, ISelectionContext context) 
	{
		return VOXEL_SHAPE;
	}
	
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) 
	{
		builder.add(HATCH);
	}
	
	private boolean canDestroyEgg(World worldIn, Entity entity) 
	{
		if(!(entity instanceof DimetrodonEntity))
		{
			if(!(entity instanceof LivingEntity)) 
			{
				return false;
			} 
			else 
			{
				return entity instanceof PlayerEntity || ForgeEventFactory.getMobGriefingEvent(worldIn, entity);
			}
		} 
		else 
		{
			return false;
		}
	}
}
