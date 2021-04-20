package lostworlds.common.entities.abstracts;

import lostworlds.common.goal.controller.AnimalSwimMoveController;
import lostworlds.common.goal.path.SemiAquaticPathNavigator;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.pathfinding.PathNodeType;
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
		if (this.isInWaterOrBubble() && this.isLandNavigator) 
		{
            switchNavigator(false);
        }
        if (!this.isInWaterOrBubble() && !this.isLandNavigator) 
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
            this.moveControl = new AnimalSwimMoveController(this, 1.2F, 1.6F);
            this.navigation = new SemiAquaticPathNavigator(this, level);
            this.isLandNavigator = false;
        }
    }
	
	public void travel(Vector3d vec3d) 
	{
		if(this.isEffectiveAi() && this.isInWater()) 
		{
			this.moveRelative(this.getSpeed(), vec3d);
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
}
