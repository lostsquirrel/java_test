package demo.concurrency.inner.v1;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InnerThreadWorker {

	private static final Logger log = LoggerFactory.getLogger(InnerThreadWorker.class);

	private int countDown = 5;

	@SuppressWarnings("unused")
	private Worker worker;

	private class Worker extends Thread {
		Worker(String name) {
			super(name);
			start();
		}

		public void run() {
			try {
				while (true) {
					log.debug("{}", countDown);
					if (--countDown == 0) {
						return;
					}
					TimeUnit.MILLISECONDS.sleep(100);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public InnerThreadWorker(String name) {
		worker = new Worker(name);
	}
}
