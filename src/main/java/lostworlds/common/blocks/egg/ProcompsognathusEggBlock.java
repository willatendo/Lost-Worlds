package lostworlds.common.blocks.egg;

import java.util.Random;

import javax.annotation.Nullable;

import lostworlds.common.entities.abstracts.AbstractPrehistoricAnimalEntity;
import lostworlds.common.entities.abstracts.AbstractPrehistoricEntity;
import lostworlds.core.init.BlockInit;
import lostworlds.core.util.ModBlockStateProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
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
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.common.util.NonNullSupplier;

public class ProcompsognathusEggBlock extends Block
{
	private static final VoxelShape EGG_ONE = Block.box(6, 0, 7, 8, 4, 9);
	private static final VoxelShape EGG_TWO = Block.box(6, 0, 5, 11, 4, 9);
	private static final VoxelShape EGG_THREE = Block.box(4, 0, 4, 9, 4, 11);
	private static final VoxelShape EGG_FOUR = Block.box(4, 0, 5, 13, 4, 13);
	private static final VoxelShape EGG_FIVE = Block.box(3, 0, 3, 13, 4, 13);
	public static final IntegerProperty HATCH = BlockStateProperties.HATCH;
	public static final IntegerProperty EGGS = ModBlockStateProperties.SMALL_EGGS;

	private final Lazy<? extends EntityType<? extends AbstractPrehistoricAnimalEntity>> entityTypeSupplier;
	
	public ProcompsognathusEggBlock(Properties properties, NonNullSupplier<? extends EntityType<? extends AbstractPrehistoricAnimalEntity>> entity) 
	{
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(HATCH, Integer.valueOf(0)).setValue(EGGS, Integer.valueOf(1)));
		this.entityTypeSupplier = Lazy.of(entity::get);
	}

	@Override
	public void stepOn(World world, BlockPos pos, Entity entity) 
	{
		this.destroyEgg(world, pos, entity, 100);
		super.stepOn(world, pos, entity);
	}
	
	@Override
	public void fallOn(World world, BlockPos pos, Entity entity, float damage) 
	{
		if(!(entity instanceof ZombieEntity)) 
		{
			this.destroyEgg(world, pos, entity, 3);
		}
		
		super.fallOn(world, pos, entity, damage);
	}
	
	private void destroyEgg(World world, BlockPos pos, Entity entity, int p_203167_4_) 
	{
		if(this.canDestroyEgg(world, entity)) 
		{
			if(!world.isClientSide && world.random.nextInt(p_203167_4_) == 0) 
			{
				BlockState blockstate = world.getBlockState(pos);
				if(blockstate.is(this)) 
				{
					this.decreaseEggs(world, pos, blockstate);
				}
			}
		}
	}
	
	private void decreaseEggs(World world, BlockPos pos, BlockState state) 
	{
		world.playSound((PlayerEntity)null, pos, SoundEvents.TURTLE_EGG_BREAK, SoundCategory.BLOCKS, 0.7F, 0.9F + world.random.nextFloat() * 0.2F);
		int i = state.getValue(EGGS);
		if(i <= 1) 
		{
			world.destroyBlock(pos, false);
		} 
		else 
		{
			world.setBlock(pos, state.setValue(EGGS, Integer.valueOf(i - 1)), 2);
			world.levelEvent(2001, pos, Block.getId(state));
		}
	}
	
	@Override
	public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random rand) 
	{
		if(this.shouldUpdateHatchLevel(world) && onValadNestingBlock(world, pos)) 
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
				
				for(int j = 0; j < state.getValue(EGGS); ++j) 
				{
					world.levelEvent(2001, pos, Block.getId(state));
					AbstractPrehistoricAnimalEntity entity = this.getType().create(world);
					entity.setAge(-24000);
					world.addFreshEntity(entity);
				}
			}
		}
	}
	
	public static boolean onValadNestingBlock(IBlockReader reader, BlockPos pos) 
	{
		return isValadNestingBlock(reader, pos.below());
	}
	
	public static boolean isValadNestingBlock(IBlockReader reader, BlockPos pos) 
	{
		return reader.getBlockState(pos).is(BlockInit.NESTING_BLOCK.get());
	}
	
	@Override
	public void onPlace(BlockState state, World world, BlockPos pos, BlockState newState, boolean b) 
	{
		if(onValadNestingBlock(world, pos) && !world.isClientSide) 
		{
			world.levelEvent(2005, pos, 0);
		}
	}
	
	private boolean shouldUpdateHatchLevel(World world) 
	{
		float f = world.getTimeOfDay(1.0F);
		if((double)f < 0.69D && (double)f > 0.65D) 
		{
			return true;
		} 
		else 
		{
			return world.random.nextInt(500) == 0;
		}
	}
	
	@Override
	public void playerDestroy(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable TileEntity tile, ItemStack stack) 
	{
		super.playerDestroy(world, player, pos, state, tile, stack);
		this.decreaseEggs(world, pos, state);
	}
	
	@Override
	public boolean canBeReplaced(BlockState state, BlockItemUseContext context) 
	{
		return context.getItemInHand().getItem() == this.asItem() && state.getValue(EGGS) < 5 ? true : super.canBeReplaced(state, context);
	}
	
	@Override
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) 
	{
		BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos());
		return blockstate.is(this) ? blockstate.setValue(EGGS, Integer.valueOf(Math.min(5, blockstate.getValue(EGGS) + 1))) : super.getStateForPlacement(context);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) 
	{
		return state.getValue(EGGS) == 1 ? EGG_ONE : state.getValue(EGGS) == 2 ? EGG_TWO : state.getValue(EGGS) == 3 ? EGG_THREE : state.getValue(EGGS) == 4 ? EGG_FOUR : EGG_FIVE;
	}
	
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) 
	{
		builder.add(HATCH, EGGS);
	}
	
	public EntityType<? extends AbstractPrehistoricAnimalEntity> getType() 
	{
		return this.entityTypeSupplier.get();
	}
	
	private boolean canDestroyEgg(World world, Entity entity) 
	{
		if(!(entity instanceof AbstractPrehistoricEntity) && !(entity instanceof BatEntity)) 
		{
			if(!(entity instanceof LivingEntity)) 
			{
				return false;
			} 
			else 
			{
				return entity instanceof PlayerEntity || net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(world, entity);
			}
		} 
		else 
		{
			return false;
		}
	}
}
