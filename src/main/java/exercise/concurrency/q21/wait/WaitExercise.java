package exercise.concurrency.q21.wait;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WaitExercise {

	/**
	 * @param args
	 * 验证在没有锁的时候 wait notifyAll 会报异常
	 */
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		
		WaitWorker waiter = new WaitWorker();
		exec.execute(waiter);
		exec.execute(new NotifyAllWorker(waiter));
	}
}
