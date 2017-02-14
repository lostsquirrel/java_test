package exercise.concurrency.q24.p_c;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.util.SleepUtils;

public class Producer implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(Producer.class);

	private static AtomicInteger idGenerator;

	private Stock stock;

	private Random r = new Random();

	public Producer(Stock stock) {
		this.stock = stock;
		idGenerator = new AtomicInteger(0);
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (stock) {
					if (!stock.isFull()) {

						int orderNum = idGenerator.incrementAndGet();
						int status = stock.stockIn(orderNum);
						if (status < 0) {
							log.warn("添加{}失败", orderNum);
						} else {
							log.warn("添加{}成功", orderNum);
						}
						SleepUtils.sleepInMilliSeconds(r.nextInt(2000) + 100);
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
