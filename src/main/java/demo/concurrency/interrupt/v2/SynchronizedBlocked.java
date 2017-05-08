package demo.concurrency.interrupt.v2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SynchronizedBlocked implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(SynchronizedBlocked.class);
	
	public synchronized void f() {
		log.info("拿到锁不放");
		while(true) {
			Thread.yield();
		}
	}
	
	public SynchronizedBlocked() {
		log.debug("一来就进死循环");
		new Thread() {
			@Override
			public void run() {
				f();
			}
		}.start();
	}
	@Override
	public void run() {
		log.debug("再尝试进死循环");
		f();
		log.debug("退出\n");
	}

}
