package library.dimension.permian;

import java.util.function.LongFunction;

import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.gen.layer.LayerUtil;
import net.minecraft.world.gen.layer.SmoothLayer;
import net.minecraft.world.gen.layer.ZoomLayer;

public class PermianLayerUtil 
{
	private static final Int2IntMap CATEGORIES = Util.make(new Int2IntOpenHashMap(), (p_242938_0_) -> 
	{
		register(p_242938_0_, PermianLayerUtil.Type.BEACH, 16);
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

		biomes = LayerUtil.zoom(1000L, ZoomLayer.NORMAL, biomes, 1, contextFactory);

		IAreaFactory<T> riverLayer = PermianRiverLayer.INSTANCE.run(contextFactory.apply(1L), biomes);
		riverLayer = SmoothLayer.INSTANCE.run(contextFactory.apply(7000L), riverLayer);
		biomes = PermianRiverMixLayer.INSTANCE.run(contextFactory.apply(100L), biomes, riverLayer);

		return biomes;
	}

	public static Layer makeLayers(long seed, Registry<Biome> registry) 
	{
		biomeRegistry = registry;
		IAreaFactory<LazyArea> areaFactory = makeLayers((contextSeed) -> new LazyAreaLayerContext(25, seed, contextSeed), registry);
		return new Layer(areaFactory);
	}

	public static boolean isSame(int p_202826_0_, int p_202826_1_) 
	{
		if(p_202826_0_ == p_202826_1_) 
		{
			return true;
		} 
		else 
		{
			return CATEGORIES.get(p_202826_0_) == CATEGORIES.get(p_202826_1_);
		}
	}

	private static void register(Int2IntOpenHashMap p_242939_0_, PermianLayerUtil.Type p_242939_1_, int p_242939_2_) 
	{
		p_242939_0_.put(p_242939_2_, p_242939_1_.ordinal());
	}

	static enum Type 
	{
		NONE,
		TAIGA,
		EXTREME_HILLS, 
		JUNGLE, 
		MESA, 
		BADLANDS_PLATEAU, 
		PLAINS, 
		SAVANNA, 
		ICY, 
		BEACH, 
		FOREST, 
		OCEAN, 
		DESERT,
		RIVER, 
		SWAMP, 
		MUSHROOM;
	}
}