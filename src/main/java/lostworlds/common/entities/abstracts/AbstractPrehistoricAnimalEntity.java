package lostworlds.common.entities.abstracts;

import java.util.UUID;

import javax.annotation.Nullable;

import lostworlds.common.events.PrehistoricBabySpawnEvent;
import lostworlds.common.triggers.ModCriteriaTriggers;
import lostworlds.core.util.enums.TimeEras;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;

public abstract class AbstractPrehistoricAnimalEntity extends AbstractPrehistoricAgeingEntity
{
	private int inLove;
	private UUID loveCause;
	
	public AbstractPrehistoricAnimalEntity(EntityType<? extends AbstractPrehistoricAnimalEntity> entityIn, World worldIn, TimeEras timeEra) 
	{
		super(entityIn, worldIn, timeEra);
		this.setPathfindingMalus(PathNodeType.DANGER_FIRE, 16.0F);
		this.setPathfindingMalus(PathNodeType.DAMAGE_FIRE, -1.0F);
	}
	
	protected void customServerAiStep() 
	{
		if(this.getAge() != 0) 
		{
			this.inLove = 0;
		}
		
		super.customServerAiStep();
	}
	
	public void aiStep() 
	{
		super.aiStep();
		if(this.getAge() != 0) 
		{
			this.inLove = 0;
		}
		
		if(this.inLove > 0) 
		{
			--this.inLove;
			if(this.inLove % 10 == 0) 
			{
				double d0 = this.random.nextGaussian() * 0.02D;
				double d1 = this.random.nextGaussian() * 0.02D;
				double d2 = this.random.nextGaussian() * 0.02D;
				this.level.addParticle(ParticleTypes.HEART, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), d0, d1, d2);
			}
		}
	}
	
	public boolean hurt(DamageSource source, float f) 
	{
		if(this.isInvulnerableTo(source)) 
		{
			return false;
		} 
		else 
		{
			this.inLove = 0;
			return super.hurt(source, f);
		}
	}
	
	@SuppressWarnings("deprecation")
	public float getWalkTargetValue(BlockPos pos, IWorldReader worldReader) 
	{
		return worldReader.getBlockState(pos.below()).is(Blocks.GRASS_BLOCK) ? 10.0F : worldReader.getBrightness(pos) - 0.5F;
	}
	
	public void addAdditionalSaveData(CompoundNBT nbt) 
	{
		super.addAdditionalSaveData(nbt);
		nbt.putInt("InLove", this.inLove);
		if(this.loveCause != null) 
		{
			nbt.putUUID("LoveCause", this.loveCause);
		}
	}
	
	public double getMyRidingOffset() 
	{
		return 0.14D;
	}
	
	public void readAdditionalSaveData(CompoundNBT nbt) 
	{
		super.readAdditionalSaveData(nbt);
		this.inLove = nbt.getInt("InLove");
		this.loveCause = nbt.hasUUID("LoveCause") ? nbt.getUUID("LoveCause") : null;
	}
	
	public int getAmbientSoundInterval() 
	{
		return 120;
	}
	
	protected int getExperienceReward(PlayerEntity playerEntity) 
	{
		return 1 + this.level.random.nextInt(3);
	}
	
	public boolean isFood(ItemStack stack) 
	{
		return stack.getItem() == Items.BEEF;
	}
	
	public ActionResultType mobInteract(PlayerEntity playerEntity, Hand handIn) 
	{
		ItemStack itemstack = playerEntity.getItemInHand(handIn);
		if(this.isFood(itemstack)) 
		{
			int i = this.getAge();
			if(!this.level.isClientSide && i == 0 && this.canFallInLove()) 
			{
				this.usePlayerItem(playerEntity, itemstack);
				this.setInLove(playerEntity);
				return ActionResultType.SUCCESS;
			}
			
			if(this.isBaby()) 
			{
				this.usePlayerItem(playerEntity, itemstack);
				this.ageUp((int)((float)(-i / 20) * 0.1F), true);
				return ActionResultType.sidedSuccess(this.level.isClientSide);
			}
			
			if(this.level.isClientSide) 
			{
				return ActionResultType.CONSUME;
			}
		}
		
		return super.mobInteract(playerEntity, handIn);
	}
	
	protected void usePlayerItem(PlayerEntity playerEntity, ItemStack stack) 
	{
		if(!playerEntity.abilities.instabuild) 
		{
			stack.shrink(1);
		}
	}
	
	public boolean canFallInLove() 
	{
		return this.inLove <= 0;
	}
	
	public void setInLove(@Nullable PlayerEntity playerEntity) 
	{
		this.inLove = 600;
		if(playerEntity != null) 
		{
			this.loveCause = playerEntity.getUUID();
		}
		
		this.level.broadcastEntityEvent(this, (byte)18);
	}
	
	public void setInLoveTime(int time) 
	{
		this.inLove = time;
	}
	
	public int getInLoveTime() 
	{
		return this.inLove;
	}
	
	@Nullable
	public ServerPlayerEntity getLoveCause() 
	{
		if(this.loveCause == null) 
		{
			return null;
		} 
		else 
		{
			PlayerEntity playerentity = this.level.getPlayerByUUID(this.loveCause);
			return playerentity instanceof ServerPlayerEntity ? (ServerPlayerEntity)playerentity : null;
		}
	}
	
	public boolean isInLove() 
	{
		return this.inLove > 0;
	}
	
	public void resetLove() 
	{
		this.inLove = 0;
	}
	
	public boolean canMate(AbstractPrehistoricAnimalEntity animal) 
	{
		if(animal == this) 
		{
			return false;
		} 
		else if(animal.getClass() != this.getClass()) 
		{
			return false;
		} 
		else 
		{
			return this.isInLove() && animal.isInLove();
		}
	}
	
	public void spawnChildFromBreeding(ServerWorld world, AbstractPrehistoricAnimalEntity entity) 
	{
		AbstractPrehistoricAgeingEntity ageableentity = this.getBreedOffspring(world, entity);
		final PrehistoricBabySpawnEvent event = new PrehistoricBabySpawnEvent(this, entity, ageableentity);
		final boolean cancelled = MinecraftForge.EVENT_BUS.post(event);
		ageableentity = event.getChild();
		if(cancelled) 
		{
			this.setAge(6000);
			entity.setAge(6000);
			this.resetLove();
			entity.resetLove();
			return;
		}
		
		if(ageableentity != null) 
		{
			ServerPlayerEntity serverplayerentity = this.getLoveCause();
			if(serverplayerentity == null && entity.getLoveCause() != null) 
			{
				serverplayerentity = entity.getLoveCause();
			}
			
			if(serverplayerentity != null) 
			{
				serverplayerentity.awardStat(Stats.ANIMALS_BRED);
				ModCriteriaTriggers.BRED_PREHISTORIC_ANIMALS.trigger(serverplayerentity, this, entity, ageableentity);
			}
			
			this.setAge(6000);
			entity.setAge(6000);
			this.resetLove();
			entity.resetLove();
			ageableentity.setBaby(true);
			ageableentity.moveTo(this.getX(), this.getY(), this.getZ(), 0.0F, 0.0F);
			world.addFreshEntityWithPassengers(ageableentity);
			world.broadcastEntityEvent(this, (byte)18);
			if(world.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) 
			{
				world.addFreshEntity(new ExperienceOrbEntity(world, this.getX(), this.getY(), this.getZ(), this.getRandom().nextInt(7) + 1));
			}
		}
	}
	
	@OnlyIn(Dist.CLIENT)
	public void handleEntityEvent(byte p_70103_1_) 
	{
		if(p_70103_1_ == 18) 
		{
			for(int i = 0; i < 7; ++i) 
			{
				double d0 = this.random.nextGaussian() * 0.02D;
				double d1 = this.random.nextGaussian() * 0.02D;
				double d2 = this.random.nextGaussian() * 0.02D;
				this.level.addParticle(ParticleTypes.HEART, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), d0, d1, d2);
			}
		}
		else 
		{
			super.handleEntityEvent(p_70103_1_);
		}
	}
}
