package demo.concurrency.executor;

import demo.concurrency.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class SingleThreadPoolDemo {

	/**
	 * @param args
	 * 添加 5个任务
	 * 预期 1 个线程
	 */
	public static void main(String[] args) {
		ExecutorService exec = Executors.newSingleThreadExecutor();
		
		for (int i = 0; i < 5; i++) {
			exec.execute(new LiftOff());
		}
		
		exec.shutdown();
	}
}
