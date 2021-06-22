package lostworlds.core.util;

import net.minecraft.util.DamageSource;

public class ModDamageSources 
{
	public static final DamageSource HUNGER = (new DamageSource("hunger")).bypassArmor();
	public static final DamageSource THIRST = (new DamageSource("thirst")).bypassArmor();
	public static final DamageSource AGE = (new DamageSource("age")).bypassArmor();
}
