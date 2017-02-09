package exercise.concurrency.q18.sleep;

import java.util.concurrent.TimeUnit;

public class SleepInterruptExercise {

	/**
	 * @param args
	 * @throws InterruptedException
	 * 验证sleep的线程能被打断
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new SleepWorker());
		t.start();
		TimeUnit.SECONDS.sleep(1);
		t.interrupt();
		
	}
}
