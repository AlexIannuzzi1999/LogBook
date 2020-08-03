package logbook;

public class Rating {
	private String rating;
	private String date;
	private String certNumber;
	private boolean isActive;
	
	public Rating(String rate)
	{
		rating = rate;
		date = "No Date Provided";
		certNumber = "No Certification Number Provided";
		isActive = false;
	}
	
	public void setDate(String day)
	{
		date = day;
	}
	
	public void setCert(String cert)
	{
		certNumber = cert;
	}
	
	public void setActive(boolean act)
	{
		isActive = act;
	}
	
	public String getRating()
	{
		return rating;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public String getCert()
	{
		return certNumber;
	}
	
	public boolean isActive()
	{
		return isActive;
	}
	
	public String toString()
	{
		return rating + " - " + isActive;
	}
}
