package library.blocks.machines;

import api.core.init.TileEntityInit;
import library.tileentities.DNAExtractorTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class DNAExtractorBlock extends BaseMachineBlock
{
	public static final VoxelShape SHAPE = Block.box(1, 0, 3, 15, 9, 16);

	public DNAExtractorBlock(Properties properties) 
	{
		super(properties);
		
		runCalculation(SHAPE);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) 
	{
		return SHAPES.get(this).get(state.getValue(HORIZONTAL_FACING));
	}
	
	@Override
	public TileEntity newBlockEntity(IBlockReader reader) 
	{
		return new DNAExtractorTileEntity();
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) 
	{
		return TileEntityInit.DNA_EXTRACTOR_TILE_ENTITY.get().create();
	}
}
