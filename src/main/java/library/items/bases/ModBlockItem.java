package library.items.bases;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.fml.RegistryObject;

public class ModBlockItem extends BlockItem
{
	private final Lazy<? extends Block> blockSupplier;

	public ModBlockItem(final NonNullSupplier<? extends Block> blockSupplier, Properties properties) 
	{
		super(null, properties);
		this.blockSupplier = Lazy.of(blockSupplier::get);
	}
	
	public ModBlockItem(final RegistryObject<? extends Block> blockSupplier, Properties properties) 
	{
		super(null, properties);
		this.blockSupplier = Lazy.of(blockSupplier::get);
	}
	
	@Override
	public Block getBlock() 
	{
		return this.blockSupplier.get();
	}
}
