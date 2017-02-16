package exercise.concurrency.q30.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.util.SleepUtils;

public class Sender implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(Sender.class);
	
	private CharQueue out;

	public Sender(CharQueue out) {
		this.out = out;
	}

	@Override
	public void run() {
		try {
			while (true) {
				for (int c = 'A'; c <= 'z'; c++) {
					log.debug(String.format("%c", c));
					out.put(c);
					SleepUtils.sleepRandomMilliseconds(500);
				}
			}
		} catch (InterruptedException e) {
			log.error("打爆");
		}
	}

}
