package exercise.concurrency.q15.sync.obj.single;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingleSynch {
	
	private static final Logger log = LoggerFactory.getLogger(SingleSynch.class);
	
	private Object so1 = new Object();
	
	public void f1() {
		synchronized(so1) {
			for (int i = 0; i < 5; i++) {
				log.info("f1()");
				Thread.yield();
			}
		}
	}
	
	public void f2() {
		synchronized(so1) {
			for (int i = 0; i < 5; i++) {
				log.info("f2()");
				Thread.yield();
			}
		}
	}
	
	public void f3() {
		synchronized(so1) {
			for (int i = 0; i < 5; i++) {
				log.info("f3()");
				Thread.yield();
			}
		}
	}
}
