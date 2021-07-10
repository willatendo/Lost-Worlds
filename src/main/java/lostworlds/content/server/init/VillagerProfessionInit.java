package lostworlds.content.server.init;

import lostworlds.library.util.ModRegistry;
import lostworlds.library.util.ModUtil;
import lostworlds.library.villager.ModVillagerProfession;
import net.minecraft.util.SoundEvents;

/*
 * Author: Willatendo
 * Date: July 8, 2021
 */

public class VillagerProfessionInit 
{
	public static final ModVillagerProfession ARCHAEOLOGIST = ModRegistry.register("archaeologist", new ModVillagerProfession("archaeologist", () -> PointOfInterestInit.ARCHAEOLOGY_TABLE_POI, SoundEvents.VILLAGER_WORK_MASON));
	
	//Registry
	public static void init() { ModUtil.LOGGER.debug("Registering Mod Villager Professions"); }
}
