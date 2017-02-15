package demo.util;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SleepUtils {
	
	private static final Logger log = LoggerFactory.getLogger(SleepUtils.class);
	
	public static void sleepInSeconds(int seconds) throws InterruptedException {
		log.debug("睡{}秒", seconds);
		TimeUnit.SECONDS.sleep(seconds);
	}
	
	public static void sleepInMilliSeconds(long milliSeconds) throws InterruptedException {
		log.debug("睡{}毫秒", milliSeconds);
		TimeUnit.MILLISECONDS.sleep(milliSeconds);
	}
}
