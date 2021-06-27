package library.util.base;

import net.minecraft.block.WoodType;

public class ModWoodTypes extends WoodType
{
	public ModWoodTypes(String id) 
	{
		super(id);
	}

	public static final WoodType CONIFER = WoodType.register(new ModWoodTypes("conifer"));
	public static final WoodType GINKGO = WoodType.register(new ModWoodTypes("ginkgo"));
	public static final WoodType ARAUCARIA = WoodType.register(new ModWoodTypes("araucaria"));
}
