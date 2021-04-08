package lostworlds.mixins;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import com.mojang.datafixers.util.Pair;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.NetherBiomeProvider;

@Mixin(NetherBiomeProvider.class)
public interface NetherBiomeProviderAccessor 
{
	public static NetherBiomeProvider createMultiNoiseBiomeSource(long seed, List<Pair<Biome.Builder, Supplier<Biome>>> biomePoints, NetherBiomeProvider.Noise temperatureNoiseParameters, NetherBiomeProvider.Noise humidityNoiseParameters, NetherBiomeProvider.Noise altitudeNoiseParameters, NetherBiomeProvider.Noise weirdnessNoiseParameters, Optional<Pair<Registry<Biome>, NetherBiomeProvider.Preset>> instance) 
	{
		throw new UnsupportedOperationException();
	}

	@Invoker("<init>")
	public static NetherBiomeProvider createMultiNoiseBiomeSource(long seed, List<Pair<Biome.Builder, Supplier<Biome>>> biomePoints, Optional<Pair<Registry<Biome>, NetherBiomeProvider.Preset>> instance) 
	{
		throw new UnsupportedOperationException();
	}
}
