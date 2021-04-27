package lostworlds.common.entities;

import lostworlds.common.entities.abstracts.AbstractPrehistoricGroupFishEntity;
import lostworlds.core.init.ItemInit;
import lostworlds.core.util.enums.TimeEras;
import net.minecraft.entity.EntityType;
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

public class PalaeoniscumEntity extends AbstractPrehistoricGroupFishEntity implements IAnimatable
{
	private AnimationFactory factory = new AnimationFactory(this);
	
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) 
	{
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.palaeoniscum.swim", true));
		return PlayState.CONTINUE;
	}
	
	public PalaeoniscumEntity(EntityType<? extends AbstractPrehistoricGroupFishEntity> type, World worldIn) 
	{
		super(type, worldIn, TimeEras.PERMIAN);
		this.noCulling = true;
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
	protected ItemStack getBucketItemStack() 
	{
		return new ItemStack(ItemInit.PALAEONISCUM_BUCKET.get());
	}

	@Override
	protected SoundEvent getFlopSound() 
	{
		return SoundEvents.TROPICAL_FISH_FLOP;
	}
	
	protected SoundEvent getAmbientSound() 
	{
		return SoundEvents.COD_AMBIENT;
	}
	
	protected SoundEvent getDeathSound() 
	{
		return SoundEvents.COD_DEATH;
	}
	
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) 
	{
		return SoundEvents.COD_HURT;
	}
}