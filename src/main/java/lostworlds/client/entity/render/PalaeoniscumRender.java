package lostworlds.client.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import lostworlds.client.entity.model.PalaeoniscumModel;
import lostworlds.common.entities.PalaeoniscumEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

@OnlyIn(Dist.CLIENT)
public class PalaeoniscumRender extends GeoEntityRenderer<PalaeoniscumEntity>
{
	public PalaeoniscumRender(EntityRendererManager renderManager)
	{
		super(renderManager, new PalaeoniscumModel());
		this.shadowSize = 0.15F;
	}
	
	@Override
	public RenderType getRenderType(PalaeoniscumEntity animatable, float partialTicks, MatrixStack stack, IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation textureLocation) 
	{
		return RenderType.getEntityTranslucent(getTextureLocation(animatable));
	}
}
