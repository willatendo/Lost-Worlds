package lostworlds.common.items;

import lostworlds.core.ModItemGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.FishBucketItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.fml.RegistryObject;

public class ModFishBucketItem extends FishBucketItem
{
	private final Lazy<? extends EntityType<?>> entityTypeSupplier;

	@SuppressWarnings("deprecation")
	public ModFishBucketItem(final NonNullSupplier<? extends EntityType<?>> entityTypeSupplier, final Fluid fluid) 
	{
		super(null, fluid, new Item.Properties().tab(ModItemGroup.CREATURES_TAB).stacksTo(1));
		this.entityTypeSupplier = Lazy.of(entityTypeSupplier::get);
	}

	@SuppressWarnings("deprecation")
	public ModFishBucketItem(final RegistryObject<? extends EntityType<?>> entityTypeSupplier, final Fluid fluid) 
	{
		super(null, fluid, new Item.Properties().tab(ModItemGroup.CREATURES_TAB).stacksTo(1));
		this.entityTypeSupplier = Lazy.of(entityTypeSupplier::get);
	}
	
	@Override
	protected EntityType<?> getFishType() 
	{
		return this.entityTypeSupplier.get();
	}
}
