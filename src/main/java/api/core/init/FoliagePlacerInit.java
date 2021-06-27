package api.core.init;

import library.Init;
import library.ModRegistry;
import library.feature.foliageplacer.GinkgoFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import net.minecraftforge.fml.RegistryObject;

@Init
public class FoliagePlacerInit extends ModRegistry
{
	public static final RegistryObject<FoliagePlacerType<GinkgoFoliagePlacer>> GINKGO_FOLIAGE_PLACER = FOLIAGE_PLACER_REGISTRY.register("ginkgo_foliage_placer", () -> new FoliagePlacerType<>(GinkgoFoliagePlacer.CODEC));
}
