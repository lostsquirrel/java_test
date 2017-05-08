package demo.util;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SleepUtils {
	
	private static final Logger log = LoggerFactory.getLogger(SleepUtils.class);
	
	private static final Random random = new Random(21);
	
	public static void sleepInSeconds(int seconds) throws InterruptedException {
		log.debug("睡{}秒", seconds);
		TimeUnit.SECONDS.sleep(seconds);
	}
	
	public static void sleepInMilliseconds(long milliSeconds) throws InterruptedException {
		log.debug("睡{}毫秒", milliSeconds);
		TimeUnit.MILLISECONDS.sleep(milliSeconds);
	}
	
	public static void sleepRandomMilliseconds(long limit) throws InterruptedException {
		sleepInMilliseconds(random.nextLong() % limit);
	}
}
