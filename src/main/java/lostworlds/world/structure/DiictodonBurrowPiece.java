package lostworlds.world.structure;

import java.util.List;
import java.util.Random;

import lostworlds.core.util.ModID;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.TemplateStructurePiece;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class DiictodonBurrowPiece
{
	private static final ResourceLocation STRUCTURE_NBT = ModID.lostWorlds("diictodon_burrow");
	
	public static void generate(TemplateManager templateManager, BlockPos pos, Rotation rotation, List<StructurePiece> pieces, Random random) 
	{
		pieces.add(new DiictodonBurrowPiece.Piece(templateManager, STRUCTURE_NBT, pos, rotation));
	}

	public static class Piece extends TemplateStructurePiece 
	{
		private final ResourceLocation templateLocation;
		private final Rotation rotation;
		
		public Piece(TemplateManager templateManager, ResourceLocation nbt, BlockPos pos, Rotation rotation) 
		{
			super(IStructurePieceType.NETHER_FOSSIL, 0);
			this.templateLocation = nbt;
			this.templatePosition = pos;
			this.rotation = rotation;
			this.loadTemplate(templateManager);
		}
		
		public Piece(TemplateManager templateManager, CompoundNBT nbt) 
		{
			super(IStructurePieceType.NETHER_FOSSIL, nbt);
			this.templateLocation = new ResourceLocation(nbt.getString("Template"));
			this.rotation = Rotation.valueOf(nbt.getString("Rot"));
			this.loadTemplate(templateManager);
		}
		
		private void loadTemplate(TemplateManager templateManager) 
		{
			Template template = templateManager.getOrCreate(this.templateLocation);
			PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation).setMirror(Mirror.NONE).addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_AND_AIR);
			this.setup(template, this.templatePosition, placementsettings);
		}
		
		protected void addAdditionalSaveData(CompoundNBT nbt) 
		{
			super.addAdditionalSaveData(nbt);
			nbt.putString("Template", this.templateLocation.toString());
			nbt.putString("Rot", this.rotation.name());
		}
		
		protected void handleDataMarker(String id, BlockPos pos, IServerWorld world, Random random, MutableBoundingBox box) { }

		public boolean postProcess(ISeedReader seedReader, StructureManager manager, ChunkGenerator chunkGenerator, Random rand, MutableBoundingBox box, ChunkPos pos, BlockPos blockPos) 
		{
			box.expand(this.template.getBoundingBox(this.placeSettings, this.templatePosition));
			return super.postProcess(seedReader, manager, chunkGenerator, rand, box, pos, blockPos);
		}
	}
}
