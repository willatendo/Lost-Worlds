package lostworlds.common.entities.abstracts;

import lostworlds.common.goal.LostWorldsSwimGoal;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IEquipable;
import net.minecraft.entity.IRideable;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.EntityPredicates;
import net.minecraft.world.World;

public abstract class AbstractPrehistoricEntity extends CreatureEntity
{	
	protected boolean isHostile;
	protected boolean isScaredOfPlayer;
	protected boolean isFish;
	protected boolean isRideable;
	protected boolean isAmphibian;

	public AbstractPrehistoricEntity(EntityType<? extends AbstractPrehistoricEntity> entityIn, World worldIn) 
	{
		super(entityIn, worldIn);
	}
	
	@Override
	protected boolean shouldDespawnInPeaceful() 
	{
		return false;
	}
	
	public boolean removeWhenFarAway(double doubleIn) 
	{
		return false;
	}
	
	public boolean isHostile() 
	{
		return this.isHostile;		
	}
	
	public boolean isAmphibian() 
	{
		return this.isAmphibian;		
	}
	
	public boolean isScaredOfPlayer() 
	{
		return this.isScaredOfPlayer;
	}
	
	public boolean isFish()
	{
		return this.isFish;
	}
	
	public boolean canRandomSwim() 
	{
		if(isFish())
		{
			return true;
		}
		return false;
	}
	
	public boolean isRideable()
	{
		return this.isRideable;
	}
	
	@Override
	protected void registerGoals() 
	{
		super.registerGoals();
		if(!isFish())
		{
			this.goalSelector.addGoal(0, new RandomWalkingGoal(this, 1.0D));
			this.goalSelector.addGoal(1, new LookAtGoal(this, PlayerEntity.class, 6.0F));
			this.goalSelector.addGoal(2, new SwimGoal(this));
			if(isHostile())
			{
				this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 1.6D, false));
				this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
			}
			if(!isHostile() && isScaredOfPlayer())
			{
				this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, PlayerEntity.class, 8.0F, 1.6D, 1.4D, EntityPredicates.NO_SPECTATORS::test));
			}
		}
		if(isFish())
		{
			this.goalSelector.addGoal(0, new PanicGoal(this, 1.25D));
			this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, PlayerEntity.class, 8.0F, 1.6D, 1.4D, EntityPredicates.NO_SPECTATORS::test));
			this.goalSelector.addGoal(4, new LostWorldsSwimGoal(this));
		}
	}
	
	public static abstract class AbstractRideablePrehistoricEntity extends AbstractPrehistoricEntity implements IRideable, IEquipable
	{
		public AbstractRideablePrehistoricEntity(EntityType<? extends AbstractPrehistoricEntity> entityIn, World worldIn) 
		{
			super(entityIn, worldIn);
		}
	}
}
