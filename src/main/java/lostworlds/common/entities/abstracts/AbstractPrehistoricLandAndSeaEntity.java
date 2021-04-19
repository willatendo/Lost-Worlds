package lostworlds.common.entities.abstracts;

import lostworlds.common.goal.path.SemiAquaticPathNavigator;
import lostworlds.core.util.interfaces.ISemiAquatic;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public abstract class AbstractPrehistoricLandAndSeaEntity extends AbstractPrehistoricAnimalEntity implements ISemiAquatic
{
	public float prevInWaterProgress;
    public float inWaterProgress;
	private boolean isLandNavigator;
	private int swimTimer = -1000;
	
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
	public void tick() 
	{
		prevInWaterProgress = inWaterProgress;
		super.tick();
		if(this.isInWaterOrBubble() && inWaterProgress < 5F) 
		{
            inWaterProgress++;
        }
        if(!this.isInWaterOrBubble() && inWaterProgress > 0F)
        {
            inWaterProgress--;
        }
        if(this.isInWaterOrBubble() && this.isLandNavigator) 
        {
            switchNavigator(false);
        }
        if(!this.isInWaterOrBubble() && !this.isLandNavigator) 
        {
            switchNavigator(true);
        }
        if(inWaterProgress > 0) 
        {
            this.maxUpStep = 1;
        } 
        else 
        {
            this.maxUpStep = 0.6F;
        }
        if(this.level.isClientSide())
        {
        	if (isInWater()) 
    		{
    			swimTimer++;
    		} 
    		else 
    		{
    			swimTimer--;
    		}
        }
	}
	
	@Override
    public boolean shouldEnterWater() 
	{
		return swimTimer <= -1000;
	}
	
	@Override
	public boolean shouldLeaveWater() 
	{
		return swimTimer > 600;
	}
	
	@Override
    public int getWaterSearchRange() 
	{
        return 10;
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
            this.moveControl = new MovementController(this);
            this.navigation = new SemiAquaticPathNavigator(this, level);
            this.isLandNavigator = false;
        }
    }
	
	public void travel(Vector3d travelVector) 
	{
        if(this.isEffectiveAi() && this.isInWater()) 
        {
        	this.moveRelative(this.getSpeed(), travelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.moveTo(this.getDeltaMovement().scale(0.9D));
        } 
        else 
        {
            super.travel(travelVector);
        }
    }
}
