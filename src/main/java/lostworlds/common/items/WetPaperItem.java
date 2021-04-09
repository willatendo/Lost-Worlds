package lostworlds.common.items;

import java.util.List;

import lostworlds.core.util.ModID;
import lostworlds.core.util.TextUtil;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
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
		
		tooltip.add(TextUtil.coloredTextComponent("toolTip." + ModID.ID + ".wet_paper", TextFormatting.GRAY));
	}
}
