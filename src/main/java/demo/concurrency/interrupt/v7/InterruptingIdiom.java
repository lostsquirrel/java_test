package demo.concurrency.interrupt.v7;

import demo.util.SleepUtils;

public class InterruptingIdiom {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Blocked());
		t.start();
		
		SleepUtils.sleepInSeconds(10);
		t.interrupt();
	}
}
