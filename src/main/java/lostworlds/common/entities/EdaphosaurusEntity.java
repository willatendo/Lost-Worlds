package lostworlds.common.entities;

import lostworlds.common.entities.abstracts.AbstractPrehistoricEntity;
import lostworlds.core.init.SoundInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class EdaphosaurusEntity extends AbstractPrehistoricEntity implements IAnimatable
{
	private AnimationFactory factory = new AnimationFactory(this);

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) 
	{
		if(!(animationSpeed > -0.15F && animationSpeed < 0.15F))
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.edaphosaurus.walking", true));
			return PlayState.CONTINUE;
		}
		else
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.edaphosaurus.idol", true));
			return PlayState.CONTINUE;
		}
	}
	
	public EdaphosaurusEntity(EntityType<? extends EdaphosaurusEntity> entityIn, World worldIn) 
	{
		super(entityIn, worldIn);
	}

	@Override
	public void registerControllers(AnimationData data) 
	{
		data.addAnimationController(new AnimationController<IAnimatable>(this, "controller", 0, this::predicate));
	}
	
	@Override
	protected void registerGoals() 
	{
		super.registerGoals();
		this.goalSelector.addGoal(4, new AvoidEntityGoal<>(this, DimetrodonEntity.class, 8.0F, 1.6D, 1.4D, EntityPredicates.NO_SPECTATORS::test));
	}

	@Override
	public AnimationFactory getFactory() 
	{
		return this.factory;
	}
	
	@Override
	public boolean isHostile() 
	{
		return false;
	}
	
	@Override
	public boolean isScaredOfPlayer() 
	{
		return false;
	}
	
	@Override
	public boolean isFish() 
	{
		return false;
	}
	
	@Override
	protected SoundEvent getAmbientSound() 
	{
		return SoundInit.EDAPHOSAURUS_AMBIENT.get();
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) 
	{
		return SoundInit.EDAPHOSAURUS_HURT.get();
	}
	
	@Override
	protected SoundEvent getDeathSound() 
	{
		return SoundInit.EDAPHOSAURUS_DEATH.get();
	}
}
