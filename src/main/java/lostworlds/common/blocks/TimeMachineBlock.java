package lostworlds.common.blocks;

import java.util.List;

import org.lwjgl.glfw.GLFW;

import lostworlds.core.util.ModID;
import lostworlds.core.util.TextUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class TimeMachineBlock extends Block
{
	public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 10, 16);
	
	public TimeMachineBlock(Properties properties) 
	{
		super(properties);
	}	
	
	public boolean useShapeForLightOcclusion(BlockState state) 
	{
		return true;
	}
	
	@Override
	public void appendHoverText(ItemStack stack, IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)  
	{
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
		if(InputMappings.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), GLFW.GLFW_KEY_LEFT_SHIFT))
		{
			tooltip.add(TextUtil.coloredTextComponent("toolTip." + ModID.ID + ".time_machine.holding_shift", TextFormatting.GOLD));
		}
		else
		{
			tooltip.add(TextUtil.coloredTextComponent("toolTip." + ModID.ID + ".time_machine.not_holding_shift", TextFormatting.GRAY));
		}
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) 
	{
		return SHAPE;
	}
	
	@Override
	public BlockRenderType getRenderShape(BlockState state) 
	{
		return BlockRenderType.MODEL;
	}
		
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerEntity, Hand handIn, BlockRayTraceResult hit) 
	{
		if(worldIn.isClientSide) 
		{
			return ActionResultType.SUCCESS;
		} 
		else 
		{
			playerEntity.openMenu(state.getMenuProvider(worldIn, pos));
			return ActionResultType.CONSUME;
		}
	}
	
	public boolean isPathfindable(BlockState state, IBlockReader reader, BlockPos pos, PathType path) 
	{
		return false;
	}
}
