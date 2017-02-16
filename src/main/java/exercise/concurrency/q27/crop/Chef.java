package exercise.concurrency.q27.crop;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
	
	Lock lock = new ReentrantLock();
	
	Condition condition = lock.newCondition();
	
	private int count;
	
	public Chef(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				lock.lock();
				try {
					
					while(restaurant.meal != null) {
						condition.await();
					}
				} finally {
					lock.unlock();
				}
				if (++count == 10) {
					log.info("已售罄，关门。。。");
					restaurant.exec.shutdownNow();
				}
				log.info("订单处理完了");
				restaurant.waiter.lock.lock();
				try {
					
					restaurant.meal = new Meal(count);
					log.info("厨师做好菜:{}", restaurant.meal);
					restaurant.waiter.condition.signalAll();
				} finally {
					restaurant.waiter.lock.unlock();
				}
				SleepUtils.sleepInMilliseconds(100);
			}
		} catch (InterruptedException e) {
			log.error("厨师被丢出去了");
		}
	}

}
