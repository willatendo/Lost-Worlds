package lostworlds.world.init;

import java.util.function.Supplier;

import lostworlds.core.util.ModID;
import lostworlds.core.util.registry.ModRegistry;
import lostworlds.world.biome.ModBiomeMaker;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.fml.RegistryObject;

public class BiomeInit 
{
	public static final RegistryObject<Biome> VOLCANO = createBiome("volcano", ModBiomeMaker::makeAVolcanoBiome);
	public static final RegistryKey<Biome> VOLCANO_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModID.ID, "volcano"));
	
	public static final RegistryObject<Biome> PERMIAN_DESERT = createBiome("permian_desert", ModBiomeMaker::makeAPermianDesert);
	public static final RegistryKey<Biome> PERMIAN_DESERT_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModID.ID, "permian_desert"));
	
	public static final RegistryObject<Biome> FLOOD_BASALT_PLAINS = createBiome("flood_basalt_plains", ModBiomeMaker::makeAFloodBasaltPlains);
	public static final RegistryKey<Biome> FLOOD_BASALT_PLAINS_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModID.ID, "flood_basalt_plains"));
	
	public static final RegistryObject<Biome> PERMIAN_PLAINS = createBiome("permian_plains", ModBiomeMaker::makeAPermianPlains);
	public static final RegistryKey<Biome> PERMIAN_PLAINS_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModID.ID, "permian_plains"));
	
	public static final RegistryObject<Biome> PERMIAN_OCEAN = createBiome("permian_ocean", ModBiomeMaker::makeAPermianOcean);
	public static final RegistryKey<Biome> PERMIAN_OCEAN_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModID.ID, "permian_ocean"));

	public static final RegistryObject<Biome> PERMIAN_MOUNTAINS = createBiome("permian_mountains", ModBiomeMaker::makeAPermianMountains);
	public static final RegistryKey<Biome> PERMIAN_MOUNTAINS_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModID.ID, "permian_mountains"));
	
	public static final RegistryObject<Biome> CONIFER_FOREST = createBiome("conifer_forest", ModBiomeMaker::makeAConiferForest);
	public static final RegistryKey<Biome> CONIFER_FOREST_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModID.ID, "conifer_forest"));
	
	public static final RegistryObject<Biome> GINKGO_FOREST = createBiome("ginkgo_forest", ModBiomeMaker::makeAGinkgoForest);
	public static final RegistryKey<Biome> GINKGO_FOREST_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModID.ID, "ginkgo_forest"));
	
	public static final RegistryObject<Biome> PERMIAN_RIVER = createBiome("permian_river", ModBiomeMaker::makeAPermianRiver);
	public static final RegistryKey<Biome> PERMIAN_RIVER_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModID.ID, "permian_river"));
	
	public static final RegistryObject<Biome> JURASSIC_CONIFER_FOREST = createBiome("jurassic_conifer_forest", ModBiomeMaker::makeAJurassicConiferForest);
	public static final RegistryKey<Biome> JURASSIC_CONIFER_FOREST_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModID.ID, "jurassic_conifer_forest"));
	
	public static final RegistryObject<Biome> JURASSIC_GINKGO_FOREST = createBiome("jurassic_ginkgo_forest", ModBiomeMaker::makeAJurassicGinkgoForest);
	public static final RegistryKey<Biome> JURASSIC_GINKGO_FOREST_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModID.ID, "jurassic_ginkgo_forest"));
	
	public static final RegistryObject<Biome> JURASSIC_PLAINS = createBiome("jurassic_plains", ModBiomeMaker::makeAJurassicPlains);
	public static final RegistryKey<Biome> JURASSIC_PLAINS_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModID.ID, "jurassic_plains"));
	
	public static final RegistryObject<Biome> JURASSIC_DESERT = createBiome("jurassic_desert", ModBiomeMaker::makeAJurassicDesert);
	public static final RegistryKey<Biome> JURASSIC_DESERT_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModID.ID, "jurassic_desert"));
	
	public static final RegistryObject<Biome> JURASSIC_MOUNTAINS = createBiome("jurassic_mountains", ModBiomeMaker::makeAJurassicMountains);
	public static final RegistryKey<Biome> JURASSIC_MOUNTAINS_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModID.ID, "jurassic_mountains"));
	
	public static final RegistryObject<Biome> JURASSIC_ERRODED_MOUNTAINS = createBiome("jurassic_erroded_mountains", ModBiomeMaker::makeAErrodedMountains);
	public static final RegistryKey<Biome> JURASSIC_ERRODED_MOUNTAINS_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModID.ID, "jurassic_erroded_mountains"));
	
	public static final RegistryObject<Biome> JURASSIC_RIVER = createBiome("jurassic_river", ModBiomeMaker::makeAJurassicRiver);
	public static final RegistryKey<Biome> JURASSIC_RIVER_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModID.ID, "jurassic_river"));
	
	public static final RegistryObject<Biome> JURASSIC_ISLANDS = createBiome("jurassic_islands", ModBiomeMaker::makeAJurassicRiver);
	public static final RegistryKey<Biome> JURASSIC_ISLANDS_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModID.ID, "jurassic_islands"));
	
	public static final RegistryObject<Biome> JURASSIC_OCEAN = createBiome("jurassic_ocean", ModBiomeMaker::makeAJurassicRiver);
	public static final RegistryKey<Biome> JURASSIC_OCEAN_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModID.ID, "jurassic_ocean"));
	
	//Registry
    public static RegistryObject<Biome> createBiome(String name, Supplier<Biome> biome) 
    {
        return ModRegistry.BIOME_REGISTRY.register(name, biome);
    }
    
    public static void initBiomes() { }
    
    //Generation
    public static void addBiomesToOverworld(BiomeLoadingEvent event)
    {
    	if (event.getName().equals(VOLCANO.get().getRegistryName())) 
    	{
    		BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(VOLCANO_KEY, 1));
    		BiomeDictionary.addTypes(VOLCANO_KEY, Type.HOT, Type.MOUNTAIN, Type.RARE);
    	}
    }
}
