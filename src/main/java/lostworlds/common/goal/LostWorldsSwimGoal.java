package lostworlds.common.goal;

import lostworlds.common.entities.abstracts.AbstractPrehistoricEntity;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;

public class LostWorldsSwimGoal extends RandomSwimmingGoal
{
	private final AbstractPrehistoricEntity prehistoric;
	
	public LostWorldsSwimGoal(AbstractPrehistoricEntity entity) 
	{
		super(entity, 1.0D, 40);
		this.prehistoric = entity;
	}
	
	public boolean canUse() 
	{
		return this.prehistoric.canRandomSwim() && super.canUse();
	}
}
