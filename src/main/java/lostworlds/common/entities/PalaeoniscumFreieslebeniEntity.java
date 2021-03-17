package lostworlds.common.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.item.ItemStack;
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

public class PalaeoniscumFreieslebeniEntity extends AbstractGroupFishEntity implements IAnimatable
{
	private AnimationFactory factory = new AnimationFactory(this);
	
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) 
	{
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.palaeoniscum.swim", true));
		return PlayState.CONTINUE;
	}
	
	public PalaeoniscumFreieslebeniEntity(EntityType<? extends AbstractGroupFishEntity> type, World worldIn) 
	{
		super(type, worldIn);
		this.ignoreFrustumCheck = true;
	}

	@Override
	public void registerControllers(AnimationData data) 
	{
		data.addAnimationController(new AnimationController<IAnimatable>(this, "controller", 0, this::predicate));
	}
	
	@Override
	public AnimationFactory getFactory() 
	{
		return this.factory;
	}

	@Override
	protected ItemStack getFishBucket() 
	{
		return null;
	}

	@Override
	protected SoundEvent getFlopSound() 
	{
		return SoundEvents.ENTITY_TROPICAL_FISH_FLOP;
	}
	
	protected SoundEvent getAmbientSound() 
	{
		return SoundEvents.ENTITY_COD_AMBIENT;
	}
	
	protected SoundEvent getDeathSound() 
	{
		return SoundEvents.ENTITY_COD_DEATH;
	}
	
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) 
	{
		return SoundEvents.ENTITY_COD_HURT;
	}
}