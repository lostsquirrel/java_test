package exercise.concurrency.q22.wait;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WaitExercise {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		
		WaitWorker bw = new WaitWorker();
		exec.execute(bw);
		
		exec.execute(new NotifyWorker(bw));
	}
}
