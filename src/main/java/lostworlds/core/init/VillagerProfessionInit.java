package lostworlds.core.init;

import javax.annotation.Nullable;

import lostworlds.common.villager.ModVillagerProfession;
import lostworlds.core.util.ModUtil;
import lostworlds.core.util.registry.ModRegistry;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.fml.RegistryObject;

public class VillagerProfessionInit 
{
	public static final RegistryObject<VillagerProfession> ARCHAEOLOGIST = register("archaeologist", () -> PointsOfInterestInit.ARCHAEOLOGY_TABLE_POI.get(), SoundEvents.VILLAGER_WORK_MASON);

	static RegistryObject<VillagerProfession> register(String id, NonNullSupplier<PointOfInterestType> poi, @Nullable SoundEvent sounds) 
	{
		return ModRegistry.VILLAGER_PROFESSIONS_REGISTRY.register(id, () -> new ModVillagerProfession(id, poi, sounds));
	}
	
	public static void initVillageProfession() { ModUtil.LOGGER.debug("Registering: Mod Villager Professions"); }
}
