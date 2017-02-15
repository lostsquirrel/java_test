package exercise.concurrency.q27.crop;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lisong 服务生，送菜
 */
public class Waiter implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(Waiter.class);
	
	private Restaurant restaurant;

	Lock lock = new ReentrantLock();
	
	Condition condition = lock.newCondition();
	
	public Waiter(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				lock.lock();
				try {
					while (restaurant.meal == null) {
						condition.await();
					}
				} finally {
					lock.unlock();
				}
				
				log.info("服务生取菜: {}", restaurant.meal);
				restaurant.chef.lock.lock();
				try {
					restaurant.meal = null;
					restaurant.chef.condition.signalAll();
				} finally {
					restaurant.chef.lock.unlock();
				}
				
			}
		} catch (InterruptedException e) {
			log.error("服务生被丢出去了\n");
		}
	}

}
