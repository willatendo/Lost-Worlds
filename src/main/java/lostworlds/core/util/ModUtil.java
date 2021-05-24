package lostworlds.core.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;

public class ModUtil
{
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
}
