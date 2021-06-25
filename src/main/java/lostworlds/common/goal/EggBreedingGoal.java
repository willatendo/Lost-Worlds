package lostworlds.common.goal;

import java.util.Random;

import lostworlds.common.entities.abstracts.BasePrehistoricEntity;
import lostworlds.common.triggers.ModCriteriaTriggers;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.stats.Stats;
import net.minecraft.world.GameRules;

public class EggBreedingGoal extends ModBreedGoal1 
{
	private final BasePrehistoricEntity entity;

	public EggBreedingGoal(BasePrehistoricEntity entity, double speedmodifier) 
	{
		super(entity, speedmodifier);
		this.entity = entity;
	}

	public boolean canUse() 
	{
		return super.canUse() && !this.entity.hasEgg();
	}

	protected void breed() 
	{
		ServerPlayerEntity serverplayerentity = this.animal.getLoveCause();
		if(serverplayerentity == null && this.partner.getLoveCause() != null) 
		{
			serverplayerentity = this.partner.getLoveCause();
		}

		if(serverplayerentity != null) 
		{
			serverplayerentity.awardStat(Stats.ANIMALS_BRED);
			ModCriteriaTriggers.BRED_PREHISTORIC_ANIMALS.trigger(serverplayerentity, this.animal, this.partner, (BasePrehistoricEntity) null);
		}

		this.entity.setHasEgg(true);
		this.animal.resetLove();
		this.partner.resetLove();
		Random random = this.animal.getRandom();
		if(this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) 
		{
			this.level.addFreshEntity(new ExperienceOrbEntity(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
		}

	}
}
