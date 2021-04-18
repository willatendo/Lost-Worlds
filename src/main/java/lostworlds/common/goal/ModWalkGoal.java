package lostworlds.common.goal;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;

public class ModWalkGoal extends RandomWalkingGoal
{
	public ModWalkGoal(CreatureEntity entity) 
	{
		super(entity, 1.0D, 30, true);
	}
}
