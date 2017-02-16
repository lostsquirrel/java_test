package demo.concurrency.corp.v2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.util.SleepUtils;

/**
 * @author lisong
 * 厨师
 */
public class Chef implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(Chef.class);
	
	private Restaurant restaurant;

	private int count;
	
	public Chef(Restaurant restaurant) {
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
				if (++count == 10) {
					log.info("已售罄，关门。。。");
					restaurant.exec.shutdownNow();
				}
				log.info("订单处理完了");
				
				synchronized(restaurant.waiter) {
					restaurant.meal = new Meal(count);
					log.info("厨师做好菜:{}", restaurant.meal);
					restaurant.waiter.notifyAll();
				}
				SleepUtils.sleepInMilliseconds(100);
			}
		} catch (InterruptedException e) {
			log.error("厨师被丢出去了");
		}
	}

}
