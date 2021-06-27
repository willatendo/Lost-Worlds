package api.core.init;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class FoodInit 
{
	public static final Food FERN_LITTER = new Food.Builder().effect(() -> new EffectInstance(Effects.POISON, 10000), 0.15F).nutrition(3).saturationMod(0.7F).fast().build();
	public static final Food BOILED_FERN_LITTER = new Food.Builder().nutrition(6).saturationMod(0.9F).fast().build();

	public static final Food SEED = new Food.Builder().nutrition(1).saturationMod(0.3F).fast().build();

	public static final Food PALEO_SALAD = new Food.Builder().nutrition(10).saturationMod(1.0F).build();

	public static final Food RAW_SMALL_DINOSAUR_MEAT = new Food.Builder().effect(() -> new EffectInstance(Effects.POISON, 100), 0.25F).nutrition(1).saturationMod(0.0F).build();
	public static final Food COOKED_SMALL_DINOSAUR_MEAT = new Food.Builder().nutrition(2).saturationMod(0.26F).build();

	public static final Food RAW_MEDIUM_DINOSAUR_MEAT = new Food.Builder().effect(() -> new EffectInstance(Effects.POISON, 100), 0.25F).nutrition(1).saturationMod(0.0F).build();
	public static final Food COOKED_MEDIUM_DINOSAUR_MEAT = new Food.Builder().nutrition(6).saturationMod(0.56F).build();
	
	public static final Food RAW_LARGE_DINOSAUR_MEAT = new Food.Builder().effect(() -> new EffectInstance(Effects.POISON, 100), 0.25F).nutrition(1).saturationMod(0.0F).build();
	public static final Food COOKED_LARGE_DINOSAUR_MEAT = new Food.Builder().nutrition(10).saturationMod(1.0F).build();
}
