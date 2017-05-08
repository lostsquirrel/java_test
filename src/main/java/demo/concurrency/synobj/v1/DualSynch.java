package demo.concurrency.synobj.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DualSynch {
	
	private static final Logger log = LoggerFactory.getLogger(DualSynch.class);
	
	private Object synchObject = new Object();
	
	public synchronized void f() {
		for (int i = 0; i < 5; i++) {
			log.info("f()");
			Thread.yield();
		}
	}
	
	public void g() {
		synchronized(synchObject) {
			for (int i = 0; i < 5; i++) {
				log.info("g()");
				Thread.yield();
			}
		}
	}
}
