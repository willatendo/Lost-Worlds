package lostworlds.common;

import lostworlds.core.init.EntityInit;
import lostworlds.core.util.ModUtil;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = ModUtil.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AttributeSetup 
{
	@SuppressWarnings("deprecation")
	@SubscribeEvent
	public static void registerEntityAttributes(FMLCommonSetupEvent event) 
	{
		event.enqueueWork(() -> 
		{
			GlobalEntityTypeAttributes.put(EntityInit.ALLOSAURUS_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 25.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 3.0D).build());
			GlobalEntityTypeAttributes.put(EntityInit.CARNOTAURUS_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 2.0D).build());
			GlobalEntityTypeAttributes.put(EntityInit.CHILESAURUS_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 5.0D).add(Attributes.MOVEMENT_SPEED, 0.3D).build());
			GlobalEntityTypeAttributes.put(EntityInit.CRYOLOPHOSAURUS_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 25.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 3.0D).build());
			GlobalEntityTypeAttributes.put(EntityInit.DIMETRODON_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 15.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 2.0D).build());
			GlobalEntityTypeAttributes.put(EntityInit.DIICTODON_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 5.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).build());
			GlobalEntityTypeAttributes.put(EntityInit.EDAPHOSAURUS_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).build());
			GlobalEntityTypeAttributes.put(EntityInit.FUKUIVENATOR_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 7.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 1.0D).build());
			GlobalEntityTypeAttributes.put(EntityInit.GIGANOTOSAURUS_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 35.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 14.0D).build());
			GlobalEntityTypeAttributes.put(EntityInit.GORGONOPS_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 25.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 3.0D).build());
			GlobalEntityTypeAttributes.put(EntityInit.GREAT_AUK_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 7.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 1.0D).build());
			GlobalEntityTypeAttributes.put(EntityInit.KENTROSAURUS_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 15.0D).add(Attributes.MOVEMENT_SPEED, 0.3D).add(Attributes.ATTACK_DAMAGE, 9.0D).build());
			GlobalEntityTypeAttributes.put(EntityInit.NAUTILUS_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.ARMOR, 6.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).build());
			GlobalEntityTypeAttributes.put(EntityInit.OSTROMIA_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 7.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 2.0D).build());
			GlobalEntityTypeAttributes.put(EntityInit.OURANOSAURUS_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 15.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).build());
			GlobalEntityTypeAttributes.put(EntityInit.PALAEONISCUM_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 7.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).build());
			GlobalEntityTypeAttributes.put(EntityInit.PROCOMPSOGNATHUS_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 5.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 1.0D).build());
			GlobalEntityTypeAttributes.put(EntityInit.PROTOSUCHUS_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, .0D).build());
			GlobalEntityTypeAttributes.put(EntityInit.PSITTACOSAURUS_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 9.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).build());
			GlobalEntityTypeAttributes.put(EntityInit.RHINESUCHUS_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).build());
			GlobalEntityTypeAttributes.put(EntityInit.SUCHOMIMUS_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 6.0D).build());
			GlobalEntityTypeAttributes.put(EntityInit.TETRACERATOPS_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 7.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 1.0D).build());
			GlobalEntityTypeAttributes.put(EntityInit.TYRANNOSAURUS_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 30.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 12.0D).build());
		});
	}
}
