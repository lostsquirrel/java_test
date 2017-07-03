package demo.concurrency.queue.v2;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.util.SleepUtils;

public class Toaster implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(Toaster.class);
	
	private ToastQueue toastQueue;

	private int count;

	private Random random = new Random(47);

	public Toaster(ToastQueue toastQueue) {
		this.toastQueue = toastQueue;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				SleepUtils.sleepInMilliseconds(100 + random.nextInt(500));
				Toast t = new Toast(count++);
				log.info("{}", t);
				toastQueue.put(t);
			}
		} catch (InterruptedException e) {
			log.warn("断电");
		}
		log.info("正常关机");
	}

}
