package lostworlds.common.entities;

import lostworlds.common.entities.abstracts.AbstractAmphibianEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

//Rhinesuchus -- Subject to rewrite!
public class RhinesuchusEntity extends AbstractAmphibianEntity implements IAnimatable, IMob
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
		if(!(animationSpeed > -0.15F && animationSpeed < 0.15F) && !isInWater())
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.rhinesuchus.walking", true));
			return PlayState.CONTINUE;
		}
		else if(isInWater())
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.rhinesuchus.swimming", true));
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
	protected void registerGoals() 
	{
		super.registerGoals();
		this.goalSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
	}
}
