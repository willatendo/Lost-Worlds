package lostworlds.common.items;

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
	public ModFishBucketItem(final NonNullSupplier<? extends EntityType<?>> entityTypeSupplier, final Fluid fluid, final Item.Properties properties) 
	{
		super(null, fluid, properties);
		this.entityTypeSupplier = Lazy.of(entityTypeSupplier::get);
	}

	@SuppressWarnings("deprecation")
	public ModFishBucketItem(final RegistryObject<? extends EntityType<?>> entityTypeSupplier, final Fluid fluid, final Item.Properties properties) 
	{
		super(null, fluid, properties);
		this.entityTypeSupplier = Lazy.of(entityTypeSupplier::get);
	}
	
	@Override
	protected EntityType<?> getFishType() 
	{
		return this.entityTypeSupplier.get();
	}
}
