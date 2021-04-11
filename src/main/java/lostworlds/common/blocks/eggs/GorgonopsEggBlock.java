package lostworlds.common.blocks.eggs;

import java.util.Random;

import lostworlds.common.blocks.abstracts.AbstractDinosaurEgg;
import lostworlds.common.entities.GorgonopsEntity;
import lostworlds.core.init.EntityInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public class GorgonopsEggBlock extends AbstractDinosaurEgg
{
	@Override
	public boolean isMedium() 
	{
		return true;
	}

	public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random rand) 
	{
		if(this.shouldUpdateHatchLevel(world) && onNest(world, pos)) 
		{
			int i = state.getValue(HATCH);
			if(i < 2) 
			{
				world.playSound((PlayerEntity)null, pos, SoundEvents.TURTLE_EGG_CRACK, SoundCategory.BLOCKS, 0.7F, 0.9F + rand.nextFloat() * 0.2F);
				world.setBlock(pos, state.setValue(HATCH, Integer.valueOf(i + 1)), 2);
			} 
			else 
			{
				world.playSound((PlayerEntity)null, pos, SoundEvents.TURTLE_EGG_HATCH, SoundCategory.BLOCKS, 0.7F, 0.9F + rand.nextFloat() * 0.2F);
				world.removeBlock(pos, false);
				
				world.levelEvent(2001, pos, Block.getId(state));
				GorgonopsEntity gorgonops = EntityInit.GORGONOPS_ENTITY.get().create(world);
				gorgonops.moveTo((double)pos.getX() + 0.3D * 0.2D, (double)pos.getY(), (double)pos.getZ() + 0.3D, 0.0F, 0.0F);
				world.addFreshEntity(gorgonops);
				gorgonops.setAge(-24000);
			}
		}
	}
}
