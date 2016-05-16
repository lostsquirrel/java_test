package test.v8.dsiface.d;

import org.junit.Test;

public class TestClient {

	@Test
	public void Simple() throws Exception {
		TimeClient myTimeClient = new SimpleTimeClient();
		System.out.println(myTimeClient.toString());
	}

	@Test
	public void testDefault() throws Exception {
		TimeClient myTimeClient = new SimpleTimeClient();
		System.out.println("Current time: " + myTimeClient.toString());
		System.out.println("Time in California: " + myTimeClient.getZonedDateTime("Blah blah").toString());
	}
}
