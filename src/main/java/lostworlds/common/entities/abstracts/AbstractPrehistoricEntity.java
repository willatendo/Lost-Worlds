package lostworlds.common.entities.abstracts;

import java.util.EnumSet;
import java.util.Random;

import lostworlds.common.goal.ModSwimGoal;
import lostworlds.common.goal.ModSwimSemiAquaticGoal;
import lostworlds.core.util.enums.TimeEras;
import net.minecraft.block.Blocks;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public abstract class AbstractPrehistoricEntity extends CreatureEntity
{
 	public static final DataParameter<Boolean> ATTACKING = EntityDataManager.defineId(AbstractPrehistoricEntity.class, DataSerializers.BOOLEAN);	
    protected static final DataParameter<Byte> SEX = EntityDataManager.defineId(TameableEntity.class, DataSerializers.BYTE);
	
    public static final String SEX_TAG = "Sex";

    protected boolean isHostile = false;
	protected boolean isScaredOfPlayer;
	protected boolean isFish = false;
	protected boolean isAmphibian = false;
	protected boolean isLandAndWater = false;

	public AbstractPrehistoricEntity(EntityType<? extends AbstractPrehistoricEntity> entityIn, World worldIn, TimeEras timeEra) 
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
	
	@Override
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
	
	public boolean checkAnimalSpawnRules(EntityType<? extends AbstractPrehistoricEntity> entity, IWorld world, SpawnReason reason, BlockPos pos, Random rand) 
	{
		if(isFish())
		{
			return world.getBlockState(pos.above()).is(Blocks.WATER) && world.getBlockState(pos).is(Blocks.WATER);
		}
		if(isLandAndWater())
		{
			return world.getBlockState(pos.above()).is(Blocks.WATER) && world.getBlockState(pos).is(Blocks.WATER) || world.getBlockState(pos.above()).is(BlockTags.VALID_SPAWN) && world.getBlockState(pos).is(Blocks.AIR);
		}
		else
		{
			return world.getBlockState(pos.above()).is(BlockTags.VALID_SPAWN) && world.getBlockState(pos).is(Blocks.AIR);
		}
	}
	
	@Override
	protected void defineSynchedData() 
	{
		super.defineSynchedData();
		byte sex = (byte) random.nextInt(2);
        this.entityData.define(SEX, sex);
		this.getEntityData().define(ATTACKING, Boolean.FALSE);
	}
	
	@Override
	public void addAdditionalSaveData(CompoundNBT nbt) 
	{
		super.addAdditionalSaveData(nbt);
		nbt.putByte(SEX_TAG, getSex());
	}
	
	@Override
	public void readAdditionalSaveData(CompoundNBT nbt) 
	{
		super.readAdditionalSaveData(nbt);
		setSex(nbt.getByte(SEX_TAG));
	}
	
	public byte getSex() 
	{
        return entityData.get(SEX);
    }

    public void setSex(byte sex) 
    {
    	entityData.set(SEX, sex);
    }
	
	public void setAttacking(boolean attacking) 
	{
		this.entityData.set(ATTACKING, attacking);
	}
	
	public boolean isAttacking() 
	{
		return this.entityData.get(ATTACKING);
	}
	
	@Override
	public boolean isPushedByFluid() 
	{
		if(isFish())
		{
			return false;
		}
		if(isLandAndWater())
		{
			return false;
		}
		return true;
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
		if(!isLandAndWater() || !isFish)
		{
			return new GroundPathNavigator(this, worldIn);
		}
		return super.createNavigation(worldIn);
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
			this.goalSelector.addGoal(1, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
			this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 6.0F));
			this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
			if(this.isHostile())
			{
				this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));
			}
			if(isScaredOfPlayer())
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
			this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1.0D));
			this.goalSelector.addGoal(1, new ModSwimSemiAquaticGoal(this, 1.0D, 30));
			this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 6.0F));
			this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
			if(isScaredOfPlayer())
			{
				this.goalSelector.addGoal(4, new AvoidEntityGoal<>(this, PlayerEntity.class, 8.0F, 1.6D, 1.4D, EntityPredicates.NO_SPECTATORS::test));
			}
		}
	}
	
	public boolean attackEntityAsMob(Entity entityIn) 
	{
		boolean flag = entityIn.hurt(DamageSource.mobAttack(this), (float) ((int) this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
        if (flag) 
        {
            this.doEnchantDamageEffects(this, entityIn);
        }

        return flag;
    }
	
	static class LandAndSeaMoveHelperController extends MovementController 
	{
		private final AbstractPrehistoricEntity animal;
		
		LandAndSeaMoveHelperController(AbstractPrehistoricEntity entity) 
		{
			super(entity);
			this.animal = entity;
		}
		
		@Override
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
	
	class ModAttackGoal extends MeleeAttackGoal 
	{
		private final AbstractPrehistoricEntity entity;
		@SuppressWarnings("unused")
		private int attackStep;
		
		public ModAttackGoal(AbstractPrehistoricEntity entityIn, double speedIn, boolean useMemory) 
		{
			super(entityIn, speedIn, useMemory);
			this.entity = entityIn;
			this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		}
		
		@Override
		protected void checkAndPerformAttack(LivingEntity entity, double distToEnemySqr) 
		{
			double d0 = this.getAttackReachSqr(entity);
            if(distToEnemySqr <= d0 && this.isTimeToAttack()) 
            {
                this.resetAttackCooldown();
                this.entity.attackEntityAsMob(entity);
                AbstractPrehistoricEntity.this.setAttacking(false);
            }
            else if(distToEnemySqr <= d0 * 2.0D) 
            {
                if(this.isTimeToAttack()) 
                {
                	AbstractPrehistoricEntity.this.setAttacking(false);
                    this.resetAttackCooldown();
                }

                if(this.getTicksUntilNextAttack() <= 10) 
                {
                	AbstractPrehistoricEntity.this.setAttacking(true);
                }
            }
            else 
            {
                this.resetAttackCooldown();
                AbstractPrehistoricEntity.this.setAttacking(false);
            }
		}
		
		@Override
		public boolean canUse() 
		{
			LivingEntity livingentity = this.entity.getTarget();
            return livingentity != null && livingentity.isAlive() && this.entity.canAttack(livingentity);
        }

        @Override
		public void start() 
        {
        	this.attackStep = 0;
        }

        @Override
		public void stop() 
        {
            super.stop();
            this.entity.setAttacking(false);
        }
	}
}
