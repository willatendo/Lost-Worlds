package lostworlds.common.entities;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class DiictodonEntity extends CreatureEntity implements IAnimatable
{
	protected DiictodonEntity(EntityType<? extends CreatureEntity> type, World worldIn) 
	{
		super(type, worldIn);
	}

	@Override
	public void registerControllers(AnimationData data) 
	{
		
	}

	@Override
	public AnimationFactory getFactory() 
	{
		return null;
	}
	
}
