package demo.concurrency.section;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lisong
 * 使用同步方法，使Pair线程安全
 */
public class PairManager3 extends PairManager {

	private Lock lock = new ReentrantLock();
	@Override
	public synchronized void increment() {
		Pair temp;
		lock.lock();
		try {
			p.incrementX();
			p.incrementY();
			temp = getPair();
		} finally {
			lock.unlock();
		}
		store(temp);
	}

}
