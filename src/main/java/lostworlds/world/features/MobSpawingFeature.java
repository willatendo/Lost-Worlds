package lostworlds.world.features;

import lostworlds.core.init.EntityInit;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class MobSpawingFeature 
{
	public static void addFeatures(BiomeLoadingEvent event)
	{
		if (event.getCategory() != Category.NETHER && event.getCategory() != Category.THEEND && event.getCategory() != Category.NONE)
		{
			if (event.getCategory() == Category.OCEAN)
			{
				event.getSpawns().withSpawner(EntityClassification.WATER_CREATURE, new MobSpawnInfo.Spawners(EntityInit.NAUTILUS_ENTITY.get(), 1, 1, 1));
			}
		}
	}
}
