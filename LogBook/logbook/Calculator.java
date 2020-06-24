package logbook;

/**
 * Backend of the GUI that will perform calculations and 
 * modify the data structures containing flight log data.   
 * @author Alexander Iannuzzi
 * @version 1->7/16/19
 * @copyright Alexander Iannuzzi 5/28/19
**/
public class Calculator {
    private double hours;
    private LinkedList<String> planes;
    private LinkedList<Flight> flights;
    
    /**
     * Constructor for the calculator class.  
     * @param log LinkedList of all flights parsed 
     * from the file.  
     */
    public Calculator(LinkedList<Flight> log)
    {
        hours = 0;
        planes = new LinkedList<String>();
        flights = log;
        calculate();
    }
    
    /**
     * Adds a flight to the LinkedList of flights.  
     * @param a Flight to be added.  
     */
    public void updateAddFlight(Flight a)
    {
        flights.add(a);
        
        calculate();
    }
    
    /**
     * Searches and removes a particular flight from the LinkedList 
     * of flights.  
     * @param a The flight to be removed.  
     */
    public void updateRemoveFlight(Flight a)
    {
        if (flights.getSize() == 0)
        {
            throw new IllegalStateException("Flight list empty");
        }
        int index = 0;
        while (index < flights.getSize() || !flights.get(index).equals(a))
        {
            index++;
        }
        try
        {
            flights.remove(index);
        }
        catch (Exception e)
        {
            throw new IllegalStateException("Flight not found");
        }
        calculate();
    }
    
    /**
     * Perform various calculations that will be displayed in the 
     * GUI.  
     */
    public void calculate()
    {
        double hours = 0.0;
        LinkedList<String> planes = new LinkedList<String>();
        for (int i = 0; i < flights.getSize(); i++)
        {
            hours += flights.get(i).getTotalTime();
            if (!planes.contains(flights.get(i).getModel()))
            {
                planes.add(flights.get(i).getModel());
            }
        }
        this.hours = hours;
        this.planes = planes;
    }
    
    /**
     * Getter method for the total flight hours.  
     * @return Total flight hours.  
     */
    public double getHours()
    {
        return hours;
    }
    
    /**
     * Getter method for the planes flown.  
     * @return The planes flown.  
     */
    public LinkedList<String> getPlanes()
    {
        return planes;
    }
    
    /**
     * Getter method for the flight log list.  
     * @return LinkedList of flight log.  
     */
    public LinkedList<Flight> getFlights()
    {
        return flights;
    }
    
    /**
     * Sorts flight list by date in descending order.  
     * @return Sorted List by date.  
     */
    public LinkedList<Flight> sortByDate()
    {
    	LinkedList<Flight> current = flights.clone();
    	int length = current.getSize();
    	for (int i = 1; i < length; i++)
    	{
    		int j = i - 1;
    		Date curr = new Date(current.get(i).getDate().toString());
    		Date curr2 = new Date(current.get(j).getDate().toString());
    		
    		while (j >= 0 && curr2.compareTo(curr) == 1)
    		{
    			Flight temp = current.get(j);
    			current.set(temp, j + 1);
    			j--;
    			if (j >= 0)
    			{
    				curr2 = new Date(current.get(j).getDate().toString());
    			}
    		}
    		current.set(current.get(i), j + 1);
    	}
    	return current;
    }
    
    
}