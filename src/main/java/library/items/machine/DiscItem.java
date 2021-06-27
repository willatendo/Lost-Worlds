package library.items.machine;

import java.util.List;

import org.lwjgl.glfw.GLFW;

import library.util.ModUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class DiscItem extends Item
{
	private String id;
	
	public DiscItem(String extraId, Properties properties) 
	{
		super(properties);
		this.id = extraId;
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) 
	{
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
		if(InputMappings.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), GLFW.GLFW_KEY_LEFT_SHIFT))
		{
			tooltip.add(ModUtil.cTC("toolTip", id + ".holding_shift", TextFormatting.GOLD));
		}
		else
		{
			tooltip.add(ModUtil.cTC("toolTip", id + ".not_holding_shift", TextFormatting.GRAY));
		}
	}
}
