package lostworlds.library.dimension.permian.layer;

import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import lostworlds.library.biome.BiomeKeys;
import lostworlds.library.dimension.permian.PermianLayerUtil;
import net.minecraft.util.Util;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.traits.IAreaTransformer2;
import net.minecraft.world.gen.layer.traits.IDimOffset1Transformer;

public enum PermianHillLayer implements IAreaTransformer2, IDimOffset1Transformer
{
	INSTANCE;

	private static final Int2IntMap MUTATIONS = Util.make(new Int2IntOpenHashMap(), (map) -> 
	{
		map.addTo(PermianLayerUtil.getBiomeId(BiomeKeys.PERMIAN_DESERT), PermianLayerUtil.getBiomeId(BiomeKeys.PERMIAN_DESERT_LAKE));
	});
	
	@Override
	public int applyPixel(INoiseRandom randNoise, IArea area1, IArea area2, int biomeSeed1, int biomeSeed2) 
	{
		int i = area1.get(this.getParentX(biomeSeed1 + 1), this.getParentY(biomeSeed2 + 1));
		int j = area2.get(this.getParentX(biomeSeed1 + 1), this.getParentY(biomeSeed2 + 1));
		
		int k = (j - 2) % 29;
		if(j >= 2 && k == 1) 
		{
			return MUTATIONS.getOrDefault(i, i);
		}
		else
		{
			if(randNoise.nextRandom(3) == 0 )
			{
				int l = i;
				if(biomeSeed1 == PermianLayerUtil.getBiomeId(BiomeKeys.PERMIAN_DESERT))
				{
					l = PermianLayerUtil.getBiomeId(BiomeKeys.PERMIAN_DESERT_HILLS);
				}
				else if(biomeSeed1 == PermianLayerUtil.getBiomeId(BiomeKeys.PERMIAN_DRIED_PLAINS))
				{
					l = PermianLayerUtil.getBiomeId(BiomeKeys.PERMIAN_DRIED_PLAINS_HILLS);
				}
				
				if(k == 0 && l != i) 
				{
					l = MUTATIONS.getOrDefault(l, i);
				}
				
				if(l != i) 
				{
					int i1 = 0;
					if(PermianLayerUtil.isSame(area1.get(this.getParentX(biomeSeed1 + 1), this.getParentY(biomeSeed2 + 0)), i)) 
					{
						++i1;
					}
					
					if(PermianLayerUtil.isSame(area1.get(this.getParentX(biomeSeed1 + 2), this.getParentY(biomeSeed2 + 1)), i)) 
					{
						++i1;
					}
					
					if(PermianLayerUtil.isSame(area1.get(this.getParentX(biomeSeed1 + 0), this.getParentY(biomeSeed2 + 1)), i)) 
					{
						++i1;
					}
					
					if(PermianLayerUtil.isSame(area1.get(this.getParentX(biomeSeed1 + 1), this.getParentY(biomeSeed2 + 2)), i)) 
					{
						++i1;
					}
					
					if(i1 >= 3) 
					{
						return l;
					}
				}
			}
		}
		return i;
	}
}
