package demo.concurrency.section;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PairChecker implements Runnable {

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(PairChecker.class);
	
	private PairManager pm;
	
	public PairChecker(PairManager pm) {
		this.pm = pm;
	}
	
	@Override
	public void run() {
		while(true) {
			@SuppressWarnings("unused")
			int x = pm.checkCounter.incrementAndGet();
//			log.debug("check {} time start", x);
			pm.getPair().checkState();
		}
	}

}
