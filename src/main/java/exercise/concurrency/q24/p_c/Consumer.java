package exercise.concurrency.q24.p_c;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.util.SleepUtils;

public class Consumer implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(Consumer.class);

	private Stock stock;

	public Consumer(Stock stock) {
		this.stock = stock;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (stock) {
					if (!stock.isEmpty()) {
						log.info("orderNum: {}", stock.stockOut());
						SleepUtils.sleepInSeconds(1);
						stock.notifyAll();
					} else {
						stock.wait();
					}
				}
			}
		} catch (InterruptedException e) {
			log.error("打断，退出");
		}
	}

}
