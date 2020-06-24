package logbook;

public class Date {
	private int month;
	private int day; 
	private int year;
	
	public Date(String str)
	{
		int slash = str.indexOf("/");
		this.month = Integer.parseInt(str.substring(0, slash));
		str = str.substring(slash + 1);
		slash = str.indexOf("/");
		this.day = Integer.parseInt(str.substring(0, slash));
		this.year = Integer.parseInt(str.substring(slash + 1));
	}
	
	public int month()
	{
		return this.month;
	}
	
	public int day()
	{
		return this.day;
	}
	
	public int year()
	{
		return this.year;
	}
	
	
	public String toString()
	{
		return month + "/" + day + "/" + year;
	}
	
	
	public int compareTo(Date a)
	{
		if (a.year() > year)
		{
			return -1;
		}
		else if (a.year() < year)
		{
			return 1;
		}
		else if (a.month() > month)
		{
			return -1;
		}
		else if (a.month() < month)
		{
			return 1;
		}
		else if (a.day() > day)
		{
			return -1;
		}
		else if (a.day() < day)
		{
			return 1;
		}
		return 0;
	}
}
