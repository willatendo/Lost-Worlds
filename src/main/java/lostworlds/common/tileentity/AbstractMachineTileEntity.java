package lostworlds.common.tileentity;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.INameable;
import net.minecraft.util.text.ITextComponent;

public abstract class AbstractMachineTileEntity extends TileEntity implements ITickableTileEntity, IInventory, INamedContainerProvider, INameable
{

	public AbstractMachineTileEntity(TileEntityType<?> p_i48289_1_) {
		super(p_i48289_1_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ITextComponent getDisplayName() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
