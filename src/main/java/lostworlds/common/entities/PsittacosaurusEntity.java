package lostworlds.common.entities;

import lostworlds.common.entities.abstracts.AbstractPrehistoricAgeingEntity;
import lostworlds.common.entities.abstracts.AbstractPrehistoricAnimalEntity;
import lostworlds.common.goal.PrehistoricBreedGoal;
import lostworlds.core.init.EntityInit;
import lostworlds.core.util.enums.TimeEras;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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

public class PsittacosaurusEntity extends AbstractPrehistoricAnimalEntity implements IAnimatable
{
	private static final Ingredient FOOD_ITEMS = Ingredient.of(Items.GRASS, Items.FERN);
	private AnimationFactory factory = new AnimationFactory(this);

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) 
	{
		if(event.isMoving())
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.psittacosaurus.walk", true));
		}
		else
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.psittacosaurus.idle", true));
		}	
		return PlayState.CONTINUE;
	}

	public PsittacosaurusEntity(EntityType<? extends PsittacosaurusEntity> entityIn, World worldIn) 
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
		return false;
	}
	
	@Override
	public boolean isScaredOfPlayer() 
	{
		return true;
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
		this.goalSelector.addGoal(5, new PrehistoricBreedGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new TemptGoal(this, 1.0D, false, FOOD_ITEMS));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<>(this, CarnotaurusEntity.class, 8.0F, 1.6D, 1.4D, EntityPredicates.NO_SPECTATORS::test));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<>(this, GiganotosaurusEntity.class, 8.0F, 1.6D, 1.4D, EntityPredicates.NO_SPECTATORS::test));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<>(this, TyrannosaurusEntity.class, 8.0F, 1.6D, 1.4D, EntityPredicates.NO_SPECTATORS::test));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<>(this, SuchomimusEntity.class, 8.0F, 1.6D, 1.4D, EntityPredicates.NO_SPECTATORS::test));
	}

	@Override
	public AbstractPrehistoricAgeingEntity getBreedOffspring(ServerWorld serverWorld, AbstractPrehistoricAgeingEntity prehistoricEntity) 
	{
		return EntityInit.PSITTACOSAURUS_ENTITY.get().create(serverWorld);
	}
}
