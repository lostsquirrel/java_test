package exercise.concurrency.q03.yield;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import exercise.concurrency.q01.yield.YieldSample;


public class CachedThreadPoolExercise {
	/**
	 * @param args
	 * 分三次添加15任务，第二次，马上添加，每三次预计前面任务执行完后添加
	 * 预期使用10个线程
	 */
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new YieldSample());
		}
		
		for (int i = 0; i < 5; i++) {
			exec.execute(new YieldSample());
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < 5; i++) {
			exec.execute(new YieldSample());
		}
		
		exec.shutdown(); // 阻止加入新的任务
	}
}
