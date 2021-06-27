package library.util.base;

import api.core.init.SoundInit;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.util.ForgeSoundType;

public class ModSoundTypes 
{
	public static final ForgeSoundType POT_SOUNDS = new ForgeSoundType(1.0F, 1.0F, () -> SoundInit.POT_BREAK.get(), () -> SoundEvents.STONE_STEP, () -> SoundEvents.STONE_PLACE, () -> SoundEvents.STONE_HIT, () -> SoundEvents.STONE_FALL);
}
