package lostworlds.common.entities.abstracts;

import lostworlds.common.goal.path.GroundAndSwimmerPathNavigator;
import lostworlds.core.util.interfaces.ISemiAquatic;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public abstract class AbstractPrehistoricLandAndSeaEntity extends AbstractPrehistoricAnimalEntity implements ISemiAquatic
{
	private boolean isLandNavigator;
	private int swimTimer = -1000;
	
	public AbstractPrehistoricLandAndSeaEntity(EntityType<? extends AbstractPrehistoricAnimalEntity> entityIn, World worldIn) 
	{
		super(entityIn, worldIn);
		this.moveControl = new AbstractPrehistoricEntity.LandAndSeaMoveHelperController(this);
	}
	
	@Override
	public boolean isLandAndWater() 
	{
		return true;
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
            this.navigation = new SwimmerPathNavigator(this, level);
            this.isLandNavigator = false;
        }
    }
	
	@Override
	protected PathNavigator createNavigation(World worldIn) 
	{
		return new GroundAndSwimmerPathNavigator(this, worldIn);
	}
	
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
		if(this.isEffectiveAi() && !this.isInWater()) 
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
}
