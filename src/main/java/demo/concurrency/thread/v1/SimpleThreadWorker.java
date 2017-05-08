package demo.concurrency.thread.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleThreadWorker extends Thread {

	private int countDown = 5;
	
	private static int threadCount = 0;
	
	private static final Logger log = LoggerFactory.getLogger(SimpleThreadWorker.class);
	
	private int id;
	
	public SimpleThreadWorker()  {
		id = ++threadCount;
		start();
		log.debug("create SimpleThreadWorker #{}", threadCount);
		
	}
	
	@Override
	public void run() {
		while(true) {
			log.debug("worker [{}] coutDown is {} now ", id, --countDown);
			if (countDown == 0) {
				return;
			}
		}
	}
	
	
}
