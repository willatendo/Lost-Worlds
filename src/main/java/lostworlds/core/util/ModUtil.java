package lostworlds.core.util;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;

public class ModUtil
{
	public static List<? extends String> modPreference;
	
	public static final Logger LOGGER = LogManager.getLogger(ModUtil.ID);
	public static boolean DISABLE_IN_DEV = false;

	public static final String ID = "lostworlds";
	public static final String VERSION = "Alpha 10";
	public static final String NAME = "Lost Worlds";
	
	public static ResourceLocation rL(String id)
	{
		return new ResourceLocation(ID, id);
	}
	
	public static TranslationTextComponent tTC(String displayText)
	{
		return new TranslationTextComponent(ID + "." + displayText);
	}
	
	public static ItemStack getPreferredStackbyMod(ItemStack[] array)
	{
		return getPreferredElementbyMod(Lists.newArrayList(array), stack -> stack.getItem().getRegistryName());
	}
	
	public static <T> T getPreferredElementbyMod(Collection<T> list, Function<T, ResourceLocation> getName)
	{
		T preferredStack = null;
		int currBest = modPreference.size();
		for(T stack : list)
		{
			if(preferredStack==null)
				preferredStack = stack;
			ResourceLocation rl = getName.apply(stack);
			if(rl!=null)
			{
				String modId = rl.getNamespace();
				int idx = modPreference.indexOf(modId);
				if(idx >= 0&&idx < currBest)
				{
					preferredStack = stack;
					currBest = idx;
				}
			}
		}
		Preconditions.checkNotNull(preferredStack, "No entry found in %s", list);
		return preferredStack;
	}
}	
