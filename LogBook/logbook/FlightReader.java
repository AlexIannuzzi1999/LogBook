package logbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Reads from the text file and sends information to the GUI.
 * 
 * @author Alexander Iannuzzi
 * @version 1->5/28/19
 * @copyright Alexander Iannuzzi 5/28/19
 */
public class FlightReader {
    private Scanner console;
    private PrintWriter writer;
    private File file;

    /**
     * Constructor for the FLightReader class.  
     * @param text Text file to be reading logbook data from.  
     * @throws FileNotFoundException 
     */
    public FlightReader(File text)
    {
        try
        {
            console = new Scanner(new FileReader(text));
            file = text;
            
        }
        catch (Exception e)
        {
            System.out.println("File Not Found");
        }
        
    }


    /**
     * Reads from the logbook file and returns a list of flight
     * objects.
     * 
     * @return List containing every flight logged in the text
     *         file.
     * @throws FileNotFoundException
     */
    public LinkedList<Flight> readFile() throws FileNotFoundException {
        if (console != null) {
            LinkedList<Flight> answer = new LinkedList<Flight>();
            while (console.hasNextLine()) {
                String[] arr = console.nextLine().split("::", 23);
                Flight flight = new Flight(arr[0], arr[1], arr[2], arr[3], arr[4],
                    Integer.parseInt(arr[5]), Double.parseDouble(arr[6]), Double
                        .parseDouble(arr[7]), Double.parseDouble(arr[8]), Double
                            .parseDouble(arr[9]), Double.parseDouble(arr[10]),
                    Double.parseDouble(arr[11]), Double.parseDouble(arr[12]),
                    Double.parseDouble(arr[13]), Double.parseDouble(arr[14]), 
                    Double.parseDouble(arr[15]),Double.parseDouble(arr[16]), 
                    Double.parseDouble(arr[17]), Double.parseDouble(arr[18]), 
                    Integer.parseInt(arr[19]), Integer.parseInt(arr[20]), 
                    arr[21], arr[22]);
                answer.add(flight);
            }
            console.close();
            return answer;
        }
        console.close();
        throw new FileNotFoundException();
    }
    
    /**
     * Re-writes all of the flights in the .txt file to save in 
     * the application data.  
     * @param flights LinkedList of flights contained in the log book 
     * to be written to the file.  
     */
    public void recordFlights(LinkedList<Flight> flights)
    {
        LinkedList<Flight> log = flights.clone();
        try {
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            
            
            while (!log.isEmpty())
            {
                Flight current = log.get(0);
                writer.print(current.toString());
                writer.println();
                log.remove(0);
            }
            writer.close();
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("messed up recording file");
            e.printStackTrace();
        }
    }
}
