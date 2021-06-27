package api.client.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import api.client.entity.model.PsittacosaurusModel;
import library.entites.PsittacosaurusEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

@OnlyIn(Dist.CLIENT)
public class PsittacosaurusRender extends GeoEntityRenderer<PsittacosaurusEntity>
{
	public PsittacosaurusRender(EntityRendererManager renderManager) 
	{
		super(renderManager, new PsittacosaurusModel());
		this.shadowRadius = 0.5F;
	}
	
	@Override
	public RenderType getRenderType(PsittacosaurusEntity animatable, float partialTicks, MatrixStack stack, IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation textureLocation) 
	{
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
	
	@Override
	public void render(PsittacosaurusEntity entity, float entityYaw, float partialTicks, MatrixStack stack, IRenderTypeBuffer bufferIn, int packedLightIn) 
	{
		if(entity.isBaby())
		{
			stack.scale(0.15F, 0.15F, 0.15F);
		}
		stack.scale(0.8F, 1.0F, 1.0F); //Lenght, Height, Width
		
		super.render(entity, entityYaw, partialTicks, stack, bufferIn, packedLightIn);
	}
}