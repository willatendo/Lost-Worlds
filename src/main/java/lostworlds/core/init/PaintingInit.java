package lostworlds.core.init;

import lostworlds.core.util.registry.ModRegistry;
import net.minecraft.entity.item.PaintingType;
import net.minecraftforge.fml.RegistryObject;

public class PaintingInit 
{
	public static final RegistryObject<PaintingType> TIME_BOOK = ModRegistry.PAINTING_REGISTRY.register("time_book", () -> new PaintingType(48, 32));
	
	//Registry
	public static void initPaintings() { }
}
