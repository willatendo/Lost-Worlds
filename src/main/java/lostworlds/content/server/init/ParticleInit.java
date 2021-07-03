package lostworlds.content.server.init;

import lostworlds.library.util.ModRegistry;
import net.minecraft.particles.BasicParticleType;
import net.minecraftforge.fml.RegistryObject;

/*
 * Author: Willatendo
 * Date: July 2, 2021
 */

public class ParticleInit 
{
	public static final RegistryObject<BasicParticleType> PERMIAN_DESERT_AMBIANT_DUST = ModRegistry.register("permian_desert_ambiant_dust");
	
	//Registry
	public static void init() { }
}
