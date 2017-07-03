package demo.concurrency.corp.v3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import demo.util.SleepUtils;

public class WaxOMatic {
	/**
	 * @param args
	 * @throws InterruptedException
	 * Lock 和Condition只有在处理比较困难的多线程问题时使用
	 */
	public static void main(String[] args) throws InterruptedException {
		Car car = new Car();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new WaxOff(car));
		exec.execute(new WaxOn(car));
		
		SleepUtils.sleepInSeconds(100);
		exec.shutdownNow();
	}
}
