package library.goals;

import library.entites.bases.AbstractPrehistoricEntity;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;

public class ModSwimGoal extends RandomSwimmingGoal
{
	private final AbstractPrehistoricEntity prehistoric;
	
	public ModSwimGoal(AbstractPrehistoricEntity entity) 
	{
		super(entity, 1.0D, 40);
		this.prehistoric = entity;
	}
	
	@Override
	public boolean canUse() 
	{
		return this.prehistoric.canRandomSwim() && super.canUse();
	}
}
