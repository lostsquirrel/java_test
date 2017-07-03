package demo.concurrency.inner.v1;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InnerThreadWorkerAnonymous {

	private static final Logger log = LoggerFactory.getLogger(InnerThreadWorkerAnonymous.class);

	private int countDown = 5;

	private Thread worker;

	public InnerThreadWorkerAnonymous(String name) {
		worker = new Thread(name) {
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
		};

		worker.start();
	}
}
