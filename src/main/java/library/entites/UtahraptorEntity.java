package library.entites;

import api.core.init.EntityInit;
import api.core.init.ItemInit;
import library.entites.bases.AbstractPrehistoricAgeingEntity;
import library.entites.bases.AbstractPrehistoricAnimalEntity;
import library.entites.bases.AbstractPrehistoricEntity;
import library.enums.TimeEras;
import library.goals.ModBreedGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class UtahraptorEntity extends AbstractPrehistoricAnimalEntity implements IAnimatable
{
	private static final Ingredient FOOD_ITEMS = Ingredient.of(ItemInit.CARNOTAURUS_MEAT.get(), ItemInit.FUKUIVENATOR_MEAT.get(), ItemInit.GIGANOTOSAURUS_MEAT.get(), ItemInit.LIAONINGOSAURUS_MEAT.get(), ItemInit.OURANOSAURUS_MEAT.get(), ItemInit.PSITTACOSAURUS_MEAT.get(), ItemInit.SUCHOMIMUS_MEAT.get(), ItemInit.TYRANNOSAURUS_MEAT.get(), ItemInit.ZEPHYROSAURUS_MEAT.get());
	private AnimationFactory factory = new AnimationFactory(this);

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) 
	{				
		if(this.entityData.get(AbstractPrehistoricEntity.ATTACKING))
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.utahraptor.attack", true));
		}
		else if(event.isMoving())
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.utahraptor.walk", true));
		}
		else
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.utahraptor.idle", true));
		}	
		return PlayState.CONTINUE;
	}
	
	public UtahraptorEntity(EntityType<? extends UtahraptorEntity> entityIn, World worldIn) 
	{
		super(entityIn, worldIn, TimeEras.CRETACEOUS);
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
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, FukuivenatorEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, OuranosaurusEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, PsittacosaurusEntity.class, false));
	}

	@Override
	public AbstractPrehistoricAgeingEntity getBreedOffspring(ServerWorld serverWorld, AbstractPrehistoricAgeingEntity prehistoricEntity) 
	{
		return EntityInit.UTAHRAPTOR_ENTITY.get().create(serverWorld);
	}
}
