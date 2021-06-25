package lostworlds.common.tileentity;

import lostworlds.common.blocks.VaseBlock;
import lostworlds.core.init.TileEntityInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class VaseTileEntity extends TileEntity implements ITickableTileEntity
{
	private VaseBlock block;

	public VaseTileEntity()
	{
		super(TileEntityInit.VASE_TILE_ENTITY.get());
	}
	
	public boolean canCookVase() 
	{
		if(this.level.getBlockState(getBlockPos().below()) == Blocks.FIRE.defaultBlockState())
		{
			if(this.level.getBlockState(getBlockPos().west()) == Blocks.BRICKS.defaultBlockState() && this.level.getBlockState(getBlockPos().east()) == Blocks.BRICKS.defaultBlockState() && this.level.getBlockState(getBlockPos().north()) == Blocks.BRICKS.defaultBlockState() && this.level.getBlockState(getBlockPos().north()) == Blocks.AIR.defaultBlockState())
			{
				return true;
			}
			else if(this.level.getBlockState(getBlockPos().west()) == Blocks.BRICKS.defaultBlockState() && this.level.getBlockState(getBlockPos().east()) == Blocks.BRICKS.defaultBlockState() && this.level.getBlockState(getBlockPos().north()) == Blocks.AIR.defaultBlockState() && this.level.getBlockState(getBlockPos().north()) == Blocks.BRICKS.defaultBlockState())
			{
				return true;
			}
			else if(this.level.getBlockState(getBlockPos().west()) == Blocks.BRICKS.defaultBlockState() && this.level.getBlockState(getBlockPos().east()) == Blocks.AIR.defaultBlockState() && this.level.getBlockState(getBlockPos().south()) == Blocks.BRICKS.defaultBlockState() && this.level.getBlockState(getBlockPos().north()) == Blocks.BRICKS.defaultBlockState())
			{
				return true;
			}
			else if(this.level.getBlockState(getBlockPos().west()) == Blocks.AIR.defaultBlockState() && this.level.getBlockState(getBlockPos().east()) == Blocks.BRICKS.defaultBlockState() && this.level.getBlockState(getBlockPos().south()) == Blocks.BRICKS.defaultBlockState() && this.level.getBlockState(getBlockPos().north()) == Blocks.BRICKS.defaultBlockState())
			{
				return true;
			}

		}
		return false;
	}
	
	@Override
	public void tick() 
	{
		if(this.level.isClientSide())
		{
			if(this.level.getBlockState(getBlockPos().below()) == Blocks.FIRE.defaultBlockState())
			{
				Block cookedVase = block.getCookedVase();
				BlockState state = block.defaultBlockState();
				this.level.setBlock(getBlockPos(), cookedVase.defaultBlockState().setValue(VaseBlock.HORIZONTAL_FACING, state.getValue(VaseBlock.HORIZONTAL_FACING)), 0);
			}
		}
	}
}
