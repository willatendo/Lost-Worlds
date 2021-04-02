package lostworlds.common.blocks.abstracts;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

public class AbstractMediumEggsBlock extends Block
{
	@SuppressWarnings("unused")
	private static final VoxelShape ONE_EGG_VOXEL_SHAPE = Block.box(0, 0, 0, 16, 3, 16);
	@SuppressWarnings("unused")
	private static final VoxelShape TWO_EGG_VOXEL_SHAPE = Stream.of(Block.box(9, 0, 7, 15, 9, 13), Block.box(3, 0, 4, 8, 8, 9)).reduce((v1, v2) -> {
		return VoxelShapes.join(v1, v2, IBooleanFunction.OR);
	}).get();
	public static final IntegerProperty HATCH = BlockStateProperties.HATCH;
	public static final IntegerProperty EGGS = BlockStateProperties.EGGS;

	public AbstractMediumEggsBlock(Properties properties) 
	{
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(HATCH, Integer.valueOf(0)).setValue(EGGS, Integer.valueOf(1)));
	}
	
	
}
