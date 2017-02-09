package exercise.concurrency.q18.sleep;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepInterruptExercise {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		
		exec.execute(new SleepWorker());
		TimeUnit.SECONDS.sleep(1);
		exec.shutdownNow();
	}
}
