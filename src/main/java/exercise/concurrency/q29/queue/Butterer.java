package exercise.concurrency.q29.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Butterer implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(Butterer.class);
	
	private ToastQueue toastQueue;

	private ToastQueue butteredQueue;

	public Butterer(ToastQueue toastQueue, ToastQueue butteredQueue) {
		this.toastQueue = toastQueue;
		this.butteredQueue = butteredQueue;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Toast t;
				t = toastQueue.take();
				t.butter();
				log.debug("{}", t);
				butteredQueue.put(t);
			}
		} catch (InterruptedException e) {
			log.warn("断电");
		}
		log.info("正常关机");
	}

}
