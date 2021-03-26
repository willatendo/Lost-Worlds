package lostworlds.common.entities.abstracts;

import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public abstract class AbstractLandAndWaterMobEntity extends CreatureEntity
{
	public AbstractLandAndWaterMobEntity(EntityType<? extends AbstractLandAndWaterMobEntity> entityIn, World worldIn) 
	{
		super(entityIn, worldIn);
	}
	
	@Override
	public boolean canBreatheUnderwater() 
	{
		return true;
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
	
	public boolean isPushedByFluid() 
	{
		return false;
	}
	
	public boolean canBeLeashed(PlayerEntity player) 
	{
		return true;
	}
}
