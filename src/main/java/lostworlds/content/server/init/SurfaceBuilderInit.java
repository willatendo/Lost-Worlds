package lostworlds.content.server.init;

import lostworlds.library.surfacebuilders.PermianDriedPlainsSurfaceBuilder;
import lostworlds.library.util.ModRegistry;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;

public class SurfaceBuilderInit 
{
	public static final SurfaceBuilder NAKED_DRIED_PLAINS = new PermianDriedPlainsSurfaceBuilder(SurfaceBuilderConfig.CODEC);
	
	public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> DRIED_PLAINS = ModRegistry.register("dried_plains", NAKED_DRIED_PLAINS);
	
	//Registry
	public static void init() { }
}
