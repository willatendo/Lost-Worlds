package lostworlds.common.entities.abstracts;

import lostworlds.common.goal.ModSwimGoal;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
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
	protected boolean isFish = false;
	protected boolean isRideable;
	protected boolean isAmphibian = false;

	public AbstractPrehistoricEntity(EntityType<? extends AbstractPrehistoricEntity> entityIn, World worldIn) 
	{
		super(entityIn, worldIn);
	}
	
	@Override
	protected boolean shouldDespawnInPeaceful() 
	{
		return false;
	}
	
	@Override
	public boolean canChangeDimensions() 
	{
		return true;
	}
	
	@Override
	public boolean canBeLeashed(PlayerEntity playerEntity) 
	{
		return true;
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
			this.goalSelector.addGoal(0, new SwimGoal(this));
			this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1.0D));
			this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 6.0F));
			this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
			if(isHostile())
			{
				this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));
			}
			if(!isHostile() && isScaredOfPlayer())
			{
				this.goalSelector.addGoal(4, new AvoidEntityGoal<>(this, PlayerEntity.class, 8.0F, 1.6D, 1.4D, EntityPredicates.NO_SPECTATORS::test));
			}
		}
		if(isFish())
		{
			this.goalSelector.addGoal(0, new PanicGoal(this, 1.25D));
			this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, PlayerEntity.class, 8.0F, 1.6D, 1.4D, EntityPredicates.NO_SPECTATORS::test));
			this.goalSelector.addGoal(2, new ModSwimGoal(this));
		}
	}
}
