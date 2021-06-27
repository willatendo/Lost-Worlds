package api.core.init;

import javax.annotation.Nullable;

import library.Init;
import library.ModRegistry;
import library.villagers.ModVillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.fml.RegistryObject;

@Init	
public class VillagerProfessionInit extends ModRegistry
{
	public static final RegistryObject<VillagerProfession> ARCHAEOLOGIST = register("archaeologist", () -> PointsOfInterestInit.ARCHAEOLOGY_TABLE_POI.get(), SoundEvents.VILLAGER_WORK_MASON);

	static RegistryObject<VillagerProfession> register(String id, NonNullSupplier<PointOfInterestType> poi, @Nullable SoundEvent sounds) 
	{
		return VILLAGER_PROFESSIONS_REGISTRY.register(id, () -> new ModVillagerProfession(id, poi, sounds));
	}
}
