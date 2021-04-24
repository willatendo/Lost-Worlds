package lostworlds.world.init;

import lostworlds.core.util.registry.ModRegistry;
import lostworlds.world.feature.foliageplacer.GinkgoFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import net.minecraftforge.fml.RegistryObject;

public class FoliagePlacerInit 
{
	public static final RegistryObject<FoliagePlacerType<GinkgoFoliagePlacer>> GINKGO_FOLIAGE_PLACER = ModRegistry.FOLIAGE_PLACER_REGISTRY.register("ginkgo_foliage_placer", () -> new FoliagePlacerType<>(GinkgoFoliagePlacer.CODEC));
	
	//Registry
	public static void initFoliagePlacers() { }
}
