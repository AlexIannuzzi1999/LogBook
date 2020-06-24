package logbook;

/**
 * Contains the attributes that will represent 
 * a Flight in a log book.  
 * @author Alexander Iannuzzi
 * @version 1->5/29/19
 * @copyright Alexander Iannuzzi 5/28/19
 */
@SuppressWarnings("rawtypes")
public class Flight implements Comparable {
    private Date date;
    private String model;
    private String id;
    private String dep;
    private String arr;
    private String[] stops;
    private double singleTime;
    private double multiTime;
    private double rotorTime;
    private double dual;
    private double pic;
    private double sin;
    private double cfi;
    private double gi;
    private double day;
    private double night;
    private double xcountry;
    private double actualInstr;
    private double simInstr;
    private int numInstrApp;
    private int numLand;
    private double totalTime;
    private String remarks;
    private AircraftCategory ac;
    private TypeCategory tc;
    private FlightCondition fc;
    
    /**
     * Constructor taking in the required attributes for a flight.  
     * @param date Date of the flight.  
     * @param model Make and model of the plane.  
     * @param id Identification number of the plane.  
     * @param dep Departure airport (ICAO code).  
     * @param arr Arrival airport (ICAO code). 
     * @param numStops The number of stops, 0 if there were none.  
     */
    public Flight(String date, String model, String id, 
        String dep, String arr, int numStops, double singleTime, 
        double multiTime, double rotorTime, double dual, double pic, 
        double sin, double cfi, double gi, double day, double night, double xcountry, 
        double actualInstr, double simInstr, int numInstrApp, int numLand, 
        String remarks, String stops)
    {
        if (dep.length() != 4 || arr.length() != 4)
        {
            throw new IllegalArgumentException();
        }
        Date dateObject = new Date(date);
        this.date = dateObject;
        this.model = model;
        this.id = id;
        this.dep = dep;
        this.arr = arr;
        this.stops = new String[numStops];
        this.singleTime = singleTime;
        this.multiTime = multiTime;
        this.rotorTime = rotorTime;
        this.dual = dual;
        this.pic = pic;
        this.sin = sin;
        this.cfi = cfi;
        this.day = day;
        this.night = night;
        this.xcountry = xcountry;
        this.actualInstr = actualInstr;
        this.simInstr = simInstr;
        this.numInstrApp = numInstrApp;
        this.numLand = numLand;
        this.remarks = remarks;
        this.stops = stops.split(",");
        this.gi = gi;
        setTotalTime();
        if (singleTime != 0.0)
        {
            ac = AircraftCategory.SINGLE;
        }
        else if (multiTime != 0.0)
        {
            ac = AircraftCategory.MULTI;
        }
        else
        {
            ac = AircraftCategory.ROTOR;
        }
        if (dual != 0.0)
        {
            tc = TypeCategory.DUAL;
        }
        else if (pic != 0.0)
        {
            tc = TypeCategory.PIC;
        }
        else if (sin != 0.0)
        {
            tc = TypeCategory.SIC;
        }
        else if (cfi != 0.0)
        {
            tc = TypeCategory.CFI;
        }
        else 
        {
            tc = TypeCategory.GI;
        }
        if (day != 0.0)
        {
            fc = FlightCondition.DAY;
        }
        else if (night != 0.0)
        {
            fc = FlightCondition.NIGHT;
        }
        else if (simInstr != 0.0)
        {
            fc = FlightCondition.SIMULATED_INSTRUMENT;
        }
        else if (actualInstr != 0.0)
        {
            fc = FlightCondition.ACTUAL_INSTRUMENT;
        }
        else 
        {
            fc = FlightCondition.CROSS_COUNTRY;
        }
    }
    
    
    public FlightCondition getFlightCondition()
    {
        return fc;
    }
    
    
    public TypeCategory getTypeCategory()
    {
        return tc;
    }
    
    
    public AircraftCategory getAircraftCategory()
    {
        return ac;
    }
    
    /**
     * Calculates the total time for a flight.  
     */
    public void setTotalTime()
    {
        this.totalTime = singleTime + multiTime 
            + rotorTime;
    }
    
    //Getter methods for all of the fields.  
    
    public Date getDate()
    {
        return date;
    }
    
    public String getDateString()
    {
    	return date.toString();
    }
    
    public String getModel()
    {
        return model;
    }
    
    public String getId()
    {
        return id;
    }
    
    public String getDep()
    {
        return dep;
    }
    
    public String getArr()
    {
        return arr;
    }
    
    public String[] getStops()
    {
        return stops;
    }
    
    public double getSingleTime()
    {
        return singleTime;
    }
    
    public double getMultiTime()
    {
        return multiTime;
    }
    
    public double getRotorTime()
    {
        return rotorTime;
    }
    
    public double getDual()
    {
        return dual;
    }
    
    public double getPic()
    {
        return pic;
    }
    
    public double getSin()
    {
        return sin;
    }
    
    public double getCfi()
    {
        return cfi;
    }
    
    public double getDay()
    {
        return day;
    }
    
    public double getNight()
    {
        return night;
    }
    
    public double getXcountry()
    {
        return xcountry;
    }
    
    public double getActualInstr()
    {
        return actualInstr;
    }
    
    public double getSimIntr()
    {
        return simInstr;
    }
    
    public int getNumInstrApp()
    {
        return numInstrApp;
    }
    
    public int getNumLand()
    {
        return numLand;
    }
    
    public double getTotalTime()
    {
        return totalTime;
    }
    
    public String getRemarks()
    {
        return remarks;
    }
    
    public double getGi()
    {
        return gi;
    }
    
    /**
     * Determines whether or not there were any stops 
     * during the flight.  
     * @return True if there were stops, false otherwise.  
     */
    public boolean hasStopps()
    {
        return stops.length > 1;
    }
    
    /**
     * Creates a string representation of a flight.  
     * @return Object as a String.  
     */
    public String toString()
    {
        String stop = "";
        for (int i = 0; i < stops.length - 1; i++)
        {
            stop += stops[i];
            stop += ",";
        }
        stop += stops[stops.length - 1];
        return date + "::" + model + "::" + id 
            + "::" + dep + "::" + arr + "::" + stops.length + "::" + singleTime + "::" + multiTime + "::" 
            + rotorTime + "::" + dual + "::" + pic + "::" + sin 
            + "::" + cfi + "::" + gi + "::" + day + "::" + night + "::" 
            + xcountry + "::" + actualInstr + "::" + simInstr 
            + "::" + numInstrApp + "::" + numLand 
            + "::" + remarks + "::" + stop;
    }


	@Override
	public int compareTo(Object o) {
		if (o.getClass() != Flight.class)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			Flight other = (Flight)o;
			if (other.getDate().compareTo(getDate()) > 0)
			{
				return 1;
			}
			else if (other.getDate().compareTo(getDate()) < 0)
			{
				return -1;
			}
			else
			{
				return 0;
			}
		}
	}
}
