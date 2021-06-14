package lostworlds.common.entities.abstracts;

import lostworlds.core.util.enums.TimeEras;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public abstract class AbstractPrehistoricCarnivourEntity extends AbstractPrehistoricAnimalEntity
{
	public AbstractPrehistoricCarnivourEntity(EntityType<? extends AbstractPrehistoricAnimalEntity> entityIn, World worldIn, TimeEras timeEra) 
	{
		super(entityIn, worldIn, timeEra);
	}
}
