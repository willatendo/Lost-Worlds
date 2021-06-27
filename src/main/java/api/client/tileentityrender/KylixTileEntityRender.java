package api.client.tileentityrender;

import com.mojang.blaze3d.matrix.MatrixStack;

import library.tileentities.KylixTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class KylixTileEntityRender extends TileEntityRenderer<KylixTileEntity>
{
	private final Minecraft minecraft = Minecraft.getInstance();
	private final ItemRenderer itemRenderer;

	public KylixTileEntityRender(TileEntityRendererDispatcher rendererDispatcher) 
	{
		super(rendererDispatcher);
		itemRenderer = minecraft.getItemRenderer();
	}
	
	@Override
	public void render(KylixTileEntity tile, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) 
	{
		if(!tile.isEmpty()) 
		{
			matrixStackIn.pushPose();
			matrixStackIn.translate(0.5, 1.125, 0.5);
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
			
			ItemCameraTransforms.TransformType transform = ItemCameraTransforms.TransformType.FIXED;
			
			ItemStack stack = tile.getDisplayedItem();
			IBakedModel ibakedmodel = itemRenderer.getModel(stack, tile.getLevel(), null);
			itemRenderer.render(stack, transform, true, matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn, ibakedmodel);
			
			matrixStackIn.popPose();
		}
	}
}
