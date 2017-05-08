package demo.concurrency.dead.v1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import demo.util.SleepUtils;

public class FixedDiningPhilosophers {

	/**
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		int ponder = 1;
		
		int size = 5;
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		Chopstick[] sticks = new Chopstick[size];
		
		for (int i = 0; i < size; i++) {
			sticks[i] = new Chopstick(i);
		}
		
		for (int i = 0; i < size; i++) {
			Chopstick left = null;
			Chopstick right = null;
			if (i < (size - 1)) {
				
				left = sticks[i];
				right = sticks[(i + 1) % size];
			} else {
//				破坏闭环条件，最后一个先拿左边等右边
				left = sticks[0];
				right = sticks[i];
			}
			Philosopher phi = new Philosopher(left, right, i, ponder);
			exec.execute(phi);
		}
		
		SleepUtils.sleepInSeconds(10);
		exec.shutdownNow();
	}
}
