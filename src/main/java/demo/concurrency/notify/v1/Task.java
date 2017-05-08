package demo.concurrency.notify.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Task implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(Task.class);
	
	static Blocker blocker = new Blocker();
	
	@Override
	public void run() {
		log.debug("任务开始");
		blocker.waitingCall();
		log.debug("任务结束");
	}

}
