package demo.concurrency.corp.v1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import demo.util.SleepUtils;

public class WaxOMatic {
	public static void main(String[] args) throws InterruptedException {
		Car car = new Car();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new WaxOff(car));
		exec.execute(new WaxOn(car));
		
		SleepUtils.sleepInSeconds(100);
		exec.shutdownNow();
	}
}
