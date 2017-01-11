package exercise.concurrency.q06.sleep;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RandomSleepingTask implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(RandomSleepingTask.class);
	
	private int id = x++;
	
	private static int x = 0;
	
	public RandomSleepingTask() {
		log.debug("created RandomSleepingTask #{}", id);
	}
	
	@Override
	public void run() {
		long timeout = randomTime();
		try {
			TimeUnit.MILLISECONDS.sleep(timeout * 1000);
			log.debug("RandomSleepingTask #{}-{}s", id, timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.debug("RandomSleepingTask #{} finished", id);
	}

	private int randomTime() {
		Random r = new Random();
		return 1 + r.nextInt(9);
	}
}
