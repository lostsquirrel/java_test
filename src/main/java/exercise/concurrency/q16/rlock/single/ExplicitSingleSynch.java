package exercise.concurrency.q16.rlock.single;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExplicitSingleSynch {
	
	private static final Logger log = LoggerFactory.getLogger(ExplicitSingleSynch.class);
	
	private Lock lock = new ReentrantLock();
	
	public void f1() {
		lock.lock();
		try {
			for (int i = 0; i < 5; i++) {
				log.info("f1()");
				Thread.yield();
			}
		} finally {
			lock.unlock();
		}
	}
	
	public void f2() {
		lock.lock();
		try {
			for (int i = 0; i < 5; i++) {
				log.info("f2()");
				Thread.yield();
			}
		} finally {
			lock.unlock();
		}
	}
	
	public void f3() {
		lock.lock();
		try {
			for (int i = 0; i < 5; i++) {
				log.info("f3()");
				Thread.yield();
			}
		} finally {
			lock.unlock();
		}
	}
}
