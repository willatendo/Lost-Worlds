package lostworlds.common.entities;

import lostworlds.common.entities.abstracts.AbstractLostWorldsEntity;
import lostworlds.core.init.SoundInit;
import net.minecraft.entity.EntityType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class ProcompsognathusEntity extends AbstractLostWorldsEntity implements IAnimatable
{	
	private AnimationFactory factory = new AnimationFactory(this);

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) 
	{
		if(!(animationSpeed > -0.15F && animationSpeed < 0.15F))
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.procompsognathus.walk", true));
			return PlayState.CONTINUE;
		}
		else
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.procompsognathus.idol", true));
			return PlayState.CONTINUE;
		}
	}

	public ProcompsognathusEntity(EntityType<? extends ProcompsognathusEntity> type, World worldIn) 
	{
		super(type, worldIn);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void registerControllers(AnimationData data) 
	{
		data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() 
	{
		return this.factory;
	}
	
	@Override
	public boolean isHostile() 
	{
		return true;
	}
	
	@Override
	public boolean isScaredOfPlayer() 
	{
		return false;
	}
	
	@Override
	protected SoundEvent getAmbientSound() 
	{
		return SoundInit.COMPY_AMBIANT.get();
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) 
	{
		return SoundInit.COMPY_HURT.get();
	}
	
	@Override
	protected SoundEvent getDeathSound() 
	{
		return SoundInit.COMPY_DEATH.get();
	}
	
	
}
