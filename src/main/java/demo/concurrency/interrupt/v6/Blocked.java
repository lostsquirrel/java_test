package demo.concurrency.interrupt.v6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Blocked implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(Blocked.class);
	
	BlockedMutex bm = new BlockedMutex();
	
	@Override
	public void run() {
		log.info("准备执行 BlockedMutex.f()");
		bm.f();
		log.info("BlockedMutex.f()执行结束");
	}

}
