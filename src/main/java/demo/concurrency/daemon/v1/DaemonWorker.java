package demo.concurrency.daemon.v1;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaemonWorker implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(DaemonWorker.class);
	
	private int x = 0;
	
	@Override
	public void run() {
		while(true) {
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			log.debug("{}", x++);
		}
	}

}
