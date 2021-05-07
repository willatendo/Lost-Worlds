package lostworlds.common.blocks;

import java.util.Random;

import lostworlds.core.init.BlockInit;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;

public class ModOreBlock extends OreBlock
{
	public ModOreBlock(Properties properties) 
	{
		super(properties);
	}
	
	@Override
	protected int xpOnDrop(Random rand) 
	{
		if(this == BlockInit.PERMIAN_COAL_ORE.get()) 
		{
			return MathHelper.nextInt(rand, 0, 2);
		}
		else if(this == BlockInit.PERMIAN_DIAMOND_ORE.get()) 
		{
			return MathHelper.nextInt(rand, 3, 7);
		}
		else if(this == BlockInit.PERMIAN_EMERALD_ORE.get()) 
		{
			return MathHelper.nextInt(rand, 3, 7);
		}
		else if(this == BlockInit.PERMIAN_LAPIS_ORE.get()) 
		{
			return MathHelper.nextInt(rand, 2, 5);
		}
		else if(this == BlockInit.JURASSIC_COAL_ORE.get()) 
		{
			return MathHelper.nextInt(rand, 0, 2);
		}
		else if(this == BlockInit.JURASSIC_DIAMOND_ORE.get()) 
		{
			return MathHelper.nextInt(rand, 3, 7);
		}
		else if(this == BlockInit.JURASSIC_EMERALD_ORE.get()) 
		{
			return MathHelper.nextInt(rand, 3, 7);
		}
		else if(this == BlockInit.JURASSIC_LAPIS_ORE.get()) 
		{
			return MathHelper.nextInt(rand, 2, 5);
		}
		else
		{
			return MathHelper.nextInt(rand, 0, 0);
		}
	}
}
