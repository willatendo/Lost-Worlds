package lostworlds.common.entities.abstracts;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public abstract class LostWorldsEntity extends CreatureEntity
{
	public LostWorldsEntity(EntityType<? extends LostWorldsEntity> entity, World world) 
	{
		super(entity, world);
	}	
}
