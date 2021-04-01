package lostworlds.client;

import lostworlds.common.particle.PermianDesertDustParticle;
import lostworlds.core.init.ParticleInit;
import lostworlds.core.util.reference.ModReference;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = ModReference.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleSetup 
{
	@SuppressWarnings("resource")
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void registerParticles(ParticleFactoryRegisterEvent event) 
	{
		Minecraft.getInstance().particleEngine.register(ParticleInit.PERMIAN_DESERT_AMBIANT_DUST.get(), PermianDesertDustParticle.Factory::new);
	}
}
