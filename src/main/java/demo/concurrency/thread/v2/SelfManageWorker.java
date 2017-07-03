package demo.concurrency.thread.v2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelfManageWorker implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(SelfManageWorker.class);
	
	private int countDown = 5;
	
	private Thread t = new Thread(this);
	
	public SelfManageWorker() {
		t.start();
	}
	
	@Override
	public void run() {
		while(true) {
			log.debug("{}", countDown);
			if (--countDown == 0) {
				return;
			}
		}
	}

}
