package lostworlds.common.entities;

import lostworlds.core.init.EntityInit;
import lostworlds.core.init.ItemInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class GreatAukEggEntity extends ProjectileItemEntity
{
	public GreatAukEggEntity(EntityType<? extends GreatAukEggEntity> entity, World worldIn) 
	{
		super(entity, worldIn);
	}
	
	public GreatAukEggEntity(World worldIn, LivingEntity entity) 
	{
		super(EntityInit.GREAT_AUK_EGG_ENTITY.get(), entity, worldIn);
	}
	
	public GreatAukEggEntity(World worldIn, double x, double y, double z) 
	{
		super(EntityInit.GREAT_AUK_EGG_ENTITY.get(), x, y, z, worldIn);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public void handleEntityEvent(byte status) 
	{
		if(status == 3) 
		{
			for(int i = 0; i < 8; ++i) 
			{
				this.level.addParticle(new ItemParticleData(ParticleTypes.ITEM, this.getItem()), this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D);
			}
		}
	}
	
	@Override
	protected void onHitEntity(EntityRayTraceResult trace) 
	{
		super.onHitEntity(trace);
		trace.getEntity().hurt(DamageSource.thrown(this, this.getOwner()), 0.0F);
	}
	
	@Override
	protected void onHit(RayTraceResult trace) 
	{
		super.onHit(trace);
		if(!this.level.isClientSide) 
		{
			if(this.random.nextInt(8) == 0) 
			{
				int i = 1;
				if(this.random.nextInt(32) == 0) 
				{
					i = 4;
				}
				
				for(int j = 0; j < i; ++j) 
				{
					GreatAukEntity greatauk = EntityInit.GREAT_AUK_ENTITY.get().create(this.level);
					greatauk.setAge(-24000);
					greatauk.moveTo(this.getX(), this.getY(), this.getZ(), this.yRot, 0.0F);
					this.level.addFreshEntity(greatauk);
				}
			}
			
			this.level.broadcastEntityEvent(this, (byte)3);
			this.remove();
		}
	}
	
	@Override
	protected Item getDefaultItem() 
	{
		return ItemInit.GREAT_AUK_EGG.get();
	}
}
