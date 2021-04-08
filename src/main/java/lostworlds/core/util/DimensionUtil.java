package lostworlds.core.util;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

public class DimensionUtil 
{
	public static RegistryKey<World> getWorld(ResourceLocation id)
	{
		return RegistryKey.create(Registry.DIMENSION_REGISTRY, id);
	}
	
	public static RegistryKey<DimensionType> getDimensionType(ResourceLocation id)
	{
		return RegistryKey.create(Registry.DIMENSION_TYPE_REGISTRY, id);
	}
	
	public static RegistryKey<Dimension> getDimensionSettings(ResourceLocation id)
	{
		return RegistryKey.create(Registry.LEVEL_STEM_REGISTRY, id);
	}
}
