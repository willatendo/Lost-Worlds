package lostworlds.core.init;

import lostworlds.core.util.ModUtil;
import lostworlds.core.util.registry.ModRegistry;
import net.minecraft.particles.BasicParticleType;
import net.minecraftforge.fml.RegistryObject;

public class ParticleInit 
{
	public static final RegistryObject<BasicParticleType> PERMIAN_DESERT_AMBIANT_DUST = ModRegistry.PARTICLE_REGISTRY.register("permian_desert_ambiant_dust", () -> new BasicParticleType(true));
	
	//Registry	
	public static void initParticles() { ModUtil.LOGGER.debug("Registering: Mod Particles"); }
}
