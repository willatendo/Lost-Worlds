package lostworlds.world.dimension.jurassic;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import lostworlds.world.init.BiomeInit;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeRegistry;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.layer.Layer;

public class JurassicBiomeProvider extends BiomeProvider
{
	public static final Codec<JurassicBiomeProvider> CODEC = RecordCodecBuilder.create((instance) -> instance.group(Codec.LONG.fieldOf("seed").orElse(JurassicChunkGenerator.hackSeed).forGetter((obj) -> obj.seed), RegistryLookupCodec.create(Registry.BIOME_REGISTRY).forGetter((obj) -> obj.registry)).apply(instance, instance.stable(JurassicBiomeProvider::new)));

	private final long seed;
    private final Registry<Biome> registry;
    private final Layer genBiomes;
    private static final List<RegistryKey<Biome>> BIOMES = ImmutableList.of(BiomeInit.JURASSIC_CONIFER_FOREST_KEY, BiomeInit.JURASSIC_CONIFER_FOREST_HILLS_KEY, BiomeInit.JURASSIC_GINKGO_FOREST_KEY, BiomeInit.JURASSIC_GINKGO_FOREST_HILLS_KEY, BiomeInit.JURASSIC_PLAINS_KEY, BiomeInit.JURASSIC_PLAINS_HILLS_KEY, BiomeInit.JURASSIC_ISLANDS_KEY, BiomeInit.JURASSIC_OCEAN_KEY, BiomeInit.JURASSIC_MOUNTAINS_KEY, BiomeInit.JURASSIC_DESERT_KEY, BiomeInit.JURASSIC_DESERT_HILLS_KEY, BiomeInit.JURASSIC_ERRODED_MOUNTAINS_KEY, BiomeInit.JURASSIC_ARAUCARIA_FOREST_KEY, BiomeInit.JURASSIC_ARAUCARIA_FOREST_HILLS_KEY);
    
    public JurassicBiomeProvider(long seed, Registry<Biome> registry) 
    {    	
        super(BIOMES.stream().map(define -> () -> registry.getOrThrow(define)));
        this.seed = seed;
        this.registry = registry;
        this.genBiomes = JurassicLayerUtil.makeLayers(seed, registry);
    }

    @Override
    public BiomeProvider withSeed(long s) 
    {
        return new JurassicBiomeProvider(s, registry);
    }
    
    @Override
    protected Codec<? extends BiomeProvider> codec() 
    {
    	return CODEC;
    }
    
    @Override
    public Biome getNoiseBiome(int x, int y, int z) 
    {
        return this.getBiomeFromPos(registry, x, z);
    }

    public Biome getBiomeFromPos(Registry<Biome> registry, int x, int z) 
    {
        int i = genBiomes.area.get(x, z);
        Biome biome = registry.byId(i);
        if(biome == null) 
        {
            if (SharedConstants.IS_RUNNING_IN_IDE) 
            {
                throw Util.pauseInIde(new IllegalStateException("Unknown biome id: " + i));
            } 
            else 
            {
                return registry.get(BiomeRegistry.byId(0));
            }
        } 
        else 
        {
            return biome;
        }
    }

}
