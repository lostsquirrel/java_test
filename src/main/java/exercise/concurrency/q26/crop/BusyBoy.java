package exercise.concurrency.q26.crop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.util.SleepUtils;

/**
 * @author lisong
 * 临时工
 */
public class BusyBoy implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(BusyBoy.class);
	
	private Restaurant restaurant;

	public BusyBoy(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				synchronized(this) {
					while(restaurant.meal != null) {
							wait();
					}
				}
				
				synchronized(restaurant.waiter) {
					log.info("打扫完工（客人吃了吗？）", restaurant.meal);
					restaurant.waiter.notifyAll();
				}
				SleepUtils.sleepInMilliSeconds(100);
			}
		} catch (InterruptedException e) {
			log.error("临时工被丢出去了");
		}
	}

}
