package lostworlds.common.blocks;

import java.util.HashMap;
import java.util.Map;

import lostworlds.common.blocks.abstracts.AbstractFossilCleanerBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.FurnaceTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class FossilCleanerBlock extends AbstractFossilCleanerBlock
{
	protected static final Map<Block, Map<Direction, VoxelShape>> SHAPES = new HashMap<Block, Map<Direction, VoxelShape>>();
	public static final VoxelShape VOXEL_SHAPE = Block.box(1, 0, 1, 15, 8, 16);
	
	public FossilCleanerBlock(Properties properties)
	{
		super(properties);
		
		runCalculation(VOXEL_SHAPE);
	}

	@Override
	public TileEntity newBlockEntity(IBlockReader blockReader) 
	{
		return new FurnaceTileEntity();
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader blockReader, BlockPos pos,
			ISelectionContext p_220053_4_) 
	{
		return SHAPES.get(this).get(state.getValue(HORIZONTAL_FACING));
	}

	@Override
	protected void openContainer(World worldIn, BlockPos pos, PlayerEntity playerEntity) 
	{
		TileEntity tileentity = worldIn.getBlockEntity(pos);
		if (tileentity instanceof FurnaceTileEntity) 
		{
			playerEntity.openMenu((INamedContainerProvider)tileentity);
			playerEntity.awardStat(Stats.INTERACT_WITH_FURNACE);
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
