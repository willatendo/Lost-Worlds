package library.blocks.pottery;

import javax.annotation.Nullable;

import api.core.init.BlockInit;
import api.core.init.SoundInit;
import api.core.init.TileEntityInit;
import library.blocks.bases.FallingRotateableBlock;
import library.tileentities.KylixTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class BakedKylixBlock extends FallingRotateableBlock implements ITileEntityProvider
{
	private static final VoxelShape KYLIX_SHAPE = Block.box(1, 0, 3, 15, 5, 13);

	public BakedKylixBlock(Properties properties) 
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
	
	@Override
	protected void falling(FallingBlockEntity blockEntity) 
	{
		blockEntity.setHurtsEntities(true); 
	}
	
	@Override
	public void onLand(World world, BlockPos pos, BlockState state, BlockState newState, FallingBlockEntity blockEntity) 
	{	
		if(!blockEntity.isSilent()) 
		{
			world.levelEvent(1031, pos, 0);
		}
	}
	
	@Override
	public void onBroken(World world, BlockPos pos, FallingBlockEntity blockEntity) 
	{
		if(!blockEntity.isSilent()) 
		{
			world.levelEvent(1029, pos, 0);
		}
	}
	
	@Nullable
	public static BlockState damage(BlockState state) 
	{
		if(state.is(BlockInit.BAKED_KYLIX.get())) 
		{
			return BlockInit.CHIPPED_BAKED_KYLIX.get().defaultBlockState().setValue(HORIZONTAL_FACING, state.getValue(HORIZONTAL_FACING));
		} 
		else 
		{
			return state.is(BlockInit.CHIPPED_BAKED_KYLIX.get()) ? BlockInit.DAMAGED_BAKED_KYLIX.get().defaultBlockState().setValue(HORIZONTAL_FACING, state.getValue(HORIZONTAL_FACING)) : null;
		}
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
		world.playSound((PlayerEntity) null, pos, SoundInit.POT_BREAK.get(), SoundCategory.BLOCKS, 0.7F, 0.9F + world.random.nextFloat() * 0.2F);
		world.destroyBlock(pos, false);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) 
	{
		return SHAPES.get(this).get(state.getValue(HORIZONTAL_FACING));
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
		if(!world.isClientSide) 
		{
			TileEntity tile = world.getBlockEntity(pos);
			if(tile instanceof KylixTileEntity) 
			{
				NetworkHooks.openGui((ServerPlayerEntity)player, (INamedContainerProvider)tile, pos);
				return ActionResultType.SUCCESS;
			}
		}
		return ActionResultType.SUCCESS;
	}
		
	@Override
	public void setPlacedBy(World world, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) 
	{
		if(stack.hasCustomHoverName()) 
		{
			TileEntity tileentity = world.getBlockEntity(pos);
			if(tileentity instanceof KylixTileEntity) 
			{
				((KylixTileEntity)tileentity).setCustomName(stack.getHoverName());
			}
		}
	}
	
	@Override
	public void onRemove(BlockState state, World world, BlockPos pos, BlockState newState, boolean b) 
	{
		if(!state.is(newState.getBlock())) 
		{
			TileEntity tileentity = world.getBlockEntity(pos);
			if(tileentity instanceof KylixTileEntity) 
			{
				InventoryHelper.dropContents(world, pos, (KylixTileEntity)tileentity);
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
	public TileEntity newBlockEntity(IBlockReader reader) 
	{
		return new KylixTileEntity();
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) 
	{
		return TileEntityInit.KYLIX_TILE_ENTITY.get().create();
	}
}
