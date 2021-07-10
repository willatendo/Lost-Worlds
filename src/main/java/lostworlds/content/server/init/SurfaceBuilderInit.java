package lostworlds.content.server.init;

import lostworlds.library.surfacebuilders.AshyMedowsSurfaceBuilder;
import lostworlds.library.surfacebuilders.PermianDriedPlainsSurfaceBuilder;
import lostworlds.library.util.ModRegistry;
import lostworlds.library.util.ModUtil;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

/*
 * Author: Willatendo
 * Date: July 8, 2021
 */

public class SurfaceBuilderInit 
{
	public static final SurfaceBuilder NAKED_DRIED_PLAINS = new PermianDriedPlainsSurfaceBuilder(SurfaceBuilderConfig.CODEC);
	public static final SurfaceBuilder NAKED_ASHY_MEDOWS = new AshyMedowsSurfaceBuilder(SurfaceBuilderConfig.CODEC);
	
	public static final SurfaceBuilder<?> DRIED_PLAINS = ModRegistry.register("dried_plains", NAKED_DRIED_PLAINS);
	public static final SurfaceBuilder<?> ASHY_MEDOWS = ModRegistry.register("ashy_medows", NAKED_ASHY_MEDOWS);
	
	//Registry
	public static void init() { ModUtil.LOGGER.debug("Registering Mod Surface Builders"); }
}
