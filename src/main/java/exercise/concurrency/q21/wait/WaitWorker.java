package exercise.concurrency.q21.wait;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WaitWorker implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(WaitWorker.class);
	
	@Override
	public synchronized void run() {
		long t = System.currentTimeMillis();
		try {
			log.info("开始等");
			wait();
			log.info("等完了");
		} catch (InterruptedException e) {
			log.info("等被打断");
		}
		log.info("等结束, 花费{}ms", System.currentTimeMillis() - t);
	}

}
