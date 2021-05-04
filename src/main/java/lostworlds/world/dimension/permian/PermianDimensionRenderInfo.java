package lostworlds.world.dimension.permian;

import javax.annotation.Nonnull;

import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.client.ISkyRenderHandler;

public class PermianDimensionRenderInfo extends DimensionRenderInfo 
{
    private ISkyRenderHandler skyrender;

    public PermianDimensionRenderInfo() 
    {
        super(255.0F, true, FogType.NORMAL, false, false);
    }

    @Override
    public Vector3d getBrightnessDependentFogColor(Vector3d vector3d, float v) 
    {
        return vector3d;
    }

    @Override
    public boolean isFoggyAt(int i, int i1) 
    {
        return false;
    }

    @Nonnull
    @Override
    public ISkyRenderHandler getSkyRenderHandler() 
    {
        if (skyrender == null)
            skyrender = new PermianSkyRender();
        return skyrender;
    }

}
