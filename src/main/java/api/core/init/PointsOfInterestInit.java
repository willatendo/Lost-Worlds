package api.core.init;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import library.Init;
import library.ModRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.fml.RegistryObject;

@Init
public class PointsOfInterestInit extends ModRegistry
{
	public static Set<BlockState> getBlockStates(Block block) 
	{
		return ImmutableSet.copyOf(block.getStateDefinition().getPossibleStates());
	}
	
	public static final RegistryObject<PointOfInterestType> ARCHAEOLOGY_TABLE_POI = ModRegistry.POINTS_OF_INTEREST_REGISTRY.register("archaeology_table_poi", () -> new PointOfInterestType("archaeology_table_poi", getBlockStates(BlockInit.ARCHAEOLOGY_TABLE.get()), 1, 1));
}
