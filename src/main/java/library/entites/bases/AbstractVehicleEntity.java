package library.entites.bases;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public abstract class AbstractVehicleEntity extends Entity
{
	public AbstractVehicleEntity(EntityType<?> entity, World worldIn) 
	{
		super(entity, worldIn);
	}    
}
