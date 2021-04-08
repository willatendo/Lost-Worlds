package lostworlds.core.init;

import lostworlds.core.util.ModID;
import lostworlds.core.util.registry.ModRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;

public class FluidInit 
{
	//Assets
	public static final ResourceLocation OIL_STILL_RL = new ResourceLocation(ModID.ID, "fluids/oil_still"); 
	public static final ResourceLocation OIL_FLOWING_RL = new ResourceLocation(ModID.ID, "fluids/oil_flowing"); 
	public static final ResourceLocation OIL_OVERLAY_RL = new ResourceLocation(ModID.ID, "fluids/oil_overlay"); 
	
	//Objects
	public static final RegistryObject<FlowingFluid> OIL_FLUID = ModRegistry.FLUID_REGISTRY.register("oil_fluid", () -> new ForgeFlowingFluid.Source(FluidInit.OIL_PROPERTIES));
	public static final RegistryObject<FlowingFluid> OIL_FLOWING = ModRegistry.FLUID_REGISTRY.register("oil_flowing", () -> new ForgeFlowingFluid.Flowing(FluidInit.OIL_PROPERTIES));
	
	//Block
	public static final RegistryObject<FlowingFluidBlock> OIL_BLOCK = ModRegistry.BLOCK_REGISTRY.register("oil_block", () -> new FlowingFluidBlock(() -> FluidInit.OIL_FLUID.get(), AbstractBlock.Properties.of(Material.WATER).strength(100.0F).noDrops().noCollission()));
	
	//Properties
	public static final ForgeFlowingFluid.Properties OIL_PROPERTIES = new ForgeFlowingFluid.Properties(() -> OIL_FLUID.get(), () -> OIL_FLOWING.get(), FluidAttributes.builder(OIL_STILL_RL, OIL_FLOWING_RL).density(0).sound(SoundEvents.WATER_AMBIENT).overlay(OIL_OVERLAY_RL)).block(() -> FluidInit.OIL_BLOCK.get()).bucket(() -> ItemInit.OIL_BUCKET.get());

	public static void initFluids() { }
}
