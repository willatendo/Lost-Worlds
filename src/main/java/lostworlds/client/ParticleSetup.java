package lostworlds.client;

import lostworlds.common.particle.PermianDesertDustParticle;
import lostworlds.core.init.ParticleInit;
import lostworlds.core.util.ModUtil;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = ModUtil.ID, value = Dist.CLIENT, bus = Bus.MOD)
public class ParticleSetup 
{
	@SuppressWarnings("resource")
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void registerParticles(ParticleFactoryRegisterEvent event) 
	{
		ModUtil.LOGGER.debug("Loading: Setting Up Particle Render");
		
		Minecraft.getInstance().particleEngine.register(ParticleInit.PERMIAN_DESERT_AMBIANT_DUST.get(), PermianDesertDustParticle.Factory::new);
		
		ModUtil.LOGGER.debug("Finished: Setting Up Particle Render");
	}
}
