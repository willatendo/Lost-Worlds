package lostworlds.core.init;

import lostworlds.core.util.ModUtil;
import lostworlds.core.util.registry.ModRegistry;
import lostworlds.world.feature.blockplacer.TriplePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.BlockPlacerType;
import net.minecraftforge.fml.RegistryObject;

public class BlockPlacerTypeInit 
{
	public static final RegistryObject<BlockPlacerType<TriplePlantBlockPlacer>> TRIPLE_PLANT_PLACER = ModRegistry.BLOCK_PLACER_REGISTRY.register("triple_plant_placer", () -> new BlockPlacerType<>(TriplePlantBlockPlacer.CODEC));
	
	//Registry
	public static void initBlockPlacerTypes() { ModUtil.LOGGER.debug("Registering: Mod Block Placer Types"); }
}
