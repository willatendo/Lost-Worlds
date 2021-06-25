package lostworlds.common.entities.abstracts;

import lostworlds.common.goal.HuntGoal;
import lostworlds.core.util.enums.TimeEras;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

public abstract class PrehistoricCarnivoreEntity extends BasePrehistoricEntity
{	
	protected int anger;
	
	public PrehistoricCarnivoreEntity(EntityType<? extends PrehistoricCarnivoreEntity> entity, World world, TimeEras era, boolean isScaredOfPlayer, boolean isSemiAquatic) 
	{
		super(entity, world, era, isScaredOfPlayer, isSemiAquatic);
	}
	
	@Override
	public void addAdditionalSaveData(CompoundNBT nbt) 
	{
		super.addAdditionalSaveData(nbt);
		nbt.putInt("Anger", this.getAnger());
	}
	
	@Override
	public void readAdditionalSaveData(CompoundNBT nbt) 
	{
		super.readAdditionalSaveData(nbt);
		this.setAge(nbt.getInt("Anger"));
	}
	
	public int getAnger() 
	{
		return this.anger;
	}
	
	@Override
	protected void customServerAiStep() 
	{
		if(this.anger > 0) 
		{
			--this.anger;
			if (this.anger == 0 && ForgeEventFactory.getMobGriefingEvent(this.level, this)) 
			{
				int i1 = MathHelper.floor(this.getY());
				int l1 = MathHelper.floor(this.getX());
				int i2 = MathHelper.floor(this.getZ());
				boolean flag = false;
				
				for(int k2 = -1; k2 <= 1; ++k2) 
				{
					for(int l2 = -1; l2 <= 1; ++l2) 
					{
						for(int j = 0; j <= 3; ++j) 
						{
							int i3 = l1 + k2;
							int k = i1 + j;
							int l = i2 + l2;
							BlockPos blockpos = new BlockPos(i3, k, l);
							BlockState blockstate = this.level.getBlockState(blockpos);
							if(ForgeEventFactory.onEntityDestroyBlock(this, blockpos, blockstate))
							{
								flag = this.level.destroyBlock(blockpos, true, this) || flag;
							}
						}
					}
				}
				
				if(flag) 
				{
					this.level.levelEvent((PlayerEntity)null, 1022, this.blockPosition(), 0);
				}
			}
		}
	}
	
	@Override
	public boolean hurt(DamageSource source, float f) 
	{
		if(this.anger <= 0) 
		{
			this.anger = 20;
		}
		
		return super.hurt(source, f);
	}

	@Override
	protected void registerGoals() 
	{
		super.registerGoals();
		this.goalSelector.addGoal(5, new HuntGoal(this, 2.0D, false));
	}
}
