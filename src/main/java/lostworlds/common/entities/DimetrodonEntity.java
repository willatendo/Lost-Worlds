package lostworlds.common.entities;

import lostworlds.common.entities.abstracts.AbstractPrehistoricEntity;
import lostworlds.core.init.SoundInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
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

public class DimetrodonEntity extends AbstractPrehistoricEntity implements IAnimatable
{
	private AnimationFactory factory = new AnimationFactory(this);

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) 
	{
		if(!(animationSpeed > -0.15F && animationSpeed < 0.15F))
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dimetrodon.walking", true));
			return PlayState.CONTINUE;
		}
		else
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dimetrodon.idol", true));
			return PlayState.CONTINUE;
		}
	}
	
	public DimetrodonEntity(EntityType<? extends DimetrodonEntity> entityIn, World worldIn) 
	{
		super(entityIn, worldIn);
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
	public boolean isFish() 
	{
		return false;
	}
	
	@Override
	protected void registerGoals() 
	{
		super.registerGoals();
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EdaphosaurusEntity.class, false));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, CowEntity.class, false));
		this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, PigEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, ChickenEntity.class, false));
		this.targetSelector.addGoal(8, new NearestAttackableTargetGoal<>(this, RabbitEntity.class, false));	
		this.targetSelector.addGoal(9, new NearestAttackableTargetGoal<>(this, SheepEntity.class, false));	
	}
	
	@Override
	protected SoundEvent getAmbientSound() 
	{
		return SoundInit.DIMETRODON_AMBIENT.get();
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) 
	{
		return SoundInit.DIMETRODON_HURT.get();
	}
	
	@Override
	protected SoundEvent getDeathSound() 
	{
		return SoundInit.DIMETRODON_DEATH.get();
	}
}
