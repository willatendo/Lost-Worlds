package lostworlds.common.items;

import java.util.List;

import lostworlds.core.util.reference.ModReference;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class WetPaperItem extends ModItem
{
	public WetPaperItem(String textID) 
	{
		super(textID);
	}
	
	@Override
	public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) 
	{
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
		
		tooltip.add(new TranslationTextComponent("toolTip." + ModReference.ID + ".wet_paper"));
	}
}
