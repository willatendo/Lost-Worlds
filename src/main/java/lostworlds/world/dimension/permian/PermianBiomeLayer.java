package lostworlds.world.dimension.permian;

import lostworlds.world.init.BiomeInit;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;

public class PermianBiomeLayer implements IAreaTransformer0 
{
    private static final int UNCOMMON_BIOME_CHANCE = 8;
    private static final int RARE_BIOME_CHANCE = 16;
    protected int[] commonBiomes = new int[]
    {
    	PermianLayerUtil.getBiomeId(BiomeInit.PERMIAN_DESERT_KEY),
    	PermianLayerUtil.getBiomeId(BiomeInit.PERMIAN_DESERT_HILLS_KEY)
    };
    protected int[] uncommonBiomes = (new int[]
    {
    	PermianLayerUtil.getBiomeId(BiomeInit.PERMIAN_MOUNTAINS_KEY),
    	PermianLayerUtil.getBiomeId(BiomeInit.FLOOD_BASALT_PLAINS_KEY)
    });
    protected int[] rareBiomes = (new int[]
    {
    	PermianLayerUtil.getBiomeId(BiomeInit.PERMIAN_CONIFER_FOREST_KEY),
    	PermianLayerUtil.getBiomeId(BiomeInit.PERMIAN_CONIFER_FOREST_HILLS_KEY),
    	PermianLayerUtil.getBiomeId(BiomeInit.PERMIAN_GINKGO_FOREST_KEY),
    	PermianLayerUtil.getBiomeId(BiomeInit.PERMIAN_GINKGO_FOREST_HILLS_KEY),
    	PermianLayerUtil.getBiomeId(BiomeInit.PERMIAN_OCEAN_KEY),
    	PermianLayerUtil.getBiomeId(BiomeInit.PERMIAN_PLAINS_KEY),
    	PermianLayerUtil.getBiomeId(BiomeInit.PERMIAN_PLAINS_HILLS_KEY)
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
