package exercise.concurrency.q31.dead;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import demo.concurrency.dead.v1.Chopstick;
import demo.util.SleepUtils;

public class DeadLockExercise {
	public static void main(String[] args) throws InterruptedException {
		int ponder = 1;

		int size = 2;

		ExecutorService exec = Executors.newCachedThreadPool();

		LinkedBlockingQueue<Chopstick> bin = new LinkedBlockingQueue<>();
		for (int i = 0; i < size; i++) {
			bin.put(new Chopstick(i));
		}

		for (int i = 0; i < size; i++) {
			Philosopher phi = new Philosopher(bin, i, ponder);
			exec.execute(phi);
		}

		SleepUtils.sleepInSeconds(30);
		exec.shutdownNow();
	}
}
