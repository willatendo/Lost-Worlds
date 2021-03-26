package lostworlds.common;

import lostworlds.core.init.EntityInit;
import lostworlds.core.util.reference.ModReference;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = ModReference.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonSetup 
{
	@SuppressWarnings("deprecation")
	@SubscribeEvent
	public static void registerEntityAttributes(FMLCommonSetupEvent event) 
	{
		event.enqueueWork(() -> 
		{
			GlobalEntityTypeAttributes.put(EntityInit.PROCOMPSOGNATHUS_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 2.5D).add(Attributes.MOVEMENT_SPEED, 0.5D).build());
			GlobalEntityTypeAttributes.put(EntityInit.PALAEONISCUM_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 5.0D).add(Attributes.MOVEMENT_SPEED, 0.5D).build());
			GlobalEntityTypeAttributes.put(EntityInit.NAUTILUS_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, 0.75D).build());
			GlobalEntityTypeAttributes.put(EntityInit.RHINESUCHUS_ENTITY.get(), MobEntity.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 3.0F).build());
		});
	}
}
