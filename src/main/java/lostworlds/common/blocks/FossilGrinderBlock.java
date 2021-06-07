package lostworlds.common.blocks;

import lostworlds.common.blocks.abstracts.AbstractMachineBlock;
import lostworlds.common.tileentity.FossilCleanerTileEntity;
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

public class FossilGrinderBlock extends AbstractMachineBlock
{
	public static final VoxelShape SHAPE = Block.box(1, 0, 3, 15, 9, 16);

	public FossilGrinderBlock(Properties properties) 
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
		return new FossilCleanerTileEntity();
	}

	@Override
	protected void openContainer(World world, BlockPos pos, PlayerEntity player) 
	{
		TileEntity tileentity = world.getBlockEntity(pos);
		if(tileentity instanceof FossilCleanerTileEntity) 
		{
			player.openMenu((INamedContainerProvider)tileentity);
		}
	}
}
