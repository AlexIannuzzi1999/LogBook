package logbook;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DateTest {
	
	@Test
	void test()
	{
		Date a = new Date("1/1/2019");
		Date b = new Date("01/01/2019");
		Date c = new Date("10/1/2019");
		Date d = new Date("3/25/1999");
		Date e = new Date("12/16/1999");
		assertEquals(1, a.month());
		assertEquals(1, a.day());
		assertEquals(2019, a.year());
		assertEquals(1, b.month());
		assertEquals(1, b.day());
		assertEquals(10, c.month());
		assertEquals(25, d.day());
		assertEquals(12, e.month());
		assertEquals(16, e.day());
		assertEquals(1999, e.year());
		
		assertEquals(-1, Date.compareDates(e, a));
		assertEquals(1, Date.compareDates(a, e));
		Date f = new Date("11/17/1999");
		assertEquals(-1, Date.compareDates(f, e));
		assertEquals(1, Date.compareDates(e, f));
		Date g = new Date("12/15/1999");
		assertEquals(-1, Date.compareDates(g, e));
		assertEquals(1, Date.compareDates(e, g));
		Date h = new Date("12/16/1999");
		assertEquals(0, Date.compareDates(e, h));
		assertEquals(0, Date.compareDates(h, e));
	}
}
