package lostworlds.common.goals;

import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.merchant.IMerchant;
import net.minecraft.entity.player.PlayerEntity;

public class LookAtGoalLWV extends LookAtGoal
{
	public <T extends MobEntity & IMerchant> LookAtGoalLWV(T entityIn)
    {
        super(entityIn, PlayerEntity.class, 8.0F);
    }

    public boolean shouldExecute()
    {
        if(((IMerchant)this.entity).getCustomer() != null)
        {
            this.closestEntity = ((IMerchant)this.entity).getCustomer();
            return true;
        }
        return false;
    }
}