package lostworlds.common.items;

import lostworlds.common.entities.ProcompsognathusEntity;
import lostworlds.common.entities.abstracts.AbstractPrehistoricEntity;
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
		if(entity instanceof AbstractPrehistoricEntity)
		{
			if(entity instanceof ProcompsognathusEntity)
			{
//				DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> ProcompsognathusFieldGuideEntry.open());
			}
			return ActionResultType.SUCCESS;
		}
		
		return ActionResultType.FAIL;
	}
}
