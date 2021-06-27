package library.items;

import library.entites.bases.BasePrehistoricEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;

public class FieldGuideItem extends Item
{	
	public FieldGuideItem(Properties properties) 
	{
		super(properties);
	}
	
	@Override
	public ActionResultType interactLivingEntity(ItemStack stack, PlayerEntity playerEntity, LivingEntity entity, Hand hand) 
	{
		if(entity instanceof BasePrehistoricEntity)
		{	
			return ActionResultType.SUCCESS;
		}
		
		return ActionResultType.FAIL;
	}
}
