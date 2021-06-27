package library.entites;

import api.core.init.EntityInit;
import api.core.init.ItemInit;
import library.entites.bases.AbstractPrehistoricAgeingEntity;
import library.entites.bases.AbstractPrehistoricAnimalEntity;
import library.entites.bases.AbstractPrehistoricEntity;
import library.enums.TimeEras;
import library.goals.ModBreedGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.EntityPredicates;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class CryolophosaurusEntity extends AbstractPrehistoricAnimalEntity implements IAnimatable
{   
    private static final Ingredient FOOD_ITEMS = Ingredient.of(ItemInit.ALLOSAURUS_MEAT.get(), ItemInit.CHILESAURUS_MEAT.get(), ItemInit.KENTROSAURUS_MEAT.get(), ItemInit.OSTROMIA_MEAT.get(), ItemInit.PROTOSUCHUS_MEAT.get());
	private AnimationFactory factory = new AnimationFactory(this);

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) 
	{				
		if(this.entityData.get(AbstractPrehistoricEntity.ATTACKING))
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.cryolophosaurus.attack", true));
		}
		else if(event.isMoving())
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.cryolophosaurus.walk", true));
		}
		else
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.cryolophosaurus.idle", true));
		}	
		return PlayState.CONTINUE;
	}
	
	public CryolophosaurusEntity(EntityType<? extends CryolophosaurusEntity> entityIn, World worldIn) 
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
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, ChilesaurusEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, KentrosaurusEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, OstromiaEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, ProtosuchusEntity.class, false));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<>(this, AllosaurusEntity.class, 8.0F, 1.6D, 1.4D, EntityPredicates.NO_SPECTATORS::test));
	}

	@Override
	public AbstractPrehistoricAgeingEntity getBreedOffspring(ServerWorld serverWorld, AbstractPrehistoricAgeingEntity prehistoricEntity) 
	{
		return EntityInit.CRYOLOPHOSAURUS_ENTITY.get().create(serverWorld);
	}
}