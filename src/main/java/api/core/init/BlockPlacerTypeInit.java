package api.core.init;

import library.Init;
import library.ModRegistry;
import library.feature.blockplacer.TriplePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.BlockPlacerType;
import net.minecraftforge.fml.RegistryObject;

@Init
public class BlockPlacerTypeInit extends ModRegistry
{
	public static final RegistryObject<BlockPlacerType<TriplePlantBlockPlacer>> TRIPLE_PLANT_PLACER = BLOCK_PLACER_REGISTRY.register("triple_plant_placer", () -> new BlockPlacerType<>(TriplePlantBlockPlacer.CODEC));
}
