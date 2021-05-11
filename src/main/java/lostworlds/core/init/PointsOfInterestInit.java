package lostworlds.core.init;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import lostworlds.core.util.registry.ModRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.fml.RegistryObject;

public class PointsOfInterestInit 
{
	public static Set<BlockState> getBlockStates(Block block) 
	{
		return ImmutableSet.copyOf(block.getStateDefinition().getPossibleStates());
	}
	
	public static final RegistryObject<PointOfInterestType> ARCHAEOLOGY_TABLE_POI = ModRegistry.POINTS_OF_INTEREST_REGISTRY.register("archaeology_table_poi", () -> new PointOfInterestType("archaeology_table_poi", getBlockStates(BlockInit.ARCHAEOLOGY_TABLE.get()), 1, 1));
	
	//Registry
	public static void initPointsOfInterest() { }
}
