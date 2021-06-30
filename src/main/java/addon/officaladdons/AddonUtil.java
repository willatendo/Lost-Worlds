package addon.officaladdons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import library.util.ModUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

public class AddonUtil extends ModUtil
{
	public static final Logger OG_PACK_LOGGER = LogManager.getLogger(AddonUtil.OG_PACK_ID);
	
	public static final String OG_PACK_ID = ID + ".ogpack";
	
	public static ResourceLocation ogPackRL(String id)
	{
		return new ResourceLocation(ID, id);
	}
	
	public static TranslationTextComponent ogPackTTC(String type, String displayText)
	{
		return new TranslationTextComponent(type + "." + OG_PACK_ID + "." + displayText);
	}
	
	public static ITextComponent ogPackCTC(String type, String text, TextFormatting color) 
	{
        TranslationTextComponent textComponent = tTC(type, text);
        textComponent.withStyle(color);
        return textComponent;
    }
	
	public static ITextComponent ogPackGTC(String type, String text) 
	{
        TranslationTextComponent textComponent = tTC(type, text);
        textComponent.withStyle(TextFormatting.GRAY);
        return textComponent;
	}
}
