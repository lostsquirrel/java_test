package exercise.concurrency.q22.wait;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WaitWorker implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(WaitWorker.class);
	
	private boolean flag = false;
	
	@Override
	public synchronized void run() {
		log.info("开始检查flag");
		while(!Thread.interrupted()) {
			long t = System.nanoTime();
			
			if (flag) {
				flag = false;
			} else {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			log.info("花费{}ns", System.nanoTime() - t);
		}
	}

	public synchronized void flag() {
		this.flag = true;
	}
	
}
