package demo.concurrency.thread.yield.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YieldSample implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(YieldSample.class);
	
	private static int initer = 0;
	
	private final int counter = initer++;
	
	public YieldSample() {
		log.info("start YieldSimple #{}", counter);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			log.info("YieldSimple #{}-{}", counter, i);
			Thread.yield();
		}
		log.info("YieldSimple #{} has been finished", counter);
	}
	
}
