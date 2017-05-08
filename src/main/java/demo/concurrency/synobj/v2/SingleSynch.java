package demo.concurrency.synobj.v2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingleSynch {
	
	private static final Logger log = LoggerFactory.getLogger(SingleSynch.class);
	
	public synchronized void f() {
		for (int i = 0; i < 5; i++) {
			log.info("f()");
			Thread.yield();
		}
	}
	
	public void g() {
		synchronized(this) {
			for (int i = 0; i < 5; i++) {
				log.info("g()");
				Thread.yield();
			}
		}
	}
}
