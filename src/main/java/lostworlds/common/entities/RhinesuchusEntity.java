package lostworlds.common.entities;

import lostworlds.common.entities.abstracts.AbstractAmphibianEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
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
		data.addAnimationController(new AnimationController<>(this, "controller", 2, this::predicate));
	}
	
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) 
	{
		if(!(animationSpeed > -0.15F && animationSpeed < 0.15F))
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.rhinesuchus.swim", true));
			return PlayState.CONTINUE;
		}
		else
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.rhinesuchus.idol", true));
			return PlayState.CONTINUE;
		}
	}
	
	@Override
	public AnimationFactory getFactory() 
	{
		return this.factory;
	}
	
	@Override
	protected SoundEvent getAmbientSound() 
	{
		return SoundEvents.SLIME_BLOCK_STEP;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource source) 
	{
		return SoundEvents.SLIME_BLOCK_HIT;
	}
	
	@Override
	protected SoundEvent getDeathSound() 
	{
		return SoundEvents.SLIME_BLOCK_HIT;
	}
}
