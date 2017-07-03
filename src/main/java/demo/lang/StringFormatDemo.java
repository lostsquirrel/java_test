package demo.lang;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringFormatDemo {

	@Test
	public void testPaddingZero() throws Exception {
		for (int i = 1; i <= 12; i++) {
			String n = String.format("%02d", i);
			System.out.println(n);
			assertTrue(n.length() == 2);
		}
	}
}
