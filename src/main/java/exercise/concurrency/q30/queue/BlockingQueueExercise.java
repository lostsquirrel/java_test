package exercise.concurrency.q30.queue;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import demo.util.SleepUtils;

public class BlockingQueueExercise {
	public static void main(String[] args) throws IOException, InterruptedException {
		CharQueue queue = new CharQueue();
		Sender s = new Sender(queue);
		Reciver r = new Reciver(queue);
		
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(s);
		exec.execute(r);
		
		SleepUtils.sleepInSeconds(7);
		exec.shutdownNow();
	}
}
