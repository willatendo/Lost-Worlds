package lostworlds.common.entities.abstracts;

import java.util.List;
import java.util.stream.Stream;

import javax.annotation.Nullable;

import lostworlds.common.goal.ModFollowSchoolLeaderGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

public abstract class AbstractPrehistoricGroupFishEntity extends AbstractPrehistoricFishEntity
{
	private AbstractPrehistoricGroupFishEntity leader;
	private int schoolSize = 1;
	
	public AbstractPrehistoricGroupFishEntity(EntityType<? extends AbstractPrehistoricGroupFishEntity> entityIn, World worldIn) 
	{
		super(entityIn, worldIn);
	}
	
	protected void registerGoals() 
	{
		super.registerGoals();
		this.goalSelector.addGoal(5, new ModFollowSchoolLeaderGoal(this));
	}
	
	public int getMaxSpawnClusterSize() 
	{
		return this.getMaxSchoolSize();
	}
	
	public int getMaxSchoolSize() 
	{
		return super.getMaxSpawnClusterSize();
	}
	
	public boolean canRandomSwim() 
	{
		return !this.isFollower();
	}
	
	public boolean isFollower() 
	{
		return this.leader != null && this.leader.isAlive();
	}
	
	public AbstractPrehistoricGroupFishEntity startFollowing(AbstractPrehistoricGroupFishEntity entity) 
	{
		this.leader = entity;
		entity.addFollower();
		return entity;
	}
	
	public void stopFollowing() 
	{
		this.leader.removeFollower();
		this.leader = null;
	}
	
	private void addFollower() 
	{
		++this.schoolSize;
	}
	
	private void removeFollower() 
	{
		--this.schoolSize;
	}
	
	public boolean canBeFollowed() 
	{
		return this.hasFollowers() && this.schoolSize < this.getMaxSchoolSize();
	}
	
	public void tick() 
	{
		super.tick();
		if(this.hasFollowers() && this.level.random.nextInt(200) == 1) 
		{
			List<AbstractPrehistoricFishEntity> list = this.level.getEntitiesOfClass(this.getClass(), this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D));
			if(list.size() <= 1) 
			{
				this.schoolSize = 1;
			}
		}
	}
	
	public boolean hasFollowers() 
	{
		return this.schoolSize > 1;
	}
	
	public boolean inRangeOfLeader() 
	{
		return this.distanceToSqr(this.leader) <= 121.0D;
	}
	
	public void pathToLeader() 
	{
		if(this.isFollower()) 
		{
			this.getNavigation().moveTo(this.leader, 1.0D);
		}
	}
	
	public void addFollowers(Stream<AbstractPrehistoricGroupFishEntity> p_212810_1_) 
	{
		p_212810_1_.limit((long)(this.getMaxSchoolSize() - this.schoolSize)).filter((p_212801_1_) -> 
		{
			return p_212801_1_ != this;
		}).forEach((p_212804_1_) -> 
		{
			p_212804_1_.startFollowing(this);
		});
	}
	
	@Nullable
	public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficultyInstance, SpawnReason spawnReason, @Nullable ILivingEntityData entityData, @Nullable CompoundNBT nbt) 
	{
		super.finalizeSpawn(world, difficultyInstance, spawnReason, entityData, nbt);
		if(entityData == null) 
		{
			entityData = new AbstractPrehistoricGroupFishEntity.GroupData(this);
		} 
		else 
		{
			this.startFollowing(((AbstractPrehistoricGroupFishEntity.GroupData)entityData).leader);
		}
		
		return entityData;
	}
	
	public static class GroupData implements ILivingEntityData 
	{
		public final AbstractPrehistoricGroupFishEntity leader;
		
		public GroupData(AbstractPrehistoricGroupFishEntity entity) 
		{
			this.leader = entity;
		}
	}
}
