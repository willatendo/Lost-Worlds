package lostworlds.common.entities;

import lostworlds.common.entities.abstracts.AbstractPrehistoricAgeingEntity;
import lostworlds.common.entities.abstracts.AbstractPrehistoricAnimalEntity;
import lostworlds.common.goal.PrehistoricBreedGoal;
import lostworlds.core.init.EntityInit;
import lostworlds.core.init.ItemInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.passive.OcelotEntity;
import net.minecraft.entity.passive.PandaEntity;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.passive.horse.DonkeyEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.passive.horse.MuleEntity;
import net.minecraft.entity.player.PlayerEntity;
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

public class SuchomimusEntity extends AbstractPrehistoricAnimalEntity implements IAnimatable
{
	private static final Ingredient FOOD_ITEMS = Ingredient.of(Items.PORKCHOP, Items.BEEF, Items.RABBIT, Items.CHICKEN, Items.MUTTON, Items.COD, Items.SALMON, Items.TROPICAL_FISH, ItemInit.DIMETRODON_MEAT.get(), ItemInit.EDAPHOSAURUS_MEAT.get(), ItemInit.GORGONOPS_MEAT.get(), ItemInit.PALAEONISCUM_MEAT.get(), ItemInit.PROCOMPSOGNATHUS_MEAT.get(), ItemInit.RHINESUCHUS_MEAT.get());
	private AnimationFactory factory = new AnimationFactory(this);
	
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
	{
		if(event.isMoving())
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.suchomimus.walk", true));
			return PlayState.CONTINUE;
		}
		else
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.suchomimus.idle", true));
			return PlayState.CONTINUE;
		}
	}

	public SuchomimusEntity(EntityType<? extends SuchomimusEntity> entityIn, World worldIn) 
	{
		super(entityIn, worldIn);
		// TODO Auto-generated constructor stub
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
	public boolean isLandAndWater() 
	{
		return true;
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
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, PalaeoniscumEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, RhinesuchusEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, ProcompsognathusEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, CarnotaurusEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, DimetrodonEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, EdaphosaurusEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, GorgonopsEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, CowEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, PigEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, ChickenEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, RabbitEntity.class, false));	
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, SheepEntity.class, false));	
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, CatEntity.class, false));	
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, WolfEntity.class, false));	
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, FoxEntity.class, false));	
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, HorseEntity.class, false));	
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, MuleEntity.class, false));	
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, DonkeyEntity.class, false));	
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, OcelotEntity.class, false));	
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, PolarBearEntity.class, false));	
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, PandaEntity.class, false));	
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, ParrotEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, TurtleEntity.class, false));	
	}

	@Override
	public AbstractPrehistoricAgeingEntity getBreedOffspring(ServerWorld serverWorld, AbstractPrehistoricAgeingEntity prehistoricEntity) 
	{
		return EntityInit.TYRANNOSAURUS_ENTITY.get().create(serverWorld);
	}
}
