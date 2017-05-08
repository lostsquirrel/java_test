package demo.concurrency.notify.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Blocker {
	
	private static final Logger log = LoggerFactory.getLogger(Blocker.class);
	
	private int count = 0;
	
	public synchronized void waitingCall() {
			try {
				while(!Thread.interrupted()) {
					log.debug("{}", ++count);
					wait();
				}
			} catch (InterruptedException e) {
//				e.printStackTrace();
			}
	}
	
	public synchronized void prod() {
		this.notify();
	}
	
	public synchronized void prodAll() {
		this.notifyAll();
	}
}
