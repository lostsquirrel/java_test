package demo.concurrency.inner.v1;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadMethod {

	private static final Logger log = LoggerFactory.getLogger(ThreadMethod.class);
	
	private int countDown = 5;

	private Thread t;

	private String name;

	public ThreadMethod(String name) {
		this.name = name;
	}

	public void runTask() {
		if (t == null) {
			t = new Thread(name) {
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
		}
		t.start();
	}

}
