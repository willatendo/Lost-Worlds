package lostworlds.client.screen.machines;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import lostworlds.common.container.FossilGrinderContainer;
import lostworlds.common.tileentity.FossilGrinderTileEntity;
import lostworlds.core.util.ModUtil;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class FossilGrinderScreen<T extends FossilGrinderContainer> extends ContainerScreen<T>
{
	private static final ResourceLocation TEXTURE = ModUtil.rL("textures/gui/machines/fossil_grinder.png");
	private final FossilGrinderContainer container;
	private final FossilGrinderTileEntity tile;
	
	public FossilGrinderScreen(T container, PlayerInventory playerInv, ITextComponent text) 
	{
		super(container, playerInv, text);
		this.container = container;
		this.tile = container.tile;
	}
	
	@Override
	public void render(MatrixStack stack, int i1, int i2, float f)
	{
		this.renderBackground(stack);
		this.renderBg(stack, f, i1, i2);
		super.render(stack, i1, i2, f);
		this.renderTooltip(stack, i1, i2);
	}
	
	@Override
	protected void renderBg(MatrixStack stack, float partialTicks, int x, int y)
	{
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.minecraft.getTextureManager().bind(TEXTURE);
		int i = this.leftPos;
		int j = this.topPos;
		this.blit(stack, i, j, 0, 0, this.imageWidth, this.imageHeight);
	}
}
