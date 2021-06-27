package library.dimension.jurassic;

import java.util.function.Supplier;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.NoiseChunkGenerator;

public class JurassicChunkGenerator extends NoiseChunkGenerator
{
	public static final Codec<JurassicChunkGenerator> CODEC = RecordCodecBuilder.create((instance) -> instance.group(BiomeProvider.CODEC.fieldOf("biome_source").forGetter(ChunkGenerator::getBiomeSource), Codec.LONG.fieldOf("seed").orElseGet(() -> JurassicChunkGenerator.hackSeed).forGetter((obj) -> obj.seed), DimensionSettings.CODEC.fieldOf("settings").forGetter(JurassicChunkGenerator::getDimensionSettings)).apply(instance, instance.stable(JurassicChunkGenerator::new)));
	
	private long seed;
	public static long hackSeed;
	
	public JurassicChunkGenerator(BiomeProvider provider, long seed, Supplier<DimensionSettings> settingsIn) 
	{
		super(provider, seed, settingsIn);
		this.seed = seed;
	}
	
	@Override
	protected Codec<? extends ChunkGenerator> codec() 
	{
		return CODEC;
	}
	
	@Override
	public ChunkGenerator withSeed(long seed) 
	{
		return new JurassicChunkGenerator(biomeSource.withSeed(seed), seed, getDimensionSettings());
	}
	
	private Supplier<DimensionSettings> getDimensionSettings() 
	{
		return settings;
	}
}
