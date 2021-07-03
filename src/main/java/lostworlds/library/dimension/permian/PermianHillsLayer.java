package lostworlds.library.dimension.permian;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import net.minecraft.util.Util;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.LayerUtil;
import net.minecraft.world.gen.layer.traits.IAreaTransformer2;
import net.minecraft.world.gen.layer.traits.IDimOffset1Transformer;

public enum PermianHillsLayer implements IAreaTransformer2, IDimOffset1Transformer 
{
	INSTANCE;

	private static final Logger LOGGER = LogManager.getLogger();
	private static final Int2IntMap MUTATIONS = Util.make(new Int2IntOpenHashMap(), (map) -> 
	{
		map.put(1, 2);
	});

	public int applyPixel(INoiseRandom random, IArea area1, IArea area2, int val1, int val2)  
	{
		int i = area1.get(this.getParentX(val1 + 1), this.getParentY(val2 + 1));
		int j = area2.get(this.getParentX(val1 + 1), this.getParentY(val2 + 1));
		if(i > 255) 
		{
			LOGGER.debug("old! {}", (int) i);
		}

		int k = (j - 2) % 29;
		if(!PermianLayerUtil.isShallowOcean(i) && j >= 2 && k == 1) 
		{
			return MUTATIONS.getOrDefault(i, i);
		} 
		else 
		{
			if(random.nextRandom(3) == 0 || k == 0) 
			{
				int l = i;
				if(i == 2) 
				{
					l = 17;
				} 
				else if(i == 4) 
				{
					l = 18;
				} 
				else if(i == 27) 
				{
					l = 28;
				} 
				else if(i == 29) 
				{
					l = 1;
				}
				else if(i == 5) 
				{
					l = 19;
				}
				else if(i == 32) 
				{
					l = 33;
				}
				else if(i == 30) 
				{
					l = 31;
				}
				else if(i == 1) 
				{
					l = random.nextRandom(3) == 0 ? 18 : 4;
				}
				else if(i == 12) 
				{
					l = 13;
				}
				else if(i == 21) 
				{
					l = 22;
				} 
				else if(i == 168) 
				{
					l = 169;
				} 
				else if(i == 0) 
				{
					l = 24;
				} 
				else if(i == 45) 
				{
					l = 48;
				} 
				else if(i == 46) 
				{
					l = 49;
				} 
				else if(i == 10) 
				{
					l = 50;
				} 
				else if(i == 3) 
				{
					l = 34;
				} 
				else if(i == 35) 
				{
					l = 36;
				} 
				else if(LayerUtil.isSame(i, 38)) 
				{
					l = 37;
				} 
				else if((i == 24 || i == 48 || i == 49 || i == 50) && random.nextRandom(3) == 0) 
				{
					l = random.nextRandom(2) == 0 ? 1 : 4;
				}

				if(k == 0 && l != i) 
				{
					l = MUTATIONS.getOrDefault(l, i);
				}

				if(l != i) 
				{
					int i1 = 0;
					if(LayerUtil.isSame(area1.get(this.getParentX(val1 + 1), this.getParentY(val2 + 0)), i)) 
					{
						++i1;
					}

					if(LayerUtil.isSame(area1.get(this.getParentX(val1 + 2), this.getParentY(val2 + 1)), i)) 
					{
						++i1;
					}

					if(LayerUtil.isSame(area1.get(this.getParentX(val1 + 0), this.getParentY(val2 + 1)), i)) 
					{
						++i1;
					}

					if(LayerUtil.isSame(area1.get(this.getParentX(val1 + 1), this.getParentY(val2 + 2)), i)) 
					{
						++i1;
					}

					if(i1 >= 3) 
					{
						return l;
					}
				}
			}

			return i;
		}
	}
}
