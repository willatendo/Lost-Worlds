package lostworlds.client.screen.fieldguides.entries;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import lostworlds.client.screen.fieldguides.FieldGuideLang;
import lostworlds.core.util.ModUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FukuivenatorFieldGuideScreen extends Screen
{
	private static final ResourceLocation BOOK_TEXTURE = ModUtil.rL("textures/gui/field_guide/book_base.png");
	private static final int FONT_COLOUR = 0x000000;
	
	private final int texWidth;
	private final int texHeight;
	
	public FukuivenatorFieldGuideScreen(ITextComponent translationKey) 
	{
		super(translationKey);
		
		this.texWidth = 255;
		this.texHeight = 192;
	}
	
	@Override
	public void render(MatrixStack stack, int mouseX, int mouseY, float partialTicks) 
	{
		this.renderBackgroundElements(stack);
		this.font.draw(stack, this.title, 18, 22, FONT_COLOUR);
		this.font.draw(stack, FieldGuideLang.DANGER, 18, 116, FONT_COLOUR);
		this.font.draw(stack, FieldGuideLang.DIET, 18, 126, FONT_COLOUR);
		this.font.draw(stack, FieldGuideLang.TIME_ERA, 18, 136, FONT_COLOUR);
		this.font.draw(stack, FieldGuideLang.TYPE, 18, 146, FONT_COLOUR);
		this.font.draw(stack, FieldGuideLang.FUKUIVENATOR_DANGER, 65, 116, FONT_COLOUR);
		this.font.draw(stack, FieldGuideLang.FUKUIVENATOR_DIET, 65, 126, FONT_COLOUR);
		this.font.draw(stack, FieldGuideLang.FUKUIVENATOR_TIME_ERA, 65, 136, FONT_COLOUR);
		this.font.draw(stack, FieldGuideLang.FUKUIVENATOR_TYPE, 65, 146, FONT_COLOUR);
		this.font.draw(stack, FieldGuideLang.FUKUIVENATOR_ENTRY_SPECIES_NAME, 18, 30, FONT_COLOUR);
		this.font.draw(stack, FieldGuideLang.FUKUIVENATOR_ENTRY_LINE_ONE, 18, 50, FONT_COLOUR);
		this.font.draw(stack, FieldGuideLang.FUKUIVENATOR_ENTRY_LINE_TWO, 18, 60, FONT_COLOUR);
		this.font.draw(stack, FieldGuideLang.FUKUIVENATOR_ENTRY_LINE_THREE, 18, 70, FONT_COLOUR);
		this.font.draw(stack, FieldGuideLang.FUKUIVENATOR_ENTRY_LINE_FOUR, 18, 80, FONT_COLOUR);
		this.font.draw(stack, FieldGuideLang.FUKUIVENATOR_ENTRY_LINE_FIVE, 18, 90, FONT_COLOUR);
		this.font.draw(stack, FieldGuideLang.FUKUIVENATOR_ENTRY_LINE_SIX, 18, 100, FONT_COLOUR);
		super.render(stack, mouseX, mouseY, partialTicks);
		this.renderComponentHoverEffect(stack, Style.EMPTY, mouseX, mouseY);
	}
	
	@SuppressWarnings("deprecation")
	private void renderBackgroundElements(MatrixStack stack)
	{
		this.renderBackground(stack, 0);
		Minecraft.getInstance().getTextureManager().bind(BOOK_TEXTURE);
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		stack.translate((this.width / 2) - (this.texWidth / 2), (this.height / 2) - (this.texHeight / 2), 0);
		blit(stack, 0, 0, 0, 0, this.texWidth, this.texHeight);
	}
	
	@Override
	public boolean isPauseScreen() 
	{
		return false;
	}
}
