package library.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

public class ModUtil
{	
	public static final Logger LOGGER = LogManager.getLogger(ModUtil.ID);
	public static boolean DISABLE_IN_DEV = false;

	public static final String ID = "lostworlds";
	
	public static ResourceLocation rL(String id)
	{
		return new ResourceLocation(ID, id);
	}
	
	public static TranslationTextComponent tTC(String type, String displayText)
	{
		return new TranslationTextComponent(type + "." + ID + "." + displayText);
	}
	
	public static ITextComponent cTC(String type, String text, TextFormatting color) 
	{
        TranslationTextComponent textComponent = tTC(type, text);
        textComponent.withStyle(color);
        return textComponent;
    }
	
	public static ITextComponent gTC(String type, String text) 
	{
        TranslationTextComponent textComponent = tTC(type, text);
        textComponent.withStyle(TextFormatting.GRAY);
        return textComponent;
	}
}	
