package library.entites;

import api.core.init.ItemInit;
import library.entites.bases.AbstractPrehistoricFishEntity;
import library.enums.TimeEras;
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

public class NautilusEntity extends AbstractPrehistoricFishEntity implements IAnimatable
{
	private AnimationFactory factory = new AnimationFactory(this);
	
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) 
	{
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.nautilus.swim", true));
		return PlayState.CONTINUE;
	}

	public NautilusEntity(EntityType<? extends AbstractPrehistoricFishEntity> type, World worldIn) 
	{
		super(type, worldIn, TimeEras.MIX_ERA);
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
		return new ItemStack(ItemInit.NAUTILUS_BUCKET.get());
	}

	@Override
	protected SoundEvent getFlopSound() 
	{
		return SoundEvents.ANVIL_BREAK;
	}
	
	@Override
	protected SoundEvent getAmbientSound() 
	{
		return SoundEvents.BUBBLE_COLUMN_BUBBLE_POP;
	}
	
	@Override
	protected SoundEvent getDeathSound() 
	{
		return SoundEvents.ANVIL_BREAK;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) 
	{
		return SoundEvents.ANVIL_HIT;
	}
}
