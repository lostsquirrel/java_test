package exercise.concurrency.q23.notify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Car {
	
	private static final Logger log = LoggerFactory.getLogger(Car.class);
	
	private boolean waxOn = false;
	
	public synchronized void waxed() {
		this.waxOn = true;
		log.info("完成打蜡");
		this.notify();
	}
	
	public synchronized void buffed() {
		this.waxOn = false;
		log.info("完成抛光");
		this.notify();
	}
	
	public synchronized void waitForWaxing() throws InterruptedException {
		while(!waxOn) {
			log.info("已经抛光了，等待打蜡...");
			wait();
		}
	}
	
	public synchronized void waitForBuffing() throws InterruptedException {
		while(waxOn) {
			log.info("已经打蜡了，等待抛光...");
			wait();
		}
	}
}
