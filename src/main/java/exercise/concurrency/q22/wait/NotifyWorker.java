package exercise.concurrency.q22.wait;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.util.SleepUtils;

/**
 * @author lisong
 * 睡一会，设置flag
 */
public class NotifyWorker implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(NotifyWorker.class);
	
	private WaitWorker bw;
	
	public NotifyWorker(WaitWorker bw) {
		this.bw = bw;
	}
	
	@Override
	public void run() {
		try {
			synchronized(bw) {
				SleepUtils.sleepInSeconds(5);
				log.info("准备notifyAll...");
				bw.notifyAll();
				log.info("notifyAll完成");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
