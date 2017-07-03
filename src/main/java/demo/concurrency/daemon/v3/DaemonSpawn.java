package demo.concurrency.daemon.v3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.concurrency.daemon.v1.DaemonWorker;

public class DaemonSpawn implements Runnable {

	
	private static final Logger log = LoggerFactory.getLogger(DaemonSpawn.class);
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(new DaemonWorker());
			t.start();
			log.debug("thread [{}] isDaemon:{}", t.getName(), t.isDaemon());
		}
	}

}
