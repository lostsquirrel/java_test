package exercise.concurrency.q03.yield;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import exercise.concurrency.q01.yield.YieldSample;

public class SingleThreadPoolExercise {

	/**
	 * @param args
	 * 添加 5个任务
	 * 预期 1 个线程
	 */
	public static void main(String[] args) {
		ExecutorService exec = Executors.newSingleThreadExecutor();
		
		for (int i = 0; i < 5; i++) {
			exec.execute(new YieldSample());
		}
		
		exec.shutdown();
	}
}
