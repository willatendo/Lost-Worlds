package lostworlds.world.dimension.jurassic;

import lostworlds.world.init.BiomeInit;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;

public class JurassicBiomeLayer implements IAreaTransformer0 
{
	private static final int UNCOMMON_BIOME_CHANCE = 8;
    private static final int RARE_BIOME_CHANCE = 16;
    protected int[] commonBiomes = new int[]
    {
    	JurassicLayerUtil.getBiomeId(BiomeInit.JURASSIC_CONIFER_FOREST_KEY),
    	JurassicLayerUtil.getBiomeId(BiomeInit.JURASSIC_GINKGO_FOREST_KEY),
    	JurassicLayerUtil.getBiomeId(BiomeInit.JURASSIC_ARAUCARIA_FOREST_KEY),
    	JurassicLayerUtil.getBiomeId(BiomeInit.JURASSIC_PLAINS_KEY),
    	JurassicLayerUtil.getBiomeId(BiomeInit.JURASSIC_ISLANDS_KEY),
    	JurassicLayerUtil.getBiomeId(BiomeInit.JURASSIC_OCEAN_KEY),
    };
    protected int[] uncommonBiomes = (new int[]
    {
    	JurassicLayerUtil.getBiomeId(BiomeInit.JURASSIC_MOUNTAINS_KEY)
    });
    protected int[] rareBiomes = (new int[]
    {
    	JurassicLayerUtil.getBiomeId(BiomeInit.JURASSIC_DESERT_KEY),
    	JurassicLayerUtil.getBiomeId(BiomeInit.JURASSIC_ERRODED_MOUNTAINS_KEY)
    });

    public JurassicBiomeLayer() { }

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
