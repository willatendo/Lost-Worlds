package lostworlds.world.structure;

import com.mojang.serialization.Codec;

import net.minecraft.util.Rotation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class DiictodonBurrowStructure extends Structure<NoFeatureConfig>
{
	public DiictodonBurrowStructure(Codec<NoFeatureConfig> config)
	{
		super(config);
	}

	@Override
	public IStartFactory<NoFeatureConfig> getStartFactory() 
	{
		return DiictodonBurrowStructure.Start::new;
	}
	
	@Override
	public Decoration step() 
	{
		return GenerationStage.Decoration.SURFACE_STRUCTURES;
	}
	
	@Override
	protected boolean isFeatureChunk(ChunkGenerator chunkGenerator, BiomeProvider biomeProvider, long worldSeed, SharedSeedRandom random, int chunkX, int chunkZ, Biome biome, ChunkPos chunkPos, NoFeatureConfig config) 
	{
		int terrainHeight = chunkGenerator.getBaseHeight(chunkX << 4, chunkZ << 4, Heightmap.Type.WORLD_SURFACE_WG);
		int maxHeight = chunkGenerator.getSeaLevel();
		
		return terrainHeight <= maxHeight;
	}

	public static class Start extends StructureStart<NoFeatureConfig>
	{
		public Start(Structure<NoFeatureConfig> config, int chunkX, int chunkZ, MutableBoundingBox box, int i, long worldSeed) 
		{
			super(config, chunkX, chunkZ, box, i, worldSeed);
		}

		@Override
		public void generatePieces(DynamicRegistries registryManager, ChunkGenerator chunkGenerator, TemplateManager structureManager, int chunkX, int chunkZ, Biome biome, NoFeatureConfig config) 
		{	
			int i = chunkX * 16;
			int j = chunkZ * 16;
			BlockPos blockpos = new BlockPos(i, 0, j);
			Rotation rotation = Rotation.getRandom(this.random);
			DiictodonBurrowPiece.generate(structureManager, blockpos, rotation, this.pieces, this.random);
			this.calculateBoundingBox();
		}
	}
}
