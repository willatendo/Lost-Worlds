package lostworlds.client.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import lostworlds.common.container.FossilCleanerContianer;
import lostworlds.core.util.reference.ModReference;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FossilCleanerScreen extends ContainerScreen<FossilCleanerContianer> 
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(ModReference.ID, "textures/gui/machines/fossil_cleaner.png");

	public FossilCleanerScreen(FossilCleanerContianer screenContainer, PlayerInventory inv, ITextComponent titleIn) 
	{
		super(screenContainer, inv, titleIn);
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void renderBg(MatrixStack stack, float floatIn, int intIn1, int intIn2) 
	{
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.minecraft.getTextureManager().bind(TEXTURE);
		int i = this.leftPos;
		int j = (this.height - this.imageHeight) / 2;
		this.blit(stack, i, j, 0, 0, this.imageWidth, this.imageHeight);
	}
}