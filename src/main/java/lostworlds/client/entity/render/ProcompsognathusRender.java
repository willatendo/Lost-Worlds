package lostworlds.client.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import lostworlds.client.entity.model.ProcompsognathusModel;
import lostworlds.common.entities.ProcompsognathusEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

@OnlyIn(Dist.CLIENT)
public class ProcompsognathusRender extends GeoEntityRenderer<ProcompsognathusEntity>
{
	public ProcompsognathusRender(EntityRendererManager renderManager)
	{
		super(renderManager, new ProcompsognathusModel());
		this.shadowRadius = 0.15F;
	}
	
	@Override
	public RenderType getRenderType(ProcompsognathusEntity animatable, float partialTicks, MatrixStack stack, IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation textureLocation) 
	{
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
	
	@Override
	public void render(ProcompsognathusEntity entity, float entityYaw, float partialTicks, MatrixStack stack, IRenderTypeBuffer bufferIn, int packedLightIn) 
	{
		if(entity.isBaby())
		{
			stack.scale(0.39F, 0.38F, 0.39F); 
		}
		stack.scale(0.5F, 0.487F, 0.5F); // Length, Height, Width
		
		super.render(entity, entityYaw, partialTicks, stack, bufferIn, packedLightIn);
	}
}
