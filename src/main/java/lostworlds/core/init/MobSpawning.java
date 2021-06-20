package lostworlds.core.init;

import lostworlds.core.util.ModUtil;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ModUtil.ID)
public class MobSpawning 
{
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void addSpawn(BiomeLoadingEvent event) 
	{
		/*Biome biome = ForgeRegistries.BIOMES.getValue(event.getName());
		if(LostWorldsConfig.COMMON.shouldDinosaurSpawnInOverworld.get()) 
		{
			if(biome.getBiomeCategory() == Biome.Category.PLAINS)
			{
				event.getSpawns().addSpawn(EntityClassification.CREATURE, new Spawners(EntityInit.TYRANNOSAURUS_ENTITY.get(), 2, 1, 1));
			}
		}*/
	}
}
