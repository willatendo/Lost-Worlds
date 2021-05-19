package lostworlds.common.items;

import java.util.List;

import org.lwjgl.glfw.GLFW;

import lostworlds.common.entities.abstracts.AbstractPrehistoricEntity;
import lostworlds.core.util.ModID;
import lostworlds.core.util.TextUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class FieldGuideItem extends Item
{
	public FieldGuideItem(Properties properties) 
	{
		super(properties);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) 
	{
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
		if(InputMappings.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), GLFW.GLFW_KEY_LEFT_SHIFT))
		{
			tooltip.add(TextUtil.coloredTextComponent("toolTip." + ModID.ID + ".field_guide.holding_shift", TextFormatting.GRAY));
		}
		else
		{
			tooltip.add(TextUtil.coloredTextComponent("toolTip." + ModID.ID + ".field_guide.not_holding_shift", TextFormatting.GRAY));
		}
	}
	
	@Override
	public ActionResultType interactLivingEntity(ItemStack stack, PlayerEntity playerEntity, LivingEntity entity, Hand hand) 
	{
		if(entity instanceof AbstractPrehistoricEntity)
		{
			return ActionResultType.SUCCESS;
		}
		
		return ActionResultType.FAIL;
	}
}
