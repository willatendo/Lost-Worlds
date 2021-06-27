package api.client.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import api.client.entity.model.AllosaurusModel;
import library.entites.AllosaurusEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class AllosaurusRender extends GeoEntityRenderer<AllosaurusEntity>
{
	public AllosaurusRender(EntityRendererManager renderManager) 
	{
		super(renderManager, new AllosaurusModel());
		this.shadowRadius = 0.5F;
	}
	
	@Override
	public RenderType getRenderType(AllosaurusEntity animatable, float partialTicks, MatrixStack stack, IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation textureLocation) 
	{
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
	
	@Override
	public void render(AllosaurusEntity entity, float entityYaw, float partialTicks, MatrixStack stack, IRenderTypeBuffer bufferIn, int packedLightIn) 
	{
		if(entity.isBaby())
		{
			if(entity.getAge() >= -24000 && entity.getAge() <= -20000)
			{
				stack.scale(0.15F, 0.15F, 0.15F);
			}
			if(entity.getAge() >= -20001 && entity.getAge() <= -16000)
			{
				stack.scale(0.40F, 0.40F, 0.40F);
			}
			if(entity.getAge() >= -16001 && entity.getAge() <= -10000)
			{
				stack.scale(0.70F, 0.70F, 0.70F);
			}
			if(entity.getAge() >= -10001 && entity.getAge() <= 0)
			{
				stack.scale(1.0F, 1.0F, 1.0F);
			}
		}
		stack.scale(1.4F, 1.5F, 1.5F); //Lenght, Height, Width
		
		super.render(entity, entityYaw, partialTicks, stack, bufferIn, packedLightIn);
	}
}
