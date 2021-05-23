package lostworlds.core.init;

import lostworlds.common.tileentity.ModSignTileEntity;
import lostworlds.core.util.ModUtil;
import lostworlds.core.util.registry.ModRegistry;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;

public class TileEntityInit 
{	
	//Sign
	public static final RegistryObject<TileEntityType<ModSignTileEntity>> SIGN_TILE_ENTITY = ModRegistry.TILE_ENTITY_REGISTRY.register("sign_tile_entity", () -> TileEntityType.Builder.of(ModSignTileEntity::new, BlockInit.CONIFER_SIGN.get(), BlockInit.CONIFER_WALL_SIGN.get(), BlockInit.GINKGO_SIGN.get(), BlockInit.GINKGO_WALL_SIGN.get(), BlockInit.ARAUCARIA_SIGN.get(), BlockInit.ARAUCARIA_WALL_SIGN.get()).build(null));
			
	//Registry
	public static void initTileEntities() { ModUtil.LOGGER.debug("Registering: Mod Tile Entities"); }
}
