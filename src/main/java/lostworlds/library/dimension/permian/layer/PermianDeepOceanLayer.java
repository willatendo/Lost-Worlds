package lostworlds.library.dimension.permian.layer;

import lostworlds.library.dimension.permian.PermianLayerUtil;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;

public enum PermianDeepOceanLayer implements ICastleTransformer 
{
	INSTANCE;

	public int apply(INoiseRandom randNoise, int north, int south, int east, int west, int centre) 
	{
		if(PermianLayerUtil.isShallowOcean(centre)) 
		{
			int i = 0;
			if (PermianLayerUtil.isShallowOcean(north)) 
			{
				++i;
			}

			if (PermianLayerUtil.isShallowOcean(south)) 
			{
				++i;
			}

			if (PermianLayerUtil.isShallowOcean(west)) 
			{
				++i;
			}

			if (PermianLayerUtil.isShallowOcean(east)) 
			{
				++i;
			}

			if(i > 3) 
			{
				if (centre == 44) 
				{
					return 47;
				}

				if (centre == 45) 
				{
					return 48;
				}

				if (centre == 0) 
				{
					return 24;
				}

				if (centre == 46) 
				{
					return 49;
				}

				if (centre == 10) 
				{
					return 50;
				}

				return 24;
			}
		}

		return centre;
	}
}
