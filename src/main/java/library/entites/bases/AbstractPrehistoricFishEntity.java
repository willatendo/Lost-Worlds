package library.entites.bases;

import library.enums.TimeEras;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockState;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.Pose;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public abstract class AbstractPrehistoricFishEntity extends AbstractPrehistoricEntity
{
	private static final DataParameter<Boolean> FROM_BUCKET = EntityDataManager.defineId(AbstractFishEntity.class, DataSerializers.BOOLEAN);
	
	public AbstractPrehistoricFishEntity(EntityType<? extends AbstractPrehistoricFishEntity> entityIn, World worldIn, TimeEras timeEra) 
	{
		super(entityIn, worldIn, timeEra);
		this.setPathfindingMalus(PathNodeType.WATER, 0.0F);
		this.moveControl = new AbstractPrehistoricFishEntity.MoveHelperController(this);
	}
	
	@Override
	public boolean canBreatheUnderwater() 
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
		return true;
	}
	
	@Override	
	public CreatureAttribute getMobType() 
	{
		return CreatureAttribute.WATER;
	}
	
	@Override
	public boolean checkSpawnObstruction(IWorldReader worldReader) 
	{
		return worldReader.isUnobstructed(this);
	}
	
	@Override
	public int getAmbientSoundInterval() 
	{
		return 120;
	}
	
	@Override
	protected int getExperienceReward(PlayerEntity playerEntity) 
	{
		return 1 + this.level.random.nextInt(3);
	}
	
	protected void handleAirSupply(int p_209207_1_) 
	{
		if(this.isAlive() && !this.isInWaterOrBubble()) 
		{
			this.setAirSupply(p_209207_1_ - 1);
			if(this.getAirSupply() == -20) 
			{
				this.setAirSupply(0);
				this.hurt(DamageSource.DROWN, 2.0F);
			}
		} 
		else 
		{
			this.setAirSupply(300);
		}
	}
	
	@Override
	public void baseTick() 
	{
		int i = this.getAirSupply();
		super.baseTick();
		this.handleAirSupply(i);
	}
	
	@Override
	public boolean isPushedByFluid() 
	{
		return false;
	}
	
	@Override
	public boolean canBeLeashed(PlayerEntity playerEntity) 
	{
		return false;
	}
	
	@Override
	protected float getStandingEyeHeight(Pose pose, EntitySize size) 
	{
		return size.height * 0.65F;
	}
	
	public static AttributeModifierMap.MutableAttribute createAttributes() 
	{
		return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 3.0D);
	}
	
	@Override
	public boolean requiresCustomPersistence() 
	{
		return super.requiresCustomPersistence() || this.fromBucket();
	}
	
	@Override
	public boolean removeWhenFarAway(double doub) 
	{
		return !this.fromBucket() && !this.hasCustomName();
	}
	
	@Override
	public int getMaxSpawnClusterSize() 
	{
		return 8;
	}
	
	@Override
	protected void defineSynchedData() 
	{
		super.defineSynchedData();
		this.entityData.define(FROM_BUCKET, false);
	}
	
	private boolean fromBucket() 
	{
		return this.entityData.get(FROM_BUCKET);
	}
	
	public void setFromBucket(boolean bool) 
	{
		this.entityData.set(FROM_BUCKET, bool);
	}
	
	@Override
	public void addAdditionalSaveData(CompoundNBT nbt) 
	{
		super.addAdditionalSaveData(nbt);
		nbt.putBoolean("FromBucket", this.fromBucket());
	}
	
	@Override
	public void readAdditionalSaveData(CompoundNBT nbt) 
	{
		super.readAdditionalSaveData(nbt);
		this.setFromBucket(nbt.getBoolean("FromBucket"));
	}
	
	@Override
	protected PathNavigator createNavigation(World worldIn) 
	{
		return new SwimmerPathNavigator(this, worldIn);
	}
	
	@Override
	public void travel(Vector3d vec3d) 
	{
		if(this.isEffectiveAi() && this.isInWater()) 
		{
			this.moveRelative(0.01F, vec3d);
			this.move(MoverType.SELF, this.getDeltaMovement());
			this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
			if(this.getTarget() == null) 
			{
				this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
			}
		} 
		else 
		{
			super.travel(vec3d);
		}
	}
	
	@Override
	public void aiStep() 
	{
		if(!this.isInWater() && this.onGround && this.verticalCollision) 
		{
			this.setDeltaMovement(this.getDeltaMovement().add((double)((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F), (double)0.4F, (double)((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F)));
			this.onGround = false;
			this.hasImpulse = true;
			this.playSound(this.getFlopSound(), this.getSoundVolume(), this.getVoicePitch());
		}
		super.aiStep();
	}
	
	@Override
	protected ActionResultType mobInteract(PlayerEntity playerEntity, Hand hand) 
	{
		ItemStack itemstack = playerEntity.getItemInHand(hand);
		if(itemstack.getItem() == Items.WATER_BUCKET && this.isAlive()) 
		{
			this.playSound(SoundEvents.BUCKET_FILL_FISH, 1.0F, 1.0F);
			itemstack.shrink(1);
			ItemStack itemstack1 = this.getBucketItemStack();
			this.saveToBucketTag(itemstack1);
			if(!this.level.isClientSide) 
			{
				CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayerEntity)playerEntity, itemstack1);
			}
			
			if(itemstack.isEmpty()) 
			{
				playerEntity.setItemInHand(hand, itemstack1);
			} 
			else if(!playerEntity.inventory.add(itemstack1)) 
			{
				playerEntity.drop(itemstack1, false);
			}
			
			this.remove();
			return ActionResultType.sidedSuccess(this.level.isClientSide);
		} 
		else 
		{
			return super.mobInteract(playerEntity, hand);
		}
	}
	
	protected void saveToBucketTag(ItemStack stack) 
	{
		if(this.hasCustomName()) 
		{
			stack.setHoverName(this.getCustomName());	      
		}
	}
	
	protected abstract ItemStack getBucketItemStack();
	
	protected abstract SoundEvent getFlopSound();
	
	@Override
	protected SoundEvent getSwimSound() 
	{
		return SoundEvents.FISH_SWIM;
	}
	
	@Override
	protected void playStepSound(BlockPos pos, BlockState state) { }
	
	public static class MoveHelperController extends MovementController 
	{
		private final AbstractPrehistoricFishEntity fish;
		
		MoveHelperController(AbstractPrehistoricFishEntity entityIn) 
		{
			super(entityIn);
			this.fish = entityIn;
		}
		
		@Override
		public void tick() 
		{
			if(this.fish.isEyeInFluid(FluidTags.WATER)) 
			{
				this.fish.setDeltaMovement(this.fish.getDeltaMovement().add(0.0D, 0.005D, 0.0D));
			}
			
			if(this.operation == MovementController.Action.MOVE_TO && !this.fish.getNavigation().isDone()) 
			{
				float f = (float)(this.speedModifier * this.fish.getAttributeValue(Attributes.MOVEMENT_SPEED));
				this.fish.setSpeed(MathHelper.lerp(0.125F, this.fish.getSpeed(), f));
				double d0 = this.wantedX - this.fish.getX();
				double d1 = this.wantedY - this.fish.getY();
				double d2 = this.wantedZ - this.fish.getZ();
				if(d1 != 0.0D) 
				{
					double d3 = (double)MathHelper.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
					this.fish.setDeltaMovement(this.fish.getDeltaMovement().add(0.0D, (double)this.fish.getSpeed() * (d1 / d3) * 0.1D, 0.0D));
				}
				
				if(d0 != 0.0D || d2 != 0.0D) 
				{
					float f1 = (float)(MathHelper.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
					this.fish.yRot = this.rotlerp(this.fish.yRot, f1, 90.0F);
					this.fish.yBodyRot = this.fish.yRot;
				}
			} 
			else 
			{
				this.fish.setSpeed(0.0F);
			}
		}
	}
}
