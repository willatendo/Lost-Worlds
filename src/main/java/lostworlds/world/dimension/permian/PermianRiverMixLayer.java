package lostworlds.world.dimension.permian;

import lostworlds.world.init.BiomeInit;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.traits.IAreaTransformer2;
import net.minecraft.world.gen.layer.traits.IDimOffset0Transformer;

public enum PermianRiverMixLayer implements IAreaTransformer2, IDimOffset0Transformer
{
	INSTANCE;
	
	PermianRiverMixLayer() { }
	
	@Override
    public int applyPixel(INoiseRandom random, IArea area1, IArea area2, int val1, int val2) 
	{
        int i = area1.get(this.getParentX(val1), this.getParentY(val2));
        int j = area2.get(this.getParentX(val1), this.getParentY(val2));

        if(i == PermianLayerUtil.getBiomeId(BiomeInit.PERMIAN_RIVER_KEY)) 
        {
            return i;
        } 
        else if(j == PermianLayerUtil.getBiomeId(BiomeInit.PERMIAN_RIVER_KEY)) 
        {
            return j;
        } 
        else 
        {
            return i;
        }
    }
}
