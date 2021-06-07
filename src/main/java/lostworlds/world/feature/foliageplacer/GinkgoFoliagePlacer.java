package lostworlds.world.feature.foliageplacer;

import java.util.Random;
import java.util.Set;

import com.mojang.datafixers.Products.P3;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.serialization.codecs.RecordCodecBuilder.Instance;
import com.mojang.serialization.codecs.RecordCodecBuilder.Mu;

import lostworlds.core.init.FoliagePlacerInit;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;

public class GinkgoFoliagePlacer extends FoliagePlacer
{
	public static final Codec<GinkgoFoliagePlacer> CODEC = RecordCodecBuilder.create((p_236742_0_) -> 
	{
		return blobParts(p_236742_0_).apply(p_236742_0_, GinkgoFoliagePlacer::new);
	});
	protected final int height;
	
	protected static <P extends GinkgoFoliagePlacer> P3<Mu<P>, FeatureSpread, FeatureSpread, Integer> blobParts(Instance<P> placer) 
	{
		return foliagePlacerParts(placer).and(Codec.intRange(0, 16).fieldOf("height").forGetter((p_236741_0_) -> 
		{
			return p_236741_0_.height;
		}));
	}
	
	public GinkgoFoliagePlacer(FeatureSpread spread1, FeatureSpread spread2, int height) 
	{
		super(spread1, spread2);
		this.height = height;
	}
	
	@Override
	protected FoliagePlacerType<?> type() 
	{
		return FoliagePlacerInit.GINKGO_FOLIAGE_PLACER.get();
	}
	
	@Override
	protected void createFoliage(IWorldGenerationReader reader, Random rand, BaseTreeFeatureConfig config, int i1, FoliagePlacer.Foliage leaves, int i2, int i3, Set<BlockPos> setPos, int i4, MutableBoundingBox box) 
	{
		for(int i = i4; i >= i4 - i2; --i) 
		{
			int j = Math.max(i3 + leaves.radiusOffset() - 1 - i / 2, 0);
			this.placeLeavesRow(reader, rand, config, leaves.foliagePos(), j, setPos, i, leaves.doubleTrunk(), box);
		}
	}
	
	@Override
	public int foliageHeight(Random rand, int i, BaseTreeFeatureConfig config) 
	{
		return this.height;
	}
	
	@Override
	protected boolean shouldSkipLocation(Random rand, int i1, int i2, int i3, int i4, boolean b) 
	{
		return i1 == i4 && i3 == i4 && (rand.nextInt(2) == 0 || i2 == 0);
		}
}
