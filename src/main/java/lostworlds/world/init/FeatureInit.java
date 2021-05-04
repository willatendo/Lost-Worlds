package lostworlds.world.init;

import lostworlds.core.util.ModID;
import lostworlds.world.feature.lake.PermianLakesFeature;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class FeatureInit 
{
	public static final Feature<BlockStateFeatureConfig> LAKES = new PermianLakesFeature<>(BlockStateFeatureConfig.CODEC);

	public static void init(Register<Feature<?>> event)
	{
		register(event.getRegistry(), LAKES, "permian_lakes");
	}
	
	public static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, T entry, String registryKey) 
    {
        entry.setRegistryName(new ResourceLocation(ModID.ID, registryKey));
        registry.register(entry);
        return entry;
    }
}
