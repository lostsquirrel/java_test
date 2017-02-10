package exercise.concurrency.q21.wait;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.util.SleepUtils;

public class NotifyAllWorker implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(NotifyAllWorker.class);
	
	private Runnable r;
	
	public NotifyAllWorker(Runnable r) {
		this.r = r;
	}
	
	@Override
	public void run() {
		try {
			log.info("准备通知");
			SleepUtils.sleepInSeconds(2);
			r.notifyAll();
			log.info("通知完成");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
