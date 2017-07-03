package demo.concurrency.share.v5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AttemptedLocking {

	
	private static final Logger log = LoggerFactory.getLogger(AttemptedLocking.class);
	
	private ReentrantLock lock = new ReentrantLock();
	
	public void untimed() {
		boolean captured = lock.tryLock();
		try {
			log.info("{}", captured);
		} finally {
			if (captured) {
				lock.unlock();
			}
		}
	}
	
	public void timed(int timeout) {
		boolean captured = false;
		try {
			captured = lock.tryLock(timeout, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		try {
			log.info("在{}秒内拿锁: {}", timeout, captured);
		} finally {
			if (captured) {
				lock.unlock();
			}
		}
		
	}
	
	public static void main(String[] args) {
		final AttemptedLocking al = new AttemptedLocking();
		al.untimed();
		al.timed(2);
		
		new Thread() {
			{
				setDaemon(true);
				
			}
			@Override
			public void run() {
				log.debug("lock lock");
				al.lock.lock();
			}
			
		}.start();
//		Thread.yield();
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		al.untimed();
		al.timed(2);
	}
}
