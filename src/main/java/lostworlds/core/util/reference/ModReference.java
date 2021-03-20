package lostworlds.core.util.reference;

import net.minecraft.util.ResourceLocation;

public class ModReference
{
	public static final String ID = "lostworlds";
	
	//Demensions
	
	//Ceanozoic
	public static final ResourceLocation PLEISTOCENE = new ResourceLocation(ID, "pleistocene_time_era");
	
	//Mesozoic
	public static final ResourceLocation CRETACOUS = new ResourceLocation(ID, "cretacous_time_era");
	public static final ResourceLocation JURASSIC = new ResourceLocation(ID, "jurassic_time_era");
	public static final ResourceLocation TRIASSIC = new ResourceLocation(ID, "triassic_time_era");
	
	//Palaeozoic
	public static final ResourceLocation PERMIAN = new ResourceLocation(ID, "permian_time_era");
	public static final String PERMIAN_ID = "permian_id";
	public static final ResourceLocation CARBONIFEROUS = new ResourceLocation(ID, "carboniferous_time_era");	
	public static final ResourceLocation DEVONIAN = new ResourceLocation(ID, "devonian_time_era");		
	public static final ResourceLocation SILURIAN = new ResourceLocation(ID, "carboniferous_time_era");	
	public static final ResourceLocation ORDOVICIAN = new ResourceLocation(ID, "ordovician_time_era");	
	public static final ResourceLocation CAMBRIAN = new ResourceLocation(ID, "cambrian_time_era");
	
	//Precambrian
	public static final ResourceLocation FROZEN_PRECAMBRIAN = new ResourceLocation(ID, "frozen_precambrian_time_era");
	public static final ResourceLocation PRECAMBRIAN = new ResourceLocation(ID, "precambrian_time_era");
}
