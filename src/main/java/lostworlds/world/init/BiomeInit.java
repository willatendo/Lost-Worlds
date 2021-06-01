package lostworlds.world.init;

import java.util.function.Supplier;

import lostworlds.LostWorldsConfig;
import lostworlds.core.util.ModUtil;
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
	public static final RegistryObject<Biome> PERMIAN_DESERT = createBiome("permian_desert", ModBiomeMaker::makeAPermianDesert);
	public static final RegistryKey<Biome> PERMIAN_DESERT_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "permian_desert"));
	
	public static final RegistryObject<Biome> PERMIAN_DESERT_HILLS = createBiome("permian_desert_hills", ModBiomeMaker::makeAPermianDesertHills);
	public static final RegistryKey<Biome> PERMIAN_DESERT_HILLS_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "permian_desert_hills"));
	
	public static final RegistryObject<Biome> FLOOD_BASALT_PLAINS = createBiome("permian_flood_basalt_plains", ModBiomeMaker::makeAPermainFloodBasaltPlains);
	public static final RegistryKey<Biome> FLOOD_BASALT_PLAINS_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "permian_flood_basalt_plains"));
	
	public static final RegistryObject<Biome> PERMIAN_PLAINS = createBiome("permian_plains", ModBiomeMaker::makeAPermianPlains);
	public static final RegistryKey<Biome> PERMIAN_PLAINS_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "permian_plains"));
	
	public static final RegistryObject<Biome> PERMIAN_PLAINS_HILLS = createBiome("permian_plains_hills", ModBiomeMaker::makeAPermianPlainsHills);
	public static final RegistryKey<Biome> PERMIAN_PLAINS_HILLS_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "permian_plains_hills"));
	
	public static final RegistryObject<Biome> PERMIAN_OCEAN = createBiome("permian_ocean", ModBiomeMaker::makeAPermianOcean);
	public static final RegistryKey<Biome> PERMIAN_OCEAN_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "permian_ocean"));

	public static final RegistryObject<Biome> PERMIAN_MOUNTAINS = createBiome("permian_mountains", ModBiomeMaker::makeAPermianMountains);
	public static final RegistryKey<Biome> PERMIAN_MOUNTAINS_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "permian_mountains"));
	
	public static final RegistryObject<Biome> PERMIAN_CONIFER_FOREST = createBiome("permian_conifer_forest", ModBiomeMaker::makeAPermianConiferForest);
	public static final RegistryKey<Biome> PERMIAN_CONIFER_FOREST_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "permian_conifer_forest"));
	
	public static final RegistryObject<Biome> PERMIAN_CONIFER_FOREST_HILLS = createBiome("permian_conifer_forest_hills", ModBiomeMaker::makeAPermianConiferForestHills);
	public static final RegistryKey<Biome> PERMIAN_CONIFER_FOREST_HILLS_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "permian_conifer_forest_hills"));
	
	public static final RegistryObject<Biome> PERMIAN_GINKGO_FOREST = createBiome("permian_ginkgo_forest", ModBiomeMaker::makeAPermianGinkgoForest);
	public static final RegistryKey<Biome> PERMIAN_GINKGO_FOREST_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "permian_ginkgo_forest"));
	
	public static final RegistryObject<Biome> PERMIAN_GINKGO_FOREST_HILLS = createBiome("permian_ginkgo_forest_hills", ModBiomeMaker::makeAPermianGinkgoForestHills);
	public static final RegistryKey<Biome> PERMIAN_GINKGO_FOREST_HILLS_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "permian_ginkgo_forest_hills"));
	
	public static final RegistryObject<Biome> PERMIAN_RIVER = createBiome("permian_river", ModBiomeMaker::makeAPermianRiver);
	public static final RegistryKey<Biome> PERMIAN_RIVER_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "permian_river"));
	
	public static final RegistryObject<Biome> JURASSIC_CONIFER_FOREST = createBiome("jurassic_conifer_forest", ModBiomeMaker::makeAJurassicConiferForest);
	public static final RegistryKey<Biome> JURASSIC_CONIFER_FOREST_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "jurassic_conifer_forest"));
	
	public static final RegistryObject<Biome> JURASSIC_CONIFER_FOREST_HILLS = createBiome("jurassic_conifer_forest_hills", ModBiomeMaker::makeAJurassicConiferForestHills);
	public static final RegistryKey<Biome> JURASSIC_CONIFER_FOREST_HILLS_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "jurassic_conifer_forest_hills"));
	
	public static final RegistryObject<Biome> JURASSIC_GINKGO_FOREST = createBiome("jurassic_ginkgo_forest", ModBiomeMaker::makeAJurassicGinkgoForest);
	public static final RegistryKey<Biome> JURASSIC_GINKGO_FOREST_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "jurassic_ginkgo_forest"));
	
	public static final RegistryObject<Biome> JURASSIC_GINKGO_FOREST_HILLS = createBiome("jurassic_ginkgo_forest_hills", ModBiomeMaker::makeAJurassicGinkgoForestHills);
	public static final RegistryKey<Biome> JURASSIC_GINKGO_FOREST_HILLS_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "jurassic_ginkgo_forest_hills"));
	
	public static final RegistryObject<Biome> JURASSIC_ARAUCARIA_FOREST = createBiome("jurassic_araucaria_forest", ModBiomeMaker::makeAJurassicAraucariaForest);
	public static final RegistryKey<Biome> JURASSIC_ARAUCARIA_FOREST_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "jurassic_araucaria_forest"));
	
	public static final RegistryObject<Biome> JURASSIC_ARAUCARIA_FOREST_HILLS = createBiome("jurassic_araucaria_forest_hills", ModBiomeMaker::makeAJurassicAraucariaForestHills);
	public static final RegistryKey<Biome> JURASSIC_ARAUCARIA_FOREST_HILLS_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "jurassic_araucaria_forest_hills"));
	
	public static final RegistryObject<Biome> JURASSIC_PLAINS = createBiome("jurassic_plains", ModBiomeMaker::makeAJurassicPlains);
	public static final RegistryKey<Biome> JURASSIC_PLAINS_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "jurassic_plains"));
	
	public static final RegistryObject<Biome> JURASSIC_PLAINS_HILLS = createBiome("jurassic_plains_hills", ModBiomeMaker::makeAJurassicPlainsHills);
	public static final RegistryKey<Biome> JURASSIC_PLAINS_HILLS_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "jurassic_plains_hills"));
	
	public static final RegistryObject<Biome> JURASSIC_DESERT = createBiome("jurassic_desert", ModBiomeMaker::makeAJurassicDesert);
	public static final RegistryKey<Biome> JURASSIC_DESERT_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "jurassic_desert"));
	
	public static final RegistryObject<Biome> JURASSIC_DESERT_HILLS = createBiome("jurassic_desert_hills", ModBiomeMaker::makeAJurassicDesertHills);
	public static final RegistryKey<Biome> JURASSIC_DESERT_HILLS_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "jurassic_desert_hills"));
	
	public static final RegistryObject<Biome> JURASSIC_MOUNTAINS = createBiome("jurassic_mountains", ModBiomeMaker::makeAJurassicMountains);
	public static final RegistryKey<Biome> JURASSIC_MOUNTAINS_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "jurassic_mountains"));
	
	public static final RegistryObject<Biome> JURASSIC_ERRODED_MOUNTAINS = createBiome("jurassic_erroded_mountains", ModBiomeMaker::makeAErrodedMountains);
	public static final RegistryKey<Biome> JURASSIC_ERRODED_MOUNTAINS_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "jurassic_erroded_mountains"));
	
	public static final RegistryObject<Biome> JURASSIC_RIVER = createBiome("jurassic_river", ModBiomeMaker::makeAJurassicRiver);
	public static final RegistryKey<Biome> JURASSIC_RIVER_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "jurassic_river"));
	
	public static final RegistryObject<Biome> JURASSIC_ISLANDS = createBiome("jurassic_islands", ModBiomeMaker::makeAJurassicIslands);
	public static final RegistryKey<Biome> JURASSIC_ISLANDS_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "jurassic_islands"));
	
	public static final RegistryObject<Biome> JURASSIC_OCEAN = createBiome("jurassic_ocean", ModBiomeMaker::makeAJurassicOcean);
	public static final RegistryKey<Biome> JURASSIC_OCEAN_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "jurassic_ocean"));
	
	public static final RegistryObject<Biome> OVERWORLD_CONIFER_FOREST = createBiome("overworld_conifer_forest", ModBiomeMaker::makeAOverworldConiferForest);
	public static final RegistryKey<Biome> OVERWORLD_CONIFER_FOREST_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "overworld_conifer_forest"));
	
	public static final RegistryObject<Biome> OVERWORLD_CONIFER_FOREST_HILLS = createBiome("overworld_conifer_forest_hills", ModBiomeMaker::makeAOverworldConiferForestHills);
	public static final RegistryKey<Biome> OVERWORLD_CONIFER_FOREST_HILLS_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "overworld_conifer_forest_hills"));
	
	public static final RegistryObject<Biome> OVERWORLD_GINKGO_FOREST = createBiome("overworld_ginkgo_forest", ModBiomeMaker::makeAOverworldGinkgoForest);
	public static final RegistryKey<Biome> OVERWORLD_GINKGO_FOREST_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "overworld_ginkgo_forest"));
	
	public static final RegistryObject<Biome> OVERWORLD_GINKGO_FOREST_HILLS = createBiome("overworld_ginkgo_forest_hills", ModBiomeMaker::makeAOverworldGinkgoForestHills);
	public static final RegistryKey<Biome> OVERWORLD_GINKGO_FOREST_HILLS_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "overworld_ginkgo_forest_hills"));
	
	public static final RegistryObject<Biome> OVERWORLD_ARAUCARIA_FOREST = createBiome("overworld_araucaria_forest", ModBiomeMaker::makeAOverworldAraucariaForest);
	public static final RegistryKey<Biome> OVERWORLD_ARAUCARIA_FOREST_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "overworld_araucaria_forest"));

	public static final RegistryObject<Biome> OVERWORLD_ARAUCARIA_FOREST_HILLS = createBiome("overworld_araucaria_forest_hills", ModBiomeMaker::makeAOverworldAraucariaForestHills);
	public static final RegistryKey<Biome> OVERWORLD_ARAUCARIA_FOREST_HILLS_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "overworld_araucaria_forest_hills"));
	
	public static final RegistryObject<Biome> VOLCANO = createBiome("volcano", ModBiomeMaker::makeAVolcanoBiome);
	public static final RegistryKey<Biome> VOLCANO_KEY = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModUtil.ID, "volcano"));
	
	//Registry
    public static RegistryObject<Biome> createBiome(String name, Supplier<Biome> biome) 
    {
        return ModRegistry.BIOME_REGISTRY.register(name, biome);
    }
    
    public static void initBiomes() { ModUtil.LOGGER.debug("Registering: Mod Biomes"); }
    
    //Generation
    public static void addBiomesToOverworld(BiomeLoadingEvent event)
    {
    	if(LostWorldsConfig.COMMON.shouldForestsSpawnInOverworld.get())
    	{
    		if(event.getName().equals(OVERWORLD_CONIFER_FOREST.get().getRegistryName())) 
        	{
        		BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(OVERWORLD_CONIFER_FOREST_KEY, LostWorldsConfig.COMMON.coniferWeight.get()));
        		BiomeDictionary.addTypes(OVERWORLD_CONIFER_FOREST_KEY, Type.FOREST, Type.CONIFEROUS);
        	}
        	
        	if(event.getName().equals(OVERWORLD_CONIFER_FOREST_HILLS.get().getRegistryName())) 
        	{
        		BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(OVERWORLD_CONIFER_FOREST_HILLS_KEY, LostWorldsConfig.COMMON.coniferWeight.get()));
        		BiomeDictionary.addTypes(OVERWORLD_CONIFER_FOREST_HILLS_KEY, Type.FOREST, Type.CONIFEROUS, Type.HILLS);
        	}
        	
        	if(event.getName().equals(OVERWORLD_GINKGO_FOREST.get().getRegistryName())) 
        	{
        		BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(OVERWORLD_GINKGO_FOREST_KEY, LostWorldsConfig.COMMON.ginkgoWeight.get()));
        		BiomeDictionary.addTypes(OVERWORLD_GINKGO_FOREST_KEY, Type.FOREST);
        	}
        	
        	if(event.getName().equals(OVERWORLD_GINKGO_FOREST_HILLS.get().getRegistryName())) 
        	{
        		BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(OVERWORLD_GINKGO_FOREST_HILLS_KEY, LostWorldsConfig.COMMON.ginkgoWeight.get()));
        		BiomeDictionary.addTypes(OVERWORLD_GINKGO_FOREST_HILLS_KEY, Type.FOREST, Type.HILLS);
        	}
        	
        	if(event.getName().equals(OVERWORLD_ARAUCARIA_FOREST.get().getRegistryName())) 
        	{
        		BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(OVERWORLD_ARAUCARIA_FOREST_KEY, LostWorldsConfig.COMMON.araucariaWeight.get()));
        		BiomeDictionary.addTypes(OVERWORLD_ARAUCARIA_FOREST_KEY, Type.FOREST);
        	}
        	
        	if(event.getName().equals(OVERWORLD_ARAUCARIA_FOREST_HILLS.get().getRegistryName())) 
        	{
        		BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(OVERWORLD_ARAUCARIA_FOREST_HILLS_KEY, LostWorldsConfig.COMMON.araucariaWeight.get()));
        		BiomeDictionary.addTypes(OVERWORLD_ARAUCARIA_FOREST_HILLS_KEY, Type.FOREST, Type.HILLS);
        	}
    	}
    	
    	if(LostWorldsConfig.COMMON.shouldVolcanoSpawnInOverworld.get())
    	{
    		if(event.getName().equals(VOLCANO.get().getRegistryName())) 
    		{
    			BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(VOLCANO_KEY, 1));
    			BiomeDictionary.addTypes(VOLCANO_KEY, Type.HOT, Type.MOUNTAIN, Type.RARE);
    		}
    	}
    }
}
