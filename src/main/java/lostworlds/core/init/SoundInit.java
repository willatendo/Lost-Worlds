package lostworlds.core.init;

import lostworlds.core.util.reference.ModReference;
import lostworlds.core.util.registry.ModRegistry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.RegistryObject;

public class SoundInit 
{	
	//Compy Sounds
	public static final RegistryObject<SoundEvent> COMPY_AMBIANT = ModRegistry.SOUND_REGISTRY.register("compy_ambient", () -> new SoundEvent(new ResourceLocation(ModReference.ID, "entity.compy.ambient")));
	public static final RegistryObject<SoundEvent> COMPY_HURT = ModRegistry.SOUND_REGISTRY.register("compy_hurt", () -> new SoundEvent(new ResourceLocation(ModReference.ID, "entity.compy.hurt")));
	public static final RegistryObject<SoundEvent> COMPY_DEATH = ModRegistry.SOUND_REGISTRY.register("compy_death", () -> new SoundEvent(new ResourceLocation(ModReference.ID, "entity.compy.death")));
	
	//Music Disc
	public static final Lazy<SoundEvent> LAZY_JP_MUSIC = Lazy.of(() -> new SoundEvent(new ResourceLocation(ModReference.ID, "disc.jurassic_park")));
	public static final RegistryObject<SoundEvent> JP_MUSIC = ModRegistry.SOUND_REGISTRY.register("jurassic_park", LAZY_JP_MUSIC);
	
	public static void initSounds() { }
}
 	