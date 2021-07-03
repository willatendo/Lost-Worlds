package lostworlds.library.dimension.permian;

import java.util.function.LongFunction;

import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import lostworlds.library.dimension.ModBiomeTypes;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.HillsLayer;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.gen.layer.LayerUtil;
import net.minecraft.world.gen.layer.ZoomLayer;

public class PermianLayerUtil 
{
	private static final Int2IntMap CATEGORIES = Util.make(new Int2IntOpenHashMap(), (map) -> 
	{
		register(map, ModBiomeTypes.DESERT, 1);
		register(map, ModBiomeTypes.DESERT, 2);
	});
	
	private static Registry<Biome> biomeRegistry;
	
	static int getBiomeId(RegistryKey<Biome> define) 
	{
		Biome biome = biomeRegistry.get(define);
		return biomeRegistry.getId(biome);
	}
	
	public static <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> makeLayers(LongFunction<C> contextFactory, Registry<Biome> registry) 
	{
		biomeRegistry = registry;

		IAreaFactory<T> biomes = new PermianBiomeLayer().run(contextFactory.apply(1L));

		biomes = ZoomLayer.NORMAL.run(contextFactory.apply(1000), biomes);
		biomes = ZoomLayer.NORMAL.run(contextFactory.apply(1001), biomes);
		biomes = ZoomLayer.NORMAL.run(contextFactory.apply(1002), biomes);
		biomes = ZoomLayer.NORMAL.run(contextFactory.apply(1003), biomes);
		biomes = ZoomLayer.NORMAL.run(contextFactory.apply(1004), biomes);
		biomes = ZoomLayer.NORMAL.run(contextFactory.apply(1005), biomes);
		biomes = HillsLayer.INSTANCE.run(contextFactory.apply(1000L), biomes, biomes);

		biomes = LayerUtil.zoom(1000L, ZoomLayer.NORMAL, biomes, 1, contextFactory);

		//IAreaFactory<T> riverLayer = PermianRiverLayer.INSTANCE.run(contextFactory.apply(1L), biomes);
		//riverLayer = SmoothLayer.INSTANCE.run(contextFactory.apply(7000L), riverLayer);
		//biomes = PermianRiverMixLayer.INSTANCE.run(contextFactory.apply(100L), biomes, riverLayer);

		return biomes;
	}

	public static Layer makeLayers(long seed, Registry<Biome> registry) 
	{
		biomeRegistry = registry;
		IAreaFactory<LazyArea> areaFactory = makeLayers((contextSeed) -> new LazyAreaLayerContext(25, seed, contextSeed), registry);
		return new Layer(areaFactory);
	}
	
	public static boolean isSame(int biome1, int biome2) 
	{
		if(biome1 == biome2) 
		{
			return true;
		} 
		else 
		{
			return CATEGORIES.get(biome1) == CATEGORIES.get(biome2);
		}
	}
	
	protected static boolean isOcean(int biomeNumberId) 
	{
		return biomeNumberId == 44 || biomeNumberId == 45 || biomeNumberId == 0 || biomeNumberId == 46 || biomeNumberId == 10 || biomeNumberId == 47 || biomeNumberId == 48 || biomeNumberId == 24 || biomeNumberId == 49 || biomeNumberId == 50;
	}
	
	protected static boolean isShallowOcean(int biomeNumberId) 
	{
		return biomeNumberId == 44 || biomeNumberId == 45 || biomeNumberId == 0 || biomeNumberId == 46 || biomeNumberId == 10;
	}
	
	private static void register(Int2IntOpenHashMap map, ModBiomeTypes type, int biomeNumberId) 
	{
		map.put(biomeNumberId, type.ordinal());
	}
}
