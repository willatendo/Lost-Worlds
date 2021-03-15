package lostworlds.core.init;

import lostworlds.common.entities.PalaeoniscumFreieslebeniEntity;
import lostworlds.common.entities.ProcompsognathusTriassicusEntity;
import lostworlds.core.util.registry.ModRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;

public class EntityInit 
{
	public static final RegistryObject<EntityType<ProcompsognathusTriassicusEntity>> PROCOMPSOGNATHUS_TRIASSICUS_ENTITY = registerEntity("procompsognathus_triassicus", ProcompsognathusTriassicusEntity::new, EntityClassification.CREATURE, ProcompsognathusTriassicusEntity.class, 0.3F, 0.7F);
	public static final RegistryObject<EntityType<PalaeoniscumFreieslebeniEntity>> PALAEONISCUM_FREISLEBENI_ENTITY = registerEntity("palaeoniscum_freislbeni", PalaeoniscumFreieslebeniEntity::new, EntityClassification.WATER_AMBIENT, PalaeoniscumFreieslebeniEntity.class, 0.25F, 0.25F);
	
	//Registry
	public static <T extends Entity> RegistryObject<EntityType<T>> registerEntity(String name, EntityType.IFactory<T> entity, EntityClassification entitytype, Class<T> entityClass, float width, float height) 
	{
		return ModRegistry.ENTITY_REGISTRY.register(name, () -> EntityType.Builder.create(entity, entitytype).size(width, height).build(name));
	}
	
	public static void initEntities() { }
}
