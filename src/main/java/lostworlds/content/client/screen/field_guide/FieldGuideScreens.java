package lostworlds.content.client.screen.field_guide;

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
