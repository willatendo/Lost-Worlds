package lostworlds.core.util;

import net.minecraft.block.WoodType;

public class ModWoodType extends WoodType
{
	public ModWoodType(String id) 
	{
		super(id);
	}

	public static final WoodType CONIFER = WoodType.register(new ModWoodType("conifer"));
	public static final WoodType GINKGO = WoodType.register(new ModWoodType("ginkgo"));
}
