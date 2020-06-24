package logbook;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
	@Test
	void test() throws FileNotFoundException {
		setUp();
		testSortByDate();
	}
	
	private LinkedList<Flight> a;

	public void setUp() throws FileNotFoundException {
		File log = findFile("logbook.txt", new File("C:\\Users\\Alexander Iannuzzi\\git\\LogBook\\LogBook"));
		FlightReader reader = new FlightReader(log);
		this.a = reader.readFile();
	}

	public File findFile(String fileName, File directory) {
		File[] list = directory.listFiles();
		if (list != null)
			for (File fil : list) {
				if (fil.isDirectory()) {
					findFile(fileName, fil);
					System.out.println(fil.getName());
				} else if (fileName.equalsIgnoreCase(fil.getName())) {
					return fil;
				}
			}
		return null;
	}
	
	public void testSortByDate()
	{
		Calculator calc = new Calculator(this.a);

		System.out.println("\nDisplaying the flights before running the sorting algorithm: ");
		for (int i = 0; i < this.a.getSize(); i++)
		{
			System.out.println(this.a.get(i).getDate());
		}
		
		
		LinkedList<Flight> b = calc.sortByDate();
		assertEquals("12/16/2015", b.get(0).getDate().toString());
		System.out.println("\nDisplaying flights after running the sorting algorithm: ");
		for (int i = 0; i < b.getSize(); i++)
		{
			System.out.println(b.get(i).getDate());
		}
	}
}
