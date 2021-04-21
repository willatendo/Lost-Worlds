package lostworlds.common.items;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.WallOrFloorItem;
import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ModSignItem extends WallOrFloorItem
{
	public ModSignItem(Block standingBlock, Block wallBlock, Properties properties) 
	{
		super(standingBlock, wallBlock, properties);
	}

	protected boolean updateCustomBlockEntityTag(BlockPos pos, World worldIn, @Nullable PlayerEntity playerEntity, ItemStack stack, BlockState state) 
	{
		boolean flag = super.updateCustomBlockEntityTag(pos, worldIn, playerEntity, stack, state);
		if (!worldIn.isClientSide && !flag && playerEntity != null) 
		{
			playerEntity.openTextEdit((SignTileEntity)worldIn.getBlockEntity(pos));
		}
		
		return flag;
	}
	
	@Override
	public int getBurnTime(ItemStack itemStack) 
	{
		return 200;
	}
}
