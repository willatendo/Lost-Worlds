package lostworlds.core.util.interfaces;

public interface ISemiAquatic 
{
	boolean shouldEnterWater();

    boolean shouldLeaveWater();
    
    int getWaterSearchRange();
}
