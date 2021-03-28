package lostworlds.core.init;

import lostworlds.common.tileentity.FossilCleanerTileEntity;
import lostworlds.core.util.registry.ModRegistry;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;

public class TileEntityInit 
{
	public static final RegistryObject<TileEntityType<FossilCleanerTileEntity>> FOSSIL_CLEANER_TILE_ENTITY = ModRegistry.TILE_ENTITY_REGISTRY.register("fossil_cleaner_tile_entity", () -> TileEntityType.Builder.of(FossilCleanerTileEntity::new, BlockInit.FOSSIL_CLEANER.get()).build(null));
	
	//Registry
	public static void initTileEntities() { }
}
