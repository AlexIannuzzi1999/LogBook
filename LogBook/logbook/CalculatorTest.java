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
		File log = findFile("logbook.txt", new File("C:\\Users\\aiannuzzi99\\eclipse-workspace\\LogBook"));
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
		LinkedList<Flight> b = calc.sortByDate();
		assertEquals("1/1/2019", a.get(0).getDate());
	}
}
