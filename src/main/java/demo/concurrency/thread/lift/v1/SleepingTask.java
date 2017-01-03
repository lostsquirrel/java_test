package demo.concurrency.thread.lift.v1;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SleepingTask extends LiftOff {

	private static final Logger log = LoggerFactory.getLogger(SleepingTask.class);
	
	public void run() {
		while (countDown-- > 0) {
			log.info(status());
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
