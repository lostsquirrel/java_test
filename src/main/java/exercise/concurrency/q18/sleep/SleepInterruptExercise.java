package exercise.concurrency.q18.sleep;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepInterruptExercise {

	/**
	 * @param args
	 * @throws InterruptedException
	 * 验证sleep的线程能被打断
	 */
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		
		exec.execute(new SleepWorker());
		TimeUnit.SECONDS.sleep(1);
		exec.shutdownNow();
	}
}
