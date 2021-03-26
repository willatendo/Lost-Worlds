package lostworlds.common.entities.abstracts;

import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public abstract class AbstractLandAndWaterMobEntity extends CreatureEntity
{
	public AbstractLandAndWaterMobEntity(EntityType<? extends AbstractLandAndWaterMobEntity> entityIn, World worldIn) 
	{
		super(entityIn, worldIn);
		this.setPathfindingMalus(PathNodeType.DANGER_FIRE, 16.0F);
		this.setPathfindingMalus(PathNodeType.WATER, 0.0F);
	}
	
	@Override
	public boolean canBreatheUnderwater() 
	{
		return false;
	}
	
	@Override
	public CreatureAttribute getMobType() 
	{
		return CreatureAttribute.WATER;
	}
	
	public boolean checkSpawnObstruction(IWorldReader iWorldReader) 
	{
		return iWorldReader.isUnobstructed(this);
	}
	
	protected void handleAirSupply(int time) 
	{
		if (this.isAlive() && this.isInWaterOrBubble()) 
		{
			this.setAirSupply(time - 1);
			if (this.getAirSupply() == -20) 
			{
				this.setAirSupply(0);
				this.hurt(DamageSource.DROWN, 1.0F);
			}
		}
		else 
		{
			this.setAirSupply(6000);
		}
	}
	
	public void baseTick() 
	{
		int i = this.getAirSupply();
		super.baseTick();
		this.handleAirSupply(i);
	}
	
	public boolean isPushedByFluid() 
	{
		return false;
	}
	
	public boolean canBeLeashed(PlayerEntity player) 
	{
		return true;
	}
}
