package api.core.init;

import library.Init;
import library.ModRegistry;
import net.minecraft.entity.item.PaintingType;
import net.minecraftforge.fml.RegistryObject;

@Init
public class PaintingInit extends ModRegistry
{
	public static final RegistryObject<PaintingType> TIME_BOOK = PAINTING_REGISTRY.register("time_book", () -> new PaintingType(48, 32));
}
