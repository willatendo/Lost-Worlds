package lostworlds.common.entities;

import lostworlds.common.entities.abstracts.AbstractPrehistoricAgeingEntity;
import lostworlds.common.entities.abstracts.AbstractPrehistoricAnimalEntity;
import lostworlds.common.goal.ModBreedGoal;
import lostworlds.core.init.EntityInit;
import lostworlds.core.init.ItemInit;
import lostworlds.core.util.enums.TimeEras;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.player.PlayerEntity;
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

public class LiaoningosaurusEntity extends AbstractPrehistoricAnimalEntity implements IAnimatable
{
	private static final Ingredient FOOD_ITEMS = Ingredient.of(Items.FERN, Items.GRASS, ItemInit.GROUND_FERNS.get(), ItemInit.DICKSONIA.get(), ItemInit.TALL_DICKSONIA.get(), ItemInit.CYCAD.get(),ItemInit.CYCAD_SEEDS.get(), ItemInit.OSMUNDA.get(), ItemInit.OSMUNDA_SEEDS.get(), ItemInit.DUISBERGIA.get(), ItemInit.DUISBERGIA_SEEDS.get(), ItemInit.CEPHALOTAXUS.get(),ItemInit.CEPHALOTAXUS_SEEDS.get(), ItemInit.LYCOPHYTA.get(), ItemInit.LYCOPHYTA_SEEDS.get(), ItemInit.DILLHOFFIA.get(), ItemInit.DILLHOFFIA_SEEDS.get());
	private AnimationFactory factory = new AnimationFactory(this);
	
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) 
	{
		if(event.isMoving())
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.liaoningosaurus.walk", true));
		}
		else
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.liaoningosaurus.idle", true));
		}	
		return PlayState.CONTINUE;
	}
	
	public LiaoningosaurusEntity(EntityType<? extends LiaoningosaurusEntity> entityIn, World worldIn) 
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
		this.goalSelector.addGoal(7, new AvoidEntityGoal<>(this, CarnotaurusEntity.class, 8.0F, 1.6D, 1.4D, EntityPredicates.NO_SPECTATORS::test));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<>(this, PlayerEntity.class, 8.0F, 1.6D, 1.4D, EntityPredicates.NO_SPECTATORS::test));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<>(this, CarnotaurusEntity.class, 8.0F, 1.6D, 1.4D, EntityPredicates.NO_SPECTATORS::test));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<>(this, TyrannosaurusEntity.class, 8.0F, 1.6D, 1.4D, EntityPredicates.NO_SPECTATORS::test));
	}
	
	@Override
	public AbstractPrehistoricAgeingEntity getBreedOffspring(ServerWorld serverWorld, AbstractPrehistoricAgeingEntity prehistoricEntity) 
	{
		return EntityInit.LIAONINGOSAURUS_ENTITY.get().create(serverWorld);
	}
}
