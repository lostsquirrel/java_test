package demo.concurrency.queue.v2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import demo.util.SleepUtils;

public class ToastOMatic {
	public static void main(String[] args) throws InterruptedException {
		ToastQueue dryQueue = new ToastQueue();
		ToastQueue butteredQueue = new ToastQueue();
		ToastQueue finishedQueue = new ToastQueue();
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		exec.execute(new Toaster(dryQueue));
		exec.execute(new Butterer(dryQueue, butteredQueue));
		exec.execute(new Jammer(butteredQueue, finishedQueue));
		exec.execute(new Eater(finishedQueue));
		
		SleepUtils.sleepInSeconds(5);
		exec.shutdownNow();
	}
}
