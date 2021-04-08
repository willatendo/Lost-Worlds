package lostworlds.core.util.interfaces;

public interface IPageable 
{
	void switchToPage(int pageNumber);
	
	int getCurrentPageNumber();
	
	boolean isWithinRange(int pageNumber);
}
