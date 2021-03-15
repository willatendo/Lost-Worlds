package lostworlds.core.init;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class FoodInit 
{
	public static final Food RAW_PROCOMPSOGNATHUS_MEAT = new Food.Builder().effect(() -> new EffectInstance(Effects.POISON, 100), 0.5F).hunger(1).saturation(0.0F).build();
	public static final Food COOKED_PROCOMPSOGNATHUS_MEAT = new Food.Builder().hunger(2).saturation(0.26F).build();
}
