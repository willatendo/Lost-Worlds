package api.core.init;

import library.feature.lake.JurassicLakesFeature;
import library.feature.lake.PermianLakesFeature;
import library.util.ModUtil;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class FeatureInit 
{
	public static final Feature<BlockStateFeatureConfig> PERMIAN_LAKES = new PermianLakesFeature<>(BlockStateFeatureConfig.CODEC);
	public static final Feature<BlockStateFeatureConfig> JURASSIC_LAKES = new JurassicLakesFeature<>(BlockStateFeatureConfig.CODEC);

	public static void init(Register<Feature<?>> event)
	{
		register(event.getRegistry(), "permian_lakes", PERMIAN_LAKES);
		register(event.getRegistry(), "jurassic_lakes", JURASSIC_LAKES);
	}
	
	public static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, String id, T entry) 
    {
        entry.setRegistryName(ModUtil.rL(id));
        registry.register(entry);
        return entry;
    }
}
