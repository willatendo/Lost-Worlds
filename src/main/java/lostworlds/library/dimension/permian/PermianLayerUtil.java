package lostworlds.library.dimension.permian;

import java.util.function.LongFunction;

import lostworlds.library.dimension.permian.layer.AddPermianIslandLayer;
import lostworlds.library.dimension.permian.layer.PermianDeepOceanLayer;
import lostworlds.library.dimension.permian.layer.PermianEdgeLayer;
import lostworlds.library.dimension.permian.layer.PermianHillLayer;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.AddIslandLayer;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.gen.layer.LayerUtil;
import net.minecraft.world.gen.layer.ShoreLayer;
import net.minecraft.world.gen.layer.ZoomLayer;

public class PermianLayerUtil 
{
	private static Registry<Biome> biomeRegistry;
	
	public static int getBiomeId(RegistryKey<Biome> define) 
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
		biomes = PermianHillLayer.INSTANCE.run(contextFactory.apply(1000L), biomes, biomes);
		biomes = PermianEdgeLayer.INSTANCE.run(contextFactory.apply(1000L), biomes);
		biomes = AddPermianIslandLayer.INSTANCE.run(contextFactory.apply(2L), biomes);
		biomes = AddPermianIslandLayer.INSTANCE.run(contextFactory.apply(50L), biomes);
		biomes = AddPermianIslandLayer.INSTANCE.run(contextFactory.apply(70L), biomes);
		biomes = AddPermianIslandLayer.INSTANCE.run(contextFactory.apply(3L), biomes);
		biomes = AddPermianIslandLayer.INSTANCE.run(contextFactory.apply(4L), biomes);
		biomes = PermianDeepOceanLayer.INSTANCE.run(contextFactory.apply(4L), biomes);
		
		for(int i = 0; i < 4; ++i) 
		{
			biomes = ZoomLayer.NORMAL.run(contextFactory.apply((long)(1000 + i)), biomes);
			if(i == 0) 
			{
				biomes = AddIslandLayer.INSTANCE.run(contextFactory.apply(3L), biomes);
			}
			
			if (i == 1) 
			{
				biomes = ShoreLayer.INSTANCE.run(contextFactory.apply(1000L), biomes);
			}
		}
		
		biomes = LayerUtil.zoom(1000L, ZoomLayer.NORMAL, biomes, 1, contextFactory);
		
		//IAreaFactory<T> riverLayer = PermianRiverLayer.INSTANCE.run(contextFactory.apply(1L), biomes);
		//riverLayer = SmoothLayer.INSTANCE.run(contextFactory.apply(7000L), riverLayer);
		//biomes = PermianRiverMixLayer.INSTANCE.run(contextFactory.apply(100L), biomes, riverLayer);

		return biomes;
	}
	
	public static boolean isSame(int biomeSeed1, int biomeSeed2) 
	{
		if(biomeSeed1 == biomeSeed2)
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}
	
	public static boolean isOcean(int biomeSeed) 
	{
		return biomeSeed == 44 || biomeSeed == 45 || biomeSeed == 0 || biomeSeed == 46 || biomeSeed == 10 || biomeSeed == 47 || biomeSeed == 48 || biomeSeed == 24 || biomeSeed == 49 || biomeSeed == 50;
	}
	
	public static boolean isShallowOcean(int biomeSeed) 
	{
		return biomeSeed == 44 || biomeSeed == 45 || biomeSeed == 0 || biomeSeed == 46 || biomeSeed == 10;
	}

	public static Layer makeLayers(long seed, Registry<Biome> registry) 
	{
		biomeRegistry = registry;
		IAreaFactory<LazyArea> areaFactory = makeLayers((contextSeed) -> new LazyAreaLayerContext(25, seed, contextSeed), registry);
		return new Layer(areaFactory);
	}
}
