package lostworlds.library.dimension.permian.layer;

import lostworlds.library.dimension.permian.PermianLayerUtil;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;

public enum PermianShoreLayer implements ICastleTransformer 
{
	INSTANCE;
	
	public int apply(INoiseRandom randNoise, int north, int south, int east, int west, int centre) 
	{
		if(!PermianLayerUtil.isOcean(centre) && (PermianLayerUtil.isOcean(north) || PermianLayerUtil.isOcean(south) || PermianLayerUtil.isOcean(east) || PermianLayerUtil.isOcean(west))) 
		{
			return PermianLayerUtil.getBiomeId(Biomes.BEACH);
		}

		return centre;
	}
}
