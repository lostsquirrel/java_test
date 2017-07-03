package demo.concurrency.dead.v1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import demo.util.SleepUtils;

public class DeadLockDiningPhilosophers {

	public static void main(String[] args) throws InterruptedException {
		int ponder = 1;
		
		int size = 5;
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		Chopstick[] sticks = new Chopstick[size];
		
		for (int i = 0; i < size; i++) {
			sticks[i] = new Chopstick(i);
		}
		
		for (int i = 0; i < size; i++) {
			Chopstick left = sticks[i];
			Chopstick right = sticks[(i + 1) % size];
			Philosopher phi = new Philosopher(left, right, i, ponder);
			exec.execute(phi);
		}
		
		SleepUtils.sleepInSeconds(30);
		exec.shutdownNow();
	}
}
