package logbook;

public class Rating {
	private String rating;
	private String date;
	private String certNumber;
	
	public Rating(String rate)
	{
		rating = rate;
	}
	
	public void setDate(String day)
	{
		date = day;
	}
	
	public void setCert(String cert)
	{
		certNumber = cert;
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
}
