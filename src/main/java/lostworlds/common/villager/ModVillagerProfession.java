package lostworlds.common.villager;

import com.google.common.collect.ImmutableSet;

import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.util.SoundEvent;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.common.util.NonNullSupplier;

public class ModVillagerProfession extends VillagerProfession
{
	private final Lazy<PointOfInterestType> pointOfInterestTypeSupplier;

	public ModVillagerProfession(String id, final NonNullSupplier<PointOfInterestType> poi, SoundEvent sound) 
	{
		super(id, null, ImmutableSet.of(), ImmutableSet.of(), sound);
		this.pointOfInterestTypeSupplier = Lazy.of(poi::get);
	}
	
	@Override
	public PointOfInterestType getJobPoiType() 
	{
		return this.pointOfInterestTypeSupplier.get();
	}
}
