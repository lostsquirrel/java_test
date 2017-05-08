package exercise.concurrency.q22.wait;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BusyWaitExercise {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		
		BusyWaitWorker bw = new BusyWaitWorker();
		exec.execute(bw);
		
		exec.execute(new FlagSetWorker(bw));
	}
}
