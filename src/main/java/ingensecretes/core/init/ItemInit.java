package ingensecretes.core.init;

import ingensecretes.core.util.registry.ModRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class ItemInit 
{
	//Syringe
	public static final RegistryObject<Item> EMPTY_BLOOD_SYRINGE = ModRegistry.ITEMS.register("empty_blood_syringe", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
	
	//Registry
	public static void initItems() { }
}
