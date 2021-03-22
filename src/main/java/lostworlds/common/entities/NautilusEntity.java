package lostworlds.common.entities;

import lostworlds.core.init.ItemInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
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

public class NautilusEntity extends AbstractFishEntity implements IAnimatable
{
	private AnimationFactory factory = new AnimationFactory(this);
	
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) 
	{
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.nautilus.swim", true));
		return PlayState.CONTINUE;
	}

	public NautilusEntity(EntityType<? extends AbstractFishEntity> type, World worldIn) 
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
		return new ItemStack(ItemInit.NAUTILUS_BUCKET.get());
	}

	@Override
	protected SoundEvent getFlopSound() 
	{
		return SoundEvents.BLOCK_ANVIL_BREAK;
	}
	
	protected SoundEvent getAmbientSound() 
	{
		return SoundEvents.BLOCK_BUBBLE_COLUMN_BUBBLE_POP;
	}
	
	protected SoundEvent getDeathSound() 
	{
		return SoundEvents.BLOCK_ANVIL_BREAK;
	}
	
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) 
	{
		return SoundEvents.BLOCK_ANVIL_HIT;
	}
}