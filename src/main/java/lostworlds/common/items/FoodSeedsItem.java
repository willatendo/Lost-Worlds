package lostworlds.common.items;

import java.util.List;

import lostworlds.core.util.ModUtil;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class FoodSeedsItem extends Item
{
	public FoodSeedsItem(Properties properties) 
	{
		super(properties);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, World world, List<ITextComponent> textComponent, ITooltipFlag flag) 
	{
		super.appendHoverText(stack, world, textComponent, flag);
		textComponent.add(new TranslationTextComponent("toolTip." + ModUtil.ID + ".seeds"));
	}
}
