package demo.concurrency.share.v4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import demo.concurrency.share.v1.EvenCheckerTester;
import demo.concurrency.share.v1.IntGenerator;

public class MutexEvenGenerator extends IntGenerator {

	private int currentEvenValue = 0;
	private Lock lock = new ReentrantLock();

	public int next() {
		lock.lock();
		try {
			++currentEvenValue;
			Thread.yield(); // Cause failure faster
			++currentEvenValue;
			return currentEvenValue;
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		EvenCheckerTester.test(new MutexEvenGenerator());
	}
}
