package lostworlds.common.entities.abstracts;

import lostworlds.core.util.enums.TimeEras;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public abstract class AbstractPrehistoricLandAndSeaEntity extends AbstractPrehistoricAnimalEntity
{
	private boolean isLandNavigator;
	
	public AbstractPrehistoricLandAndSeaEntity(EntityType<? extends AbstractPrehistoricLandAndSeaEntity> entityIn, World worldIn, TimeEras timeEra) 
	{
		super(entityIn, worldIn, timeEra);
		this.setPathfindingMalus(PathNodeType.WATER, 0.0F);
        this.setPathfindingMalus(PathNodeType.WATER_BORDER, 0.0F);
		switchNavigator(false);
	}
	
	@Override
	public boolean isLandAndWater() 
	{
		return true;
	}
	
	@Override
	public boolean isFish() 
	{
		return false;
	}
	
	@Override
	public void tick() 
	{
		super.tick();
		if(this.isInWaterOrBubble() && this.isLandNavigator) 
		{
            switchNavigator(false);
        }
        if(!this.isInWaterOrBubble() && !this.isLandNavigator) 
        {
            switchNavigator(true);
        }
	}
	
	private void switchNavigator(boolean onLand) 
	{
		if(onLand) 
		{
			this.moveControl = new MovementController(this);
            this.navigation = new GroundPathNavigator(this, level);
            this.isLandNavigator = true;
        } 
		else 
        {
            this.moveControl = new AbstractPrehistoricLandAndSeaEntity.MoveHelperController(this);
            this.navigation = new SwimmerPathNavigator(this, level);
            this.isLandNavigator = false;
        }
    }
	
	public void travel(Vector3d vec3d) 
	{
		if(this.isEffectiveAi() && this.isInWater()) 
		{
			this.moveRelative(this.getSpeed(), vec3d);
			this.move(MoverType.SELF, this.getDeltaMovement());
			this.setDeltaMovement(this.getDeltaMovement().scale(0.1D));
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
	
	
	static class MoveHelperController extends MovementController 
	{
		private final AbstractPrehistoricLandAndSeaEntity entity;
		
		MoveHelperController(AbstractPrehistoricLandAndSeaEntity entity) 
		{
			super(entity);
			this.entity = entity;
		}
		
		public void tick() 
		{
			if(this.entity.isEyeInFluid(FluidTags.WATER)) 
			{
				this.entity.setDeltaMovement(this.entity.getDeltaMovement().add(0.0D, 0.005D, 0.0D));
			}
			
			if(this.operation == MovementController.Action.MOVE_TO && !this.entity.getNavigation().isDone()) 
			{
				float f = (float)(this.speedModifier * this.entity.getAttributeValue(Attributes.MOVEMENT_SPEED));
				this.entity.setSpeed(MathHelper.lerp(0.125F, this.entity.getSpeed(), f));
				double d0 = this.wantedX - this.entity.getX();
				double d1 = this.wantedY - this.entity.getY();
				double d2 = this.wantedZ - this.entity.getZ();
				if(d1 != 0.0D) 
				{
					double d3 = (double)MathHelper.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
					this.entity.setDeltaMovement(this.entity.getDeltaMovement().add(0.0D, (double)this.entity.getSpeed() * (d1 / d3) * 0.1D, 0.0D));
				}
				
				if(d0 != 0.0D || d2 != 0.0D) 
				{
					float f1 = (float)(MathHelper.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
					this.entity.yRot = this.rotlerp(this.entity.yRot, f1, 90.0F);
					this.entity.yBodyRot = this.entity.yRot;
				}
			} 
			else 
			{
				this.entity.setSpeed(0.0F);
			}
		}
	}
}
