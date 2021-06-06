package lostworlds.common.entities;

import lostworlds.common.entities.abstracts.AbstractPrehistoricAgeingEntity;
import lostworlds.common.entities.abstracts.AbstractPrehistoricEntity;
import lostworlds.common.entities.abstracts.AbstractPrehistoricLandAndSeaEntity;
import lostworlds.common.goal.ModBreedGoal;
import lostworlds.common.goal.ModLandAndWaterTemptGoal;
import lostworlds.core.init.EntityInit;
import lostworlds.core.init.ItemInit;
import lostworlds.core.util.enums.TimeEras;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
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

public class SuchomimusEntity extends AbstractPrehistoricLandAndSeaEntity implements IAnimatable
{
	private static final Ingredient FOOD_ITEMS = Ingredient.of(ItemInit.CARNOTAURUS_MEAT.get(), ItemInit.GIGANOTOSAURUS_MEAT.get(), ItemInit.OURANOSAURUS_MEAT.get(), ItemInit.PSITTACOSAURUS_MEAT.get(), ItemInit.TYRANNOSAURUS_MEAT.get());
	private AnimationFactory factory = new AnimationFactory(this);
	
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
	{
		if(this.entityData.get(AbstractPrehistoricEntity.ATTACKING))
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.suchomimus.attack", true));
		}
		else if(event.isMoving() && !isInWaterOrBubble())
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.suchomimus.walk", true));
		}
		else if(event.isMoving() && isInWaterOrBubble())
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.suchomimus.swim", true));
		}
		else if(!isInWaterOrBubble())
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.suchomimus.idle", true));
		}
		else
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.suchomimus.swim_idle", true));
		}
		return PlayState.CONTINUE;
	}

	public SuchomimusEntity(EntityType<? extends SuchomimusEntity> entityIn, World worldIn) 
	{
		super(entityIn, worldIn, TimeEras.CRETACEOUS);
	}
	
	public static AttributeModifierMap.MutableAttribute createAttributes() 
	{
		return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 6.0D);
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
		this.goalSelector.addGoal(6, new ModLandAndWaterTemptGoal(this, 1.0D, FOOD_ITEMS));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
	}

	@Override
	public AbstractPrehistoricAgeingEntity getBreedOffspring(ServerWorld serverWorld, AbstractPrehistoricAgeingEntity prehistoricEntity) 
	{
		return EntityInit.SUCHOMIMUS_ENTITY.get().create(serverWorld);
	}
}
