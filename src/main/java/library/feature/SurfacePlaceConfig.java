package library.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class SurfacePlaceConfig implements IFeatureConfig
{
	public static final Codec<SurfacePlaceConfig> CODEC = RecordCodecBuilder.create((p_236606_0_) -> 
	{
		return p_236606_0_.group(BlockState.CODEC.fieldOf("target").forGetter((p_236607_0_) -> 
		{
			return p_236607_0_.target;
		}), BlockState.CODEC.fieldOf("state").forGetter((p_236605_0_) -> 
		{
			return p_236605_0_.state;
		})).apply(p_236606_0_, SurfacePlaceConfig::new);
	});
	
	public final BlockState target;
	public final BlockState state;
	
	public SurfacePlaceConfig(BlockState target, BlockState state) 
	{
		this.target = target;
		this.state = state;
	}
}
