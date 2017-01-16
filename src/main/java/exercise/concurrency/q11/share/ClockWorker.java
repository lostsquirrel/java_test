package exercise.concurrency.q11.share;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClockWorker implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(ClockWorker.class);
	
	private Clocker clocker;
	
	public ClockWorker(Clocker clocker) {
		super();
		this.clocker = clocker;
	}

	@Override
	public void run() {
		while(!clocker.isDayFinished()) {
			clocker.tick();
			log.debug("{}", clocker);
		}
	}

}
