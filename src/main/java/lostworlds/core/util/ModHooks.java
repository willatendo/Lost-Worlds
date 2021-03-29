package lostworlds.core.util;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.registries.IRegistryDelegate;

public class ModHooks extends ForgeHooks
{
	private static final Map<IRegistryDelegate<Item>, Integer> MOD_FLUIDS = new HashMap<>();
	
	public static int getFluidTime(ItemStack stack)
    {
        if (stack.isEmpty())
        {
            return 0;
        }
        else
        {
            Item item = stack.getItem();
            int ret = stack.getBurnTime();
            return ForgeEventFactory.getItemBurnTime(stack, ret == -1 ? MOD_FLUIDS.getOrDefault(item.delegate, 0) : ret);
        }
    }
}
