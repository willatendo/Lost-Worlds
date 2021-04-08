package lostworlds.common.entities;

import lostworlds.common.entities.abstracts.AbstractPrehistoricEntity;
import lostworlds.core.init.SoundInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.DolphinEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.passive.OcelotEntity;
import net.minecraft.entity.passive.PandaEntity;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.passive.fish.CodEntity;
import net.minecraft.entity.passive.fish.SalmonEntity;
import net.minecraft.entity.passive.fish.TropicalFishEntity;
import net.minecraft.entity.passive.horse.DonkeyEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.passive.horse.MuleEntity;
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

public class GorgonopsEntity extends AbstractPrehistoricEntity implements IAnimatable
{
	private AnimationFactory factory = new AnimationFactory(this);

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) 
	{
		if(!(animationSpeed > -0.15F && animationSpeed < 0.15F))
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.gorgonops.walking", true));
			return PlayState.CONTINUE;
		}
		else
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.gorgonops.idol", true));
			return PlayState.CONTINUE;
		}
	}

	public GorgonopsEntity(EntityType<? extends GorgonopsEntity> entityIn, World worldIn) 
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
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, PalaeoniscumEntity.class, false));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, RhinesuchusEntity.class, false));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, ProcompsognathusEntity.class, false));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, CowEntity.class, false));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, PigEntity.class, false));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, ChickenEntity.class, false));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, RabbitEntity.class, false));	
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, SheepEntity.class, false));	
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, CatEntity.class, false));	
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, WolfEntity.class, false));	
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, FoxEntity.class, false));	
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, HorseEntity.class, false));	
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, MuleEntity.class, false));	
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, DonkeyEntity.class, false));	
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, OcelotEntity.class, false));	
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, PolarBearEntity.class, false));	
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, PandaEntity.class, false));	
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, ParrotEntity.class, false));	
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, SalmonEntity.class, false));	
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, CodEntity.class, false));	
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, TropicalFishEntity.class, false));	
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, RabbitEntity.class, false));	
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, SquidEntity.class, false));	
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, TurtleEntity.class, false));	
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, DolphinEntity.class, false));
	}
	
	@Override
	protected SoundEvent getAmbientSound() 
	{
		return SoundInit.GORGONOPS_AMBIENT.get();
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) 
	{
		return SoundInit.GORGONOPS_HURT.get();
	}
	
	@Override
	protected SoundEvent getDeathSound() 
	{
		return SoundInit.GORGONOPS_DEATH.get();
	}
}