package demo.util;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SleepUtils {
	
	private static final Logger log = LoggerFactory.getLogger(SleepUtils.class);
	
	public static void sleepInSeconds(int seconds) throws InterruptedException {
		log.info("睡{}秒", seconds);
		TimeUnit.SECONDS.sleep(seconds);
	}
}