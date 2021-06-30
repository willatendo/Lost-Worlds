package api.client.screen.fieldguide;

import api.client.screen.fieldguide.screens.FieldGuideScreen;
import net.minecraft.client.Minecraft;

public class FieldGuideScreens 
{
	public static void allosaurusEntry()
	{
		Minecraft.getInstance().setScreen(new AllosaurusGUI());
	}
	
	public static class AllosaurusGUI extends FieldGuideScreen
	{
		public AllosaurusGUI() 
		{
			super("allosaurus");
		}		
	}
}
