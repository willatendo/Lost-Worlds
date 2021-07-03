package lostworlds.library.item.forge;

import lostworlds.library.tab.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.common.util.NonNullSupplier;

/*
 * Author: Willatendo
 * Date: July 1, 2021
 */

public class ForgeBlockItem extends BlockItem
{
	private final Lazy<? extends Block> blockSupplier;
	
	public ForgeBlockItem(final NonNullSupplier<? extends Block> blockSupplier) 
	{
		super(null, new Properties().tab(ModItemGroup.BLOCKS));
		this.blockSupplier = Lazy.of(blockSupplier::get);
	}
	
	@Override
	public Block getBlock() 
	{
		return this.blockSupplier.get();
	}
}
