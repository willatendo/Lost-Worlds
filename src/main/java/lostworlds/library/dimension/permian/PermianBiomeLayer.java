package lostworlds.library.dimension.permian;

import lostworlds.library.biome.BiomeKeys;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;

public class PermianBiomeLayer implements IAreaTransformer0 
{
    private static final int UNCOMMON_BIOME_CHANCE = 8;
    private static final int RARE_BIOME_CHANCE = 16;
    protected int[] commonBiomes = new int[]
    {
    	PermianLayerUtil.getBiomeId(BiomeKeys.PERMIAN_DESERT),
    	PermianLayerUtil.getBiomeId(BiomeKeys.PERMIAN_DESERT_HILLS)
    };
    protected int[] uncommonBiomes = (new int[]
    {
    	PermianLayerUtil.getBiomeId(BiomeKeys.PERMIAN_DESERT),
    	PermianLayerUtil.getBiomeId(BiomeKeys.PERMIAN_DESERT_HILLS)	
    });
    protected int[] rareBiomes = (new int[]
    {
    	PermianLayerUtil.getBiomeId(BiomeKeys.PERMIAN_DESERT),
    	PermianLayerUtil.getBiomeId(BiomeKeys.PERMIAN_DESERT_HILLS)
    });

    public PermianBiomeLayer() { }

    @Override
    public int applyPixel(INoiseRandom iNoiseRandom, int rand1, int rand2) 
    {
        if(iNoiseRandom.nextRandom(RARE_BIOME_CHANCE) == 0) 
        {
            return rareBiomes[iNoiseRandom.nextRandom(rareBiomes.length)];
        } 
        else if(iNoiseRandom.nextRandom(UNCOMMON_BIOME_CHANCE) == 0) 
        {
            return uncommonBiomes[iNoiseRandom.nextRandom(uncommonBiomes.length)];
        } 
        else 
        {
            return commonBiomes[iNoiseRandom.nextRandom(commonBiomes.length)];
        }
    }
}