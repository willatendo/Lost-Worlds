package lostworlds.world.dimension.jurassic;

import lostworlds.core.init.BiomeInit;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.traits.IAreaTransformer2;
import net.minecraft.world.gen.layer.traits.IDimOffset0Transformer;

public enum JurassicRiverMixLayer implements IAreaTransformer2, IDimOffset0Transformer
{
	INSTANCE;
	
	JurassicRiverMixLayer() { }
	
	@Override
    public int applyPixel(INoiseRandom random, IArea area1, IArea area2, int val1, int val2) 
	{
        int i = area1.get(this.getParentX(val1), this.getParentY(val2));
        int j = area2.get(this.getParentX(val1), this.getParentY(val2));

        if(i == JurassicLayerUtil.getBiomeId(BiomeInit.JURASSIC_RIVER_KEY)) 
        {
            return i;
        } 
        else if(j == JurassicLayerUtil.getBiomeId(BiomeInit.JURASSIC_RIVER_KEY)) 
        {
            return j;
        } 
        else 
        {
            return i;
        }
    }
}
