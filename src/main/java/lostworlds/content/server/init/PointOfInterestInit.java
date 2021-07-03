package lostworlds.content.server.init;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import lostworlds.library.util.ModRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.fml.RegistryObject;

public class PointOfInterestInit 
{
	public static Set<BlockState> getBlockStates(Block block) 
	{
		return ImmutableSet.copyOf(block.getStateDefinition().getPossibleStates());
	}
	
	public static final RegistryObject<PointOfInterestType> ARCHAEOLOGY_TABLE_POI = ModRegistry.register("archaeology_table_poi", getBlockStates(BlockInit.ARCHAEOLOGY_TABLE));
	
	//Registry
	public static void init() { }
}
