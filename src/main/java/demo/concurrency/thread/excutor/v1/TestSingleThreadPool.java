package demo.concurrency.thread.excutor.v1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import demo.concurrency.thread.lift.v1.LiftOff;

public class TestSingleThreadPool {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newSingleThreadExecutor();
		
		for (int i = 0; i < 5; i++) {
			exec.execute(new LiftOff());
		}
		
		exec.shutdown();
	}
}
