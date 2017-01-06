package demo.concurrency.thread.daemon.v1;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleDeamonsDemo {

	private static final Logger log = LoggerFactory.getLogger(SimpleDeamonsDemo.class);
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Thread x = new Thread(new DaemonWorker());
			x.setDaemon(true);
			x.start();
		}
		log.debug("create daemons finshed");
		try {
			TimeUnit.MILLISECONDS.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.debug("read to terminate");
	}
}
