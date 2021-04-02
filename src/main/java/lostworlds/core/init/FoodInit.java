package lostworlds.core.init;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class FoodInit 
{
	public static final Food RAW_PROCOMPSOGNATHUS_MEAT = new Food.Builder().effect(() -> new EffectInstance(Effects.POISON, 100), 0.25F).nutrition(1).saturationMod(0.0F).build();
	public static final Food COOKED_PROCOMPSOGNATHUS_MEAT = new Food.Builder().nutrition(2).saturationMod(0.26F).build();
	
	public static final Food PALAEONISCUM = new Food.Builder().effect(() -> new EffectInstance(Effects.POISON, 100), 0.25F).nutrition(2).saturationMod(0.0F).build();
	public static final Food COOKED_PALAEONISCUM = new Food.Builder().nutrition(6).saturationMod(0.26F).build();
	
	public static final Food NAUTILUS_TENTICAL = new Food.Builder().effect(() -> new EffectInstance(Effects.POISON, 100), 0.25F).nutrition(2).saturationMod(0.0F).build();
	public static final Food COOKED_NAUTILUS_TENTICAL = new Food.Builder().nutrition(8).saturationMod(0.56F).build();
	
	public static final Food RAW_RHINESUCHUS_MEAT = new Food.Builder().effect(() -> new EffectInstance(Effects.POISON, 100), 0.25F).nutrition(2).saturationMod(0.0F).build();
	public static final Food COOKED_RHINESUCHUS_MEAT = new Food.Builder().nutrition(8).saturationMod(0.56F).build();

	public static final Food RAW_DIMETRODON_MEAT = new Food.Builder().effect(() -> new EffectInstance(Effects.POISON, 100), 0.25F).nutrition(2).saturationMod(0.0F).build();
	public static final Food COOKED_DIMETRODON_MEAT = new Food.Builder().nutrition(10).saturationMod(0.56F).build();
}
