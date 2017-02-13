package exercise.concurrency.q23.notify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.util.SleepUtils;

public class WaxOn implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(WaxOn.class);
	
	private Car car;
	
	public WaxOn(Car car) {
		super();
		this.car = car;
	}


	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				log.info("开始打蜡...");
				SleepUtils.sleepInSeconds(3);
				car.waxed();
				car.waitForBuffing();
			}
		} catch (InterruptedException e) {
			log.error("打蜡被中断----");
		}
		log.info("打蜡结束\n");
	}

}
