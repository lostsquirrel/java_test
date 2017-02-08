package demo.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

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
	
	@Test
	public void testSort() throws Exception {
		List<Integer> list = new ArrayList<>();
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			list.add(r.nextInt());
		}
		log.debug(list.toString());
//		list.sort(new Comparator<Integer>(){
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				int c = o1.compareTo(o2);
//				log.debug("{} ? {} : {}", o1, o2, c);
//				return c * -1;
//			}
//		});
		log.debug(list.toString());
	}
}
