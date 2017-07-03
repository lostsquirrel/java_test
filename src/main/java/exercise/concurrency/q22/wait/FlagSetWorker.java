package exercise.concurrency.q22.wait;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.util.SleepUtils;

/**
 * @author lisong
 * 睡一会，设置flag
 */
public class FlagSetWorker implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(FlagSetWorker.class);
	
	private BusyWaitWorker bw;
	
	public FlagSetWorker(BusyWaitWorker bw) {
		this.bw = bw;
	}
	
	@Override
	public void run() {
		try {
			SleepUtils.sleepInSeconds(5);
			log.info("准备修改flag...");
			bw.flag();
			log.info("flag修改完成");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
