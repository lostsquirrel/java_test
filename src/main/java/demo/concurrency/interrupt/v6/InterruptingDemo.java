package demo.concurrency.interrupt.v6;

import java.util.concurrent.TimeUnit;

public class InterruptingDemo {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Blocked());
		t.start();
		TimeUnit.SECONDS.sleep(1);
		
		t.interrupt();
	}
}
