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
