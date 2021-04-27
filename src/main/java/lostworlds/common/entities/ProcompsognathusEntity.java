package lostworlds.common.entities;

import lostworlds.common.entities.abstracts.AbstractPrehistoricAgeingEntity;
import lostworlds.common.entities.abstracts.AbstractPrehistoricAnimalEntity;
import lostworlds.common.goal.PrehistoricBreedGoal;
import lostworlds.core.init.EntityInit;
import lostworlds.core.init.ItemInit;
import lostworlds.core.init.SoundInit;
import lostworlds.core.util.enums.TimeEras;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class ProcompsognathusEntity extends AbstractPrehistoricAnimalEntity implements IAnimatable
{	
	private static final Ingredient FOOD_ITEMS = Ingredient.of(Items.PORKCHOP, Items.BEEF, Items.RABBIT, Items.CHICKEN, Items.MUTTON, Items.COD, Items.SALMON, Items.TROPICAL_FISH, ItemInit.DIMETRODON_MEAT.get(), ItemInit.EDAPHOSAURUS_MEAT.get(), ItemInit.GORGONOPS_MEAT.get(), ItemInit.PALAEONISCUM_MEAT.get(), ItemInit.PROCOMPSOGNATHUS_MEAT.get(), ItemInit.RHINESUCHUS_MEAT.get());
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
		super(type, worldIn, TimeEras.TRIASSIC);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void registerControllers(AnimationData data) 
	{
		data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
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
		this.goalSelector.addGoal(5, new PrehistoricBreedGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new TemptGoal(this, 1.0D, false, FOOD_ITEMS));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, ChickenEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, ParrotEntity.class, false));
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
	protected SoundEvent getAmbientSound() 
	{
		return SoundInit.COMPY_AMBIENT.get();
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

	@Override
	public AbstractPrehistoricAgeingEntity getBreedOffspring(ServerWorld serverWorld, AbstractPrehistoricAgeingEntity prehistoricEntity) 
	{
		return EntityInit.PROCOMPSOGNATHUS_ENTITY.get().create(serverWorld);
	}
}
