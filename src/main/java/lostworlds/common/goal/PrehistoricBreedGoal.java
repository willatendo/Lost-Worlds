package lostworlds.common.goal;

import java.util.EnumSet;
import java.util.List;

import javax.annotation.Nullable;

import lostworlds.common.entities.abstracts.AbstractPrehistoricAnimalEntity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class PrehistoricBreedGoal extends Goal 
{
	private static final EntityPredicate PARTNER_TARGETING = (new EntityPredicate()).range(8.0D).allowInvulnerable().allowSameTeam().allowUnseeable();
	protected final AbstractPrehistoricAnimalEntity animal;
	private final Class<? extends AbstractPrehistoricAnimalEntity> partnerClass;
	protected final World level;
	protected AbstractPrehistoricAnimalEntity partner;
	private int loveTime;
	private final double speedModifier;
	
	public PrehistoricBreedGoal(AbstractPrehistoricAnimalEntity entity, double d) 
	{
		this(entity, d, entity.getClass());
	}
	
	public PrehistoricBreedGoal(AbstractPrehistoricAnimalEntity entity, double d, Class<? extends AbstractPrehistoricAnimalEntity> entityClass) 
	{
		this.animal = entity;
		this.level = entity.level;
		this.partnerClass = entityClass;
		this.speedModifier = d;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
	}
	
	public boolean canUse() 
	{
		if(!this.animal.isInLove()) 
		{
			return false;
		} 
		else 
		{
			this.partner = this.getFreePartner();
			return this.partner != null;
		}
	}
	
	public boolean canContinueToUse() 
	{
		return this.partner.isAlive() && this.partner.isInLove() && this.loveTime < 60;
	}
	
	public void stop() 
	{
		this.partner = null;
		this.loveTime = 0;
	}
	
	public void tick() 
	{
		this.animal.getLookControl().setLookAt(this.partner, 10.0F, (float)this.animal.getMaxHeadXRot());
		this.animal.getNavigation().moveTo(this.partner, this.speedModifier);
		++this.loveTime;
		if(this.loveTime >= 60 && this.animal.distanceToSqr(this.partner) < 9.0D) 
		{
			this.breed();
		}
	}
	
	@Nullable
	private AbstractPrehistoricAnimalEntity getFreePartner() 
	{
		List<AbstractPrehistoricAnimalEntity> list = this.level.getNearbyEntities(this.partnerClass, PARTNER_TARGETING, this.animal, this.animal.getBoundingBox().inflate(8.0D));
		double d0 = Double.MAX_VALUE;
		AbstractPrehistoricAnimalEntity animalentity = null;
		
		for(AbstractPrehistoricAnimalEntity animalentity1 : list) 
		{
			if(this.animal.canMate(animalentity1) && this.animal.distanceToSqr(animalentity1) < d0) 
			{
				animalentity = animalentity1;
				d0 = this.animal.distanceToSqr(animalentity1);
			}
		}
		
		return animalentity;
	}
	
	protected void breed() 
	{
		this.animal.spawnChildFromBreeding((ServerWorld)this.level, this.partner);
	}
}
