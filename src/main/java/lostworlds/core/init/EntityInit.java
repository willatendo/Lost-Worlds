package lostworlds.core.init;

import lostworlds.common.entities.AllosaurusEntity;
import lostworlds.common.entities.CarnotaurusEntity;
import lostworlds.common.entities.CryolophosaurusEntity;
import lostworlds.common.entities.DiictodonEntity;
import lostworlds.common.entities.DimetrodonEntity;
import lostworlds.common.entities.EdaphosaurusEntity;
import lostworlds.common.entities.FukuivenatorEntity;
import lostworlds.common.entities.GiganotosaurusEntity;
import lostworlds.common.entities.GorgonopsEntity;
import lostworlds.common.entities.GreatAukEggEntity;
import lostworlds.common.entities.GreatAukEntity;
import lostworlds.common.entities.ModBoatEntity;
import lostworlds.common.entities.NautilusEntity;
import lostworlds.common.entities.OstromiaEntity;
import lostworlds.common.entities.OuranosaurusEntity;
import lostworlds.common.entities.PalaeoniscumEntity;
import lostworlds.common.entities.ProcompsognathusEntity;
import lostworlds.common.entities.ProtosuchusEntity;
import lostworlds.common.entities.PsittacosaurusEntity;
import lostworlds.common.entities.RhinesuchusEntity;
import lostworlds.common.entities.SuchomimusEntity;
import lostworlds.common.entities.TetraceratopsEntity;
import lostworlds.common.entities.TyrannosaurusEntity;
import lostworlds.core.util.ModUtil;
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
	public static final RegistryObject<EntityType<RhinesuchusEntity>> RHINESUCHUS_ENTITY = registerEntity("rhinesuchus", RhinesuchusEntity::new, EntityClassification.CREATURE, RhinesuchusEntity.class, 0.34F, 0.34F);
	public static final RegistryObject<EntityType<DimetrodonEntity>> DIMETRODON_ENTITY = registerEntity("dimetrodon", DimetrodonEntity::new, EntityClassification.CREATURE, DimetrodonEntity.class, 0.75F, 2.0F);
	public static final RegistryObject<EntityType<EdaphosaurusEntity>> EDAPHOSAURUS_ENTITY = registerEntity("edaphosaurus", EdaphosaurusEntity::new, EntityClassification.CREATURE, EdaphosaurusEntity.class, 0.5F, 1.25F);
	public static final RegistryObject<EntityType<GorgonopsEntity>> GORGONOPS_ENTITY = registerEntity("gorgonops", GorgonopsEntity::new, EntityClassification.CREATURE, GorgonopsEntity.class, 0.4F, 0.5F);
	public static final RegistryObject<EntityType<CarnotaurusEntity>> CARNOTAURUS_ENTITY = registerEntity("carnotaurus", CarnotaurusEntity::new, EntityClassification.CREATURE, CarnotaurusEntity.class, 0.75F, 1.25F);
	public static final RegistryObject<EntityType<TyrannosaurusEntity>> TYRANNOSAURUS_ENTITY = registerEntity("tyrannosaurus", TyrannosaurusEntity::new, EntityClassification.CREATURE, TyrannosaurusEntity.class, 1.0F, 1.75F);
	public static final RegistryObject<EntityType<AllosaurusEntity>> ALLOSAURUS_ENTITY = registerEntity("allosaurus", AllosaurusEntity::new, EntityClassification.CREATURE, AllosaurusEntity.class, 1.25F, 1.75F);
	public static final RegistryObject<EntityType<GiganotosaurusEntity>> GIGANOTOSAURUS_ENTITY = registerEntity("giganotosaurus", GiganotosaurusEntity::new, EntityClassification.CREATURE, GiganotosaurusEntity.class, 1.6F, 1.75F);
	public static final RegistryObject<EntityType<SuchomimusEntity>> SUCHOMIMUS_ENTITY = registerEntity("suchomimus", SuchomimusEntity::new, EntityClassification.CREATURE, SuchomimusEntity.class, 2.0F, 1.75F);
	public static final RegistryObject<EntityType<TetraceratopsEntity>> TETRACERATOPS_ENTITY = registerEntity("tetraceratops", TetraceratopsEntity::new, EntityClassification.CREATURE, TetraceratopsEntity.class, 0.25F, 0.25F);
	public static final RegistryObject<EntityType<GreatAukEntity>> GREAT_AUK_ENTITY = registerEntity("great_auk", GreatAukEntity::new, EntityClassification.CREATURE, GreatAukEntity.class, 0.4F, 0.7F);
	public static final RegistryObject<EntityType<GreatAukEggEntity>> GREAT_AUK_EGG_ENTITY = registerEntity("great_auk_egg", GreatAukEggEntity::new, EntityClassification.MISC, GreatAukEggEntity.class, 0.5F, 0.5F);
	public static final RegistryObject<EntityType<OuranosaurusEntity>> OURANOSAURUS_ENTITY = registerEntity("ouranosaurus", OuranosaurusEntity::new, EntityClassification.CREATURE, OuranosaurusEntity.class, 0.7F, 0.9F);
	public static final RegistryObject<EntityType<FukuivenatorEntity>> FUKUIVENATOR_ENTITY = registerEntity("fukuivenator", FukuivenatorEntity::new, EntityClassification.CREATURE, FukuivenatorEntity.class, 0.5F, 0.6F);
	public static final RegistryObject<EntityType<PsittacosaurusEntity>> PSITTACOSAURUS_ENTITY = registerEntity("pisttacosaurus", PsittacosaurusEntity::new, EntityClassification.CREATURE, PsittacosaurusEntity.class, 0.5F, 0.5F);
	public static final RegistryObject<EntityType<CryolophosaurusEntity>> CRYOLOPHOSAURUS_ENTITY = registerEntity("cryolophosaurus", CryolophosaurusEntity::new, EntityClassification.CREATURE, CryolophosaurusEntity.class, 0.75F, 1.9F);
	public static final RegistryObject<EntityType<OstromiaEntity>> OSTROMIA_ENTITY = registerEntity("ostromia", OstromiaEntity::new, EntityClassification.CREATURE, OstromiaEntity.class, 0.5F, 0.5F);
	public static final RegistryObject<EntityType<ProtosuchusEntity>> PROTOSUCHUS_ENTITY = registerEntity("protosuchus", ProtosuchusEntity::new, EntityClassification.CREATURE, ProtosuchusEntity.class, 0.5F, 0.5F);
	public static final RegistryObject<EntityType<DiictodonEntity>> DIICTODON_ENTITY = registerEntity("diictodon", DiictodonEntity::new, EntityClassification.CREATURE, DiictodonEntity.class, 0.25F, 0.25F);
	
	//Boat
    public static final RegistryObject<EntityType<ModBoatEntity>> BOAT = registerEntity("boat", ModBoatEntity::new, EntityClassification.MISC, ModBoatEntity.class, 1.375F, 0.5625F);
    
	//Registry
	public static <T extends Entity> RegistryObject<EntityType<T>> registerEntity(String name, EntityType.IFactory<T> entity, EntityClassification entitytype, Class<T> entityClass, float width, float height) 
	{
		return ModRegistry.ENTITY_REGISTRY.register(name, () -> EntityType.Builder.of(entity, entitytype).sized(width, height).build(name));
	}
	
	public static void initEntities() { ModUtil.LOGGER.debug("Registering: Mod Entities"); }
}
