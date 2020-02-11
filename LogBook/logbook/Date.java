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
	
	public static int compareDates(Date a, Date b)
	{
		if (a.year() < b.year())
		{
			return -1;
		}
		else if (a.year() > b.year())
		{
			return 1;
		}
		else if (a.month() < b.month())
		{
			return -1;
		}
		else if (a.month() > b.month())
		{
			return 1;
		}
		else if (a.day() < b.day())
		{
			return -1;
		}
		else if (a.day() > b.day())
		{
			return 1;
		}
		return 0;
	}
}
