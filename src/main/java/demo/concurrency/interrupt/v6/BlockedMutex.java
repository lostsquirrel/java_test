package demo.concurrency.interrupt.v6;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlockedMutex {
	
	private static final Logger log = LoggerFactory.getLogger(BlockedMutex.class);
	
	private Lock lock = new ReentrantLock();
	
	public BlockedMutex() {
		lock.lock();
		log.debug("构造器持有锁");
	}
	
	public void f() {
		try {
			lock.lockInterruptibly(); // 如果当前线程被中断或成功得到锁，后继续向下执行
			log.debug("f() 持有锁");
		} catch (InterruptedException e) {
			log.error("f() 被 中断？");
		}
	}
}
