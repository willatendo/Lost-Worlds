package lostworlds.client.gui.fieldguideentries;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public abstract class FieldGuideEntryBase extends Screen 
{
	protected int imageWidth;
	protected int imageHeight;
	protected int titleLabelX;
	protected int titleLabelY;
	protected int inventoryLabelX;
	protected int inventoryLabelY;
	protected int leftPos;
	protected int topPos;
	
	public FieldGuideEntryBase() 
	{
		super(new StringTextComponent(""));
				
        this.leftPos = 0;
        this.topPos = 0;

        this.imageWidth = 543;
        this.imageHeight = 359;
	}
	
	protected void init() 
	{
		super.init();
		this.leftPos = (this.width - this.imageWidth) / 2;
		this.topPos = (this.height - this.imageHeight) / 2;
	}

	public void render(MatrixStack stack, int mouseX, int mouseY, float partialTicks) 
	{
		this.renderBackground(stack);
		this.renderFg(stack, mouseX, mouseY, partialTicks);
        super.render(stack, mouseX, mouseY, partialTicks);
        RenderSystem.disableBlend();
	}
	
	protected abstract void renderBg(MatrixStack stack, float f, int i1, int i2);

	protected void renderFg(MatrixStack stack, int f, int i1, float i2) { }
}
