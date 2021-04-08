package lostworlds.core.init;

import lostworlds.core.util.ModID;
import lostworlds.core.util.registry.ModRegistry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.RegistryObject;

public class SoundInit 
{	
	//Compy Sounds
	public static final RegistryObject<SoundEvent> COMPY_AMBIENT = ModRegistry.SOUND_REGISTRY.register("procompsognathus_ambient", () -> new SoundEvent(new ResourceLocation(ModID.ID, "entity.procompsognathus.ambient")));
	public static final RegistryObject<SoundEvent> COMPY_HURT = ModRegistry.SOUND_REGISTRY.register("procompsognathus_hurt", () -> new SoundEvent(new ResourceLocation(ModID.ID, "entity.procompsognathus.hurt")));
	public static final RegistryObject<SoundEvent> COMPY_DEATH = ModRegistry.SOUND_REGISTRY.register("procompsognathus_death", () -> new SoundEvent(new ResourceLocation(ModID.ID, "entity.procompsognathus.death")));
	
	//Dimetrodon
	public static final RegistryObject<SoundEvent> DIMETRODON_AMBIENT = ModRegistry.SOUND_REGISTRY.register("dimetrodon_ambient", () -> new SoundEvent(new ResourceLocation(ModID.ID, "entity.dimetrodon.ambient")));
	public static final RegistryObject<SoundEvent> DIMETRODON_HURT = ModRegistry.SOUND_REGISTRY.register("dimetrodon_hurt", () -> new SoundEvent(new ResourceLocation(ModID.ID, "entity.dimetrodon.hurt")));
	public static final RegistryObject<SoundEvent> DIMETRODON_DEATH = ModRegistry.SOUND_REGISTRY.register("dimetrodon_death", () -> new SoundEvent(new ResourceLocation(ModID.ID, "entity.dimetrodon.death")));
	
	//Dimetrodon
	public static final RegistryObject<SoundEvent> GORGONOPS_AMBIENT = ModRegistry.SOUND_REGISTRY.register("gorgonops_ambient", () -> new SoundEvent(new ResourceLocation(ModID.ID, "entity.gorgonops.ambient")));
	public static final RegistryObject<SoundEvent> GORGONOPS_HURT = ModRegistry.SOUND_REGISTRY.register("gorgonops_hurt", () -> new SoundEvent(new ResourceLocation(ModID.ID, "entity.gorgonops.hurt")));
	public static final RegistryObject<SoundEvent> GORGONOPS_DEATH = ModRegistry.SOUND_REGISTRY.register("gorgonops_death", () -> new SoundEvent(new ResourceLocation(ModID.ID, "entity.gorgonops.death")));
	
	//Edaphosaurus
	public static final RegistryObject<SoundEvent> EDAPHOSAURUS_AMBIENT = ModRegistry.SOUND_REGISTRY.register("edaphosaurus_ambient", () -> new SoundEvent(new ResourceLocation(ModID.ID, "entity.edaphosaurus.ambient")));
	public static final RegistryObject<SoundEvent> EDAPHOSAURUS_HURT = ModRegistry.SOUND_REGISTRY.register("edaphosaurus_hurt", () -> new SoundEvent(new ResourceLocation(ModID.ID, "entity.edaphosaurus.hurt")));
	public static final RegistryObject<SoundEvent> EDAPHOSAURUS_DEATH = ModRegistry.SOUND_REGISTRY.register("edaphosaurus_death", () -> new SoundEvent(new ResourceLocation(ModID.ID, "entity.edaphosaurus.death")));
		
	//Music Disc
	public static final Lazy<SoundEvent> LAZY_JP_MUSIC = Lazy.of(() -> new SoundEvent(new ResourceLocation(ModID.ID, "disc.jurassic_park")));
	public static final RegistryObject<SoundEvent> JP_MUSIC = ModRegistry.SOUND_REGISTRY.register("jurassic_park", LAZY_JP_MUSIC);
	
	public static void initSounds() { }
}
 	