package lostworlds.client.gui.fieldguideentries;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import lostworlds.core.util.ModID;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class ProcompsognathusFieldGuideEntry extends FieldGuideEntryBase
{
	public static final ResourceLocation TEXTURE = new ResourceLocation(ModID.ID, "textures/gui/field_guide/procompsognathus_entry.png");

	public static void open() 
	{
		Minecraft.getInstance().setScreen(new ProcompsognathusFieldGuideEntry());
	}
	
	
	@SuppressWarnings("deprecation")
	@Override
    protected void renderBg(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY)
    {
		this.renderBackground(matrixStack);
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.minecraft.getTextureManager().bind(TEXTURE);
        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;
        this.blit(matrixStack, x, y, 0, 0, this.imageWidth, this.imageHeight);
    }
}
