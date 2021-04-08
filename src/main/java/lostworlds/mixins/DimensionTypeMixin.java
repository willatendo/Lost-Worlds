package lostworlds.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import com.mojang.serialization.Lifecycle;

import lostworlds.world.dimension.PermianDimension;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.MutableRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.SimpleRegistry;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.DimensionSettings;

@Mixin(DimensionType.class)
public class DimensionTypeMixin 
{
	@Inject(method = "registerBuiltin", at = @At("TAIL"), cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
	private static void dimensionRegistry(DynamicRegistries.Impl registryManager, CallbackInfoReturnable<DynamicRegistries.Impl> ci, MutableRegistry<DimensionType> mutableRegistry)
	{
		mutableRegistry.register(PermianDimension.PERMIAN_DIMENSION_KEY, PermianDimension.PERMIAN_DIMENSION_TYPE, Lifecycle.stable());
	}
	
	@Inject(method = "defaultDimensions", at = @At("TAIL"), cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
	private static void defaultDimensions(Registry<DimensionType> dimensionRegistry, Registry<Biome> biomeRegistry, Registry<DimensionSettings> dimensionSettingsRegister, long seed, CallbackInfoReturnable<SimpleRegistry<Dimension>> ci, SimpleRegistry<Dimension> simpleRegistry)
	{
		simpleRegistry.register(PermianDimension.PERMIAN_DIMENSION_SETTINGS, new Dimension(() -> 
		{
			return (DimensionType) dimensionRegistry.getOrThrow(PermianDimension.PERMIAN_DIMENSION_KEY);
		}, PermianDimension.createGenerator(biomeRegistry, dimensionSettingsRegister, seed)), Lifecycle.stable());
	}
}
