package demo.concurrency.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComplexWorker {
	
	private static final Logger log = LoggerFactory.getLogger(ComplexWorker.class);
	
	private volatile double d = 1;
	
	public void infiniteWorker() {
		while (true) {
			d = d + (Math.PI + Math.E) / d;
			if (d % 3 == 0) {
				log.debug("{}", d);
			}
		}
	}
}
