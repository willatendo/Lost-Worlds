package lostworlds.core.util.enums;

import java.util.function.Supplier;

import lostworlds.core.init.ItemInit;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

public enum ModItemTeir implements IItemTier
{
	LEATHER_BRUSH(0, 34, 0.5F, 1.4F, 0, () -> 
	{
		return Ingredient.of(Items.STRING);
	}),
	IRON_BRUSH(0, 254, 1.5F, 1.4F, 0, () -> 
	{
		return Ingredient.of(Items.STRING);
	}),
	GOLD_BRUSH(0, 51, 2.8F, 1.4F, 0, () -> 
	{
		return Ingredient.of(Items.STRING);
	}),
	DIAMOND_BRUSH(0, 1554, 2.5F, 1.4F, 0, () -> 
	{
		return Ingredient.of(Items.STRING);
	}),
	ANCIENT(2, 550, 5.0F, 10.0F, 5, () ->
	{
		return Ingredient.of(Items.IRON_INGOT);
	}),	
	SCARAB(4, 15000, 30.0F, 80.0F, 40, () -> 
	{
		return Ingredient.of(ItemInit.CRYSTAL_SCARAB_GEM.get()); 
	});
	
	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantability;
	private final LazyValue<Ingredient> repairMaterial;
	
	private ModItemTeir(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) 
	{
		this.harvestLevel = harvestLevelIn;
		this.maxUses = maxUsesIn;
		this.efficiency = efficiencyIn;
		this.attackDamage = attackDamageIn;
		this.enchantability = enchantabilityIn;
		this.repairMaterial = new LazyValue<>(repairMaterialIn);
	}
	
	public int getUses() 
	{
		return this.maxUses;
	}
	
	public float getSpeed() 
	{
		return this.efficiency;
	}
	
	public float getAttackDamageBonus() 
	{
		return this.attackDamage;
	}
	
	public int getLevel() 
	{
		return this.harvestLevel;
	}
	
	public int getEnchantmentValue() 
	{
		return this.enchantability;
	}
	
	public Ingredient getRepairIngredient() 
	{
		return this.repairMaterial.get();
	}
}
