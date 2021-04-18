package lostworlds.common;

import lostworlds.core.init.EntityInit;
import lostworlds.core.util.ModID;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = ModID.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonSetup 
{
	@SuppressWarnings("deprecation")
	@SubscribeEvent
	public static void registerEntityAttributes(FMLCommonSetupEvent event) 
	{
		event.enqueueWork(() -> 
		{
			GlobalEntityTypeAttributes.put(EntityInit.PROCOMPSOGNATHUS_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 2.5D).add(Attributes.MOVEMENT_SPEED, 0.5D).add(Attributes.ATTACK_DAMAGE, 1.0D).build());
			GlobalEntityTypeAttributes.put(EntityInit.PALAEONISCUM_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 5.0D).add(Attributes.MOVEMENT_SPEED, 0.5D).build());
			GlobalEntityTypeAttributes.put(EntityInit.NAUTILUS_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, 0.75D).build());
			GlobalEntityTypeAttributes.put(EntityInit.RHINESUCHUS_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 3.0F).build());
			GlobalEntityTypeAttributes.put(EntityInit.DIMETRODON_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 35.0D).add(Attributes.MOVEMENT_SPEED, 0.5D).add(Attributes.ATTACK_DAMAGE, 5.0D).add(Attributes.ARMOR_TOUGHNESS, 2.0D).build());
			GlobalEntityTypeAttributes.put(EntityInit.EDAPHOSAURUS_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 15.0D).add(Attributes.MOVEMENT_SPEED, 0.5D).build());
			GlobalEntityTypeAttributes.put(EntityInit.GORGONOPS_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.5D).add(Attributes.ATTACK_DAMAGE, 7.0D).build());
			GlobalEntityTypeAttributes.put(EntityInit.CARNOTAURUS_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 50.0D).add(Attributes.MOVEMENT_SPEED, 0.5D).add(Attributes.ATTACK_DAMAGE, 7.0D).build());
			GlobalEntityTypeAttributes.put(EntityInit.TYRANNOSAURUS_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 75.0D).add(Attributes.MOVEMENT_SPEED, 0.5D).add(Attributes.ATTACK_DAMAGE, 20.0D).build());
			GlobalEntityTypeAttributes.put(EntityInit.ALLOSAURUS_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 55.0D).add(Attributes.MOVEMENT_SPEED, 0.5D).add(Attributes.ATTACK_DAMAGE, 8.0D).build());
			GlobalEntityTypeAttributes.put(EntityInit.GIGANOTOSAURUS_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 80.0D).add(Attributes.MOVEMENT_SPEED, 0.5D).add(Attributes.ATTACK_DAMAGE, 24.0D).build());
			GlobalEntityTypeAttributes.put(EntityInit.SUCHOMIMUS_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 65.0D).add(Attributes.MOVEMENT_SPEED, 0.5D).add(Attributes.ATTACK_DAMAGE, 11.0D).build());
			GlobalEntityTypeAttributes.put(EntityInit.TETRACERATOPS_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, 0.5D).build());
		});
	}
}
