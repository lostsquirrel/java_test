package demo.concurrency.inner.v1;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InnerRunnableWorkerAnonymous {

	private static final Logger log = LoggerFactory.getLogger(InnerRunnableWorkerAnonymous.class);

	private int countDown = 5;

	private Thread worker;

	public InnerRunnableWorkerAnonymous(String name) {
		worker = new Thread(new Runnable() {
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

		}, name);

		worker.start();
	}
}
