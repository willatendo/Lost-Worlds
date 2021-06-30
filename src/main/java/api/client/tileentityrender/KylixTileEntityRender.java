package api.client.tileentityrender;

import com.mojang.blaze3d.matrix.MatrixStack;

import api.core.init.BlockInit;
import library.blocks.pottery.BakedKylixBlock;
import library.tileentities.KylixTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class KylixTileEntityRender extends TileEntityRenderer<KylixTileEntity>
{
	public KylixTileEntityRender(TileEntityRendererDispatcher rendererDispatcher) 
	{
		super(rendererDispatcher);
	}
	
	@Override
	public void render(KylixTileEntity tile, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) 
	{
		World world = tile.getLevel();
		boolean isInWorld = world != null;
		BlockState blockstate = isInWorld ? tile.getBlockState() : BlockInit.BAKED_KYLIX.get().defaultBlockState().setValue(ChestBlock.FACING, Direction.SOUTH);
		Block block = blockstate.getBlock();
		if(block instanceof BakedKylixBlock) 
		{
			if(isInWorld) 
			{
				ItemStack stack = tile.getItem(0);
				if(!stack.isEmpty()) 
				{
					matrixStackIn.pushPose();
					matrixStackIn.translate(0.5, 0.4, 0.5);
					Minecraft.getInstance().getItemRenderer().renderStatic(stack, ItemCameraTransforms.TransformType.GROUND, combinedLightIn, combinedOverlayIn, matrixStackIn, bufferIn);
                    matrixStackIn.popPose();
                }
            }
		}
	}
}
