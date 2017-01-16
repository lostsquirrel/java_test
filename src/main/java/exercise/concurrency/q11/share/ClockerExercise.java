package exercise.concurrency.q11.share;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClockerExercise {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		Clocker c = new Clocker();
		for (int i = 0; i < 10; i++) {
			exec.execute(new ClockWorker(c));
		}
		exec.shutdown();
	}
}
