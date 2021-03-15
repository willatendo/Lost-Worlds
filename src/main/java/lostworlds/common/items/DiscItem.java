package lostworlds.common.items;

import java.util.List;

import org.lwjgl.glfw.GLFW;

import lostworlds.core.util.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class DiscItem extends Item
{
	public DiscItem(Properties properties) 
	{
		super(properties);
	}	
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) 
	{
		super.addInformation(stack, worldIn, tooltip, flagIn);
		if(InputMappings.isKeyDown(Minecraft.getInstance().getMainWindow().getHandle(), GLFW.GLFW_KEY_LEFT_SHIFT))
		{
			tooltip.add(new TranslationTextComponent("toolTip." + Reference.ID + ".disc.holding_shift"));
		}
		else
		{
			tooltip.add(new TranslationTextComponent("toolTip." + Reference.ID + ".disc.not_holding_shift"));
		}
	}
}
