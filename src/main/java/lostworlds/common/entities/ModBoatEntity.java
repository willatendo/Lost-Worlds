package lostworlds.common.entities;

import lostworlds.core.init.BlockInit;
import lostworlds.core.init.EntityInit;
import lostworlds.core.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IndirectEntityDamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;

public class ModBoatEntity extends BoatEntity
{
	private static final DataParameter<Integer> LOST_WORLDS_BOAT_TYPE = EntityDataManager.defineId(ModBoatEntity.class, DataSerializers.INT);
	@SuppressWarnings("unused")
	private double lastYd;
	private Status status;

	public ModBoatEntity(World worldIn, double x, double y, double z) 
	{
		this(EntityInit.BOAT.get(), worldIn);
		this.setPos(x, y, z);
		this.setDeltaMovement(Vector3d.ZERO);
		this.xo = x;
		this.yo = y;
		this.zo = z;
	}
	
	public ModBoatEntity(EntityType<? extends ModBoatEntity> boatEntityType, World worldType) 
	{
		super(boatEntityType, worldType);
	}
	
	public ModBoatEntity(FMLPlayMessages.SpawnEntity packet, World world) 
	{
        super(EntityInit.BOAT.get(), world);
    }
	
	@Override
	public Item getDropItem() 
	{
		switch(this.getModBoatType())
		{
			default:
				return ItemInit.CONIFER_BOAT.get();
			case GINKGO:
				return ItemInit.GINKGO_BOAT.get();
			case ARAUCARIA:
				return ItemInit.ARAUCARIA_BOAT.get();
		}
	}
	
	public Block getPlanks() 
	{
        switch (this.getModBoatType())
        {
        	default:
        		return BlockInit.CONIFER_PLANKS.get();
        	case GINKGO:
        		return BlockInit.GINKGO_PLANKS.get();
        	case ARAUCARIA:
				return BlockInit.ARAUCARIA_PLANKS.get();
        }
	}
	
	public ModBoatType getModBoatType()
	{
		return ModBoatType.byId(this.entityData.get(LOST_WORLDS_BOAT_TYPE));
	}
	
	public void setBoatType(ModBoatType boatType) 
	{
		this.entityData.set(LOST_WORLDS_BOAT_TYPE, boatType.ordinal());
    }
	
	@Override
    protected void defineSynchedData() 
	{
        super.defineSynchedData();
        this.entityData.define(LOST_WORLDS_BOAT_TYPE, ModBoatType.CONIFER.ordinal());
    }

    @Override
    protected void addAdditionalSaveData(CompoundNBT nbt) 
    {
    	nbt.putString("Type", this.getModBoatType().getName());
    }

    @Override
    protected void readAdditionalSaveData(CompoundNBT nbt) 
    {
        if(nbt.contains("Type", 8)) 
        {
            this.setBoatType(ModBoatType.getTypeFromString(nbt.getString("Type")));
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void animateHurt() 
    {
        this.setHurtDir(-this.getHurtDir());
        this.setHurtTime(10);
        this.setDamage(this.getDamage() * 11.0F);
    }

    @SuppressWarnings("deprecation")
	@Override
    protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) 
    {
        this.lastYd = this.getDeltaMovement().y;
        if(!this.isPassenger()) 
        {
            if(onGroundIn) 
            {
                if(this.fallDistance > 3.0F) 
                {
                    if(this.status != BoatEntity.Status.ON_LAND) 
                    {
                        this.fallDistance = 0.0F;
                        return;
                    }

                    this.causeFallDamage(this.fallDistance, 1.0F);
                    if(!this.level.isClientSide && !this.removed) 
                    {
                        this.remove();
                        if(this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) 
                        {
                            for(int i = 0; i < 3; ++i) 
                            {
                                this.spawnAtLocation(this.getPlanks());
                            }

                            for(int j = 0; j < 2; ++j) 
                            {
                                this.spawnAtLocation(Items.STICK);
                            }
                            
                            this.spawnAtLocation(Blocks.AIR);
                        }
                    }
                }

                this.fallDistance = 0.0F;
            } 
            else if(!this.level.getFluidState((new BlockPos(this.getX(), this.getY(), this.getZ()).below())).is(FluidTags.WATER) && y < 0.0D) 
            {
                this.fallDistance = (float) ((double) this.fallDistance - y);
            }
        }
    }

    @SuppressWarnings("deprecation")
	@Override
    public boolean hurt(DamageSource source, float amount) 
    {
        if(this.isInvulnerableTo(source)) 
        {
            return false;
        } else if(!this.level.isClientSide && !this.removed) 
        {
            if(source instanceof IndirectEntityDamageSource && source.getEntity() != null && this.hasPassenger(source.getEntity())) 
            {
                return false;
            } 
            else
            {
                this.setHurtDir(-this.getHurtDir());
                this.setHurtTime(10);
                this.setDamage(this.getDamage() + amount * 10.0F);
                this.markHurt();
                boolean flag = source.getEntity() instanceof PlayerEntity && ((PlayerEntity) source.getEntity()).abilities.instabuild;
                if(flag || this.getDamage() > 40.0F) 
                {
                    if(!flag && this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) 
                    {
                        this.spawnAtLocation(this.getDropItem());
                    }

                    this.remove();
                }

                return true;
            }
        }
        else 
        {
            return true;
        }
    }

    @Override
    public IPacket<?> getAddEntityPacket() 
    {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
    
    public enum ModBoatType 
    {
    	CONIFER("conifer"),
    	GINKGO("gingko"),
    	ARAUCARIA("araucaria");
    	
    	private final String name;

    	ModBoatType(String string) 
        {
            this.name = string;
        }
    	
        public static ModBoatType byId(int id) 
        {
        	ModBoatType[] aModBoatEntity$BoatType = values();
            if(id < 0 || id >= aModBoatEntity$BoatType.length) 
            {
                id = 0;
            }

            return aModBoatEntity$BoatType[id];
        }

        public static ModBoatType getTypeFromString(String nameIn) 
        {
        	ModBoatType[] aModBoatEntity$BoatType = values();

            for(ModBoatType ModBoatEntityType : aModBoatEntity$BoatType) 
            {
                if(ModBoatEntityType.getName().equals(nameIn)) 
                {
                    return ModBoatEntityType;
                }
            }

            return aModBoatEntity$BoatType[0];
        }

        public String getName() 
        {
            return this.name;
        }

        public String toString() 
        {
            return this.name;
        }
    }
}
