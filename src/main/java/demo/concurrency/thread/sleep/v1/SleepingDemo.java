package demo.concurrency.thread.sleep.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.concurrency.thread.lift.v1.SleepingTask;

public class SleepingDemo {

private static final Logger log = LoggerFactory.getLogger(SleepingDemo.class);
	
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(new SleepingTask());
			thread.start();
		}
		log.debug("等待Lift线程执行结束");
	}
}
