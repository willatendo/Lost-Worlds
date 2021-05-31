package lostworlds.common.tileentity;

import javax.annotation.Nullable;

import lostworlds.core.init.TileEntityInit;
import lostworlds.core.util.ModUtil;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.INameable;
import net.minecraft.util.text.ITextComponent;

public class TimeMachineTileEntity extends TileEntity implements INameable, ITickableTileEntity
{
	private ITextComponent name;
	
	public TimeMachineTileEntity() 
	{
		super(TileEntityInit.TIME_MACHINE_TILE_ENTITY.get());
	}

	@Override
	public CompoundNBT save(CompoundNBT nbt) 
	{
		super.save(nbt);
		if(this.hasCustomName()) 
		{
			nbt.putString("CustomName", ITextComponent.Serializer.toJson(this.name));
		}
		
		return nbt;
	}
	
	@Override
	public void load(BlockState state, CompoundNBT nbt) 
	{
		super.load(state, nbt);
		if(nbt.contains("CustomName", 8)) 
		{
			this.name = ITextComponent.Serializer.fromJson(nbt.getString("CustomName"));
		}
	}
	
	@Override
	public void tick() { }
	
	@Override
	public ITextComponent getName() 
	{
		return (ITextComponent)(this.name != null ? this.name : ModUtil.tTC("container.time_machine"));
	}
	
	public void setCustomName(@Nullable ITextComponent name) 
	{
		this.name = name;
	}
	
	@Nullable
	@Override
	public ITextComponent getCustomName() 
	{
		return this.name;
	}

}
