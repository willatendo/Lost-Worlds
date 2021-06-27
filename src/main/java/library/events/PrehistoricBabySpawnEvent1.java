package library.events;

import javax.annotation.Nullable;

import library.entites.bases.AbstractPrehistoricAgeingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.Event;

@Cancelable
public class PrehistoricBabySpawnEvent1 extends Event
{
	 private final MobEntity parentA;
	 private final MobEntity parentB;
	 private final PlayerEntity causedByPlayer;
	 private AbstractPrehistoricAgeingEntity child;

	 public PrehistoricBabySpawnEvent1(MobEntity parentA, MobEntity parentB, @Nullable AbstractPrehistoricAgeingEntity ageableentity)
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
		 this.child = ageableentity;
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