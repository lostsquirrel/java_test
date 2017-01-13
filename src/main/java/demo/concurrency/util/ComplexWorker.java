package demo.concurrency.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComplexWorker {
	
	private static final Logger log = LoggerFactory.getLogger(ComplexWorker.class);
	
	private volatile double d = 1;
	
	public void infiniteWorker() {
		int counter = 0;
		while (true) {
			d = d + (Math.PI + Math.E) / d;
			
			if (counter++ % 1000 == 0) {
				log.debug("{}:{}",counter, d);
			}
		}
	}
}
