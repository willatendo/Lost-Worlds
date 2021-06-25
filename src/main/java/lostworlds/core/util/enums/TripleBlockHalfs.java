package lostworlds.core.util.enums;

import net.minecraft.util.IStringSerializable;

public enum TripleBlockHalfs implements IStringSerializable
{
	BOTTOM,
	MIDDLE,
	TOP;
	
	@Override
	public String toString()
	{
		return this.getSerializedName();
	}
	
	@Override
	public String getSerializedName() 
	{
		if(this == BOTTOM)
		{
			return "bottom";
		}
		else if(this == MIDDLE)
		{
			return "middle";
		}
		else 
		{
			return "top";
		}
	}
}
