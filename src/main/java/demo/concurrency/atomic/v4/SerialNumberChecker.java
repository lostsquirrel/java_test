package demo.concurrency.atomic.v4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SerialNumberChecker implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(SerialNumberChecker.class);

	private static int capaciity = 1000;

	private static CircularSet serials = new CircularSet(capaciity);

	@Override
	public void run() {
		while (true) {
			int serail = SerialNumberGenerator.nextSerialNumber();
			if (serials.contains(serail)) {
				log.info("生成了重复序列：{}", serail);
				break;
			}
			serials.add(serail);
		}
	}

}
