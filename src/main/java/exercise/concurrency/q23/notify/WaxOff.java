package exercise.concurrency.q23.notify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.util.SleepUtils;

public class WaxOff implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(WaxOff.class);
	
	private Car car;
	
	public WaxOff(Car car) {
		super();
		this.car = car;
	}


	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				car.waitForWaxing();
				log.info("开始抛光...");
				SleepUtils.sleepInSeconds(3);
				car.buffed();
				log.info("抛光完成");
			}
		} catch (InterruptedException e) {
			log.error("抛光被中断----");
		}
		log.info("抛光结束\n");
	}

}
