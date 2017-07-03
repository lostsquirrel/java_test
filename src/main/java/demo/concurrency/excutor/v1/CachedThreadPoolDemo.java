package demo.concurrency.excutor.v1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import demo.concurrency.lift.v1.LiftOff;

public class CachedThreadPoolDemo {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new LiftOff());
		}
		
		for (int i = 0; i < 5; i++) {
			exec.execute(new LiftOff());
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < 5; i++) {
			exec.execute(new LiftOff());
		}
		
		exec.shutdown(); // 阻止加入新的任务
	}
}
