package lostworlds.common.entities;

import java.util.UUID;

import javax.annotation.Nullable;

import lostworlds.common.entities.abstracts.AbstractPrehistoricAgeingEntity;
import lostworlds.common.entities.abstracts.AbstractPrehistoricAnimalEntity;
import lostworlds.common.entities.abstracts.AbstractPrehistoricEntity;
import lostworlds.common.goal.ModBreedGoal;
import lostworlds.core.init.EntityInit;
import lostworlds.core.init.ItemInit;
import lostworlds.core.util.enums.TimeEras;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IAngerable;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.ResetAngerGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.RangedInteger;
import net.minecraft.util.TickRangeConverter;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class KentrosaurusEntity extends AbstractPrehistoricAnimalEntity implements IAnimatable, IAngerable
{
	private static final Ingredient FOOD_ITEMS = Ingredient.of(ItemInit.GROUND_FERNS.get(), ItemInit.DICKSONIA.get(), ItemInit.TALL_DICKSONIA.get(), ItemInit.CYCAD.get(), ItemInit.OSMUNDA.get(), ItemInit.DUISBERGIA.get(), ItemInit.CEPHALOTAXUS.get(), ItemInit.LYCOPHYTA.get(), ItemInit.DILLHOFFIA.get());
    private static final RangedInteger PERSISTENT_ANGER_TIME = TickRangeConverter.rangeOfSeconds(20, 39);
	private AnimationFactory factory = new AnimationFactory(this);
	private int remainingPersistentAngerTime;
	private UUID persistentAngerTarget;

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) 
	{				
		if(this.entityData.get(AbstractPrehistoricEntity.ATTACKING))
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.kentrosaurus.attack", true));
		}
		else if(event.isMoving())
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.kentrosaurus.walk", true));
		}
		else
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.kentrosaurus.idle", true));
		}	
		return PlayState.CONTINUE;
	}
	
	public KentrosaurusEntity(EntityType<? extends KentrosaurusEntity> entityIn, World worldIn) 
	{
		super(entityIn, worldIn, TimeEras.JURASSIC);
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
	public boolean isFood(ItemStack stack) 
	{
		return FOOD_ITEMS.test(stack);
	}
	
	@Override
	protected void registerGoals()
	{
		super.registerGoals();
		this.goalSelector.addGoal(5, new ModBreedGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new TemptGoal(this, 1.0D, false, FOOD_ITEMS));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false, this::isAngryAt));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, AllosaurusEntity.class, 10, true, false, this::isAngryAt));
		this.targetSelector.addGoal(8, new ResetAngerGoal<>(this, false));
	}

	@Override
	public AbstractPrehistoricAgeingEntity getBreedOffspring(ServerWorld serverWorld, AbstractPrehistoricAgeingEntity prehistoricEntity) 
	{
		return EntityInit.KENTROSAURUS_ENTITY.get().create(serverWorld);
	}
	
	@Override
	public void startPersistentAngerTimer() 
	{
		this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.randomValue(this.random));
	}
	
	@Override
	public int getRemainingPersistentAngerTime() 
	{
		return this.remainingPersistentAngerTime;
	}
	
	@Override
	public void setRemainingPersistentAngerTime(int time) 
	{
		this.remainingPersistentAngerTime = time;
	}
	
	@Override
	public UUID getPersistentAngerTarget() 
	{
		return this.persistentAngerTarget;
	}
	
	@Override
	public void setPersistentAngerTarget(@Nullable UUID target) 
	{
		this.persistentAngerTarget = target;
	}
	
	public void addAdditionalSaveData(CompoundNBT nbt) 
	{
		super.addAdditionalSaveData(nbt);
		this.addPersistentAngerSaveData(nbt);
	}
	
	public void readAdditionalSaveData(CompoundNBT nbt) 
	{
		super.readAdditionalSaveData(nbt);
		this.readPersistentAngerSaveData((ServerWorld)this.level, nbt);
	}
}
