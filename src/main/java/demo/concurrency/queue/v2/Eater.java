package demo.concurrency.queue.v2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Eater implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(Eater.class);
	
	private ToastQueue toastQueue;

	private int counter = 0;

	public Eater(ToastQueue toastQueue) {
		this.toastQueue = toastQueue;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Toast t = toastQueue.take();
				if (t.getId() != counter++ || t.getStatus() != Toast.Status.JAMMED) {
					log.error("程序出错");;
					System.exit(0);
				} else {
					log.info("搞定：{}", t);
				}
				
			}
		} catch (InterruptedException e) {
			log.warn("断电");
		}
		log.info("正常关机");
	}

}
