package library.items;

import api.client.screen.fieldguide.FieldGuideScreens;
import library.entites.AllosaurusEntity;
import library.entites.bases.BasePrehistoricEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

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
			if(entity instanceof AllosaurusEntity)
			{
				DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> FieldGuideScreens::allosaurusEntry);
			}
			
			return ActionResultType.SUCCESS;
		}
		
		return ActionResultType.FAIL;
	}
}
