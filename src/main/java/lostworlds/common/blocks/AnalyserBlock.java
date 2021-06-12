package lostworlds.common.blocks;

import lostworlds.common.blocks.abstracts.AbstractMachineBlock;
import lostworlds.common.tileentity.AnalyserTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class AnalyserBlock extends AbstractMachineBlock
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
	protected void openContainer(World world, BlockPos pos, PlayerEntity player) 
	{
		TileEntity tileentity = world.getBlockEntity(pos);
		if(tileentity instanceof AnalyserTileEntity) 
		{
			player.openMenu((INamedContainerProvider)tileentity);
		}
	}
}
