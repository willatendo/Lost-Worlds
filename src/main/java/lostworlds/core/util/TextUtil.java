package lostworlds.core.util;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TextUtil
{
	public static ITextComponent coloredTextComponent(String i18n, TextFormatting color) 
	{
        TranslationTextComponent textComponent = new TranslationTextComponent(i18n);
        textComponent.withStyle(color);
        return textComponent;
    }
}
