package lostworlds.world.dimension.jurassic;

import java.util.List;

import com.google.common.collect.ImmutableList;

import lostworlds.core.init.BiomeInit;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;

public enum JurassicRiverLayer implements ICastleTransformer
{
	INSTANCE;
		
	private List<Integer> dryBiomes = ImmutableList.of(JurassicLayerUtil.getBiomeId(BiomeInit.JURASSIC_DESERT_KEY));
	
	JurassicRiverLayer() { }
	
	@Override
	public int apply(INoiseRandom iNoiseRandom, int up, int left, int down, int right, int mid) 
	{
		if(shouldRiver(mid, left, down, right, up))
		{
			return JurassicLayerUtil.getBiomeId(BiomeInit.JURASSIC_RIVER_KEY);
		}
		else
		{
			return -1;
		}
	}
	
	boolean shouldRiver(int mid, int left, int down, int right, int up) 
	{
        return shouldStream(mid, left) || shouldStream(mid, right) || shouldStream(mid, down) || shouldStream(mid, up);
    }
	
	boolean shouldStream(int biome1, int biome2)
	{
		if(biome1 == biome2)
		{
			return false;
		}
		
		if(biome1 == -biome2)
		{
			return false;
		}
		
		if(dryBiomes.contains(biome1) || dryBiomes.contains(biome2))
		{
			return false;
		}
		
		return true;
	}
}
