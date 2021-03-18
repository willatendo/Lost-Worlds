package lostworlds.core.util.reference;

import net.minecraft.util.ResourceLocation;

public class Reference 
{
	public static final String ID = "lostworlds";
	
	//Demensions
	
	//Ceanozoic
	public static final ResourceLocation PLEISTOCENE = new ResourceLocation(Reference.ID, "pleistocene_time_era");
	
	//Mesozoic
	public static final ResourceLocation CRETACOUS = new ResourceLocation(ID, "cretacous_time_era");
	public static final ResourceLocation JURASSIC = new ResourceLocation(Reference.ID, "jurassic_time_era");
	public static final ResourceLocation TRIASSIC = new ResourceLocation(Reference.ID, "triassic_time_era");
	
	//Palaeozoic
	public static final ResourceLocation PERMIAN = new ResourceLocation(Reference.ID, "permian_time_era");
	public static final String PERMIAN_ID = "permian_id";
	public static final ResourceLocation CARBONIFEROUS = new ResourceLocation(Reference.ID, "carboniferous_time_era");	
	public static final ResourceLocation DEVONIAN = new ResourceLocation(Reference.ID, "devonian_time_era");		
	public static final ResourceLocation SILURIAN = new ResourceLocation(Reference.ID, "carboniferous_time_era");	
	public static final ResourceLocation ORDOVICIAN = new ResourceLocation(Reference.ID, "ordovician_time_era");	
	public static final ResourceLocation CAMBRIAN = new ResourceLocation(Reference.ID, "cambrian_time_era");
	
	//Precambrian
	public static final ResourceLocation FROZEN_PRECAMBRIAN = new ResourceLocation(Reference.ID, "frozen_precambrian_time_era");
	public static final ResourceLocation PRECAMBRIAN = new ResourceLocation(Reference.ID, "precambrian_time_era");
}
