package lostworlds.common.entities;

import lostworlds.common.entities.abstracts.AbstractPrehistoricAgeingEntity;
import lostworlds.common.entities.abstracts.AbstractPrehistoricLandAndSeaEntity;
import lostworlds.common.goal.PrehistoricBreedGoal;
import lostworlds.core.init.EntityInit;
import lostworlds.core.init.ItemInit;
import lostworlds.core.util.enums.TimeEras;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.passive.fish.CodEntity;
import net.minecraft.entity.passive.fish.SalmonEntity;
import net.minecraft.entity.passive.fish.TropicalFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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

public class GreatAukEntity extends AbstractPrehistoricLandAndSeaEntity implements IAnimatable
{
	private static final Ingredient FOOD_ITEMS = Ingredient.of(Items.COD, Items.SALMON, Items.TROPICAL_FISH, ItemInit.PALAEONISCUM_MEAT.get());
	private AnimationFactory factory = new AnimationFactory(this);

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) 
	{
		if(event.isMoving() && !this.isInWaterOrBubble())
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.great_auk.walk", true));
		}
		else if(event.isMoving() && this.isInWaterOrBubble())
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.great_auk.swim", true));
		}
		else if(!event.isMoving() && this.isInWaterOrBubble())
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.great_auk.swim_idle", true));
		}
		else
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.great_auk.idle", true));
		}	
		return PlayState.CONTINUE;
	}

	public GreatAukEntity(EntityType<? extends GreatAukEntity> entityIn, World worldIn) 
	{
		super(entityIn, worldIn, TimeEras.MODERN);
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
//		this.goalSelector.addGoal(6, new TemptGoal(this, 1.0D, false, FOOD_ITEMS));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, CodEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, SalmonEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, TropicalFishEntity.class, false));
	}
	
	@Override
	public AbstractPrehistoricAgeingEntity getBreedOffspring(ServerWorld serverWorld, AbstractPrehistoricAgeingEntity prehistoricEntity) 
	{
		return EntityInit.GREAT_AUK_ENTITY.get().create(serverWorld);
	}
}
