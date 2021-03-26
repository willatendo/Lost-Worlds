package lostworlds.common.entities;

import lostworlds.common.entities.abstracts.AbstractAmphibianEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class RhinesuchusEntity extends AbstractAmphibianEntity implements IAnimatable
{
	private AnimationFactory factory = new AnimationFactory(this);
	
	public RhinesuchusEntity(EntityType<? extends RhinesuchusEntity> entityIn, World worldIn) 
	{
		super(entityIn, worldIn);
	}

	@Override
	public void registerControllers(AnimationData data) 
	{
		
	}

	@Override
	public AnimationFactory getFactory() 
	{
		return this.factory;
	}
	
	@Override
	protected void registerGoals() 
	{
		super.registerGoals();
		this.goalSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
	}
}
