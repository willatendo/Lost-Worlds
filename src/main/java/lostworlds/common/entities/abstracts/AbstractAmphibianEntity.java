package lostworlds.common.entities.abstracts;

import java.util.Random;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public abstract class AbstractAmphibianEntity extends WaterMobEntity
{	
	public AbstractAmphibianEntity(EntityType<? extends AbstractAmphibianEntity> entityIn, World worldIn) 
	{
		super(entityIn, worldIn);
		this.moveControl = new AbstractAmphibianEntity.MoveHelperController(this);
	}
	
	protected float getStandingEyeHeight(Pose pose, EntitySize size) 
	{
		return size.height * 0.65F;
	}
	
	public static boolean checkSpawnRules(EntityType<? extends AbstractAmphibianEntity> entity, IWorld iWorldIn, SpawnReason spawnReasonIn, BlockPos pos, Random rand) 
	{
		return iWorldIn.getBlockState(pos).is(Blocks.WATER) || iWorldIn.getBlockState(pos).is(Blocks.AIR);
	}
	
	public boolean removeWhenFarAway(double doubleIn) 
	{
		return !this.hasCustomName();
	}
	
	public int getMaxSpawnClusterSize() 
	{
		return 1;
	}
	
	@Override
	protected void registerGoals() 
	{
		super.registerGoals();
		this.goalSelector.addGoal(0, new RandomSwimmingGoal(this, 1.0D, 1));
		this.goalSelector.addGoal(1, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 6.0F));
	}
	
	protected PathNavigator createNavigation(World worldIn) 
	{
		return new SwimmerPathNavigator(this, worldIn);
	}
	
	public void travel(Vector3d vec3d) 
	{
		if (this.isEffectiveAi() && this.isInWater()) 
		{
			this.moveRelative(0.01F, vec3d);
			this.move(MoverType.SELF, this.getDeltaMovement());
			this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
			if (this.getTarget() == null) 
			{
				this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
			}
		} 
		else 
		{
			super.travel(vec3d);
		}
	}
	
	protected boolean canRandomSwim() 
	{
		return true;
	}
	
	public static class MoveHelperController extends MovementController 
	{
		private final AbstractAmphibianEntity amphibian;
		
		MoveHelperController(AbstractAmphibianEntity entityIn) 
		{
			super(entityIn);
			this.amphibian = entityIn;
		}
		
		public void tick() 
		{
			if (this.amphibian.isEyeInFluid(FluidTags.WATER)) 
			{
				this.amphibian.setDeltaMovement(this.amphibian.getDeltaMovement().add(0.0D, 0.005D, 0.0D));
			}
			
			if (this.operation == MovementController.Action.MOVE_TO && !this.amphibian.getNavigation().isDone()) 
			{
				float f = (float)(this.speedModifier * this.amphibian.getAttributeValue(Attributes.MOVEMENT_SPEED));
				this.amphibian.setSpeed(MathHelper.lerp(0.125F, this.amphibian.getSpeed(), f));
				double d0 = this.wantedX - this.amphibian.getX();
				double d1 = this.wantedY - this.amphibian.getY();
				double d2 = this.wantedZ - this.amphibian.getZ();
				if (d1 != 0.0D) 
				{
					double d3 = (double)MathHelper.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
					this.amphibian.setDeltaMovement(this.amphibian.getDeltaMovement().add(0.0D, (double)this.amphibian.getSpeed() * (d1 / d3) * 0.1D, 0.0D));
				}
				
				if (d0 != 0.0D || d2 != 0.0D) 
				{
					float f1 = (float)(MathHelper.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
					this.amphibian.yRot = this.rotlerp(this.amphibian.yRot, f1, 90.0F);
					this.amphibian.yBodyRot = this.amphibian.yRot;
				}
			} 
			else 
			{
				this.amphibian.setSpeed(0.0F);
			}
		}
	}
}
