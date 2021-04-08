package lostworlds.common.items;

import java.util.List;

import lostworlds.core.util.ModID;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
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
		
		tooltip.add(new TranslationTextComponent("toolTip." + ModID.ID + ".wet_paper"));
	}
}
