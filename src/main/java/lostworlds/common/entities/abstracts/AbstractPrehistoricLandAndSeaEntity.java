package lostworlds.common.entities.abstracts;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public abstract class AbstractPrehistoricLandAndSeaEntity extends AbstractPrehistoricAnimalEntity
{
	private boolean isLandNavigator;
	
	public AbstractPrehistoricLandAndSeaEntity(EntityType<? extends AbstractPrehistoricLandAndSeaEntity> entityIn, World worldIn) 
	{
		super(entityIn, worldIn);
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
			this.setDeltaMovement(this.getDeltaMovement().scale(1.0D));
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
		
		public MoveHelperController(AbstractPrehistoricLandAndSeaEntity entity) 
		{
			super(entity);
			this.entity = entity;
		}
		
		public void tick() 
		{
			if(this.entity.isInWater()) 
			{
				this.entity.setDeltaMovement(this.entity.getDeltaMovement().add(0.0D, 0.005D, 0.0D));
			}
			
			if(this.operation == MovementController.Action.MOVE_TO && !this.entity.getNavigation().isDone()) 
			{
				double d0 = this.wantedX - this.entity.getX();
				double d1 = this.wantedY - this.entity.getY();
				double d2 = this.wantedZ - this.entity.getZ();
				double d3 = d0 * d0 + d1 * d1 + d2 * d2;
				if (d3 < (double)2.5000003E-7F) 
				{
					this.mob.setZza(0.0F);
				} 
				else 
				{
					float f = (float)(MathHelper.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
					this.entity.yRot = this.rotlerp(this.entity.yRot, f, 10.0F);
					this.entity.yBodyRot = this.entity.yRot;
					this.entity.yHeadRot = this.entity.yRot;
					float f1 = (float)(this.speedModifier * this.entity.getAttributeValue(Attributes.MOVEMENT_SPEED));
					if(this.entity.isInWater()) 
					{
						this.entity.setSpeed(f1 * 0.02F);
						float f2 = -((float)(MathHelper.atan2(d1, (double)MathHelper.sqrt(d0 * d0 + d2 * d2)) * (double)(180F / (float)Math.PI)));
						f2 = MathHelper.clamp(MathHelper.wrapDegrees(f2), -85.0F, 85.0F);
						this.entity.xRot = this.rotlerp(this.entity.xRot, f2, 5.0F);
						float f3 = MathHelper.cos(this.entity.xRot * ((float)Math.PI / 180F));
						float f4 = MathHelper.sin(this.entity.xRot * ((float)Math.PI / 180F));
						this.entity.zza = f3 * f1;
						this.entity.yya = -f4 * f1;
					} 
					else 
					{
						this.entity.setSpeed(f1 * 0.1F);
					}
				}
			}
		}
	}
}
