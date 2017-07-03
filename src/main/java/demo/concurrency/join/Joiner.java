package demo.concurrency.join;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Joiner extends Thread {
	
	private static final Logger log = LoggerFactory.getLogger(Joiner.class);
	
	private Sleeper sleeper;
	
	public Joiner(String name, Sleeper sleeper) {
		super(name);
		this.sleeper = sleeper;
		super.start();
	}

	@Override
	public void run() {
		log.debug("Joiner work is done, wait sleeper finished to continue");
		try {
			sleeper.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.debug("all work done");
	}
	
	
}
