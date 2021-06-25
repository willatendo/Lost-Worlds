package lostworlds.common.entities;

import lostworlds.LostWorldsConfig;
import lostworlds.common.blocks.egg.MediumEggBlock;
import lostworlds.common.entities.abstracts.BasePrehistoricEntity;
import lostworlds.common.entities.abstracts.PrehistoricCarnivoreEntity;
import lostworlds.common.goal.EggBreedingGoal;
import lostworlds.core.init.BlockInit;
import lostworlds.core.init.EntityInit;
import lostworlds.core.init.ItemInit;
import lostworlds.core.util.enums.TimeEras;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class AllosaurusEntity extends PrehistoricCarnivoreEntity implements IAnimatable
{
    private static final Ingredient FOOD_ITEMS = Ingredient.of(ItemInit.CHILESAURUS_MEAT.get(), ItemInit.CRYOLOPHOSAURUS_MEAT.get(), ItemInit.KENTROSAURUS_MEAT.get(), ItemInit.OSTROMIA_MEAT.get(), ItemInit.PROTOSUCHUS_MEAT.get());
	private AnimationFactory factory = new AnimationFactory(this);

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) 
	{				
		if(this.entityData.get(BasePrehistoricEntity.ATTACKING))
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.allosaurus.attack", true));
		}
		else if(event.isMoving())
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.allosaurus.walk", true));
		}
		else
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.allosaurus.idle", true));
		}	
		return PlayState.CONTINUE;
	}
	
	public AllosaurusEntity(EntityType<? extends AllosaurusEntity> entityIn, World worldIn) 
	{
		super(entityIn, worldIn, TimeEras.JURASSIC, false, false);
	}
	
	public static AttributeModifierMap.MutableAttribute makeAttributes()
	{
		return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, LostWorldsConfig.COMMON.allosaurusHeath.get()).add(Attributes.MOVEMENT_SPEED, LostWorldsConfig.COMMON.allosaurusMovementSpeed.get()).add(Attributes.ATTACK_DAMAGE, LostWorldsConfig.COMMON.allosaurusAttackDamage.get());
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
	public boolean isFood(ItemStack stack) 
	{
		return FOOD_ITEMS.test(stack);
	}
	
	@Override
	protected void registerGoals()
	{
		super.registerGoals();
		this.goalSelector.addGoal(5, new EggBreedingGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new TemptGoal(this, 1.0D, false, FOOD_ITEMS));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, ChilesaurusEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, CryolophosaurusEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, KentrosaurusEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, OstromiaEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, ProtosuchusEntity.class, false));
	}

	@Override
	public BasePrehistoricEntity getBreedOffspring(ServerWorld serverWorld, BasePrehistoricEntity prehistoricEntity) 
	{
		return EntityInit.ALLOSAURUS_ENTITY.get().create(serverWorld);
	}
	
	static class LayEggGoal extends MoveToBlockGoal 
	{
		private final BasePrehistoricEntity entity;
		
		LayEggGoal(final BasePrehistoricEntity entity, final double speedModifier) 
		{
			super(entity, speedModifier, 16);
			this.entity = entity;
		}
		
		public boolean canUse() 
		{
			return this.entity.hasEgg() ? super.canUse() : false;
		}
		
		public boolean canContinueToUse() 	
		{
			return super.canContinueToUse() && this.entity.hasEgg();
		}
		
		public void tick() 
		{
			super.tick();
			BlockPos blockpos = this.entity.blockPosition();
			if(!this.entity.isInWater() && this.isReachedTarget()) 
			{
				if(this.entity.layEggCounter < 1) 
				{
					this.entity.setLayingEgg(true);
				} 
				else if(this.entity.layEggCounter > 200) 
				{
					World world = this.entity.level;
					world.playSound((PlayerEntity)null, blockpos, SoundEvents.TURTLE_LAY_EGG, SoundCategory.BLOCKS, 0.3F, 0.9F + world.random.nextFloat() * 0.2F);
					world.setBlock(this.blockPos.above(), BlockInit.ALLOSAURUS_EGG.get().defaultBlockState().setValue(MediumEggBlock.EGGS, Integer.valueOf(this.entity.getRandom().nextInt(3) + 1)), 3);
					world.setBlock(this.blockPos, BlockInit.NESTING_BLOCK.get().defaultBlockState(), 3);
					this.entity.setHasEgg(false);
					this.entity.setLayingEgg(false);
					this.entity.setInLoveTime(600);
				}
				
				if(this.entity.isLayingEgg()) 
				{
					this.entity.layEggCounter++;
	            }
			}
		}
		
		protected boolean isValidTarget(IWorldReader reader, BlockPos pos) 
		{
			return !reader.isEmptyBlock(pos.above()) ? false : true;
		}
	}
}
