package demo.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.socket.TestSocketServer;

public class ListDemo {

	private static final Logger log = LoggerFactory.getLogger(TestSocketServer.class);
	
	@SuppressWarnings("null")
	@Test(expected=NullPointerException.class)
	public void testNullList() throws Exception {
		List<String> list = null;
		for (String item : list) {
			log.debug(item);
		}
	}
	
	@Test
	public void testEmptyList() throws Exception {
		List<String> list = new ArrayList<>();
		for (String item : list) {
			log.debug(item);
		}
	}
}
