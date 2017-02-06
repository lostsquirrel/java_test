package demo.concurrency.section;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PairManipulator implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(PairManipulator.class);
	
	private PairManager pm;
	
	public PairManipulator(PairManager pm) {
		this.pm = pm;
	}
	
	@Override
	public void run() {
		while(true) {
			pm.increment();
			log.debug("increment done");
		}
	}
	
	public String toString() {
		return String.format("%s; checkCounter = %s", pm.getPair(), pm.checkCounter.get());
	}

}
