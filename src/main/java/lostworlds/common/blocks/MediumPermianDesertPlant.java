package lostworlds.common.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.IForgeShearable;

public class MediumPermianDesertPlant extends BushBlock implements IForgeShearable
{
	protected static final VoxelShape VOXEL_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);

	public MediumPermianDesertPlant(Properties properties) 
	{
		super(properties);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader blockReader, BlockPos pos, ISelectionContext context) 
	{
		return VOXEL_SHAPE;
	}
	
	public AbstractBlock.OffsetType getOffsetType() 
	{
		return AbstractBlock.OffsetType.XYZ;
	}
}
