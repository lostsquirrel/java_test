package exercise.concurrency.q29.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Jellyer implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(Jellyer.class);
	
	private ToastQueue jellyedQueue;

	private ToastQueue peanuteredQueue;

	public Jellyer(ToastQueue peanuteredQueue, ToastQueue jellyedQueue) {
		this.jellyedQueue = jellyedQueue;
		this.peanuteredQueue = peanuteredQueue;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Toast t;
				t = peanuteredQueue.take();
				t.jelly();
				log.debug("{}", t);
				jellyedQueue.put(t);
			}
			log.info("正常关机");
		} catch (InterruptedException e) {
			log.warn("断电");
		}
	}

}
