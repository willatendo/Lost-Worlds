package api.core.init;

import library.Init;
import library.ModRegistry;
import net.minecraft.particles.BasicParticleType;
import net.minecraftforge.fml.RegistryObject;

@Init
public class ParticleInit extends ModRegistry
{
	public static final RegistryObject<BasicParticleType> PERMIAN_DESERT_AMBIANT_DUST = PARTICLE_REGISTRY.register("permian_desert_ambiant_dust", () -> new BasicParticleType(true));
}
