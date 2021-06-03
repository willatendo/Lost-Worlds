package lostworlds.common.entities;

import lostworlds.common.entities.abstracts.AbstractPrehistoricAgeingEntity;
import lostworlds.common.entities.abstracts.AbstractPrehistoricLandAndSeaEntity;
import lostworlds.common.goal.ModBreedGoal;
import lostworlds.core.init.EntityInit;
import lostworlds.core.init.ItemInit;
import lostworlds.core.util.enums.TimeEras;
import net.minecraft.entity.EntityType;
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

public class ProtosuchusEntity extends AbstractPrehistoricLandAndSeaEntity implements IAnimatable
{
    private static final Ingredient FOOD_ITEMS = Ingredient.of(ItemInit.ALLOSAURUS_MEAT.get(), ItemInit.CHILESAURUS_MEAT.get(), ItemInit.CRYOLOPHOSAURUS_MEAT.get(), ItemInit.KENTROSAURUS_MEAT.get(), ItemInit.OSTROMIA_MEAT.get());
	private AnimationFactory factory = new AnimationFactory(this);

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) 
	{				
		if(event.isMoving())
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.protosuchus.walk", true));
		}
		else if(event.isMoving() && this.isInWaterOrBubble())
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.protosuchus.swim", true));
		}
		else if(!event.isMoving() && this.isInWaterOrBubble())
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.protosuchus.swim_idle", true));
		}
		else
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.protosuchus.idle", true));
		}	
		return PlayState.CONTINUE;
	}
	
	public ProtosuchusEntity(EntityType<? extends ProtosuchusEntity> entityIn, World worldIn) 
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
	}

	@Override
	public AbstractPrehistoricAgeingEntity getBreedOffspring(ServerWorld serverWorld, AbstractPrehistoricAgeingEntity prehistoricEntity) 
	{
		return EntityInit.PROTOSUCHUS_ENTITY.get().create(serverWorld);
	}
}
