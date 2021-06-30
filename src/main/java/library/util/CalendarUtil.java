package library.util;

import java.util.Calendar;

public class CalendarUtil 
{
	public enum Holidays
	{
		NONE,
		CHRISTMAS;
		
		public boolean isChristmas() 
		{
			return this == CHRISTMAS;
		}
		
		private static Holidays get()
		{
			Calendar calendar = Calendar.getInstance();
			if((calendar.get(Calendar.MONTH) == Calendar.DECEMBER && calendar.get(Calendar.DATE) == 25) || calendar.get(Calendar.DATE) == 24)
			{
				return CHRISTMAS;
			}
			
			return NONE;
		}
	}
	
	public static Holidays HOLIDAYS = Holidays.get();
}
