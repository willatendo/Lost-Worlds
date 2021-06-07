package lostworlds.common.blocks;

import java.util.List;

import javax.annotation.Nullable;

import org.lwjgl.glfw.GLFW;

import lostworlds.common.container.TimeMachineContainer;
import lostworlds.common.tileentity.TimeMachineTileEntity;
import lostworlds.core.util.ModUtil;
import lostworlds.core.util.TextUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.INameable;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class TimeMachineBlock extends ContainerBlock implements ITileEntityProvider	
{
	public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 10, 16);
	
	public TimeMachineBlock(Properties properties) 
	{
		super(properties);
	}	
	
	@Override
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
			tooltip.add(TextUtil.coloredTextComponent("toolTip." + ModUtil.ID + ".time_machine.holding_shift", TextFormatting.GOLD));
		}
		else
		{
			tooltip.add(TextUtil.coloredTextComponent("toolTip." + ModUtil.ID + ".time_machine.not_holding_shift", TextFormatting.GRAY));
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
	public TileEntity newBlockEntity(IBlockReader reader) 
	{
		return new TimeMachineTileEntity();
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
	
	@Override
	@Nullable
	public INamedContainerProvider getMenuProvider(BlockState state, World world, BlockPos pos) 
	{
		TileEntity tileentity = world.getBlockEntity(pos);
		if(tileentity instanceof TimeMachineTileEntity) 
		{
			ITextComponent itextcomponent = ((INameable)tileentity).getDisplayName();
			return new SimpleNamedContainerProvider((p_220147_2_, p_220147_3_, p_220147_4_) -> 
			{
				return new TimeMachineContainer(p_220147_2_, p_220147_3_, IWorldPosCallable.create(world, pos));
			}, itextcomponent);
		} 
		else 
		{
			return null;
		}
	}
	
	@Override
	public void setPlacedBy(World world, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) 
	{
		if(stack.hasCustomHoverName()) 
		{
			TileEntity tileentity = world.getBlockEntity(pos);
			if(tileentity instanceof TimeMachineTileEntity) 
			{
				((TimeMachineTileEntity)tileentity).setCustomName(stack.getHoverName());
			}
		}
	}
	
	@Override
	public boolean isPathfindable(BlockState state, IBlockReader reader, BlockPos pos, PathType path) 
	{
		return false;
	}
}
