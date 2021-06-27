package library.items;

import java.util.List;

import org.lwjgl.glfw.GLFW;

import library.util.ModUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

public class WetPaperItem extends Item
{
	public WetPaperItem(Properties properties) 
	{
		super(properties);
	}
	
	@Override
	public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) 
	{
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
		if(InputMappings.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), GLFW.GLFW_KEY_LEFT_SHIFT))
		{
			tooltip.add(ModUtil.gTC("toolTip", "wet_paper.holding_shift"));
		}
		else
		{
			tooltip.add(ModUtil.gTC("toolTip", "wet_paper.not_holding_shift"));
		}
	}
}
