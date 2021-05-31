package lostworlds.core.init;

import lostworlds.common.tileentity.ModSignTileEntity;
import lostworlds.common.tileentity.TimeMachineTileEntity;
import lostworlds.core.util.ModUtil;
import lostworlds.core.util.registry.ModRegistry;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;

public class TileEntityInit 
{	
	//Machines
	//public static final RegistryObject<TileEntityType<FossilCleanerTileEntity>> FOSSIL_CLEANER_TILE_ENTITY = ModRegistry.TILE_ENTITY_REGISTRY.register("fossil_cleaner_time_entity", () -> TileEntityType.Builder.of(FossilCleanerTileEntity::new, BlockInit.FOSSIL_CLEANER.get()));
	
	//Time Machine
	public static final RegistryObject<TileEntityType<TimeMachineTileEntity>> TIME_MACHINE_TILE_ENTITY = ModRegistry.TILE_ENTITY_REGISTRY.register("time_machine_tile_entity", () -> TileEntityType.Builder.of(TimeMachineTileEntity::new, BlockInit.TIME_MACHINE.get()).build(null));
	
	//Sign
	public static final RegistryObject<TileEntityType<ModSignTileEntity>> SIGN_TILE_ENTITY = ModRegistry.TILE_ENTITY_REGISTRY.register("sign_tile_entity", () -> TileEntityType.Builder.of(ModSignTileEntity::new, BlockInit.CONIFER_SIGN.get(), BlockInit.CONIFER_WALL_SIGN.get(), BlockInit.GINKGO_SIGN.get(), BlockInit.GINKGO_WALL_SIGN.get(), BlockInit.ARAUCARIA_SIGN.get(), BlockInit.ARAUCARIA_WALL_SIGN.get()).build(null));
			
	//Registry
	public static void initTileEntities() { ModUtil.LOGGER.debug("Registering: Mod Tile Entities"); }
}
                   