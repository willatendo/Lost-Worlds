package lostworlds.library.dimension.permian.layer;

import lostworlds.library.biome.BiomeKeys;
import lostworlds.library.dimension.permian.PermianLayerUtil;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;

public enum PermianEdgeLayer implements ICastleTransformer 
{
	INSTANCE;
	
	public int apply(INoiseRandom randNoise, int north, int south, int east, int west, int centre) 
	{
		int[] aint = new int[1];
		if(!this.checkEdge(aint, centre) && !this.checkEdgeStrict(aint, north, south, east, west, centre, 38, 37) && !this.checkEdgeStrict(aint, north, south, east, west, centre, 39, 37) && !this.checkEdgeStrict(aint, north, south, east, west, centre, 32, 5)) 
		{
			if(north == PermianLayerUtil.getBiomeId(BiomeKeys.PERMIAN_FLOOD_BASALTS) || south == PermianLayerUtil.getBiomeId(BiomeKeys.PERMIAN_FLOOD_BASALTS) || east == PermianLayerUtil.getBiomeId(BiomeKeys.PERMIAN_FLOOD_BASALTS) || west == PermianLayerUtil.getBiomeId(BiomeKeys.PERMIAN_FLOOD_BASALTS)) 
			{
				return PermianLayerUtil.getBiomeId(BiomeKeys.PERMIAN_ASHY_MEDOWS);
			}
			else 
			{
				return PermianLayerUtil.getBiomeId(BiomeKeys.PERMIAN_DESERT);
			}
		} 
		else 
		{
			return aint[0];
		}
	}

	private boolean checkEdge(int[] biomeSeedArray, int biomeSeed) 
	{
		if(!PermianLayerUtil.isSame(biomeSeed, 3)) 
		{
			return false;
		} 
		else 
		{
			biomeSeedArray[0] = biomeSeed;
			return true;
		}
	}

	private boolean checkEdgeStrict(int[] biomeSeedArray, int north, int south, int east, int west, int centre, int i2, int i3) 
	{
		if(centre != i2) 
		{
			return false;
		} 
		else 
		{
			if(PermianLayerUtil.isSame(north, i2) && PermianLayerUtil.isSame(south, i2) && PermianLayerUtil.isSame(west, i2) && PermianLayerUtil.isSame(east, i2)) 
			{
				biomeSeedArray[0] = centre;
			} 
			else 
			{
				biomeSeedArray[0] = i3;
			}
			return true;
		}
	}
}
