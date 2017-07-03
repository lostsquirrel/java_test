package demo.concurrency.inner.v1;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InnerRunnableWorker {

	private static final Logger log = LoggerFactory.getLogger(InnerRunnableWorker.class);

	private int countDown = 5;

	private Worker worker;

	private class Worker implements Runnable {

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

	public InnerRunnableWorker(String name) {
		worker = new Worker();
		new Thread(worker, name).start();
	}
}
