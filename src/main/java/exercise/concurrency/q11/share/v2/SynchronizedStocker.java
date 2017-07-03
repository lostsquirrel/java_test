package exercise.concurrency.q11.share.v2;

import exercise.concurrency.q11.share.Stocker;

public class SynchronizedStocker extends Stocker {
	
	public SynchronizedStocker(int stock) {
		super(stock);
	}
	
	public synchronized void sell(int x) {
		super.sell(x);
	}
}
