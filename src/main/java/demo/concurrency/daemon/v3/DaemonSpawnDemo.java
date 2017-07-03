package demo.concurrency.daemon.v3;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaemonSpawnDemo {

	
	private static final Logger log = LoggerFactory.getLogger(DaemonSpawnDemo.class);
	/**
	 * @param args
	 * 验证后台线程创建的线程也是后台线程
	 */
	public static void main(String[] args) {
		Thread t = new Thread(new DaemonSpawn());
		t.setDaemon(true);
		t.start();
		log.debug("thread [{}] isDaemon:{}", t.getName(), t.isDaemon());
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.debug("to be continued ...");
	}
}
