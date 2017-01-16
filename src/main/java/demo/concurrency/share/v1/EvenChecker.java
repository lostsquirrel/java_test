package demo.concurrency.share.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EvenChecker implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(EvenChecker.class);
	
	private IntGenerator generator;
	
	public EvenChecker(IntGenerator generator) {
		super();
		this.generator = generator;
		
	}

	@Override
	public void run() {
		log.debug("EvenChecker ready...");
		while (!generator.isCanceled()) {
			int next = generator.next();
			if (next % 2 != 0) {
				log.info("{} is not even number!", next);
				generator.cancel();
			}
		}
	}

}
