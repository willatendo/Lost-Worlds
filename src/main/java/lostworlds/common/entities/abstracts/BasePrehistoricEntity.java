package lostworlds.common.entities.abstracts;

import java.util.Random;
import java.util.UUID;

import javax.annotation.Nullable;

import lostworlds.common.events.PrehistoricBabySpawnEvent;
import lostworlds.common.goal.ModBreedGoal1;
import lostworlds.common.goal.ModSwimSemiAquaticGoal;
import lostworlds.common.triggers.ModCriteriaTriggers;
import lostworlds.core.util.ModDamageSources;
import lostworlds.core.util.enums.TimeEras;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.GameRules;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;

public abstract class BasePrehistoricEntity extends LostWorldsEntity
{
	protected static final DataParameter<Boolean> HAS_EGG = EntityDataManager.defineId(BasePrehistoricEntity.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Boolean> LAYING_EGG = EntityDataManager.defineId(BasePrehistoricEntity.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Boolean> DATA_BABY_ID = EntityDataManager.defineId(BasePrehistoricEntity.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Boolean> ATTACKING = EntityDataManager.defineId(BasePrehistoricEntity.class, DataSerializers.BOOLEAN);	
	protected static final DataParameter<Byte> SEX = EntityDataManager.defineId(BasePrehistoricEntity.class, DataSerializers.BYTE);
	
	
	protected boolean isScaredOfPlayer;
	protected boolean isSemiAquatic;
	
	public boolean killedTarget = false;
	
	protected int hunger;
	protected int age;
	protected int forcedAge;
	protected int forcedAgeTimer;
	protected int inLove;
	
	public int layEggCounter;
	
	protected UUID loveCause;
	public static final String SEX_TAG = "Sex";

	public BasePrehistoricEntity(final EntityType<? extends BasePrehistoricEntity> entity, final World world, final TimeEras era, final boolean isScaredOfPlayer, final boolean isSemiAquatic)
	{
		super(entity, world);
		this.isScaredOfPlayer = isScaredOfPlayer;
		this.isSemiAquatic = isSemiAquatic;
	}
	
	private boolean isSemiAquatic()
	{
		return this.isSemiAquatic;
	}
	
	private boolean isScaredOfPlayer() 
	{
		return this.isScaredOfPlayer;
	}
	
	private boolean hasKilledTarget() 
	{
		return this.killedTarget;
	}
	
	@Override
	protected void defineSynchedData() 
	{
		super.defineSynchedData();
		byte sex = (byte) random.nextInt(2);
		this.entityData.define(SEX, sex);
 		this.getEntityData().define(ATTACKING, Boolean.FALSE);
		this.entityData.define(DATA_BABY_ID, false);
		this.entityData.define(HAS_EGG, false);
		this.entityData.define(LAYING_EGG, false);
	}
	
	@Override
	public void onSyncedDataUpdated(DataParameter<?> parameter) 
	{
		if(DATA_BABY_ID.equals(parameter)) 
		{
			this.refreshDimensions();
		}
		super.onSyncedDataUpdated(parameter);
	}
	
	@Override
	public void addAdditionalSaveData(CompoundNBT nbt) 
	{
		super.addAdditionalSaveData(nbt);
		nbt.putByte(SEX_TAG, getSex());
		nbt.putInt("Age", this.getAge());
		nbt.putInt("Hunger", this.getHunger());
		nbt.putInt("ForcedAge", this.forcedAge);
		nbt.putInt("InLove", this.inLove);
		if(this.loveCause != null) 
		{
			nbt.putUUID("LoveCause", this.loveCause);
		}
		nbt.putBoolean("HasEgg", this.hasEgg());
	}
	
	@Override
	public void readAdditionalSaveData(CompoundNBT nbt) 
	{
		super.readAdditionalSaveData(nbt);
		this.setHasEgg(nbt.getBoolean("HasEgg"));
		setSex(nbt.getByte(SEX_TAG));
		this.setAge(nbt.getInt("Age"));
		this.setHunger(nbt.getInt("Hunger"));
		this.forcedAge = nbt.getInt("ForcedAge");
		this.inLove = nbt.getInt("InLove");
		this.loveCause = nbt.hasUUID("LoveCause") ? nbt.getUUID("LoveCause") : null;
	}
	
	@Override
	protected boolean shouldDespawnInPeaceful() 
	{
		return false;
	}
	
	@Override
	public boolean removeWhenFarAway(double range) 
	{
		return false;
	}
	
	@Override
	public boolean canChangeDimensions() 
	{
		return true;
	}
	
	@Override
	public boolean canBeLeashed(PlayerEntity player) 
	{
		return true;
	}
	
	public boolean isLayingEgg() 
	{
		return this.entityData.get(LAYING_EGG);
	}
	
	public void setLayingEgg(boolean layingEggs) 
	{
		this.layEggCounter = layingEggs ? 1 : 0;
		this.entityData.set(LAYING_EGG, layingEggs);
	}
	
	public boolean hasEgg() 
	{
		return this.entityData.get(HAS_EGG);
	}
	
	public void setHasEgg(boolean hasEgg) 
	{
		this.entityData.set(HAS_EGG, hasEgg);
	}
	
	public int getHunger()
	{
		return this.hunger;
	}
	
	public void setHunger(int hunger) 
	{
		this.hunger = hunger;
	}
	
	public boolean isHungry()
	{
		return this.getHunger() <= 0;
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
	
	public int getAge() 
	{
		if(this.level.isClientSide) 
		{
			return this.entityData.get(DATA_BABY_ID) ? -1 : 1;
		} 
		else 
		{
			return this.age;
		}
	}
	
	public void ageUp(int age, boolean bool) 
	{
		int i = this.getAge();
		i = i + age * 20;
		if(i > 0) 
		{
			++i;
		}
		
		int j = i - i;
		this.setAge(i);
		if(bool) 
		{
			this.forcedAge += j;
			if(this.forcedAgeTimer == 0) 
			{
				this.forcedAgeTimer = 40;
			}
		}
		
		if(this.getAge() == 0) 
		{
			this.setAge(this.forcedAge);
		}
	}
	
	public void ageUp(int age) 
	{
		this.ageUp(age, false);
	}
	
	public void setAge(int age) 
	{
		int i = this.age;
		this.age = age;
		if(i < 0 && age >= 0 || i >= 0 && age < 0) 
		{
			this.entityData.set(DATA_BABY_ID, age < 0);
			this.ageBoundaryReached();
		}
	}
	
	@Override
	public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason spawnReason, ILivingEntityData entityData, CompoundNBT nbt) 
	{
		this.hunger = 9000;
		return super.finalizeSpawn(world, difficulty, spawnReason, entityData, nbt);
	}
	
	@Override
	public void aiStep() 
	{
		super.aiStep();
		if(this.level.isClientSide) 
		{
			if(this.forcedAgeTimer > 0) 
			{
				if(this.forcedAgeTimer % 4 == 0) 
				{
					this.level.addParticle(ParticleTypes.HAPPY_VILLAGER, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), 0.0D, 0.0D, 0.0D);
				}
				
				--this.forcedAgeTimer;
			}
		} 
		else if(this.isAlive()) 
		{
			int i = this.getAge();
			++i;
			this.setAge(i);
		}
		
		if(this.hasKilledTarget())
		{
			Random rand = new Random();
			int fill = rand.nextInt(3);
			if(fill == 0)
			{
				this.setHunger(this.getHunger() + 2000);
				this.killedTarget = false;
			}
			if(fill == 1)
			{
				this.setHunger(this.getHunger() + 5000);
				this.killedTarget = false;
			}
			if(fill == 2)
			{
				this.setHunger(this.getHunger() + 9000);
			}
		}
		
		if(this.isAlive())
		{
			int i = this.getHunger();
			--i;
			this.setHunger(i);
		}
		
		if(this.getAge() >= 10000000)
		{
			this.hurt(ModDamageSources.AGE, 200.0F);
		}
		
		if(this.getHunger() < -5000)
		{
			this.hurt(ModDamageSources.HUNGER, 3.0F);
		}
		
		if(this.getAge() != 0) 
		{
			this.inLove = 0;
		}
		
		if(this.inLove > 0) 
		{
			--this.inLove;
			if(this.inLove % 10 == 0) 
			{
				double d0 = this.random.nextGaussian() * 0.02D;
				double d1 = this.random.nextGaussian() * 0.02D;
				double d2 = this.random.nextGaussian() * 0.02D;
				this.level.addParticle(ParticleTypes.HEART, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), d0, d1, d2);
			}
		}
	}

	protected void ageBoundaryReached() { }
	
	public abstract BasePrehistoricEntity getBreedOffspring(ServerWorld serverWorld, BasePrehistoricEntity entity);
	
	@Override
	public boolean isBaby() 
	{
		return this.getAge() < 0;
	}
	
	@Override
	public void setBaby(boolean bool) 
	{
		this.setAge(bool ? -24000 : 0);
	}
	
	@Override
	protected void customServerAiStep() 
	{
		if(this.getAge() != 0) 
		{
			this.inLove = 0;
		}
		
		super.customServerAiStep();
	}
	
	@Override
	public boolean hurt(DamageSource source, float f) 
	{
		if(this.isInvulnerableTo(source)) 
		{
			return false;
		} 
		else 
		{
			this.inLove = 0;
			return super.hurt(source, f);
		}
	}
	
	@Override
	public double getMyRidingOffset() 
	{
		return 0.14D;
	}
	
	@Override
	public int getAmbientSoundInterval() 
	{
		return 120;
	}
	
	@Override
	protected int getExperienceReward(PlayerEntity playerEntity) 
	{
		return 1 + this.level.random.nextInt(3);
	}
	
	public boolean isFood(ItemStack stack) 
	{
		return stack.getItem() == Items.WHEAT;
	}
	
	@Override
	public ActionResultType mobInteract(PlayerEntity playerEntity, Hand handIn) 
	{
		ItemStack itemstack = playerEntity.getItemInHand(handIn);
		if(this.isFood(itemstack)) 
		{
			int i = this.getAge();
			if(!this.level.isClientSide && i == 0 && this.canFallInLove()) 
			{
				this.usePlayerItem(playerEntity, itemstack);
				this.setInLove(playerEntity);
				return ActionResultType.SUCCESS;
			}
			
			if(this.isBaby()) 
			{
				this.usePlayerItem(playerEntity, itemstack);
				this.ageUp((int)((float)(-i / 20) * 0.1F), true);
				return ActionResultType.sidedSuccess(this.level.isClientSide);
			}
			
			if(this.level.isClientSide) 
			{
				return ActionResultType.CONSUME;
			}
		}
		
		return super.mobInteract(playerEntity, handIn);
	}
	
	protected void usePlayerItem(PlayerEntity playerEntity, ItemStack stack) 
	{
		if(!playerEntity.abilities.instabuild) 
		{
			stack.shrink(1);
		}
	}
	
	public boolean canFallInLove() 
	{
		return this.inLove <= 0;
	}
	
	public void setInLove(@Nullable PlayerEntity playerEntity) 
	{
		this.inLove = 600;
		if(playerEntity != null) 
		{
			this.loveCause = playerEntity.getUUID();
		}
		
		this.level.broadcastEntityEvent(this, (byte)18);
	}
	
	public void setInLoveTime(int time) 
	{
		this.inLove = time;
	}
	
	public int getInLoveTime() 
	{
		return this.inLove;
	}
	
	@Nullable
	public ServerPlayerEntity getLoveCause() 
	{
		if(this.loveCause == null) 
		{
			return null;
		} 
		else 
		{
			PlayerEntity playerentity = this.level.getPlayerByUUID(this.loveCause);
			return playerentity instanceof ServerPlayerEntity ? (ServerPlayerEntity)playerentity : null;
		}
	}
	
	public boolean isInLove() 
	{
		return this.inLove > 0;
	}
	
	public void resetLove() 
	{
		this.inLove = 0;
	}
	
	public boolean canMate(BasePrehistoricEntity partner) 
	{
		if(partner == this) 
		{
			return false;
		} 
		else if(partner.getClass() != this.getClass()) 
		{
			return false;
		} 
		else if(this.getSex() != partner.getSex())
		{
			return this.isInLove() && partner.isInLove();
		}
		else
		{
			return false;
		}
	}
	
	public void spawnChildFromBreeding(ServerWorld world, BasePrehistoricEntity entity) 
	{
		BasePrehistoricEntity ageableentity = this.getBreedOffspring(world, entity);
		final PrehistoricBabySpawnEvent event = new PrehistoricBabySpawnEvent(this, entity, ageableentity);
		final boolean cancelled = MinecraftForge.EVENT_BUS.post(event);
		ageableentity = event.getChild();
		if(cancelled) 
		{
			this.setAge(6000);
			entity.setAge(6000);
			this.resetLove();
			entity.resetLove();
			return;
		}
		
		if(ageableentity != null) 
		{
			ServerPlayerEntity serverplayerentity = this.getLoveCause();
			if(serverplayerentity == null && entity.getLoveCause() != null) 
			{
				serverplayerentity = entity.getLoveCause();
			}
			
			if(serverplayerentity != null) 
			{
				serverplayerentity.awardStat(Stats.ANIMALS_BRED);
				ModCriteriaTriggers.BRED_PREHISTORIC_ANIMALS.trigger(serverplayerentity, this, entity, ageableentity);
			}
			
			this.setAge(6000);
			entity.setAge(6000);
			this.resetLove();
			entity.resetLove();
			ageableentity.setBaby(true);
			ageableentity.moveTo(this.getX(), this.getY(), this.getZ(), 0.0F, 0.0F);
			world.addFreshEntityWithPassengers(ageableentity);
			world.broadcastEntityEvent(this, (byte)18);
			if(world.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) 
			{
				world.addFreshEntity(new ExperienceOrbEntity(world, this.getX(), this.getY(), this.getZ(), this.getRandom().nextInt(7) + 1));
			}
		}
	}
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public void handleEntityEvent(byte b) 
	{
		if(b == 18) 
		{
			for(int i = 0; i < 7; ++i) 
			{
				double d0 = this.random.nextGaussian() * 0.02D;
				double d1 = this.random.nextGaussian() * 0.02D;
				double d2 = this.random.nextGaussian() * 0.02D;
				this.level.addParticle(ParticleTypes.HEART, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), d0, d1, d2);
			}
		}
		else 
		{
			super.handleEntityEvent(b);
		}
	}
	
	@Override
	public boolean isPushedByFluid() 
	{
		if(this.isSemiAquatic())
		{
			return false;
		}
		return true;
	}
	
	public boolean canRandomSwim() 
	{
		if(this.isSemiAquatic())
		{
			return true;
		}
		return false;
	}
	
	@Override
	protected PathNavigator createNavigation(World worldIn) 
	{
		if(!this.isSemiAquatic())
		{
			return new GroundPathNavigator(this, worldIn);
		}
		return super.createNavigation(worldIn);
	}
	
	@Override
	public boolean canBreatheUnderwater() 
	{
		if(this.isSemiAquatic())
		{
			return true;
		}
		return false;
	}
	
	@Override
	protected void registerGoals() 
	{
		super.registerGoals();
		if(!this.isSemiAquatic())
		{
			this.goalSelector.addGoal(0, new SwimGoal(this));
			this.goalSelector.addGoal(1, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
			this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 6.0F));
			this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(4, new ModBreedGoal1(this, 1.0D));
			if(this.isScaredOfPlayer())
			{
				this.goalSelector.addGoal(5, new AvoidEntityGoal<>(this, PlayerEntity.class, 8.0F, 1.6D, 1.4D, EntityPredicates.NO_SPECTATORS::test));
			}
		}
		if(this.isSemiAquatic())
		{
			this.goalSelector.addGoal(0, new RandomWalkingGoal(this, 1.0D));
			this.goalSelector.addGoal(1, new ModSwimSemiAquaticGoal(this, 1.0D, 30));
			this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 6.0F));
			this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(4, new ModBreedGoal1(this, 1.0D));
		if(this.isScaredOfPlayer())
			{
				this.goalSelector.addGoal(5, new AvoidEntityGoal<>(this, PlayerEntity.class, 8.0F, 1.6D, 1.4D, EntityPredicates.NO_SPECTATORS::test));
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
	
	static class SemiAquaticMoveHelperController extends MovementController 
	{
		private final AbstractPrehistoricEntity animal;
		
		SemiAquaticMoveHelperController(final AbstractPrehistoricEntity entity) 
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
}
