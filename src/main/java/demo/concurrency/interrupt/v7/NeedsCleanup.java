package demo.concurrency.interrupt.v7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NeedsCleanup {
	
	private static final Logger log = LoggerFactory.getLogger(NeedsCleanup.class);
	
	private final int id;
	
	public NeedsCleanup(int ident) {
		id = ident;
		log.debug("创建一个NeedsCleanup{}", id);
	}
	
	public void cleanup() {
		log.info("Cleanup {}", id);
	}
}
