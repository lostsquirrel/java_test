package demo.concurrency.interrupt.v5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiLock {
	
	private static final Logger log = LoggerFactory.getLogger(MultiLock.class);
	
	public synchronized void f1(int count) {
		if (count-- > 0) {
			log.info("f1 调f2 count: {}", count);
			f2(count);
		}
	}
	public synchronized void f2(int count) {
		if (count-- > 0) {
			log.info("f2 调f1 count: {}", count);
			f1(count);
		}
	}
	
	/**
	 * @param args
	 * 验证一个方法可以多次获得锁
	 */
	public static void main(String[] args) {
		final MultiLock ml = new MultiLock();
		new Thread() {
			public void run() {
				ml.f1(10);
			}
		}.start();
	}
}
