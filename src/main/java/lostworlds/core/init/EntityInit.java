package lostworlds.core.init;

import lostworlds.common.entities.NautilusEntity;
import lostworlds.common.entities.PalaeoniscumEntity;
import lostworlds.common.entities.ProcompsognathusEntity;
import lostworlds.common.entities.RhinesuchusEntity;
import lostworlds.core.util.registry.ModRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;

public class EntityInit 
{
	public static final RegistryObject<EntityType<ProcompsognathusEntity>> PROCOMPSOGNATHUS_ENTITY = registerEntity("procompsognathus", ProcompsognathusEntity::new, EntityClassification.CREATURE, ProcompsognathusEntity.class, 0.3F, 0.7F);
	public static final RegistryObject<EntityType<PalaeoniscumEntity>> PALAEONISCUM_ENTITY = registerEntity("palaeoniscum", PalaeoniscumEntity::new, EntityClassification.WATER_AMBIENT, PalaeoniscumEntity.class, 0.25F, 0.25F);
	public static final RegistryObject<EntityType<NautilusEntity>> NAUTILUS_ENTITY = registerEntity("nautilus", NautilusEntity::new, EntityClassification.WATER_AMBIENT, NautilusEntity.class, 0.5F, 1.0F);
	public static final RegistryObject<EntityType<RhinesuchusEntity>> RHINESUCHUS_ENTITY = registerEntity("rhinesuchus", RhinesuchusEntity::new, EntityClassification.CREATURE, RhinesuchusEntity.class, 0.5F, 0.5F);
	
	//Registry
	public static <T extends Entity> RegistryObject<EntityType<T>> registerEntity(String name, EntityType.IFactory<T> entity, EntityClassification entitytype, Class<T> entityClass, float width, float height) 
	{
		return ModRegistry.ENTITY_REGISTRY.register(name, () -> EntityType.Builder.of(entity, entitytype).sized(width, height).build(name));
	}
	
	public static void initEntities() { }
}
