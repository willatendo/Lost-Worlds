package library.blocks.machines;

import api.core.init.TileEntityInit;
import library.tileentities.AnalyserTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class AnalyserBlock extends BaseMachineBlock
{
	public static final VoxelShape SHAPE = Block.box(1, 0, 3, 15, 9, 16);

	public AnalyserBlock(Properties properties) 
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
		return new AnalyserTileEntity();
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) 
	{
		return TileEntityInit.ANALYSER_TILE_ENTITY.get().create();
	}
}