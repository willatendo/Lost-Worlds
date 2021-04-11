package lostworlds.common.blocks.abstracts;

import javax.annotation.Nullable;

import lostworlds.common.entities.abstracts.AbstractPrehistoricEntity;
import lostworlds.core.init.BlockInit;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
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
import net.minecraftforge.event.ForgeEventFactory;

public abstract class AbstractDinosaurEgg extends Block
{
	private boolean isSmall = false;
	private boolean isMedium = false;
	private boolean isLarge = false;
	
	public static final VoxelShape SMALL = Block.box(7, 0, 7, 9, 4, 9);
	public static final VoxelShape MEDIUM = Block.box(6, 0, 6, 10, 7, 10);
	public static final VoxelShape LARGE = Block.box(5.5, 0, 5.5, 10.5, 8, 10.5);
	
	public static final IntegerProperty HATCH = BlockStateProperties.HATCH;

	public AbstractDinosaurEgg() 
	{
		super(AbstractBlock.Properties.copy(Blocks.TURTLE_EGG));
		this.registerDefaultState(this.stateDefinition.any().setValue(HATCH, Integer.valueOf(0)));
	}	
	
	public boolean isSmall()
	{
		return this.isSmall;
	}
	
	public boolean isMedium()
	{
		return this.isMedium;
	}
	
	public boolean isLarge()
	{
		return this.isLarge;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader blockReader, BlockPos pos, ISelectionContext context) 
	{
		if(isSmall())
		{
			return SMALL;
		}
		if(isMedium())
		{
			return MEDIUM;
		}
		else 
		{
			return LARGE;
		}
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
				if(blockstate.is(this)) 
				{
					worldIn.playSound((PlayerEntity)null, pos, SoundEvents.TURTLE_EGG_BREAK, SoundCategory.BLOCKS, 0.7F, 0.9F + worldIn.random.nextFloat() * 0.2F);

					worldIn.destroyBlock(pos, false);
	            }
			}
		}
	}
	
	private void destroyEggOther(World worldIn, BlockPos pos, BlockState state) 
	{
		worldIn.playSound((PlayerEntity)null, pos, SoundEvents.TURTLE_EGG_BREAK, SoundCategory.BLOCKS, 0.7F, 0.9F + worldIn.random.nextFloat() * 0.2F);
		worldIn.destroyBlock(pos, false);
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
	
	public boolean shouldUpdateHatchLevel(World worldIn) 
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
	
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) 
	{
		builder.add(HATCH);
	}
	
	public boolean canDestroyEgg(World worldIn, Entity entity) 
	{
		if(!(entity instanceof AbstractPrehistoricEntity))
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
