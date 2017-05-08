package demo.concurrency.corp.v3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Car {
	
	private static final Logger log = LoggerFactory.getLogger(Car.class);
	
	private Lock lock = new ReentrantLock();
	
	private Condition condition = lock.newCondition();
	
	private boolean waxOn = false;
	
	public void waxed() {
		lock.lock();
		try {
			this.waxOn = true;
			log.info("完成打蜡");
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}
	
	public void buffed() {
		lock.lock();
		try {
			this.waxOn = false;
			log.info("完成抛光");
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}
	
	public void waitForWaxing() throws InterruptedException {
		lock.lock();
		try {
			while(!waxOn) {
				log.info("已经抛光了，等待打蜡...");
				condition.await();
			}
		} finally {
			lock.unlock();
		}
		
	}
	
	public void waitForBuffing() throws InterruptedException {
		lock.lock();
		try {
			while(waxOn) {
				log.info("已经打蜡了，等待抛光...");
				condition.await();
			}
		} finally {
			lock.unlock();
		}
	}
}
