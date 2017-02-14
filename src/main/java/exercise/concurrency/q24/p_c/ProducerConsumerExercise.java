package exercise.concurrency.q24.p_c;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import demo.util.SleepUtils;

public class ProducerConsumerExercise {

	public static void main(String[] args) throws InterruptedException {
		Stock stock = new Stock();
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		exec.execute(new Producer(stock));
		exec.execute(new Consumer(stock));
		
		SleepUtils.sleepInSeconds(20);
		exec.shutdownNow();
	}
}
