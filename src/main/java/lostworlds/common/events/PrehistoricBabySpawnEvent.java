package lostworlds.common.events;

import javax.annotation.Nullable;

import lostworlds.common.entities.abstracts.AbstractPrehistoricAgeingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.Event;

@Cancelable
public class PrehistoricBabySpawnEvent extends Event
{
	 private final MobEntity parentA;
	 private final MobEntity parentB;
	 private final PlayerEntity causedByPlayer;
	 private AbstractPrehistoricAgeingEntity child;

	 public PrehistoricBabySpawnEvent(MobEntity parentA, MobEntity parentB, @Nullable AbstractPrehistoricAgeingEntity proposedChild)
	 {
		 PlayerEntity causedByPlayer = null;
		 if (parentA instanceof AnimalEntity) 
		 {
			 causedByPlayer = ((AnimalEntity)parentA).getLoveCause();
		 }

		 if (causedByPlayer == null && parentB instanceof AnimalEntity)
		 {
			 causedByPlayer = ((AnimalEntity)parentB).getLoveCause();
		 }

		 this.parentA = parentA;
		 this.parentB = parentB;
		 this.causedByPlayer = causedByPlayer;
		 this.child = proposedChild;
	 }

	 public MobEntity getParentA()
	 {
		 return parentA;
	 }

	 public MobEntity getParentB()
	 {
		 return parentB;
	 }

	 @Nullable
	 public PlayerEntity getCausedByPlayer()
	 {
		 return causedByPlayer;
	 }

	 @Nullable
	 public AbstractPrehistoricAgeingEntity getChild()
	 {
		 return child;
	 }

	 public void setChild(AbstractPrehistoricAgeingEntity proposedChild)
	 {
		 child = proposedChild;
	 }
}
