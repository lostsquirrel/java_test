package demo.concurrency.executor;

import demo.concurrency.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


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
