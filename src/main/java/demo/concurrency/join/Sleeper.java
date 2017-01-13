package demo.concurrency.join;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sleeper extends Thread {
	
	private static final Logger log = LoggerFactory.getLogger(Sleeper.class);
	
	private int duration;
	
	public Sleeper(String name, int duration) {
		super(name);
		this.duration = duration;
		start();
	}

	@Override
	public void run() {
		try {
			sleep(duration);
		} catch (InterruptedException e) {
			log.debug("isInterupted: {}", super.isInterrupted());
		}
		log.debug("awake");
	}
	
	
}
