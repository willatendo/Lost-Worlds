package lostworlds.common.entities.abstracts;

import lostworlds.core.util.ModDamageSources;
import lostworlds.core.util.enums.TimeEras;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

public abstract class AbstractPrehistoricCarnivoreEntity extends AbstractPrehistoricAnimalEntity
{
	private static final DataParameter<Integer> HUNGER = EntityDataManager.defineId(AbstractPrehistoricCarnivoreEntity.class, DataSerializers.INT);
	private static final DataParameter<Boolean> KILLED = EntityDataManager.defineId(AbstractPrehistoricCarnivoreEntity.class, DataSerializers.BOOLEAN);
	
	public AbstractPrehistoricCarnivoreEntity(EntityType<? extends AbstractPrehistoricAnimalEntity> entityIn, World worldIn, TimeEras timeEra) 
	{
		super(entityIn, worldIn, timeEra);
	}
	
	public boolean getKilled()
	{
		return this.entityData.get(KILLED);
	}
	
	public void setKilled(boolean killed) 
	{
		this.entityData.set(KILLED, killed);
	}
	
	public boolean hasKilled()
	{
		return this.getKilled() == true;
	}
	
	public int getHunger()
	{
		return this.entityData.get(HUNGER);
	}
	
	public void setHunger(int hunger) 
	{
		this.entityData.set(HUNGER, hunger);
	}
	
	public boolean isHungry()
	{
		return this.getHunger() <= 0;
	}
	
	@Override
	protected void defineSynchedData() 
	{
		super.defineSynchedData();
		this.entityData.define(HUNGER, 2400);
		this.entityData.define(KILLED, false);
	}

	@Override
	public void addAdditionalSaveData(CompoundNBT nbt) 
	{
		super.addAdditionalSaveData(nbt);
		nbt.putInt("Hunger", this.getHunger());
		nbt.putBoolean("Killed", this.getKilled());
	}

	@Override
	public void readAdditionalSaveData(CompoundNBT nbt) 
	{
		super.readAdditionalSaveData(nbt); 
		this.setHunger(nbt.getInt("Hunger"));
		this.setKilled(nbt.getBoolean("Killed"));
	}
	
	@Override
	public void tick() 
	{
		super.tick();
		if(this.hasKilled()) 
		{
			this.setHunger(2400);
		}
		else
		{
			this.setHunger(this.getHunger() - 1);
			if(this.getHunger() < -30)
			{
				this.hurt(ModDamageSources.HUNGER, 200.0F);
			}
		}
	}
	
	@Override
	protected void registerGoals() 
	{
		super.registerGoals();
	}
}
