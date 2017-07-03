package exercise.concurrency.q11.share.v2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import exercise.concurrency.q11.share.Seller;

public class SynchronizedClockerExercise {

	/**
	 * 不会超卖
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		SynchronizedStocker c = new SynchronizedStocker(1000);
		for (int i = 0; i < 10; i++) {
			exec.execute(new Seller(c));
		}
		exec.shutdown();
	}
}
