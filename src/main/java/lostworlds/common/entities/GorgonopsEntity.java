package lostworlds.common.entities;

import lostworlds.common.entities.abstracts.AbstractPrehistoricAgeingEntity;
import lostworlds.common.entities.abstracts.AbstractPrehistoricAnimalEntity;
import lostworlds.common.goal.PrehistoricBreedGoal;
import lostworlds.core.init.EntityInit;
import lostworlds.core.init.ItemInit;
import lostworlds.core.util.enums.TimeEras;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
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

public class GorgonopsEntity extends AbstractPrehistoricAnimalEntity implements IAnimatable
{
    private static final Ingredient FOOD_ITEMS = Ingredient.of(Items.BONE, ItemInit.EDAPHOSAURUS_MEAT.get(), ItemInit.DIMETRODON_MEAT.get(), ItemInit.RHINESUCHUS_MEAT.get(), ItemInit.TETRACERATOPS_MEAT.get());
	private AnimationFactory factory = new AnimationFactory(this);

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) 
	{
		if(!(animationSpeed > -0.15F && animationSpeed < 0.15F))
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.gorgonops.walking", true));
			return PlayState.CONTINUE;
		}
		else
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.gorgonops.idol", true));
			return PlayState.CONTINUE;
		}
	}

	public GorgonopsEntity(EntityType<? extends GorgonopsEntity> entityIn, World worldIn) 
	{
		super(entityIn, worldIn, TimeEras.PERMIAN);
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
		this.goalSelector.addGoal(5, new PrehistoricBreedGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new TemptGoal(this, 1.0D, false, FOOD_ITEMS));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, EdaphosaurusEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, RhinesuchusEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, TetraceratopsEntity.class, false));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<>(this, DimetrodonEntity.class, 8.0F, 1.6D, 1.4D, EntityPredicates.NO_SPECTATORS::test));
	}

	@Override
	public AbstractPrehistoricAgeingEntity getBreedOffspring(ServerWorld serverWorld, AbstractPrehistoricAgeingEntity prehistoricEntity) 
	{
		return EntityInit.GORGONOPS_ENTITY.get().create(serverWorld);
	}
}
