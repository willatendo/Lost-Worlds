package lostworlds.common.entities.abstracts;

import lostworlds.common.goal.ModSwimGoal;
import lostworlds.common.goal.ModWalkGoal;
import lostworlds.common.goal.path.GroundAndSwimmerPathNavigator;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public abstract class AbstractPrehistoricEntity extends CreatureEntity
{	
	protected boolean isHostile;
	protected boolean isScaredOfPlayer;
	protected boolean isFish = false;
	protected boolean isAmphibian = false;
	protected boolean isLandAndWater = false;

	public AbstractPrehistoricEntity(EntityType<? extends AbstractPrehistoricEntity> entityIn, World worldIn) 
	{
		super(entityIn, worldIn);
		
		if(isLandAndWater())
		{
			this.moveControl = new AbstractPrehistoricEntity.MoveHelperController(this);
		}
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
	
	public boolean isLandAndWater()
	{
		return this.isLandAndWater;
	}
	
	public void travel(Vector3d vec3d) 
	{
		if(this.isEffectiveAi() && this.isInWater() && isLandAndWater()) 
		{
			this.moveRelative(0.01F, vec3d);
			this.move(MoverType.SELF, this.getDeltaMovement());
			this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
			if(this.getTarget() == null) 
			{
				this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
			}
		} 
		else 
		{
			super.travel(vec3d);
		}
	}
	
	@Override
	public boolean isPushedByFluid() 
	{
		if(isFish())
		{
			return true;
		}
		if(isLandAndWater())
		{
			return true;
		}
		return false;
	}
	
	public boolean canRandomSwim() 
	{
		if(isFish())
		{
			return true;
		}
		if(isLandAndWater())
		{
			return true;
		}
		return false;
	}
	
	@Override
	protected PathNavigator createNavigation(World worldIn) 
	{
		if(isLandAndWater())
		{
			return new GroundAndSwimmerPathNavigator(this, worldIn);
		}
		return new GroundPathNavigator(this, worldIn);
	}
	
	@Override
	public boolean canBreatheUnderwater() 
	{
		if(isFish())
		{
			return true;
		}
		if(isLandAndWater())
		{
			return true;
		}
		return false;
	}
	
	@Override
	protected void registerGoals() 
	{
		super.registerGoals();
		if(!isFish() && !isLandAndWater())
		{
			this.goalSelector.addGoal(0, new SwimGoal(this));
			this.goalSelector.addGoal(1, new ModWalkGoal(this));
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
		if(isFish() && !isLandAndWater())
		{
			this.goalSelector.addGoal(0, new PanicGoal(this, 1.25D));
			this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, PlayerEntity.class, 8.0F, 1.6D, 1.4D, EntityPredicates.NO_SPECTATORS::test));
			this.goalSelector.addGoal(2, new ModSwimGoal(this));
		}
		if(isLandAndWater() && !isFish())
		{
			this.goalSelector.addGoal(1, new ModWalkGoal(this));
			this.goalSelector.addGoal(1, new ModSwimGoal(this));
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
	}
	
	static class MoveHelperController extends MovementController 
	{
		private final AbstractPrehistoricEntity animal;
		
		MoveHelperController(AbstractPrehistoricEntity entity) 
		{
			super(entity);
			this.animal = entity;
		}
		
		public void tick() 
		{
			if(this.animal.isEyeInFluid(FluidTags.WATER)) 
			{
				this.animal.setDeltaMovement(this.animal.getDeltaMovement().add(0.0D, 0.005D, 0.0D));
			}
			
			if(this.operation == MovementController.Action.MOVE_TO && !this.animal.getNavigation().isDone()) 
			{
				float f = (float)(this.speedModifier * this.animal.getAttributeValue(Attributes.MOVEMENT_SPEED));
				this.animal.setSpeed(MathHelper.lerp(0.125F, this.animal.getSpeed(), f));
				double d0 = this.wantedX - this.animal.getX();
				double d1 = this.wantedY - this.animal.getY();
				double d2 = this.wantedZ - this.animal.getZ();
				if(d1 != 0.0D) 
				{
					double d3 = (double)MathHelper.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
					this.animal.setDeltaMovement(this.animal.getDeltaMovement().add(0.0D, (double)this.animal.getSpeed() * (d1 / d3) * 0.1D, 0.0D));
				}
				
				if(d0 != 0.0D || d2 != 0.0D) 
				{
					float f1 = (float)(MathHelper.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
					this.animal.yRot = this.rotlerp(this.animal.yRot, f1, 90.0F);
					this.animal.yBodyRot = this.animal.yRot;
				}
			} 
			else 
			{
				this.animal.setSpeed(0.0F);
			}
		}
	}
}
