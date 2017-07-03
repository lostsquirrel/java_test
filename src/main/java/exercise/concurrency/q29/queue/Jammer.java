package exercise.concurrency.q29.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Jammer implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(Jammer.class);
	
	private ToastQueue finishedQueue;

	private ToastQueue butteredQueue;

	public Jammer(ToastQueue butteredQueue, ToastQueue finishedQueue) {
		this.finishedQueue = finishedQueue;
		this.butteredQueue = butteredQueue;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Toast t;
				t = butteredQueue.take();
				t.jam();
				log.debug("{}", t);
				finishedQueue.put(t);
			}
		} catch (InterruptedException e) {
			log.warn("断电");
		}
		log.info("正常关机");
	}

}
