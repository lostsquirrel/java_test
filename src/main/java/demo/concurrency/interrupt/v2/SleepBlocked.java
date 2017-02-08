package demo.concurrency.interrupt.v2;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SleepBlocked implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(SleepBlocked.class);
	
	private int time;
	
	public SleepBlocked() {
		this(100);
	}
	
	public SleepBlocked(int time) {
		this.time = time;
	}
	@Override
	public void run() {
		log.debug("start to sleep ...");
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			log.error("sleep interrupted !!!");
		}
		log.debug("sleep completed ...\n");
	}

}
 