package demo.concurrency.thread.excutor.v1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import demo.concurrency.thread.lift.v1.LiftOff;

public class TestFixedThreadPool {
	public static void main(String[] args) {
		// Constructor argument is number of threads:
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++)
			exec.execute(new LiftOff());
		exec.shutdown();
	}
}
