package lostworlds.common.tools;

import java.util.Set;

import com.google.common.collect.Sets;

import lostworlds.core.init.BlockInit;
import lostworlds.core.util.ModMaterials;
import lostworlds.core.util.ModToolType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;

public class BrushItem extends ToolItem
{
	private static final Set<Material> EFFECTIVE_ON_MATERIALS = Sets.newHashSet(ModMaterials.MADE_FOR_BRUSH);
	private static final Set<Block> EFFECTIVE_ON_BLOCKS = Sets.newHashSet(BlockInit.STONE_FOSSIL.get());

	public BrushItem(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties properties) 
	{
		super(attackDamageIn, attackSpeedIn, tier, EFFECTIVE_ON_BLOCKS, properties.addToolType(ModToolType.BRUSH, tier.getLevel()));
	}
	
	public float getDestroySpeed(ItemStack stack, BlockState state) 
	{
		Material material = state.getMaterial();
		return EFFECTIVE_ON_MATERIALS.contains(material) ? this.speed : super.getDestroySpeed(stack, state);
	}
}
