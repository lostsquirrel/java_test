package demo.concurrency.atomic.v3;

public class Atomicity implements Runnable {

	private int i = 0;

	public synchronized int getValue() {
		return i;
	}

	private synchronized void evenIncrement() {
		i++;
		i++;
	}

	@Override
	public void run() {
		while (true) {
			this.evenIncrement();
		}
	}

}
