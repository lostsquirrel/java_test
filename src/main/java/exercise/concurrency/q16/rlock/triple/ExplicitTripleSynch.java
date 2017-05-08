package exercise.concurrency.q16.rlock.triple;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExplicitTripleSynch {
	
	private static final Logger log = LoggerFactory.getLogger(ExplicitTripleSynch.class);
	
	private Lock lock1 = new ReentrantLock();
	
	private Lock lock2 = new ReentrantLock();
	
	private Lock lock3 = new ReentrantLock();
	
	public void f1() {
		lock1.lock();
		try {
			for (int i = 0; i < 5; i++) {
				log.info("f1()");
				Thread.yield();
			}
		} finally {
			lock1.unlock();
		}
	}
	
	public void f2() {
		lock2.lock();
		try {
			for (int i = 0; i < 5; i++) {
				log.info("f2()");
				Thread.yield();
			}
		} finally {
			lock2.unlock();
		}
	}
	
	public void f3() {
		lock3.lock();
		try {
			for (int i = 0; i < 5; i++) {
				log.info("f3()");
				Thread.yield();
			}
		} finally {
			lock3.unlock();
		}
	}
}
