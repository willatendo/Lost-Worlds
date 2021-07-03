package lostworlds.content.server.init;

import lostworlds.library.util.ModRegistry;
import lostworlds.library.villager.ModVillagerProfession;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fml.RegistryObject;

public class VillagerProfessionInit 
{
	public static final RegistryObject<ModVillagerProfession> ARCHAEOLOGIST = ModRegistry.register("archaeologist", () -> PointOfInterestInit.ARCHAEOLOGY_TABLE_POI.get(), SoundEvents.VILLAGER_WORK_MASON);
	
	//Registry
	public static void init() { }
}
