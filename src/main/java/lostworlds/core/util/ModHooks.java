package lostworlds.core.util;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.registries.IRegistryDelegate;

public class ModHooks 
{
	private static final Map<IRegistryDelegate<Item>, Integer> VANILLA_BURNS = new HashMap<>();
	
	public static int getBurnTime(ItemStack stack)
	{
		if (stack.isEmpty())
		{
			return 0;
		}
		else
		{
			Item item = stack.getItem();
			int ret = stack.getBurnTime();
			return ForgeEventFactory.getItemBurnTime(stack, ret == -1 ? VANILLA_BURNS.getOrDefault(item.delegate, 0) : ret);
        }
    }
}
