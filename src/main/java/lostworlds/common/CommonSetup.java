package lostworlds.common;

import lostworlds.core.init.EntityInit;
import lostworlds.core.util.reference.Reference;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = Reference.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonSetup 
{
	@SubscribeEvent
	public static void registerEntityAttributes(FMLCommonSetupEvent event) 
	{
		event.enqueueWork(() -> 
		{
			GlobalEntityTypeAttributes.put(EntityInit.PROCOMPSOGNATHUS_ENTITY.get(), MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 2.5D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.5D).create());
			GlobalEntityTypeAttributes.put(EntityInit.PALAEONISCUM_ENTITY.get(), MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 5.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.5D).create());
			GlobalEntityTypeAttributes.put(EntityInit.NAUTILUS_ENTITY.get(), MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 10.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 1.0D).create());
		});
	}
}
