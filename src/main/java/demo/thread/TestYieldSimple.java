package demo.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestYieldSimple {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(new YieldSimple()).start();
		}
	}
}

class YieldSimple implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(YieldSimple.class);
	
	private static int x = 0;
	
	private static final int counter = x++;
	
	YieldSimple() {
		log.info("start YieldSimple #{}", counter);
	}
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			log.info("YieldSimple #{}-{}", counter, i);
		}
		log.info("YieldSimple #{} has been finished", counter);
	}
	
}