package demo.concurrency.thread.local;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Accessor implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(Accessor.class);
	
	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			ThreadLocalVariableHolder.increment();
			log.debug("{}", this);
			Thread.yield();
		}
	}

	@Override
	public String toString() {
		return "" + ThreadLocalVariableHolder.get();
	}

	
}
