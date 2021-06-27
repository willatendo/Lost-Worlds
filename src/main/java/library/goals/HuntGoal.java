package library.goals;

import java.util.EnumSet;

import library.entites.bases.BasePrehistoricEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.pathfinding.Path;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;

public class HuntGoal extends Goal
{
	protected final BasePrehistoricEntity entity;
	private final double speedModifier;
	private final boolean followingTargetEvenIfNotSeen;
	private Path path;
	private double pathedTargetX;
	private double pathedTargetY;
	private double pathedTargetZ;
	private int ticksUntilNextPathRecalculation;
	private int ticksUntilNextAttack;
	private long lastCanUseCheck;
	private int failedPathFindingPenalty = 0;
	private boolean canPenalize = false;
	
	public HuntGoal(BasePrehistoricEntity entity, double speedModifier, boolean followingTargetEvenIfNotSeen) 
	{
		this.entity = entity;
		this.speedModifier = speedModifier;
		this.followingTargetEvenIfNotSeen = followingTargetEvenIfNotSeen;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
	}
	
	@Override
	public boolean canUse() 
	{
		long i = this.entity.level.getGameTime();
		if(i - this.lastCanUseCheck < 20L) 
		{
			return false;
		}
		else 
		{
			if(entity.isHungry())
			{
				this.lastCanUseCheck = i;
				LivingEntity livingentity = this.entity.getTarget();
				if(livingentity == null) 
				{
					return false;
				} 
				else if(!livingentity.isAlive()) 
				{
					return false;
				} 
				else 
				{
					if(canPenalize) 
					{
						if(--this.ticksUntilNextPathRecalculation <= 0) 
						{
							this.path = this.entity.getNavigation().createPath(livingentity, 0);
							this.ticksUntilNextPathRecalculation = 4 + this.entity.getRandom().nextInt(7);
							return this.path != null;
						} 
						else 
						{
							return true;
						}
					}
					this.path = this.entity.getNavigation().createPath(livingentity, 0);
					if(this.path != null) 
					{
						return true;
					} 
					else 
					{
						return this.getAttackReachSqr(livingentity) >= this.entity.distanceToSqr(livingentity.getX(), livingentity.getY(), livingentity.getZ());
					}
				}
			}
			return false;
		}
	}
	
	@Override
	public boolean canContinueToUse() 
	{
		LivingEntity livingentity = this.entity.getTarget();
		if(livingentity == null)
		{
			return false;
		}
		else if(!livingentity.isAlive()) 
		{
			return false;
		}
		else if(!this.followingTargetEvenIfNotSeen) 
		{
			return !this.entity.getNavigation().isDone();
		}
		else if(!this.entity.isWithinRestriction(livingentity.blockPosition())) 
		{
			return false;
		} 
		else 
		{
			return !(livingentity instanceof PlayerEntity) || !livingentity.isSpectator() && !((PlayerEntity)livingentity).isCreative();
		}
	}
	
	@Override
	public void start() 
	{
		this.entity.getNavigation().moveTo(this.path, this.speedModifier);
		this.entity.setAggressive(true);
		this.ticksUntilNextPathRecalculation = 0;
		this.ticksUntilNextAttack = 0;
	}
	
	@Override
	public void stop() 
	{
		LivingEntity livingentity = this.entity.getTarget();
		if(!EntityPredicates.NO_CREATIVE_OR_SPECTATOR.test(livingentity)) 
		{
			this.entity.setTarget((LivingEntity)null);
		}
		
		this.entity.setAggressive(false);
		this.entity.getNavigation().stop();
	}
	
	@Override
	public void tick() 
	{
		LivingEntity livingentity = this.entity.getTarget();
		this.entity.getLookControl().setLookAt(livingentity, 30.0F, 30.0F);
		double d0 = this.entity.distanceToSqr(livingentity.getX(), livingentity.getY(), livingentity.getZ());
		this.ticksUntilNextPathRecalculation = Math.max(this.ticksUntilNextPathRecalculation - 1, 0);
		if((this.followingTargetEvenIfNotSeen || this.entity.getSensing().canSee(livingentity)) && this.ticksUntilNextPathRecalculation <= 0 && (this.pathedTargetX == 0.0D && this.pathedTargetY == 0.0D && this.pathedTargetZ == 0.0D || livingentity.distanceToSqr(this.pathedTargetX, this.pathedTargetY, this.pathedTargetZ) >= 1.0D || this.entity.getRandom().nextFloat() < 0.05F)) 
		{
			this.pathedTargetX = livingentity.getX();
			this.pathedTargetY = livingentity.getY();
			this.pathedTargetZ = livingentity.getZ();
			this.ticksUntilNextPathRecalculation = 4 + this.entity.getRandom().nextInt(7);
			if(this.canPenalize) 
			{
				this.ticksUntilNextPathRecalculation += failedPathFindingPenalty;
				if(this.entity.getNavigation().getPath() != null) 
				{
					net.minecraft.pathfinding.PathPoint finalPathPoint = this.entity.getNavigation().getPath().getEndNode();
					if(finalPathPoint != null && livingentity.distanceToSqr(finalPathPoint.x, finalPathPoint.y, finalPathPoint.z) < 1)
						failedPathFindingPenalty = 0;
					else
						failedPathFindingPenalty += 10;
				} 
				else 
				{
					failedPathFindingPenalty += 10;
				}
			}
			if(d0 > 1024.0D) 
			{
				this.ticksUntilNextPathRecalculation += 10;
			} 
			else if(d0 > 256.0D) 
			{
				this.ticksUntilNextPathRecalculation += 5;
			}
			
			if(!this.entity.getNavigation().moveTo(livingentity, this.speedModifier)) 
			{
				this.ticksUntilNextPathRecalculation += 15;
			}
		}
		
		this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
		this.checkAndPerformAttack(livingentity, d0);
	}
	
	protected void checkAndPerformAttack(LivingEntity target, double reach) 
	{
		double d0 = this.getAttackReachSqr(target);
		if (reach <= d0 && this.ticksUntilNextAttack <= 0) 
		{
			this.resetAttackCooldown();
			this.entity.swing(Hand.MAIN_HAND);
			this.entity.doHurtTarget(target);
		}
	}
	
	protected void resetAttackCooldown() 
	{
		this.ticksUntilNextAttack = 20;
	}
	
	protected boolean isTimeToAttack() 
	{
		return this.ticksUntilNextAttack <= 0;
	}
	
	protected int getTicksUntilNextAttack() 
	{
		return this.ticksUntilNextAttack;
	}
	
	protected int getAttackInterval() 
	{
		return 0;
	}
	
	protected double getAttackReachSqr(LivingEntity p_179512_1_) 
	{
		return (double)(this.entity.getBbWidth() * 2.0F * this.entity.getBbWidth() * 2.0F + p_179512_1_.getBbWidth());
	}
}
