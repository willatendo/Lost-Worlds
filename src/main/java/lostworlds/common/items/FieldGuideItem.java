package lostworlds.common.items;

import lostworlds.client.screen.fieldguides.FieldGuideScreens;
import lostworlds.common.entities.AllosaurusEntity;
import lostworlds.common.entities.CarnotaurusEntity;
import lostworlds.common.entities.ChilesaurusEntity;
import lostworlds.common.entities.CryolophosaurusEntity;
import lostworlds.common.entities.DiictodonEntity;
import lostworlds.common.entities.DimetrodonEntity;
import lostworlds.common.entities.EdaphosaurusEntity;
import lostworlds.common.entities.FukuivenatorEntity;
import lostworlds.common.entities.GiganotosaurusEntity;
import lostworlds.common.entities.GorgonopsEntity;
import lostworlds.common.entities.GreatAukEntity;
import lostworlds.common.entities.KentrosaurusEntity;
import lostworlds.common.entities.OstromiaEntity;
import lostworlds.common.entities.OuranosaurusEntity;
import lostworlds.common.entities.ProcompsognathusEntity;
import lostworlds.common.entities.ProtosuchusEntity;
import lostworlds.common.entities.PsittacosaurusEntity;
import lostworlds.common.entities.RhinesuchusEntity;
import lostworlds.common.entities.SuchomimusEntity;
import lostworlds.common.entities.TetraceratopsEntity;
import lostworlds.common.entities.TyrannosaurusEntity;
import lostworlds.common.entities.abstracts.AbstractPrehistoricEntity;
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
		if(entity instanceof AbstractPrehistoricEntity)
		{
			if(entity instanceof ProcompsognathusEntity)
			{
				DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> FieldGuideScreens::procompsognathusEntry);
			}
			if(entity instanceof RhinesuchusEntity)
			{
				DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> FieldGuideScreens::rhinesuchusEntry);
			}
			if(entity instanceof DimetrodonEntity)
			{
				DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> FieldGuideScreens::dimentrodonEntry);
			}
			if(entity instanceof EdaphosaurusEntity)
			{
				DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> FieldGuideScreens::edaphosaurusEntry);
			}
			if(entity instanceof GorgonopsEntity)
			{
				DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> FieldGuideScreens::gorgonopsEntry);
			}
			if(entity instanceof CarnotaurusEntity)
			{
				DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> FieldGuideScreens::carnotaurusEntry);
			}
			if(entity instanceof TyrannosaurusEntity)
			{
				DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> FieldGuideScreens::tyrannosaurusEntry);
			}
			if(entity instanceof AllosaurusEntity)
			{
				DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> FieldGuideScreens::allosaurusEntry);
			}
			if(entity instanceof GiganotosaurusEntity)
			{
				DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> FieldGuideScreens::giganotosaurusEntry);
			}
			if(entity instanceof SuchomimusEntity)
			{
				DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> FieldGuideScreens::suchomimusEntry);
			}
			if(entity instanceof TetraceratopsEntity)
			{
				DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> FieldGuideScreens::tetraceratopsEntry);
			}
			if(entity instanceof GreatAukEntity)
			{
				DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> FieldGuideScreens::greatAukEntry);
			}
			if(entity instanceof OuranosaurusEntity)
			{
				DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> FieldGuideScreens::ouranosaurusEntry);
			}
			if(entity instanceof FukuivenatorEntity)
			{
				DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> FieldGuideScreens::fukuivenatorEntry);
			}
			if(entity instanceof PsittacosaurusEntity)
			{
				DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> FieldGuideScreens::psittacosaurusEntry);
			}
			if(entity instanceof CryolophosaurusEntity)
			{
				DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> FieldGuideScreens::cryolophosaurusEntry);
			}
			if(entity instanceof OstromiaEntity)
			{
				DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> FieldGuideScreens::ostromiaEntry);
			}
			if(entity instanceof ProtosuchusEntity)
			{
				DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> FieldGuideScreens::protosuchusEntry);
			}
			if(entity instanceof DiictodonEntity)
			{
				DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> FieldGuideScreens::diictodonEntry);
			}
			if(entity instanceof KentrosaurusEntity)
			{
				DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> FieldGuideScreens::kentrosaurusEntry);
			}
			if(entity instanceof ChilesaurusEntity)
			{
				DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> FieldGuideScreens::chilesaurusEntry);
			}
			return ActionResultType.SUCCESS;
		}
		
		return ActionResultType.FAIL;
	}
}
