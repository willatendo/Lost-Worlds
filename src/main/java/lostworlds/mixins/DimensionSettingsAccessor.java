package lostworlds.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.block.BlockState;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.NoiseSettings;

@Mixin(DimensionSettings.class)
public interface DimensionSettingsAccessor 
{
	@Invoker("<init>")
	static DimensionSettings createChunkGeneratorSettings(DimensionStructuresSettings SpawnsStronghold, NoiseSettings generationShapeConfig, BlockState defaultBlock, BlockState defaultFluid, int bedrockCeilingY, int bedrockFloorY, int seaLevel, boolean mobGenerationDisabled) 
	{
		throw new UnsupportedOperationException();
	}
}
