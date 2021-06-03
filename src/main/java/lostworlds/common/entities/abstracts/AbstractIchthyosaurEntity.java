package lostworlds.common.entities.abstracts;

import lostworlds.core.util.enums.TimeEras;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class AbstractIchthyosaurEntity extends AbstractPrehistoricEntity implements IAnimatable
{

	public AbstractIchthyosaurEntity(EntityType<? extends AbstractPrehistoricAnimalEntity> entityIn, World worldIn) 
	{
		super(entityIn, worldIn, TimeEras.JURASSIC);
	}

	@Override
	public void registerControllers(AnimationData data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AnimationFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
