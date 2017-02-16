package exercise.concurrency.q29.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Peanuter implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(Peanuter.class);
	
	private ToastQueue dryQueue;

	private ToastQueue peanuteredQueue;

	public Peanuter(ToastQueue dryQueue, ToastQueue peanuteredQueue) {
		this.dryQueue = dryQueue;
		this.peanuteredQueue = peanuteredQueue;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Toast t;
				t = dryQueue.take();
				t.peanut();
				log.debug("{}", t);
				peanuteredQueue.put(t);
			}
		} catch (InterruptedException e) {
			log.warn("断电");
		}
		log.info("正常关机");
	}

}
