package lostworlds.common.goal;

import java.util.EnumSet;
import java.util.Set;

import com.google.common.collect.Sets;

import lostworlds.common.entities.abstracts.AbstractPrehistoricLandAndSeaEntity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModLandAndWaterFollowGoal extends Goal 
{
	private static final EntityPredicate TEMPT_TARGETING = (new EntityPredicate()).range(10.0D).allowSameTeam().allowInvulnerable();
	private final AbstractPrehistoricLandAndSeaEntity entity;
	private final double speedModifier;
	private PlayerEntity player;
	private int calmDown;
	private final Set<Item> items;

	ModLandAndWaterFollowGoal(AbstractPrehistoricLandAndSeaEntity entity, double speed, Item followItem) 
	{
		this.entity = entity;
		this.speedModifier = speed;
		this.items = Sets.newHashSet(followItem);
		this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
	}

	public boolean canUse() 
	{
		if(this.calmDown > 0) 
		{
			--this.calmDown;
			return false;
		} 
		else 
		{
			this.player = this.entity.level.getNearestPlayer(TEMPT_TARGETING, this.entity);
			if(this.player == null) 
			{
				return false;
			} 
			else 
			{
				return this.shouldFollowItem(this.player.getMainHandItem()) || this.shouldFollowItem(this.player.getOffhandItem());
			}
		}
	}

	private boolean shouldFollowItem(ItemStack stack) 
	{
		return this.items.contains(stack.getItem());
	}

	public boolean canContinueToUse() 
	{
		return this.canUse();
	}

	public void stop() 
	{
		this.player = null;
		this.entity.getNavigation().stop();
		this.calmDown = 100;
	}

	public void tick() 
	{
		this.entity.getLookControl().setLookAt(this.player, (float)(this.entity.getMaxHeadYRot() + 20), (float)this.entity.getMaxHeadXRot());
		if(this.entity.distanceToSqr(this.player) < 6.25D) 
		{
			this.entity.getNavigation().stop();
		} 
		else 
		{
			this.entity.getNavigation().moveTo(this.player, this.speedModifier);
		}
	}
}
