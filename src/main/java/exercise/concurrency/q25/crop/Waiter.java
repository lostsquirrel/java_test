package exercise.concurrency.q25.crop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lisong 服务生，送菜
 */
public class Waiter implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(Waiter.class);
	
	private Restaurant restaurant;

	public Waiter(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (restaurant.meal == null) {
						wait();
					}
				}
				log.info("服务生取菜: {}", restaurant.meal);
				synchronized(restaurant.chef) {
					restaurant.meal = null;
					restaurant.chef.notifyAll();
				}
			}
		} catch (InterruptedException e) {
			log.error("服务生被丢出去了\n");
		}
	}

}
