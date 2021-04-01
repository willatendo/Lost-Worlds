package lostworlds.common.entities.abstracts;

import javax.annotation.Nullable;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public abstract class AbstractPrehistoricAgeingEntity extends AbstractPrehistoricEntity
{
	private static final DataParameter<Boolean> DATA_BABY_ID = EntityDataManager.defineId(AgeableEntity.class, DataSerializers.BOOLEAN);
	
	protected int age;
	protected int forcedAge;
	protected int forcedAgeTimer;
	
	public AbstractPrehistoricAgeingEntity(EntityType<? extends AbstractPrehistoricAgeingEntity> entityIn, World worldIn) 
	{
		super(entityIn, worldIn);
	}
	public ILivingEntityData finalizeSpawn(IServerWorld serverWorld, DifficultyInstance difficultyInstance, SpawnReason spawnReason, @Nullable ILivingEntityData entityData, @Nullable CompoundNBT nbt) 
	{
		if(entityData == null) 
		{
			entityData = new AgeableEntity.AgeableData(true);
		}
		
		AgeableEntity.AgeableData ageableentity$ageabledata = (AgeableEntity.AgeableData)entityData;
		if(ageableentity$ageabledata.isShouldSpawnBaby() && ageableentity$ageabledata.getGroupSize() > 0 && this.random.nextFloat() <= ageableentity$ageabledata.getBabySpawnChance()) 
		{
			this.setAge(-24000);
		}
		
		ageableentity$ageabledata.increaseGroupSizeByOne();
		return super.finalizeSpawn(serverWorld, difficultyInstance, spawnReason, entityData, nbt);
	}
	
	@Nullable
	public abstract AbstractPrehistoricEntity getBreedOffspring(ServerWorld serverWorld, AbstractPrehistoricEntity prehistoricEntity);
	
	protected void defineSynchedData() 
	{
		super.defineSynchedData();
		this.entityData.define(DATA_BABY_ID, false);
	}
	
	public boolean canBreed() 
	{
		return false;
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
	
	public void ageUp(int integer, boolean bool) 
	{
		int i = this.getAge();
		i = i + integer * 20;
		if(i > 0) 
		{
			i = 0;
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
	
	public void ageUp(int integer) 
	{
		this.ageUp(integer, false);
	}
	
	public void setAge(int integer) 
	{
		int i = this.age;
		this.age = integer;
		if(i < 0 && integer >= 0 || i >= 0 && integer < 0) 
		{
			this.entityData.set(DATA_BABY_ID, integer < 0);
			this.ageBoundaryReached();
		}
	}
	
	public void addAdditionalSaveData(CompoundNBT nbt) 
	{
		super.addAdditionalSaveData(nbt);
		nbt.putInt("Age", this.getAge());
		nbt.putInt("ForcedAge", this.forcedAge);
	}
	
	public void readAdditionalSaveData(CompoundNBT nbt) 
	{
		super.readAdditionalSaveData(nbt);
		this.setAge(nbt.getInt("Age"));
		this.forcedAge = nbt.getInt("ForcedAge");
	}
	
	public void onSyncedDataUpdated(DataParameter<?> dataParameter) 
	{
		if(DATA_BABY_ID.equals(dataParameter)) 
		{
			this.refreshDimensions();
		}
		super.onSyncedDataUpdated(dataParameter);
	}
	
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
			if(i < 0) 
			{
				++i;
				this.setAge(i);
			} 
			else if(i > 0) 
			{
				--i;
				this.setAge(i);
			}
		}
	}

	protected void ageBoundaryReached() 
	{
		
	}
	
	public boolean isBaby() 
	{
		return this.getAge() < 0;
	}
	
	public void setBaby(boolean bool) 
	{
		this.setAge(bool ? -24000 : 0);
	}
}
