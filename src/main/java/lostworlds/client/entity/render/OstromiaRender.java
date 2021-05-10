package lostworlds.client.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import lostworlds.client.entity.model.OstromiaModel;
import lostworlds.common.entities.OstromiaEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class OstromiaRender extends GeoEntityRenderer<OstromiaEntity>
{
	public OstromiaRender(EntityRendererManager renderManager) 
	{
		super(renderManager, new OstromiaModel());
		this.shadowRadius = 0.5F;
	}
	
	@Override
	public RenderType getRenderType(OstromiaEntity animatable, float partialTicks, MatrixStack stack, IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation textureLocation) 
	{
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}	
	
	@Override
	public void render(OstromiaEntity entity, float entityYaw, float partialTicks, MatrixStack stack, IRenderTypeBuffer bufferIn, int packedLightIn) 
	{
		if(entity.isBaby())
		{
			stack.scale(0.15F, 0.15F, 0.15F);
		}
		stack.scale(1.0F, 1.0F, 1.0F); //Lenght, Height, Width
		
		super.render(entity, entityYaw, partialTicks, stack, bufferIn, packedLightIn);
	}
}
