package exercise.concurrency.q22.wait;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BusyWaitWorker implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(BusyWaitWorker.class);
	
	private boolean flag = false;
	
	@Override
	public void run() {
		long t = System.nanoTime();
		log.info("开始检查flag");
		int x = 0;
		while(true) {
			if (x++ % 100000 == 0) {
				log.debug("标记为: {}", flag);
			}
			if (flag) {
				flag = false;
				log.info("重置flag");
				break;
			}
		}
		log.info("花费{}ns", System.nanoTime() - t);
	}

	public void flag() {
		this.flag = true;
	}
}
