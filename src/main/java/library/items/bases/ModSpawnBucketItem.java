package library.items.bases;

import library.entites.bases.AbstractPrehistoricAgeingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.NonNullSupplier;

public class ModSpawnBucketItem extends ModFishBucketItem
{
	public ModSpawnBucketItem(NonNullSupplier<? extends EntityType<?>> entityTypeSupplier) 
	{
		super(entityTypeSupplier, Fluids.WATER);
	}
	
	@Override
	public void checkExtraContent(World p_203792_1_, ItemStack p_203792_2_, BlockPos pos) 
	{
	      if (p_203792_1_ instanceof ServerWorld) {
	         this.spawn((ServerWorld)p_203792_1_, p_203792_2_, pos);
	      }

	   }
	
	private void spawn(ServerWorld p_205357_1_, ItemStack p_205357_2_, BlockPos pos) 
	{
		AbstractPrehistoricAgeingEntity entity = (AbstractPrehistoricAgeingEntity) this.entityTypeSupplier.get().spawn(p_205357_1_, p_205357_2_, (PlayerEntity)null, pos, SpawnReason.BUCKET, true, false);
		if(entity != null) 
		{
			entity.setAge(-24000);
		}
	}
}
