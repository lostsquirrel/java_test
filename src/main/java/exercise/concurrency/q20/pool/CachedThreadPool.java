package exercise.concurrency.q20.pool;

import java.util.ArrayList;
import java.util.List;

import demo.concurrency.lift.v1.LiftOff;

public class CachedThreadPool {
	public static void main(String[] args) {
		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Thread t = new Thread(new LiftOff());
			threads.add(t);
			t.start();
		}
		for (Thread thread : threads) {
			thread.interrupt();
		}
	}
}