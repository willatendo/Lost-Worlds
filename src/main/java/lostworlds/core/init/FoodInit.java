package lostworlds.core.init;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class FoodInit 
{
	public static final Food RAW_PROCOMPSOGNATHUS_MEAT = new Food.Builder().effect(() -> new EffectInstance(Effects.POISON, 100), 0.25F).hunger(1).saturation(0.0F).build();
	public static final Food COOKED_PROCOMPSOGNATHUS_MEAT = new Food.Builder().hunger(2).saturation(0.26F).build();
	
	public static final Food PALAEONISCUM = new Food.Builder().effect(() -> new EffectInstance(Effects.POISON, 100), 0.25F).hunger(2).saturation(0.0F).build();
	public static final Food COOKED_PALAEONISCUM = new Food.Builder().hunger(6).saturation(0.26F).build();
	
	public static final Food NAUTILUS_TENTICAL = new Food.Builder().effect(() -> new EffectInstance(Effects.POISON, 100), 0.25F).hunger(2).saturation(0.0F).build();
	public static final Food COOKED_NAUTILUS_TENTICAL = new Food.Builder().hunger(8).saturation(0.56F).build();
}
