package lostworlds.library.dimension.permian.layer;

import lostworlds.library.dimension.permian.PermianLayerUtil;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IBishopTransformer;

public enum AddPermianIslandLayer implements IBishopTransformer 
{
	INSTANCE;

	public int apply(INoiseRandom randNoise, int north, int south, int west, int east, int centre) 
	{
		if(!PermianLayerUtil.isShallowOcean(centre) || PermianLayerUtil.isShallowOcean(east) && PermianLayerUtil.isShallowOcean(west) && PermianLayerUtil.isShallowOcean(north) && PermianLayerUtil.isShallowOcean(south)) 
		{
			if(!PermianLayerUtil.isShallowOcean(centre) && (PermianLayerUtil.isShallowOcean(east) || PermianLayerUtil.isShallowOcean(north) || PermianLayerUtil.isShallowOcean(west) || PermianLayerUtil.isShallowOcean(south)) && randNoise.nextRandom(5) == 0) 
			{
				if(PermianLayerUtil.isShallowOcean(east)) 
				{
					return centre == 4 ? 4 : east;
				}

				if(PermianLayerUtil.isShallowOcean(north)) 
				{
					return centre == 4 ? 4 : north;
				}

				if(PermianLayerUtil.isShallowOcean(west)) 
				{
					return centre == 4 ? 4 : west;
				}

				if(PermianLayerUtil.isShallowOcean(south)) 
				{
					return centre == 4 ? 4 : south;
				}
			}

			return centre;
		} 
		else 
		{
			int i = 1;
			int j = 1;
			if(!PermianLayerUtil.isShallowOcean(east) && randNoise.nextRandom(i++) == 0) 
			{
				j = east;
			}

			if(!PermianLayerUtil.isShallowOcean(west) && randNoise.nextRandom(i++) == 0) 
			{
				j = west;
			}

			if(!PermianLayerUtil.isShallowOcean(north) && randNoise.nextRandom(i++) == 0) 
			{
				j = north;
			}

			if(!PermianLayerUtil.isShallowOcean(south) && randNoise.nextRandom(i++) == 0) 
			{
				j = south;
			}

			if(randNoise.nextRandom(3) == 0) 
			{
				return j;
			} 
			else 
			{
				return j == 4 ? 4 : centre;
			}
		}
	}
}
