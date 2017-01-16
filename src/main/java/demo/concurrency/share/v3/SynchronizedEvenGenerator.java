package demo.concurrency.share.v3;

import demo.concurrency.share.v1.IntGenerator;

public class SynchronizedEvenGenerator extends IntGenerator {

private int currentEvenValue = 0;
	
	@Override
	public synchronized int next() {
		++currentEvenValue; // 这是在zuo
		Thread.yield();
		++currentEvenValue;
		
		return currentEvenValue;
	}
}
