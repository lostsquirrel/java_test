package demo.concurrency.thread.daemon.v4;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaemonFinallyWorker implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(DaemonFinallyWorker.class);

	private int x = 0;

	@Override
	public void run() {
		while (true) {
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				log.debug("什么时候能执行呢？");
			}
			log.debug("{}", x++);
		}
	}
}
