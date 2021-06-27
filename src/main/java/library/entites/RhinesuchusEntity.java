package library.entites;

import api.core.init.EntityInit;
import library.entites.bases.AbstractPrehistoricAgeingEntity;
import library.entites.bases.AbstractPrehistoricLandAndSeaEntity;
import library.enums.TimeEras;
import library.goals.ModBreedGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class RhinesuchusEntity extends AbstractPrehistoricLandAndSeaEntity implements IAnimatable
{
    private static final Ingredient FOOD_ITEMS = Ingredient.of(Items.BONE);
	private AnimationFactory factory = new AnimationFactory(this);
	
	public RhinesuchusEntity(EntityType<? extends RhinesuchusEntity> entityIn, World worldIn) 
	{
		super(entityIn, worldIn, TimeEras.PERMIAN);
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
	public boolean isHostile() 
	{
		return true;
	}
	
	@Override
	protected void registerGoals()
	{
		super.registerGoals();
		this.goalSelector.addGoal(5, new ModBreedGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new TemptGoal(this, 1.0D, false, FOOD_ITEMS));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
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

	@Override
	public AbstractPrehistoricAgeingEntity getBreedOffspring(ServerWorld serverWorld, AbstractPrehistoricAgeingEntity prehistoricEntity) 
	{
		return EntityInit.RHINESUCHUS_ENTITY.get().create(serverWorld);
	}
}
