package exercise.concurrency.q11.share;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StockerExercise {

	/**
	 * 预期会超卖，卖出数大于库存数
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		Stocker c = new Stocker(1000);
		for (int i = 0; i < 30; i++) {
			exec.execute(new Seller(c));
		}
		exec.shutdown();
	}
}
