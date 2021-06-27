package api.core.init;

import library.Init;
import library.ModRegistry;
import library.util.ModUtil;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;

@Init
public class SoundInit extends ModRegistry
{
	public static final RegistryObject<SoundEvent> POT_BREAK = register("block.pot.smash");
	
	//Registry
	public static RegistryObject<SoundEvent> register(String id)
	{
		return SOUND_REGISTRY.register(id, () -> new SoundEvent(ModUtil.rL(id)));
	}
}
